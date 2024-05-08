<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login-staff-page</title>
    <link rel="stylesheet" href="./css/login.css">
</head>

<body>

<div class="login-container">
    <h2>Staff-Login</h2>

    <form action="LoginServlet" method = "post">

        <div class="form-group">
            <label for = "username"> Username </label>
            <input type = "text" id = "username" name = "username" placeholder = "Enter your username" required>
        </div>

        <div class="form-group">
            <label for = "password"> Password </label>
            <input type = "password" id = "password"  name = "password" placeholder = "Enter your password" required>
        </div>

        <div class="form-group">
            <br><input type = "submit" name = "submit" value = "Login">
        </div>

    </form>
</div>

</body>
</html>

