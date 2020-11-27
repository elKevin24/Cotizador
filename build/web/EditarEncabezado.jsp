<%-- 
    Document   : Editar
    Created on : 05-may-2018, 12:51:49
    Author     : nichodeveloper
--%>




<%@ page import="controlador.BeanConsulta"%> 
<%@ page import="modelo.Consulta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    
        <title>Modificacion de datos</title>
    </head>
    <body>
        
        
        <%
               String Cotizacion = request.getParameter("Cotizacion");
               
               BeanConsulta enc = new BeanConsulta();
               enc = Consulta.ConsultaCreado(Cotizacion);
                
         %>
         
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
                        Buque: <%= enc.getNOMBRE_DEL_BUQUE()%>
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
                            Usuario Servicio: <%= enc.getCWBC_USUARIO_SERVICIO()%>
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

                                Toneladas:

                            </td>

                            <td>
                                Toneladas: 
                                
                            </td>

                        </tr>

                        <tr>

                            <th>Granel Solido en Pontones</th>

                            <td>
                                Toneladas: 
                            </td>

                            <td>
                                 Toneladas: 
                            </td>
                        </tr>

                        
                        
                </table>
            
        
        
        
        
    </body>
</html>
