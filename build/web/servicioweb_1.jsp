<%-- 
    Document   : newjsp
    Created on : 4/06/2021, 06:36:38 PM
    Author     : kcordon
--%>

<%@page import="modelo.TrazabilidadContenedores"%>
<%@page import="controlador.Trazabilidad_Contenedores"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>



        </script>
    </head>
    <body>

        
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>


    <div id="demo">
        <h1>The XMLHttpRequest Object</h1>
        <button type="button" onclick="loadDoc()">Change Content</button>
    </div>
    <script>
        var settings = {
            "url": "https://farm3.sat.gob.gt/retencion-liberacion-ws/rest/privado/retencionLiberacion/consultar",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Authorization": "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr",
                "Content-Type": "application/json",
                "Cookie": "visid_incap_2112329=0xk+tVssSjegRxb6moVvoquKumAAAAAAQUIPAAAAAABebEr5ELkke+K1Kp+CTHG/"
            },
            "data": JSON.stringify({
                "noContenedor": "HAMU1004983"
            })
        };

        $.ajax(settings).done(function(response) {
            


console.log(response);
            var x = response.getElementsByTagName("mensajeRespuesta");
            var z = response.getElementsByTagName("retencionesLiberaciones");
            var y = response.getElementsByTagName("estado")

            var node;
            var mensaje_c;
            var tipo;
            var codigo;
            var mensaje;
            var firma;
            var retencion;
            var noRetencion;
            
            //console.log(y);
            for (var i = 0; i < y.length; i++) {
                node = y[i].childNodes;
              console.log(node[0].nodeValue);

            }
            
            
            
            
            for (var i = 0; i < node.length; i++) {
                mensaje = node[i].childNodes;             
                

            }
            
            
           


            //solo se recibe un parametro  aunque se recorra solo hay un valor 

            for (var i = 0; i < z.length; i++) {
                node = z[i].childNodes;

            }




            for (var i = 0; i < x.length; i++) {
                mensaje_c = x[i].childNodes;

            }
            console.log(mensaje_c);

            console.log(mensaje_c[0].childNodes[0].nodeValue);
            console.log(mensaje_c[1].childNodes[0].nodeValue);
            console.log(mensaje_c[2].childNodes[0].nodeValue);
            console.log(mensaje_c[3].childNodes[0].nodeValue);


            for (var i = 0; i < mensaje_c.length; i++) {
                retencion = mensaje_c[i].childNodes;             
                

            }
            
            console.log(retencion[0].childNodes[0]);
            
             for (var i = 0; i < retencion.length; i++) {
                tipo = retencion[i].childNodes;             
                

            }
            
            console.log(tipo[0].childNodes[0]);
            
            for (var i = 0; i < tipo.length; i++) {
                codigo = tipo[i].childNodes;             
                

            }
            
            
            console.log(codigo[0].nodeValue);
            
            
            
            
             


            
            

        });
    </script>
    
    
    

    </body>
</html>
