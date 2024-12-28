<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: url('https://t4.ftcdn.net/jpg/06/73/08/53/360_F_673085356_bqQ6xf1PvCNBJvvwOWxnspJ06hQsCcLf.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .container {
            padding: 80px;
            border: 1px solid #ddd;
            border-radius: 10px;
            width: 500px;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        h1 {
            margin-bottom: 30px;
        }
        .button {
            display: inline-block;
            margin: 10px;
            padding: 15px 30px;
            font-size: 16px;
            font-weight: bold;
            color: white;
            background-color: black;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .button:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Employee Management System</h1>
        <div>
            <a href="Register.html" class="button">Add Employee</a>
            
            <a href="viewdata.jsp" class="button">View Employees</a>
            <a href="Delete.html" class="button">Remove Employee</a>
        </div>
    </div>
</body>
</html>
