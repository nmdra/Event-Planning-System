<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Staff List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Staff List</h1>

    <input type="text" id="searchInput" class="form-control" placeholder="Search...">

    <table class="table table-striped table-bordered table-hover text-center mt-3">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Planner ID #</th>
            <th scope="col">Name</th>
            <th scope="col">E-mail</th>
            <th scope="col">Username</th>
            <th scope="col">position</th>
            <th scope="col" colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="eventplanners" type="java.util.List"--%>
        <c:forEach var="planner" items="${eventplanners}">
            <tr>
                <td>${planner.plannerid}</td>
                <td>${planner.name}</td>
                <td>${planner.email}</td>
                <td>${planner.username}</td>
                <td>${planner.position}</td>
                <td colspan="2">
                    <c:url value="deleteplanneraccount.jsp" var="deletedetails">
                        <c:param name="plannerid" value="${planner.plannerid}"/>
                        <c:param name="name" value="${planner.name}"/>
                        <c:param name="email" value="${planner.email}"/>
                        <c:param name="position" value="${planner.position}"/>
                        <c:param name="username" value="${planner.username}"/>
                    </c:url>
                    <a href="${deletedetails}" class="btn btn-danger btn-sm">Delete</a>

                    <c:url value="updateplannerprofile.jsp" var="updatedetails">
                        <c:param name="plannerid" value="${planner.plannerid}"/>
                        <c:param name="name" value="${planner.name}"/>
                        <c:param name="email" value="${planner.email}"/>
                        <c:param name="position" value="${planner.position}"/>
                        <c:param name="username" value="${planner.username}"/>
                    </c:url>
                    <a href="${updatedetails}" class="btn btn-primary btn-sm">Update</a>
<%--                    <a href="deleteStaffAccount?plannerid=${planner.plannerid}&position=${planner.position}" class="btn btn-danger btn-sm">Delete</a> <!-- Example delete link/button -->--%>
<%--                    <a href="updateStaffProfile?plannerid=${planner.plannerid}&position=${planner.position}" class="btn btn-primary btn-sm">update</a>--%>
<%----%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    document.getElementById('searchInput').addeventplanner('keyup', function() {
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