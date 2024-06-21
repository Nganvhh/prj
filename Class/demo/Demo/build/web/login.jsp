<%-- 
    Document   : login
    Created on : Jun 5, 2024, 8:24:47 AM
    Author     : NganNganchimte
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="Styles/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body class="container">
        <h1>Đăng nhập hệ thống thông minh vcl siêu cấp vjp pờ zồ :D</h1>
        <!--${ttDangNhap.fullName} EL: Expression Language-->
        <c:if test="${ttDangNhap != null}">
            <jsp:forward page="dashboard.jsp"></jsp:forward>
        </c:if>
        <form action="MainController?action=authen" method="post">
            <div class="imgcontainer">
                <img src="Images/img_avatar2.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">
                <label for="account"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="account" required>

                <label for="pass"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="pass" required>

                <!--<p style="color: red; font-weight: bold">
                <%=   (request.getAttribute("ERROR") != null) ? request.getAttribute("ERROR") : ""%>
                </p>-->

                <button type="submit">Login</button>
                <label>
                    <input type="checkbox" checked="checked" name="remember"> Remember me
                </label>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" class="cancelbtn">Cancel</button>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
            <c:if test="${ERROR != null} ">
                <h3 style="color: red;">
                    ${ERROR}
                </h3>
            </c:if>
        </form> 
    </body>
</html>

