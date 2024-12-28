<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employees Data</title>
    <style>
    
   body {

	margin: 0;
	padding: 0;
	background-image:
		url('data:image/jpeg;base64,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');
	background-size: 2000px;
	background-repeat: no-repeat;
	background-attachment: fixed;
}
      body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f8f9fa; /* Optional background color */
        }
        .container {
            text-align: center; /* Centers the content horizontally */
            margin-top: 20px;
        }
        button {
            width: 220px; /* Small button width */
            padding: 10px;
            border: none;
            border-radius: 4px;
            background: #007BFF;
            color: #fff;
            font-size: 20px;
            cursor: pointer;
            text-align: center;
        }
        button:hover {
            background: #0056b3; /* Hover effect */
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1 style="text-align: center;">Employee Details</h1>
     <form action="idform" method="post">
    <table>
        <thead>
            <tr>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                <th>Marital Status</th>
                <th>Date of Birth</th>
                <th>Email</th>
                <th>Password</th>
                <th>Mobile No</th>
                <th>Address</th>
                <th>Zip Code</th>
                <th>University Name</th>
                <th>Resume</th>
                <th>Employee ID</th>                
                <th>Department</th>
            </tr>
        </thead>
        <tbody>
            <% 
                java.sql.Connection conn = null;
                java.sql.PreparedStatement ps = null;
                java.sql.ResultSet rs = null;
                
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197", "root", "root");
                    ps = conn.prepareStatement("SELECT * FROM employees");
                    rs = ps.executeQuery();

                    while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getString(1) %></td>
                <td><%= rs.getString(2) %></td>
                <td><%= rs.getString(3) %></td>
                <td><%= rs.getString(4) %></td>
                <td><%= rs.getDate(5) %></td>
                <td><%= rs.getString(6) %></td>
                <td><%= rs.getString(7) %></td>
                <td><%= rs.getBigDecimal(8) %></td>
                <td><%= rs.getString(9) %></td>
                <td><%= rs.getInt(10) %></td>
                <td><%= rs.getString(11) %></td>
                <td><%= rs.getString(12) %></td>
                <td><%= rs.getInt(13) %></td>
                <td><%= rs.getString(14) %></td>
            </tr>
            <% 
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                }
            %>
            
        </tbody>
    </table>
     <br><br>
    <div class="container">
    <a href="Update.html" style="text-decoration: none;">
        <button type="button">Update</button>
    </a>
</div>

</body>
</html>
