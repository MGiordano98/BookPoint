<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Libro</title>
</head>
<body>

<%@ include file="header.jsp"%>




<div class="container-visualizza-libro"  >
<div class="visualizza-libro-immagine">
	<img src="../image/libro.jpg" >
</div >

<div class="container-visualizza-libro2">
<div class="intestazione-visualizza-libro" >
<h2>Nome autore</h2><h2>Nome autore</h2> <img src="../image/star.jpg">

</div>

<div class="descrizione-visualizza-libro">
Porco il demonio un bel libro
Con il libro Cuore di Edmondo De Amicis la letteratura italiana si arricchisce del romanzo di formazione più famoso e funzionale conosciuto, insieme al Pinocchio di Collodi. 
Dalla sua esperienza come giornalista e scrittore, uomo impegnato in uno dei periodi fra i più complessi della nostra storia, quello del Risorgimento e dell’Italia postunitaria, Edmondo de Amicis ricava la scrittura del romanzo “Cuore”, lettura quasi obbligata (scolasticamente e non) per ogni italiano fino agli anni Cinquanta del Novecento; ai giorni nostri questo romanzo è ancora oggetto di rivisitazioni sul grande e piccolo schermo che ne testimoniano la fondamentale importanza; è impossibile dimenticarlo!
Soffermandoci brevemente su questo laborioso autore che, oltre a Cuore, ha scritto dozzine di altre opere e vediamo gli eventi principali che ne caratterizzano la vita.  
</div>
</div>
</div>



<div class="container-dettagli-libro">
<div class="dettagli-libro" >
<span>Dettagli prodotto</span>
<span>Editore</span>
<span>ISBN</span>
<span>Categoria</span>
</div>
<div class="quantita-libro">
<span>Euro 3</span>
<span>Quantita</span>
<span>Quantita disponibile</span>
<center><input type="submit" value="aggiungi al carrello"></center>
</div>
</div>


<div class="container-recensione-libro">
<h2>Recensioni</h2>
Nome
<p>Porco il demonio un bel libro
Con il libro Cuore di Edmondo De Amicis la letteratura italiana si arricchisce del romanzo di formazione più famoso e funzionale conosciuto, insieme al Pinocchio di Collodi. 
Dalla sua esperienza come giornalista e scrittore, uomo impegnato in uno dei periodi fra i più complessi della nostra storia, quello del Risorgimento e dell’Italia postunitaria, Edmondo de Amicis ricava la scrittura del romanzo “Cuore”, lettura quasi obbligata (scolasticamente e non) per ogni italiano fino agli anni Cinquanta del Novecento; ai giorni nostri questo romanzo è ancora oggetto di rivisitazioni sul grande e piccolo schermo che ne testimoniano la fondamentale importanza; è impossibile dimenticarlo!
Sofferman</p>
</div>
<div class="container-aggiungi-recensione" >
<input id="titolo-recensione" type="text" placeholder="Titolo..." >
<textarea rows="4" cols="20" placeholder="Testo...">
</textarea>
<input "type="submit" value="aggiungi recensione" >
</div>





 <%@ include file="footer.jsp"%>





</body>
</html>