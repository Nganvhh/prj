<%-- 
    Document   : hinhtron
    Created on : May 11, 2024, 1:15:19 AM
    Author     : NganNganchimte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Circle calculation</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style type="text/css">
            .giua{text-align: center;}
        </style>
    </head>
    <body class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="alert alert-info giua">
                    Circle calculation
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8">
                <form method="post" action="CircleCal">
                    <div class="form-group">
                        <label for="radius">Radius:</label>
                        <input type="text" class="form-control" name="radius">
                    </div>

                    <button type="submit" class="btn btn-success">Calculate</button>
                    <div>
                        <!--expression language: ngon ngu bieu thuc-->
                        <%=request.getAttribute("result") %>
                        <!--request duoc goi la implicit setup: bien pho bien hay dung dc khai bao san-->
                    </div>
                </form>
            </div>
            <div class="col-md-4">
                <img src="images/circle.png" alt="" class="img-responsive"/>
            </div>
        </div>
    </body>
</html>
