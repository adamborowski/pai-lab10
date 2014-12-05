/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.service;

import javax.jws.WebService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import pai10.common.AuthFilter;
import pai10.common.core.FilterManager;
import pai9.app.MainDispatcher;
import pai9.app.core.IView;
import pai9.app.view.MainView;

/**
 * REST Web Service
 *
 * @author adam
 */
@Path("/db")
public class DBFacade {

    @Context
    private UriInfo context;
    @Context
    private HttpHeaders headers;

    private final FilterManager fm;

    /**
     * Creates a new instance of FrontController
     */
    public DBFacade() {
        fm = new FilterManager();
        fm.add(new AuthFilter("admin:admin"));
    }
    private MainDispatcher md;

    @GET
    @Path("/items")
    @Produces("text/json")
    public String process(@PathParam("cmd") String cmd) {
        if (fm.test(context, headers)) {
            return "{\"items\": [{\"id\":1, \"name\":\"Janek\"}, {\"id\":3, \"name\": \"Wacek\" }] }";
        } else {
            return "<b>Cannot access</b>";
        }
    }
}
