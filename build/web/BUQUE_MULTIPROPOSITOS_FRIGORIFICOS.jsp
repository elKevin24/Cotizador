<%@page import="modelo.Encabezado"%>
<%@page import="controlador.BeanEncabezado"%>
<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="modelo.Barcos"%>
<%@page import="controlador.BeanBarcos"%>
<%@page import="java.util.*"%>


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
        <%
            String Cotizacion = request.getParameter("Cotizacion");
            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.CotizacionGeneral(Cotizacion);
        %>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <jsp:include page="menu.jsp" flush="true"></jsp:include>

        </head>
        <body>
            <div class="row">
                <div class="col s1 push-s1">
                    <a  href="index.jsp" class="btn-floating pulse" ><i class="material-icons">arrow_back</i></a>
                </div>
            </div>

            <div class="container">

                <h5> Cotizacion LR: <%= enc.getCWBC_LR() + "  ETA: " + enc.getCWBC_ETA() + "  SEÑAL DISTINTIVA: " + enc.getCWBC_SENAL_DISTINTIVA()%></h5>


            <form action="ServleMultiFrigo.do" method="post" >
                <div class="row">
                    <div class="col s12">

                        <div class="divider"></div>

                        <div class="section" align="center">
                            <p> Aplica Muellaje a Contenedores</p>
                            <div class="input-field col s12">

                                <!-- Switch -->
                                <div class="switch" align="center">
                                    <label>
                                        No
                                        <input type="checkbox" name="Muellaje" id="Muellaje">
                                        <span class="lever"></span>
                                        Si
                                    </label>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>

                <div class="divider"></div>

                <div class="section">


                </div>

                <table class="responsive-table highlight striped">

                    <thead>

                        <tr>

                            <th></th>

                            <th colspan="2">Via Indirecta</th>

                            <th colspan="2">Via Directa</th>

                        </tr>

                        <tr>

                            <th scope="col">Descripcion</th>

                            <th>Grua Puerto</th>

                            <th>Grua Buque</th>

                            <th>Grua Puerto</th>

                            <th>Grua Buque</th>

                        </tr>

                    </thead>

                    <tbody>

                        <tr>

                            <th>Descarga Llenos</th>

                            <td>

                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>

                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                        </tr>

                        <tr>

                            <th>Descaga Vacios</th>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                        </tr>

                        <tr>

                            <th>Carga Llenos</th>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                        </tr>

                        <tr>

                            <th>Carga Vacios</th>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                        </tr>
                        
                        <tr>

                            <th>Vehiculos</th>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>  
                        </tr>
                        <tr>

                            <th>Reestibas</th>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>  
                        </tr>
                        <tr>

                            <th>Tapa Escotillas</th>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>  
                        </tr>
                        <tr>

                            <th>Depositos Temporales</th>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>  
                        </tr>
                        <tr>

                            <th>Reembarques</th>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>  
                        </tr>
                        <tr>

                            <th>Dep. Momentaneos</th>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>  
                        </tr>
                        <tr>

                            <th>Descarga Merc. General</th>

                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>
                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>
                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>
                        </tr>
                        <tr>

                            <th>Carga Merc. General</th>

                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>  
                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>
                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>
                        </tr>
                        <tr>

                            <th>Carga Fruta Fresca Paletizada</th>

                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>

                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>
                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>
                            <td>
                                <input  placeholder="Toneladas" name="VDGPDL" type="text" class="validate">
                                <label for="VDGPDL"></label>
                            </td>
                        </tr>
                        
                </table>
                
                

                <div class="input-field col s1">
                    <input type="text" name="CWSF_COTIZACION" value="<%= Cotizacion%>" >
                    <label for="CWSF_COTIZACION">Cotizacion</label>
                </div>











                <div class="input-field col s3">
                    <input type="submit" value="Registrar" class="btn-large light-blue accent-4" name="enviar">

                </div>
            </form>


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
