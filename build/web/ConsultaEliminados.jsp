<%-- 
    Document   : Consulta
    Created on : 19/11/2020, 09:52:13 AM
    Author     : kcordon
--%>

<%@page import="controlador.BeanConsulta"%>
<%@page import="modelo.Consulta"%>
<%@page import="modelo.Barcos"%>
<%@page import="controlador.BeanBarcos"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.LinkedList"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.js"></script>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>



        <jsp:include page="menu.jsp" flush="true"></jsp:include>

        </head>
        <body>
            <div class="row">
                <div class="col s1 push-s1">
                    <a  href="Barcos.jsp" class="btn-floating pulse" ><i class="material-icons">arrow_back</i></a>
                </div>
            </div>

            <div class="container">

                <div class="col s12">

                    <table id="table_id" border="1"   class="highlight responsive-table striped " >
                        <thead>
                            <tr>

                                <th>COTIZACION</th>
                                <th>LR</th>
                                <th>SENAL DISTINTIVA</th>
                                <th>ETA</th>
                                <th>TIPO CAMBIO</th>
                                <th>USUARIO SERVICIO</th>
                                <th>NIT</th>
                                <th>TIPO OPERACION</th>
                                <th>GRABADOR</th>
                                <th>HORA</th>



                            </tr>
                        </thead>
                        <tbody>
                        <%
                            String usuario = String.valueOf(session.getAttribute("usuario"));
                            BeanUsuarios user = new BeanUsuarios();
                            user = Usuario.ObtenerUsuario(usuario);
                            String codigo = user.getUSUARIO_DE_SERVICIO();

                            LinkedList<BeanConsulta> lista = Consulta.CotizacionEliminados(codigo);

                            for (int i = 0; i < lista.size(); i++) {

                                out.println("<tr>");
                                out.println("<td>" + lista.get(i).getCWBC_COTIZACION() + "</td>");
                                out.println("<td>" + lista.get(i).getCWBC_LR() + "</td>");
                                out.println("<td>" + lista.get(i).getCWBC_SENAL_DISTINTIVA() + "</td>");

                                out.println("<td>" + lista.get(i).getCWBC_ETA() + "</td>");
                                out.println("<td>" + lista.get(i).getCWBC_TIPO_CAMBIO() + "</td>");
                                
                                out.println("<td>" + lista.get(i).getCWBC_USUARIO_SERVICIO() + "</td>");
                                out.println("<td>" + lista.get(i).getCWBC_NIT() + "</td>");
                                out.println("<td>" + lista.get(i).getCWBC_TIPO_OPERACION() + "</td>");
                                out.println("<td>" + lista.get(i).getGRABADOR() + "</td>");
                                out.println("<td>" + lista.get(i).getCWBC_HORA() + "</td>");

                                out.println("</tr>");
                            }
                        %>  
                    </tbody>
                </table>

            </div>
        </div>


        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>


        <script type="text/javascript">

            $(document).ready(function () {
                $('#table_id').DataTable();
            });

        </script>
    </body>


</html>
