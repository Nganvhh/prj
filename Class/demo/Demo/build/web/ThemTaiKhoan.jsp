<%-- 
    Document   : ThemTaiKhoan
    Created on : Jun 1, 2024, 7:51:29 AM
    Author     : NganNganchimte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Chức năng thêm tài khoản mới</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <img src="Images/addAccount.png" alt=""/>
            </div>
            <div class="col-md-8">
                <form action="MainController" method="post">
                    <div class="form-group">
                        <label for="account">Account name:</label>
                        <input type="text" class="form-control" name="account">
                    </div>
                    <div class="form-group">
                        <label for="pass">Password:</label>
                        <input type="password" class="form-control" name="pass">
                    </div>
                    <div class="form-group">
                        <label for="fullName">Full name:</label>
                        <input type="text" class="form-control" name="fullName">
                    </div>
                    <div class="form-group">
                        <label for="birthDay">Birth day:</label>
                        <input type="date" class="form-control" name="birthDay">
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="gender"> Male</label>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone:</label>
                        <input type="tel" class="form-control" name="phone">
                    </div>
                    <div class="form-group">
                        <label for="addr">Address:</label>
                        <input type="text" class="form-control" name="addr">
                    </div>
                    <div class="form-group">
                        <label for="memo">Memo:</label>
                        <input type="text" class="form-control" name="memo">
                    </div>
                    <button type="submit" class="btn btn-default" value="register" name="action">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
