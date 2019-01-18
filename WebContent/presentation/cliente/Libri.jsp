<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style>
.col-md-3 {
	display: inline-block;
	margin-left: -4px;
}

.col-md-3 img {
	width: 100%;
	height: auto;
}


body .carousel-control-prev-icon, body .carousel-control-next-icon {
	background-color: red;
}

body .no-padding {
	padding-left: 0;
	padding-right: 0;
}

.slider.no-padding.carousel-inner.container {
	width: auto;
	display: inline-block;
	float: none;
	padding-left: 5%;
	padding-right: 5%;
}

.slider.no-padding.carousel-inner.container img {
	height: 280px;
	width: 230px;
	padding: 5%;
}

.prima.carousel-control-prev {
	width: 3%;
}

.dopo.carousel-control-next {
	width: 3%;
}

.car-item.carousel-item.active {
	background-color: #f7f7f7;
}

.carousel-mio.slide.carousel{
	height: 280px;
	margin-bottom: 30px;
}

@media(display-width:980px){

}
</style>

<title>Libri</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	 
<div class="container-cerca" >
<div class="cerca">
  <form class="search-container">
    <input  type="text" id="search-bar" placeholder="Cerca libro">
    <a href="#"><i class="fas fa-search fa-lg"></i></a>
  </form>
</div>
<select>
  <option value="categorie"> Tutte le categorie</option>
  <option value="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
</div>
 
<div style="width: 90%; margin-right:5%; margin-left:5%; margin-top: 50px;">
	<div id="demo"
		class="carousel slide carousel-mio" data-ride="carousel"
		data-interval="false">

		<!-- The slideshow -->
		<div class="container carousel-inner no-padding slider">
			<div class="carousel-item active car-item">
				<div class="col-xs-3 col-sm-3 col-md-3">
					<a href="Home.jsp"><img src="../image/principe.jpg"></a>
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
			</div>
			<div class="carousel-item car-item">
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
			</div>
			
			<!-- Left and right controls -->
			<a class="carousel-control-prev prima" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next dopo" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
			
		</div>
		

	</div>
	
	<div id="demo"
		class="carousel slide carousel-mio" data-ride="carousel"
		data-interval="false">

		<!-- The slideshow -->
		<div class="container carousel-inner no-padding slider">
			<div class="carousel-item active car-item">
				<div class="col-xs-3 col-sm-3 col-md-3">
					<a href="Home.jsp"><img src="../image/principe.jpg"></a>
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
			</div>
			<div class="carousel-item car-item">
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/principe.jpg">
				</div>
			</div>
			
			<!-- Left and right controls -->
			<a class="carousel-control-prev prima" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next dopo" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
			
		</div>
		

	</div>



</div>






	<%@ include file="footer.jsp"%>
</body>


</html>