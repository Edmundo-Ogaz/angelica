define(["jquery", "bootstrap-dialog"], 
		function($, bootstrapDialog) {
 	console.log("Function : dialog");
	return {
		modal : function(text,titulo) {
			if (titulo==undefined){
				titulo = "...";
			}
			$('#dialog').html(text);
			$("#dialog").dialog({
				autoOpen: false,
				height: "auto",
				width: 810,
				modal: true,
				resizable:true,
				closeOnEscape:false,
				title: titulo,
				position: "top",
				open: function (event, ui) {
					$('#dialog').css('overflow', 'hidden'); //this line does the actual hiding
				},
			});
			$("#dialog" ).dialog("open");
		},
		modalWidth : function(text,titulo, width) {
//			bootstrapDialog.show({
//	            message: $('<div></div>').load('page/ficha.html')
//	            //message: text
//	        });
			if (titulo==undefined){
				titulo = "...";
			}
			$('#dialog').html(text);
			$("#dialog").dialog({
				autoOpen: false,
				height: "auto",
				width: width,
				modal: true,
				resizable:true,
				closeOnEscape:false,
				title: titulo,
				position: "top",
				open: function (event, ui) {
					$('#dialog').css('overflow', 'hidden'); //this line does the actual hiding
				},
			});
			$("#dialog" ).dialog("open");
		}
	}
});