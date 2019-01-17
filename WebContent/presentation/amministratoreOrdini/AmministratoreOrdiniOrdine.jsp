<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookPoint</title>
</head>
<body>

<%@ include file="headerAmministratoreOrdini.jsp"%>

<div class="container-cerca">
<div class="cerca">
  <form class="search-container">
    <input  type="text" id="search-bar" placeholder="Cerca ordine">
    <a href="#"><i class="fas fa-search fa-lg"></i></a>
  </form>
</div>
<input type="submit" value="Cerca ordine">
</div>


<div class="container-ordine">
<h1>Ordine numero</h1>
<table style="border:2px solid; border-collapse:separate;border-spacing: 0 1em;">
  
  
    <tr>
      <td style="padding-right:25%;">Stato</td>
      <td style="padding-right:25%;">sdjsadsjsdsna</td>
	  <td style="padding-right:5%;"><center><input type="submit" value="modifica"></center></td>  
    </tr>
    <tr>
      <td style="padding-right:25%;">Ora arrivo</td>
      <td style="padding-right:25%;">13:22</td>
      <td style="padding-right:5%;"><center><input type="submit" value="modifica"></center></td>
    </tr>
    <tr>
      <td style="padding-right:25%;">Data Arrivo</td>
      <td style="padding-right:25%;">23/44/6666</td>
      <td style="padding-right:5%;"><center><input type="submit" value="modifica"></center></td>
    </tr>
  
</table>
</div>




</body>
</html>