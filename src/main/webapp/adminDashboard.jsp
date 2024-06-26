<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Custom CSS -->
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
            <!-- Buttons -->
            <div class="text-center">
                <a href="customers.jsp" class="btn btn-primary btn-lg btn-custom">Customers</a>
                <a href="eventplanners.jsp" class="btn btn-success btn-lg btn-custom">Event Planners</a>
                <a href="events.jsp" class="btn btn-info btn-lg btn-custom">Events</a>
                <a href="adminprofile.jsp" class="btn btn-warning btn-lg btn-custom">Admin Profile</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
