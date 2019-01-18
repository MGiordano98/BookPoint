

<!DOCTYPE html>
<html>
 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.*,model.*" %>
 <head>

<title>PizzaPoint</title>
<link rel="stylesheet" type="text/css" href="style.css"> 
</head>
<body>


<%@ include file="header.jsp"%>

<div class="divordini">
	
	


	<div style="">
		<table class="tableordini1">
			<tr class="tr1">
				<td>Data</td>
				<td>Prezzo</td>
				<td>Indirizzo</td>
				<td>	</td>
			</tr>

		<tr class="tr2">
			<td>31/2/12</td>
			<td>444</td>
			<td>via peppe</td>

		<td><form action="fattura.jsp?count=" method="post">
		
		<button type="submit">Fattura!</button></form></td>
		</tr>
		</table>

		<table class="tableordini2">
	
			<tr>
				<td><img src="../image/principe.jpg" style="width: 50%"></td>
				<td style="font-family: fantasy; font-size: x-large;">dsada</td>
				<td>cvbnngf</td>
				<td style="text-align:center"></td>
				<td style="font-weight:bold"></td>
			</tr>
	
	</table>
	</div>


	
</div>


 <%@ include file="footer.jsp"%>
 
<script src="https://code.jquery.com/jquery-3.3.1.stdm.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/tdbs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>
<script src="utente.js"></script>
</body>
</html>

