define(["jquery", "jqGrid", "bootstrap-datetimepicker", "moment", "underscore", "spin", "spin-jquery",
        "fichaDialogController", "service", "page", "enum"], 
		function($, jqGrid, bootstrapdatetimepicker, moment, underscore, spin, spinjquery, 
				fichaDialogController, service, page, ENUM) {
 
	console.log("Function : agenda proveedor controller");
	
	var _fillGrid = null;
	var _listenerSave = null;
	return {
		init : function() {
			
			_fillGrid = this.fillGrid;
			_listenerSave = this.listenerSave;
			
			$('#titulo').html('Agenda');
			
			$('#fecha').datetimepicker({
				defaultDate: moment(),
				format: 'DD-MM-YYYY'
			});
			
			$('#page').html(page.proveedor.agenda.get());
			
			//PENDIENTES POR AGENDAMIENTO
	 		jQuery("#pendienteAgendamientoGrid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['id','Estado', 'Nombre', 'Apellidos', 'Empresa', 'Cargo', 'Fecha Entrevista', 'Fecha Entrega Informe'],
				colModel:[
				  		{name:'id', index:'id', key:true, width:55, editable:true, editoptions:{readonly:false,size:10}},
				  		{name:'estado',index:'estado',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'nombre',index:'nombre',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'apellidos',index:'apellidos',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'empresa',index:'empresa',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'cargo',index:'cargo',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'fechaEntrevista',index:'fechaEntrevista',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'fechaEntregaInforme',index:'fechaEntregaInforme',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  	],
			  	rowNum:5,
			  	rowList:[5,10,15],
			  	pager: '#pendienteAgendamientoPager',
			  	sortname: 'id',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Pendientes de Agendamiento",
			  	editurl:"clientArray",
			  	height:125,
			  	autowidth:true,
			  	ondblClickRow: function (rowid, iRow,iCol) {
			  		var fichas = $('#state').data('fichas');
					var ficha = underscore.where(fichas, {id : parseInt(rowid)});
					fichaDialogController.init(ficha[0]);
					//LISTENER TO DIALOG EVENT CLICK ADD
					_listenerSave();
		        }
	 		});
	 		
	 		//PARA ENTREVISTAR
	 		jQuery("#entrevistaGrid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['id','Estado', 'Nombre', 'Apellidos', 'Empresa', 'Cargo', 'Fecha Entrevista', 'Fecha Entrega Informe'],
				colModel:[
				  		{name:'id', index:'id', key:true, width:55, editable:true, editoptions:{readonly:false,size:10}},
				  		{name:'estado',index:'estado',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'nombre',index:'nombre',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'apellidos',index:'apellidos',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'empresa',index:'empresa',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'cargo',index:'cargo',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'fechaEntrevista',index:'fechaEntrevista',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'fechaEntregaInforme',index:'fechaEntregaInforme',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  	],
			  	rowNum:5,
			  	rowList:[5,10,15],
			  	pager: '#entrevistaGridPager',
			  	sortname: 'id',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Para Entrevistar",
			  	editurl:"clientArray",
			  	height:125,
			  	autowidth:true,
			  	ondblClickRow: function (rowid, iRow,iCol) {
			  		var fichas = $('#state').data('fichas');
					var ficha = underscore.where(fichas, {id : parseInt(rowid)});
					fichaDialogController.init(ficha[0]);
					//LISTENER TO DIALOG EVENT CLICK ADD
					_listenerSave();
			  	}
	 		});
	 		
	 		//INFORME POR ENTREGAR
	 		jQuery("#informeEntregarGrid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['id','Estado', 'Nombre', 'Apellidos', 'Empresa', 'Cargo', 'Fecha Entrevista', 'Fecha Entrega Informe'],
				colModel:[
				  		{name:'id', index:'id', key:true, width:55, editable:true, editoptions:{readonly:false,size:10}},
				  		{name:'estado',index:'estado',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'nombre',index:'nombre',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'apellidos',index:'apellidos',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'empresa',index:'empresa',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'cargo',index:'cargo',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'fechaEntrevista',index:'fechaEntrevista',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  		{name:'fechaEntregaInforme',index:'fechaEntregaInforme',            width:90, editable:true, editoptions:{readonly:false,size:25}},
				  	],
			  	rowNum:5,
			  	rowList:[5,10,15],
			  	pager: '#informeEntregarGridPager',
			  	sortname: 'id',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Informe por entregar",
			  	editurl:"clientArray",
			  	height:125,
			  	autowidth:true,
			  	ondblClickRow: function (rowid, iRow,iCol) {
			  		var fichas = $('#state').data('fichas');
					var ficha = underscore.where(fichas, {id : parseInt(rowid)});
					fichaDialogController.init(ficha[0]);
					//LISTENER TO DIALOG EVENT CLICK ADD
					_listenerSave();
			  	}
	 		});
	 		
	 		$(window).on("resize", function () {
			    var newWidth1 = $("#pendienteAgendamientoGrid").closest(".ui-jqgrid").parent().width();
			    $("#pendienteAgendamientoGrid").jqGrid("setGridWidth", newWidth1, true);
			    // without scrollbar
			    $("#pendienteAgendamientoGrid").closest('.ui-jqgrid-bdiv').width($("#pendienteAgendamientoGrid").closest('.ui-jqgrid-bdiv').width() + 1);
			    
			    var newWidth2 = $("#entrevistaGrid").closest(".ui-jqgrid").parent().width();
			    $("#entrevistaGrid").jqGrid("setGridWidth", newWidth2, true);
			    // without scrollbar
			    $("#entrevistaGrid").closest('.ui-jqgrid-bdiv').width($("#entrevistaGrid").closest('.ui-jqgrid-bdiv').width() + 1);
			    
			    var newWidth3 = $("#informeEntregarGrid").closest(".ui-jqgrid").parent().width();
			    $("#informeEntregarGrid").jqGrid("setGridWidth", newWidth3, true);
			    // without scrollbar
			    $("#informeEntregarGrid").closest('.ui-jqgrid-bdiv').width($("#informeEntregarGrid").closest('.ui-jqgrid-bdiv').width() + 1);
			});
		  	
	 		//FILL GRID
			var resp = service.ficha.getAll();
			if(resp instanceof Array) {
				var fichas = resp;
				_fillGrid(fichas);
			}
			
			$("#ficha").click(function() {
	 			console.log("Ficha Dialog controller");
	 			fichaDialogController.init(null);	 			
	 			//LISTENER TO DIALOG EVENT CLICK ADD
	 			_listenerSave();
			});
		},
		listenerSave : function() {
			$('#add').on('click', function(e) {
	    		var fichaSave = e.result;
	    		if(fichaSave instanceof Object) {	    			
	    			var fichaGrid = {'id' : fichaSave.id,
	    							'estado' : fichaSave.estado.nombre,
					            	'nombre' : fichaSave.postulante.nombre,
					            	'apellidos' : fichaSave.postulante.apellidoPaterno + ' ' + fichaSave.postulante.apellidoMaterno,
					            	'empresa' : fichaSave.sucursal.cliente.nombre,
					            	'cargo' : fichaSave.cargo.nombre,
					            	'fechaEntrevista' : fichaSave.fechaEntrevista,
					            	'fechaEntregaInforme' : fichaSave.fechaEntregaInforme,
						            };
	    			var fichas = $('#state').data('fichas');
	 				if(underscore.where(fichas, {id : fichaSave.id})) {
	 					//UPDATE GRID
	 					for(var i=0; i<fichas.length; i++) {
	 						if(fichas[i].id == fichaSave.id) {
	 							fichas[i] = fichaSave;
	 							break;
	 						}
	 					}
	 					_fillGrid(fichas);
	 					jQuery("#pendienteAgendamientoGrid").jqGrid('setSelection', fichaSave.id, false);
	 					jQuery("#entrevistaGrid").jqGrid('setSelection', fichaSave.id, false);
	 					jQuery("#informeEntregarGrid").jqGrid('setSelection', fichaSave.id, false);
	 				} else {
	 					//ADD GRID	 					
	 					jQuery("#pendienteAgendamientoGrid").jqGrid('addRowData', fichaSave.id, fichaGrid);
	 					fichas.push(ficha);
	 				}
	    		}		
	        });			
		},
		fillGrid : function(fichas) {
			$('#state').data('fichas', fichas);
			var arrayPendienteAgendamiento = [];
			var arrayEntrevista = [];
			var arrayInforme = [];
			for(var i=0; i<fichas.length; i++) {
				if(ENUM.estadoFicha.INGRESADO.codigo == fichas[i].estado.codigo) {
					arrayPendienteAgendamiento.push({'id' : fichas[i].id, 
								            		'estado' : fichas[i].estado.nombre,
								            		'nombre' : fichas[i].postulante.nombre,
								            		'apellidos' : fichas[i].postulante.apellidoPaterno + ' ' + fichas[i].postulante.apellidoMaterno,
								            		'empresa' : fichas[i].sucursal.cliente.nombre,				            	
								            		'cargo' : fichas[i].cargo.nombre,
								            		'fechaEntrevista' : fichas[i].fechaEntrevista,
								            		'fechaEntregaInforme' : fichas[i].fechaEntregaInforme,
									            });
				} 
				else if(ENUM.estadoFicha.AGENDADO.codigo == fichas[i].estado.codigo && 
						moment(fichas[i].fechaEntrevista).isSameOrBefore(moment()) ) {
					arrayEntrevista.push({'id' : fichas[i].id, 
										'estado' : fichas[i].estado.nombre,
					            		'nombre' : fichas[i].postulante.nombre,
					            		'apellidos' : fichas[i].postulante.apellidoPaterno + ' ' + fichas[i].postulante.apellidoMaterno,
					            		'empresa' : fichas[i].sucursal.cliente.nombre,				            	
					            		'cargo' : fichas[i].cargo.nombre,
					            		'fechaEntrevista' : fichas[i].fechaEntrevista,
					            		'fechaEntregaInforme' : fichas[i].fechaEntregaInforme,
						            });
				}
				else if(ENUM.estadoFicha.EVALUADO.codigo == fichas[i].estado.codigo && 
						moment(fichas[i].fechaEntrevista).isSameOrBefore(moment()) ) {
					arrayInforme.push({'id' : fichas[i].id, 
										'estado' : fichas[i].estado.nombre,
					            		'nombre' : fichas[i].postulante.nombre,
					            		'apellidos' : fichas[i].postulante.apellidoPaterno + ' ' + fichas[i].postulante.apellidoMaterno,
					            		'empresa' : fichas[i].sucursal.cliente.nombre,				            	
					            		'cargo' : fichas[i].cargo.nombre,
					            		'fechaEntrevista' : fichas[i].fechaEntrevista,
					            		'fechaEntregaInforme' : fichas[i].fechaEntregaInforme,
						            });
				}
			}
			
			jQuery("#pendienteAgendamientoGrid").jqGrid("clearGridData").jqGrid('addRowData', 'id', arrayPendienteAgendamiento);
			jQuery("#pendienteAgendamientoGrid").trigger("reloadGrid");
			
			jQuery("#entrevistaGrid").jqGrid("clearGridData").jqGrid('addRowData', 'id', arrayEntrevista);
			jQuery("#entrevistaGrid").trigger("reloadGrid");
			
			jQuery("#informeEntregarGrid").jqGrid("clearGridData").jqGrid('addRowData', 'id', arrayInforme);
			jQuery("#informeEntregarGrid").trigger("reloadGrid");
		}
	};
});