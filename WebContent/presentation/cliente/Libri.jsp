 	<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,bean.*,control.gestioneRicerca.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="cliente.js"></script>


<title>Libri</title>
</head>

<body>

	<%@ include file="header.jsp"%>

<%  Collection<?> libriInEvidenza= (Collection<?>)request.getSession().getAttribute("libriInEvidenza");
	Collection<?> libriPiùVenduti= (Collection<?>)request.getSession().getAttribute("libriPiùVenduti");%>
	
<h1>I miei preferiti</h1>

<!-- Search Bar -->
<form class="search-container" action="ricerca">
<div class="container-cerca" >
<div class="cerca">
  
    <input  type="text" id="search-bar" placeholder="Cerca libro">
    <a href="#"><i class="fas fa-search fa-lg"></i></a>
  
</div>
<select>
  <option value="categorie"> Tutte le categorie</option>
  <option value="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
</div>
</form>
 
<div style="width: 90%; margin-right:5%; margin-left:5%; margin-top: 50px;">

	<% if(libriInEvidenza!=null && libriInEvidenza.size()>0){
	int i=0;
	
	%>
	
	
	<!-- Libri in evidenza -->
	<div id="demo"
		class="carousel slide carousel-mio" data-ride="carousel"
		data-interval="false">

		<!-- The slideshow -->
		<div class="container carousel-inner no-padding slider">
			<div class="carousel-item active car-item">
			<%
			Iterator it=libriInEvidenza.iterator();
			while(it.hasNext()){
		
			Libro bean= (Libro) it.next();
			if(i<4){
			%>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img class="visualizza" src="../image/<%=bean.getFoto()%>" name="<%=bean.getIsbn()%>">
				</div>
			<%	}else{ %>
			<% if(i==4){  %>
			</div>
			<div class="carousel-item car-item">
			<% }if(i>=4 && i<8){ %>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<img src="../image/<%=bean.getFoto()%>">
				</div>
			<%} %>
			<%if(i==8){ %>
			</div>
			<%}}i++;} %>
			
		</div>

		<!-- Left and right controls -->
			<a class="carousel-control-prev prima" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next dopo" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
	</div>
	<%}	 %>
	
	
<!--	
	<!-- libri più venduti 
	<div id="demo"
		class="carousel slide carousel-mio" data-ride="carousel"
		data-interval="false">

		<!-- The slideshow 
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
			
			<!-- Left and right controls 
			<a class="carousel-control-prev prima" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next dopo" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
			
		</div>
	</div>
 -->


</div>






	<%@ include file="footer.jsp"%>
</body>


</html>