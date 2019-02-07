<%
	if (request.getSession().getAttribute("utente") != null) {
		Utente utenteC = (Utente) request.getSession().getAttribute("utente");
		if (!utenteC.getTipo().equalsIgnoreCase("cliente")) {
			if (utenteC.getTipo().equalsIgnoreCase("amministratore")) {
				response.sendRedirect("../amministratore/AmministratoreCatalogo.jsp");
			} else {
				response.sendRedirect("../amministratoreOrdini/AmministratoreOrdiniOrdine.jsp");
			}
		} else {
%>
<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*, control.*, model.*, bean.*"%>
<head>

<title>BookPoint</title>
<link rel="stylesheet" type="text/css" href="styleCliente2.css">
</head>
<body>

	<%
		Collection<?> carte = (Collection<?>) request.getSession().getAttribute("carte");
		Collection<?> indirizzi = (Collection<?>) request.getSession().getAttribute("indirizzi");
	%>


	<%@ include file="header.jsp"%>
<form action="completaAcquisto" method="post">
	<div class="container-completa-acquisto">

		<div class="container-carta">
			<h2>Carta di credito</h2>
			<%
				if (carte != null) {
			%>
			<select name="numCarta" required>
				<%
					Iterator it = carte.iterator();
						while (it.hasNext()) {
							CartaDiCredito carta = (CartaDiCredito) it.next();
				%>
				<option></option>
				<option value="<%=carta.getNumCarta()%>">**** **** ****
					<%=carta.getNumCarta().substring(11, 16)%></option>

				<%
					}
				%>
			</select>

		<%
			} else {
		%>
		<h3>Nessuna Carta Inserita</h3>

		<%
			}
		%>
		</div>

		<div class="container-indirizzo">
			<h2>Scegli indirizzo</h2>

			<%
				if (indirizzi != null) {
			%>
			<select name="idIndirizzo" required>
				<%
					Iterator it = indirizzi.iterator();
						while (it.hasNext()) {
							Indirizzo indirizzo = (Indirizzo) it.next();
				%>
				
				<option value="<%=indirizzo.getId()%>"><%=indirizzo.getVia()%>
					<%=indirizzo.getNumCivico()%>
					<%=indirizzo.getCittà()%>
					<%=indirizzo.getCap()%></option>

				<%
					}
				%>
			</select>
		<%
			} else {
		%>
		<h3>Nessun Indirizzo Inserito</h3>
		<%
			}
		%>
	</div>
	
	<input class="btn btn-danger bottone-completa-acquisto" type="submit"
		value="Completa l'acquisto">

	</div>
</form>
	<%@include file="footer.jsp"%>


	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
	<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

</body>
</html>

<%
	}
}else{
	response.sendRedirect("Home.jsp");
}
%>
