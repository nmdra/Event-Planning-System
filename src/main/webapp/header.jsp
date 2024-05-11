<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Models.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EventWhiz</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
<body>

<%
    // Retrieve session object
    HttpSession session1 = request.getSession(false);
    User user = null;
    if (session1 != null) {
        user = (User) session1.getAttribute("user");
    } else{
    }
%>

<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="index.jsp">EventWhiz</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <%-- Check if user is logged in --%>
            <%    if (user != null) { %>
            <li class="nav-item active">
                <a class="nav-link" href="#">Welcome, <%= user.getUsername() %></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="LogoutServlet">Logout</a>
            </li>
            <% } else { %>
            <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Login</a>
            </li>
            <% } %>
        </ul>
    </div>
</nav>
</body>
</html>
