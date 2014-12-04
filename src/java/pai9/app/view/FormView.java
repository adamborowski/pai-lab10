/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.app.view;

import javax.ws.rs.core.UriInfo;
import pai9.app.core.IView;

/**
 *
 * @author adam
 */
public class FormView implements IView {

    @Override
    public String renderView(UriInfo context) {
        String body = "<form action=''><input value='login'/><input type='password' value='haslo'/></form>";
        return ViewHelper.wrapContent(body);
    }

}
