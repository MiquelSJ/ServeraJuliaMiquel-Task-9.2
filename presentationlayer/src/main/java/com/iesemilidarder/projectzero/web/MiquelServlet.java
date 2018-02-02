package com.iesemilidarder.projectzero.web;

import com.iesemilidarder.projectzero.DBHelper;
import com.iesemilidarder.projectzero.Restaurants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MiquelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Restaurants restaurant = DBHelper.loadRestaurant(id);

        request.setAttribute("restaurant", restaurant);
        request.getRequestDispatcher("servlet.jsp").forward(request, response);
    }
}
