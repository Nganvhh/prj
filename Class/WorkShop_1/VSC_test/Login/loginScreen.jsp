<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto+Mono:ital,wght@0,100..700;1,100..700&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="login.css" />
  </head>
  <body>
    <header>
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#"
              ><strong style="font-size: 1.5em">WS1</strong></a
            >
          </div>
        </div>
      </nav>
    </header>

    <div class="login_wrapper">
      <form action="#" method="post">
        <div class="img_container">
          <img
            src="/Images/loginBackground.png"
            class="login_icon"
            alt="Background Login"
          />
        </div>
        <div class="">
          <h2>Log in</h2>
        </div>
        <div class="form-group">
          <input
            class="form-control"
            type="text"
            placeholder="Username"
            name="account"
            required
          />
        </div>
        <div class="form-group">
          <input
            class="form-control"
            type="password"
            placeholder="Password"
            required
          />
        </div>
        <div class="remember-forgot">
          <label><input type="checkbox" name="remember" />Remember me</label>
        </div>
        <button type="submit" class="btn">Đăng nhập</button>
      </form>
    </div>
  </body>
</html>
