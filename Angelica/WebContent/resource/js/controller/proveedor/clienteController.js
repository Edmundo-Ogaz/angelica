define(["jquery", "jqGrid", "underscore", "spin", "spin-jquery",
        "service", "page", "enum"], 
		function($, jqGrid, underscore, spin, spinjquery, 
				service, page, ENUM) {
 
	console.log("Function : cliente proveedor controller");
	
	var _fillGrid = null;
	var _listenerSave = null;
	return {
		init : function() {
			
			_fillGrid = this.fillGrid;
			_listenerSave = this.listenerSave;
			
			$('#titulo').html('Cliente');
			
			$('#page').html(page.proveedor.cliente.get());
			
			//PENDIENTES POR AGENDAMIENTO
	 		jQuery("#grid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['Rut', 'Nombre', 'Razón Social', 'Fecha Pago', 'Volor Informe', 'Entrega Informe'],
				colModel:[
				  		{name:'rut', index:'rut', key:true, width:55, editable:true, editoptions:{readonly:false,size:10}},
				  		{name:'nombre',index:'nombre',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'razonSocial',index:'razonSocial',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'fechaPago',index:'fechaPago',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'valorInforme',index:'valorInforme',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'entregaInfrme',index:'entregaInfrme',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  	],
			  	rowNum:5,
			  	rowList:[5,10,15],
			  	pager: '#pager',
			  	sortname: 'rut',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Clientes",
			  	editurl:"clientArray",
			  	height:125,
			  	autowidth:true,
			  	ondblClickRow: function (rowid, iRow,iCol) {
			  		var clientes = $('#state').data('clientes');
					var cliente = underscore.where(clientes, {rut : rowid});
					//clienteDialogController.init(ficha[0]);
					//LISTENER TO DIALOG EVENT CLICK ADD
					//_listenerSave();
		        }
	 		});
	 		
	 		$(window).on("resize", function () {
			    var newWidth1 = $("#grid").closest(".ui-jqgrid").parent().width();
			    $("#grid").jqGrid("setGridWidth", newWidth1, true);
			    // without scrollbar
			    $("#grid").closest('.ui-jqgrid-bdiv').width($("#grid").closest('.ui-jqgrid-bdiv').width() + 1);
			});
		  	
	 		//FILL GRID
			var resp = service.cliente.getAll();
			if(resp instanceof Array) {
				var clientes = resp;
				_fillGrid(clientes);
			}
		},
		listenerSave : function() {
			$('#add').on('click', function(e) {
	    		var clienteSave = e.result;
	    		if(clienteSave instanceof Object) {	    			
	    			var clienteGrid = {'rut' : clienteSave.rut,
	    							'nombre' : clienteSave.nombre,
					            	'razonSocial' : clienteSave.razonSocial,
					            	'fechaPago' : clienteSave.fechaPago,
					            	'valorInforme' : clienteSave.valorInforme,
					            	'entregaInforme' : clienteSave.entregaInforme,
						            };
	    			var fichas = $('#state').data('clientes');
	 				if(underscore.where(fichas, {id : clienteSave.id})) {
	 					//UPDATE GRID
	 					for(var i=0; i<clientes.length; i++) {
	 						if(clientes[i].rut == clienteSave.rut) {
	 							clientes[i] = clienteSave;
	 							break;
	 						}
	 					}
	 					_fillGrid(fichas);
	 					jQuery("#grid").jqGrid('setSelection', clienteSave.id, false);
	 				} else {
	 					//ADD GRID	 					
	 					jQuery("#grid").jqGrid('addRowData', clienteSave.id, clienteGrid);
	 					clientes.push(cliente);
	 				}
	    		}		
	        });			
		},
		fillGrid : function(clientes) {
			$('#state').data('clientes', clientes);
			var arrayCliente = [];
			for(var i=0; i<clientes.length; i++) {
				arrayCliente.push({'rut' : clientes[i].rut, 
				            		'nombre' : clientes[i].nombre,
				            		'razonSocial' : clientes[i].razonSocial,
				            		'fechaPago' : clientes[i].fechaPago,
				            		'valorInforme' : clientes[i].valorInforme,				            	
				            		'entregaInforme' : clientes[i].entregaInforme,
					            });
			}
			
			jQuery("#grid").jqGrid("clearGridData").jqGrid('addRowData', 'id', arrayCliente);
			jQuery("#grid").trigger("reloadGrid");
		}
	};
});