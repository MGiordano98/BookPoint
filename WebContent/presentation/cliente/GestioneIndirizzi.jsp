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
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="styleCliente2.css">

<title>Indirizzi</title>
</head>
<body>

	<%@ include file="header.jsp"%>
	<%
		Collection<?> indirizzi = (Collection<?>) request.getSession().getAttribute("indirizzi");
		Utente utente2= (Utente) request.getSession().getAttribute("utente");
	%>
	<h1>Gestione indirizzi</h1>

<div class="container-indirizzi">
	<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal2">
  Aggiungi indirizzo
</button>


	<div class="grid-container">

		<%
			Iterator it = indirizzi.iterator();
			int i = 0;
			while (it.hasNext()) {

				Indirizzo indirizzo = (Indirizzo) it.next();
		%>

		<div class="grid-item-indirizzi ">
			<table class="table-striped">
				<tr>
					<td><h5>via</h5></td>
					<td><%=indirizzo.getVia()%></td>
				</tr>
				<tr>
					<td><h5>numero civico</h5></td>
					<td><%=indirizzo.getNumCivico()%></td>
				</tr>
				<tr>
					<td><h5>Cap</h5></td>
					<td><%=indirizzo.getCap()%></td>
				</tr>
				<tr>
					<td><h5>citta</h5></td>
					<td><%=indirizzo.getCittà()%></td>
				</tr>
				
				<tr>
					<td><form action="rimuoviIndirizzo" method="post">
							<input type="hidden" name="idIndirizzo"
								value="<%=indirizzo.getId()%>">
							<button type="submit"
								class="btn btn-danger buttonRimuoviIndirizzo">
								Rimuovi</button>
						</form></td>
					<td><button type="button"
							class="btn btn-danger buttonModificaIndirizzo" id="<%=i%>"
							data-toggle="modal" data-target="#exampleModal">
							Modifica</button></td>
				</tr>
			</table>
			<input type="hidden" id="idIndirizzo<%=i%>" name="idIndirizzo"
				value="<%=indirizzo.getId()%>">
		</div>


		<%
			i++;
			}
		%>
	</div>
</div>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<h5 class="modal-title" id="exampleModalLabel">Modifica
					Indirizzo</h5>

				<form action="modificaIndirizzo" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<table>
							<!-- Modifica  DATI Indirizzo -->
							<tr>
								<td class="td-bold"><label for="via">Via</label></td>
								<td><input id="via" type="text" name="via"
									placeholder="via" pattern="[a-zA-Z_]{0,30}" title="La via deve contenere solo da lettere con lunghezza massima di 30 caratteri"><br></td>
							</tr>

							<tr>
								<td class="td-bold"><label for="numCivico">Numero
										Civico</label></td>
								<td><input id="numCivico" type="text" name="numCivico"
									placeholder="Numero Civico" pattern="\d{3}$" title="Il numero civico deve essere formato da soli numeri"><br></td>
							</tr>

							<tr>
								<td class="td-bold"><label for="cap">CAP</label></td>
								<td><input id="cap" type="text" name="cap"
									placeholder="CAP" pattern=[0-9]{5} title="il CAP deve essere formato da soli numeri"><br></td>
							</tr>

							<tr>
								<td class="td-bold"><label for="citta">Città</label></td>
								<td><input id="città" type="text" name="citta"
									placeholder="Città" pattern="[a-zA-Z_]{0,30}" title="La città deve essere formato solo da lettere"><br></td>
							</tr>
						</table>

						<input type="hidden" id="idIndirizzoDaModificare"
							name="idIndirizzo">

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Modifica</button>
					</div>

				</form>
			</div>
		</div>
	</div>




<!-- Modal -->
<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <form action="aggiungiIndirizzo" method="post">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Aggiungi indirizzo</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <table>
							<!-- agigungi  DATI Indirizzo -->
							<tr>
								<td class="td-bold"><label for="isbn">Via</label></td>
								<td><input id="via" type="text" name="via"
									placeholder="via"><br></td>
							</tr>

							<tr>
								<td class="td-bold"><label for="titolo">Numero
										Civico</label></td>
								<td><input id="numCivico" type="text" name="numCivico"
									placeholder="Numero Civico"><br></td>
							</tr>

							<tr>
								<td class="td-bold"><label for="trama">CAP</label></td>
								<td><input id="cap" type="text" name="cap"
									placeholder="CAP"><br></td>
							</tr>

							<tr>
								<td class="td-bold"><label for="casaEditrice">Città</label></td>
								<td><input id="città" type="text" name="citta"
									placeholder="Città"><br></td>
							</tr>
						</table>
						<input type="hidden" value=<%=utente2.getEmail() %>
							name="email">
      </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">aggiungi</button>
      </div>
      </form>
    </div>
  </div>
</div>






	<%@ include file="footer.jsp"%>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="cliente.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>

</body>
</html>
<%
	}
}else{
	response.sendRedirect("Login.jsp");
}
%>
