<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>JSP Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="Styles/login.css" rel="stylesheet" type="text/css" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    
    <style>
      

.sidebar {
  position: fixed;
  left: 20px;
  top: 130px;
  background: #fff;
  width: 180px;
  z-index: 200;
  border-radius: 5px;
  padding: 13px 8px;
}

.sidebar_link {
  cursor: pointer;
  border-radius: 5px;
  padding: 5px;
  display: block;
  margin-bottom: 10px;
  text-decoration: none !important;
  /* background-color: aqua; */
  padding: 10px;
}

.sidebar_link:hover {
  background-color: #E6E6E6;
}

.sidebar_link{
  font-size: 15px;
  color: #212529;
}

.sidebar_title {
  font-size: 18px;
  padding-left: 10px;
  border-bottom-style: solid;
  border-bottom-width: 1px;
  border-bottom-color: #e4e9ef;
  display: block;
}
body{
  background-color: #F5F5FA;
}
@media screen and (max-width:768px) {
  .sidebar{
    top: 204px;
  }
}
    </style>
  </head>
  <body>
    <nav class="sidebar">
      <div>
        <div class="sidebar_title">
          <strong>Danh mục</strong>
        </div>
        <a class="sidebar_link" href="#">
          Dụng cụ nhà bếp
        </a>
        <a class="sidebar_link" href="#">
          Điện gia dụng
        </a>
        <a class="sidebar_link" href="#">
          Trang trí nội thất
        </a>
        <a class="sidebar_link" href="#">
          Dụng cụ thể thao
        </a>
        <a class="sidebar_link" href="#">
          Thiết bị thông minh
        </a>
        <a class="sidebar_link" href="#">
          Quần - Áo thời trang
        </a>
      </div>
  </nav>
  </body>
</html>
