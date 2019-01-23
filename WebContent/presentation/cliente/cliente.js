/**
 * 
 */

$(document).ready(function() {
	
	$(".visualizza").click(function(){
		var isbn= $(this).attr("name");
		alert(isbn);
		$.post("visualizzaLibro",{"isbn":isbn}, function(){
			window.location.href= "VisualizzaLibro.jsp";
		});
		
	});
		
	$("#search-button").click(function(){
		var testo= $("#search-bar").val();
		var categoria= $("#categoria").val();
		alert(testo + " " + categoria);
		
		$.post("ricerca",{"testo":testo, "categoria":categoria}, function(){
			window.location.href= "Ricerca.jsp";
		});
	});
	
	$(".modifica-quantità.aumenta").click(function(){
		var isbn= $(this).attr("title");
		
		$.post("aumentaQuantità",{"isbn":isbn}, function(data, status){
			alert(data);
			alert(data.totaleCarrello);
		});
	});
	
});