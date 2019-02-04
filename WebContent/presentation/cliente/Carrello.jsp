<!-- 
  
  -->
 
<!DOCTYPE html>
<html>
 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.gestioneAcquisto.*, model.*,java.lang.Math, carrello.*" %>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 
<meta charset="utf-8">
<title>PizzaPoint</title>
</head>
<body>



<div class="divcarrello">


 <%@ include file="header.jsp"%>


<div class="contenitore">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
        
            <table class="table table-hover" id="table">
                <thead>
                    <tr>
                        <th>Prodotto</th>
                        <th>Quantità</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Totale</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                
     
			<%

			if(request.getSession().getAttribute("carrello")!=null){
				Carrello carrello= (Carrello) request.getSession().getAttribute("carrello");
				Collection<?> libri= carrello.getLibri();
				Iterator it= libri.iterator();
				
				while(it.hasNext()){
					Libro libro = (Libro) it.next();
					%>
					
			
                
                    <tr>
                        <td class="col-sm-6 col-md-5">
                        <div class="media">
                            <a class="thumbnail pull-left "> <img class="media-object" id="" src="../image/<%=libro.getFoto()%>" >	</a>
                            <p class="thumbnail trama"><%=libro.getTrama().substring(0, 200) %>...</p>
                            <div class="media-body">
                                <h4 class="media-heading" id="nome"></h4>                         
                            </div>
                        </div></td>
                       
                        
                        <td class="col-sm-3 col-md-2 td-center" >
                                                
                        <button type="button" class="btn btn-md quantita-selezionata" id="quantità<%=libro.getIsbn()%>"> <%=libro.getQuantitàSelezionata()%> </button>
                        <div class="container-carrello" >
                        <a class="modifica-quantità aumenta" title="<%=libro.getIsbn()%>"><strong>+</strong></a>
                        <a class="modifica-quantità diminuisci" title="<%=libro.getIsbn()%>"><strong>-</strong></a>
                        </div>
                        <input type="hidden" id="codice" value="">
                        </td>
                        
                        <td class="col-sm-1 col-md-1 text-center"><strong><span id="prezzo<%=libro.getIsbn()%>"> <%=Math.round(libro.getPrezzo()*100.0)/100.0%></span></strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong><span id="prezzotot<%=libro.getIsbn()%>"> <%=Math.round((libro.getPrezzo() * libro.getQuantitàSelezionata()) *100.0)/100.0%></span></strong></td>
                        <td class="col-sm-1 col-md-1"> 
                        <form action="eliminaDalCarrello" method="post">                       	
                        	<input type="hidden" name="isbn" value="<%=libro.getIsbn()%>">
                        <button type="submit" id="" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Rimuovi
                        </button>
                        </form></td>
                    </tr>
                 
              		<%
				}
			%>  



				
                </tbody>
                <tfoot>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h2>Total</h2><h3></h3></td>
                        <td class="text-right">
                        <h3><span id="totaleProdotti"><%=Math.round(carrello.getTotale()*100.0)/100.0 %></span></h3>
                        <h5><strong><span id="tot"></span><br></strong></h5>
                        </td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
             
                        <td>

                     <%  if(request.getSession().getAttribute("utente")!=null){  %>
		                <a href="selezionaCartaEIndirizzo">
                        <button type="submit" class="btn btn-success" id="ordinaButton">
                            Ordina!<span class="glyphicon glyphicon-play"></span>
                        </button>
   
                       </a>

					<% }else{%>
					
						<a href="Login.jsp">
						<button type="submit" class="btn btn-success" id="ordinaButton">
                            Effettua il Login!<span class="glyphicon glyphicon-play"></span>
                        </button>
   
                       </a>
						
					<%} %>

                        </td>
                    </tr>
                </tfoot>
                <%
				}
                %>
                
            </table>
        </div>
    </div>
   
</div>


 <%@ include file="footer.jsp"%>
 
 </div>
 
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="cliente.js"></script>
 
 
 
</body>
</html>