<%--
  Created by IntelliJ IDEA.
  Servlets: nimendra
  Date: 01/05/2024
  Time: 20:37
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <style>
        .form-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 70%;
            width: 60%;
            background: aliceblue;
            border: 1px solid deepskyblue; /* Box around form container */
            padding: 10px; /* Add padding inside the box */
            border-radius: 10px; /* Optional: rounded corners */
            margin-top: 20vh;
        }
    </style>
    <script type="text/javascript">
        function ValidatePassword(password, confirmPassword) {
            let passwordValue = password.value;
            let confirmPasswordValue = confirmPassword.value;

            if (passwordValue.length < 8) {
                alert("Password must be at least 8 characters long!");
                password.focus();
                return false;
            }

            if (passwordValue !== confirmPasswordValue) {
                alert("Passwords do not match!");
                confirmPassword.focus();
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<div class="container form-container ">
    <form action="userRegister" method="POST" onsubmit="return ValidatePassword(document.getElementById('password'), document.getElementById('confirmPassword'));" class="col-md-7">

        <h1 class="text-center">Create Account</h1><br>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="name">Name</label><br>
                <input type="text" id="name" name="name" placeholder="Enter the Name" required class="form-control"><br>
            </div>

            <div class="form-group col-md-6 ">
                <label for="username">Username</label><br>
                <input type="text" id="username" name="username" placeholder="Enter the Username" required class="form-control"><br>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="email">Email</label><br>
                <input type="email" id="email" name="email" placeholder="Enter the Email" required class="form-control"><br>
            </div>
        </div>


        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="password">Password</label><br>
                <input type="password" id="password" name="password" placeholder="Enter the Password" required class="form-control"><br>
            </div>

            <div class="form-group col-md-6">
                <label for="confirmPassword">Confirm Password</label><br>
                <input type="password" id="confirmPassword" name="rpassword" placeholder="Re-Enter Password" required class="form-control"><br>
            </div>
        </div>

        <%--        <div class="form-group form-check">--%>
        <%--            <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
        <%--            <label class="form-check-label" for="exampleCheck1">Check me out</label>--%>
        <%--        </div>--%>


        <div class="form-row">
            <div class="col text-center">
        <button type="submit" class="btn btn-primary center-block">Submit</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
