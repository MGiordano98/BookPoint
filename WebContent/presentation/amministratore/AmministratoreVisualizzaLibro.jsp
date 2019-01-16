<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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





<table class="table table">
  
  <tbody>
  <tr>
      <td>Immagine</td>
      <td colspan="2">Nome immagine</td>
    <td> <center> <input type="submit" value="modifica"></center></td>
    </tr>
      <tr>
      <td>Titolo</td>
      <td colspan="2">Nome titolo</td>
	  <td><center><input type="submit" value="modifica"></center></td>
    </tr>
     <tr>
      <td>Autore</td>
      <td colspan="2">Nome Autore</td>
      <td><center><input type="submit" value="modifica"></center></td>
    </tr>
      <tr>
      <td>Editore</td>
      <td colspan="2">Nome editore</td>
	  <td><center><input type="submit" value="modifica"></center></td>
    </tr>
     <tr>
      <td>ISBN</td>
      <td colspan="2">isbn</td>
      <td><center><input type="submit" value="modifica"></center></td>
    </tr>
      <tr>
      <td>Categoria</td>
      <td colspan="2">Nome categoria</td>
	  <td><center><input type="submit" value="modifica"></center></td>
    </tr>
      
     <tr>
      <td>Descrizione</td>
      <td style="word-wrap:break-word;"colspan="2">contenti e che vi farà del bene</td>
      <td><center><input type="submit" value="modifica"></center></td>
    </tr>
     <tr>
      <td>Euro</td>
      <td colspan="2">3,30</td>
      <td><center><input type="submit" value="modifica"></center></td>
    </tr>
      <tr>
      <td>Quantita</td>
      <td colspan="2">1</td>
	  <td><center><input type="submit" value="modifica"></center></td>
    </tr>
  </tbody>
</table>


<h1>Recensioni</h1>
<div style="position:relative;display: -webkit-box;float: inherit;border:1px solid;" class="container">
<a><i style="position:absolute;right:2px;" class="fas fa-times"></i></a>
<table >
  
  
    <tr>
      <td>Immagine</td>
      <td>Nome immagine</td>
   
    </tr>
      <tr>
      <td>Immagine</td>
      <td>Nome immagine</td>
   
    </tr>
      <tr>
      <td>Immagine</td>
      <td>Nome immagine</td>
   
    </tr>
       
      <tr>
      <td>Immagine</td>
      <td colspan="2">Nome immagine</td>
   
    </tr>
  
</table>
</div>

</body>
</html>