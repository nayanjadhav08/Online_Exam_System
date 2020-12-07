<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    

    <title>Login Page</title>

    
	<link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    <style>
      .box{
        height: 70px;
        width: 70px;
        background: gray;
      }
    </style>

    <!-- Custom styles for this template -->
    <link href="dist/css/floating-labels.css" rel="stylesheet">
  </head>
  <body>

  <!-- check cookies for remember me -->
  <%
  	Cookie[] cookies=request.getCookies();
  	String userName = "", password = "",rememberVal="";
  	if (cookies != null) {
       for (Cookie cookie : cookies) {
         if(cookie.getName().equals("cookUserName")) {
           userName = cookie.getValue();
         }
         if(cookie.getName().equals("cookPassword")){
           password = cookie.getValue();
         }
         if(cookie.getName().equals("cookremember")){
           rememberVal = cookie.getValue();
         }
      }
  }	
  %>
  	
  
  
    <form class="form-signin" action="UserLoginServlet" method="post">
  <div class="text-center mb-4">
   
      <div class="mb-4 box mx-auto" style="align-content: center;"></div> 
      <h1 class="h3 mb-3 font-weight-normal">User Login</h1>
    
  </div>

  <div class="form-label-group">
    <input type="text" id="Username" name="username" class="form-control" value="<%=userName%>" placeholder="User Name" required autofocus>
    <label for="Username">User Name</label>
  </div>

  <div class="form-label-group">
    <input type="password" id="Password" name="password" class="form-control" value="<%=password%>" placeholder="Password" required>
    <label for="Password">Password</label>
  </div>

  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" name="rememberme" value="rememberMe" checked="checked" <%= (rememberVal.equals("rememberMe")) ? "checked=\"checked\"" : "" %> > Remember me
    </label>
  </div>
    <div >
  	<p style="color:red">${message}</p> 
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  
</form>
</body>
</html>
