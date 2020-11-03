<%-- 
    Document   : Barcos_Cotizar
    Created on : 22/10/2020, 01:34:29 PM
    Author     : kcordon
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Barcos"%>
<%@page import="modelo.Conexion"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="controlador.BeanBarcos"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="menu.jsp" flush="true"></jsp:include>
        </head>
        <body>
        <%
            String LR = request.getParameter("LR");
            BeanBarcos des = new BeanBarcos();
            des = Barcos.ObtenerBarcos(LR);

            String usuario = String.valueOf(session.getAttribute("usuario"));
            BeanUsuarios user = new BeanUsuarios();
            user = Usuario.ObtenerUsuario(usuario);

            BeanUsuarios user2 = new BeanUsuarios();
            user2 = Usuario.ObtenerCambioDolar();
        %>
        <div class="container">
            <h3 class="aling center">Cotizacion en Linea "<%= des.getNOMBRE_DEL_BUQUE()%>" </h3>
            <div class="col s12">
                <form action='ServletRegistro.do' method='post'>
                    <div class="row">
                        <h5 class="">Datos Buque</h5>
                        <div class="input-field col s3">
                            <input type="date" name="FECHA" id="fecha" required>
                            <label for="fecha">Fecha ETA</label>
                        </div>
                        
                        
                            <div class="input-field col s3">
                            <input type="text" name="SENAL_DISTINTIVA" value="<%= des.getBANDERA()%>">
                            <label for="SENAL_DISTINTIVA">SENAL DISTINTIVA</label>
                        </div>
                            
                            
                            
                            <div class="input-field col s3">
                            <input type="text" name="BUQUE_VIAJE" >
                            <label for="BUQUE_VIAJE">BUQUE VIAJE</label>
                        </div>

                        <div class="input-field col s3">
                            <select name="Tipo" required >
                                <%
                                    try {
                                        Conexion c = new Conexion();
                                        Connection con = c.getConexion();
                                        Statement st;
                                        st = con.createStatement();
                                        ResultSet rs = st.executeQuery("SELECT CWTO_TIPO_OPERACION, CWTO_OPERACION FROM  COTIZADOR_WEB.cw_tipo_operacion Order by 1");
                                        while (rs.next()) {
                                %>
                                <option value="<%=rs.getString("CWTO_TIPO_OPERACION")%>"><%=rs.getString("CWTO_OPERACION")%></option>
                                <%
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        out.println("Error " + e.getMessage());
                                    }

                                %>
                            </select>
                            <label>Escoger Tipo de Proyecto</label>
                        </div>

                        <div class="input-field col s3">
                            <input id="Cambio" type="text" name="Cambio" required value="<%= user2.getCAMBIO()%>">
                            <label for="Cambio">Cambio Dolar</label>
                        </div>
                           
                                           
                        
                        <div class="input-field col s3">
                            <input id="Nit" type="text"  name="Nit" required value="<%=user.getNIT()%>">
                            <label for="Nit">Nit</label>
                        </div>

                        <div class="input-field col s3">
                            <input name="Horas" type="text" required>
                            <label for="Horas">Horas</label>
                        </div>
                            
                            <input name="LR" type="hidden" value="<%= LR%>">
                            <input name="USUARIO_SERVICIO" type="hidden" value="<%= user.getUSUARIO_DE_SERVICIO() %>">
                            <input name="GRABADOR" type="hidden" value="<%= user.getUSUARIO_INOW()%>">
                            <input name="FECHA_CAMBIO" type="hidden" value="<%= user2.getFECHA_CAMBIO()%>">
  

                        <div class="row col s12">

                            <input type='submit' value='Registrar' class='btn-large'>

                        </div>

                    </div>   

                </form>

            </div>

        </div>

        <script type="text/javascript">
            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('select');
                var instances = M.FormSelect.init(elems, instances);
            });
        </script>
    </body>
</html>
