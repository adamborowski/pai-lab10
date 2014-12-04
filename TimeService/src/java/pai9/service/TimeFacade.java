/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import pai9.app.MainDispatcher;

/**
 * REST Web Service
 *
 * @author adam
 */
@Path("/time")
public class TimeFacade {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FrontController
     */
    public TimeFacade() {
        System.out.println("dzialasdsdsa");
        md = new MainDispatcher();
    }
    private MainDispatcher md;

    @GET
    @Path("/current")
    public String process() {
        return new SimpleDateFormat().format(new Date());
    }
}
