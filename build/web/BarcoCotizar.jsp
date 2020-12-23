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

                window.onload = function () {
                    var fecha = new Date(); //Fecha actual
                    var mes = fecha.getMonth() + 1; //obteniendo mes
                    var dia = fecha.getDate(); //obteniendo dia
                    var ano = fecha.getFullYear(); //obteniendo año
                    if (dia < 10)
                        dia = '0' + dia; //agrega cero si el menor de 10
                    if (mes < 10)
                        mes = '0' + mes //agrega cero si el menor de 10
                    document.getElementById('fechaActual').value = ano + "-" + mes + "-" + dia;
                }


            </script>

            <script type="text/javascript">


                $(document).ready(function () {
                    $('select').formSelect();
                });


                $(document).ready(function () {
                    $('.timepicker').timepicker();
                });

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
        <h3 class="center"> Datos del Buque </h3>

            
        <div class="card-panel">
            <span class="blue-text text-darken-2">

                <h4 class="center"> Buque: <%=ship.getNOMBRE_DEL_BUQUE()%>, 
                    Numero Cotizacion <%= enc.getCWBC_COTIZACION()%>,
                    TRB: <%=ship.getTRB()%>,
                    Eslora: <%=ship.getESLORA()%>
                </h4></span>
        </div>


        <form action="ServletRegistro.do" method="post" >
            <div class="row">
                <div class="col s12">

                    <div class="input-field col s3">
                        <input disabled  type="text" size="20" name="LR" value="<%=ship.getLR()%>" >
                        <label for="LR">LR</label>
                    </div>

                    <div class="input-field col s3">
                        <input disabled  type="text" size="20" name="CWBC_SENAL_DISTINTIVA1" value="<%=ship.getBANDERA()%>" >
                        <label for="CWBC_SENAL_DISTINTIVA1">SENAL DISTINTIVA</label>
                    </div>

                    <!--
                                        <div class="input-field col s3">
                                            <input type="text" size="20" name="CWBC_TIPO_CAMBIO_FECHA" value="<%=cambio.getFECHA_CAMBIO().substring(0, 10)%>" >
                                            <label for="CWBC_TIPO_CAMBIO_FECHA">FECHA TIPO DE CAMBIO DOLAR</label>
                                        </div>-->
                    <div class="input-field col s3">
                        <input disabled type="text" size="20" name="CWBC_USUARIO_SERVICIO" value="<%= codigo%>" >
                        <label for="CWBC_USUARIO_SERVICIO1">Usuario Servicio</label>
                    </div>
                    <div class="input-field col s3">
                        <input disabled  type="text" size="20" name="CWBC_NIT1" value="<%= user.getNIT()%>" >
                        <label for="CWBC_NIT1">NIT</label>
                    </div>

                    <div class="input-field col s3">
                        <input disabled type="text" size="20" name="GRABADOR1" value="<%= usuario%>" >
                        <label for="GRABADOR1">GRABADOR</label>
                    </div>


                    <div class="input-field col s3">
                        <select name="Tipo" required >
                            <%
                                try {
                                    Conexion c = new Conexion();
                                    Connection con = c.getConexion();
                                    Statement st;
                                    st = con.createStatement();
                                    ResultSet rs = st.executeQuery("SELECT DISTINCT cwto_tipo_operacion, cwto_operacion\n"
                                            + "FROM(\n"
                                            + "select tiop.cwto_tipo_operacion cwto_tipo_operacion, tiop.cwto_operacion cwto_operacion\n"
                                            + "from PUERTO.eopt_barcos buq,\n"
                                            + "cotizador_web.cw_tipo_operacion tiop,\n"
                                            + "cotizador_web.cw_tipo_operacion_x_estru tioe\n"
                                            + "where  (tiop.cwto_tipo_operacion = tioe.cwto_tipo_operacion)\n"
                                            + "and (buq.tipo_de_barco_por_estructura = tioe.tipo_de_barco_por_estructura)\n"
                                            + "and buq.LR = '" + LR + "'\n"
                                            + "and BUQ.SENAL_DISTINTIVA = '" + ship.getBANDERA() + "'\n"
                                            + "UNION\n"
                                            + "select B.cwto_tipo_operacion cwto_tipo_operacion, B.cwto_operacion cwto_operacion\n"
                                            + "from CW_EOPT_BARCOS A,\n"
                                            + "cotizador_web.cw_tipo_operacion B,\n"
                                            + "cotizador_web.cw_tipo_operacion_x_estru C\n"
                                            + "where  (B.cwto_tipo_operacion = C.cwto_tipo_operacion)\n"
                                            + "and (A.tipo_de_barco_por_estructura = C.tipo_de_barco_por_estructura)\n"
                                            + "and A.LR = '" + LR + "'\n"
                                            + "and A.SENAL_DISTINTIVA = '" + ship.getBANDERA() + "'\n"
                                            + ")");
                                    while (rs.next()) {
                            %>
                            <option value="<%=rs.getInt("CWTO_TIPO_OPERACION")%>"><%=rs.getString("CWTO_OPERACION")%></option>
                            <%
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    out.println("Error " + e.getMessage());
                                }
                            %>
                        </select>
                        <label>TIPO</label>
                    </div>

                    <div class="input-field col s3">
                        <input type="number" size="20" name="CWBC_HORA" >
                        <label for="CWBC_HORA">HORAS ESTADIA</label>
                    </div>

                    <div class="input-field col s2">   


                        <input type="date" id="fechaActual" value=""   name="CWBC_ETA">
                        <label for="CWBC_ETA">FECHA ETA</label>


                    </div>

                    <div class="input-field col s1">   

                        <input type="text" class="timepicker" name="HORA_ETA">
                        <label for="HORA_ETA">Hora ETA</label>

                    </div>



                    <!-- campos que no se ven en pantalla hidden -->

                    <input type="hidden"  name="CWBC_COTIZACION" value="<%= enc.getCWBC_COTIZACION()%>">
                    <input type="hidden" size="20" name="CWBC_TIPO_CAMBIO_FECHA" value="<%=cambio.getFECHA_CAMBIO().substring(0, 10)%>" >
                    <input type="hidden" size="20" name="LR" value="<%=ship.getLR()%>" >
                    <input type="hidden" size="20" name="CWBC_SENAL_DISTINTIVA" value="<%=ship.getBANDERA()%>" >
                    <input type="hidden" size="20" name="CWBC_USUARIO_SERVICIO" value="<%= codigo%>" >
                    <input type="hidden" size="20" name="CWBC_NIT" value="<%= user.getNIT()%>" >
                    <input type="hidden" size="20" name="GRABADOR" value="<%= usuario%>" >
                    <input type="hidden" size="20" name="TBR" value="<%=ship.getTRB()%>" >
                    <input type="hidden" size="20" name="SLORA" value="<%=ship.getESLORA()%>" >






                    <div class="input-field col s3">
                        <input type="submit" value="Nueva Cotizacion" class="btn-large light-blue accent-4" name="enviar">

                    </div>
                </div>


            </div>
        </form>
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
                                out.println("<td>" + "<a class='waves-effect waves-light btn-small' onclick='return myFunction()'href=" + lista.get(i).getCWBC_TIPO_OPERACION() + ".jsp?Cotizacion=" + lista.get(i).getCWBC_COTIZACION() + "&Tipo=" + lista.get(i).getCWBC_TIPO_OPERACION() + ">" + "Cotizar" + "</a>" + "</td>");
                                out.println("<td>" + "<a class='waves-effect waves-light btn-small' onclick='return validar()' href=Eliminar.jsp?id=" + lista.get(i).getCWBC_COTIZACION() + ">" + "<i class='material-icons'>delete_forever</i>" + "Eliminar" + "</a>" + "</td>");

                                out.println("</tr>");
                            }
                        %>  
                    </tbody>
                </table>

            </div>
        </div><!-- div cointainer-->


    </body>
</html>
