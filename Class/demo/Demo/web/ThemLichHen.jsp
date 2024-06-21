<%-- 
    Document   : ThemLichHen
    Created on : Jun 2, 2024, 8:17:53 PM
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
                <h1>Chức năng thêm lịch hẹn mới!</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <img src="Images/addAppointment.png" alt=""/>
            </div>
            <div class="col-md-8">
                <form action="addAppointment" method="post">
                    <div class="form-group">
                        <label for="account">Account name:</label>
                        <input type="text" class="form-control" name="account">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
