/**
 * 
 */

$(document).ready(function() {
	
	$(".visualizza").click(function(){
		var isbn= $(this).attr("name");
		alert(isbn);
		
		$.post("VisualizzaLibro",{"isbn":isbn},function(data,status){
			alert("done");
		});
		
	})
		
	
	
});