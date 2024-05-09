<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update profile page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<%
    String plannerid = request.getParameter("plannerid");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String position = request.getParameter("position");
    String username = request.getParameter("username");

%>

<div class="container mt-5">
    <form action="updateStaffProfile" method="post">
        <h1 class="mb-4">Update Profile Page</h1>
        <table class="table table-bordered">
            <tr>
                <td>Planner ID</td>
                <td><input type="text" name="plannerid" value="<%= plannerid %>" class="form-control" readonly></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="<%= name %>" class="form-control"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="<%= email %>" class="form-control"></td>
            </tr>
            <tr>
                <td>Position</td>
                <td><input type="text" name="position" value="<%= position %>" class="form-control" readonly></td>
            </tr>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="username" value="<%= username %>" class="form-control"></td>
            </tr>
        </table>
        <input type="submit" name="update" value="Save" class="btn btn-primary">
    </form>
</div>

</body>
</html>
