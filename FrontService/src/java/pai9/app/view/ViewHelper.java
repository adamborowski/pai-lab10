/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.app.view;

import rs.client.db.DBClient;
import rs.client.time.TimeClient;

/**
 *
 * @author adam
 */
public class ViewHelper {

    public static String getNav() {
        String urls[] = {"main", "form", "contact", "not-existing"};
        StringBuilder sb = new StringBuilder();
        sb.append("<nav><ul>");
        for (String url : urls) {
            sb.append("<li><a href=\"/FrontService/resources/route/").append(url).append("\">").append(url).append("</a></li>");
        }
        sb.append("</ul></nav>");
        return sb.toString();
    }

    public static String wrapContent(String content) {
        return "<html><body><h2>Lab 9 & 10</h2>" + getNav() + "<hr/>" + content + "</body></html>";
    }

    public String getTime() {
        TimeClient s = new TimeClient();
        return s.process();
    }

    public String getItems() {
        DBClient db = new DBClient();
        return db.process();
    }
}
