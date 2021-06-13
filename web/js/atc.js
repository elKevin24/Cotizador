/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function consultatc(cont) {



    var settings = {
        "url": "https://farm3.sat.gob.gt/atc-ws/rest/privado/atc/consultarAtcPorContenedor",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr",
            "Content-Type": "application/json",
            "Accept": "application/json;charset=utf-8"

        },
        "data": JSON.stringify({"noContenedor": cont
        })
    };

    $.ajax(settings).done(function (response) {



        var valor = null;
        var response2 = null;
        //console.log(response.operacion.atc[0].estado)
        //console.log(response.codigo)

        if (response.codigo == "1") {



            response2 = response.operacion.atc[0].estado;
            //console.log(response.retencionLiberacion[i].estado);

            //console.log("result atc: " + response2);
            if (response2 == "R") {

                valor = 'R';
                
                document.getElementById(cont + "atc").innerHTML = '<img src="img/bullet-green.png" class="tooltipped" data-position="bottom" data-tooltip="Registrado"></>';
   
            }

        }
        return valor;

    });

}