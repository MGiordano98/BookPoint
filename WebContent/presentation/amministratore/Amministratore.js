/**
 * 
 */

$(document).ready(function(){

	$("#search-button").click(function(){
		var testo= $("#search-bar").val();
		var categoria= $("#categoria").val();
		alert(testo + " " + categoria);
		
		$.post("ricerca",{"testo":testo, "categoria":categoria}, function(){
			window.location.href= "AmministratoreCatalogo.jsp";
		});
	});
	
	$("#bottone-aggiungi-libro").click(function(){
		$(".container-inserimento").slideToggle();
		$("#libro-non-trovato-display").hide();
		$(".libro-trovato-display").hide();
	});
	
	$("#bottone-inserisci-autori").click(function(){
		$(".aggiungi-autori").slideToggle();
	});
	
	$(".bottone-aggiungi-autore").click(function(){
		$(".aggiungi-autori").append("<div class=\"aggiungi-autore\">Nome: <input type=\"text\" name=\"autore\"> </div>");
	});
	
});
