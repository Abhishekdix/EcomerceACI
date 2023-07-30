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
<title>Cart</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<%@include file="Components/css.jsp"%>
     <style>
     
     .txt-colr {
	color: #7b1fa2;
}
     </style>
</head>
<body class="bg-light">
	<%@include file="Components/design.jsp"%>
 <div class="container-fluid "
		style="height: 10px; background-color: #7b1fa2"></div>
		
	<div class="container-fluid p-3">

		<div class="row">
			<div class="col-md-3 txt-colr">

				<h3>
					<i class="fa-solid fa-cart-shopping fa-beat"></i>
					Ecomerce ACI
				</h3>
			</div>

<div class="container-fluid "
		style="height: 10px; background-color: #7b1fa2"></div>



	


















	



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
								Quantity:
								<input type="number" min="1" max="${product.quantity}" value="1" onkeydown="return false;">
								<%-- <a href="<c:url value='/addToCart'/>?productId=${product.id}"
									class="btn btn-primary">Add to Cart</a> --%>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
		<form action="placeOrder" method="post">
                <div class="form-group">
                    
                    <input type="submit" value="Place Order" class="btn btn-primary btn-block">
                </div>
                </form>
		
		
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