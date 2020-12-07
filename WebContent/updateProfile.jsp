<%@page import="java.io.PrintWriter"%>
<%@page import="com.vwits.model.OESUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">

<title>Result</title>



<!-- Bootstrap core CSS -->
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

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="dist/css/dashboard.css" rel="stylesheet">
<script src="https://unpkg.com/feather-icons"></script>
</head>


<body>

	<%
		//acess session 

	session = request.getSession();
	OESUser user = (OESUser)session.getAttribute("currentSessionUser");
	if (session != null && user != null) {
		//set user 
		user = (OESUser) session.getAttribute("currentSessionUser");
	} else { //sesion not available 
		RequestDispatcher r = request.getRequestDispatcher("login.jsp");
		r.forward(request, response);
	}

	out.println("user :" + user.getFirstname());
	System.out.println("user : " + user.getFirstname());
	%>

	<nav
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Online
			Exam System</a>
		<h5 style="color: green;">Hello <%= user.getFirstname()%> !!</h5>
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><a class="nav-link"
				href="Logout">Sign out</a></li>
		</ul>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="sidebar-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link active"
							href="studentHomeServlet"> <span data-feather="home"></span>
								Dashboard
						</a></li>
						<li class="nav-item"><a class="nav-link " href="#"> <span
								data-feather="file-text"></span> Result Reports
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="user"></span> My Profile
						</a></li>

					</ul>

				</div>
			</nav>

			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2"></h1>
				</div>

				<h2>Update Profile</h2>
		
				<h2 style="color:green"> ${msg} </h2>


				<div class="container">
					<div class="py-5 text-center">
						<div class="mx-auto"
							style="width: 75px; height: 75px; background-color: grey">
							<p>LOGO</p>
						</div>

						<h2>Update Profile</h2>
						<hr>
					</div>


					<form action="updateProfileServlet" method="post">
						<div class="form-row" style="padding: 60px; padding-top: 1px">
							<div class="form-group col-md-6">
								<label for="userId">User ID :</label> <input type="text"
									class="form-control" id="userId" name="userId"
									value="<%= user.getId()%>" disabled>
							</div>
							<input type = "hidden" name = "userId" 	value="<%= user.getId()%>" >
							<div class="form-group col-md-6">
								<label for="firstName">First Name</label> <input type="text"
									class="form-control" id="firstName" name="firstName"
									value="<%= user.getFirstname()%>">
							</div>
							<div class="form-group col-md-6">
								<label for="lastName">Last Name</label> <input type="text"
									class="form-control" id="lastName" name="lastName"
									value="<%=user.getLastname()%>">
							</div>

							<div class="form-group col-md-12">
								<label for="userName">UserName</label> <input type="text"
									class="form-control" id="userName" name="userName"
									value="<%=user.getUsername()%>">
							</div>
							<div class="form-group col-md-12">
								<label for="password">Password</label> <input type="password"
									class="form-control" id="password" name="password"
									value="<%=user.getPassword()%>">
							</div>


							<div class="form-group col-md-4">
								<label for="profile">Profile</label> <input id="profile"
									class="form-control" name="profile"
									value="<%=user.getProfile()%>" disabled>
									<br>
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
							<hr>

							<br>
							<hr>
							</div>
					</form>


				</div>



				<!-- //exam loop end -->
			</main>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
	<script src="/dist/js/bootstrap.js"></script>

	<script>
		feather.replace()
	</script>
</body>

</html>