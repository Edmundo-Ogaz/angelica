define(["jquery", "spin", "spin-jquery", "service"], 
		function($, spin, spinjquery, service) {
 
	console.log("Function : login controller");

	return {
		init: function() {
			var login = this.login;
			
			$('#button').on('click', function(e) {
	        	console.log("login controller");	        	
	        	$('#cargando').spin();
	        	setTimeout(function() {
	        		var resp = login.up();
	        		if(resp != "") {
	        			window.location.href = resp;
	        		} else {
	        			$("#cargando").spin(false);
	        		}
	        	}, 1000);
	        });		
			$("#username").keyup(function(event){
			    if(event.keyCode == 13){
			    	$('#password').focus();
			    }
			});
			$("#password").keyup(function(event){
			    if(event.keyCode == 13){
			        $("#button").click();
			    }
			});			
		},
		login: {
			up : function() {
				var forward = '';
				var $username = $("#username");
				var $password = $("#password");
				if(this.validarUsuario($username, $password)) {					
					var usuario = ({"username": $username.val(), "password": $password.val()});					
					var resp = service.usuario.login(usuario);
					if(resp) {
						forward = window.location.href.substring(0,  window.location.href.lastIndexOf("/")) + "/home.html";
					}				
				}
				return forward;
			},
			upTest : function() {
				var $username = $("#username");
				var $password = $("#password");
				if(this.validarUsuario($username, $password)) {
					var usuario = ({"username": $username.val(), "password": $password.val()});
					var resp = service.usuario.login(usuario);				
					if(resp) {
						var forward = window.location.href.substring(0,  window.location.href.lastIndexOf("/")) + "/home.html";
						return forward;
					}
				}
			},
			out : function(event) {
				console.log("out");
			},
			validarUsuario : function($username, $password) {
				if($username.val() == null || $username.val().length < 1) {
					alert("Escriba nombre de usuario.");
					$username.focus();
					return false;
				} else if($password.val() == null || $password.val().length < 1) {
					alert("Escriba contraseña del usuario.");
					$password.focus();
					return false;
				}
				return true;
			}
		}
	};
});