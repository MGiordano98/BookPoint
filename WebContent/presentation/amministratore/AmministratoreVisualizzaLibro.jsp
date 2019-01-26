<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="styleAmministratore.css">
 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookPoint</title>
</head>
<body>
<%@ include file="headerAmministratore.jsp"%>
<%
Libro libro=(Libro) request.getSession().getAttribute("libro");
Collection<Recensione> recensioni=libro.getRecensioni(); 
%>




<table class="table table">
  
  <tbody>
  <tr>
      <td>Immagine</td>
      <td colspan="2"><%=libro.getFoto() %></td>
    <td> <center> <input type="submit" value="modifica" class="modificaFoto"></center></td>
    </tr>
      <tr>
      <td>Titolo</td>
      <td colspan="2"><%=libro.getTitolo() %></td>
	  <td><center><input type="submit" value="modifica"  class="modificaTitolo"></center></td>
    </tr>
     <tr>
      <td>Autore</td>
      <td colspan="2"><%Collection<Autore> autori=libro.getAutori();
      Iterator it=autori.iterator();
      while(it.hasNext()){
      Autore autore=(Autore)it.next();%>
      <%=autore.getNome() %>
      <%} %></td>
      <td><center><input type="submit" value="modifica"></center></td>
    </tr>
      <tr>
      <td>Editore</td>
      <td colspan="2"><%=libro.getCasaEditrice() %></td>
	  <td><center><input type="submit" value="modifica"  class="modificaEditore"></center></td>
    </tr>
     <tr>
      <td>ISBN</td>
      <td colspan="2"><%=libro.getIsbn() %></td>
      <td><center><input type="submit" value="modifica"  class="modificaIsbn"></center></td>
    </tr>
      <tr>
      <td>Categoria</td>
      <td colspan="2"><%=libro.getCategoria()%></td>
	  <td><center><input type="submit" value="modifica"  class="modificaCategoria"></center></td>
    </tr>
      
     <tr>
      <td>Descrizione</td>
      <td style="word-wrap:break-word;"colspan="2"><%=libro.getTrama() %></td>
      <td><center><input type="submit" value="modifica"  class="modificaDescrizione"></center></td>
    </tr>
     <tr>
      <td>Prezzo</td>
      <td colspan="2"><%=libro.getPrezzo()+"€" %></td>
      <td><center><input type="submit" value="modifica"  class="modificaPrezzo"></center></td>
    </tr>
      <tr>
      <td>Quantita</td>
      <td colspan="2"><%=libro.getQuantità()%></td>
	  <td><center><input type="submit" value="modifica"  class="modificaQuantita	"></center></td>
    </tr>
  </tbody>
</table>


<h1>Recensioni</h1>

<table >
  
<% 
Iterator it2=recensioni.iterator();
while(it2.hasNext()){
Recensione recensione=(Recensione) it2.next();%>
    <tr>
      <td><%=recensione.getEmail() %></td>
     </tr>
     <tr>
      <td><%=recensione.getTesto() %></td>
     </tr>
     <tr>
     	<td>
     		<form action="">
     			<input type=hidden  value=<%= %>name="idRecensione">
     			<input type=submit value=x>
     		</form>
     	</td>
     </tr>
  <%} %>
</table>


<div class="formModificaFoto" style="display:none; position:fixed; width:15%; margin-left:42%; top:30%;">
	<form action="modificaAttributo">
		<input type="hidden" value="foto" name="tipo">
		<input type="hidden" value=<%=libro.getIsbn() %> name="isbn">
		<input type="text" name="nuovoAttributo">
		<input type=submit value=modifica>
	</form>
</div>

<div class="formModificaTitolo" style="display:none; position:fixed; width:15%; margin-left:42%; top:30%;">
	<form action="modificaAttributo">
		<input type="hidden" value="titolo" name="tipo">
		<input type="hidden" value=<%=libro.getIsbn() %> name="isbn">
		<input type="text" name="nuovoAttributo">
		<input type="submit" value="modifica">
	</form>
</div>

<div class="formModificaEditore" style="display:none; position:fixed; width:15%; margin-left:42%; top:30%;">
	<form action="modificaAttributo">
		<input type="hidden" value="casaEditrice" name="tipo">
		<input type="hidden" value=<%=libro.getIsbn() %> name="isbn">
		<input type="text" name="nuovoAttributo">
		<input type=submit value=modifica>
	</form>
</div>

<div class="formModificaCategoria" style="display:none; position:fixed; width:15%; margin-left:42%; top:30%;">
	<form action="modificaAttributo">
		<input type="hidden" value="categoria" name="tipo">
		<input type="hidden" value=<%=libro.getIsbn() %> name="isbn">
		<input type="text" name="nuovoAttributo">
		<input type=submit value=modifica>
	</form>
</div>

<div class="formModificaDescrizione" style="display:none; position:fixed; width:15%; margin-left:42%; top:30%;">
	<form action="modificaAttributo">
		<input type="hidden" value="trama" name="tipo">
		<input type="hidden" value=<%=libro.getIsbn() %> name="isbn">
		<input type="text" name="nuovoAttributo">
		<input type=submit value=modifica>
	</form>
</div>


<div class="formModificaPrezzo" style="display:none; position:fixed; width:15%; margin-left:42%; top:30%;">
	<form action="modificaAttributo">
		<input type="hidden" value="prezzo" name="tipo">
		<input type="hidden" value=<%=libro.getIsbn() %> name="isbn">
		<input type="text" name="nuovoAttributo">
		<input type=submit value=modifica>
	</form>
</div>

<div class="formModificaQuantita" style="display:none; position:fixed; width:15%; margin-left:42%; top:30%;">
	<form action="modificaAttributo">
		<input type="hidden" value="quantità" name="tipo">
		<input type="hidden" value=<%=libro.getIsbn() %> name="isbn">
		<input type="text" name="nuovoAttributo">
		<input type=submit value=modifica>
	</form>
</div>

<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="Amministratore.js"></script>

</body>
</html>