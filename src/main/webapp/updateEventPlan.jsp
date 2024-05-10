<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="eventPlan" type="Models.Event.EventPlan"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Event Plan</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Update Event Plan</h1>
    <form action="updateEventPlan" method="post">

        <div class="form-group">
            <label for="userID">User ID: </label>
            <input type="text" id="userID" name="userID" value="${eventPlan.userID}" class="form-control" readonly>
        </div>

        <div class="form-group">
            <label for="eventPlanId">Event Plan ID: </label>
            <input type="text" id="eventPlanId" name="eventPlanId" value="${eventPlan.eventPlanId}" class="form-control" readonly>
        </div>

        <div class="form-group">
        <label for="eventId">Event ID: </label>
        <input type="text" id="eventId" name="eventId" value="${eventPlan.eventId}" class="form-control" readonly>
        </div>

        <div class="form-group">
            <label for="theme">Event Theme:</label>
            <input type="text" class="form-control" id="theme"  value="${eventPlan.theme}" name="theme">
        </div>
        <div class="form-group">
            <label for="budget">Budget:</label>
            <input type="text" class="form-control" id="budget" name="budget" value="${eventPlan.budget}">
        </div>
        <div class="form-group">
            <label for="planDescription">Plan Description:</label>
            <textarea class="form-control" id="planDescription" name="planDescription"> ${eventPlan.planDescription}</textarea>
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>
