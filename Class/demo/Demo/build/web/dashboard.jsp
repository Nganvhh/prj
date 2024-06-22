<%-- 
    Document   : dashboard
    Created on : Jun 5, 2024, 8:40:28 AM
    Author     : NganNganchimte
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.TaiKhoan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${ttDangNhap == null}">
            <jsp:forward page = "login.jsp"></jsp:forward>
        </c:if>
        <%--<jsp:include page="head.jsp"/>--%>
        <h1 style="color: blue">Welcome to Mr. ${ttDangNhap.fullName} </h1>
        <a href="MainController?action=logout">Logout</a>
        <jsp:include page="ListAccount.jsp"/>
    </body>
</html>
