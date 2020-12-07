<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.vwits.db.ResultDataDAO"%>
<%@page import="com.vwits.model.Result_Data" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	
	 import="java.util.*"%>


<%@
    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html lang="en">

<head>
	<!-- Required meta tags -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta charset="ISO-8859-1">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
		integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

	<title>All Exams Available</title>
</head>

<body>
<%! int count=0; %>
	<%
	
		List<Result_Data> allRes = (List<Result_Data>)ResultDataDAO.getAllResults()  ;
		response.setContentType("text/html") ;
		
	
	%>
	<div class="container">
		<div class="py-5 text-center">

			<h2>All RESULTS </h2>
			<hr>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">User_ID</th>
					<th scope="col">Obtained Mr</th>
					<th scope="col">Max_Marks</th>
					<th scope="col">Exam ID</th>
					
				</tr>
			</thead>
				

			<tbody>
			
				<c:forEach var="event" items="<%=allRes %>">
					
					<tr>
						<th scope="row">${event.getId()}</th>
						<td>${event.getUserId()}</td>
						<td>${event.getObtainedMarks()}</td>
						<td>${event.getTotalMarks()}</td>
						<td>${event.getExamId()}</td>
						
					</tr>
				</c:forEach>

			</tbody>
		</table>
	
	<hr>
	<a class="btn btn-primary" href="teacherHome.jsp" role="button">Home</a>
		<div></div>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
		integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
		crossorigin="anonymous"></script>

</body>

</html>