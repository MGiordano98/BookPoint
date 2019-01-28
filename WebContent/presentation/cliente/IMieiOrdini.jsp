

<!DOCTYPE html>
<html>
 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.*,model.*, bean.*" %>
 <head>

<title>BookPoint</title>
<link rel="stylesheet" type="text/css" href="style.css"> 
</head>
<body>


<%@ include file="header.jsp"%>

<% Collection<?> ordini = (Collection<?>) request.getSession().getAttribute("ordini"); %>


<div class="divordini">
	
	
<% Iterator it=ordini.iterator();
	while(it.hasNext()){

		Ordine ordine =(Ordine) it.next();
		
%>

	<div class="container-ordini">
		<table class="tableordini1 table-striped">
			<tr class="tr1">
				<td class="td-grassetto">Numero ordine</td>
				<td><%=ordine.getIdOrdine() %></td>
				<td class="td-grassetto">Stato</td>
				<td><%=ordine.getStato() %></td>
				<td class="td-grassetto">Prezzo</td>
				<td><%=ordine.getPrezzoTot() %></td>
			</tr>

		<tr class="tr2">
			<td class="td-grassetto">Data acquisto</td>
			<td><%=ordine.getDataEffettuata() %></td>
			<td class="td-grassetto">Data di consegna</td>
			<td><%=ordine.getDataConsegna() %></td>
			<td class="td-grassetto">Ora di consegna</td>
			<td ><%=ordine.getOra() %></td>

		<td><form action="VisualizzaFattura" method="post">
		<input type="hidden" value=<%=ordine.getIdOrdine()%> name="numOrdine">
		<button type="submit">Fattura!</button></form></td>
		</tr>
		
				<tr class="tr3">
				<td class="td-grassetto">Numero carta</td>
				<td><%=ordine.getNumCarta() %></td>
				<td class="td-grassetto">Indirizzo</td>
				<td><%=ordine.getVia() %><%=" " %><%=ordine.getCittà() %><%=" " %><%=ordine.getNumCivico() %></td>
				<td class="td-grassetto">CAP</td>
				<td><%=ordine.getCap() %></td>
			</tr>
		
		
		</table>

		<% Iterator it2 = ordine.getLibri().iterator(); 
			while(it2.hasNext()){
				Libro libro=(Libro)it2.next();%>

		<table class="tableordini2 table-striped">
			<th>Titolo</th>
			<th>Quantità</th>
			<th>Prezzo</th>
			<th>Prezzo Totale</th>
		
			
			<tr>
				<td class="td-padding" ><%=libro.getTitolo() %></td>
				<td class="td-padding"><%=libro.getQuantità() %></td>
				<td class="td-padding"><%=libro.getPrezzo() %></td>
				<td><%=libro.getQuantità()*libro.getPrezzo() %></td>
			</tr>
	
	</table>
	<%} %>
	</div>
<%} %>

	
</div>


 <%@ include file="footer.jsp"%>
 
<script src="https://code.jquery.com/jquery-3.3.1.stdm.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/tdbs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>
<script src="utente.js"></script>
</body>
</html>

