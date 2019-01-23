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
      <td><center><input type="submit" value="modifica"></center></td>
      <td><center><input type="submit" value="elimina"></center></td>
   
    </tr>
  
</table>
</div>
<%} 

request.getSession().removeAttribute("utenteCercato");
%>


</body>
</html>