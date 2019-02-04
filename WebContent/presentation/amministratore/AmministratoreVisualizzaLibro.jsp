<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="styleAmministratore.css">
 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookPoint</title>
</head>
<body>
<%@ include file="headerAmministratore.jsp"%>
<%
Libro libro=(Libro) request.getSession().getAttribute("libro");
Collection<Recensione> recensioni=libro.getRecensioni(); 
%>




<table class="table table">
  
  <tbody>
  <tr>
      <td>Immagine</td>
      <td colspan="2" id="fotoLibro"><%=libro.getFoto() %></td>
    <td> <center></center></td>
    </tr>
      <tr>
      <td>Titolo</td>
      <td colspan="2" id="titoloLibro"><%=libro.getTitolo() %></td>
	  <td><center><button data-toggle="modal" data-target="#exampleModal" class="btn btn-danger" type="submit" value="modifica"  class="modificaTitolo">Modifica</button></center></td>
    </tr>
      <tr>
      <td>Editore</td>
      <td colspan="2" id="editoreLibro" ><%=libro.getCasaEditrice() %></td>
	  <td><center><button data-toggle="modal" data-target="#exampleModal1" class="btn btn-danger" type="submit" value="modifica"  class="modificaEditore">Modifica</button></center></td>
    </tr>
     <tr>
      <td>ISBN</td>
      <td colspan="2" id="isbnLibro" ><%=libro.getIsbn() %></td>
      <td><center><button data-toggle="modal" data-target="#exampleModal2" class="btn btn-danger" type="submit" value="modifica"  class="modificaISBN">Modifica</button></center></td>
    </tr>
      <tr>
      <td>Categoria</td>
      <td colspan="2" id="categoriaLibro"><%=libro.getCategoria()%></td>
	  <td><center><button data-toggle="modal" data-target="#exampleModal3" class="btn btn-danger" type="submit" value="modifica"  class="modificaCategoria">Modifica</button></center></td>
    </tr>
      
     <tr>
      <td>Descrizione</td>
      <td  id="descrizioneLibro" colspan="2"><%=libro.getTrama() %></td>
      <td><center><button data-toggle="modal" data-target="#exampleModal4" class="btn btn-danger" type="submit" value="modifica"  class="modificaDescrizione">Modifica</button></center></td>
    </tr>
     <tr>
      <td>Prezzo</td>
      <td colspan="2" id="prezzoLibro" ><%=libro.getPrezzo()+"€" %></td>
      <td><center><button data-toggle="modal" data-target="#exampleModal5" class="btn btn-danger" type="submit" value="modifica"  class="modificaPrezzo">Modifica</button></center></td>
    </tr>
      <tr>
      <td>Quantita</td>
      <td colspan="2" id="quantitaLibro"><%=libro.getQuantità()%></td>
	  <td><center><button data-toggle="modal" data-target="#exampleModal6" class="btn btn-danger" type="submit" value="modifica"  class="modificaQauntita">Modifica</button></center></td>
    </tr>
      <tr>
      <td></td>
      <td><center><form action="eliminaLibro" method="post">
      		<input type="hidden" name="isbn" value="<%=libro.getIsbn() %>" >
      		<button class="btn btn-danger" type="submit" value="elimina" >Elimina</button>
      		
      		</form></center></td>
	  <td></td>
    </tr>
  </tbody>
</table>


<div class="container-recensione-libro">
<h2>Recensioni</h2>
<div class="container-recensione" >

  
<% 
Iterator it2=recensioni.iterator();
int i=0;
while(it2.hasNext()){
Recensione recensione=(Recensione) it2.next();%>
   

     		<div class="container-informazioni-recensioni" id="div-recensione<%=i %>" >
     		<form action="eliminaRecensione" method="post">
     		<h6><%=recensione.getEmail() %></h6>
			<p><%=recensione.getTesto() %></p>
     		<input type="hidden"  value="<%=recensione.getId() %>" name="idRecensione" id="recensione<%=i%>">
			<button   type="button" class="btn btn-danger bottone-elimina" id="<%=i%>"> x </button>
     		</form>
     		</div>
     		
     
  <%i++; } %>

</div>

</div>


