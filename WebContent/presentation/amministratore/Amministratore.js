/**
 * 
 */
$("#search-button").click(function(){
		var testo= $("#search-bar").val();
		var categoria= $("#categoria").val();
		alert(testo + " " + categoria);
		
		$.post("ricerca",{"testo":testo, "categoria":categoria}, function(){
			window.location.href= "AmministratoreCatalogo.jsp";
		});
	});