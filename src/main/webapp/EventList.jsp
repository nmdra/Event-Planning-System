<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Event List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Request List</h1>
    <table class="table table-striped table-bordered table-hover text-center">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID #</th>
            <th scope="col">User ID #</th>
            <th scope="col">Category</th>
            <th scope="col">DateTime</th>
            <th scope="col">Location</th>
            <th scope="col">Attendees</th>
            <th scope="col">Requirements</th>
            <th scope="col" colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="eventList" type="java.util.List"--%>
        <c:forEach var="event" items="${eventList}">
            <tr>
                <td>${event.eventId}</td>
                <td>${event.userID}</td>
                <td>${event.category}</td>
                <td>${event.dateTime}</td>
                <td>${event.location}</td>
                <td>${event.attendees}</td>
                <td>${event.requirements}</td>
                <td colspan="2">
                    <a href="deleteEvent?eventId=${event.eventId}" class="btn btn-danger btn-sm">Delete</a> <!-- Example delete link/button -->
                    <a href="CreatePlan.jsp?eventId=${event.eventId}" class="btn btn-primary btn-sm">Create Plan</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Add any additional content or scripts here -->
</body>
</html>
