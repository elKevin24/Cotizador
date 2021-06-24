<%@page import="modelo.TrazabilidadContenedores"%>
<%@page import="controlador.Trazabilidad_Contenedores"%>
<%@page import="modelo.TrazabilidadBarcos"%>
<%@page import="controlador.Trazabilidad_Barcos"%>
<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="modelo.Barcos"%>
<%@page import="controlador.BeanBarcos"%>
<%@page import="java.util.*"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="menu.jsp" flush="true"></jsp:include>

            <script src="js/retenciones.js" type="text/javascript"></script>
            <!--Import Google Icon Font-->
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <!--Import materialize.css-->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Compiled and minified JavaScript -->
            <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

            <!-- Compiled and minified JavaScript -->


            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>

            <!--Let browser know website is optimized for mobile-->
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


            <title>Trazabilidad Contenedor</title>
        <%
            String id = request.getParameter("id");
            Trazabilidad_Contenedores cont = new Trazabilidad_Contenedores();
            cont = TrazabilidadContenedores.ManifiestoImport(id);

        %>

    </head>
    <body>
        <div class="container">
            <div class="col s12">
                <h4 class="center"> Trazabilidad Contenedor  "<%= id%>"</h4>
            </div>
            <table id="my-table" class="table table-bordered">
                <tr class="azul white_text">
                    <th colspan="6" >Retenciones y Liberaciones por Instituciones</th>
                </tr>
                <tr class="celeste">
                    <th>Mensaje</th>
                    <th>Contenedor</th>
                    
                    <th>MAGA</th>
                    <th>DIPA</th>
                    <th>SEPA</th>
                    <th>SGDAIA</th>
                </tr>
                <tr>
                    <td id="mensaje"></td>
                    <td id="contenedor"></td>
                    
                    <td id="MAGA"><img src="img/new/Bullet-grey.png"></td>
                    <td id="DIPA"><img src="img/new/Bullet-grey.png"></td>
                    <td id="SEPA"><img src="img/new/Bullet-grey.png"></td>
                    <td id="SGDAIA"><img src="img/new/Bullet-grey.png"></td>
                </tr>
            </table>
            <table id="my-table" class="table table-bordered">
                <tr class="azul white_text">
                    <th colspan="6" >ATC</th>
                </tr>
                <tr class="celeste">
                    <th>Mensaje</th>
                    <th>No. Atc</th>
                    <th>Estado</th>
                    <th>Descripcion Estado</th>
                    <th>Fecha Estado Registrado</th>
                    <th>Fecha Estado Actual</th>
                </tr>
                <tr>
                    <td id="mensajeatc"></td>
                    <td id="noAtc"></td>
                    <td id="estado"></td>
                    <td id="descripcionEstado"></td>
                    <td id="fechaEstadoRegistrado"></td>
                    <td id="fechaEstadoActual"></td>
                </tr>
            </table>
            <table id="my-table" class="table table-bordered">
                <tr class="azul white_text">
                    <th colspan="5" >Informacion Manifiesto</th>
                </tr>
                <tr class="celeste">
                    <th>Fecha Recibido</th>
                    <th>No. Manifiesto</th>
                    <th>Nombre Buque</th>
                    <th>Viaje</th>
                    <th>ETA</th>
                </tr>
                <tr>
                    <td> <%= cont.getC1()%></td>
                    <td ><%= cont.getC2()%></td>
                    <td><%= cont.getC3()%></td>
                    <td><%= cont.getC4()%></td>
                    <td><%= cont.getC5()%></td>
                </tr>
            </table>
        </div>
        <script>
            var settings = {
                "url": "https://farm3.sat.gob.gt/retencion-liberacion-ws/rest/privado/retencionLiberacion/consultar",
                "method": "POST",
                "timeout": 3000,
                "headers": {
                    "Authorization": "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr",
                    "Content-Type": "application/json",
                    "Accept": "application/json;charset=utf-8",

                },
                "data": JSON.stringify({
                    "noContenedor": "<%= id%>"
                })
            };

            $.ajax(settings).done(function (response) {

                console.log(response);
                document.getElementById("contenedor").innerHTML = "<%= id%>";
                document.getElementById("mensaje").innerHTML = response.mensaje;
                if (response.codigo == 0) {

                    for (var i = 0; i < response.retencionLiberacion.length; i++) {
                        //console.log(response.retencionLiberacion[i].estado);
                        if (response.retencionLiberacion[i].entidadRetiene == 'MAGA' && response.retencionLiberacion[i].estado == 'R') {
                            console.log('MAGA');
                            document.getElementById("MAGA").innerHTML = '<img src="img/new/Bullet-red.png" data-toggle="tooltip" data-placement="bottom" title="Fecha Retencion: ' + response.retencionLiberacion[i].fechaRetencion + '">';

                            $(document).ready(function () {
                                $('[data-toggle="tooltip"]').tooltip();
                            });
                            //console.log(listaconte);                           
                        }
                        if (response.retencionLiberacion[i].entidadRetiene == 'SEPA' && response.retencionLiberacion[i].estado == 'R') {
                            console.log('SEPA');
                            document.getElementById("SEPA").innerHTML = '<img src="img/new/Bullet-red.png" data-toggle="tooltip" data-placement="bottom" title="Fecha Retencion: ' + response.retencionLiberacion[i].fechaRetencion + '">';

                            $(document).ready(function () {
                                $('[data-toggle="tooltip"]').tooltip();
                            });

                            //console.log(listaconte);                           
                        }
                        if (response.retencionLiberacion[i].entidadRetiene == 'DIPA' && response.retencionLiberacion[i].estado == 'R') {
                            console.log('DIPA');
                            document.getElementById("DIPA").innerHTML = '<img src="img/new/Bullet-red.png" data-toggle="tooltip" data-placement="bottom" title="Fecha Retencion: ' + response.retencionLiberacion[i].fechaRetencion + '">';

                            $(document).ready(function () {
                                $('[data-toggle="tooltip"]').tooltip();
                            });
                            //console.log(listaconte);                           
                        }
                        if (response.retencionLiberacion[i].entidadRetiene == 'SGAIA' && response.retencionLiberacion[i].estado == 'R') {
                            console.log('SGAIA');
                            document.getElementById("SGAIA").innerHTML = '<img src="img/new/Bullet-red.png" data-toggle="tooltip" data-placement="bottom" title="Fecha Retencion: ' + response.retencionLiberacion[i].fechaRetencion + '">';

                            $(document).ready(function () {
                                $('[data-toggle="tooltip"]').tooltip();
                            });
                            //console.log(listaconte);                           
                        }



                    }
                } else {
                    console.log(response.codigo);
                }

            }).fail(function (response) {
                document.getElementById("mensaje").innerHTML = "Sin respuesta de Servicios Web Sat";

            });


        </script>

        <script>
            var settings = {
                "url": "https://farm3.sat.gob.gt/atc-ws/rest/privado/atc/consultarAtcPorContenedor",
                "method": "POST",
                "timeout": 3000,
                "headers": {
                    "Authorization": "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr",
                    "Content-Type": "application/json",
                    "Accept": "application/json;charset=utf-8"
                },
                "data": JSON.stringify({"noContenedor": "<%= id%>"})
            };

            $.ajax(settings).done(function (response) {
                console.log(response);


                if (response.codigo == 1) {

                    document.getElementById("noAtc").innerHTML = response.operacion.atc[0].noAtc;
                    document.getElementById("estado").innerHTML = response.operacion.atc[0].estado;
                    document.getElementById("descripcionEstado").innerHTML = response.operacion.atc[0].descripcionEstado;
                    document.getElementById("fechaEstadoRegistrado").innerHTML = response.operacion.atc[0].fechaEstadoRegistrado;
                    document.getElementById("fechaEstadoActual").innerHTML = response.operacion.atc[0].fechaEstadoActual;



                }

            }).fail(function (response) {
                document.getElementById("mensajeatc").innerHTML = "Sin respuesta de Servicios Web Sat";

            });
        </script>



        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>




        <!--JavaScript at end of body for optimized loading-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>


    </body>
</html>
