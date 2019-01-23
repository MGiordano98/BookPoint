<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,bean.*,control.gestioneRicerca.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleAmministratore.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookPoint</title>
</head>
<body>
<%@ include file="headerAmministratore.jsp"%>
<%Collection<?> libri= (Collection<?>)request.getSession().getAttribute("libri");%>


<form class="search-container" action="ricerca">
<div class="container-cerca" >
<div class="cerca">
  
    <input  type="text" id="search-bar" placeholder="Cerca libro" name="testo">
    <a><i id="search-button" class="fas fa-search fa-lg"></i></a>
  
</div>
<select name="categoria" id="categoria">
  <option value=""></option>
  <option value="Romanzo">Romanzo</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
</div>
</form>


<input type="submit" value="aggiungi libro">
<%if(libri==null){
	
}else if(libri.size()==0){%>

<div>
	<h2>Nessun libro trovato</h2>
</div>
<%request.getSession().removeAttribute("libri");
}else{
	Iterator it=libri.iterator();
	while(it.hasNext()){
	Libro bean=(Libro)it.next();%>

	<div>
		<div>
			<img alt="" src="../image/<%=bean.getFoto()%>">
		</div>
		<div>
			<div>
				<h5><%=bean.getTitolo()%></h5>
			</div>
			<div>
				<%for(Autore autore : bean.getAutori()){ %>
					<h6><%=autore.getNome()+" " %></h6>
				<%} %>
			</div>
			<div>
				<p><%=bean.getTrama().substring(0,200)%></p>
			</div>
		</div>
	
	
	</div>



<%}request.getSession().removeAttribute("libri");
}%>
<div class="container-inserimento">
<ul style="display:none">
<li><form action="/action_page.php">
  <input type="file" name="pic" accept="image/*">
  <input type="submit">
</form></li>
<li>Isbn<input type="text" name="isbn" placeholder="isbn"></li>
<li>Titolo<input type="text" name="titolo" placeholder="titolo"></li>
<li>Trama<input type="text" name="trama" placeholder="trama"></li>
<li>CasaEditrice<input type="text" name="casaEditrice" placeholder="casa editrice"></li>
<li>Prezzo<input type="text" name="prezzo" placeholder="prezzo"></li>
<li style="display:-webkit-inline-box;">Quantita<input style="width:auto;"type="number" min="1" max="100"  class="form-control" id="" min="1" value="1"></li>
<li>Categoria<input type="text" name="categoria" placeholder="categoria"></li>
</ul>
</div>
	
	
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="Amministratore.js"></script>

</body>
</html>