package com;

import java.io.File;
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
import jakarta.servlet.http.Part;
import jakarta.servlet.annotation.MultipartConfig;


@WebServlet("/idform")
public class id extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Depart = req.getParameter("depa");
        String Email = req.getParameter("mail");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197", "root", "root");

          
            PreparedStatement ps = c.prepareStatement("UPDATE employees SET depa = ? WHERE email = ?");
            ps.setString(1, Depart);
            ps.setString(2, Email);
            ps.executeUpdate(); // Execute the update query
            System.out.println("Data Inserted Successfully.....");
            
            ps.executeUpdate();
 			
 			out.print("Data Updated Successfully......");
 			
 			 RequestDispatcher rd = req.getRequestDispatcher("show.html");
             rd.forward(req, resp);

	    }catch (Exception e) {
	    	
	    }
			
		}

}
