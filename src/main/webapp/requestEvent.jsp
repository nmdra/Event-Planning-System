<%--
  Created by IntelliJ IDEA.
  User: nimendra
  Date: 03/05/2024
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Request Event</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .form-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 70%;
            width: 60%;
            background: aliceblue;
            border: 1px solid deepskyblue; /* Box around form container */
            padding: 10px; /* Add padding inside the box */
            border-radius: 10px; /* Optional: rounded corners */
            margin-top: 20vh;
        }
    </style>
</head>
<body>
<div class="container form-container">
    <form action="eventRequest" method="POST" class="col-md-7" novalidate>
        <h1 class="text-center">Event Request Form</h1>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="category">Select the Event Type</label>
                <select name="category" id="category" class="form-control" required>
                    <option value="">Please select</option>
                    <option value="Wedding">Wedding</option>
                    <option value="Speaker Session">A speaker session</option>
                    <option value="Seminar or Half-day Event">Seminar or half-day event</option>
                    <option value="Workshops">Workshops</option>
                    <option value="Award and Competitions">Award and Competitions</option>
                    <option value="Festivals">Festivals</option>
                    <option value="Parties">Parties</option>
                    <option value="Conferences">Conferences</option>
                    <option value="Exhibition or Trade Show">Exhibition or trade show</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="dateTime">Date of Event</label>
                <input type="datetime-local" name="dateTime" id="dateTime" class="form-control" required>
            </div>
            <div class="form-group col-md-6">
                <label for="attendance">Expected Attendance</label>
                <input type="number" name="attendance" id="attendance" class="form-control" placeholder="Enter number of attendees" required>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="requirements">Special Requirements</label>
                <textarea name="requirements" id="requirements" class="form-control" rows="3" placeholder="Enter any special requirements" required></textarea>
            </div>
            <div class="form-group col-md-6">
                <label for="location">Location</label>
                <textarea rows="3" name="location" id="location" class="form-control" placeholder="Location" required></textarea>
            </div>
        </div>
        <div class="form-row">
            <div class="col text-center">
                <button type="submit" class="btn btn-primary center-block">Submit</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>

