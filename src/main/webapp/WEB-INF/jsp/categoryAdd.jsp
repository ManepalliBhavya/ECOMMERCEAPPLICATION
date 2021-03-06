<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>categoryAdd page</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />

<link rel="stylesheet" href="css/style.css">

<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>

<%@ include file="head.jsp"%>
</head>

<body>
	<!-- NAVIGATION -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-white py-3 fixed-top">
	<div class="container">
		<img src="img/logo3.png" alt="">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span><i id="bar" class="fas fa-bars"></i></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link active" href="/">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="productlist">Shopping</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="productadd">ProductAdd</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="categoryadd">CategoryAdd</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="supplieradd">SupplierAdd</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="categorylist">Categorylist</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="supplierlist">Supplierlist</a>
					</li>
			</ul>
		</div>
		<a href="logout"><i class="fa fa-sign-out" aria-hidden="true"></i></a>
	</div>
	</nav>
<br>
<br>
<br>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Category Add</div>
			<div class="card-body">
				<div class="form-group">
					<label>Category Name</label> <input type=text id="catName" required
						class="form-control" placeholder="Enter category Name">
				</div>

				<div class="text-center">
					<input type="submit" id="submit"
						class="btn btn-lg btn-primary btn-block" value="Add to Database" />
				</div>
			</div>
		</div>
	</div>
	<div id="displayDiv" style="display: none">
		<h3>Category ADDED Successfully to database</h3>
		<div id="processedData"></div>
		<span class="form-signin" action="signup" method="get"> <a
			href="logout" style="color: green"> click here to logout</a></span>
	</div>

	<script>
		jQuery(document).ready(function($) {

			$("#submit").click(function() {
				var categoryData = {};
				categoryData["id"] = $("#id").val();
				categoryData["catName"] = $("#catName").val();

				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "categoryadd",
					data : JSON.stringify(categoryData),
					dataType : 'json',
					success : function(data) {
						$('#processedData').html(JSON.stringify(data));
						$('#displayDiv').show();
					}
				});
			});

		});
	</script>

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
				<p>Gannavaram, VijayawadaS</p>
			</div>
			<div>
				<h6 class="text-uppercase">Phone</h6>
				<p>1800 456 456</p>
			</div>
			<div>
				<h6 class="text-uppercase">Email</h6>
				<p>Ecom@hcl.COM</p>
			</div>
		</div>

		<div class="footer-one col-lg-3 col-md-6 col-12">
			<h5 class="pb-2">Instagram</h5>
			<div class="row">
				<img class="img-fluid w-25 h-100 m-2" src="img/insta/1.jpg" alt="">
				<img class="img-fluid w-25 h-100 m-2" src="img/insta/2.jpg" alt="">
				<img class="img-fluid w-25 h-100 m-2" src="img/insta/3.jpg" alt="">
				<img class="img-fluid w-25 h-100 m-2" src="img/insta/4.jpg" alt="">
				<img class="img-fluid w-25 h-100 m-2" src="img/insta/5.jpg" alt="">
			</div>
		</div>
	</div>

	<div class="copyright mt-5">
		<div class="row container mx-auto">
			<div class="col-lg-3 col-md-6 col-12 mb-4">
				<img src="img/payment.png" alt="">
			</div>
			<div class="col-lg-4 col-md-6 col-12">
				<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
					class="fab fa-twitter"></i></a> <a href="#"><i
					class="fab fa-linkedin-in"></i></a>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>