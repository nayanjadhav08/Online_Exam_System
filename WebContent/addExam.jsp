<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<title>Add exam</title>
</head>

<body>

	<div class="container">
		<div class="py-5 text-center">

			<h2>Add New Exam/Subject</h2>
			<hr>
		</div>
		
		<form action="addExamServlet" method="post">
			<div class="form-row" style="padding: 60px; padding-top: 1px">
				<div class="form-group col-md-6">
					<label for="examName">Exam Name</label> <input type="text"
						class="form-control" id="examName" name="examName">
				</div>
				<div class="form-group col-md-6">
					<label for="totalMark">total Mark</label> <input type="text"
						class="form-control" id="totalMark" name="totalMark">
				</div>

				<div class="form-group col-md-4">

					<br>
					<button type="submit" class="btn btn-primary">Add Exam</button>
				</div>
				<hr>

				<br>
				<hr>
				</div>
		</form>


	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
		integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
		crossorigin="anonymous"></script>

</body>

</html>