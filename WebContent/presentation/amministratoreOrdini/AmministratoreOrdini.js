/**
 * 
 */

$(document).ready(function(){
	$("#button-1").click(function(){
		$("#div-modifica-data-e-ora").fadeOut();
		$("#div-modifica-stato").slideToggle();
	});
	
	$("#button-2").click(function(){
		$("#div-modifica-stato").fadeOut();
		$("#div-modifica-data-e-ora").slideToggle();
	});
});