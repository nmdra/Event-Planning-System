<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .profile-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            margin-top: 5vh;
        }

        .profile-table {
            width: 50%;
            margin-top: 2rem;
        }

        .profile-table td {
            padding: 0.5rem;
            border: 1px solid #dee2e6;
        }

        .profile-table tr:first-child td {
            font-weight: bold;
            background-color: #f8f9fa;
        }

        .profile-table tr:nth-child(even) {
            background-color: #f8f9fa;
        }

        .profile-table tr:hover {
            background-color: #e9ecef;
        }

        .btn-container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 2rem;
        }

        .btn-container a {
            margin-right: 1rem;
        }
    </style>
</head>
<body>

<div class="container">
    <form>
        <h1>Profile Page</h1>
        <table class="table">
            <tr><td>Planner ID</td>      <td>${eventplanner_details.plannerid}</td></tr>
            <tr><td>Name</td>            <td>${eventplanner_details.name}</td></tr>
            <tr><td>Email</td>           <td>${eventplanner_details.email}</td></tr>
            <tr><td>Position</td>        <td>${eventplanner_details.position}</td></tr>
            <tr><td>User Name</td>       <td>${eventplanner_details.username}</td></tr>
        </table>

        <div class="btn-container">
            <c:url value="updateplannerprofile.jsp" var="updatedetails">
                <c:param name="plannerid" value="${eventplanner_details.plannerid}"/>
                <c:param name="name" value="${eventplanner_details.name}"/>
                <c:param name="email" value="${eventplanner_details.email}"/>
                <c:param name="position" value="${eventplanner_details.position}"/>
                <c:param name="username" value="${eventplanner_details.username}"/>
            </c:url>
            <a href="${updatedetails}" class="btn btn-primary">Update</a>

            <c:url value="deleteplanneraccount.jsp" var="deletedetails">
                <c:param name="plannerid" value="${eventplanner_details.plannerid}"/>
                <c:param name="name" value="${eventplanner_details.name}"/>
                <c:param name="email" value="${eventplanner_details.email}"/>
                <c:param name="position" value="${eventplanner_details.position}"/>
                <c:param name="username" value="${eventplanner_details.username}"/>
            </c:url>
            <a href="${deletedetails}" class="btn btn-danger">Delete My Account</a>
        </div>
    </form>
</div>

</body>
</html>
