package com.iesemilidarder.projectzero.web;

import com.iesemilidarder.projectzero.DBHelper;
import com.iesemilidarder.projectzero.HashSHA256;
import com.iesemilidarder.projectzero.Restaurants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuari, password;
        usuari=request.getParameter("usuari");
        password=request.getParameter("password");
        String xifrat= HashSHA256.sha256(password);


        try {
            // Per fer la connexió a la base de dades
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            PreparedStatement Ps1=con.prepareStatement("SELECT * FROM USUARIS WHERE USU_CODI = '"+usuari+"'AND USU_PASSWORD = '"+xifrat+"'");
            ResultSet resultSet = Ps1.executeQuery();
            //Per a que el login agafi l'usuari i el password
            if (resultSet.next()){
                HttpSession ses = request.getSession(true);
                ses.setAttribute("usuari",usuari);
                response.sendRedirect("index.jsp");
            } else {
                throw new Exception("Usuari/password incorrectes");
            }

        }

        catch (Exception e) {
            throw new ServletException(e);
        }
    }

}
