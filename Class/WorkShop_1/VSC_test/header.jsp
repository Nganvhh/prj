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
      .header_login-icon {
        color: #212529;
      }
      .header_login a {
        color: #212529;
      }
      .header_login ul {
        list-style-type: none;
        font-size: 16px;
      }
      .header_login ul li {
        display: inline;
        margin-left: 15px;
      }
      .header_login {
        text-align: right;
        margin-top: 10px;
        margin-right: 15px;
      }
    </style>
  </head>
  <body>
    <div class="header_login">
      <ul>
        <li>
          <a href="#"
            ><span
              class="glyphicon glyphicon-user text-dark header_login-icon"
            ></span>
            Sign Up</a
          >
        </li>
        <li>
          <a href="#"
            ><span class="glyphicon glyphicon-log-in header_login-icon"></span>
            Login</a
          >
        </li>
      </ul>
    </div>
    <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#"
            ><strong style="font-size: 1.5em">WS1</strong></a
          >
        </div>
        <form class="navbar-form navbar-right" action="#">
          <div class="form-group has-feedback has-search">
            <input
              type="text"
              class="form-control"
              placeholder="Search"
            />
            <span
              class="glyphicon glyphicon-search form-control-feedback"
            ></span>
          </div>
        </form>
      </div>
    </nav>

  </body>
</html>
