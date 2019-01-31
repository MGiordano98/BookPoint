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
    <td> <center><button  class="btn btn-danger" type="submit" value="modifica"  class="modificaImmagine">Modifica</button></center></td>
    </tr>
      <tr>
      <td>Titolo</td>
      <td colspan="2" id="titoloLibro"><%=libro.getTitolo() %></td>
	  <td><center><button data-toggle="modal" data-target="#exampleModal" class="btn btn-danger" type="submit" value="modifica"  class="modificaTitolo">Modifica</button></center></td>
    </tr>
      <tr>
      <td>Editore</td>
      <td colspan="2"><%=libro.getCasaEditrice() %></td>
	  <td><center><button class="btn btn-danger" type="submit" value="modifica"  class="modificaEditore">Modifica</button></center></td>
    </tr>
     <tr>
      <td>ISBN</td>
      <td colspan="2"><%=libro.getIsbn() %></td>
      <td><center><button class="btn btn-danger" type="submit" value="modifica"  class="modificaISBN">Modifica</button></center></td>
    </tr>
      <tr>
      <td>Categoria</td>
      <td colspan="2"><%=libro.getCategoria()%></td>
	  <td><center><button class="btn btn-danger" type="submit" value="modifica"  class="modificaCategoria">Modifica</button></center></td>
    </tr>
      
     <tr>
      <td>Descrizione</td>
      <td style="word-wrap:break-word;"colspan="2"><%=libro.getTrama() %></td>
      <td><center><button class="btn btn-danger" type="submit" value="modifica"  class="modificaDescrizione">Modifica</button></center></td>
    </tr>
     <tr>
      <td>Prezzo</td>
      <td colspan="2"><%=libro.getPrezzo()+"€" %></td>
      <td><center><button class="btn btn-danger" type="submit" value="modifica"  class="modificaPrezzo">Modifica</button></center></td>
    </tr>
      <tr>
      <td>Quantita</td>
      <td colspan="2"><%=libro.getQuantità()%></td>
	  <td><center><button class="btn btn-danger" type="submit" value="modifica"  class="modificaQauntita">Modifica</button></center></td>
    </tr>
  </tbody>
</table>


<h1>Recensioni</h1>

<table >
  
<% 
Iterator it2=recensioni.iterator();
while(it2.hasNext()){
Recensione recensione=(Recensione) it2.next();%>
    <tr>
      <td><%=recensione.getEmail() %></td>
     </tr>
     <tr>
      <td><%=recensione.getTesto() %></td>
     </tr>
     <tr>
     	<td>
     		<form action="eliminaRecensione">
     			<input type=hidden  value="<%=recensione.getId() %>" name="idRecensione">
     			<input type=submit value="x">
     		</form>
     	</td>
     </tr>
  <%} %>
</table>





<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<h5 class="modal-title" id="exampleModalLabel">Modifica
					Titolo</h5>

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<table>
							<!-- Modifica  DATI Libro -->
							<tr>
						
								<td class="td-bold"><label for="isbn">Titolo</label></td>
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


















<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="Amministratore.js"></script>

</body>
</html>