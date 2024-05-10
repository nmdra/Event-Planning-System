<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Error</h1>
    <%-- Check if error message is present in request attribute --%>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="alert alert-danger" role="alert">
        <strong>Error:</strong> ${request.getAttribute("errorMessage")}
    </div>
    <% } else { %>
    <div class="alert alert-danger" role="alert">
        <strong>Error:</strong> An unexpected error occurred.
    </div>
    <% } %>
    <p>Please try again later.</p>
</div>
</body>

<script>
    // Redirect to the previous page
    function redirectToPreviousPage() {
        window.history.back();
    }
    // Redirect after 5 seconds (adjust as needed)
    setTimeout(redirectToPreviousPage, 5000);
</script>
</html>
