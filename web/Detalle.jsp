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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


        <%
            String Cotizacion = request.getParameter("Cotizacion");
            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.Cotizacion(Cotizacion);
            String eta = enc.getCWBC_ETA();

            try {
                Conexion c = new Conexion();
                Connection con = c.getConexion();
                Statement st;
                st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT COTIZADOR_WEB.F_CW_TARIFA_X_COTIZACION(" + Cotizacion + ",'" + enc.getGRABADOR() + "', TO_DATE('" + enc.getCWBC_TIPO_CAMBIO_FECHA().substring(0, 10) + "','YYYY-MM-DD') , " + enc.getCWBC_HORA() + ", " + enc.getCWBC_CODIGO_USUARIO() + ") from dual");

            } catch (Exception e) {

            }


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
                        <th class="text-center" colspan="5"> 
                            Datos 
                        </th>
                    </tr>

                    <tr>
                        <th class="text-center" colspan="2" >
                            Dolar 
                        </th>

                        <th class="text-center"  colspan="3">
                            Usuario 
                        </th>
                    </tr>

                    <tr>
                        <th class="text-center" >
                            Precio:  <%= enc.getCWBC_TIPO_CAMBIO()%>
                        </th>

                        <th class="text-center" >
                            Fecha Tipo Cambio: <%= enc.getCWBC_TIPO_CAMBIO_FECHA().substring(0, 10)%>
                        </th>

                        <th class="text-center" >
                            Grabador:  <%= enc.getGRABADOR()%>
                        </th>

                        <th class="text-center" >
                            Usuario Servicio: <%= enc.getCWBC_USUARIO_SERVICIO()%>
                        </th>

                        <th class="text-center" >
                            Codigo Usuario: <%= enc.getCWBC_CODIGO_USUARIO()%>
                            dias = <%= enc.getCWBC_HORA()%>
                        </th>
                    </tr>                               

                </thead> 



            </table>


            <div class="col s12">

                <table id="ejemplo" border="1"   class="highlight responsive-table striped " >
                    <thead class="encabezado">
                        <tr>

                            <th>CORRELATIVO</th>
                            <th>CANTIDAD</th>                           
                            <th>CODIGO TARIFA</th>                            
                            <th>VALOR</th>
                            <th>SUB_TOTAL</th>
                            <th>DESCUENTO</th>
                            <th>DESCRIPCION</th>
                            <th>VALOR QUETZAL</th>
                            <th>FACTOR AJUSTE</th>
                            <th>UNIDAD MEDIDA</th>


                        </tr>
                    </thead>
                    <tbody>
                        <%

                            LinkedList<BeanDetalleCotizacion> lista = DetalleCotizacion.ObtenerDatos2(Cotizacion);

                            for (int i = 0; i < lista.size(); i++) {

                                out.println("<tr>");

                                out.println("<td>" + lista.get(i).getCWDC_CORRELATIVO() + "</td>");
                                out.println("<td>" + lista.get(i).getCWDC_CANTIDAD() + "</td>");
                                out.println("<td>" + lista.get(i).getWDC_TDS_CODIGO() + "</td>");
                                out.println("<td>" + lista.get(i).getCWDC_VALOR() + "</td>");
                                out.println("<td class='subtotal'>" + lista.get(i).getCWDC_SUB_TOTAL() + "</td>");
                                out.println("<td>" + lista.get(i).getDESCUENTO() + "</td>");
                                out.println("<td>" + lista.get(i).getDESCRIPCION() + "</td>");
                                out.println("<td>" + lista.get(i).getVALOR_QUETZAL() + "</td>");
                                out.println("<td>" + lista.get(i).getFACTOR_AJUSTE() + "</td>");
                                out.println("<td>" + lista.get(i).getDESCRIPCION_UNIDAD_MEDIDA() + "</td>");

                                out.println("</tr>");

                            }
                        %>  
                    </tbody>
                   <tfoot>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th>Total</th>
        </tr>
    </tfoot>
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

    <script>
        $(document).ready(function ()
        {
            //Defino los totales de mis 2 columnas en 0
            
            var total_col5 = 0;
            //Recorro todos los tr ubicados en el tbody
            $('#ejemplo tbody').find('tr').each(function (i, el) {

                //Voy incrementando las variables segun la fila ( .eq(0) representa la fila 1 )     
                    total_col5 += parseFloat($(this).find('td').eq(4).text());

            });
            //Muestro el resultado en el th correspondiente a la columna
              $('#ejemplo tfoot tr th').eq(9).text("Total " + total_col5);

        });
    </script>


</body>
</html>
