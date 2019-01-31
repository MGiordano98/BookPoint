 	<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,bean.*,control.gestioneRicerca.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<title>Libri</title>
</head>

<body>

	<%@ include file="header.jsp"%>

<%  Collection<?> libriInEvidenza= (Collection<?>)request.getSession().getAttribute("libriInEvidenza");
	Collection<?> libriPiùVenduti= (Collection<?>)request.getSession().getAttribute("libriPiùVenduti");
	Collection<?> libri= (Collection<?>)request.getSession().getAttribute("libri");%>
	
<h1>Catalogo</h1>

<!-- Search Bar -->
<form class="search-container" action="ricerca" id="form-ricerca-libri">
<div class="container-cerca"  >

  		<select class="form-control" name="categoria" id="sel1" placeholder="categoria">
		<option selected hidden value="">categoria</option>
        <option value="Avventura">Avventura</option>
        <option value="Romanzo">Romanzo</option>
        <option value="Giallo">Giallo</option>
        <option value="Verde">Verde</option>
      </select>
    <input  type="text" placeholder="cerca libro..." name="testo">
   <button class=" btn btn-danger"id="search-button" type="submit">
				<i class="fa fa-search"></i>
			</button>
  


</div>
</form>
 
 <%if(libri==null){ %>
 
 
<div class="container-libri-evidenza">

	<% if(libriInEvidenza!=null && libriInEvidenza.size()>0){
	int i=0;
	
	%>
	
	
	<!-- Libri in evidenza -->
	<div id="demo" style="margin-left:4%;"
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
					<img class="visualizza" src="../image/<%=bean.getFoto()%>" name="<%=bean.getIsbn()%>">
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
	
	
<% if(libriPiùVenduti!=null && libriPiùVenduti.size()>0){
	int i=0;
	
	%>
	
	
	<!-- Libri più venduti -->
	<div id="demo2"
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
					<img class="visualizza" src="../image/<%=bean.getFoto()%>" name="<%=bean.getIsbn()%>">
				</div>
			<%} %>
			<%if(i==8){ %>
			</div>
			<%}}i++;} %>
			
		</div>

		<!-- Left and right controls -->
			<a class="carousel-control-prev prima" href="#demo2" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next dopo" href="#demo2" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
	</div>
	
	<%}	 %>


</div>
<%} else if(libri.size()==0){%>

<div>
	<h2>Nessun libro trovato</h2>
</div>
<%request.getSession().removeAttribute("libri");
}else{
	Iterator it=libri.iterator();
	while(it.hasNext()){
	Libro bean=(Libro)it.next();%>

	<div class="container-libri-trovati">
		<div class="immagine-libro-trovato">
			<img alt="" src="../image/<%=bean.getFoto()%>" class="visualizza" name="<%=bean.getIsbn()%>">
		</div>
		<div class="container-informazioni-libro">
			<div>
				<h5><%=bean.getTitolo()%></h5>
			</div>
			<div>
				<%for(Autore autore : bean.getAutori()){ %>
					<h6><%=autore.getNome()+" " %></h6>
				<%} %>
			</div>
			<div><%if(bean.getTrama().length()>=200){ %>
				<p><%=bean.getTrama().substring(0,200)%></p>
				<%} else { %>
				<p><%=bean.getTrama() %></p>
				<%} %>
			</div>
		</div>
	
	
	</div>



<%}
	request.getSession().removeAttribute("libri");
}%>
	<%@ include file="footer.jsp"%>
	
	
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="cliente.js"></script>

	
</body>


</html>