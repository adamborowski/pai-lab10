/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai9.app.view;

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
            sb.append("<li><a href=\"/pai-lab9/resources/route/").append(url).append("\">").append(url).append("</a></li>");
        }
        sb.append("</ul></nav>");
        return sb.toString();
    }

    public static String wrapContent(String content) {
        return "<html><body><h2>Lab 9 & 10</h2>" + getNav() + "<hr/>" + content + "</body></html>";
    }
}
