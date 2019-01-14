<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>I miei preferiti</title>
</head>
<body>

 <%@ include file="header.jsp"%>

<h1>I miei preferiti</h1>


<div class="container-preferiti" >
<div class="preferiti-immagine">
	<img src="../image/principe.jpg" style="max-height: 150px">
</div >

<div class="container-preferiti2">
<div class="intestazione-preferiti" >
<h2>Nome libro</h2><h2>Nome autore</h2> <h4 style="float:right;">Prezzo</h4>

</div>

<div class="descrizione-preferiti" >
Porco il demonio un bel libroPorco il demonio un bel libroPorco il demonio un bel libroPorco il demonio un bel libroPorco il demonio un bel libroPorco il demonio un bel libro
Porco il demonio un bel libroPorco ico il demonisssssssssssssssssssssssssssssssssssssssssssssssssssssszsasadsadssadl 
</div>
	<div style="position:absolute; bottom:0; right:0;">
	<input type="submit" value="rimuovi">
	</div>
</div>




</div>



 <%@ include file="footer.jsp"%>

</body>
</html>