<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"><link rel="stylesheet" type="text/css" href="style.css"> 
<title>Header</title>
</head>
<body>



<header> 
<div class="LogoPizzaPoint">
  <p class="script"></p>
  <p class="shadow-logo text1">Book</p>
  <p class="shadow-logo text1">Point</p>
  <p class="script"><span>Dal 1989</span></p>
</div>


<div class="topnav" id="myTopnav">
	<a class="navbar-brand navbar-left-mio" href="Home.jsp">
		<i class="fas fa-book fa-lg"></i>
	  </a>
	  
	  <a href="libro">Libri</a>
	  <a class="nav-link" href="carrello.jsp"><i class="fas fa-shopping-cart"></i></a>
	  <a href="libro">Preferiti</a>
	  <a class="nav-link utenteutente" href="Login.jsp" style="margin:0;margin-left:40px;padding-left:40px"><i class="fas fa-user-circle fa-lg"></i>  </a>


    	
	

  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>



</header>

</body>
</html>