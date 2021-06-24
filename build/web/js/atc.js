/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var atc = new Array();

function consultatcdesc(cont) {

    var settings = {
        "url": "https://farm3.sat.gob.gt/atc-ws/rest/privado/atc/consultarAtcPorContenedor",
        "async": true,
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr",
            "Content-Type": "application/json",
            "Accept": "application/json;charset=utf-8"

        },
        "data": JSON.stringify({
            "noContenedor": cont
        })
    };

    $.ajax(settings).done(function (response) {

        var response2 = null;
       
        //console.log(response.operacion.atc[0].estado)
       
        if (response.codigo == '1') {
            
            
            
            response2 = response.operacion.atc[0].estado;
            //console.log(response.operacion.atc[0].estado);
             
            //atc.push(cont);
            
            //console.log("result atc: " + response2);
            if (response2 == 'R') {
                atc.push(cont);
                
               
                
               // document.getElementById(cont + "atc").innerHTML = '<img src="img/bullet-green.png" class="tooltipped" data-position="bottom" data-tooltip="Registrado"></>';
   
            }

        }
        

    });
    
    
return atc;
}


function cambiarcoloratc_descarga() {

    console.log(atc);

    for (var i = 0; i < atc.length; i++) {

        try {
            //console.log(atc[i]);
            document.getElementById(atc[i]+"atc").innerHTML = '<img src="img/bullet-green.png" class="tooltipped" data-position="bottom" data-tooltip="Registrado">';
            // declaraciones para try

        } catch (e) {
            
             // pasar el objeto exception al controlador de errores (es decir, su propia función)
        }



    }
}
    