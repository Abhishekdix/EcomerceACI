<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up - Admin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <style>
        body {
            background-color: #f2f2f2;
        }

        .txt-colr {
            color: #7b1fa2;
        }

        .jumbotron {
            background-color: #7b1fa2;
            color: #fff;
            padding: 2rem 0;
        }

        .jumbotron h1 {
            font-size: 3rem;
            font-weight: bold;
            margin-bottom: 1rem;
        }

        .jumbotron hr {
            background-color: #fff;
            margin: 2rem auto;
        }

        .jumbotron p {
            font-size: 1.2rem;
        }

        .form-container {
            max-width: 500px;
            margin: auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }

        .form-container h3 {
            margin-top: 10px;
            color: #7b1fa2;
        }

        .form-container p {
            margin-bottom: 20px;
        }

        .form-container .form-group label {
            font-weight: bold;
            color: #7b1fa2;
        }

        .form-container .form-group input.form-control-lg {
            border-color: #7b1fa2;
        }

        .form-container .form-group textarea.form-control-lg {
            resize: vertical;
            border-color: #7b1fa2;
        }

        .form-container .form-group .linkControl {
            margin-top: 10px;
        }

        .form-container .form-group .btn-primary {
            background-color: #7b1fa2;
            border-color: #7b1fa2;
        }

        .form-container .form-group .btn-primary:hover {
            background-color: #660e8a;
            border-color: #660e8a;
        }
    </style>
</head>

<body class="bg-white">

<%@include file="Components/design.jsp"%>
<div class="container-fluid" style="height: 10px; background-color: #7b1fa2;"></div>

<div class="container-fluid p-3">

    <div class="row">
        <div class="col-md-3 txt-colr">
            <h3>
                <i class="fa-solid fa-cart-shopping fa-beat"></i>
                Ecommerce ACI
            </h3>
        </div>
        <div class="container-fluid" style="height: 10px; background-color: #7b1fa2;"></div>
    </div>

    <br>
    <div class="form-container">
        <div class="col-sm-12">
            <h3>Admin passcode</h3>

            <form action="verify" method="post">
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control form-control-lg" required placeholder="Password*"
                           required name="password" id="password">
                </div>


                <input type="submit" value="Verify" class="btn btn-primary btn-block"><br>

            </form>
        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
</body>

</html>
