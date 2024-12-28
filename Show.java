package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/example")
public class Show extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("eid"); // Ensure this matches the input name in the form

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197", "root", "root");

            // Query to fetch by eid
            PreparedStatement ps = c.prepareStatement("SELECT * FROM employees WHERE eid = ?");
            ps.setString(1, id); // Use the "eid" parameter

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                req.setAttribute("fname", rs.getString(1));
                req.setAttribute("mname", rs.getString(2));
                req.setAttribute("lname", rs.getString(3));
                req.setAttribute("mastatus", rs.getString(4));
                req.setAttribute("dof", rs.getDate(5));
                req.setAttribute("email", rs.getString(6));
               // req.setAttribute("pass", rs.getString(7));
                req.setAttribute("mobno", rs.getString(8));
                req.setAttribute("addr", rs.getString(9));
                req.setAttribute("zipcode", rs.getString(10));
                req.setAttribute("uniname", rs.getString(11));
                req.setAttribute("resume", rs.getString(12));
             //   req.setAttribute("id", rs.getString(13));
              //  req.setAttribute("depa", rs.getString(14));

                RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
                rd.forward(req, resp);
            } else {
                PrintWriter out = resp.getWriter();
                resp.setContentType("text/html");
                out.print("<h1 style='color: red'>No data found for the provided ID...</h1>");
                RequestDispatcher rd = req.getRequestDispatcher("/profile.");
                rd.include(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log exception details for debugging
        }
    }
}
