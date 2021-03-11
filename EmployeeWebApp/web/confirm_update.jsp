<%-- 
    Document   : confirm_update
    Created on : Nov 22, 2020, 4:20:51 PM
    Author     : sarun
--%>

<%@page import="model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Update Employee</title>
    </head>
    <%Employee emp = (Employee )session.getAttribute("employee"); %>
    <body>
        <form name="confirmUpdate" action="ConfirmUpdateController">
            ID: <%=emp.getId()%>
            </br>
            Name: <input type="text" name="name" value="<%=emp.getName()%>" size="40" />
            </br>
            Salary: <input type="text" name="salary" value="<%=emp.getSalary()%>" size="10" />
            </br>
            <input type="submit" value="Update" name="update" />
            <input type="submit" value="Cancel" name="cancel" />
        </form>
    </body>
</html>
