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


@WebServlet("/RegForm")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 50    // 50MB
	)

public class RegisterForm extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Fname = req.getParameter("fname");
		String mname = req.getParameter("mname");
		String lname = req.getParameter("lname");
		String Mstatus = req.getParameter("mastatus");
		String DateOfBirth = req.getParameter("dof");
		String Email = req.getParameter("email");
		
		String password = req.getParameter("pass");
		String MobNu = req.getParameter("mobno");
		String Address =req.getParameter("addr");		
		String Zip = req.getParameter("zipcode");
		String Uni = req.getParameter("uniname");
		
		 String resumePath = null;
		
		 Part resumePart = null;

		 try {
		     resumePart = req.getPart("resume");
		     if (resumePart != null) {
		         String fileName = resumePart.getSubmittedFileName();
		         String uploadPath = "D:/Resume/" + fileName; // Set your upload directory
		         File uploadDir = new File("C:/uploads/");
		         if (!uploadDir.exists()) uploadDir.mkdir();
		         resumePart.write(uploadPath);
		         resumePath = uploadPath;
		     }
		 } catch (IllegalStateException | IOException | ServletException e) {
		     e.printStackTrace(); // Log the error for debugging
		 }


			    
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		
		 resp.getWriter().println("<script>alert('Data Inserted Successfully!'); window.location.href = 'successPage.html';</script>");

      
		
		out.println("</script>");
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197", "root", "root");

			PreparedStatement ps = c.prepareStatement("INSERT INTO employees (fname, mname, lname, mastatus, dof, email, pass, mobno, addr, zipcode, uniname, file_path) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"	);

			ps.setString(1, Fname);
			ps.setString(2, mname);			
			ps.setString(3, lname);
			ps.setString(4, Mstatus);
			ps.setString(5, DateOfBirth);
			ps.setString(6, Email);
			ps.setString(7, password);
			ps.setString(8, MobNu);
			ps.setString(9, Address);
			ps.setString(10, Zip);
			ps.setString(11, Uni);
			ps.setString(12, resumePath);		
					
			
			
			ps.executeUpdate();
			
			System.out.println("Data Inserted Successfully.....");
			
			resp.setContentType("text/html");
			RequestDispatcher rd = req.getRequestDispatcher("/id.html");
			rd.include(req, resp);
			c.close();
			
			
		} catch (Exception e) {
			 e.printStackTrace(); 
		}
		
		
		}
	
	
	}

