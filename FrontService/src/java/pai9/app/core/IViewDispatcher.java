/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.app.core;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author adam
 */
public interface IViewDispatcher {

    IView delegate(UriInfo context, HttpServletRequest request);
}
