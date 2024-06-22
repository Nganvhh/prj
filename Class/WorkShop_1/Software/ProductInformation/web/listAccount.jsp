<%-- 
    Document   : listAccount
    Created on : Jun 19, 2024, 9:08:35 AM
    Author     : NganNganchimte
--%>

<%@page import="controllers.IConstant"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            .bt{
                width: 3.5rem;
            }
        </style>
    </head>
    <body class="container">
        <c:if test="${loginedAccount == null || modify != 1}">
            <jsp:forward page="MainController?action=home"/>
        </c:if>
        <c:if test="${mapAccount == null}">
            <jsp:forward page="AccountController?accountRequest=<%= IConstant.LOAD_ACCOUNT %>"/>
        </c:if>
        <div class="row">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <td>Account</td>
                                <td>Full name</td>
                                <td>Birthday</td>
                                <td>Gender</td>
                                <td>Phone</td>
                                <td>Role in system</td>
                                <td>Action</td>
                            </tr>
                        </thead>
                        <tbody id="myTable">                     
                            <c:set var="currentAccount" value="${loginedAccount.account}"/>
                            <c:forEach items="${mapAccount.keySet()}" var="i">
                                <c:if test="${!mapAccount.get(i).account.equals(currentAccount)}">
                                    <tr>
                                        <td>${mapAccount.get(i).account}</td>
                                        <td>${mapAccount.get(i).lastName.concat(" ").concat(mapAccount.get(i).firstName)}</td>
                                        <td>
                                            <fmt:formatDate pattern="dd/MM/yyyy" value="${mapAccount.get(i).birthDay}"/>
                                        </td>
                                        <td>
                                            <div class="bt_wrapper">
                                                <img class="bt" src="Images/images/img_avatar${mapAccount.get(i).gender?"1":"2"}.png">
                                            </div>
                                        </td>
                                        <td>${mapAccount.get(i).phone}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${mapAccount.get(i).getRoleInSystem() == 2}">Staff</c:when>
                                                <c:when test="${mapAccount.get(i).getRoleInSystem() == 1}">Administrator</c:when>
                                                <c:otherwise>Customer</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:url scope="page" var="updateUrl" value="MainController?">
                                                <c:param name="action" value="update"/>
                                                <c:param name="account" value="${mapAccount.get(i).account}"/>
                                            </c:url>
                                            <c:url scope="page" var="stateUrl" value="MainController?">
                                                <c:param name="action" value="state"/>
                                                <c:param name="account" value="${mapAccount.get(i).account}"/>
                                            </c:url>
                                            <c:url scope="page" var="deleteUrl" value="MainController">
                                                <c:param name="action" value="delete"/>
                                                <c:param name="account" value="${mapAccount.get(i).account}"/>
                                            </c:url>

                                            <a href="${updateUrl}" class="btn btn-primary">Update</a>
                                            <a href="${stateUrl}" class="btn btn-success">
                                                <c:choose>
                                                    <c:when test="${mapAccount.get(i).isUse == true}">Active</c:when>
                                                    <c:when test="${mapAccount.get(i).isUse == false}">Defective</c:when>
                                                </c:choose>
                                            </a>
                                            <a href="${deleteUrl}" class="btn btn-danger">Delete</a>

                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>   
                </div>
            </div>
            <div class="col-md-12" style="text-align: center; padding-bottom: 30px">
                <a href="MainController?action=register&behaviour=newAccount">Add new account</a>
            </div>
        </div>
    </body>
</html>
