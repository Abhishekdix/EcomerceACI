<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-commerce ACI</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <style>
        body {
            background-color: #f8f9fa;
        }

        .navbar {
            background-color: #7b1fa2;
        }

        .navbar-brand {
            font-size: 24px;
        }

        .nav-link {
            color: white;
            font-size: 18px;
        }

        .nav-link:hover {
            background-color: white;
            color: #7b1fa2;
            border-radius: 15px;
        }

        .txt-colr {
            color: #7b1fa2;
        }

        .btn-regbtn {
            background-color: #ab47bc;
        }

        .carousel-item img {
            height: 50vh;
            width: 100%;
            object-fit: cover;
        }

        .btnset {
            margin-left: auto;
        }

        .search-form {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .search-input {
            flex: 1;
            margin-right: 10px;
        }
        
        .navbar .nav-item:hover .nav-link {
	background-color: white;
	color: #7b1fa2;
	border-radius: 15px;
}
    </style>
</head>
<body>
    <div class="container-fluid bg-custome">
    <div class="container">
        <div class="row align-items-center py-3">
            <div class="col-md-5 txt-colr">
                <h3><i class="fa-solid fa-cart-shopping fa-beat"></i> E-commerce ACI</h3>
            </div>
            <div class="col-md-4">
                <form action="search" method="post" class="search-form">
                    <div class="form-group search-input">
                        <input type="text" name="search" id="search" placeholder="Search*" required class="form-control form-control-lg">
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Search" class="btn btn-primary btn-lg">
                    </div>
                </form>
            </div>
            <div class="col-md-3 text-right d-flex align-items-center">
                <p class="my-0 mr-2"><strong style="font-size:17px;">Welcome ${user.username }</strong></p>
                <a href="/logout" class="btn btn-outline-danger">Logout</a>
            </div>
        </div>
    </div>
</div>



    <nav class="navbar navbar-expand-lg navbar-dark bg-custome">
        <div class="container">
            <a class="navbar-brand" href="/"><i class="fa-solid fa-house"></i></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse navdiv"
			id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/UserHome">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="#">Features</a></li>

				<li class="nav-item active"><a class="nav-link " href="/cart">Cart</a>
				</li>
			</ul>
			<div class="btnset">
				
				<button class="btn btn-light my-2 my-sm-0 float-right" type="submit">
					<i class="fa-solid fa-phone"></i>Contact Us
				</button>
			</div>
		</div>
        </div>
    </nav>


    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>
