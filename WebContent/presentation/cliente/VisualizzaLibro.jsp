<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,bean.*,control.gestioneAcquisto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Libro</title>
</head>
<body>

<%@ include file="header.jsp"%>

<%
	Libro libro= (Libro) request.getSession().getAttribute("libro");
%>


<div class="container-visualizza-libro"  >
<div class="visualizza-libro-immagine">
	<img src="../image/<%=libro.getFoto() %>" >
</div >

<div class="container-visualizza-libro2">
<img id="star-preferiti" src="../image/star.jpg">
<div class="intestazione-visualizza-libro" >
<h2><%=libro.getTitolo() %></h2> 
<%
for(Autore autore: libro.getAutori()){
%>
	<h5><%=autore.getNome() %></h5>
<%
}
%>




</div>

<div class="descrizione-visualizza-libro">
<%=libro.getTrama() %>
</div>
</div>
</div>



<div class="container-dettagli-libro">
<div class="dettagli-libro" >
<span>Dettagli prodotto</span>
<span>Casa Editrice: <%=libro.getCasaEditrice() %></span>
<span>ISBN: <%=libro.getIsbn() %></span>
<span>Categoria: <%=libro.getCategoria() %></span>
</div>
<div class="quantita-libro">
<span>Euro <%=libro.getPrezzo() %></span>
<span>Quantità disponibile: <%=libro.getQuantità() %></span>
<form action="aggiungiAlCarrello">
<span>Quantità selezionata: <input type="number" min="1" max="<%=libro.getQuantità()%>" name="quantità"></span>
<input type="hidden" name="isbn" value="<%=libro.getIsbn() %>">
<center><input type="submit" value="aggiungi al carrello"></center>
</form>
</div>
</div>


<div class="container-recensione-libro">
<h2>Recensioni</h2>
<div>

<%
for(Recensione recensione : libro.getRecensioni()){
%>
	
	<%=recensione.getEmail() %>
	<p><%=recensione.getTesto() %></p>
	
<%
}
%>

</div>

</div>
<form action="aggiungiRecensione">
<div class="container-aggiungi-recensione" >
<textarea rows="4" cols="20" placeholder="Testo..." name="testo">
</textarea>
<input type="hidden" name="isbn" value="<%=libro.getIsbn() %>">
<input type="submit" value="aggiungi recensione" >
</div>
</form>



 <%@ include file="footer.jsp"%>


</body>
</html>