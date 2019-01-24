<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.util.*,bean.*,control.gestioneRicerca.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleAmministratore.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookPoint</title>
</head>
<body>
	<%@ include file="headerAmministratore.jsp"%>
	<%
		Collection<?> libri = (Collection<?>) request.getSession().getAttribute("libri");
	%>

	<div class="barra-superiore" style="display: inline;">
		<input id="bottone-aggiungi-libro" type="submit"
			value="aggiungi libro" style="float: left">

		<form class="search-container" action="ricerca">


			<input size=50 type="text" id="search-bar" placeholder="Cerca libro"
				name="testo"> <a><i id="search-button"
				class="fas fa-search fa-lg"></i></a> <select name="categoria"
				id="categoria" style="float: right">
				<option value=""></option>
				<option value="Romanzo">Romanzo</option>
				<option value="opel">Opel</option>
				<option value="audi">Audi</option>
			</select>

		</form>

	</div>

	<div class="container-inserimento"
		style="display: none; margin-left: 40%;">

		<form action="aggiungiLibro">

			<label for="isbn">Isbn</label><input id="isbn" type="text"
				name="isbn" placeholder="isbn"><br> <label for="titolo">titolo</label><input
				id="titolo" type="text" name="titolo" placeholder="titolo"><br>
			<label for="trama">trama</label><input id="trama" type="text"
				name="trama" placeholder="trama"><br> <label
				for="casaEditrice">casa editrice</label><input id="casaEditrice"
				type="text" name="casaEditrice" placeholder="casa editrice"><br>
			<label for="prezzo">prezzo</label><input id="prezzo" type="text"
				name="prezzo" placeholder="prezzo"><br> <label
				for="quantità">quantità</label><input id="quantità" type="number"
				min="1" max="100" name="quantità" id="" min="1" value="1"><br>
			<label for="categoria">categoria</label><input id="categoria"
				type="text" name="categoria" placeholder="categoria"><br>
			<label for="foto">foto</label><input id="foto" type="file" name="pic"
				accept="image/*"><br>
			<button type="button" id="bottone-inserisci-autori">Inserisci autori</button>

			<div class="aggiungi-autori" style="display:none">
				<button type="button" class="btn bottone-aggiungi-autore">+</button>
				<div class="aggiungi-autore">
					Nome: <input type="text">
				</div>
			</div>
			<input type="submit"><br>

		</form>

	</div>
	<%
		if (libri == null) {

		} else if (libri.size() == 0) {
	%>

	<div id="libro-non-trovato-display">
		<h2>Nessun libro trovato</h2>
	</div>
	<%
		request.getSession().removeAttribute("libri");
		} else {
			Iterator it = libri.iterator();
			while (it.hasNext()) {
				Libro bean = (Libro) it.next();
	%>

	<div class="libro-trovato-display">
		<div>
			<img alt="" src="../image/<%=bean.getFoto()%>">
		</div>
		<div>
			<div>
				<h5><%=bean.getTitolo()%></h5>
			</div>
			<div>
				<%
					for (Autore autore : bean.getAutori()) {
				%>
				<h6><%=autore.getNome() + " "%></h6>
				<%
					}
				%>
			</div>
			<div>
				<p><%=bean.getTrama().substring(0, 200)%></p>
			</div>
		</div>


	</div>



	<%
		}
			request.getSession().removeAttribute("libri");
		}
	%>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="Amministratore.js"></script>

</body>
</html>