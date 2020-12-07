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

    <title>Register</title>
</head>

<body>

    <div class="container">
        <div class="py-5 text-center">
            <div class="mx-auto" style="width: 75px ; height:75px; background-color: grey">
                <p>LOGO</p>
            </div>

            <h2>Registration form</h2>
<hr>
        </div>
        <form action="UserRegisterServlet" method="post">
            <div class="form-row" style="padding: 60px ; padding-top: 1px">
                <div class="form-group col-md-6">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName">
                </div>
                <div class="form-group col-md-6">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName">
                </div>
                
                <div class="form-group col-md-12">
                    <label for="userName">UserName</label>
                    <input type="text" class="form-control" id="userName" name="userName">
                </div>
                <div class="form-group col-md-12">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
         
           
           <div class="form-group col-md-4">
                    <label for="profile">Profile</label>
                    <select id="profile" class="form-control" name="profile">
                        <option selected>Choose...</option>
                        <option value="student">Student</option>
                        <option value="teacher">Teacher</option>
                    </select>
                    <br>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
           <hr>
            
            <br>
            <hr>
        </form>


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