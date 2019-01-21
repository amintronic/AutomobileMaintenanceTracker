package com.ameen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "registerUsers", urlPatterns = {"/registerUsers"})
public class registerUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        userService.saveNewUser(new usersMaintenance(0,
                request.getParameter("make"),
                request.getParameter("model"),
                request.getParameter("type"),
                request.getParameter("year"),
                request.getParameter("license"),
                request.getParameter("vin"),
                Integer.parseInt(request.getParameter("odometer")),
                request.getParameter("maintenance")));

        userService.updateSingleUser(new usersMaintenance(0,
                request.getParameter("make"),
                request.getParameter("model"),
                request.getParameter("type"),
                request.getParameter("year"),
                request.getParameter("license"),
                request.getParameter("vin"),
                Integer.parseInt(request.getParameter("odometer")),
                request.getParameter("maintenance")));

        response.sendRedirect("/");
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Ameen, register users GET!</h3>");
        out.flush();
    }
}
