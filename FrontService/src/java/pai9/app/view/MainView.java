/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.app.view;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriInfo;
import pai9.app.core.IView;

/**
 *
 * @author adam
 */
public class MainView implements IView {

    @Override
    public String renderView(UriInfo context, HttpServletRequest request) {
        String body = "This Is Main Page";
        return ViewHelper.wrapContent(body, request);
    }

}
