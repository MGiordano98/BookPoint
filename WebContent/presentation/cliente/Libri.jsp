<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 

<title>Libri</title>
</head>
<body>
<%@ include file="header.jsp"%>

<div>
<div class="cerca" style="width:60%;text-align:right;">
  <form class="search-container">
    <input  style="width:90%;"type="text" id="search-bar" placeholder="Cerca libro">
    <a href="#"><i class="fas fa-search fa-lg"></i></a>
  </form>
</div>
<select>
  <option value="Tutte le categorie"></option>
  <option value="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
</div>















<%@ include file="footer.jsp"%>
</body>


</html>