/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.client.time;

import java.net.Authenticator;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:TimeFacade [/time]<br>
 * USAGE:
 * <pre>
 *        TimeClient client = new TimeClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author adam
 */
public class TimeClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/TimeService/resources";

    public TimeClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
//        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
//        client.register(feature);
        webTarget = client.target(BASE_URI).path("time");
    }

    public String process() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("current");
        return resource.request().header("Authorization", "Basic YWRtaW46YWRtaW4=").get(String.class);
    }

    public void close() {
        client.close();
    }

}
