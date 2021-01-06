<%@page import="modelo.Detalle_P"%>
<%@page import="controlador.BeanPorta"%>
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




        <jsp:include page="menu.jsp" flush="true"></jsp:include>
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <!--Import materialize.css-->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
            <link rel="stylesheet" type="text/css" href="css/newcss.css">
        <%
            String Cotizacion = request.getParameter("Cotizacion");
            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.Cotizacion(Cotizacion);

            BeanPorta porta = new BeanPorta();
            porta = Detalle_P.Obtenerxedit(Cotizacion);
            String eta = porta.getCWBC_ETA();
            eta.substring(0, 10);
            eta = eta.substring(0, 10) + "T" + eta.substring(11);
            eta = eta.substring(0, 16);

        %>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    </head>
    <body>
        <div class="row">
            <div class="col s1 push-s1">
                <a  href="Barcos.jsp" class="btn-floating pulse" ><i class="material-icons">arrow_back</i></a>
            </div>
        </div>



        <div class="container">

            <h5 class="text-center"> <%="Cotizacion: " + enc.getCWBC_COTIZACION() + ", Nombre Buque:" + enc.getCWBC_BUQUE_VIAJE() + ", LR: " + enc.getCWBC_LR() + ",  ETA: " + enc.getCWBC_ETA() + ",  SEÑAL DISTINTIVA: " + enc.getCWBC_SENAL_DISTINTIVA()%></h5>


            <form action="ServlePorta.do" method="post" >

                <div class="col s12">


                    <table id="1" class="table table-bordered table-sm table-primary">
                        <thead>
                            <tr>
                                <th><!-- Switch -->
                                    <div class="switch" >
                                        <p> Aplica Muellaje a Contenedores Import</p>
                                        <label>
                                            No
                                            <input type="checkbox" name="Muellaje" id="Muellaje">
                                            <span class="lever"></span>
                                            Si
                                        </label>


                                    </div></th>
                                <th>
                                    <div class="switch">
                                        <p> Aplica Muellaje a Contenedores Export</p>
                                        <label>
                                            No
                                            <input disabled type="checkbox" name="MuellajeExport" checked="cheked" >
                                            <span class="lever On"></span>
                                            Si
                                        </label>
                                    </div>
                                </th>

                            </tr>
                        </thead>

                    </table>



                </div>

                <div class="divider"></div>

                <div class="section">
                    <div class="row">

                        <div class="input-field col s2">
                            <input placeholder="" type="number" id="CWBC_HORA" name="CWBC_HORA" class="validate" value="<%= porta.getCWBC_HORA()%>">
                            <label for="CWBC_HORA">HORAS ESTADIA</label>
                        </div>
                        Fecha ETA:
                        <%= eta + " " + eta.substring(0, 10)%>
                        <label for="CWBC_ETA">FECHA Y HORA ETA</label>
                        <div class="input-field col s2">

                            <input placeholder="" type="datetime-local" id="CWBC_ETA" name="CWBC_ETA" class="validate" value="<%= eta%>">

                        </div>

                    </div>
                </div>



                <div class="divider"></div>

                <div class="section">


                </div>

                <table id="1" class="table table-bordered table-sm ">

                    <thead thead class="blue lighten-3" >

                        <tr>

                            <th></th>

                            <th colspan="4">Via Indirecta</th>

                            <th colspan="4">Via Directa</th>

                        </tr>

                        <tr>

                            <th scope="col">Descripcion</th>

                            <th colspan="2">Grua Puerto</th>

                            <th colspan="2">Grua Buque</th>

                            <th colspan="2">Grua Puerto</th>

                            <th colspan="2">Grua Buque</th>

                        </tr>

                    </thead>

                    <tbody>

                        <tr>

                            <th>Descarga Llenos</th>

                            <td colspan="2">

                                <input  placeholder="Movimientos" name="CWSF_DESCARGA_LLENOS_GP_VI" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_DESCARGA_LLENOS_GB_VI"></label>

                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_DESCARGA_LLENOS_GB_VI" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_DESCARGA_LLENOS_GP_VI"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_DESCARGA_LLENOS_GP_VD" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_DESCARGA_LLENOS_GB_VD"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_DESCARGA_LLENOS_GB_VD" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_DESCARGA_LLENOS_GP_VD"></label>
                            </td>

                        </tr>

                        <tr>

                            <th>Descaga Vacios</th>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_DESCARGA_VACIOS_GP_VI" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="VDGPDL"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_DESCARGA_VACIOS_GB_VI" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="VDGPDL"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_DESCARGA_VACIOS_GP_VD" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="VDGPDL"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_DESCARGA_VACIOS_GB_VD" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="VDGPDL"></label>
                            </td>

                        </tr>

                        <tr>

                            <th>Carga Llenos</th>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_CARGA_LLENOS_GP_VI" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_CARGA_LLENOS_GP_VI"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_CARGA_LLENOS_GB_VI" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_CARGA_LLENOS_GB_VI"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_CARGA_LLENOS_GP_VD" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_CARGA_LLENOS_GP_VD"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_CARGA_LLENOS_GB_VD" type="number" class="validate"value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_CARGA_LLENOS_GB_VD"></label>
                            </td>

                        </tr>

                        <tr>

                            <th>Carga Vacios</th>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_CARGA_VACIOS_GP_VI" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_CARGA_VACIOS_GP_VI"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_CARGA_VACIOS_GB_VI" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_CARGA_VACIOS_GB_VI"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_CARGA_VACIOS_GP_VD" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_CARGA_VACIOS_GP_VD"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_CARGA_VACIOS_GB_VD" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_CARGA_VACIOS_GB_VD"></label>
                            </td>

                        </tr>

                        <tr>

                            <th>Vehiculos</th>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_DESCARGA_VEHICULOS_GP" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_DESCARGA_VEHICULOS_GP"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_DESCARGA_VEHICULOS_GB" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_DESCARGA_VEHICULOS_GB"></label>
                            </td>  
                        </tr>
                        <tr>

                            <th>Reestibas</th>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_REESTIBAS_GP" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_REESTIBAS_GP"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_REESTIBAS_GB" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>" >
                                <label for="CWSF_REESTIBAS_GB"></label>
                            </td>  
                        </tr>
                        <tr>

                            <th>Tapa Escotillas</th>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_TAPA_ESCOTILLAS_GP" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_TAPA_ESCOTILLAS_GP"></label>
                            </td>

                            <td colspan="2">
                                <input  placeholder="Movimientos" name="CWSF_TAPA_ESCOTILLAS_GB" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_TAPA_ESCOTILLAS_GB"></label>
                            </td>  
                        </tr>

                    <table id="1" class="table table-bordered table-sm ">
                        <thead class="blue lighten-1">

                            <tr>
                            </tr>

                            <tr>

                                <th></th>

                                <th colspan="2" align="center">Grua Puerto </th>

                                <th colspan="2" align="center">Grua Buque</th>

                            </tr>
                            <tr>

                                <th scope="col"></th>

                                <th>Llenos</th>

                                <th>Vacios</th>

                                <th>Llenos</th>

                                <th>Vacios</th>

                            </tr>

                        </thead>
                        <tr>

                            <th>Depositos Temporales</th>

                            <td>
                                <input  placeholder="Movimientos" name="CWSF_DEPOSITO_TEMP_LLENO_GP" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_DEPOSITO_TEMP_LLENO_GP"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="CWSF_DEPOSITO_TEMP_VACIO_GP" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>" >
                                <label for="CWSF_DEPOSITO_TEMP_VACIO_GP"></label>
                            </td> 
                            <td>
                                <input  placeholder="Movimientos" name="CWSF_DEPOSITO_TEMP_LLENO_GB" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_DEPOSITO_TEMP_LLENO_GB"></label>
                            </td>

                            <td>
                                <input  placeholder="Movimientos" name="CWSF_DEPOSITO_TEMP_VACIO_GB" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                <label for="CWSF_DEPOSITO_TEMP_VACIO_GB"></label>
                            </td> 
                        </tr>
                        <table id="1" class="table table-bordered table-sm ">
                            <thead class="light-blue">

                                <tr>
                                </tr>

                                <tr>

                                    <th></th>

                                    <th colspan="3" align="center">Grua Puerto </th>

                                    <th colspan="3" align="center">Grua Buque</th>

                                </tr>
                                <tr>

                                    <th scope="col"></th>
                                    <th>Llenos Secos</th>
                                    <th>Llenos Refrigerado</th>
                                    <th>Vacios</th>
                                    <th>Llenos Secos</th>
                                    <th>Llenos Refrigerado</th>
                                    <th>Vacios</th>

                                </tr>

                            </thead>
                            <tr>

                                <th>Reembarques</th>

                                <td>
                                    <input  placeholder="Movimientos" name="CWSF_REEMBARQUE_LLENO_GP" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                    <label for="CWSF_REEMBARQUE_LLENO_GP"></label>
                                </td>

                                <td>
                                    <input  placeholder="Movimientos" name="CWSF_REEMBARQUE_LLENO_RF_GP" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                    <label for="CWSF_REEMBARQUE_LLENO_RF_GP"></label>
                                </td>

                                <td>
                                    <input  placeholder="Movimientos" name="CWSF_REEMBARQUE_VACIO_GP" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                    <label for="CWSF_REEMBARQUE_VACIO_GP"></label>
                                </td> 
                                <td>
                                    <input  placeholder="Movimientos" name="CWSF_REEMBARQUE_LLENO_GB" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                    <label for="CWSF_REEMBARQUE_LLENO_GB"></label>
                                </td>
                                <td>
                                    <input  placeholder="Movimientos" name="CWSF_REEMBARQUE_LLENO_RF_GB" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                    <label for="CWSF_REEMBARQUE_LLENO_RF_GB"></label>
                                </td>

                                <td>
                                    <input  placeholder="Movimientos" name="CWSF_REEMBARQUE_VACIO_GB" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                    <label for="CWSF_REEMBARQUE_VACIO_GB"></label>
                                </td>  
                            </tr>

                            <table id="1" class="table table-bordered table-sm ">

                                <thead class="light-blue accent-4" >

                                    <tr>
                                    </tr>

                                    <tr>

                                        <th></th>

                                        <th colspan="1" align="center">Grua Puerto </th>

                                        <th colspan="1" align="center">Grua Buque</th>

                                    </tr>

                                </thead>


                                <tr >

                                    <th>Depositos Momentaneos</th>

                                    <td>
                                        <input  placeholder="Movimientos" name="CWSF_DEPOSITO_MOMENT_GP" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                        <label for="CWSF_DEPOSITO_MOMENT_GP"></label>
                                    </td>

                                    <td>
                                        <input  placeholder="Movimientos" name="CWSF_DEPOSITO_MOMENT_GB" type="number" class="validate" value="<%= porta.getCWSF_DESCARGA_LLENOS_GP_VI()%>">
                                        <label for="CWSF_DEPOSITO_MOMENT_GB"></label>
                                    </td> 

                                </tr>




                            </table>



                            <!-- valores que no se ven en pantalla
                            -->



                            <input type="hidden" id="custId" name="CWSF_COTIZACION" value="<%= Cotizacion%>">
                            <input type="hidden" id="custId" name="GRABADOR" value="<%= enc.getGRABADOR()%>">

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
