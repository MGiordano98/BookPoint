<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="bean.Utente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookPoint</title>
</head>
<body>
<%@ include file="headerAmministratore.jsp"%>
<% Utente utente=(Utente) request.getSession().getAttribute("utenteCercato") ;%>
<div class="container-cerca">
<div class="cerca">
  <form class="search-container" action="ricercaAccount" >
    <input  type="text" id="search-bar" placeholder="Cerca account" name="email">
    <input type="submit" value="Cerca account">
  </form>
</div>
</div>

<%if(utente==null){
	
} else{%>
<div class="container-account">
<h1><%=utente.getNome()%> <%=utente.getCognome() %></h1>
<table style="border:2px solid;">
  
  
    <tr>
      <td>Email</td>
      <td><%=utente.getEmail() %></td>
   
    </tr>
      <tr>
      <td>Tipo</td>
      <td><%=utente.getTipo() %></td>
   
    </tr>
        <tr>
      <td><center><input type="submit" value="modifica" class=modificaTipo></center></td>
      <td>
      	<form action="eliminaUtente">
      		<input type=hidden value=<%=utente.getEmail()%> name=email>
      		<center><input type="submit" value="elimina"></center>
      	</form>
      </td>
   
    </tr>
  
</table>
</div>

<div class="formModificaTipo" style="display:none; position:fixed; width:15%; margin-left:42%; top:30%;">
	<form action="cambiaTipo">
		<input type="hidden" value=<%=utente.getEmail() %> name="email">
		<select name=tipo>
		<%if(utente.getTipo().equalsIgnoreCase("cliente")){ %>
		<option value=amministratore>amministratore</option>
		<option value=amministratoreOrdini>amministratoreOrdini</option>
		<%}else if(utente.getTipo().equalsIgnoreCase("amministratore")) {%>
		<option value=cliente>cliente</option>
		<option value=amministratoreOrdini>amministratoreOrdini</option>
		<%}else{ %>
		<option value=cliente>cliente</option>
		<option value=amministratore>amministratore</option>
		<%} %>
		</select>
		<input type=submit value=modifica>
	</form>
</div>
<%} 

request.getSession().removeAttribute("utenteCercato");
%>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="Amministratore.js"></script>


</body>
</html>