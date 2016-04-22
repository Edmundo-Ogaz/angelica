//Load common code that includes config, then load the app logic for this page.
requirejs(['commonConfig'], function () {
    requirejs(['jquery', 'loginController'], function($, loginController) {
    	
    	console.log("Function : login config");
    	loginController.init();
    	
//    	$('#button').on('click', function(e) {
//    		console.log("loging config");
//    		if(e.result != "") {
//    			window.location.href = e.result;
//    		}
//        });
    });
});