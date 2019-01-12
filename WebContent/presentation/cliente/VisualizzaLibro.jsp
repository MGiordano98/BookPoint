<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Libro</title>
</head>
<body>

<%@ include file="header.jsp"%>




<div class="container-preferiti" style="height:350px" >
<div class="preferiti-immagine">
	<img src="../image/libro.jpg" style="width:100%; height:100%">
</div >

<div class="container-preferiti2">
<div class="intestazione-preferiti" >
<h2>Nome autore</h2><h2>Nome autore</h2> <img  style="witdh:34px;height:34px"src="../image/star.jpg">

</div>

<div class="descrizione-preferitissfs" style="witdh:100%;">
Porco il demonio un bel libro
Con il libro Cuore di Edmondo De Amicis la letteratura italiana si arricchisce del romanzo di formazione più famoso e funzionale conosciuto, insieme al Pinocchio di Collodi. 
Dalla sua esperienza come giornalista e scrittore, uomo impegnato in uno dei periodi fra i più complessi della nostra storia, quello del Risorgimento e dell’Italia postunitaria, Edmondo de Amicis ricava la scrittura del romanzo “Cuore”, lettura quasi obbligata (scolasticamente e non) per ogni italiano fino agli anni Cinquanta del Novecento; ai giorni nostri questo romanzo è ancora oggetto di rivisitazioni sul grande e piccolo schermo che ne testimoniano la fondamentale importanza; è impossibile dimenticarlo!
Soffermandoci brevemente su questo laborioso autore che, oltre a Cuore, ha scritto dozzine di altre opere e vediamo gli eventi principali che ne caratterizzano la vita.  
</div>
</div>
</div>



<div style="margin-top:5%;margin-left:5%;margin-right:5%;display:flex">
<div style="width:50%;display:inline-grid">
<span>Dettagli prodotto</span>
<span>Editore</span>
<span>ISBN</span>
<span>Categoria</span>
</div>
<div style="width:30%;display:inline-grid">
<span>Euro 3</span>
<span>Quantita</span>
<span>Quantita disponibile</span>
<center><input type="submit" value="aggiungi al carrello"></center>
</div>
</div>


<div  style="width:80%;margin-top:5%;margin-left:5%;">
<h2>Recensioni</h2>
Nome
<p>Porco il demonio un bel libro
Con il libro Cuore di Edmondo De Amicis la letteratura italiana si arricchisce del romanzo di formazione più famoso e funzionale conosciuto, insieme al Pinocchio di Collodi. 
Dalla sua esperienza come giornalista e scrittore, uomo impegnato in uno dei periodi fra i più complessi della nostra storia, quello del Risorgimento e dell’Italia postunitaria, Edmondo de Amicis ricava la scrittura del romanzo “Cuore”, lettura quasi obbligata (scolasticamente e non) per ogni italiano fino agli anni Cinquanta del Novecento; ai giorni nostri questo romanzo è ancora oggetto di rivisitazioni sul grande e piccolo schermo che ne testimoniano la fondamentale importanza; è impossibile dimenticarlo!
Sofferman</p>
</div>
<div  style="display:grid;width:80%;margin-top:3%;margin-left:5%;">
<input style="margin-bottom:0.3%;" type="text" value="Titolo..." >
<textarea rows="4" cols="50">
At w3schools.com you will learn how to make a website. We offer free tutorials in all web development technologies. 
</textarea>
<input type="submit" value="aggiungi recensione" >
</div>





 <%@ include file="footer.jsp"%>





</body>
</html>