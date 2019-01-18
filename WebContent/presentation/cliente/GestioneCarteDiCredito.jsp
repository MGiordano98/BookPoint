
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css"> 

<title>Carte di credito</title>
</head>
<body>

<div class="divFisso">
 <%@ include file="header.jsp"%>



<div class="divindirizzi">
<table>
	<tr>
		<th>Intestatario</th>
		<th>Numero</th>
		<th>Scadenza</th>
		<th></th>
		<th style="white-space:nowrap;">Codice Postale</th>
		<th>Telefono</th>
		<th></th>
	</tr>



	<tr class="ulCOUNT trIndirizzo" id="">
		<td id="nome"></td>
		<td id="cognome"></td>
		<td id="via"></td>
		<td id="citta"></td>
		<td id="cap"></td>
		<td id="telefono"></td>
		<td id="buttons" style="display:none">
		<input type="hidden" id="codice" value="">
		<button id="" class="editIndirizzoButton" ><img src="image/edit.png" style="width:20px;"></button>
		<button id="" class="deleteIndirizzoButton"><img src="image/delete.png" style="width:20px;"></button>	
		</td>
	</tr>
	
</table>



	<div class="editIndirizzo">
		<button class="closeeditIndirizzo">X</button>
		<form action="indirizzo" method="post">
			Nome : <input type="text" name="nome" id="editNome" required pattern="^[A-Za-z]*$"><br>
			Cognome : <input type="text" name="cognome" id="editCognome" required pattern="^[A-Za-z]*$" ><br>
			Via : <input type="text" name="via" id="editVia" required pattern="^[A-Za-z0-9\s]*$"><br>
			Città : <input type="text" name="citta" id="editCitta" required pattern="^[A-Za-z\s]*$"><br>
			Codice Postale : <input type="text" name="cap" id="editCap" required pattern="^[0-9]{5}*$"><br>
			Telefono: <input type="text" name="telefono" id="editTelefono" required pattern="^[0-9]*$"><br>
			<input type="hidden" name="codice" id="editCodice" value="">
			<input type="hidden" name="action" value="modificaIndirizzo">
			<button type="submit">Cambia!</button>
		</form>
	</div>
	<div class="deleteIndirizzo">
		<form action="indirizzo" method="post">
			Sei sicuro di voler eliminare l'indirizzo?
			<button type="submit" value="SI">SI</button>
			<input type="hidden" name="action" value="rimuoviIndirizzo">
			<input type="hidden" id="deleteCodice" name="codice" value="">
		</form>
		<button class="closeeditIndirizzo" type="submit" value="NO">NO</button>
	</div>
	<button id="aggIndirizzo" ><img src="image/add-button.png"></button>

	<div class="aggIndirizzo" >
		<button class="closeeditIndirizzo">X</button>
		<form action="indirizzo" method="post">
		Nome : <input type="text" name="nome" required pattern="^[A-Za-z]*$"><br>
		Cognome : <input type="text" name="cognome" required pattern="^[A-Za-z]*$"><br>
		Via : <input type="text" name="via" required pattern="^[A-Za-z0-9\s]*$"><br>
		Città : <input type="text" name="citta" required pattern="^[A-Za-z\s]*$"><br>
		Codice Postale : <input type="text" name="cap" required pattern="^[0-9]{5}*$"><br>
		Telefono: <input type="text" name="telefono" required pattern="^[0-9]*$"><br>
		<input type="hidden" name="action" value="addIndirizzo">
		<button type="submit">Aggiungi!</button>
		</form>
	</div>


</div>

 <%@ include file="footer.jsp"%>
 </div>
 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="utente.js"></script>
</body>
</html>
