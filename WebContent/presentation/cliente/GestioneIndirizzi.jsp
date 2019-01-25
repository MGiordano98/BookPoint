
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
	%>
	<h1>Gestione indirizzi</h1>


	
		<div class="grid-container">

		<%
			Iterator it = indirizzi.iterator();
			while (it.hasNext()) {

				Indirizzo indirizzo = (Indirizzo) it.next();
		%>

			<div class="grid-item">
				<table>
					<tr>
						<td><h3>via</h3></td>
						<td><%=indirizzo.getVia()%></td>
					</tr>
					<tr>
						<td><h3>numero civico</h3></td>
						<td><%=indirizzo.getNumCivico()%></td>
					</tr>
					<tr>
						<td><h3>Cap</h3></td>
						<td><%=indirizzo.getCap()%></td>
					</tr>
					<tr>
						<td><h3>citta</h3></td>
						<td><%=indirizzo.getCittà()%></td>
					</tr>
				</table>
			</div>

				<%} %>
	</div>

	


	

	<%@ include file="footer.jsp"%>



</body>
</html>
