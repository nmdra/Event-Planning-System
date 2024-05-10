<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete profile page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #d3d3d3;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 70vh;
        }
        .delete-container {
         width: 400px;
         height: 650px; 
         background: white;
         padding: 20px 40px;
         border-radius: 5px;
         box-shadow: 0 4px 10px rgba(0,0,0,0.1);}

        .delete-table {
            width: 300px;
            height: 320px;
            background: white;
            padding: 20px 40px;
            border-radius: 5px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .delete th,
        .delete td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .delete-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .delete-table tr:hover {
            background-color: #f1f1f1;
        }

        .delete-table th {
            background-color: #4CAF50;
            color: white;
        }

        .delete-table td {
            color: #555;
        }
    </style>
</head>
<body>

   <%
        String plannerid = request.getParameter("plannerid");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String position = request.getParameter("position");
        String username = request.getParameter("username");
    %>
    
    <div class = "delete-container">  
    <form action="deleteStaffAccount" method = "post">
    
    <br><br> 
        <h1> Update Profile Page</h1>

        <table class="delete table-table">
            <tr><td>Manager ID</td>      <td><input type ="text" name = "plannerid" value = "<%= plannerid %>" readonly></td></tr>
            <tr><td>Name</td>            <td><input type ="text" name = "name" value = "<%= name %>" readonly> </td></tr>
            <tr><td>Email</td>           <td><input type ="text" name = "email" value = "<%= email %>"readonly></td></tr>
            <tr><td>Position</td>        <td><input type ="text" name = "position" value = "<%= position %>" readonly></td></tr>
            <tr><td>User Name</td>       <td><input type ="text" name = "username" value = "<%= username %>"readonly></td></tr>
        </table>

     <input type = "submit" name = "delete" value = "delete">

   </form>
   </div>
</body>
</html>