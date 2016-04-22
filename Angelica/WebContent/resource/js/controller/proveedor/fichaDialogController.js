define(["jquery", "bootstrap-dialog", "bootstrap-datetimepicker", "fileinput", "underscore", "moment",
        "service", "page", "file", "dialog", "enum"], 
		function($, bootstrapDialog, bootstrapdatetimepicker, fileinput, underscore, moment,
				service, page, file, dialog, ENUM) {
 
	console.log("Function : Ficha Dialog Controller");

	return {
		init : function(_ficha) {
			
			empty = this.empty;
			fill = this.fill;
			
			var html = page.ficha.get();
			dialog.modalWidth(html,"Ficha", 1024);
			 
			 var resp = service.sucursal.getAll();
			 if(resp instanceof Array) {
				 var sucursals = resp;
	 			 var $sucursal = $("#sucursal");
	 			 $sucursal.append($("<option />").val("-1").text("SELECCIONE SUCURSAL"));
	 			 $.each(sucursals, function() {
	 			 $sucursal.append($("<option />").val(this.id).text(this.nombre));
		 		 });
			 }
			 
			 var resp = service.cargo.getAll();
			 if(resp instanceof Array) {
				 var cargos = resp;
	 			 var $cargo = $("#cargo");
	 			 $cargo.append($("<option />").val("-1").text("SELECCIONE CARGO"));
	 			 $.each(cargos, function() {
	 			 $cargo.append($("<option />").val(this.codigo).text(this.nombre));
		 		 });
			 }
			 
			 $("#sucursal").change(function() {
				 var id = $("#sucursal").val();
				 if(id != "") {
					 var resp = service.sucursal.get(id);
					 sucursal = resp;
					 $("#empresaNombre").val(sucursal.cliente.nombre);
					 $("#empresaRazonSocial").val(sucursal.cliente.razonSocial);
				 }
			 });
			
			 $("#add").click(function() {
		 			console.log("Ficha add controller");
		 			//if(requiredField()) {
		 				var fichas = $('#state').data('fichas');
			 			
		 				var id = $("#id").val();
		 				var sucursal = $("#sucursal").val();
			 			var valorInforme = $("#valorInforme").val();
			 			
			 			var rut = $("#rut").val();
			 			var nombre = $("#nombre").val();
			 			var apellidoPaterno = $("#apellidoPaterno").val();
			 			var apellidoMaterno = $("#apellidoMaterno").val();
			 			var telefono = $("#telefono").val();
			 			var celular = $("#celular").val();
			 			
			 			var cargo = $("#cargo").val();
			 			var internoExterno = $("#internoExterno").is(':checked') ? 1: 0;
			 			
			 			var estadoFicha = null;
			 			
			 			var fechaSolicitud = null
			 			if($("#fechaSolicitud").data("DateTimePicker").date()) {
			 				fechaSolicitud = $("#fechaSolicitud").data("DateTimePicker").date().format("YYYY-MM-DD HH:MM:SS");
			 				estadoFicha = ENUM.estadoFicha.INGRESADO.codigo;
			 			}
			 			
			 			var fechaEntrevista = null;
			 			if($("#fechaEntrevista").data("DateTimePicker").date()) {
			 				fechaEntrevista = $("#fechaEntrevista").data("DateTimePicker").date().format("YYYY-MM-DD HH:MM:SS");
			 				estadoFicha = ENUM.estadoFicha.AGENDADO.codigo;
			 			}
			 			var fechaEntregaInforme = null;
			 			if($("#fechaEntregaInforme").data("DateTimePicker").date()) {
			 				fechaEntregaInforme = $("#fechaEntregaInforme").data("DateTimePicker").date().format("YYYY-MM-DD HH:MM:SS");
			 				estadoFicha = ENUM.estadoFicha.EVALUADO.codigo;
			 			}
			 			
			 			var comentarios = $("#comentarios").val();
			 			
			 			var resultado = $("#resultado").val();
			 			
			 			var curriculum = $("#nameCurriculum").val();
			 			var informe = $("#nameInforme").val();
			 			var perfil = $("#namePerfil").val();
			 			
			 			var fichaToSave = {
			 								"id": id,
						 					"sucursal": {"id": sucursal},
						 					"valorInforme": valorInforme,
						 					"postulante": {"rut": rut,
						 									"nombre": nombre,
						 						 			"apellidoPaterno": apellidoPaterno,
						 						 			"apellidoMaterno": apellidoMaterno,
						 						 			"telefono": telefono,
						 						 			"celular": celular},
						 					"cargo": {"codigo": cargo},
						 					"internoExterno": internoExterno,
						 					"fechaSolicitud": fechaSolicitud,
						 					"fechaEntrevista": fechaEntrevista,
						 					"fechaEntregaInforme": fechaEntregaInforme,
						 					"resultado": resultado,
						 					"curriculum": curriculum,
						 					"informe": informe,
						 					"perfil": perfil,
						 					"comentarios": comentarios,
						 					"estado": {"codigo": estadoFicha},
						 					};
			 			
			 			//var resp = service.ficha.save(fichaToSave);
			 			
			 			var formData = new FormData();
			 			formData.append("ficha", new Blob([JSON.stringify(fichaToSave)], 
			 												{type: "application/json"}
			 												)
			 							);
			 			formData.append("curriculum", $("#curriculum")[0].files[0]);
			 			formData.append("informe", $("#informe")[0].files[0]);
			 			formData.append("perfil", $("#perfil")[0].files[0]);
			 			var resp = service.ficha.saveFile(formData);
			 			
			 			if(resp instanceof Object) {
			 				$("#dialog" ).dialog("close");
			 				bootstrapDialog.show({message: 'Ficha grabada!'});
			 			}
			 			
			 			return resp;
		 			//}
		 		
		 		});
			 
			 if(_ficha) {
				 fill(_ficha);
			 } else {
				 empty();
			 }

			 $("#curriculum").on('change', function() {
				 $("#nameCurriculum").val($("#curriculum")[0].files[0] == undefined ? "" : $("#curriculum")[0].files[0].name);
			 });
			 $("#informe").on('change', function() {
				 $("#nameInforme").val($("#informe")[0].files[0] == undefined ? "" : $("#informe")[0].files[0].name);
			 });
			 $("#perfil").on('change', function() {
				 $("#namePerfil").val($("#perfil")[0].files[0] == undefined ? "" : $("#perfil")[0].files[0].name);
			 });
			 
			 $('#curriculum').on('fileclear', function(event) {
				 $("#nameCurriculum").val("");
			 });
			 $('#informe').on('fileclear', function(event) {
				 $("#nameInforme").val("");
			 });
			 $('#perfil').on('fileclear', function(event) {
				 $("#namePerfil").val("");
			 });
			
		},
		empty : function() {
			$('#fechaSolicitud').datetimepicker({format: 'DD-MM-YYYY'});
			$('#fechaEntrevista').datetimepicker({format: 'DD-MM-YYYY'});
			$('#fechaEntregaInforme').datetimepicker({format: 'DD-MM-YYYY'});
			 
			$("#curriculum").fileinput({showUpload: false,	showCaption: false});
			$("#informe").fileinput({showUpload: false,	showCaption: false});
 			$("#perfil").fileinput({showUpload: false, showCaption: false});
		},
		fill : function(ficha) {			
			$("#ficha #id").val(ficha.id);
 			$("#ficha #sucursal").val(ficha.sucursal.id);
 			$("#ficha #empresaNombre").val(ficha.sucursal.cliente.nombre);
			$("#ficha #empresaRazonSocial").val(ficha.sucursal.cliente.razonSocial);
 			$("#ficha #valorInforme").val(ficha.valorInforme);
 			$("#ficha #rut").val(ficha.postulante.rut);
 			$("#ficha #nombre").val(ficha.postulante.nombre);
 			$("#ficha #apellidoPaterno").val(ficha.postulante.apellidoPaterno);
 			$("#ficha #apellidoMaterno").val(ficha.postulante.apellidoMaterno);
 			$("#ficha #telefono").val(ficha.postulante.telefono);
 			$("#ficha #celular").val(ficha.postulante.celular);
 			
 			$("#ficha #cargo").val(ficha.cargo.codigo);
 			$("#ficha #internoExterno").prop('checked', ficha.internoExterno);
 			
 			$('#ficha #fechaSolicitud').datetimepicker({format: 'DD-MM-YYYY', defaultDate: moment(ficha.fechaSolicitud)});
 			if(ficha.fechaEntrevista) {
 				$('#ficha #fechaEntrevista').datetimepicker({format: 'DD-MM-YYYY HH:MM:SS', defaultDate: moment(ficha.fechaEntrevista)});
 			} else {
 				$('#ficha #fechaEntrevista').datetimepicker({format: 'DD-MM-YYYY HH:MM:SS'});
 			}
 			if(ficha.fechaEntregaInforme) {
 				$('#ficha #fechaEntregaInforme').datetimepicker({format: 'DD-MM-YYYY HH:MM:SS', defaultDate: moment(ficha.fechaEntregaInforme)});
 			} else {
 				$('#ficha #fechaEntregaInforme').datetimepicker({format: 'DD-MM-YYYY HH:MM:SS'});
 			}
 			$("#ficha #comentarios").val(ficha.comentarios);
 			
 			$("#ficha #resultado").val(ficha.resultado);
 			
 			var initialPreview = null;
 			var initialPreviewConfig = null;
 			var initialPreviewThumbTags = null;
 			
 			if(ficha.curriculum != "") {
 				initialPreview = [
  				                 "<img style='height:160px' src='"+ENUM.system.PATH+"resource/img/view-doc-icon.gif'>"
  				                 ];
 	            initialPreviewConfig = [
 	                                   {
 	                                   caption: ficha.curriculum,
 	                                   removeIcon: '',
 	                                   frameAttr: {
 								        	ondblclick: 'window.location.href="'+ENUM.system.PATH+'spring/file/get/'+ficha.curriculum+'";',
 								            style: 'width:160px;height:160px;',
 								            title: ficha.curriculum,
 								        },
 	                                   }
 	                                   ];
 	            initialPreviewThumbTags = [
 											{
 											'<div class="file-footer-buttons">': ' ',
 											'<i class="glyphicon glyphicon-trash text-danger">': ' ',
 											'<div class="file-upload-indicator" title="">': ' ',
 											}];
 			} else {
 				initialPreview = "";
 	 			initialPreviewConfig = [];
 	 			initialPreviewThumbTags = [];
 			}
 			$("#curriculum").fileinput({
 		    	showUpload: false,
 		    	showCaption: false,
 		    	showClose: false,
 		    	allowedFileExtensions: ['doc', 'docx'],
 		    	initialPreview: initialPreview,
 				initialPreviewConfig: initialPreviewConfig,
 				initialPreviewThumbTags:initialPreviewThumbTags,
 		    });
 			$("#nameCurriculum").val(ficha.curriculum);
 			
 			if(ficha.informe != "") {
 				initialPreview = [
 				                 "<img style='height:160px' src='"+ENUM.system.PATH+"resource/img/view-doc-icon.gif'>"
 				                 ];
	            initialPreviewConfig = [
	                                   {
	                                   caption: ficha.informe,
	                                   removeIcon: '',
	                                   frameAttr: {
	                                	    ondblclick: 'window.location.href="'+ENUM.system.PATH+'spring/file/get/'+ficha.informe+'";',
								            style: 'width:160px;height:160px;',
								            title: ficha.informe,
								        },
	                                   }
	                                   ];
	            initialPreviewThumbTags = [
											{
											'<div class="file-footer-buttons">': ' ',
											'<i class="glyphicon glyphicon-trash text-danger">': ' ',
											'<div class="file-upload-indicator" title="">': ' ',
											}];
 			} else {
 				initialPreview = "";
 	 			initialPreviewConfig = [];
 	 			initialPreviewThumbTags = [];
 			}
 			$("#informe").fileinput({
 		    	showUpload: false,
 		    	showCaption: false,
 		    	showClose: false,
 		    	allowedFileExtensions: ['doc', 'docx'],
 		    	initialPreview: initialPreview,
				initialPreviewConfig: initialPreviewConfig,
				initialPreviewThumbTags:initialPreviewThumbTags,
 		    });
 			$("#nameInforme").val(ficha.informe);
 			
 			if(ficha.perfil != "") {
 				initialPreview = [
  				                 "<img style='height:160px' src='"+ENUM.system.PATH+"resource/img/view-doc-icon.gif'>"
  				                 ];
 				initialPreviewConfig = [
  	                                   {
  	                                   caption: ficha.perfil,
  	                                   removeIcon: '',
  	                                   frameAttr: {
  	                                	 ondblclick: 'window.location.href="'+ENUM.system.PATH+'spring/file/get/'+ficha.perfil+'";',
  								            style: 'width:160px;height:160px;',
  								            title: ficha.perfil,
  								        },
  	                                   }
  	                                   ];
  	            initialPreviewThumbTags = [
  											{
  											'<div class="file-footer-buttons">': ' ',
  											'<i class="glyphicon glyphicon-trash text-danger">': ' ',
  											'<div class="file-upload-indicator" title="">': ' ',
  											}];
 			} else {
 				initialPreview = "";
 	 			initialPreviewConfig = [];
 	 			initialPreviewThumbTags = [];
 			}
 			$("#perfil").fileinput({
 		    	showUpload: false,
 		    	showCaption: false,
 		    	showClose: false,
 		    	allowedFileExtensions: ['doc', 'docx', 'odt'],
 		    	initialPreview: initialPreview,
				initialPreviewConfig: initialPreviewConfig,
				initialPreviewThumbTags:initialPreviewThumbTags,
 		    });
 			$("#namePerfil").val(ficha.perfil);
 			
 			$('#state').data('ficha',ficha);
		},
	};
});