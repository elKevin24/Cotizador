/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function reten2(cont) {

    var settings = {
		"url": "https://farm3.sat.gob.gt/confirmacion-salida/rest/privado/ingresoSalidaAduana/consultarIngresoSalidaContenedorVacio",
		"method": "POST",
		"timeout": 0,
		"headers": {
				"Authorization": "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr",
                                "Content-Type": "application/json",
            "Accept": "application/json;charset=utf-8"
				},
		"data": JSON.stringify({"contenedores":[{"noContenedor":"BMOU5831143","noAtc":"389271658"}],"tipoOperacion":"INGRESO"}),
};

$.ajax(settings).done(function (response) {
		console.log(response);
});


    return listaconte;
}