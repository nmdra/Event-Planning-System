<%--@elvariable id="adminDetails" type="Models.Staff.Admin"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Profile</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <form>
        <h1>Admin Profile</h1>
        <table class="table table-stripped table-hover">
            <tr><td>Admin ID</td>      <td>${adminDetails.adminId}</td></tr>
            <tr><td>Name</td>            <td>${adminDetails.name}</td></tr>
            <tr><td>Email</td>           <td>${adminDetails.email}</td></tr>
            <tr><td>Position</td>        <td>${adminDetails.position}</td></tr>
            <tr><td>User Name</td>       <td>${adminDetails.username}</td></tr>
        </table>
            <a href="${updatedetails}" class="btn btn-primary">Update</a>
        <a href="staffLogout" class="btn btn-danger">LogOut</a>
        <a href="deleteAdminServlet?Id=${adminDetails.adminId}" class="btn btn-danger">Delete My Account</a>
    </form>
</div>

</body>
</html>