<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<h5 class="modal-title" id="exampleModalLabel">Modifica
					Titolo</h5>

					<div class="modal-header">
						<button type="button" class="close close-mio" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<table>
							<!-- Modifica  DATI Libro -->
							<tr>
						
								<td class="td-bold"><label for="titolo">Titolo</label></td>
								<td><input type="text" name="nuovoAttributo" id="titoloNuovoAttributo"><br></td>
							</tr>

						</table>

					<input type="hidden" name="tipo" value="titolo" id="titoloTipo">

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary modificaButton" id="titolo">Modifica</button>
					</div>

			</div>
		</div>
	</div>
	
			
		<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<h5 class="modal-title" id="exampleModalLabel">Modifica
					Editore</h5>

					<div class="modal-header">
						<button type="button" class="close close-mio" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<table>
							<!-- Modifica  DATI Libro -->
							<tr>
						
								<td class="td-bold"><label for="editore">Editore</label></td>
								<td><input type="text" name="nuovoAttributo" id="editoreNuovoAttributo"><br></td>
							</tr>

						</table>

					<input type="hidden" name="tipo" value="editore" id="editoreTipo">

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary modificaButton" id="editore">Modifica</button>
					</div>

			</div>
		</div>
	</div>
		<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<h5 class="modal-title" id="exampleModalLabel">Modifica
					isbn</h5>

					<div class="modal-header">
						<button type="button" class="close close-mio" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<table>
							<!-- Modifica  DATI Libro -->
							<tr>
						
								<td class="td-bold"><label for="isbn">isbn</label></td>
								<td><input type="text" name="nuovoAttributo" id="isbnNuovoAttributo"><br></td>
							</tr>

						</table>

					<input type="hidden" name="tipo" value="isbn" id="isbnTipo">

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary modificaButton" id="isbn">Modifica</button>
					</div>

			</div>
		</div>
	</div>
		<div class="modal fade" id="exampleModal3" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<h5 class="modal-title" id="exampleModalLabel">Modifica
					Categoria</h5>

					<div class="modal-header">
						<button type="button" class="close close-mio" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<table>
							<!-- Modifica  DATI Libro -->
							<tr>
						
								<td class="td-bold"><label for="categoria">Categoria</label></td>
								<td><input type="text" name="nuovoAttributo" id="categoriaNuovoAttributo"><br></td>
							</tr>

						</table>

					<input type="hidden" name="tipo" value="categoria" id="categoriaTipo">

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary modificaButton" id="categoria">Modifica</button>
					</div>

			</div>
		</div>
	</div>
		<div class="modal fade" id="exampleModal4" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<h5 class="modal-title" id="exampleModalLabel">Modifica
					Descrizione</h5>

					<div class="modal-header">
						<button type="button" class="close close-mio" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<table>
							<!-- Modifica  DATI Libro -->
							<tr>
						
								<td class="td-bold"><label for="descrizione">Descrizione</label></td>
								<td><input type="text" name="nuovoAttributo" id="descrizioneNuovoAttributo"><br></td>
							</tr>

						</table>

					<input type="hidden" name="tipo" value="descrizione" id="descrizioneTipo">

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary modificaButton" id="descrizione">Modifica</button>
					</div>

			</div>
		</div>
	</div>

	<div class="modal fade" id="exampleModal5" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<h5 class="modal-title" id="exampleModalLabel">Modifica
					Prezzo</h5>

					<div class="modal-header">
						<button type="button" class="close close-mio" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<table>
							<!-- Modifica  DATI Libro -->
							<tr>
						
								<td class="td-bold"><label for="prezzo">Prezzo</label></td>
								<td><input type="text" name="nuovoAttributo" id="prezzoNuovoAttributo"><br></td>
							</tr>

						</table>

					<input type="hidden" name="tipo" value="prezzo" id="prezzoTipo">

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary modificaButton" id="prezzo">Modifica</button>
					</div>

			</div>
		</div>
	</div>
	
		<div class="modal fade" id="exampleModal6" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<h5 class="modal-title" id="exampleModalLabel">Modifica
					Quantita</h5>

					<div class="modal-header">
						<button type="button" class="close close-mio" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<table>
							<!-- Modifica  DATI Libro -->
							<tr>
						
								<td class="td-bold"><label for="quantita">Quantita</label></td>
								<td><input type="number"  min="1" max="100"
						value="1" name="nuovoAttributo" id="quantitaNuovoAttributo"><br></td>
							</tr>

						</table>

					<input type="hidden" name="tipo" value="quantita" id="quantitaTipo">

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary modificaButton" id="quantita">Modifica</button>
					</div>

			</div>
		</div>
	</div>
















<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="Amministratore.js"></script>

</body>
</html>