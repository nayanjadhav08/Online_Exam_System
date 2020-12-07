<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.vwits.model.Exam"
	import="java.util.*"%>
<%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">

<title>Dashboard</title>



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
		List<Exam> allExams = (List<Exam>) request.getAttribute("allExams");
		
	%>

	<nav
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Online
			Exam System</a>
		<h5 style="color: honeydew;">Welcome ${username} !!</h5>
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
						<li class="nav-item"><a class="nav-link active" href="#">
								<span data-feather="home"></span> Dashboard
						</a></li>
						<li class="nav-item"><a class="nav-link " href="allResultStudent"> <span
								data-feather="file-text"></span> Result Reports
						</a></li>
						<li class="nav-item"><a class="nav-link" href="updateProfile.jsp"> <span
								data-feather="user"></span> My Profile
						</a></li>

					</ul>

				</div>
			</nav>

			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Dashboard</h1>
				</div>

				<h2>Available Exams</h2>

				<!-- //exam loop -->
				<!--  var - store result of if loop || test - condition || scope - Scope of the variable to store the condition's result -->
				<c:if test="${allExams.size() == 0}" var="event" scope="session">
					<h4 style="color: green">Currently No Exams in Your Schedule.
						Enjoy !!</h4>
				</c:if>

				  <div class="row">
					<c:forEach var="event" items="${allExams}">
						<div class="col-md-12">
							<br> 
							<!-- exam card -->
							<!-- exam DS : id, examname ,totalmarks ,examcode  -->
	
							  <div class="container" style="background-color: rgb(214, 214, 214);">
									<!-- //exam cards to display -->
									<div class="card">
										<div class="card-header">Test No : ${event.getId()}</div>
										<div class="card-body">
											<h5 class="card-title">${event.getExamname()}</h5>
											<p class="card-text">Total Marks : ${event.getTotalmarks()}</p>
											<a href="loadExamServlet?examId=${event.getId()}&totMark=${event.getTotalmarks()}&examName=${event.getExamname()}" class="btn btn-primary">Start Test</a>
										</div>
									</div>
								</div> 
						
							<!-- end exam card -->					
						  </div>
					</c:forEach>
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