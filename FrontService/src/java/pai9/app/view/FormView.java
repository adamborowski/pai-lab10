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
public class FormView implements IView {

    @Override
    public String renderView(UriInfo context, HttpServletRequest request) {
        String body = "<h1>Please login: </h1><form method='post' action='/FrontService/resources/login'><input value='login' name='login'/><input name='password' type='password' value='haslo'/><input type='submit' value='ok'/></form>";
        return ViewHelper.wrapContent(body, request);
    }

}
