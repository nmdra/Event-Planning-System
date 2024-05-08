<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, Models.Event.Event" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Request List</h1>
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th scope="col">Request ID</th>
            <th scope="col">Request Title</th>
            <th scope="col">Request Description</th>
            <!-- Add more table headers as needed -->
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="eventList" type="java.util.List"--%>
        <c:forEach var="event" items="${eventList}">
            <tr>
                <td>${event.location}</td>
                <td>${event.userID}</td>
                <td>${event.requirements}</td>
                <!-- Add more table cells as needed -->
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Add any additional content or scripts here -->
</body>
</html>
