<%-- 
    Document   : ThemBanBe
    Created on : Jun 2, 2024, 6:26:47 PM
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
                <h1>Chức năng thêm bạn mới</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <img style="width: 100%" src="Images/addFriend.png" alt=""/>
            </div>
            <div class="col-md-8">
                <form action="addFriend" method="post">
                    <div class="form-group">
                        <label for="soDT">Phone:</label>
                        <input type="tel" class="form-control" name="soDT">
                    </div>
                    <div class="form-group">
                        <label for="hoTen">Full Name:</label>
                        <input type="text" class="form-control" name="hoTen">
                    </div>
                    <div class="form-check">
                        <label><input type="radio" name="gioiTinh" checked> Male</label>
                    </div>
                    <div class="form-check">
                        <label><input type="radio" name="gioiTinh"> Female</label>
                    </div>
                    <div class="form-group">
                        <label for="ngaySinh">Day Of Birth:</label>
                        <input type="date" class="form-control" name="ngaySinh">
                    </div>
                    <div class="form-group">
                        <label for="diaChi">Address:</label>
                        <input type="text" class="form-control" name="diaChi">
                    </div>
                    <div class="form-group">
                        <label for="loaiQuanHe">Type of Relationship:</label>
                        <div>
                            <select class="form-control" name="loaiQuanHe">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select> 
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ghiChu">Memo:</label>
                        <input type="text" class="form-control" name="ghiChu">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
