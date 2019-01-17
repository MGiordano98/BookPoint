<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookPoint</title>
</head>
<body>

<%@ include file="headerAmministratore.jsp"%>

<div class="container-cerca">
<div class="cerca">
  <form class="search-container">
    <input  type="text" id="search-bar" placeholder="Cerca account">
    <a href="#"><i class="fas fa-search fa-lg"></i></a>
  </form>
</div>
<input type="submit" value="Cerca account">
</div>


<div class="container-account">
<h1>Nome acocunt</h1>
<table style="border:2px solid;">
  
  
    <tr>
      <td>Email</td>
      <td>sdsdsd@gmail.com</td>
   
    </tr>
      <tr>
      <td>Tipo</td>
      <td>tipoooo</td>
   
    </tr>
        <tr>
      <td><center><input type="submit" value="modifica"></center></td>
      <td><center><input type="submit" value="elimina"></center></td>
   
    </tr>
  
</table>
</div>




</body>
</html>