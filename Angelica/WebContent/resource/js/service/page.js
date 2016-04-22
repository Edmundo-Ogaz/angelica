define(["jquery"], function($) {
 	console.log("Function : page");
	return {
		login : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "login.html",
					dataType:'html',
					success: function(data) {
						console.log('get login page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		menu : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "menu.html",
					dataType:'html',
					success: function(data) {
						console.log('get menu page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		home : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "home.html",
					dataType:'html',
					success: function(data) {
						console.log('get home page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		region : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "region.html",
					dataType:'html',
					success: function(data) {
						console.log('get region page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		ciudad : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "ciudad.html",
					dataType:'html',
					success: function(data) {
						console.log('get ciudad page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		entregaInsumoConsulta : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "entregaInsumoConsulta.html",
					dataType:'html',
					success: function(data) {
						console.log('get entregaInsumoConsulta page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		entregaInsumo : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "entregaInsumo.html",
					dataType:'html',
					success: function(data) {
						console.log('get entregaInsumo page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		devolucionInsumoConsulta : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "devolucionInsumoConsulta.html",
					dataType:'html',
					success: function(data) {
						console.log('get devolucionInsumoConsulta page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		devolucionInsumo : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "devolucionInsumo.html",
					dataType:'html',
					success: function(data) {
						console.log('get devolucionInsumo page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		capturaProduccionConsulta : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "capturaProduccionConsulta.html",
					dataType:'html',
					success: function(data) {
						console.log('get capturaProduccionConsulta page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		capturaProduccion : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "capturaProduccion.html",
					dataType:'html',
					success: function(data) {
						console.log('get capturaProduccion page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},		
		ingresoInsumo : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "ingresoInsumo.html",
					dataType:'html',
					success: function(data) {
						console.log('get ingresoInsumo page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},		
		productoConsulta : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "productoConsulta.html",
					dataType:'html',
					success: function(data) {
						console.log('get productoConsulta page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		ingredienteConsulta : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "ingredienteConsulta.html",
					dataType:'html',
					success: function(data) {
						console.log('get ingrediente consulta page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		lineaProduccionConsulta : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "lineaProduccionConsulta.html",
					dataType:'html',
					success: function(data) {
						console.log('get lineaProduccionConsulta page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		ubicacionConsulta : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "ubicacionConsulta.html",
					dataType:'html',
					success: function(data) {
						console.log('get ubicacionConsulta page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		stockConsulta : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "stockConsulta.html",
					dataType:'html',
					success: function(data) {
						console.log('get stockConsulta page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		solicitudProducto : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "solicitudProducto.html",
					dataType:'html',
					success: function(data) {
						console.log('get solicitudProducto page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		solicitudProductoCliente : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "solicitudProductoCliente.html",
					dataType:'html',
					success: function(data) {
						console.log('get solicitudProductoCliente page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		pedidoConfirma : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "pedidoConfirma.html",
					dataType:'html',
					success: function(data) {
						console.log('get pedido confirma page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		pedidoConsulta : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "pedidoConsulta.html",
					dataType:'html',
					success: function(data) {
						console.log('get pedido consulta page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		ordenFabricacionConsulta : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "ordenFabricacionConsulta.html",
					dataType:'html',
					success: function(data) {
						console.log('get orden fabricacion consulta page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		programaProduccionConsulta : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "programaProduccionConsulta.html",
					dataType:'html',
					success: function(data) {
						console.log('get programa producción consulta page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		programaProduccionModifica : {
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "programaProduccionModifica.html",
					dataType:'html',
					success: function(data) {
						console.log('get programa producción modifica page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
		proveedor : {
			agenda : {
				get : function() {
						
					var resp = "";
					
					$.ajax({
						async: false,
						type: "GET",
						url: "page/proveedor/agenda.html",
						dataType:'html',
						success: function(data) {
							console.log('get proveedor agenda page');
							resp = data;
						},
						error: function(request, status, error) {
							console.log("request " +request);
							console.log("status " + status);
							console.log("error " + error);
						}
					});
					
					return resp;
				}
			},
			cliente : {			
				get : function() {
						
					var resp = "";
					
					$.ajax({
						async: false,
						type: "GET",
						url: "page/proveedor/cliente.html",
						dataType:'html',
						success: function(data) {
							console.log('get proveedor cliente page');
							resp = data;
						},
						error: function(request, status, error) {
							console.log("request " +request);
							console.log("status " + status);
							console.log("error " + error);
						}
					});
					
					return resp;
				}
			}
		},
		ficha : {		
			get : function() {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "page/ficha.html",
					dataType:'html',
					success: function(data) {
						console.log('get ficha page');
						resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		},
	}
});