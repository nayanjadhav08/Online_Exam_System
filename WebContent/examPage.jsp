<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.vwits.model.Question"
    import="java.util.*"
%>

<%@
    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
%>

<!doctype html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">

<title>Exam Page</title>



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
		List<Question> questionBank = (List<Question>) request.getAttribute("questionBank");
	
		request.setAttribute("questionBank", questionBank) ;
        int count =1; 
	%>

	<nav
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Online
			Exam System</a>
		<h5 style="color: honeydew;"> ${examName}  </h5>
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
						<li class="nav-item"><a class="nav-link " href="#">
								<span data-feather="home"></span> Dashboard
                        </a></li>
                        <li class="nav-item"><a class="nav-link active" href="#">
								<span data-feather="airplay"></span> Exam
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
                    <div class="col-md-6">
                        <h3 class="h3">  ${examName}   </h3>
                    </div>
                    <div class="col-md-6">
                            <h4  style="text-align: right">Total Marks : ${totalMarks}   </h4>
                    </div>
				</div>

				<h2>Questions</h2>

				<!-- //exam loop -->
				<!--  var - store result of if loop || test - condition || scope - Scope of the variable to store the condition's result -->
				<c:if test="${questionBank.size() == 0}" var="event" scope="session">
					<h4 style="color: red">Currently No Question in System Please Contact to teacher.
						</h4>
				</c:if>



				  <div>
				  <form action="submitTestServlet" method="post">
					<c:forEach var="event" items="${questionBank}">
						
						<div class="form-group">
						<div class="row">
							<br> 
							<!-- exam card -->
							<!-- exam DS : id, examname ,totalmarks ,examcode  -->	
							  <div class="container" style="background-color: rgb(214, 214, 214);">
									<!-- //exam cards to display -->
									<div class="card">
										 <c:set var = "count" scope = "request" value = "${count+1}"/>
										 
										<div class="card-header">Question No : ${count}  </div>
										
										<div class="card-body">
                                            <h5 class="card-title">${event.getQuestion()}</h5>
                                            <br>
                                          
                                            <input id ="op1" type="radio" name="${count}_option"  value="1">
											<label for="op1">${event.getOption1()}</label><br>
											<input id ="op2" type="radio" name="${count}_option"  value="2">
											<label for="op2">${event.getOption2()}</label><br>
											<input id ="op3" type="radio" name="${count}_option"  value="3">
											<label for="op3">${event.getOption3()}</label><br>
											<input id ="op4" type="radio" name="${count}_option"  value="4">
											<label for="op4">${event.getOption4()}</label><br>
											<p class="card-text">Marks : ${event.getMark()}</p>
											<!-- <a href="#" class="btn btn-primary">Submit</a> -->
										</div>
									</div>
								</div> 
						
							<!-- end exam card -->					
						  </div>
						  </div>
					</c:forEach>
					
					<!-- <input id="submitBt" type="submit" value="submit">
					<label for="submitBt">Submit Test</label> -->
					<hr>
					<button type="submit" class="btn btn-primary" style="text-align: right">Submit Test</button>	
					<br>
					<hr>
					<br>
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