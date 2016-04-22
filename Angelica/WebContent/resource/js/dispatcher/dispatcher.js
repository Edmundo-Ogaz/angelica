define(["jquery", 'router', 
        'agendaController',
        'clienteController', 
         /* 'ciudadController', 'ubicacionController',
        'ingredienteConsultaController', 'lineaProduccionConsultaController',
        'ubicacionConsultaController', 'stockConsultaController',
        'solicitudProductoController', 'solicitudProductoListaController',
        'solicitudProductoClienteController',
        'ingresoInsumoController', 'ingresoInsumoListaController',
        'entregaInsumoConsultaController', 'devolucionInsumoConsultaController',
        'capturaProduccionConsultaController', 'pedidoConfirmaController',
        'pedidoConsultaController', 'ordenFabricacionConsultaController',
        'programaProduccionConsultaController'*/
        ], 
		function($, Router,
				agendaController,
				clienteController
				 /* , ciudadController, ubicacionController,
				ingredienteConsultaController, lineaProduccionConsultaController,
				ubicacionConsultaController, stockConsultaController,
				solicitudProductoController, solicitudProductoListaController,
				solicitudProductoClienteController,
				ingresoInsumoController, ingresoInsumoListaController,
				entregaInsumoConsultaController, devolucionInsumoConsultaController,
				capturaProduccionConsultaController, pedidoConfirmaController,
				pedidoConsultaController, ordenFabricacionConsultaController,
				programaProduccionConsultaController*/
				) {
 	console.log("Function : dispatcher");
	return new Router()
	.addRoute('#', function(req,next) {
		window.location.href = window.location.pathname;	 	
	 })
	 .addRoute('#/agendaProveedor', function(req,next) {
	 	agendaController.init();
	 })
	 .addRoute('#/clienteProveedor', function(req,next) {
	 	clienteController.init();
	 })
	 /*.addRoute('#/ciudad', function(req,next) {
	 	ciudadController.init();
	 })
	 .addRoute('#/ubicacion', function(req,next) {
	 	ubicacionController.init();
	 })
	 .addRoute('#/ingredienteConsulta', function(req,next) {
		 ingredienteConsultaController.init();
	 })
	 .addRoute('#/lineaProduccionConsulta', function(req,next) {
		 lineaProduccionConsultaController.init();
	 })
	 .addRoute('#/ubicacionConsulta', function(req,next) {
		 ubicacionConsultaController.init();
	 })
	 .addRoute('#/stockConsulta', function(req,next) {
		 stockConsultaController.init();
	 })
	 .addRoute('#/solicitudProducto', function(req,next) {
		 solicitudProductoController.init();
	 })
	 .addRoute('#/solicitudProductoLista', function(req,next) {
		 var numeroPedido = req.get('numeroPedido');
		 if(numeroPedido != undefined) {
			 solicitudProductoListaController.init(numeroPedido);
		 } else {
			 next('Número de pedido no encontrado',500);
		 }		 
	 })
	 .addRoute('#/solicitudProductoCliente', function(req,next) {
		 solicitudProductoClienteController.init();
	 })
	 .addRoute('#/ingresoInsumo', function(req,next) {	 
		 ingresoInsumoController.init();
	 })
	 .addRoute('#/ingresoInsumoLista', function(req,next) {
		 var codigoProducto = req.get('codigoProducto');
		 var idUbicacion = req.get('idUbicacion');
		 
		 if(codigoProducto != undefined && 
				 idUbicacion != undefined) {
			 ingresoInsumoListaController.init(codigoProducto, idUbicacion);
		 } else {
			 next('Código producto no encontrado',500);
		 }		 
	 })
	 .addRoute('#/entregaInsumo', function(req,next) {
		 entregaInsumoConsultaController.init();
	 })
	 .addRoute('#/devolucionInsumo', function(req,next) {
		 devolucionInsumoConsultaController.init();
	 })
	 .addRoute('#/capturaProduccion', function(req,next) {
		 capturaProduccionConsultaController.init();
	 })
	 .addRoute('#/pedidoConfirma', function(req,next) {
		 pedidoConfirmaController.init();
	 })
	 .addRoute('#/pedidoConsulta', function(req,next) {
		 pedidoConsultaController.init();
	 })
	 .addRoute('#/ordenFabricacionConsulta', function(req,next) {
		 ordenFabricacionConsultaController.init();
	 })
	 .addRoute('#/programaProduccionConsulta', function(req,next) {
		 programaProduccionConsultaController.init();
	 })*/
	 .errors(404,function(error) {
		 console.group();
		 console.error('404',error);
		 console.groupEnd();
	 })		 
	 .errors(500,function(error) {
		 console.group();
		 console.error('500',error);
		 console.groupEnd();
	 });
});