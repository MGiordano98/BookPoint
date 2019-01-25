
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*, bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 

<title>Carte di credito</title>
</head>
<body>


 <%@ include file="header.jsp"%>

	<%
		Collection<?> carte = (Collection<?>) request.getSession().getAttribute("carte");
	%>
	<h1>Gestione indirizzi</h1>


	
		<div class="grid-container-carte">

		<%
			Iterator it = carte.iterator();
			while (it.hasNext()) {

				CartaDiCredito carta = (CartaDiCredito) it.next();
		%>

			<div class="grid-item-carte">
				<table>
					<tr>
						<td><h3>Numero carta</h3></td>
						<td><%=carta.getNumCarta() %></td>
					</tr>
					<tr>
						<td><h3>Data di scadenza</h3></td>
						<td><%=carta.getData() %></td>
					</tr>
					<tr>
						<td><h3>Intestatario</h3></td>
						<td><%=carta.getIntestatario() %></td>
					</tr>
					<tr>
						<td><h3>CVV</h3></td>
						<td><%=carta.getCvv() %></td>
					</tr>
				</table>
			</div>

				<%} %>
	</div>


 <%@ include file="footer.jsp"%>

 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="utente.js"></script>	
</body>
</html>
