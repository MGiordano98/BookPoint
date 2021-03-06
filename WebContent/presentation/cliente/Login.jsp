<%
	if (request.getSession().getAttribute("utente") != null) {
		Utente utenteC = (Utente) request.getSession().getAttribute("utente");
		if (!utenteC.getTipo().equalsIgnoreCase("cliente")) {
			if (utenteC.getTipo().equalsIgnoreCase("amministratore")) {
				response.sendRedirect("../amministratore/AmministratoreCatalogo.jsp");
			} else {
				response.sendRedirect("../amministratoreOrdini/AmministratoreOrdiniOrdine.jsp");
			}
		}}
%>

<!DOCTYPE html>
<html>
 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.*, model.*" %>

<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 
<meta charset="utf-8">
<title>BookPoint</title>
</head>
<body>

 <%@ include file="header.jsp"%>



<div class="divloginout">

<div class="divlogin">
	<img src="../image/libro.jpg" class="imglogin">
	<% int countLoginErrato=0;
	  if(request.getSession().getAttribute("countLoginErrato")!=null){
	  countLoginErrato= (int) request.getSession().getAttribute("countLoginErrato");
	}
	  if(countLoginErrato!=5){
		%>
    <form class="px-4 px-3" action="login" method="post" name="login" id="form" onsubmit="cripta()">
    <%} %>
    <div class="form-group">
      <label for="exampleDropdownFormEmail1">Indirizzo E-mail</label>
      <input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com" name="email"  required>
    </div>
    <div class="form-group">
      <label for="exampleDropdownFormPassword1">Password</label>
      <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password" name="password" pattern="[a-zA-Z0-9_.,\-+*!#@?]{8,25}" 
      			title="la lunghezza del campo password deve essere tra gli 8 ai 25" required>
    </div>
    <br>
    <%
    if(request.getSession().getAttribute("utenteNonTrovato")!=null)
    if((boolean)request.getSession().getAttribute("utenteNonTrovato")==true){
    %>
    <p id="error">password o email errati</p>
    <%request.getSession().removeAttribute("utenteNonTrovato"); } %>
    <%if(countLoginErrato==5){ %>
    <p id="error">hai effettuato troppi tentativi, riprova più tardi</p>
    <%} %>
   <button class="btn btn-danger" id="loginButton">Login</button>
  	
   <%if(countLoginErrato==5){ %>
  	
 	</form>
 	<%} %>
 	
 
</div>

</div>



<%@ include file="footer.jsp"%>
      
      
      
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script> 
<script>
</script>



</body>
</html>