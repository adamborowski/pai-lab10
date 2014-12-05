/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai10.common.core;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author adam
 */
public class FilterManager {

    private final List<IInterceptingFilter> filters = new ArrayList<>();

    public void add(IInterceptingFilter filter) {
        filters.add(filter);
    }

    public void add(IInterceptingFilter filter, int position) {
        filters.add(position, filter);
    }

    public void remove(IInterceptingFilter filter) {
        filters.remove(filter);
    }

    public boolean test(UriInfo contet, HttpHeaders headers) {
        for (IInterceptingFilter filter : filters) {
            if (!filter.test(contet, headers)) {
                return false;
            }
        }
        return true;
    }
}
