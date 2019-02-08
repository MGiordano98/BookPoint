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
		Utente utente2= (Utente) request.getSession().getAttribute("utente");
	%>
	<h1>Gestione Carta</h1>


<div class="container-indirizzi">
	<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal2">
  Aggiungi carta
</button>
	
		<div class="grid-container-carte">

		<%
			Iterator it = carte.iterator();
			while (it.hasNext()) {

				CartaDiCredito carta = (CartaDiCredito) it.next();
		%>

			<div class="grid-item-carte">
				<table class="table-striped">
					<tr>
						<td><h5>Numero carta</h5></td>
						<td><%=carta.getNumCarta() %></td>
					</tr>
					<tr>
						<td><h5>Data di scadenza</h5></td>
						<td><%=carta.getData() %></td>
					</tr>
					<tr>
						<td><h5>Intestatario</h5></td>
						<td><%=carta.getIntestatario() %></td>
					</tr>
					<tr>
						<td><h5>CVV</h5></td>
						<td><%=carta.getCvv() %></td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
						<form action="rimuoviCarta" method="post">
							<input type="hidden" name="numCarta"
								value="<%=carta.getNumCarta()%>">
							<button type="submit"
								class="btn btn-danger buttonRimuoviCarta">
								Rimuovi</button>
						</form>
						</td>
					</tr>
				</table>
			</div>

				<%} %>
	</div>


</div>





<!-- Modal -->
<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
  
    <form action="aggiungiCarta" method="post">
    
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Aggiungi carta</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <table>
							<!-- aggiungi  DATI carta -->
							<tr>
								<td class="td-bold"><label for="numCarta">Numero di carta</label></td>
								<td><input id="numCarta" type="text" name="numCarta"
									placeholder="numero di carta" pattern=\d{16}$ title="il numero di carta deve essere formato solo da numeri e deve avere una lunghezza di 16 caratteri" required><br></td>
							</tr>

							<tr>
								<td class="td-bold"><label for="intestatario">Intestatario
										</label></td>
								<td><input id="intestatario" type="text" name="intestatario"
									placeholder="intestatario" pattern="[a-zA-Z_\x20]{0,30}" title="Il campo intestatario deve essere formato da sole lettere" required><br></td>
							</tr>

							<tr>
								<td class="td-bold"><label for="dataScandeza">Data scadenza</label></td>
								<td><input type="date" id="dataScadenza" type="text" name="dataScadenza"
									placeholder="Data Scadenza" required><br></td>
							</tr>

							<tr>
								<td class="td-bold"><label for="cvv">CVV</label></td>
								<td><input id="cvv" type="text" name="cvv"
									placeholder="CVV" pattern="\d{3}$" title="Il CVV deve essere formato da tre numeri " required><br></td>
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

 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="utente.js"></script>	
</body>
</html>
<%
	}
}else{
	response.sendRedirect("Login.jsp");
}
%>
