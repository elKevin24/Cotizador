/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function reten(cont) {


var valor = 'L';
    var settings = {
        "url": "https://farm3.sat.gob.gt/retencion-liberacion-ws/rest/privado/retencionLiberacion/consultar",
        //"async": false,
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr",
            "Content-Type": "application/json",
            "Accept": "application/json;charset=utf-8"
            //"Cookie": "visid_incap_2112329=0xk+tVssSjegRxb6moVvoquKumAAAAAAQUIPAAAAAABebEr5ELkke+K1Kp+CTHG/"
        },
        "data": JSON.stringify({
            "noContenedor": cont

        })
    };

    $.ajax(settings).done(function (response) {

       

        
        var response2 = null;
        
        
        if (response.codigo == "0") { 
                 


        for (var i = 0; i < response.retencionLiberacion.length; i++) {

            response2 = response.retencionLiberacion[i].estado;
            //console.log(response.retencionLiberacion[i].estado);
            if (response2 == 'R') {

                valor = 'R';
                document.getElementById(cont).innerHTML='<img src="img/bullet-red.png" class="tooltipped" data-position="bottom" data-tooltip="Sin Peso"></>';


                break

            }

        }
        
        }
    });
    

return valor;
}
