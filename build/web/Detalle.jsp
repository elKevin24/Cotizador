<%-- 
    Document   : Detalle
    Created on : 17/11/2020, 10:06:01 AM
    Author     : kcordon
--%>


<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexion"%>
<%@page import="modelo.DetalleCotizacion"%>
<%@page import="controlador.BeanDetalleCotizacion"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Detalle_S"%>
<%@page import="controlador.BeanSolido"%>
<%@page import="modelo.Encabezado"%>
<%@page import="controlador.BeanEncabezado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <script>

            function exportTableToExcel(tableID, filename = '') {
                var downloadLink;
                var dataType = 'application/vnd.ms-excel';
                var tableSelect = document.getElementById(tableID);
                var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');

                // Specify file name
                filename = filename ? filename + '.xls' : 'excel_data.xls';

                // Create download link element
                downloadLink = document.createElement("a");

                document.body.appendChild(downloadLink);

                if (navigator.msSaveOrOpenBlob) {
                    var blob = new Blob(['ufeff', tableHTML], {
                        type: dataType
                    });
                    navigator.msSaveOrOpenBlob(blob, filename);
                } else {
                    // Create a link to the file
                    downloadLink.href = 'data:' + dataType + ', ' + tableHTML;

                    // Setting the file name
                    downloadLink.download = filename;

                    //triggering the function
                    downloadLink.click();
            }
            }
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>

        <%
            String Cotizacion = request.getParameter("Cotizacion");
            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.Cotizacion(Cotizacion);
            String eta = enc.getCWBC_ETA();


        %>
        <jsp:include page="menu.jsp" flush="true"></jsp:include>

        </head>
        <body>

            <h4>Descargar Archivos</h4>
            <div class="trans">


                <form name="form1" action="Cotizacion.jsp" target="_black">
                    <input type="hidden" name="txtparametro" value="<%= Cotizacion%>"/>

                <input type="image" name="botondeenvio" src="img/descarga.png" alt="Enviar formulario" width="100px" height="100px">
            </form>

            <input type="image" onclick="exportTableToExcel('1', 'empornac')" src="img/kisspng-microsoft-excel.jpg" width="100px" height="100px">
        </div>

        <div class="container">

            <table id="1" class="table table-bordered">
                <thead class="text-center">
                    <tr >
                        <th>
                            <img src="https://hh.santotomasport.com.gt/global/santotomasport.com.gt/EMPORNAC_logo.png">
                        </th>
                        <th colspan="8" class="text-center">
                            EMPRESA PORTUARIA NACIONAL "SANTO TOMAS DE CASTILLA" </br>
                            IZABAL, GUATEMALA </br>
                            COTIZACION DE SERVICIOS PORTUARIOS </br>

                        </th>
                    </tr>
                </thead>

                <thead class="text-center" >
                    <tr >
                        <th colspan="3" >
                            Cotizacion: <%= Cotizacion%>

                        </th>
                        <th colspan="2" >
                            Fecha:
                            <script>

                                var f = new Date();
                                document.write(f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear());
                            </script>


                        </th>
                        <th colspan="3" >
                            Fecha ETA:
                            <%= eta%>
                        </th>
                    </tr>
                    <tr>


                        <th colspan="8" class="text-center">
                            Datos de Buque  

                        </th>
                    </tr>
                    <tr>
                        <th  colspan="2">
                            Buque: <%= enc.getCWBC_BUQUE_VIAJE()%>
                        </th>

                        <th  colspan="2">
                            LR: <%= enc.getCWBC_LR()%>
                        </th>
                        <th  colspan="2">
                            Señal Distintica: <%= enc.getCWBC_SENAL_DISTINTIVA()%>
                        </th>
                        <th  colspan="2">
                            Tipo Operacion: <%= enc.getCWBC_TIPO_OPERACION()%>
                        </th>
                    </tr>
                </thead>

                <thead>
                    <tr>
                        <th class="text-center" colspan="8"> 
                            Datos 
                        </th>
                    </tr>

                    <tr>
                        <th class="text-center" colspan="2" >
                            Dolar 
                        </th>

                        <th class="text-center"  colspan="6">
                            Usuario 
                        </th>
                    </tr>

                    <tr>
                        <th class="text-center"  >
                            Precio:  <%= enc.getCWBC_TIPO_CAMBIO()%>
                        </th>
                        <th class="text-center"   >
                            Fecha Tipo Cambio: <%= enc.getCWBC_TIPO_CAMBIO_FECHA().substring(0, 10)%>
                        </th>
                        <th class="text-center" colspan="2" >
                            Grabador:  <%= enc.getGRABADOR()%>
                        </th>
                        <th class="text-center" colspan="2" >
                            Usuario Servicio: <%= enc.getCWBC_USUARIO_SERVICIO()%>
                        </th>
                        <th class="text-center" colspan="2">
                            Codigo Usuario: <%= enc.getCWBC_CODIGO_USUARIO()%>
                        </th>
                    </tr>                               
                </thead> 
                <thead>
                    <tr>
                        <th>CORRELATIVO</th>
                        <th>CANTIDAD</th>
                        <th>UNIDAD MEDIDA</th>
                        <th>CODIGO TARIFA</th>  
                        <th>DESCRIPCION</th>
                        <th>VALOR</th>
                        <th>DESCUENTO</th>
                        <th>SUB TOTAL</th>
                        
                        
                       
                        
                    </tr>
                </thead>
                <tbody>
                    <%

                        LinkedList<BeanDetalleCotizacion> lista = DetalleCotizacion.ObtenerDatos2(Cotizacion);

                        for (int i = 0; i < lista.size(); i++) {

                            out.println("<tr>");

                            out.println("<td>" + lista.get(i).getCWDC_CORRELATIVO() + "</td>");
                            out.println("<td>" + lista.get(i).getCWDC_CANTIDAD() + "</td>");
                            out.println("<td>" + lista.get(i).getDESCRIPCION_UNIDAD_MEDIDA() + "</td>");
                            out.println("<td>" + lista.get(i).getWDC_TDS_CODIGO() + "</td>");
                            out.println("<td>" + lista.get(i).getDESCRIPCION() + "</td>");
                            out.println("<td>" + lista.get(i).getCWDC_VALOR() + "</td>");
                            
                            out.println("<td>" + lista.get(i).getDESCUENTO() + "</td>");
                            out.println("<td class='subtotal'>" + lista.get(i).getCWDC_SUB_TOTAL() + "</td>");
                            
                            
                            
                            

                            out.println("</tr>");

                        }
                        double sum = 0;
                        for (int i = 0; i < lista.size(); i++) {
                            sum = sum + Double.valueOf(lista.get(i).getCWDC_SUB_TOTAL());
                        }

                        out.println("<tr>");
                        out.println("<td colspan='7'> Total: </td>");
                        out.println("<td> Q" + sum + "</td>");
                        out.println("</tr>");
                    %>  
                </tbody>
            </table>              
        </div>
    </div>






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
