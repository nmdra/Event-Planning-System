<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Event List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container text-center">
    <h1>My Event List</h1>

    <input type="text" id="searchInput" class="form-control" placeholder="Search...">

    <table class="table table-striped table-bordered table-hover text-center">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID #</th>
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
                <td>${event.category}</td>
                <td>${event.dateTime}</td>
                <td>${event.location}</td>
                <td>${event.attendees}</td>
                <td>${event.requirements}</td>
                <td colspan="2">
                    <a href="deleteEvent?eventId=${event.eventId}" class="btn btn-danger btn-sm">Delete</a> <!-- Example delete link/button -->
                    <a href="viewEventPlan?eventId=${event.eventId}" class="btn btn-primary btn-sm">View Plan</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    document.getElementById('searchInput').addEventListener('keyup', function() {
        const searchValue = this.value.toLowerCase();
        const rows = document.querySelectorAll('tbody tr');

        rows.forEach(row => {
            const text = row.textContent.toLowerCase();
            row.style.display = text.includes(searchValue) ? '' : 'none';
        });
    });
</script>
</body>
</html>
