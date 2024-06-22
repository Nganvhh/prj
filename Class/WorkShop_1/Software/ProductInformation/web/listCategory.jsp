<%-- 
    Document   : listCategory
    Created on : Jun 22, 2024, 2:19:29 PM
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
        <c:if test="${mapCategory == null}">
            <jsp:forward page="MainController?action=loadListCategory"/>
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
                                <td>Category name</td>
                                <td>Memo</td>
                                <td>Action</td>
                            </tr>
                        </thead>
                        <tbody id="myTable">                     
                            <c:forEach items="${mapCategory.keySet()}" var="i">
                                <tr>
                                    <td>${mapCategory.get(i).categoryName}</td>
                                    <td>${mapCategory.get(i).memo}</td>
                                    <td>
                                        <c:url scope="page" var="updateUrl" value="CategoryController?">
                                            <c:param name="category" value="<%= IConstant.UPDATE_PAGE_CATEGORY %>"/>
                                            <c:param name="typeId" value="${mapCategory.get(i).typeId}"/>
                                        </c:url>
                                        <c:url scope="page" var="deleteUrl" value="CategoryController">
                                            <c:param name="category" value="<%= IConstant.DELETE_CATEGORY %>"/>
                                            <c:param name="typeId" value="${mapCategory.get(i).typeId}"/>
                                        </c:url>
                                        <a href="${updateUrl}" class="btn btn-primary">Update</a>
                                        <a href="${deleteUrl}" class="btn btn-danger">Delete</a>

                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>   
                </div>
            </div>
            <div class="col-md-12" style="text-align: center; padding-bottom: 30px">
                <a href="CategoryController?category=<%= IConstant.ADD_PAGE_CATEGORY %>">Add new category</a>
            </div>
        </div>
    </body>
</html>
