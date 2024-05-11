<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Profile</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <style>
    .form-container {
      justify-content: center;
      height: 90%;
      width: 50vw;
      background: aliceblue;
      border: 1px solid deepskyblue; /* Box around form container */
      padding: 20px; /* Add padding inside the box */
      border-radius: 10px; /* Optional: rounded corners */
      margin-top: 10vh;
    }
  </style>
</head>

<body>

<%@ include file="header.jsp" %>

<%--<%--%>
<%--  if (user == null) {--%>
<%--    response.sendRedirect("Login.jsp");--%>
<%--  }--%>
<%--%>--%>

<div class="container text-center bg-light form-container">
  <h1>User Profile</h1>
  <% if (user != null) { %>
  <h4>Welcome, <%= user.getName() %>!</h4>
  <div class="row">
    <div class="col-md-6">
      <h3>User Details</h3>
      <table class="table">
        <tr>
          <td>User ID</td>
          <td><%= user.getId() %></td>
        </tr>
        <tr>
          <td>Username</td>
          <td><%= user.getEmail() %></td>
        </tr>
        <tr>
          <td>Email</td>
          <td><%= user.getUsername() %></td>
        </tr>
      </table>
    </div>
    <div class="col-md-6">
      <h3>Actions</h3>
      <div class="row">
        <div class="col-md-6 mb-3">
          <a href="requestEvent.jsp" class="btn btn-primary btn-block">Request New Event</a>
        </div>
        <div class="col-md-6 mb-3">
          <a href="viewEvent" class="btn btn-primary btn-block">View My Event List</a>
        </div>
        <div class="col-md-6 mb-3">
          <a href="LogoutServlet" class="btn btn-danger btn-block">Logout</a>
        </div>
        <div class="col-md-6 mb-3">
          <a href="DeleteUser?userId=<%= user.getId() %>" class="btn btn-danger btn-block">Delete My Account</a>
        </div>
      </div>
    </div>
  </div>
  <% } else { %>
  <div class="alert alert-danger" role="alert">
    You need to <a href="Login.jsp" class="alert-link">log in</a> to access this page.
  </div>
  <% } %>
</div>

</body>
</html>
