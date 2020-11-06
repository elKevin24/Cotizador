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

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <%
            String Cotizacion = request.getParameter("Cotizacion");
            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.CotizacionGeneral(Cotizacion);

        %>


        <jsp:include page="menu.jsp" flush="true"></jsp:include>

        </head>
        <body>
            <div class="row">
                <div class="col s1 push-s1">
                    <a  href="index.jsp" class="btn-floating pulse" ><i class="material-icons">arrow_back</i></a>
                </div>
            </div>

            <div class="container">
                <h5> Cotizacion LR: <%= enc.getCWBC_LR() + "  ETA: " + enc.getCWBC_ETA() + "  SEÑAL DISTINTIVA: " + enc.getCWBC_SENAL_DISTINTIVA() + " Cotizacion: "+Cotizacion+"" %></h5>
            
            <div class="divider"></div>
  <div class="section">
    <!-- Switch -->
  <div class="switch">
    <label>
      NO
      <input type="checkbox">
      <span class="lever"></span>
      Si
    </label>
  </div>
  </div>
            
            
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
