<%-- 
    Document   : BarcoCotizar
    Created on : 3/11/2020, 09:13:41 AM
    Author     : kcordon
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexion"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.LinkedList"%>
<%@page import="controlador.BeanEncabezado"%>
<%@page import="controlador.BeanBarcos"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="modelo.Barcos"%>
<%@page import="modelo.Encabezado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <jsp:include page="menu.jsp" flush="true"></jsp:include>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

            <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
            <script type="text/javascript" src="js/materialize.min.js"></script>
            <script type="text/javascript" src="js/materialize.js"></script>

            <script type="text/javascript">


                $(document).ready(function () {
                    $('select').formSelect();
                });


                $(document).ready(function () {
                    $('.timepicker').timepicker();
                });
                
                function validar() {
                if (confirm("Desea Borrar los datos?")) {
                    alert("Datos borrados exitosamente");
                } else {
                    alert("No se borrara");
                    return false;
                }
            }

            </script>
        </head>
        <body>
        <%
            String usuario = String.valueOf(session.getAttribute("usuario"));
            BeanUsuarios user = new BeanUsuarios();
            user = Usuario.ObtenerUsuario(usuario);
            String codigo = user.getUSUARIO_DE_SERVICIO();
            String LR = request.getParameter("LR");

            BeanBarcos ship = new BeanBarcos();
            ship = Barcos.ObtenerBarcos(LR);

            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.ObtenerCotizacion();
            BeanUsuarios cambio = new BeanUsuarios();
            cambio = Usuario.ObtenerCambioDolar();


        %>

        <h3 style="text-align:center;"> Barco: <%=ship.getNOMBRE_DEL_BUQUE()%> , Numero Cotizacion:  <%= enc.getCWBC_COTIZACION()%> </h3>

        
        <div class="container">
            <div class="col s12">

                <table id="table_id" border="1"   class="highlight responsive-table striped " >
                    <thead>
                        <tr>


                            <th>Cotizacion</th>
                            <th>ETA</th>
                            <th>Cambio Dolar</th>
                            <th>Fecha Cambio</th>
                            <th>Operacion</th>


                        </tr>
                    </thead>
                    <tbody>
                        <%

                            LinkedList<BeanEncabezado> lista = Encabezado.CotizacionesBarco(LR);

                            for (int i = 0; i < lista.size(); i++) {

                                out.println("<tr>");

                                out.println("<td>" + lista.get(i).getCWBC_COTIZACION() + "</td>");
                                out.println("<td>" + lista.get(i).getCWBC_ETA() + "</td>");
                                out.println("<td>" + lista.get(i).getCWBC_TIPO_CAMBIO() + "</td>");
                                out.println("<td>" + lista.get(i).getCWBC_TIPO_CAMBIO_FECHA() + "</td>");
                                out.println("<td>" + lista.get(i).getCWBC_TIPO_OPERACION() + "</td>");
                                out.println("<td>" + "<a class='waves-effect waves-light btn-small' onclick='return myFunction()'href=Detalle.jsp?Cotizacion=" + lista.get(i).getCWBC_COTIZACION() +">" + "Consultar" + "</a>" + "</td>");

                                out.println("</tr>");
                            }
                        %>  
                    </tbody>
                </table>

            </div>
        </div><!-- div cointainer-->


    </body>
</html>
