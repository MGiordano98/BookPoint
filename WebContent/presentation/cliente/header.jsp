<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="bean.*"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"><link rel="stylesheet" type="text/css" href="styleCliente2.css"> 
<title>Header</title>
</head>
<body>



<header> 

<center><img src="../image/logo.jpg"></center>

<div class="topnav" id="myTopnav">
	<a class="navbar-brand navbar-left-mio" href="Home.jsp">
		<i class="fas fa-book fa-lg"></i>
	  </a>
	  
	  <a href="../../VisualizzaCatalogo">Libri</a>
	  <a class="nav-link" href="Carrello.jsp"><i class="fas fa-shopping-cart"></i></a>
	  <% Utente utente=(Utente) session.getAttribute("utente"); 
	  if(utente!=null) {%>
	  <a href="../../VisualizzaPreferiti">Preferiti</a>
	  <a class="nav-link " href="AreaPersonale.jsp" ><i class="fas fa-user-circle fa-lg"></i>  </a>
	  <%} else { %>
	  <a href="../../VisualizzaPreferiti"> </a>
	  <%}if(utente==null){ %>
	  <a class="nav-link utente" href="Login.jsp" ><i class="fas fa-user-circle fa-lg"></i>  </a>
	  <%} else {%>
	   <a class="nav-link utente-login" href="Login.jsp" ><i class="fas fa-user-circle fa-lg"></i>  </a>
	   <a class="logout" href="logout"><i class="fas fa-sign-out-alt"></i></a>
<%} %>


    	
    	
	

  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>



</header>

</body>
</html>