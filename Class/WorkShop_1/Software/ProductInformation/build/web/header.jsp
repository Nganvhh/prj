<%-- 
    Document   : header
    Created on : Jun 13, 2024, 2:06:04 PM
    Author     : NganNganchimte
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Header</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!--<link href="Styles/login.css" rel="stylesheet" type="text/css" />-->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="styles/headerStyle.css">
    </head>
    <body>
        <header>
            <c:choose>
                <c:when test="${loginedAccount == null || modify == 0}">
                    <div class="header_button">
                        <ul>
                            <li style="display:${loginedAccount == null?"":"none"}">
                                <a href="MainController?action=register&behaviour=newAccount"><span class="glyphicon glyphicon-user text-dark header_button-icon"></span>Register</a>
                            </li>

                            <li style="display: ${loginedAccount == null?"":"none"}">
                                <a href="MainController?action=login&firstLogin=1"><span class="glyphicon glyphicon-log-in header_button-icon"></span>Sign in</a>
                            </li>
                            <li style="display: ${loginedAccount != null?"":"none"}">
                                <a href="MainController?action=logout"><span class="glyphicon glyphicon-log-out header_button-icon"></span>Sign out</a>
                            </li>
                        </ul>

                    </div>

                    <nav class="navbar navbar-inverse">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="MainController?action=home">
                                    <strong class="brand">WS1</strong>
                                    <c:if test="${loginedAccount != null}">
                                        Welcome to <strong style="color: red">${loginedAccount.account} </strong>[${loginedAccount.lastName.concat(" ").concat(loginedAccount.firstName).trim()}]
                                    </c:if>
                                </a>9
                            </div>
                            <ul class="nav navbar-nav  navbar-inverse">

                                <li>
                                    <a href="MainController?action=home">Home</a>
                                </li>
                                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <c:forEach items="${mapCategory.keySet()}" var="i">
                                            <li>
                                                <a class="sidebar_link" href="MainController?action=category&numericalOrder=${i}">
                                                    ${mapCategory.get(i).categoryName}
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </li>

                            </ul>

                            <form class="navbar-form navbar-right" action="#">
                                <div class="form-group has-feedback has-search">
                                    <input
                                        type="text"
                                        class="form-control"
                                        placeholder="Tìm kiếm"
                                        />
                                    <span
                                        class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </form>
                        </div>
                    </nav>
                </c:when>
                <c:otherwise>
                    <div class="header_button">
                        <ul>
                            <li style="display: ${loginedAccount != null?"":"none"}">
                                <a href="MainController?action=logout"><span class="glyphicon glyphicon-log-out header_button-icon"></span>Đăng xuất</a>
                            </li>
                        </ul>
                    </div>

                    <nav class="navbar navbar-inverse">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="MainController?action=home">
                                    <strong class="brand">WS1</strong>
                                    <c:if test="${loginedAccount != null}">
                                        Welcome to <strong style="color: red">${loginedAccount.account} </strong>
                                        [${loginedAccount.lastName.concat(" ").concat(loginedAccount.firstName).trim()}]
                                    </c:if>
                                </a>

                            </div>
                            <ul class="nav navbar-nav  navbar-inverse">
                                <li><a href="MainController?action=home">Home</a></li>
                                <li><a href="MainController?action=showListAccount">Accounts</a></li>
                                <li><a href="MainController?action=showListCategory">Categories</a></li>
                                <li><a href="MainController?action=showListProduct">Products</a></li>                                
                            </ul>

                            <form class="navbar-form navbar-right" action="#">
                                <div class="form-group has-feedback has-search">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="myInput"
                                        placeholder="Tìm kiếm"/>
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </form>
                        </div>
                    </nav>
                </c:otherwise>
            </c:choose>
        </header>
        <script>
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>
    </body>
</html>

