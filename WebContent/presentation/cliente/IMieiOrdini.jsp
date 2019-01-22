

<!DOCTYPE html>
<html>
 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.*,model.*, bean.*" %>
 <head>

<title>PizzaPoint</title>
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

	<div>
		<table class="tableordini1">
			<tr class="tr1">
				<td>Data</td>
				<td>Prezzo</td>
				<td>Indirizzo</td>
				<td>	</td>
			</tr>

		<tr class="tr2">
			<td><%=ordine.getDataConsegna() %></td>
			<td><%=ordine.getPrezzoTot() %></td>
			<td><%=ordine.getVia()%> <%=ordine.getCittà()%></td>

		<td><form action="VisualizzaFattura" method="post">
		<input type="hidden" value=<%=ordine.getIdOrdine()%> name="numOrdine">
		<button type="submit">Fattura!</button></form></td>
		</tr>
		</table>

		<% Iterator it2 = ordine.getLibri().iterator(); 
			while(it2.hasNext()){
				Libro libro=(Libro)it2.next();%>

		<table class="tableordini2">
	
			<tr>
				<td style="font-family: fantasy; font-size: x-large;"><%=libro.getTitolo() %></td>
				<td style="text-align:center"><%=libro.getQuantità() %></td>
				<td style="font-weight:bold"><%=libro.getPrezzo() %></td>
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

