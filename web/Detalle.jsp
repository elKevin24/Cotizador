<%-- 
    Document   : Detalle
    Created on : 17/11/2020, 10:06:01 AM
    Author     : kcordon
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>



        <%
            String Cotizacion = request.getParameter("Cotizacion");
            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.Cotizacion(Cotizacion);
            String eta = enc.getCWBC_ETA();
            eta = eta.substring(0, 10);

            BeanSolido sol = new BeanSolido();
            sol = Detalle_S.ObtenerDetalle(Cotizacion);


        %>
        <jsp:include page="menu.jsp" flush="true"></jsp:include>

        </head>
        <body>
            <div class="container">

                <table id="1" class="table table-bordered">
                    <thead class="text-center">
                        <tr >
                            <th WIDTH="25" 
                                HEIGHT="25">
                                <img src="https://hh.santotomasport.com.gt/global/santotomasport.com.gt/EMPORNAC_logo.png">
                            </th>
                            <th colspan="3.5" class="text-center">
                                EMPRESA PORTUARIA NACIONAL "SANTO TOMAS DE CASTILLA" </br>
                                IZABAL, GUATEMALA </br>
                                COTIZACION DE SERVICIOS PORTUARIOS </br>

                            </th>
                        </tr>
                    </thead>
                </table>

                <table id="2" class="table table-bordered">
                    <thead class="text-center">
                        <tr >
                            <th >
                                Cotizacion: <%= Cotizacion%>

                        </th>
                        <th  >
                            Fecha:
                            <script>

                                var f = new Date();
                                document.write(f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear());
                            </script>


                        </th>
                        <th >
                            Fecha ETA:
                            <%= eta%>
                        </th>
                    </tr>
                    <tr>

            </table>

            <table id="3" class="table table-bordered">
                <th colspan="4" class="text-center">
                    Datos de Buque  

                </th>
                </tr>
                <tr>
                    <th  >
                        Buque: <%= enc.getCWBC_BUQUE_VIAJE()%>
                    </th>

                    <th  >
                        LR: <%= enc.getCWBC_LR()%>
                    </th>
                    <th  >
                        Señal Distintica: <%= enc.getCWBC_SENAL_DISTINTIVA()%>
                    </th>
                    <th  >
                        Tipo Operacion: <%= enc.getCWBC_TIPO_OPERACION()%>
                    </th>
                </tr>
                </thead>
            </table>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center" colspan="4"> 
                            Datos 
                        </th>
                    </tr>

                    <tr>
                        <th class="text-center" colspan="2" >
                            Dolar 
                        </th>

                        <th class="text-center"  colspan="2">
                            Usuario 
                        </th>
                    </tr>

                    <tr>
                        <th class="text-center" >
                            Precio:  <%= enc.getCWBC_TIPO_CAMBIO()%>
                        </th>

                        <th class="text-center" >
                            Fecha Tipo Cambio: <%= enc.getCWBC_TIPO_CAMBIO_FECHA()%>
                        </th>

                        <th class="text-center" >
                            Grabador:  <%= enc.getGRABADOR()%>
                        </th>

                        <th class="text-center" >
                            Usuario Servicio: <%= enc.getCWBC_USUARIO_SERVICIO().substring(0, 10)%>
                        </th>
                    </tr>                               

                </thead> 
                


            </table>
                        
                        <table class="responsive-table highlight striped " >

                    <thead class="light-blue darken-4">

                        <tr>

                            <th></th>

                            <th colspan="1">IMPORT</th>

                            <th colspan="2">EXPORT</th>

                        </tr>

                    </thead>

                    <tbody >

                        <tr>

                            <th>Granel Solido</th>

                            <td>

                                Toneladas: <%= sol.getCWSL_DESC_ACEITE_GRASA_QUIMI() %>

                            </td>

                            <td>
                                Toneladas: <%= sol.getCWSL_CARGA_ACEITE_GRASA_QUIMI()%>
                                
                            </td>

                        </tr>

                        <tr>

                            <th>Granel Solido en Pontones</th>

                            <td>
                                Toneladas: <%= sol.getCWSL_DESC_COMBUSTIBLES_DERIV()%>
                            </td>

                            <td>
                                 Toneladas: <%= sol.getCWSL_CARGA_COMBUSTIBLES_DERIV()%>
                            </td>
                        </tr>

                        
                        
                </table>




        </div>






        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <script src="javascript">
                                var dd = hoy.getDate();
                                var mm = hoy.getMonth() + 1;
                                var yyyy = hoy.getFullYear();
        </script>
    </body>
</html>
