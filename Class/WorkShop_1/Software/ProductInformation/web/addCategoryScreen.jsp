<%-- 
    Document   : addCategoryScreen
    Created on : Jun 22, 2024, 3:21:21 PM
    Author     : NganNganchimte
--%>


<%@page import="controllers.IConstant"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE-edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <!-- Latest compiled and minified CSS -->
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
            />

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="newAccount.css" />
        <style>
            .header_button-icon {
                color: #212529;
                margin-right: 10px;
            }
            .header_button a {
                color: #212529;
            }
            .header_button ul {
                list-style-type: none;
                /*font-size: 16px;*/
            }
            .header_button ul li {
                display: inline;
                margin-left: 15px;
            }
            .header_button {
                text-align: right;
                margin-top: 10px;
                margin-right: 15px;
                font-size: 16px;
            }
        </style>
    </head>
    <body>
        <c:if test="${loginedAccount != null && modify == 0}">
            <jsp:forward page="MainController?action=home"/>
        </c:if>
        <header>
            <div class="header_button">
                <ul>
                    <li style="display: ${loginedAccount != null?"":"none"}">
                        <a href="MainController?action=logout"><span class="glyphicon glyphicon-log-out header_button-icon"></span>Sign out</a>
                    </li>
                </ul>
            </div>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="MainController?action=home"><strong style="font-size: 1.5em">WS1</strong></a>
                    </div>
                </div>
            </nav>
        </header>

        <div class="container">
            <h2>New category</h2>
            <form action="CategoryController?category=<%= IConstant.VALIDATION_CATEGORY%>" class="form-horizontal" method="post" accept-charset="UTF-8">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="categoryName">Category name</label>
                    <div class="col-sm-10 check-input">
                        <input
                            type="text"
                            class="form-control"
                            id="categoryName"
                            name="categoryName"
                            autocomplete="new-name"
                            placeholder="Name"
                            required
                            />
                        <small class="form-text"></small>
                        <c:if test="${ExistCategoryName != null}">
                            <small style="color: red">${ExistCategoryName}</small>
                        </c:if>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="memo">Memo</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="memo" placeholder="" style="width: 100%" rows="5"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="btn-newCategory" class="btn btn-success">Submit</button>
                    </div>
                </div>
            </form>
        </div>

        <script>
            const btnNewCategory = document.getElementById('btn-newCategory');
            const inputEles = document.querySelectorAll('.check-input');

            btnNewCategory.addEventListener('click', function () {
                Array.from(inputEles).map((ele) =>
                    ele.classList.remove('success', 'error'))
                let isValid = checkValidate();
                if (isValid) {
                    console.log(window.location.href);
                }
            });


            // Truy cập vào các ô input
            const categoryNameEle = document.getElementById('categoryName');

            // Validate dữ liệu trong các ô input và highlight
            function checkValidate() {
                let categoryNameValue = categoryNameEle.value;
                let isCheck = true;
                
                // Kiểm tra trường firstname
                if (categoryNameValue == '') {
                    setError(categoryNameEle, "Category name can not be empty.");
                    isCheck = false;
                } else {
                    setSuccess(categoryNameEle);
                }
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