<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Event Plan List</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <h1>Event Plan List</h1>

  <input type="text" id="searchInput" class="form-control" placeholder="Search...">

  <table class="table table-striped table-bordered table-hover">
    <thead class="thead-dark">
    <tr>
      <th scope="col">Event Plan ID #</th>
      <th scope="col">Event ID #</th>
      <th scope="col">Event Theme</th>
      <th scope="col">Budget</th>
      <th scope="col">Plan Description</th>
      <th scope="col" colspan="2">Actions</th>
    </tr>
    </thead>
    <tbody>
    <%--@elvariable id="eventPlans" type="java.util.List"--%>
    <c:forEach var="eventPlan" items="${eventPlans}">
      <tr>
        <td>${eventPlan.eventPlanId}</td>
        <td>${eventPlan.eventId}</td>
        <td>${eventPlan.theme}</td>
        <td>${eventPlan.budget}</td>
        <td>${eventPlan.planDescription}</td>
        <td colspan="2">
          <a href="deleteEventPlan?eventPlanId=${eventPlan.eventPlanId}" class="btn btn-danger btn-sm">Delete</a> <!-- Delete plan button -->
          <a href="updateEventPlan?eventPlanId=${eventPlan.eventPlanId}" class="btn btn-primary btn-sm">Update</a> <!-- Delete plan button -->
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
