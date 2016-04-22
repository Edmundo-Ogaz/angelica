define(["jquery"], function($) {
 	console.log("Function : file");
	return {
		documento : {
			get : function(name) {
					
				var resp = "";
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/file/get/"+name,
					//dataType:'html',
//					success: function(data) {
//						console.log('get login page');
//						resp = data;
//					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			}
		}
	}
});