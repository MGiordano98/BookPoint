
<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*, control.*, model.*"%>
<head>



<title>BookPoint</title>
<link rel="stylesheet" type="text/css" href="styleCliente2.css">
</head>
<body>


	<%@ include file="header.jsp"%>

	<%
		Collection<?> carte = (Collection<?>) request.getSession().getAttribute("carte");
		Collection<?> indirizzi = (Collection<?>) request.getSession().getAttribute("Indirizzi");
	%>

	<div class="container-completa-acquisto">

		<div class="container-carta">
			<h2>Carta di credito</h2>
			<%
				if (carte != null) {
			%>
			<select>
			<%
				Iterator it= carte.iterator();
				while(it.hasNext()){
				CartaDiCredito carta= (CartaDiCredito) it.next();
			%>
				<option value="<%=carta.getNumCarta()%>">**** **** **** <%=carta.getNumCarta().substring(11,16) %></option>
				
			<%
				}
			%>
			</select>
		</div>

		<%
			}else{
		%>
			<h3>Nessuna Carta Inserita</h3>

		<%} %>

		<div class="container-indirizzo">
			<h2>Scegli indirizzo</h2>
			
			<%
				if(indirizzi!=null){
			%>
			<select>
				<%
					Iterator it= indirizzi.iterator();
					while(it.hasNext()){
						Indirizzo indirizzo= (Indirizzo) it.next();
					
				%>
				<option value="<%=indirizzo.getId()%>"><%=indirizzo.getVia() %> <%=indirizzo.getNumCivico() %> <%=indirizzo.getCittà() %> <%=indirizzo.getCap() %></option>
				
				<%
					}
				%>
			</select>
			</div>
			<%
				}else{
			%>
				<h3>Nessun Indirizzo Inserito</h3>
			<%
				}
			%>
		


		<input class="btn btn-danger bottone-completa-acquisto" type="submit"
			value="Completa l'acquisto">
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
	<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>
	<script src="utente.js"></script>

</body>
</html>

