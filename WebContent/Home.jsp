 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.*, model.*" %>

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css"> 
<meta charset="utf-8">
<title>PizzaPoint</title>
</head>

<body>
 <%@ include file="header.jsp"%>
 
<div id="slider">
  <div class="slides">
   <div class="slider">
      <div class="legend"></div>
      <div class="content">
        <div class="content-txt">
          <h1>Vesuvio</h1>
          <h2>Il Vesuvio è un vulcano situato in Italia, in posizione dominante rispetto al golfo di Napoli. È uno dei due vulcani attivi dell'Europa continentale nonché uno dei più studiati e pericolosi al mondo a causa dell'elevata popolazione delle zone circostanti e le sue caratteristiche esplosive.</h2>

        </div>
      </div>
      <div class="image">
        <img src="image/napoli.jpeg">
      </div>
    </div>
    
    <div class="slider">
      <div class="legend"></div>
      <div class="content">
        <div class="content-txt">
          <h1>Stimola la mente</h1>
          <h2>Degli studi hanno dimostrato che stimolare la mente aiuta a prevenire o rallentare lo sviluppo di malattie come l’Alzheimer e la demenza senile, poiché mantenere il tuo cervello sempre attivo e impegnato serve a non fargli perdere colpi. Come tutti gli altri muscoli del corpo anche il cervello ha bisogno di fare esercizi per mantenersi in forma perciò la frase “o lo usi o lo perdi” è particolarmente adatta quando si parla del tuo cervello. Anche fare puzzle e giocare a scacchi posso essere d’aiuto per la stimolazione celebrale.</h2>
        </div>
      </div>
      <div class="image">
        <img src="image/forno.jpg">
      </div>
    </div>
    <div class="slider">
      <div class="legend"></div>
      <div class="content">
        <div class="content-txt">
          <h1>Mozzarella Campana</h1>
          <h2>La mozzarella di bufala campana è un prodotto caseario dell'Italia Meridionale, prodotto tradizionalmente in Campania, soprattutto nelle province di Caserta e Salerno. La produzione di questo formaggio tipico si svolge anche in altre parti della Campania nonché nel Lazio meridionale</h2>
        </div>
      </div>
      <div class="image">
        <img src="image/mozz.jpg">
      </div>
    </div>
    <div class="slider">
      <div class="legend"></div>
      <div class="content">
        <div class="content-txt">
          <h1>Pomodori San Marzano</h1>
          <h2>Il pomodoro di San Marzano dell'agro sarnese-nocerino (DOP) è una varietà di pomodoro riconosciuta come prodotto ortofrutticolo italiano a Denominazione di origine protetta</h2>
        </div>
      </div>
      <div class="image">
        <img src="image/pomodoro.jpg">
      </div>
    </div>
  </div>
  <div class="switch">
    <ul>
      <li>
        <div class="on"></div>
      </li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </div>
</div>
 <%@ include file="footer.jsp"%>
</body>
</html>