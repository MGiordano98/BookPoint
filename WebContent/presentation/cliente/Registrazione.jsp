<!DOCTYPE html>
<html>
 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.*, model.*" %>
<head>
<script src="scripts/jquery-3.3.1.min.map.Js"></script> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 
<meta charset="utf-8">
<title>BookPoint</title>
</head>
<body>

 <%@ include file="header.jsp"%>



<div class="divregistrazione">
	<img src="../image/libro.jpg">
  <form class="px-4 py-3" action="registrazione" method="post" role="form">
    <div class="form-group divformgroup">
      <label for="exampleDropdownFormEmail1">Nome</label>
      <input type="text" class="form-control" id="nomeInput" placeholder="nome" name="nome" pattern="^[a-zA-Z\s]{3,}$" required>
      <label for="exampleDropdownFormEmail1">Cognome</label>
      <input type="text" class="form-control" id="cognome" placeholder="cognome" name="cognome" pattern="^[a-zA-Z\S]{3,}$" required>
      <label for="exampleDropdownFormEmail1">Indirizzo E-mail</label>
      <input type="email" class="form-control" id="email" placeholder="email@example.com" name="email" pattern="^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$" required>
      <label for="exampleDropdownFormPassword1">Password</label>
      <input type="password" class="form-control" id="password" placeholder="Password" name="password" pattern="^[a-zA-Z0-9_.,\-+*!#@?]{8,25}$" required>
    <button type="submit" class="btn btn-primary">Invia</button>
    </div>
  </form>
</div>


<%@ include file="footer.jsp"%>
                      


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</body>
</html>