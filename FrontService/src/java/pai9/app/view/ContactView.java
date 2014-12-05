/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.app.view;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriInfo;
import pai9.app.core.IView;
import pai9.app.view.subview.DBView;
import pai9.app.view.subview.TimeView;

/**
 *
 * @author adam
 */
public class ContactView implements IView {

    @Override
    public String renderView(UriInfo context, HttpServletRequest request) {
        String body = "Some contact information<hr/>";
        body += new TimeView().renderView(context, request);
        body += new DBView().renderView(context, request);
        return ViewHelper.wrapContent(body, request);
    }

}
