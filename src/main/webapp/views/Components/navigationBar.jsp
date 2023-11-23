<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />




<style>

.bg-custome {
	background-color: #7b1fa2;
}

.btn-regbtn {
	background-color: #ab47bc;
}

.navbar .nav-item:hover .nav-link {
	background-color: white;
	color: #7b1fa2;
	border-radius: 15px;
}

.txt-colr {
	color: #7b1fa2;
}

.btnset {
	margin-left: 75%;
}


</style>

</head>
<body>
	<div class="container-fluid "
		style="height: 10px; background-color: #7b1fa2"></div>



	<div class="container-fluid p-3">

		<div class="row">
			<div class="col-md-6 txt-colr">

				<h3>
					<i class="fa-solid fa-cart-shopping fa-beat"></i>
					E-commerce ACI
				</h3>
			</div>
			<div class="col-md-3">
			<form action="searchIndex" method="post">
                <div class="form-group">
                    
                   <div class="input-group">
  <input type="text" name="search" id="search" placeholder="Search*" required class="form-control form-control-lg">
  
  <div class="input-group-append">
  
                    <input type="submit" value="Search" class="btn btn-primary btn-block">
  </div>
</div>
                    
                </div>
                </form>

			</div>
			
			
			
			<div class="col-md-3">
				
				<a href="/login" class="btn btn-outline-success my-2 my-sm-2">Login</a>

				<a href="/register" class="btn btn-outline-secondary">Register</a>

			</div>

		</div>

	</div>



	<nav class="navbar navbar-expand-lg navbar-dark bg-custome">
		<a class="navbar-brand" href="/"><i
			class="fa-solid fa-house "></i></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>



		<div class="collapse navbar-collapse navdiv"
			id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="#">Features</a></li>

				<li class="nav-item active"><a class="nav-link " href="#">About</a>
				</li>
			</ul>
			<div class="btnset">
				
				<button class="btn btn-light my-2 my-sm-0 float-right" type="submit">
					<i class="fa-solid fa-phone"></i>Contact Us
				</button>
			</div>
		</div>
	</nav>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
		integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
		crossorigin="anonymous"></script>




</body>
</html>