package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String mname = req.getParameter("mname");
        String lname = req.getParameter("lname");
        String ms = req.getParameter("mastatus");
        String dob = req.getParameter("dof");
        String email = req.getParameter("email");
        String no = req.getParameter("mobno");
        String add = req.getParameter("addr");
        String zp = req.getParameter("zipcode");
        String id = req.getParameter("eid");

        PrintWriter out = resp.getWriter();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197", "root", "root");
			
			PreparedStatement ps = c.prepareStatement("UPDATE employees SET fname = ?, mname = ?, lname = ?, mastatus = ?, dof = ?, email = ?, mobno = ?, addr = ?, zipcode = ? WHERE eid = ?");
	
		
			
            ps.setString(1, fname);
            ps.setString(2, mname);
            ps.setString(3, lname);
            ps.setString(4, ms);
            ps.setString(5, dob);
            ps.setString(6, email);
            ps.setString(7, no);
            ps.setString(8, add);
            ps.setString(9, zp);
            ps.setString(10, id);
            

//			resp.setContentType("text/html");
//			RequestDispatcher rd = req.getRequestDispatcher("/login.html");
//			rd.include(req, resp);

           ps.executeUpdate(); // Execute the update query
           System.out.println("Data Inserted Successfully.....");
           
           ps.executeUpdate();
			
			out.print("Data Updated Successfully......");

      
        } catch (Exception e) {      	
   			  		
        }
    }
}
