define([], function() {
 	console.log("Function : Enum");
 	
	return {
		system : {PATH : window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)) + "/"},
		estadoFicha : {
			INGRESADO : {codigo : 'ING', descripcion : 'Ingresado'},
			AGENDADO : {codigo : 'AGN', descripcion : 'Agendado'},
			EVALUADO : {codigo : 'EVL', descripcion : 'evaluado'},
			INFORMADO : {codigo : 'INF', descripcion : 'informado'}
		},
	};
});