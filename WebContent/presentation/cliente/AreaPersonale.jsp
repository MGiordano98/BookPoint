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
	import="java.util.*, control.*, model.*"%>
<head>
<script src="scripts/jquery-3.3.1.min.map.Js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styleCliente2.css">
<meta charset="utf-8">
<title>BookPoint</title>
</head>
<body>

	<%
		Utente APUtente = (Utente) session.getAttribute("utente");
		if (APUtente == null) {

			response.sendRedirect("Login.jsp");
		} else {
	%>


	<%@ include file="header.jsp"%>



	



	
		<div class="grid-container-account">

		

			<div class="grid-item-account">
				<table>
					<tr>
						<td><a href="visualizzaStorico" class="accountahref"><img src="../image/libro.jpg"></a></td>
					</tr>
					<tr>
						<td><h3>I miei Ordini</h3></td>
					</tr>
					<tr>
						<td>Visualizza gli ordini precedentemente effettuati</td>
					</tr>
				
				</table>
			</div>
			
			<div class="grid-item-account">
				<table>
					<tr>
						<td><a href="GestioneAccount.jsp" class="accountahref"><img src="../image/libro.jpg"></a></td>
					</tr>
					<tr>
						<td><h3>Accesso e sicurezza</h3></td>
					</tr>
					<tr>
						<td>Modifica password</td>
					</tr>
				
				</table>
			</div>
			
			<div class="grid-item-account">
				<table>
					<tr>
						<td><a href="ricercaIndirizzi" class="accountahref"><img src="../image/libro.jpg"></a></td>
					</tr>
					<tr>
						<td><h3>Indirizzi</h3></td>
					</tr>
					<tr>
						<td>Modifica gli indirizzi</td>
					</tr>
				
				</table>
			</div>
			
			<div class="grid-item-account">
				<table>
					<tr>
						<td><a href="ricercaCarte" class="accountahref"> <img src="../image/libro.jpg"></a></td>
					</tr>
					<tr>
						<td><h3>Opzioni di pagamento</h3></td>
					</tr>
					<tr>
						<td>Modifica o aggiungi metodi di pagamento</td>
					</tr>
				
				</table>
			</div>

	</div>
	

			





	<%@ include file="footer.jsp"%>




	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>



	<%} %>

</body>
</html>

<%
	}
}else{
	response.sendRedirect("Login.jsp");
}
%>