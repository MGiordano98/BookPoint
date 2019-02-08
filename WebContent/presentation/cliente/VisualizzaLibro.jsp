<%
	if (request.getSession().getAttribute("utente") != null) {
		Utente utenteC = (Utente) request.getSession().getAttribute("utente");
		if (!utenteC.getTipo().equalsIgnoreCase("cliente")) {
			if (utenteC.getTipo().equalsIgnoreCase("amministratore")) {
				response.sendRedirect("../amministratore/AmministratoreCatalogo.jsp");
			} else {
				response.sendRedirect("../amministratoreOrdini/AmministratoreOrdiniOrdine.jsp");
			}
		}}
%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.util.*,bean.*,control.gestioneAcquisto.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleCliente2.css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Libro</title>
</head>
<body>

	<%@ include file="header.jsp"%>

	<%
		if(request.getSession().getAttribute("libro")!= null){
		Libro libro = (Libro) request.getSession().getAttribute("libro");
	%>


	<div class="container-visualizza-libro">
		<div class="visualizza-libro-immagine">
			<img src="../image/<%=libro.getFoto()%>">
		</div>

		<div class="container-visualizza-libro2">

			<%
				if (request.getSession().getAttribute("utente") != null) {
			%>
			<form action=aggiungiLibroPreferiti method="post" id="form-preferiti">
				
				
				
				<img id="star-preferiti" src="../image/star1.jpg"> <input
					type="hidden" name="isbn" value="<%=libro.getIsbn()%>">
			</form>
			<%
				}
			%>

			<div class="intestazione-visualizza-libro">
				<h2><%=libro.getTitolo()%></h2>
				<%
					for (Autore autore : libro.getAutori()) {
				%>
				<h5><%=autore.getNome()%></h5>
				<%
					}
				%>




			</div>

			<div class="descrizione-visualizza-libro">
				<%=libro.getTrama()%>
			</div>
		</div>
	</div>



	<div class="container-dettagli-libro">
		<div class="dettagli-libro">
			<span>Dettagli prodotto</span> <span>Casa Editrice: <%=libro.getCasaEditrice()%></span>
			<span>ISBN: <%=libro.getIsbn()%></span> <span>Categoria: <%=libro.getCategoria()%></span>
		</div>
		<div class="quantita-libro">
			<span>Euro <%=libro.getPrezzo()%></span> <span>Quantità
				disponibile: <%=libro.getQuantità()%></span>
			<form action="aggiungiAlCarrello" method="post">
				<span>Quantità selezionata: <input type="number" min="1"
					max="<%=libro.getQuantità()%>" name="quantita" value="1"></span> <input
					type="hidden" name="isbn" value="<%=libro.getIsbn()%>">
				<center>
					<button class="btn btn-danger" type="submit"
						value="aggiungi al carrello">Aggiungi al carrello</button>
				</center>
			</form>
		</div>
	</div>


	<div class="container-recensione-libro">
		<h2>Recensioni</h2>
		<div class="container-recensione" >

			<%
				for (Recensione recensione : libro.getRecensioni()) {
			%>
			<form action="rimuoviRecensione" method="post">
		<div class="container-informazioni-recensioni" >
			<h6><%=recensione.getEmail()%></h6>
			<p><%=recensione.getTesto()%></p>
			<input type="hidden" value="<%=recensione.getId() %>" name="idRecensione">
			<button   type="submit" class="btn btn-danger bottone-elimina"> x </button>
</div>
</form>
			<%
				}
			%>

		</div>

	</div>
	<%
	if(request.getSession().getAttribute("utente")!=null){
	%>
	<form action="aggiungiRecensione" method="post">
		<div class="container-aggiungi-recensione">
			<textarea rows="4" cols="20" placeholder="Testo..." name="testo" maxlength="300" required></textarea>
			<input type="hidden" name="isbn" value="<%=libro.getIsbn()%>">
			<button class="btn btn-danger bottone-recensione" type="submit"
				value="aggiungi recensione">Aggiungi recensione</button>
		</div>
	</form>

<%}} %>


	<%@ include file="footer.jsp"%>



	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
	<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>
	<script src="cliente.js"></script>
	
	
</body>
</html>