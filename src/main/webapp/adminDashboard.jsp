<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .container {
            margin-top: 50px;
        }
        .btn-custom {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h1 class="text-center">Admin Dashboard</h1>
            <div class="text-center">
                <a href="userList" class="btn btn-primary btn-lg btn-custom">Customers</a>
                <a href="staffList" class="btn btn-success btn-lg btn-custom">Event Planners</a>
                <a href="EventPlanList" class="btn btn-success btn-lg btn-custom">Event Plan List</a>
                <a href="eventList" class="btn btn-info btn-lg btn-custom">Events List</a>
                <a href="adminProfile.jsp" class="btn btn-warning btn-lg btn-custom">Admin Profile</a>
                <a href="addNewAdmin.jsp" class="btn btn-info btn-lg btn-custom">Add New Admin</a>
                <a href="addStaff.jsp" class="btn btn-info btn-lg btn-custom">Add New Staff Member</a>

            </div>
        </div>
    </div>
</div>
</body>
</html>
