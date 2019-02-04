<%
if(request.getSession().getAttribute("admin")!=null){
	boolean admin= (boolean) request.getSession().getAttribute("admin");
	if(!admin){
		response.sendRedirect("account.jsp");
	}
}
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
    <form class="px-4 px-3" action="login" method="post" name="login" id="form">
    <div class="form-group">
      <label for="exampleDropdownFormEmail1">Indirizzo E-mail</label>
      <input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com" name="email"  required>
    </div>
    <div class="form-group">
      <label for="exampleDropdownFormPassword1">Password</label>
      <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password" name="password" title="ciao" required>
    </div>
    <br>
    <%
    if(request.getSession().getAttribute("esiste")!=null)
    if((boolean)request.getSession().getAttribute("esiste")==false){
    %>
    <p id="error">password o email errati</p>
    <%request.getSession().removeAttribute("esiste"); } %>
   <button class="btn btn-danger" id="loginButton">Login</button>
 	</form>
 
</div>

</div>



<%@ include file="footer.jsp"%>
                      
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="ScriptJQ.js"></script> 


</body>
</html>