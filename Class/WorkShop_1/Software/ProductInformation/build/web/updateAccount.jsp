<%-- 
    Document   : registerScreen
    Created on : Jun 18, 2024, 12:33:46 PM
    Author     : NganNganchimte
--%>

<%@page import="java.sql.Date"%>
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
        <jsp:include page="header.jsp"/>
        <div class="container">
            <h2>Update account</h2>
            <form action="MainController?action=validationAccount&behaviour=update" class="form-horizontal" method="post" accept-charset="UTF-8">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="account">Username</label>
                    <div class="col-sm-10 check-input">
                        <input
                            type="text"
                            class="form-control"
                            id="username"
                            name="account"
                            placeholder="Username"
                            value="<c:out value="${updatedAccount.account}"/>"
                            readonly
                            required
                            />
                        <input type="hidden" name="account" value="<c:out value="${updatedAccount.account}"/>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="pass">Password</label>
                    <div class="col-sm-10 check-input">
                        <input
                            type="password"
                            disabled
                            class="form-control"
                            id="password"
                            placeholder="Password"
                            name="pass"
                            value="${updatedAccount.pass}"
                            required
                            />
                        <input type="hidden" name="pass" value="${updatedAccount.pass}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="confirm">Confirm Password</label>
                    <div class="col-sm-10 check-input">
                        <input
                            type="password"
                            class="form-control"
                            disabled
                            id="confirm-password"
                            placeholder="Confirm password"
                            name="confirm"
                            value="${updatedAccount.pass}"
                            required
                            />
                        <input type="hidden" name="confirm" value="${updatedAccount.pass}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="lastName">Last name</label>
                    <div class="col-sm-10">
                        <input
                            type="text"
                            class="form-control"
                            name="lastName"
                            placeholder="Last name"
                            value="<c:out value="${updatedAccount.lastName}"/>"
                            id="lastname"
                            />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="firstName">First name</label>
                    <div class="col-sm-10 check-input">
                        <input
                            type="text"
                            class="form-control"
                            id="firstname"
                            name="firstName"
                            placeholder="First name"
                            value="<c:out value="${updatedAccount.firstName}"/>"
                            required
                            />
                        <small class="form-text"></small>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="phone">Phone number</label>
                    <div class="col-sm-10">
                        <input
                            type="tel"
                            class="form-control"
                            id="phone"
                            name="phone"
                            placeholder="Phone number"
                            value="<c:out value="${updatedAccount.phone}"/>"
                            />
                        <c:if test="${ErrorPhoneFormat != null}">
                            <small style="color: red">${ErrorPhoneFormat}</small>
                        </c:if>
                    </div>
                </div>
                <div class="form-group">

                    <label class="control-label col-sm-2" for="birthDay">Birth day</label>
                    <div class="col-sm-10">
                        <input id="dob" type="date" class="form-control" value="${updatedAccount.birthDay}" name="birthDay" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="gender">Gender</label>
                    <div class="col-sm-10">
                        <div class="form-check form-check-inline">
                            <label class="radio-inline"><input type="radio" name="gender" value="1" ${updatedAccount.gender == true?"checked":""} /> Male</label                            >
                            <label class="radio-inline"><input type="radio" name="gender" value="0" ${updatedAccount.gender == false?"checked":""} /> Female</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="isUse">Is Active</label>
                    <div class="col-sm-10">
                        <div class="form-check form-check-inline">
                            <label class="radio-inline"><input type="radio" name="isUse" value="1" ${updatedAccount.isUse == true?"checked":""}/> Yes</label>
                            <label class="radio-inline"><input type="radio" name="isUse" value="0" ${updatedAccount.isUse == false?"checked":""}/> No</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="role"
                           >Role in system</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="role">
                            <option ${(updatedAccount.roleInSystem == 0)? "selected":""}>Customer</option>
                            <option ${(updatedAccount.roleInSystem == 1)? "selected":""}>Administrator</option>
                            <option ${(updatedAccount.roleInSystem == 2)? "selected":""}>Staff</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="btn-register" class="btn btn-danger">Cancel</button>
                        <button type="submit" id="btn-register" class="btn btn-success">Save</button>
                    </div>
                </div>
            </form>
        </div>

        <script>
            function checkModification() {

            }

            const btnRegister = document.getElementById('btn-register');
            const inputEles = document.querySelectorAll('.check-input');

            btnRegister.addEventListener('click', function () {
                Array.from(inputEles).map((ele) =>
                    ele.classList.remove('success', 'error'))
                let isValid = checkValidate();
                if (isValid) {
                    console.log(window.location.href);
                }
            });


            // Truy cập vào các ô input
            const userEle = document.getElementById('username');
            const passEle = document.getElementById('password');
            const confirmEle = document.getElementById('confirm-password');
            const firstnameEle = document.getElementById('firstname');

            // Validate dữ liệu trong các ô input và highlight
            function checkValidate() {
                let userValue = userEle.value;
                let passValue = passEle.value;
                let confirmValue = confirmEle.value;
                let firstnameValue = firstnameEle.value;
                let isCheck = true;
                // Kiểm tra trường account
                if (userValue == '') {
                    setError(userEle, "Username can not be empty.");
                    isCheck = false;
                } else {
                    setSuccess(userEle);
                }

                // Kiểm tra trường password
                if (passValue == '' || confirmValue == '') {
                    if (passValue == '') {
                        setError(passEle, "Password can not be empty.");
                        isCheck = false;
                    } else {
                        setError(confirmEle, "Confirm your password.");
                        isCheck = false;
                    }
                } else {
                    if (passValue == confirmValue) {
                        setSuccess(passEle);
                        setError(confirmEle);
                    }
                }

                // Kiểm tra trường firstname
                if (firstnameValue == '') {
                    setError(firstnameEle, "First name can not be empty.");
                    isCheck = false;
                } else {
                    setSuccess(firstnameEle);
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

