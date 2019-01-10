<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*, control.*, model.*" %>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css"> 
<meta charset="ISO-8859-1">
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
          <h1>Pizza Margherita</h1>
          <h2>E' una tipica pizza napoletana , fatta con pomodori San Marzano , mozzarella fior di latte,basilico fresco , sale e olio extra vergine di oliva .</h2>
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