/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var listaconte = new Array();
var AOP = new Array();



function reten(cont) {

    var settings = {
        "url": "https://farm3.sat.gob.gt/retencion-liberacion-ws/rest/privado/retencionLiberacion/consultar",
        "async": true,
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr",            
            "Content-Type": "application/json",
            "Accept": "application/json;charset=utf-8",
            
        },
        "data": JSON.stringify({
            "noContenedor": cont

        })
    };

    $.ajax(settings).done(function (response) {

//AOP.push(new Array(response.retencionesLiberaciones[0].manifiesto,response.retencionesLiberaciones[0].noDocumentoTransporte,cont));
//console.log(response.retencionesLiberacion[0].manifiesto,response.retencionesLiberacion[0].noDocumentoTransporte,cont);


        var response2 = null;

        if (response.codigo == "0") {

            //console.log(response.retencionLiberacion[0].noManifiesto, response.retencionLiberacion[0].noDocumentoTransporte, cont);
            AOP.push(new Array(response.retencionLiberacion[0].noManifiesto, response.retencionLiberacion[0].noDocumentoTransporte, cont));
            APIOPA(response.retencionLiberacion[0].noManifiesto, response.retencionLiberacion[0].noDocumentoTransporte, cont);

            for (var i = 0; i < response.retencionLiberacion.length; i++) {


                response2 = response.retencionLiberacion[i].estado;
                //console.log(response.retencionLiberacion[i].estado);
                if (response2 == 'R') {
                    valor = 'R';
                    listaconte.push(cont);
                    //console.log(cont);
                    //console.log(listaconte);

                    break
                }
            }
        }
    });


    return listaconte;
}


function cambiarcolor() {

    console.log(listaconte);
    console.log(AOP);

    for (var i = 0; i < listaconte.length; i++) {

        try {
            // console.log(listaconte[i]);
            document.getElementById(listaconte[i]).innerHTML = '<img src="img/bullet-red.png" class="tooltipped" data-position="bottom" data-tooltip="Retenido">';
            // declaraciones para try

        } catch (e) {
            // pasar el objeto exception al controlador de errores (es decir, su propia función)
        }
    }
}



