<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookPoint</title>
</head>
<body>

<%@ include file="headerAmministratoreOrdini.jsp"%>
<% Ordine ordine =(Ordine) request.getSession().getAttribute("ordine"); %>

<div class="container-cerca">
<div class="cerca">
  <form class="search-container" action="ricercaOrdine">
    <input  type="text" id="search-bar" placeholder="Cerca ordine" name="numOrdine">

<input type="submit" value="Cerca ordine">
  </form>
 </div>
 </div>
<%if(ordine==null){}
else{%>
<div class="container-ordine">
<h1>Ordine n°<%=ordine.getIdOrdine() %></h1>
<table style="border:2px solid; border-collapse:separate;border-spacing: 0 1em;">
  
  
    <tr>
      <td style="padding-right:25%;">Stato</td>
      <td style="padding-right:25%;"><%=ordine.getStato() %></td>
	  <td style="padding-right:5%;"><center><input type="submit" value="modifica"></center></td>  
    </tr>
    <tr>
      <td style="padding-right:25%;">Ora consegna</td>
      <td style="padding-right:25%;"><%=ordine.getOra() %></td>
      <td style="padding-right:5%;"><center><input type="submit" value="modifica"></center></td>
    </tr>
    <tr>
      <td style="padding-right:25%;">Data Consegna</td>
      <td style="padding-right:25%;"><%=ordine.getDataConsegna() %></td>
      <td style="padding-right:5%;"><center><input type="submit" value="modifica"></center></td>
    </tr>
  
</table>
</div>

<%}%>


</body>
</html>