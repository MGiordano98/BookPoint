<!-- 
  
  -->
 
<!DOCTYPE html>
<html>
 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.*, model.*" %>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 
<meta charset="ISO-8859-1">
<title>PizzaPoint</title>
</head>
<body>

<div class="divcarrello">


 <%@ include file="header.jsp"%>


<div class="contenitore">
    <div class="row" style="margin-left:10%;">
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
                
     

                
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left "> <img class="media-object" style="width:150px;height:150px;"id="" src=""> </a>
                            <div class="media-body">
                                <h4 class="media-heading" id="nome"></h4>                         
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="number" min="1" max="10" class="form-control numberquantita" id="" min="1" value="">
                        <input type="hidden" id="codice" value="">
						             
                        
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong><span id="prezzo"></strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong><span id="prezzotot"></span></strong></td>
                        <td class="col-sm-1 col-md-1"> 
                        <form action="carrello" method="post">                       	
                        	<input type="hidden" name="idProdotto" value="">
							<input type="hidden" name="nome" value="">
							<input type="hidden" name="action" value="rimuovi">
                        <button type="submit" id="" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Rimuovi
                        </button>
                        </form></td>
                    </tr>
                   
                   



				
                </tbody>
                <tfoot>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h2>Total</h2><h3></h3></td>
                        <td class="text-right">
                        <h3><span id="totaleProdotti"></span></h3>
                        <h5><strong><span id="tot"></span><br></strong></h5>
                        </td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
             
                        <td>

                     
		                <a href="Consegna.jsp">
                        <button type="submit" class="btn btn-success" id="ordinaButton">
                            Ordina!<span class="glyphicon glyphicon-play"></span>
                        </button>
   
                       </a>


                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
   
</div>


 <%@ include file="footer.jsp"%>
 
 </div>
 
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
 <script src="ScriptJQ.js"></script>
 
 
</body>
</html>