<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login-staff-page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
    .form-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 80%;
        width: 50%;
        background: aliceblue;
        border: 1px solid deepskyblue; /* Box around form container */
        padding: 10px; /* Add padding inside the box */
        border-radius: 10px; /* Optional: rounded corners */
        margin-top: 20vh;
    }
</style>

</head>

<body>

<div class="container form-container text-center">
    <form action="LoginServlet" method = "POST" class="col-md-7">

        <h1>User Login</h1>

        <div class="form-row">
            <label for = "email">Email </label>
            <input type = "email" id = "email" name = "email" placeholder = "Enter your username" class="form-control" required>
        </div>


        <div class="form-row">
            <label for = "password">Password </label>
            <input type = "password" id = "password"  name = "password" placeholder = "Enter your password" class="form-control" required>
        </div>

        <div class="form-row">
            <div class="col text-center">
            <br><input type = "submit" name = "submit" value = "Login" class="btn btn-primary center-block" >
        </div>
        </div>

    </form>
</div>

</body>
</html>

