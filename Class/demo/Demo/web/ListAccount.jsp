<%-- 
    Document   : ListAccount
    Created on : Jun 12, 2024, 8:08:30 AM
    Author     : NganNganchimte
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sach tai khoan</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="Styles/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            .bt{
                width: 20px;
            }
        </style>
    </head>
    <body class="container">
        <div class="row">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <tr>
                            <td>Account</td>
                            <td>Full name</td>
                            <td>Gender</td>
                            <td>BirthDay</td>
                            <td>Phone</td>
                            <td>Action</td>
                        </tr>
                        <c:set var="currentAccount" value="${ttDangNhap.account}"/>
                        <c:forEach items="${ds}" var="i">
                            <c:if test="${!i.account.equals(currentAccount)}">
                                <tr>
                                    <td>${i.account}</td>
                                    <td>${i.fullName}</td>
                                    <td>
                                        <div class="bt_wrapper">
                                            <img class="bt" src="Images/${i.gender?"":"fe"}male.png">
                                        </div>
                                    </td>
                                    <td>
                                        <fmt:formatDate pattern="dd/MM/yyyy" value="${i.dob}"/>
                                    </td>
                                    <td>${i.phone}</td>
                                    <td>
                                        <%--<c:url scope="page" var="deleteUrl" value="MainController">
                                            <c:param name="action" value="delete"/>
                                            <c:param name="key" value="${i.account}"/>
                                        </c:url>
                                        <c:url scope="page" var="updateUrl" value="MainController?action=update">
                                            <c:param name="key" value="${i.account}"/>
                                        </c:url>
                                        <a href="${deleteUrl}" class="btn btn-danger">Delete</a>
                                        <a href="${updateUrl}" class="btn btn-primary">Update</a>--%>

                                        <form action="MainController?action=delete"  method="post">
                                            <input type="hidden" value="${i.account}" name="key"/>
                                            <button class="btn btn-danger">Delete</button>
                                        </form>
                                        <form action="MainController?action=update"  method="post">
                                            <input type="hidden" value="${i.account}" name="key"/>
                                            <button class="btn btn-danger">Update</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>      
                </div>

            </div>
        </div>
    </body>
</html>
