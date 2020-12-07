<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta charset="ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>teacher home</title>
    <style>
        .btn{
            padding: 20px;
            margin: 10px ;
        }
    </style>
</head>

<body>
<br>
	            <a class="btn btn-primary btn-sm" style="padding: 5px ; margin: 5px" href="Logout" role="button">Logout</a>
    <div class="mx-auto">
        <h3 style="text-align: center;"> Welcome Prof.  !! </h3>
        <hr>
    </div>
	<div class="container">
        <div class="row col-md-12">
             <div class="col-md-11 mx-auto">
                <a class="btn btn-primary" href="addExam.jsp" role="button">Add Exam</a>
                <a class="btn btn-primary" href="allExams.jsp" role="button">All Exams</a>
                <a class="btn btn-primary" href="#" role="button">Add Questions</a>
                <a class="btn btn-primary" href="allQuestions" role="button">All Questions</a>
                <a class="btn btn-primary" href="allResults.jsp" role="button">All Results</a>
                <a class="btn btn-primary" href="updateProfile.jsp" role="button">Update Profile</a>
            </div>   
        </div>
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