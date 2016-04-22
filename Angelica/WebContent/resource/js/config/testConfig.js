'use strict';

require.config({
    baseUrl: 'resource/js',
    deps: ['runner'],
    paths: {
    	testLink: 'test/testLink',
    	testPage: 'test/testPage',
    	testService: 'test/testService',
    	testReportes: 'test/testReportes',
    	testSaveSolicitudProducto: 'test/testSaveSolicitudProducto',
    	testServiceCRUDSolicitudProductoCliente: 'test/testServiceCRUDSolicitudProductoCliente',
    	testServiceCRUDOrdenFabricacion: 'test/testServiceCRUDOrdenFabricacion',
    	testServiceCRUDCapturaProduccion: 'test/testServiceCRUDCapturaProduccion',
    	testServiceCRUDEntregaInsumo: 'test/testServiceCRUDEntregaInsumo',
    	testProcesoVenta: 'test/testProcesoVenta',
    	testDevolucionInsumo: 'test/testDevolucionInsumo',
        runner: 'test/testRunner',
        commonConfig: 'config/commonConfig'
    },
    shim: {
        runner: ['commonConfig']
    }
});