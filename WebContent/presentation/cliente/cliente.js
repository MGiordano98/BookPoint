/**
 * 
 */

$(document).ready(function() {
	
	$(".visualizza").click(function(){
		var isbn= $(this).attr("name");
		$.post("visualizzaLibro",{"isbn":isbn}, function(data, status){
			window.location.href= "VisualizzaLibro.jsp";
		});
		
	});
		
	$("#search-button").click(function(){
		$("#form-ricerca-libri").submit();
		
	});
	
	$(".modifica-quantità.aumenta").click(function(){
		var isbn= $(this).attr("title");
		
		$.post("aumentaQuantità",{"isbn":isbn}, function(data, status){
			var quantità= parseInt($("#quantità"+isbn).text());
			var prezzotot= parseFloat($("#prezzotot"+isbn).text());
			var prezzo= parseFloat($("#prezzo"+isbn).text());
			$("#quantità"+isbn).text(data.quantità);
			$("#prezzotot"+isbn).text(Math.round(data.totaleProdotto*100.0)/100.0);
			$("#totaleProdotti").text(Math.round(data.totaleCarrello*100.0)/100.0);
		});
	});
	
	$(".modifica-quantità.diminuisci").click(function(){
		var isbn= $(this).attr("title");
		
		$.post("diminuisciQuantità",{"isbn":isbn}, function(data, status){
			var quantità= parseInt($("#quantità"+isbn).text());
			var prezzotot= parseFloat($("#prezzotot"+isbn).text());
			var prezzo= parseFloat($("#prezzo"+isbn).text());
			$("#quantità"+isbn).text(data.quantità);
			$("#prezzotot"+isbn).text(Math.round(data.totaleProdotto*100.0)/100.0);
			$("#totaleProdotti").text(Math.round(data.totaleCarrello*100.0)/100.0);
		});
	});
	
	
	$("#star-preferiti").click(function(){
		$("#form-preferiti").submit();
	});
});