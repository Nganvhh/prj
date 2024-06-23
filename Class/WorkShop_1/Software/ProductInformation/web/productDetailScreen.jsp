<%-- 
    Document   : productDetailScreen
    Created on : Jun 23, 2024, 10:33:14 AM
    Author     : NganNganchimte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/productStyle.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-7 col-xs-7">
                    <div class="img-responsive">
                        <img style="width: 100%" src="Images${selectedProduct.productImage}" alt="${selectedProduct.productName}">
                    </div>
                </div>
                <div class="row">
                    <div>
                        <div>
                            <h3>${selectedProduct.productName}</h3>
                        </div>
                        <div class="bg-default">
                            <div class="product_wrapper_info-price" style="font-size: 18px">
                                <p class="product_wrapper_info-price-now full-number-money"><span>₫</span>${selectedProduct.price*((100-selectedProduct.discount)/100)}</p>
                                <c:if test="${selectedProduct.discount > 0}">
                                    <del class="product_wrapper_info-price-original"><span>₫</span>${selectedProduct.price}</del>
                                    <p class="product_wrapper_info-price-discount">-${selectedProduct.discount}%</p>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-danger">Buy Now</button>
                    <button class="btn btn-primary">Add to Cart</button>
                </div>
            </div>
        </div>
        <div class="col-xs-12">
            <p style="margin-top: 20px">${selectedProduct.brief}</p>
        </div>
    </div>
</body>
</body>
</html>
