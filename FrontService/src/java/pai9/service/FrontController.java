/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.service;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Request;
import pai9.app.MainDispatcher;
import pai9.app.core.IView;
import pai9.app.view.FormView;
import pai9.app.view.MainView;
import pai9.app.view.ViewHelper;

/**
 * REST Web Service
 *
 * @author adam
 */
@Path("/")
@WebService
public class FrontController {

    @Context
    private UriInfo context;
    @Context
    HttpServletRequest request;

    /**
     * Creates a new instance of FrontController
     */
    public FrontController() {
        System.out.println("dzialasdsdsa");
        md = new MainDispatcher();
    }
    private MainDispatcher md;

    @GET
    @Path("/route/{cmd}")
    @Consumes("text/html")
    public String process(@PathParam("cmd") String cmd) {
        ViewHelper helper = new ViewHelper();
        IView selectedView;
        if (helper.isUserLogged(request)) {
            selectedView = md.delegate(context, request);
        } else {
            selectedView = new FormView();
        }
        String content = selectedView.renderView(context, request);
        return content;
    }

    @POST
    @Path("/login")
    public String login(@FormParam("login") String login, @FormParam("password") String password) {
        if (login.equals(password)) {
            request.getSession().setAttribute("user", login);
            return new MainView().renderView(context, request);
        } else {
            request.getSession().removeAttribute("user");
        }
        return new FormView().renderView(context, request);
    }
}
