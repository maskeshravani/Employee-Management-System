package com;

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

import java.io.*;

@WebServlet("/profile")

public class Profile extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
             
//        String fname = "fname ";
//        String mname = "mname";
//        String lname = "lname ";
//        String mastatus = "mastatus ";
//        String dof = "dof ";
//        String email = "email ";
//        String mobno = "mobno ";
//        String addr = "addr";
//        String zipcode = "zipcode ";
//        String uniname = "uniname";
//        String resume = " file_path";
        String email = request.getParameter(" email");
        String Depa = request.getParameter(" depa");
        
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197", "root", "root");

			PreparedStatement ps = c.prepareStatement("select * from employees where email = ? AND depa = ?");

			
			ps.setString(1, email);  
			ps.setString(2, Depa);   
			
			ResultSet rs = ps.executeQuery();
			
			
			if (rs.next()) {

        request.setAttribute("fname", rs.getString(1));
        request.setAttribute("mname", rs.getString(2));
        request.setAttribute("lname", rs.getString(3) );
        request.setAttribute("mastatus", rs.getString(4));
        request.setAttribute("dof", rs.getDate(5));
        request.setAttribute("email", rs.getString(6));
        request.setAttribute("mobno", rs.getString(7));
        request.setAttribute("addr", rs.getString(8));
        request.setAttribute("zipcode", rs.getString(9));
        request.setAttribute("uniname", rs.getString(10));
        request.setAttribute("resume",rs.getString(11));
        
        resp.setContentType("text/html; charset=UTF-8");
        RequestDispatcher rd =  request.getRequestDispatcher("/Profile.jsp");
		rd.forward(request, resp);
        
			}	
			else {
				
				PrintWriter out = resp.getWriter();
				resp.setContentType("text/html");
				out.print("<h1 style = 'color: red'>Username and password don't match....</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/profile.html");
				rd.include(request, resp);
			}
    }catch (Exception e) {
    	
    }
}

}