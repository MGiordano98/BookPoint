
		

<!DOCTYPE html>
<html>
 <%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, control.*, model.*" %>
<head>
<script src="scripts/jquery-3.3.1.min.map.Js"></script> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styleCliente2.css"> 
<meta charset="utf-8">
<title>BookPoint</title>
</head>
<body>


 <%@ include file="header.jsp"%>
 
<div class="divaccount">

<div class="a-row a-spacing-base">
    <h1>
        Il mio  account 
    </h1>
</div>   



<div class="card-deck divsfizi"  id="quadrato">    <!-- Div delle tre sfizi-->


			
            <div class="ya-card-cell ordini">  
            <a href="ordine" class="accountahref">
    <div class="a-row">
        <div class="a-column a-span3">
            <img alt="I miei ordini" src="../image/libro.jpg">
        </div>
        <div class="a-column a-span9 a-span-last">
            <h3 class="a-spacing-none ya-card__heading--rich a-text-normal">
                I miei ordini
            </h3>
            <div><span class="a-color-secondary">Visualizza gli ordini precedentemente effettuati</span></div>
</div></div>  
		</a>        
            </div>
 
      
       
       
          <div class="ya-card-cell accesso">      
                  <a href="accesso.jsp" class="accountahref">
    <div class="a-row">
        <div class="a-column a-span3">
            <img alt="I miei ordini" src="../image/libro.jpg">
        </div>
        <div class="a-column a-span9 a-span-last">
            <h3 class="a-spacing-none ya-card__heading--rich a-text-normal">
                Accesso e sicurezza
            </h3>
            <div><span class="a-color-secondary">Modifica la password</span></div>
</div></div>    
			</a>     
            </div>
            
            
        <div class="ya-card-cell indirizzi"> 
                        <a href="indirizzo" class="accountahref">    
    <div class="a-row">
        <div class="a-column a-span3">
            <img alt="I miei ordini" src="../image/libro.jpg">
        </div>
        <div class="a-column a-span9 a-span-last">
            <h3 class="a-spacing-none ya-card__heading--rich a-text-normal">
                Indirizzi
            </h3>
            <div><span class="a-color-secondary"> Modifica gli indirizzi</span></div>
</div></div>         
		</a>
            </div>
       
       
       
       
       
            <div class="ya-card-cell pagamento">      
            <a href="cartacredito" class="accountahref">
    <div class="a-row">
        <div class="a-column a-span3">
            <img alt="I miei ordini" src="../image/libro.jpg">
        </div>
        <div class="a-column a-span9 a-span-last">
            <h3 class="a-spacing-none ya-card__heading--rich a-text-normal">
               Opzioni di pagamento
            </h3>
            <div><span class="a-color-secondary">Modifica o aggiungi metodi di pagamento</span></div>
</div></div>    
		</a>     
            </div>
       
   </div>

  
    </div>






</div>

 <%@ include file="footer.jsp"%>
 
 
 
 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="ScriptJS.js"></script> 
<script src="utente.js"></script> 




</body>
</html>
