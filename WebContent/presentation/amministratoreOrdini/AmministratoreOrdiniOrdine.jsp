<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookPoint</title>
</head>
<body>

	<%@ include file="headerAmministratoreOrdini.jsp"%>
	<%
		Ordine ordine = (Ordine) request.getSession().getAttribute("ordine");
	%>

	<div class="container-cerca">
		<div class="cerca">
			<form class="search-container" action="ricercaOrdine" method="post">
				<input   type="text" id="search-bar" placeholder="Cerca ordine"
					name="numOrdine"> 
					<input class="btn btn-danger" type="submit" value="Cerca ordine">
			</form>
		</div>
	</div>
	<%
		if (ordine == null) {
		} else {
	%>
	<div class="container-ordine">
		<h1>
			Ordine n°<%=ordine.getIdOrdine()%></h1>
		<table
			>


			<tr>
				<td class="td-padding" >Stato</td>
				<td class="td-padding" ><input type="text" id="stato"
					value="<%=ordine.getStato()%>" name="name" readonly></td>
				<td class="td-padding1"><button class="btn btn-danger" id="button-1">Modifica
						stato</button></td>
			</tr>
			<tr>
				<td class="td-padding" >Ora consegna</td>
				<td class="td-padding" ><input type="text" id="ora"
					value="<%=ordine.getOra()%>" name="ora" readonly></td>
				<td class="td-padding1"></td>
			</tr>
			<tr>
				<td class="td-padding" >Data Consegna</td>
				<td class="td-padding" ><input type="text" id="data"
					value="<%=ordine.getDataConsegna()%>" name="data" readonly></td>
				<td class="td-padding1"><button class="btn btn-danger" id="button-2">Modifica
						data e ora</button></td>
			</tr>

		</table>
	</div>

	<%
		}
	%>

<div class="modificaAttributo" id="div-modifica-stato">
	<form action="cambiaStato" method="post">
		<table>
			<tr>
				<td><label>Stato: </label>
				
				<select class="form-control" name="modifica-stato" id="modifica-stato" placeholder="categoria">
        <option value="<%= ordine.getStato() %>"><%= ordine.getStato() %></option>
        <option value="Consegnato">Consegnato</option>
        <option value="In transito">In transito</option>
        <option value="Verde">..</option>
      </select>
				
				
					<td><button type="submit" class="btn btn-danger" id="button-modifica-stato">Modifica</button></td>
			</tr>
		</table>
	</form>
	</div>
	
	<br><br>
	
	<div class="modificaAttributo" id="div-modifica-data-e-ora">
	<form action="cambiaDataEOra">	
		<table>
			<tr>
				<td><label>Data: </label><input type="date"
					placeholder="data" name="modifica-data" id="modifica-data"></td>
			</tr>
			<tr>
				<td><label>Ora:  </label><input type="text"
					placeholder="ora" name="modifica-ora" id="modifica-ora"></td>
			</tr>
			<tr>
				<td><button type="submit" class="btn btn-danger" id="buttone-modifica-data-e-ora">Modifica</button></td>
			</tr>
		</table>
	</form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="AmministratoreOrdini.js"></script>

</body>
</html>