/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.app;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriInfo;
import pai9.app.core.IView;
import pai9.app.core.IViewDispatcher;
import pai9.app.view.ContactView;
import pai9.app.view.ErrorView;
import pai9.app.view.FormView;
import pai9.app.view.MainView;

/**
 *
 * @author adam
 */
public class MainDispatcher implements IViewDispatcher{

    @Override
    public IView delegate(UriInfo context, HttpServletRequest request) {
        final String cmd = context.getPathParameters().get("cmd").get(0).toString().toLowerCase();
        
        if(cmd.equals("main")){
            return new MainView();
        }
        if(cmd.equals("form")){
            return new FormView();
        }
        if(cmd.equals("contact")){
            return new ContactView();
        }
        return new ErrorView();
    }
    
}
