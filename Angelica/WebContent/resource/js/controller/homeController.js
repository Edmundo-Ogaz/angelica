define(["spin", "spin-jquery", "menuController", "agendaController"], 
		function(spin, spinJquery, menuController, agendaController) {
 
	console.log("Function : home controller");

	return {
		
		init : function() {
			
			$('#cargando').spin();
			setTimeout(function() {
				menuController.init();
				agendaController.init();				
				$("#cargando").spin(false);
			}, 1000);
		},
	};
});