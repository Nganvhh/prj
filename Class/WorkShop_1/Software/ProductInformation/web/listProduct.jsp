<%-- 
    Document   : listProduct
    Created on : Jun 23, 2024, 12:02:41 AM
    Author     : NganNganchimte
--%>

<%@page import="dao.CategoryDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="controllers.IConstant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container-fluid">
        <c:if test="${loginedAccount == null || modify != 1}">
            <jsp:forward page="MainController?action=home"/>
        </c:if>
        <c:if test="${mapProduct == null}">
            <jsp:forward page="ProductController?productRequest=<%= IConstant.LOAD_PRODUCT%>"/>
        </c:if>
        <c:if test="${mapCategory == null}">
            <jsp:forward page="CategoryController?category=<%= IConstant.LOAD_CATEGORY%>"/>
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
                                <td>ID</td>
                                <td>Name</td>
                                <td>Image</td>
                                <td>Brief</td>
                                <td>Posted date</td>
                                <td>Type</td>
                                <td>Unit</td>
                                <td>Price</td>
                                <td>Discount</td>
                                <td>Action</td>
                            </tr>
                        </thead>
                        <tbody id="myTable">                     
                            <c:forEach items="${mapProduct.keySet()}" var="i">
                                <c:if test="${mapProduct.get(i).account.equals(loginedAccount.account)}">
                                    <tr>
                                        <td>${mapProduct.get(i).productId}</td>
                                        <td>${mapProduct.get(i).productName}</td>
                                        <td>
                                            <img style="width: 100px"src="Images${mapProduct.get(i).productImage}" alt="${mapProduct.get(i).productImage}">
                                        </td>
                                        <td>${mapProduct.get(i).brief}</td>
                                        <td>${mapProduct.get(i).postedDate}</td>
                                        <td>
                                            <c:forEach items="${mapCategory.keySet()}" var="j">
                                                <c:if test="${mapCategory.get(j).typeId == mapProduct.get(i).typeId}">${mapCategory.get(j).categoryName}</c:if>
                                            </c:forEach>
                                        </td>
                                        <td>${mapProduct.get(i).unit}</td>
                                        <td>${mapProduct.get(i).price}</td>
                                        <td>${mapProduct.get(i).discount}</td>
                                        <td>
                                            <c:url scope="page" var="updateUrl" value="ProductController?">
                                                <c:param name="productRequest" value="<%= IConstant.UPDATE_PAGE_PRODUCT%>"/>
                                                <c:param name="productId" value="${mapProduct.get(i).productId}"/>
                                            </c:url>
                                            <c:url scope="page" var="deleteUrl" value="ProductController">
                                                <c:param name="productRequest" value="<%= IConstant.DELETE_PRODUCT%>"/>
                                                <c:param name="productId" value="${mapProduct.get(i).productId}"/>
                                            </c:url>
                                            <div style="margin-bottom: 10px">
                                                <a href="${updateUrl}" class="btn btn-primary">Update</a>
                                            </div>
                                            <div>
                                                <a href="${deleteUrl}" class="btn btn-danger">Delete</a>
                                            </div>

                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>   
                </div>
            </div>
            <div class="col-md-12" style="text-align: center; padding-bottom: 30px">
                <a href="ProductController?productRequest=<%= IConstant.ADD_PAGE_PRODUCT%>">Add new product</a>
            </div>
        </div>
    </body>
</html>

