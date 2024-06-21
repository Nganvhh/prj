<%-- 
    Document   : allProductView
    Created on : Jun 13, 2024, 8:58:04 PM
    Author     : NganNganchimte
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="Styles/login.css" rel="stylesheet" type="text/css" />
        <!-- Latest compiled and minified CSS -->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="styles/sidebarStyle.css"/>
        <link rel="stylesheet" href="styles/headerStyle.css"/>
        <link rel="stylesheet" href="styles/productStyle.css">
        <style>
            .zoom-out {
                transform: scale(0.8); /* Adjust the scale as needed */
                transform-origin: top left;
                width: 125%; /* Adjust width to fit content correctly after scaling */
            }
        </style>
    </head>
    <body class=".zoom-out">
        <c:if test="${mapCategory == null||mapCategory.isEmpty()}">
            <jsp:forward page="MainController?action=loadListCategory"/>
        </c:if>
        <c:if test="${mapProduct == null||mapProduct.isEmpty()}">
            <jsp:forward page="MainController?action=loadListProduct"/>
        </c:if>
        <jsp:include page="header.jsp"/>
        <nav class="sidebar">
            <div>
                <div class="sidebar_title">
                    <strong>Danh mục</strong>
                </div>


                <c:forEach items="${mapCategory.keySet()}" var="i">
                    <a class="sidebar_link" href="MainController?action=category&numericalOrder=${i}">
                        ${mapCategory.get(i).categoryName}
                    </a>
                </c:forEach>
            </div>
        </nav>

    <session>
        <div class="row all_products">
            <c:forEach items="${mapProduct.keySet()}" var="i">
                <div class=" col-lg-3 col-md-4 col-xs-6 a">
                    <a class="product_wrapper">
                        <div>
                            <img src="Images${mapProduct.get(i).productImage}" alt="ảnh sản phẩm">
                        </div>
                        <div class="product_wrapper_info">
                            <p class="product_wrapper_info-name">${mapProduct.get(i).productName}</p>
                            <div class="product_wrapper_info-price">
                                <p class="product_wrapper_info-price-now full-number-money"><span>₫</span>${mapProduct.get(i).price*((100-mapProduct.get(i).discount)/100)}</p>
                                <c:if test="${mapProduct.get(i).discount > 0}">
                                    <del class="product_wrapper_info-price-original"><span>₫</span>${mapProduct.get(i).price}</del>
                                    <p class="product_wrapper_info-price-discount">-${mapProduct.get(i).discount}%</p>
                                </c:if>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </session> 
</body>
</html>
