/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.app.view.subview;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriInfo;
import pai9.app.core.IView;
import pai9.app.view.ViewHelper;

/**
 *
 * @author adam
 */
public class TimeView implements IView {

    @Override
    public String renderView(UriInfo context, HttpServletRequest request) {
        return "<div style='padding:10px; background: #ac3d4f; display: inline-block'>Czas z TimeServer: "+new ViewHelper().getTime()+"</div>";
    }
    
}
