<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Plan</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Create Plan</h1>
    <%-- Read eventId from request parameter --%>
    <% String eventId = request.getParameter("eventId"); %>

    <% String userID = request.getParameter("userId"); %>

    <%-- Check if eventId is not null or empty --%>
    <% if (eventId != null && !eventId.isEmpty()) { %>
    <form action="createPlan" method="post">
        <%-- Use hidden input field to pass eventId to servlet --%>

            <input type="hidden" id="userID" name="userID" value="<%= userID %>" class="form-control">

            <div class="form-group">
            <label for="eventId">Event ID: </label>
            <input type="text" id="eventId" name="eventId" value="<%= eventId %>" class="form-control" readonly>
            </div>

            <div class="form-group">
                <label for="theme">Event Theme:</label>
                <input type="text" class="form-control" id="theme" name="theme">
            </div>
        <div class="form-group">
            <label for="budget">Budget:</label>
            <input type="text" class="form-control" id="budget" name="budget">
        </div>
        <div class="form-group">
            <label for="planDescription">Plan Description:</label>
            <textarea class="form-control" id="planDescription" name="planDescription" rows="3"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <% } else { %>
    <p>No eventId specified.</p>
    <% } %>
</div>
</body>
</html>
