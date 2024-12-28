<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile of ${fname} ${lname}</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSefOiXv0BELEpQJPA5TEyXUCo6oObrS-NQSA&s');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            font-family: Arial, sans-serif;
            padding: 10px;
        }
        table {
            border-collapse: collapse;
            width: 50%;
            background-color: white;
            opacity: 0.9;
        }
        th, td {
            text-align: left;
            padding: 7px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        th {
            background-color: #f2f2f2;
            width: 20%; /* Smaller width for the Field column */
        }
        td {
            width: 40%; /* Larger width for the Value column */
        }
        .header-row {
            text-align: center;
            font-weight: bold;
            font-size: 1.2em;
            padding: 10px;
        }
       .link {
            text-align: center;
            margin-top: 10px;
        }
        .link a {
            text-decoration: none;
            font-size: 16px;
            color: #007BFF;
            padding: 10px 20px;
            border: 1px solid #007BFF;
            border-radius: 5px;
            transition: background-color 0.3s, color 0.3s;
        }
        .link a:hover {
            background-color: #007BFF;
            color: white;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th class="header-row" colspan="2">Employee Information</th>
        </tr>
        <tr>
            <td>First Name</td>
            <td>${fname}</td>
        </tr>
        <tr>
            <td>Middle Name</td>
            <td>${mname}</td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td>${lname}</td>
        </tr>
        <tr>
            <td>Marital Status</td>
            <td>${mastatus}</td>
        </tr>
        <tr>
            <td>Date Of Birth</td>
            <td>${dof}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${email}</td>
        </tr>
        <tr>
            <td>Mobile Number</td>
            <td>${mobno}</td>
        </tr>
        <tr>
            <td>Address</td>
            <td>${addr}</td>
        </tr>
        <tr>
            <td>Zip</td>
            <td>${zipcode}</td>
        </tr>
        <tr>
            <td>University</td>
            <td>${uniname}</td>
        </tr>
        <tr>
            <td>Resume</td>
            <td>${resume}</td>
        </tr>
        
       
            <th class="header-row" colspan="2"><div class="link">
        <a href="Main.jsp">Back to Profile</a>
    </div></th>
        </tr>
            
        </tr>
    </table>
     
 
</body>

</html>
