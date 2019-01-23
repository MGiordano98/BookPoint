/**
 * 
 */

$(document).ready(function() {
	
	$(".visualizza").click(function(){
		var isbn= $(this).attr("name");
		$.post("visualizzaLibro",{"isbn":isbn}, function(){
			window.location.href= "VisualizzaLibro.jsp";
		});
		
	});
		
	$("#search-button").click(function(){
		var testo= $("#search-bar").val();
		var categoria= $("#categoria").val();
		alert(testo + " " + categoria);
		
		$.post("ricerca",{"testo":testo, "categoria":categoria}, function(){
			window.location.href= "Libri.jsp";
		});
	});
	
	$(".modifica-quantità.aumenta").click(function(){
		var isbn= $(this).attr("title");
		
		$.post("aumentaQuantità",{"isbn":isbn}, function(data, status){
			var quantità= parseInt($("#quantità"+isbn).text());
			var prezzotot= parseFloat($("#prezzotot"+isbn).text());
			var prezzo= parseFloat($("#prezzo"+isbn).text());
			$("#quantità"+isbn).text(quantità + 1);
			$("#prezzotot"+isbn).text(prezzotot+ prezzo);
			$("#totaleProdotti").text(data.totaleCarrello);
		});
	});
	
	$(".modifica-quantità.diminuisci").click(function(){
		var isbn= $(this).attr("title");
		
		$.post("diminuisciQuantità",{"isbn":isbn}, function(data, status){
			var quantità= parseInt($("#quantità"+isbn).text());
			var prezzotot= parseFloat($("#prezzotot"+isbn).text());
			var prezzo= parseFloat($("#prezzo"+isbn).text());
			$("#quantità"+isbn).text(quantità - 1);
			$("#prezzotot"+isbn).text(data.totaleProdotto);
			$("#totaleProdotti").text(data.totaleCarrello);
		});
	});
	
});