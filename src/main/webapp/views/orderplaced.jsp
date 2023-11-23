<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Order Placed</title>
    <%@include file="Components/css.jsp"%>
    <style>
        body {
            background-color: #f8f9fa;
            color: #333;
        }

        .header {
            background-color: #7b1fa2;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        .ecommerce-logo {
            font-size: 32px;
        }

        .container-fluid .separator {
            height: 10px;
            background-color: #7b1fa2;
        }

        .order-container {
            text-align: center;
            margin-top: 50px;
        }

        .order-image {
            max-width: 100%;
            max-height: 200px;
        }

        .order-message {
            font-size: 24px;
            font-weight: bold;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <%-- Header --%>
    <div class="header">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="ecommerce-logo">Ecomerce ACI</h3>
                </div>
            </div>
        </div>
    </div>

    <%-- Separator --%>
    <div class="container-fluid separator"></div>

    <%-- Order Placed Content --%>
    <div class="container order-container">
        <div class="row">
            <div class="col-md-12">
                <img src="images/delivery.gif" alt="Animated GIF" class="order-image">
                <h1 class="order-message">Order is Placed</h1>
            </div>
        </div>
    </div>


    <!-- Include the script for redirection -->
    <script>
        // Set the time delay (in milliseconds) before redirection (e.g., 5000ms = 5 seconds)
        const delayTime = 5000;

        // Function to redirect after the specified time delay
        function redirect() {
            window.location.href = "UserHome"; // Replace with the URL of your target page
        }

        // Call the redirect function after the specified delay
        setTimeout(redirect, delayTime);
    </script>
</body>
</html>







<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
