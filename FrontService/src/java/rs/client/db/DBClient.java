/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.client.db;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:DBFacade [/db]<br>
 * USAGE:
 * <pre>
 *        DBClient client = new DBClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author adam
 */
public class DBClient {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/DBService/resources";

    public DBClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("db");
    }

    public String process() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("items");
        return resource.request().get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
