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
  </head>
  <body>
    <div class="container">
      <h2>Add new account</h2>
      <form class="form-horizontal" action="#" method="post">
        <div class="form-group">
          <label class="control-label col-sm-2" for="account">Account</label>
          <div class="col-sm-10">
            <input
              type="text"
              class="form-control"
              name="account"
              placeholder="Enter email"
            />
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="pass">Password</label>
          <div class="col-sm-10">
            <input
              type="password"
              class="form-control"
              placeholder="Enter password"
              name="pass"
            />
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
            />
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="firstName"
            >First name</label
          >
          <div class="col-sm-10">
            <input
              type="text"
              class="form-control"
              name="firstName"
              placeholder="First name"
            />
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="phone">Phone number</label>
          <div class="col-sm-10">
            <input
              type="tel"
              class="form-control"
              name="phone"
              placeholder="Phone number"
            />
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="birthDay">Birth day</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" name="birthDay" />
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Gender</label>
          <div class="col-sm-10">
            <div class="form-check form-check-inline">
              <label class="gender-radio"
                ><input type="radio" name="gender" checked /> Male</label
              >
              <label class="gender-radio"
                ><input type="radio" name="gender" /> Female</label
              >
            </div>
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="role"
            >Role in system</label
          >
          <div class="col-sm-10">
            <select class="form-control" name="role">
              <option>Administrator</option>
              <option>Staff</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
              <label><input type="checkbox" name="isActive" />Is active</label>
            </div>
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Submit</button>
          </div>
        </div>
      </form>
    </div>
  </body>
</html>
