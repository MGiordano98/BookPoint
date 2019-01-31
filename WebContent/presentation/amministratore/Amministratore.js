/**
 * 
 */

$(document).ready(function(){

	$(".modificaTipo").click(function(){
		$(".formModificaTipo").slideToggle();

	});


	$(".modificaFoto").click(function(){
		$(".formModificaFoto").slideToggle();
		$(".formModificaQuantita").hide;
		$(".formModificaTitolo").hide();
		$(".formModificaEditore").hide();
		$(".formModificaCategoria").hide();
		$(".formModificaDescrizione").hide();
		$(".formModificaPrezzo").hide();	
	});

	$(".modificaQuantita").click(function(){
		$(".formModificaQuantità").slideToggle();
		$(".formModificaFoto").hide();
		$(".formModificaTitolo").hide();
		$(".formModificaEditore").hide();
		$(".formModificaCategoria").hide();
		$(".formModificaDescrizione").hide();
		$(".formModificaPrezzo").hide();
	});

	$(".modificaTitolo").click(function(){
		$(".formModificaTitolo").slideToggle();
		$(".formModificaFoto").hide();
		$(".formModificaQuantita").hide;
		$(".formModificaEditore").hide();
		$(".formModificaCategoria").hide();
		$(".formModificaDescrizione").hide();
		$(".formModificaPrezzo").hide();
	});

	$(".modificaEditore").click(function(){
		$(".formModificaEditore").slideToggle();
		$(".formModificaCategoria").hide();
		$(".formModificaDescrizione").hide();
		$(".formModificaPrezzo").hide();
		$(".formModificaFoto").hide();
		$(".formModificaQuantita").hide;
		$(".formModificaTitolo").hide();
	});

	$(".modificaCategoria").click(function(){
		$(".formModificaCategoria").slideToggle();
		$(".formModificaDescrizione").hide();
		$(".formModificaPrezzo").hide();
		$(".formModificaFoto").hide();
		$(".formModificaQuantita").hide;
		$(".formModificaTitolo").hide();
		$(".formModificaEditore").hide();
	});

	$(".modificaDescrizione").click(function(){
		$(".formModificaDescrizione").slideToggle();
		$(".formModificaPrezzo").hide();
		$(".formModificaFoto").hide();
		$(".formModificaQuantita").hide;
		$(".formModificaTitolo").hide();
		$(".formModificaEditore").hide();
		$(".formModificaCategoria").hide();
	});

	$(".modificaPrezzo").click(function(){
		$(".formModificaPrezzo").slideToggle();
		$(".formModificaFoto").hide();
		$(".formModificaQuantita").hide;
		$(".formModificaTitolo").hide();
		$(".formModificaEditore").hide();
		$(".formModificaCategoria").hide();
		$(".formModificaDescrizione").hide();
	});

	$("#search-button").click(function(){
		$("#form-ricerca-libri").submit();
	});

	$(".add-libro").click(function(){
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

	$(".visualizza").click(function(){
		var isbn= $(this).attr("name");
		alert(isbn);
		$.post("visualizzaLibro",{"isbn":isbn}, function(data, status){
			window.location.href= "AmministratoreVisualizzaLibro.jsp";
		});

	});

	$(".modificaButton").click(function(){
		var id= this.id;
		var tipo= $("#"+id+"Tipo").val(); alert($("#"+id+"Tipo").val());
		var nuovoAttributo= $("#"+id+"NuovoAttributo").val(); alert($("#"+id+"NuovoAttributo").val());

		$.post("modificaAttributo", {"tipo":tipo, "nuovoAttributo":nuovoAttributo},function(data, statuts){
			if(data.result){
				$("#"+id+"Libro").text(data.nuovoAttributo);
				alert(data.nuovoAttributo);
			}
		});
	});
	
	$(".bottone-elimina").click(function(){
		alert("aaa");
		var id= this.id;
		var idRecensione= $("#recensione"+id).val(); alert($("#recensione"+id).val());
		$.post("eliminaRecensione", {"idRecensione": idRecensione}, function(data){
			$("#div-recensione"+id).remove();
		});
	});

});
