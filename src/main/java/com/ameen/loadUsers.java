package com.ameen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(name = "loadUsers", urlPatterns = {"/loadUsers"})
public class loadUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<tr>\n" +
                "            <th>Make</th>\n" +
                "            <th>Model</th>\n" +
                "            <th>Type</th>\n" +
                "            <th>Year</th>\n" +
                "            <th>License No.</th>\n" +
                "            <th>VIN</th>\n" +
                "            <th>Odometer</th>\n" +
                "            <th>Maintenance</th>\n" +
                "            <th>Edit</th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>");
        List<usersMaintenance> result = userService.getAllUsers();
        for(usersMaintenance model : result) {
            out.print(model.get_make());
            out.print("</td><td>");
            out.print(model.get_model());
            out.print("</td><td>");
            out.print(model.get_type());
            out.print("</td><td>");
            out.print(model.get_year());
            out.print("</td><td>");
            out.print(model.get_license_no());
            out.print("</td><td>");
            out.print(model.get_vin());
            out.print("</td><td>");
            out.print(model.get_odometer());
            out.print("</td><td>");
            out.print(model.get_maintenance());
            out.print("</td><td><button onClick=\"load_update_form(this.id)\" id=\"button" +
                    model.get_id() + "\">update</button></td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n");
            if(model.get_id() < result.size()) {
                out.print("            <td>");
            }
        }
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Ameen, load users GET!</h3>");
        out.flush();
    }
}
