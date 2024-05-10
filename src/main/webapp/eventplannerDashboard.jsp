<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Planner Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #d3d3d3;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            background: white;
            padding: 150px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            background-color: white;
            width: 100%;
            text-align: center;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        .dashboard {
            display: flex;
            gap: 20px;
        }
        .box {
            border: solid green 2px;
            width: 250px;
            height: 200px;
            padding: 30px;
            border-radius: 5px;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }
        input[type="button"] {
            background-color: #5cb85c;
            padding: 10px 20px;
            border: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Event Planner-Dashboard</h1><br><br>
        <div class="dashboard">
            <div class="box" id="event">
                <h2>Event</h2>
                <a href="eventList">
                    <input type="button" value="Go">
                </a>
            </div>

            <div class="box" id="eventPlan">
                <h2>Plan List</h2>
                <a href="EventPlanList">
                    <input type="button" value="Go">
                </a>
            </div>

            <div class="box" id="profile">
                <h2>Profile</h2>
                <a href="eventplannerprofile.jsp">
                    <input type="button" value="Go">
                </a>
            </div>
        </div>
        <form action="staffLogout" method="post"><br><br>
            <input type = "submit" name = "logout" value = "Logout" class="btn btn-primary">
        </form>
    </div>
</body>
</html>