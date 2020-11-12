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

        <h3 style="text-align:center;"> Barco: <%=ship.getNOMBRE_DEL_BUQUE()%> ,  <%= enc.getCWBC_COTIZACION()%> </h3>

        <form action="ServletRegistro.do" method="post" >
            <div class="row">
                <div class="col s12">

                    <div class="input-field col s3">
                        <input type="text" size="20" name="LR" value="<%=ship.getLR()%>" >
                        <label for="LR">LR</label>
                    </div>

                    <div class="input-field col s3">
                        <input type="text" size="20" name="CWBC_SENAL_DISTINTIVA" value="<%=ship.getBANDERA()%>" >
                        <label for="CWBC_SENAL_DISTINTIVA">SENAL DISTINTIVA</label>
                    </div>
                    <div class="input-field col s3">   
                        <input type="date" name="CWBC_ETA">

                    </div>

                    <div class="input-field col s3">
                        <input type="text" size="20" name="CWBC_TIPO_CAMBIO_FECHA" value="<%=cambio.getFECHA_CAMBIO()%>" >
                        <label for="CWBC_TIPO_CAMBIO_FECHA">FECHA CAMBIO</label>
                    </div>
                    <div class="input-field col s3">
                        <input type="text" size="20" name="CWBC_USUARIO_SERVICIO" value="<%= codigo%>" >
                        <label for="CWBC_USUARIO_SERVICIO">Usuario Servicio</label>
                    </div>
                    <div class="input-field col s3">
                        <input type="text" size="20" name="CWBC_NIT" value="<%= user.getNIT()%>" >
                        <label for="CWBC_NIT">NIT</label>
                    </div>

                    <div class="input-field col s3">
                        <input type="text" size="20" name="GRABADOR" value="<%= usuario%>" >
                        <label for="GRABADOR">GRABADOR</label>
                    </div>
                    <div class="input-field col s3">
                        <select name="Tipo" required >
                            <%
                                try {
                                    Conexion c = new Conexion();
                                    Connection con = c.getConexion();
                                    Statement st;
                                    st = con.createStatement();
                                    ResultSet rs = st.executeQuery("SELECT CWTO_TIPO_OPERACION, CWTO_OPERACION FROM CW_TIPO_OPERACION");
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



                    <!-- campos que no se ven en pantalla hidden -->

                    <input type="hidden" id="custId" name="CWBC_COTIZACION" value="<%= enc.getCWBC_COTIZACION()%>">


                    <div class="input-field col s3">
                        <input type="submit" value="Registrar" class="btn-large light-blue accent-4" name="enviar">

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
                            
                            
                            out.println("<td>" + lista.get(i).getCWBC_COTIZACION()+ "</td>");
                            out.println("<td>" + lista.get(i).getCWBC_ETA() + "</td>");
                            out.println("<td>" + lista.get(i).getCWBC_TIPO_CAMBIO() + "</td>");
                            out.println("<td>" + lista.get(i).getCWBC_TIPO_CAMBIO_FECHA()+ "</td>");
                            out.println("<td>" + lista.get(i).getCWBC_TIPO_OPERACION()+ "</td>");
                            
                            out.println("<td>" + "<a class='waves-effect waves-light btn-small' onclick='return myFunction()'href=" + lista.get(i).getCWBC_TIPO_OPERACION()+".jsp?Cotizacion=" +lista.get(i).getCWBC_COTIZACION()+">" + "Cotizar" + "</a>" + "</td>");
                                

                            out.println("</tr>");
                        }
                    %>  
                </tbody>
            </table>

        </div>
                </div><!-- div cointainer-->


    </body>
</html>
