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
import javax.ws.rs.core.Request;
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

    /**
     * Creates a new instance of FrontController
     */
    public DBFacade() {
    }
    private MainDispatcher md;

    @GET
    @Path("/items")
    @Produces("text/json")
    public String process(@PathParam("cmd") String cmd) {
        return "{\"items\": [{\"id\":1, \"name\":\"Janek\"}, {\"id\":3, \"name\": \"Wacek\" }] }";
    }
}
