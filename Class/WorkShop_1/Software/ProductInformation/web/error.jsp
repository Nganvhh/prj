<%-- 
    Document   : error
    Created on : Jun 23, 2024, 6:37:01 AM
    Author     : NganNganchimte
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    <%@page isErrorPage="true" %> <%--tiền chỉ định này giúp sinh ra 1 biến, con trỏ trong _jsp.java. biến này là exception--%>
<!DOCTYPE html>
<html>
<head>
<title>Error</title>
</head>
<body>
    <center>
        <h1>Error</h1>
        <h2><%=exception.getMessage() %><br/> </h2>
    </center>
</body>
</html>
