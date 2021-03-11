<%-- 
    Document   : confirm_remove
    Created on : Nov 22, 2020, 4:47:42 PM
    Author     : sarun
--%>

<%@page import="model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Remove Employee</title>
    </head>
    <body>
       <%
            Employee emp = (Employee) session.getAttribute("employee");
            
        %>
        <form name="confirmRemove" action="ConfirmRemoveController">
            ID: <%= emp.getId() %> </br>
            Name: <%= emp.getName() %> </br>
            Salary: <%= emp.getSalary() %> </br>
            <input type="submit" value="Delete" name="delete" />
            <input type="submit" value="Cancel" name="cancel" />
            
        </form>
    </body>
</html>
