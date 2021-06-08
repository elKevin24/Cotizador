<%-- 
    Document   : Detalle
    Created on : 17/11/2020, 10:06:01 AM
    Author     : kcordon
--%>


<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.math.BigDecimal"%>
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

            <input type="image" onclick="exportTableToExcel('1', 'empornac')" src="img/xls.png" width="150px" height="100px">
           
        </div>

        <div class="container">
            <div class="table-responsive-lg">
                <table id="1" class="table table-bordered table-striped " class="text-center">
                    <thead class="text-center">
                        <tr>
                            <th>
                               
                                <p><img src="img/EMPORNAC_logo.png"></p>
                            </th>
                            <th colspan="7">
                                <p>EMPRESA PORTUARIA NACIONAL "SANTO TOMAS DE CASTILLA"</p> 
                                <p>IZABAL, GUATEMALA </p> 
                                <p>COTIZACION DE SERVICIOS PORTUARIOS</p> 
                            </th>
                        </tr>
                    </thead>

                    <thead>
                        <tr>
                            <th colspan="2">
                                Cotizacion: <%= Cotizacion%>

                            </th>
                            <th colspan="2">
                                Fecha:
                                <script>

                                    var f = new Date();
                                    document.write(f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear());
                                </script>


                            </th>
                            <th colspan="2">
                                Fecha ETA:
                                <%= eta%>
                            </th>
                            <th colspan="2">
                                Horas Estadia:
                                <%= enc.getCWBC_HORA()%>
                            </th>
                        </tr>
                        <tr class="text-center ">


                            <th colspan="8" class="cuerpo">
                                Datos de Buque  

                            </th>
                        </tr>
                        <tr>
                            <th colspan="2">
                                Buque: <%= enc.getCWBC_BUQUE_VIAJE()%>
                            </th>

                            <th colspan="2">
                                LR: <%= enc.getCWBC_LR()%>
                            </th>
                            <th colspan="2">
                                Señal Distintica: <%= enc.getCWBC_SENAL_DISTINTIVA()%>
                            </th>
                            <th colspan="2">
                                Tipo Operacion: <%= enc.getCWBC_TIPO_OPERACION()%>
                            </th>
                        </tr>
                    </thead>

                    <thead>
                        <tr class="text-center">
                            <th colspan="8" class="cuerpo"> 
                                Datos 
                            </th>
                        </tr>

                        <tr class="text-center">
                            <th colspan="2">
                                Dolar 
                            </th>

                            <th colspan="6"> 
                                Usuario 
                            </th>
                        </tr>

                        <tr class="text-center">
                            <th>
                                Precio:  <%= enc.getCWBC_TIPO_CAMBIO()%>
                            </th>
                            <th>
                                Fecha Tipo Cambio: <%= enc.getCWBC_TIPO_CAMBIO_FECHA().substring(0, 10)%>
                            </th>
                            <th colspan="2">
                                Grabador:  <%= enc.getGRABADOR()%>
                            </th>
                            <th colspan="2">
                                Usuario Servicio: <%= enc.getCWBC_USUARIO_SERVICIO()%>
                            </th>
                            <th colspan="2">
                                Codigo Usuario: <%= enc.getCWBC_CODIGO_USUARIO()%>
                            </th>
                        </tr>                               
                    </thead> 
                    <thead>
                        <tr>
                            <th scope="col">NO.</th> 
                            <th scope="col">CODIGO TARIFA</th> 
                            <th scope="co1" colspan="2">DESCRIPCION</th>
                            <th scope="col">CANTIDAD</th>
                            <th scope="col">UNIDAD MEDIDA</th>
                            <th scope="col">VALOR</th>

                            <th scope="col">SUB TOTAL</th>




                        </tr>
                    </thead>
                    <tbody>
                        <%

                            LinkedList<BeanDetalleCotizacion> lista = DetalleCotizacion.ObtenerDatos2(Cotizacion);
                            DecimalFormat formato = new DecimalFormat("¤#,###.00");
