<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Check Password Strength</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script>
      function checkPasswordNotEmpty() {
          const passwordInput = document.querySelector('input[name="pass"]');
          const message = document.getElementById('passwordMessage');
          const password = passwordInput.value;

          if (password === '') {
              message.textContent = 'Password cannot be empty';
              message.style.color = 'red'
          } else {
              message.textContent = '';
          }
      }

      document.addEventListener('DOMContentLoaded', function() {
          const passwordInput = document.querySelector('input[name="pass"]');
          passwordInput.addEventListener('blur', checkPasswordNotEmpty);
      });
  </script>
</head>
<body>
  <form class="form-horizontal" action="RegisterServlet" method="post">
    <div class="form-group">
        <label class="control-label col-sm-2" for="account">Account</label>
        <div class="col-sm-10">
            <input
                type="text"
                class="form-control"
                name="account"
                placeholder="Enter username"
                requireds
                />
        </div>
    </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="pass">Password</label>
            <div class="col-sm-10">
                <input
                    type="password"
                    class="form-control"
                    placeholder="Enter password"
                    name="pass"
                    required
                />
                <small id="passwordMessage" class="form-text"></small>
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
                  requireds
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
      <c:if test="${loginedAccount != null && loginedAccount.rollInSystem == 1}">
          <div class="form-group">
              <label class="control-label col-sm-2" for="role"
                     >Role in system</label>
              <div class="col-sm-10">
                  <select class="form-control" name="role">
                      <option>Customer</option>
                      <option>Administrator</option>
                      <option>Staff</option>
                  </select>
              </div>
          </div>
      </c:if>
      <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-default" value="register" name="action">Submit</button>
          </div>
      </div>
  </form>
</body>
</html>
