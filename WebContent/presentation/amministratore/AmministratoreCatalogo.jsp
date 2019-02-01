<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.util.*,bean.*,control.gestioneRicerca.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="styleAmministratore.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookPoint</title>
</head>
<body>
	<%@ include file="headerAmministratore.jsp"%>
	<%
		Collection<?> libri = (Collection<?>) request.getSession().getAttribute("libri");
	%>


	<div class="container-barra">

<button class="btn btn-danger add-libro">
			<i class="fas fa-plus"></i>
		</button>

		<form class="example" action="ricerca">
		<select class="form-control" name="categoria" id="sel1" placeholder="categoria">
		<option selected hidden value="">categoria</option>
        <option value="Avventura">Avventura</option>
        <option value="Romanzo">Romanzo</option>
        <option value="Giallo">Giallo</option>
        <option value="Verde">Verde</option>
      </select>
			<input type="text" placeholder="cerca libro..." name="testo">
			<button class=" btn btn-danger"id="search-button" type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form>
	</div>

	<!-- AGGIUNGI LIBRO -->
	<div class="container-inserimento">

		<!-- FORM -->
		<form action="aggiungiLibro" method="post">
			<table>
				<!-- INSERIMENTO DATI LIBRO -->
				<tr>
					<td class="td-bold"><label for="isbn">Isbn</label></td>
					<td><input id="isbn" type="text" name="isbn"
						placeholder="isbn"><br></td>
				</tr>

				<tr>
					<td class="td-bold"><label for="titolo">titolo</label></td>
					<td><input id="titolo" type="text" name="titolo"
						placeholder="titolo"><br></td>
				</tr>

				<tr>
					<td class="td-bold"><label for="trama">trama</label></td>
					<td><input id="trama" type="text" name="trama"
						placeholder="trama"><br></td>
				</tr>

				<tr>
					<td class="td-bold"><label for="casaEditrice">casa editrice</label></td>
					<td><input id="casaEditrice" type="text" name="casaEditrice"
						placeholder="casa editrice"><br></td>
				</tr>

				<tr>
					<td class="td-bold"><label for="prezzo">prezzo</label></td>
					<td><input id="prezzo" type="text" name="prezzo"
						placeholder="prezzo"><br></td>
				</tr>

				<tr>
					<td class="td-bold"><label for="quantità">quantità</label></td>
					<td><input type="number" id="quantità" min="1" max="100"
						name="quantita" value="1"><br></td>
				</tr>

				<tr>
					<td class="td-bold"><label for="categoria">categoria</label></td>
					<td><input id="categoria" type="text" name="categoria"
						placeholder="categoria"><br></td>
				</tr>

				<tr>
					<td class="td-bold"><label for="foto">foto</label></td>
					<td><input id="foto" type="file" name="foto" accept="image/*"><br></td>
				</tr>


				<tr>
					<td class="td-bold"><label for="dataUscita">data uscita</label></td>
					<td><input id="dataUscita" type="date" name="dataUscita"><br></td>
				</tr>

				<tr>
					<td ><button type="button" class="btn btn-danger" id="bottone-inserisci-autori">Inserisci
							autori</button></td>
					<td><input class=" btn btn-primary"type="submit"><br></td>
				</tr>
				<!-- AGGIUNGI AUTORI -->
			</table>
			<div class="aggiungi-autori td-bold" >
				<button type="button" class="btn btn-danger bottone-aggiungi-autore">+</button>
				<div class="aggiungi-autore ">
					Nome: <input type="text" name="autore">
				</div>
			</div>
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

	<div class="container-libri-trovati">
		<div class="immagine-libro-trovato">
			<img alt="" src="../image/<%=bean.getFoto()%>" class="visualizza"
				name=<%=bean.getIsbn()%>>
		</div>
		<div class="container-informazioni-libro">
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
			<div><%if(bean.getTrama().length()>=200){ %>
				<p><%=bean.getTrama().substring(0, 200)%></p>
				<%} else { %>
				<p><%=bean.getTrama() %>
				<%} %>
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