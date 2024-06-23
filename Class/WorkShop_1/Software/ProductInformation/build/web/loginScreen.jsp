<%-- 
    Document   : loginScreen
    Created on : Jun 14, 2024, 1:27:48 AM
    Author     : NganNganchimte
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Login</title>
        <link rel="preconnect" shref="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Roboto+Mono:ital,wght@0,100..700;1,100..700&display=swap"
            rel="stylesheet"
            />
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
            />
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="styles/loginStyle.css" />
    </head>
    <body>
        <c:if test="${loginedAccount != null}">
            <jsp:forward page="homeScreen"/>
        </c:if>
        <header>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="MainController?action=home"><strong style="font-size: 1.5em">WS1</strong></a>
                    </div>
                </div>
            </nav>
        </header>

        <div class="login_wrapper">
            <form action="MainController" method="post">
                <div class="img_container">
                    <img
                        src="Images/loginBackground.png"
                        class="login_icon"
                        alt="Background Login"/>
                </div>
                <div class="">
                    <h2>Log in</h2>
                </div>
                <div class="form-group">
                    <input
                        class="form-control"
                        type="text"
                        placeholder="Username"
                        name="account"
                        required
                        />
                </div>
                <div class="form-group">
                    <input
                        class="form-control"
                        type="password"
                        placeholder="Password"
                        name="pass"
                        requireds
                        />
                </div>
                <c:if test="${error != null}">
                    <p style="color: red">${error}</p>
                </c:if>
                <div>
                    <button type="submit" class="btn" value="login" name="action">Đăng nhập</button>
                    <a href="MainController?action=register&behaviour=newAccount" class="createAccount">Create new account</a>
                </div>
            </form>
        </div>
    </body>
</html>