int a = 0;
                            for (int i = 0; i < lista.size(); i++) {
                                
                                
                                a=a+1;
                                out.println("<tr>");
                                Double sub = Double.valueOf(lista.get(i).getCWDC_SUB_TOTAL());
                                Double can = Double.valueOf(lista.get(i).getCWDC_CANTIDAD());
                                Double total = sub / can;

                                BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
                                double val2 = bd.doubleValue();

                                String valor = formato.format(val2);

                                Double subdouble = Double.valueOf(lista.get(i).getCWDC_SUB_TOTAL());
                                BigDecimal bd1 = new BigDecimal(subdouble).setScale(2, RoundingMode.HALF_UP);
                                double val3 = bd1.doubleValue();

                                String subtotal = formato.format(val3);

                                out.println("<td>" + a + "</td>");
                                out.println("<td>" + lista.get(i).getWDC_TDS_CODIGO() + "</td>");
                                out.println("<td colspan='2'>" + lista.get(i).getDESCRIPCION() + "</td>");
                                out.println("<td class='text-right'>" + lista.get(i).getCWDC_CANTIDAD() + "</td>");
                                out.println("<td><div class='size'>" + lista.get(i).getREFERENCIA_UNIDAD_MEDIDA() + "</div></td>");
                                out.println("<td><div class='size text-right'>" + valor + "</div></td>");
                                out.println("<td><div class='size text-right'>" + subtotal + "</div></td>");
                                out.println("</tr>");

                            }
                            double sum = 0;
                            for (int i = 0; i < lista.size(); i++) {
                                sum = sum + Double.valueOf(lista.get(i).getCWDC_SUB_TOTAL());
                            }

                            BigDecimal bd = new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP);
                            double val2 = bd.doubleValue();

                            String valor = formato.format(val2);

                            out.println("<tr>");
                            out.println("<td colspan='7' class='subtotal' > Sub-Total: </td>");
                            out.println("<td class='text-right subtotal'>" + valor + "</td>");
                            out.println("</tr>");
                        %>  
                        <tr class="text-center">
                            <th colspan="8"> 
                                Valores sin Iva 
                            </th>
                        </tr>
                        
                        <%

                            LinkedList<BeanDetalleCotizacion> lista2 = DetalleCotizacion.Noiva(Cotizacion);
                            

                            for (int i = 0; i < lista2.size(); i++) {
                                
                                out.println("<tr>");
                                Double sub2 = Double.valueOf(lista2.get(i).getCWDC_SUB_TOTAL());
                                Double can2 = Double.valueOf(lista2.get(i).getCWDC_CANTIDAD());
                                Double total2 = sub2 / can2;
                                
                                
                                BigDecimal bd2 = new BigDecimal(total2).setScale(2, RoundingMode.HALF_UP);
                                double val22 = bd2.doubleValue();

                                String valork = formato.format(val22);

                                Double subdouble2 = Double.valueOf(lista2.get(i).getCWDC_SUB_TOTAL());
                                BigDecimal bd12 = new BigDecimal(subdouble2).setScale(2, RoundingMode.HALF_UP);
                                double val32 = bd12.doubleValue();

                                String subtotal2 = formato.format(val32);

                             a=a+1;

                                out.println("<td>" + a + "</td>");
                                out.println("<td>" + lista2.get(i).getWDC_TDS_CODIGO() + "</td>");
                                out.println("<td colspan='2'>" + lista2.get(i).getDESCRIPCION() + "</td>");
                                out.println("<td class='text-right'>" + lista2.get(i).getCWDC_CANTIDAD() + "</td>");
                                out.println("<td><div class='size'>" + lista2.get(i).getREFERENCIA_UNIDAD_MEDIDA() + "</div></td>");
                                out.println("<td><div class='size text-right'>" + valork + "</div></td>");
                                out.println("<td><div class='size text-right'>" + subtotal2 + "</div></td>");
                               
                              
                                 out.println("</tr>");

                            }double sum2 = 0;
                            for (int i = 0; i < lista2.size(); i++) {
                                sum2 = sum2 + Double.valueOf(lista2.get(i).getCWDC_SUB_TOTAL());
                            }

                            BigDecimal bd9 = new BigDecimal(sum2).setScale(2, RoundingMode.HALF_UP);
                            double val29 = bd9.doubleValue();

                            String valor9 = formato.format(val29);
                            
                            double total = val29+val2;
                            
                            String total2 = formato.format(total);

                            out.println("<tr>");
                            out.println("<td colspan='7'  class='subtotal'> Sub-Total: </td>");
                            out.println("<td class='text-right  subtotal'>" + valor9 + "</td>");
                            out.println("</tr>");
                            
                            out.println("<tr>");
                            out.println("<td colspan='7' class='subtotal2'> Total: </td>");
                            out.println("<td class='text-right subtotal2'>" + total2 + "</td>");
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
