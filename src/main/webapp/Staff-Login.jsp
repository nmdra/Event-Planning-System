<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Staff Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .form-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container form {
            width: 80%;
            max-width: 400px;
            padding: 20px;
            border: 1px solid deepskyblue;
            border-radius: 10px;
            background-color: aliceblue;
        }
    </style>
</head>
<body>

<div class="container form-container text-center">
    <form action="staffLogin" method="POST">

        <h2 class="text-center">Staff Login</h2>

        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" placeholder="Enter your username" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Select Role:</label><br>
            <div class="form-check form-check-inline">
                <input type="radio" id="admin-role" name="position" value="admin" class="form-check-input" required>
                <label for="admin-role" class="form-check-label">Admin </label>

                <input type="radio" id="eventplanner-role" name="position" value="eventplanner" class="form-check-input" required>
                <label for="eventplanner-role" class="form-check-label">Event Planner </label>
            </div>
        </div>

        <div class="form-group text-center">
            <input type="submit" name="submit" value="Login" class="btn btn-primary">
        </div>
    </form>
</div>

</body>
</html>
