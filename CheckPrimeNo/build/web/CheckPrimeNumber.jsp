<%-- 
    Document   : CheckPrimeNumber
    Created on : Feb 6, 2021, 6:41:27 PM
    Author     : Cheetah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body>
        <H1><%=request.getParameter("number") %> <%=request.getAttribute("reply") %>.</H1>
    </body>
</html>
