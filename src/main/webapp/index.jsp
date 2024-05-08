<%@ page import="Models.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>HomePage</h1>
<h2>WIP</h2>

<h1>Session Details</h1>

<%
    // Retrieve session object
    session = request.getSession(false); // Passing false means it won't create a new session if it doesn't exist

    if (session != null) {
        // Retrieve session attributes
        User user = (User) session.getAttribute("user");

        if (user != null) {
%>
<p>User Details:</p>
<ul>
    <li>Username: <%= user.getUsername() %></li>
    <li>Email: <%= user.getEmail() %></li>
    <li>ID: <%= user.getId() %></li>
    <li>Name: <%= user.getName() %></li>
    <!-- Add more user details as needed -->
</ul>
<%
} else {
%>
<p>No user details found in session.</p>
<%
    }
} else {
%>
<p>No session found.</p>
<%
    }
%>
</body>
</html>
