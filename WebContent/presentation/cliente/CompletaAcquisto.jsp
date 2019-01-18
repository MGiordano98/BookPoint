
<!DOCTYPE html>
<html>
 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.*, model.*" %>
<head>



<title>BookPoint</title>
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 
</head>
<body>
<!-- 
<div class="divFisso">
<%@ include file="header.jsp"%>




<div class="divpagamento">

<table>
	<tr class="tr1">
		<td>Intestatario</td>
		<td>Scadenza</td>
		<td>Numero Carta</td>
		<td></td>
	</tr>
		
	<tr  class="ulCOUNT rigaPagamento" id="" style="height:35px">
		<td id="intestatario"></td>
		<td id="dataScadenza"> </td>
		<td id="numeroCarta"></td>
		<td id="buttons" style="display:none">
		<button id="deletePagamentoButton" class="bottoni deletePagamentoButton"><img src="image/delete.png" style="width:20px;"></button>	
		</td>
	</tr>
	
	
		</table>
		
		
		<div class="deletePagamento">
			<form action="cartacredito" method="post">
			Sei sicuro di voler eliminare il pagamento?
			<br>
			<input type="hidden" name="action" value="rimuoviCarta">
			<input type="hidden" id="deleteCodicePagamento" name="numeroCarta" value="">
			<button type="submit" value="SI">SI</button></form>
			<button type="submit" class="closeeditPagamento" value="NO">NO</button>
		</div>
		
		
	
	
	
<button id="aggPagamento" ><img src="image/add-button.png"></button>

<div class="aggPagamento">
	<button class="closeeditPagamento">X</button>
	<form action="cartacredito" method="post">
				Intestatario : <input type="text" name="intestatario" required pattern="^[A-Za-z]{4,}*$"required>
				Mese e Anno : <input type="month" name="dataScadenza" required>
				Numero carta : <input type="text" name="numeroCarta"  pattern="^[0-9]{16}" required placeholder="Debit/Credit Card Number">
				<input type="hidden" name="action" value="addCarta">
				<button class="aggSubmit" type="submit">Aggiungi!</button></form>
</div>

</div> 
 
 
 <%@ include file="footer.jsp"%>
 
 </div>
 -->
 
 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Book Point</title>
</head>
<body>

<%@ include file="header.jsp"%>

<div class="container-completa-acquisto" style="position:relative;margin: 5% 5% 5% ;">
<div class="container-carta" style="position:absolute;">
<h2>Carta di credito</h2>
<select style="width:100%;">
<option value="">**** **** **** 9383</option>
</select>
</div>

<div class="" style="position:absolute;right:0;">
<h2>Scegli indirizzo</h2>
<select style="width:100%;">
<option value="">via pecorari 89</option>
</select>
</div>



</div>
 
<input  style="margin-top:20%;margin-left:45%;"type="submit" value="Completa l'acquisto">



</body>
</html>
 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>
<script src="utente.js"></script>
</body>
</html>
