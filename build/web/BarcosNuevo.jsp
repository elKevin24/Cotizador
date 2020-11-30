<%-- 
    Document   : BarcosNuevo
    Created on : 24/11/2020, 12:25:30 PM
    Author     : kcordon
--%>

<%@page import="controlador.BeanBarcosNew"%>
<%@page import="modelo.BarcosNew"%>
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
            
            
             <!-- Compiled and minified JavaScript -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.js"></script>
            <script>


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


        %>

        <h3 style="text-align:center;"> Usuario: <%= user.getNOMBRE()%>  </h3>

        <div class="divider"></div>

        <div class="section">

            <h3 align='center'> Ingresar datos para nuevo Barco </h3>

        </div>
        
         <div class="divider"></div>
        <div class="col s12 container">


            <form action="ServletRegistroNew.do" method="post" >
                <div class="row">


                    <div class="input-field col s3">
                        <input type="number" size="20" name="LR" value="" >
                        <label for="LR">LR</label>
                    </div>

                    <div class="input-field col s3">
                        <input type="text" size="20" name="SENAL_DISTINTIVA" value="" >
                        <label for="SENAL_DISTINTIVA">SENAL DISTINTIVA</label>
                    </div>

                    
                    <div class="input-field col s3">
                        <input type="text" size="20" name="NOMBRE_DEL_BUQUE" value="" >
                        <label for="NOMBRE_DEL_BUQUE">NOMBRE DEL BUQUE</label>
                    </div>
                    

                    <div class="input-field col s3">
                        <input type="number" size="20" name="TRB">
                        <label for="TRB">TRB</label>
                    </div>

                    <div class="input-field col s3">
                        <input type="number" size="20" name="TRN">
                        <label for="TRN">TRN</label>
                    </div>

                    <div class="input-field col s3">
                        <input type="number" size="20" name="TPM">
                        <label for="TPM">TPM</label>
                    </div>
                    <div class="input-field col s3">
                        <input type="number" size="20" name="CALADO">
                        <label for="CALADO">CALADO</label>
                    </div>
                    <div class="input-field col s3">
                        <input type="number" size="20" name="ESLORA">
                        <label for="ESLORA">ESLORA</label>
                    </div>
                    <div class="input-field col s3">
                        <input type="number" size="20" name="MANGA">
                        <label for="MANGA">MANGA</label>
                    </div>



                    <div class="input-field col s3">
                        <select name="TIPO_DE_BARCO_POR_ESTRUCTURA" required >
                            <%
                                try {
                                    Conexion c = new Conexion();
                                    Connection con = c.getConexion();
                                    Statement st;
                                    st = con.createStatement();
                                    ResultSet rs = st.executeQuery("select * from\n"
                                            + "PUERTO.eopt_tipos_barc_estru\n"
                                            + "where tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)");
                                    while (rs.next()) {
                            %>
                            <option value="<%=rs.getInt("TIPO_DE_BARCO_POR_ESTRUCTURA")%>"><%=rs.getString("DESCRIPCION")%></option>
                            <%
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    out.println("Error " + e.getMessage());
                                }
                            %>
                        </select>
                        <label>TIPO DE BARCO POR ESTRUCTURA</label>
                    </div>
                        
                        
                         <div class="input-field col s3">
                        <select name="BANDERA" required >
                            <%
                                try {
                                    Conexion c = new Conexion();
                                    Connection con = c.getConexion();
                                    Statement st;
                                    st = con.createStatement();
                                    ResultSet rs = st.executeQuery("select * from PUERTO.EOPT_PAISES");
                                    while (rs.next()) {
                            %>
                            <option value="<%=rs.getString("PAIS")%>"><%=rs.getString("NOMBRE")%></option>
                            <%
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    out.println("Error " + e.getMessage());
                                }
                            %>
                        </select>
                        <label>BANDERA</label>
                    </div>





                    <!-- campos que no se ven en pantalla hidden -->

                    <input type="hidden"  name="USUARIO_DE_SERVICIO" value="<%= user.getUSUARIO_DE_SERVICIO()%>">
                    <input type="hidden"  name="BITA_USUARIO_INSERTA" value="<%= user.getUSUARIO_INOW() %>">



                </div>
                <div class="input-field col s3">
                    <input type="submit" value="Registrar" class="btn-large light-blue accent-4" name="enviar">

                </div>


        </div>
    </form>
</div>


<div class="container">
    <div class="divider"></div>

        <div class="section">

            <h3 align='center'> Barcos Creados por Usuario </h3>

        </div>
            <div class="col s12">

                <table id="table_id" border="1"   class="highlight responsive-table striped " >
                    <thead>
                        <tr>


                            <th>LR</th>
                            
                            <th>SENAL DISTINTIVA</th>
                            <th>TIPO DE BARCO POR ESTRUCTURA</th>
                            <th>NOMBRE DEL BUQUE</th>
                            <th>BANDERA</th>


                        </tr>
                    </thead>
                    <tbody>
                        <%

                            LinkedList<BeanBarcosNew> lista = BarcosNew.Barcos();

                            for (int i = 0; i < lista.size(); i++) {

                                out.println("<tr>");

                                out.println("<td>" + lista.get(i).getLR() + "</td>");
                                out.println("<td>" + lista.get(i).getSENAL_DISTINTIVA() + "</td>");
                                out.println("<td>" + lista.get(i).getTIPO_DE_BARCO_POR_ESTRUCTURA() + "</td>");
                                out.println("<td>" + lista.get(i).getNOMBRE_DEL_BUQUE() + "</td>");
                                out.println("<td>" + lista.get(i).getBANDERA() + "</td>");
                                
                                out.println("</tr>");
                            }
                        %>  
                    </tbody>
                </table>

            </div>
                    
                    
                    
        </div><!-- div cointainer-->
        
        <script type="text/javascript">

            $(document).ready(function () {
                $('#table_id').DataTable();
            });

        </script>
        


</body>
</html>