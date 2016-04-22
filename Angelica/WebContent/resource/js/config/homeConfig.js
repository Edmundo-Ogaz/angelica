//Load common code that includes config, then load the app logic for this page.
requirejs(['commonConfig'], function () {
    requirejs(['jquery', 'dispatcher', 'homeController'],
    //requirejs(['jquery', 'homeController'],
    		function($, dispatcher, homeController) {
    		//function($, homeController) {
    	
    	console.log("function : home config");
    	homeController.init();
    	
//    	$('#salir').on('click', function(e) {
//    		console.log("home config");
    		//window.location.href = e.result;
    		//window.location = e.result;
    		//window.location.assign(e.result);
//        });
    	
    	/*$('#menu #brand').on('click', function(e) {
    		console.log("home config");
    		window.location.href = e.result;
        });*/
    	
    });
});