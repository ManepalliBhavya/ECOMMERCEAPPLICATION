<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Details</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />

<link rel="stylesheet" href="style.css">

<style>
.small-img-group {
	display: flex;
	justify-content: space-between;
}

.small-img-col {
	flex-basis: 24%;
	cursor: pointer;
}

.sproduct select {
	display: block;
	padding: 5px 10px;
}

.sproduct input {
	width: 50px;
	height: 40px;
	padding-left: 10px;
	font-size: 16px;
	margin-right: 10px;
}

.sproduct input:focus {
	outline: none;
}

.buy-btn {
	background: #fb774b;
	opacity: 1;
	transition: 0.3s all;
}

.footer-colour {
	background-color: #212529;
}
</style>
</head>

<body>
	<!-- NAVIGATION -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-white py-3 fixed-top">
		<div class="container">
			<img src="img/logo3.png" alt="">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span><i id="bar" class="fas fa-bars"></i></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link active">
							${sessionScope.username}</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section class="container sproduct my-5 pt-5">
		<div class="row mt-5">
			<div class="col-lg-5 col-md-12 col-12">
				<a
					href="${pageContext.request.contextPath }/productdetails/${product.id }"><img
					src="/uploads/${product.fileName}" /></a>

				<div class="small-img-group">
					<div class="small-img-col">
						<img src="/uploads/${product.fileName}" width="100%"
							class="small-img" alt="" />
					</div>
					<div class="small-img-col">
						<img src="img/shop/24.jpg" width="100%" class="small-img" alt="">
					</div>
					<div class="small-img-col">
						<img src="img/shop/25.jpg" width="100%" class="small-img" alt="">
					</div>
					<div class="small-img-col">
						<img src="img/shop/26.jpg" width="100%" class="small-img" alt="">
					</div>
				</div>
			</div>

			<div class="col-lg-6 col-md-12 col-12">
				<h1>${product.proName}</h1>
				<h2>Rs.${product.price}</h2>

			 <input type="number" value="1"> <a
					href="${pageContext.request.contextPath }/welcomeOrderPage/${product.id }">PlaceOrder</a>
				<h4 class="mt-5 mb-4">Product Description</h4>
				<p>${product.proDesc}</p>
			</div>
		</div>
	</section>

	<div class=footer-colour>
		<footer class="mt-5 py-5">
			<div class="row container mx-auto pt-5">
				<div class="footer-one col-lg-3 col-md-6 col-12">
					<img src="img/logo3.png" alt="">
					<p class="pt-3">Welcome To HCL Ecom Website.</p>
				</div>
				<div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
					<h5 class="pb-2">Featured</h5>
					<ul class="text-uppercase list-unstyled">
						<li><a href="#">men</a></li>
						<li><a href="#">women</a></li>
						<li><a href="#">boys</a></li>
						<li><a href="#">girls</a></li>
						<li><a href="#">new arrivals</a></li>
						<li><a href="#">shoes</a></li>
						<li><a href="#">clothes</a></li>
					</ul>
				</div>
				<div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
					<h5 class="pb-2">Contact Us</h5>
					<div>
						<h6 class="text-uppercase">Address</h6>
						<p>123 STREET NAME, CITY, US</p>
					</div>
					<div>
						<h6 class="text-uppercase">Phone</h6>
						<p>(123) 456-7890</p>
					</div>
					<div>
						<h6 class="text-uppercase">Email</h6>
						<p>MAIL@EXAMPLE.COM</p>
					</div>
				</div>
			</div>

			<div class="copyright mt-5">
				<div class="row container mx-auto">
					<div class="col-lg-4 col-md-6 col-12">
						<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
							class="fab fa-twitter"></i></a> <a href="#"><i
							class="fab fa-linkedin-in"></i></a>
					</div>
				</div>
			</div>
		</footer>
	</div>

	<script>
		var MainImg = document.getElementById('MainImg');
		var smallimg = document.getElementsByClassName('small-img');

		smallimg[0].onclick = function() {
			MainImg.src = smallimg[0].src;
		}
		smallimg[1].onclick = function() {
			MainImg.src = smallimg[1].src;
		}
		smallimg[2].onclick = function() {
			MainImg.src = smallimg[2].src;
		}
		smallimg[3].onclick = function() {
			MainImg.src = smallimg[3].src;
		}
	</script>
</body>
</html>