<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<%@include file="Components/css.jsp"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>E-Commerce</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<style>
body {
	background-color: black;
}

.card-body {
	height: 250px; /* Set a fixed height for the card body */
}

.card-img-top {
	max-height: 100px; /* Limit the height of the product image */
	object-fit: contain;
}

.back-img {
	/* background: url("images/ecomerce.jpg"); */
	height: 50vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}

.card-ho:hover {
	background-color: #e7f2ef;
}
</style>
</head>
<body class="bg-light">
	<%@include file="Components/homeHeader.jsp"%>

	<%-- <p>Welcome ${user.username}</p> --%>



<div class="container mt-4">
    <div class="row">
        <div class="col-md-3">
            <div class="filter-section bg-light p-3 rounded">
                <h4 class="filter-heading mb-3">Filter</h4>

                <a href="/sortLowToHigh" class="btn btn-outline-success btn-block mb-2">Low-High</a>
                <a href="/sortHighToLow" class="btn btn-outline-success btn-block mb-3">High-Low</a>

                <form action="rangeSort" method="post" class="filter-form">
                    <div class="form-group">
                        <input type="text" name="lowPrice" id="lowPrice" required class="form-control form-control-lg" placeholder="Low Price*">
                    </div>
                    <div class="form-group">
                        <input type="text" name="highPrice" id="highPrice" required class="form-control form-control-lg" placeholder="High Price*">
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Apply" class="btn btn-primary btn-lg btn-block">
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-9">
            <div class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="images/ecomerce.jpg" class="d-block w-100" alt="Image 1">
                    </div>
                    <div class="carousel-item">
                        <img src="images/image2.jpg" class="d-block w-100" alt="Image 2">
                    </div>
                    <div class="carousel-item">
                        <img src="images/image3.jpg" class="d-block w-100" alt="Image 3">
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
















<br>

		<h2 class="text-center ">Ecommerce Services</h2>
	</div>


	<main>

		<div class="container mt-4">




			<div class="row">

				<c:forEach var="product" items="${products}">
					<div class="col-md-3">
						<div class="card mb-4">
							<img class="card-img-top" src="${product.image}" alt="Product 1">
							<div class="card-body">
								<b>
									<h4 class="card-title">${product.name}</h4>
								</b>
								<h5 class="card-text">Category: ${product.category.name}</h5>
								<h5 class="card-text">Price: ${product.price}</h5>
								<p class="card-text">Description: ${product.description}</p>





                                <c:set var="check" value="0" />

                                <c:forEach var="cart" items="${carts}">

                                    <c:choose>
                                        <c:when test="${cart.product.id eq product.id}">

                                            <c:set var="check" value="1" />


                                        </c:when>
                                    </c:choose>
                                </c:forEach>

                                <c:choose>
                                    <c:when test="${check eq 1}">

                                        <button class="btn btn-primary " disabled>In cart</button>

                                    </c:when>



                                <c:otherwise>



                                <c:choose>
                    <c:when test="${product.quantity > 0}">
                        <a href="<c:url value='/addToCart'/>?productId=${product.id}"
                            class="btn btn-primary" id="addToCartBtn${product.id}">Add to Cart</a>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-primary btn-outline-danger " disabled>OUT OF STOCK</button>
                    </c:otherwise>
                                </c:choose>
                                </c:otherwise>
                                </c:choose>
							</div>
						</div>
					</div>
				</c:forEach>



			</div>

		</div>
	</main>



	<footer>
		<div class="container">


			<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
				integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
				crossorigin="anonymous"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
				integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
				crossorigin="anonymous"></script>
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
				integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
				crossorigin="anonymous"></script>
</body>
</html>