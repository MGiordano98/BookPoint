<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="styleAmministratoreOrdini.css"> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"><link rel="stylesheet" type="text/css" href="styleCliente2.css"> 
<title>Header</title>
</head>
<body>



<header> 

<!-- <center><img src="../image/logo.jpg"></center>  -->

<div class="topnav" id="myTopnav">
	<a class="navbar-brand navbar-left-mio">
		<i class="fas fa-book fa-lg"></i>
	  </a>
	  
	  <a href="">Ordine</a>
	  <a class="logout" href="logout">Logout</a>

    	
	

 
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>



</header>

<script>
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}</script>
</body>
</html>