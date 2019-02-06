<!DOCTYPE html>
<html>
 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.*,model.*, bean.*" %>
 <head>

<title>BookPoint</title>
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 
</head>
<body>

<div class="divfisso-mio" >
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

		<td><form action="visualizzaFattura" method="post">
		<input type="hidden" value=<%=ordine.getIdOrdine()%> name="numOrdine">
		<button type="submit">Fattura</button></form></td>
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
		<h4>Contenuto ordine</h4>
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
				<td class="td-padding"><%=Math.round(libro.getPrezzo()*100.0)/100.0 %></td>
				<td><%=Math.round((libro.getQuantità() * libro.getPrezzo())*100.0)/100.0 %></td>
			</tr>
	
	</table>
	<%} %>
	</div>
<%} %>

	
</div>


 <%@ include file="footer.jsp"%>
 
 </div>
 
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" ></script>
<script src="cliente.js"></script>
</body>
</html>