<%-- 
    Document   : showemployee
    Created on : Nov 22, 2020, 3:13:07 PM
    Author     : sarun
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.EmployeeTable"%>
<%@page import="model.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Employee</title>
    </head>
    <jsp:useBean id="emp" class="model.Employee" scope="request"/>
     <%
                       
            List<Employee> empList = EmployeeTable.findAllEmployee();
            Iterator<Employee> itr = empList.iterator();
            
     %>
    <body>
        <center>
        <h1>Employee List</h1>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
          </tr>
          <%
              
               while(itr.hasNext()) {
                   emp = itr.next();
                   out.println("<tr>");
                   out.println("<td> "+ emp.getId() + "</td>");
                   out.println("<td> "+ emp.getName() + "</td>");
                   out.println("<td> "+ emp.getSalary() + "</td>");
                   out.println("<tr>");
               }
          %>
    </table>
    <a href="index.html">Back to Menu</a>
 </center>
    </body>
</html>
