/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai10.common;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import pai10.common.core.IInterceptingFilter;

/**
 *
 * @author adam
 */
public class AuthFilter implements IInterceptingFilter {

    private String authData = "admin:admin";

    public AuthFilter(String authData) {
        authData = authData;
    }

    @Override
    public boolean test(UriInfo context, HttpHeaders headers) {
        try {
            String auth = headers.getHeaderString("Authorization");
            if (auth == null) {
                return false;  // no auth
            }
            if (!auth.toUpperCase().startsWith("BASIC ")) {
                return false;  // we only do BASIC
            }
            // Get encoded user and password, comes after "BASIC "
            String userpassEncoded = auth.substring(6);
            // Decode it, using any base 64 decoder
            sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
            String userpassDecoded = new String(dec.decodeBuffer(userpassEncoded));

            // Check our user list to see if that user and password are "allowed"
            if (authData.equals(userpassDecoded)) {
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            return false;
        }
    }

    public AuthFilter() {
    }

}
