<%-- 
    Document   : addProductScreen
    Created on : Jun 23, 2024, 12:08:43 AM
    Author     : NganNganchimte
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dao.CategoryDAO"%>
<%@page import="controllers.IConstant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div class="row">
                <h3>Add New Product</h3>
                <div class="col-md-8">
                    <form action="ProductController" method="POST" class="form-horizontal" accept-charset="UTF-8">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="productId">Product ID</label>
                            <div class="col-sm-10 check-input">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="productId"
                                    name="productId"
                                    autocomplete="new-productId"
                                    placeholder="ID"
                                    value="${IsCreatingProduct.productId}"
                                    required
                                    />
                                <small class="form-text"></small>
                                <c:if test="${ExistProductId != null}">
                                    <small style="color: red">${ExistProductId}</small>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="productName">Product name</label>
                            <div class="col-sm-10 check-input">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="productName"
                                    name="productName"
                                    autocomplete="new-productName"
                                    placeholder="Name"
                                    value="${IsCreatingProduct.productName}"
                                    required
                                    />
                                <small class="form-text"></small>
                            </div>
                        </div>
                        <div class="form-group">
                            ${IsCreatingProduct.productImage}
                            <label class="control-label col-sm-2" for="productImage">Product Image</label>
                            <div class="col-sm-10">
                                <input type = "file" name = "productImage" size = "50" value="${IsCreatingProduct.productImage}"/><br>
                            </div>    
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="brief">Brief</label>
                            <div class="col-sm-10">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="productName"
                                    name="brief"
                                    autocomplete="new-brief"
                                    placeholder="brief"
                                    value="${IsCreatingProduct.brief}"
                                    />
                            </div>
                        </div>
                        <div class="form-group">
                            <c:set value="<%= new CategoryDAO().listAll()%>" var="listCategories"/>
                            <label class="control-label col-sm-2" for="typeId">Type</label>
                            <div class="col-sm-10 check-input">
                                <select class="form-control" name="typeId">
                                    <c:forEach items="${listCategories.keySet()}" var="i">
                                        <option value="${listCategories.get(i).typeId}">${listCategories.get(i).categoryName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="unit">Unit</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="unit">
                                    <option>Cái</option>
                                    <option>Chiếc</option>
                                    <option>Bộ</option>
                                    <option>Đôi</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="price">Price</label>
                            <div class="col-sm-10">
                                <input type="number" min="0" class="form-control" name="price" id="price" value="0"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="discount">Discount</label>
                            <div class="col-sm-10">
                                <input type="number" min="0" max="100" class="form-control" name="discount" id="discount" value="0"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button onclick="out(event)" type="submit" id="btn-cancel" class="btn btn-danger" name="productRequest" value="<%= IConstant.SHOW_PRODUCT %>">Cancel</button>
                                <button type="submit" id="btn-newProduct" class="btn btn-success" name="productRequest" value="<%= IConstant.VALIDATION_PRODUCT%>">Submit</button>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
                            
        <script>
            const btnNewCategory = document.getElementById('btn-newProduct');
            const inputEles = document.querySelectorAll('.check-input');
            const btnCancel = document.getElementById('btn-cancel');
            btnNewCategory.addEventListener('click', function () {
                Array.from(inputEles).map((ele) =>
                    ele.classList.remove('success', 'error'))
                let isValid = checkValidate();
                if (isValid) {
                    console.log(window.location.href);
                }
            });
            function out(event) {
                let name = document.getElementById('productName');
                let id = document.getElementById('productId');
                name.removeAttribute('required');
                id.removeAttribute('required');
                document.getElementById('btn-cancel').submit();
            }

            // Truy cập vào các ô input
            const productIdEle = document.getElementById('productId');
            const productNameEle = document.getElementById('productName');
            const typeIdEle = document.getElementById('typeId');
            const discountEle = document.getElementById('discount');
            // Validate dữ liệu trong các ô input và highlight
            function checkValidate() {
                let productNameValue = productNameEle.value;
                let typeIdValue = typeIdEle.value;
                let discountValue = discountEle.value;
                let productIdValue = productIdEle.value;
                let isCheck = true;

                // Kiểm tra trường firstname
                if (productNameValue == "") {
                    setError(productNameEle, "Product name can not be empty.");
                    isCheck = false;
                } else {
                    setSuccess(productNameEle);
                }


                //Kiểm tra trường price

                return isCheck;
            }

            function setError(ele, message) {
                let parentEle = ele.parentNode;
                parentEle.classList.add('error');
                parentEle.querySelector('small').innerText = message;
                parentEle.querySelector('small').style.color = "red"
            }

            function setSuccess(ele) {
                ele.parentNode.classList.add('success');
            }

        </script>
    </body>
</html>
