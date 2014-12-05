/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.app.view.subview;

import javax.ws.rs.core.UriInfo;
import pai9.app.core.IView;
import pai9.app.view.ViewHelper;

/**
 *
 * @author adam
 */
public class DBView implements IView {

    @Override
    public String renderView(UriInfo context) {
        return "<div style='padding:10px; background: #fcd3a2; display: inline-block; margin-left: 10px'>Json z DBServer: "+new ViewHelper().getItems()+"</div>";
    }
    
}
