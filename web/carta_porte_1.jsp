<%-- 
    Document   : carta_porte
    Created on : 11/05/2021, 11:18:28 AM
    Author     : kcordon
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexion"%>
<%@page import="modelo.Conexion"%>
<%@page import="modelo.Carta"%>
<%@page import="controlador.BeanCarta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>





        <script>
            var a = 0;
            function agregarFila() {
                a++;
                document.getElementById("tablaprueba").insertRow(-1).innerHTML = '<td><input type="text" name="Nombre[' + a + ']"/></td><td><input type="text" name="Modalidad[' + a + ']"/></td><td><input type="text" name="Vacio[' + a + ']"/></td>\n\
        <td><input type="text" name="Codigo_Region[' + a + ']"/></td><td><input type="text" name="Numero_Orden[' + a + ']"/></td>\n\
<td><input type="text" name="Observaciones[' + a + ']"/></td>';
                document.getElementById("cont").value = a;
            }

            function eliminarFila() {
                var table = document.getElementById("tablaprueba");
                var rowCount = table.rows.length;
                //console.log(rowCount);

                if (rowCount <= 1)
                    alert('No se puede eliminar el encabezado');
                else
                    table.deleteRow(rowCount - 1);
            }

        </script>

        <%

            BeanCarta a = new BeanCarta();
            a = Carta.Consultar();

        %>
        <title> Carta de Porte</title>
        <jsp:include page="menu.jsp" flush="true"></jsp:include>

            <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
            <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
            <style>
                body {background-color: #eceff1;}

            </style>
        </head>
        <body>
            <div class="container">

                <div class="card ">
                    
                    
                    
                    
                    
                    <div class="col s12 blue lighten-4">
                        <div class="row">
                            <br>
                    
                    <span class="card-title"><h4 class="center">Ingrese Datos Carta de Porte</h4></span>
                    
                    </div>
                        </div>
                        

                    <form action="ServletCarta" method="post">
                        <div class="row">
                            <div class="col s12">
                                <div class="row">

                                    <div class="col s12">
                                        <div class="col s3">
                                            <span><h5 class="center">Numero ATC</h5></span>

                                            <div class="input-field col s12">
                                                <input id="RW_ATC" type="text" class="validate" name="RW_ATC" required maxlength="20">
                                                <label for="RW_ATC">Numero ATC</label>
                                            </div>
                                        </div>

                                        <div class="col s9">
                                            <span><h5 class="center">Datos Buque</h5></span>
                                            
                                            <div class="input-field col s4">
                                                <input id="Nombre_Buque" type="text" class="validate" name="RW_NOMBRE_BUQUE" required maxlength="100">
                                                <label for="Nombre_Buque">Nombre Buque</label>
                                            </div>
                                            <div class="input-field col s4">
                                                <input id="Viaje" type="text" class="validate" name="RW_VIAJE_BARCO" required maxlength="25">
                                                <label for="Viaje">Viaje</label>
                                            </div>
                                            <!-- No podrá ver este texto. 
                                                                                    <div class="input-field col s4">
                                                                                        <input id="Fecha" type="text" class="datepicker" name="RW_FECHA_VIAJE_BARCO" required>
                                            
                                                                                        <label for="Fecha">Fecha</label>
                                                                                    </div>
                                            -->

                                            <div class="input-field col s4">

                                                <input type="datetime-local" placeholder="." id="RW_FECHA_VIAJE_BARCO" name="RW_FECHA_VIAJE_BARCO" class="validate" >

                                            </div>

                                        </div>

                                    </div>


                                </div> 
                            </div> 

                            <span><h5 class="center">Datos Contenedor</h5></span>
                            <div class="row blue lighten-4">
                                <div class="col s12 blue lighten-4">

                                    <div class="input-field col s1">
                                        <input id="Prefijo" type="text" class="validate" name="RW_PREFIJO_CONT" required maxlength="4">
                                        <label for="Prefijo">Prefijo</label>
                                    </div>
                                    <div class="input-field col s2">
                                        <input id="Numero_Contenedor" type="number" class="validate" name="RW_IDENTIFICACION_CONT" required maxlength="12">
                                        <label for="Numero_Contenedor">Numero Contenedor</label>
                                    </div>
                                    <div class="input-field col s3">
                                        <input id="Peso" type="number" class="validate" name="RW_PESO_CONTENEDOR" required maxlength="10">
                                        <label for="Peso">Peso</label>
                                    </div>
                                    <div class="input-field col s3 blue lighten-4">


                                        <select class="js-example-basic-single" name="RW_PAIS_ORIGEN" required>
                                            <option value="" disabled selected>PAIS ORIGEN</option>
                                        <%                                            try {
                                                Conexion c = new Conexion();
                                                Connection con = c.getConexion();
                                                Statement st;
                                                st = con.createStatement();
                                                ResultSet rs = st.executeQuery("select pais, nombre from PUERTO.eopt_paises");
                                                while (rs.next()) {
                                        %>

                                        <option value="<%=rs.getString("pais")%>"><%=rs.getString("nombre")%></option>
                                        <%
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                out.println("Error " + e.getMessage());
                                            }
                                        %>
                                    </select>

                                </div>
                                <div class="input-field col s3 blue lighten-4">

                                    <select class="js-example-basic-single" name="RW_PAIS_DESTINO" required>
                                        <option value="" disabled selected>PAIS DESTINO</option>
                                        <%
                                            try {
                                                Conexion c = new Conexion();
                                                Connection con = c.getConexion();
                                                Statement st;
                                                st = con.createStatement();
                                                ResultSet rs = st.executeQuery("select pais, nombre from PUERTO.eopt_paises");
                                                while (rs.next()) {
                                        %>

                                        <option value="<%=rs.getString("pais")%>"><%=rs.getString("nombre")%></option>
                                        <%
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                out.println("Error " + e.getMessage());
                                            }
                                        %>
                                    </select>

                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col s12 blue lighten-4">
                                <div class="input-field col s3">
                                    <select class="browser-default" name="RW_C_O_F" >
                                        <option value="" disabled selected>Contenedor/Furgon</option>
                                        <option value="1">Contenedor</option>
                                        <option value="2">Furgon</option>

                                    </select>

                                </div>

                                <div class="input-field col s3">
                                    <select class="browser-default" name="RW_MEDIDA" >
                                        <option value="" disabled selected>Medida</option>
                                        <option value="20">20</option>
                                        <option value="40">40</option>
                                        <option value="45">45</option>
                                        <option value="48">48</option>

                                    </select>

                                </div>

                                <div class="input-field col s3">
                                    <select class="browser-default" name="RW_ESTADO_CONT" >
                                        <option value="" disabled selected>Lleno/Vacio</option>
                                        <option value="1">Lleno</option>
                                        <option value="2">Vacio</option>


                                    </select>

                                </div>

                                <div class="input-field col s3">
                                    <select class="browser-default" name="RW_REFER_SECO_OPERANDO">
                                        <option value="" disabled selected>Tipo Contenedor</option>
                                        <option value="1">Seco</option>
                                        <option value="2">Rifer Encendido</option>
                                        <option value="3">Rifer Apagado</option>


                                    </select>

                                </div>

                            </div>
                        </div>



                        <div class="row">
                            <div class="input-field col s12">
                                <textarea id="textarea2" class="materialize-textarea" data-length="1200" name="RW_DICE_CONTENER" required maxlength="1000"></textarea>
                                <label for="textarea2">Dice Contener</label>
                            </div>

                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <textarea id="textarea2" class="materialize-textarea" data-length="120" name="RW_DICE_OBSERVACIONES" required maxlength="1000"></textarea>
                                <label for="textarea2">Observaciones</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12">

                                <span><h5 class="center ">Datos de Transportista</h5></span>
                                <div class="input-field col s3">
                                    <input id="Nombre_Transportista" type="text" class="validate" name="RW_NOMBRE_TRANSPORTISTA" required maxlength="100">
                                    <label for="Nombre_Transportista">Nombre Transportista</label>
                                </div>
                                <div class="input-field col s3">
                                    <input id="Placa" type="text" class="validate" name="RW_PLACA_CABEZAL" required maxlength="12">
                                    <label for="Placa">Placa Cabezal</label>
                                </div>



                                <div class="input-field col s2">
                                    <input id="Prefijo_Chasis" type="text" class="validate" name="RW_PREFIJO_CHASIS" required maxlength="6">
                                    <label for="Prefijo_Chasis">Prefijo Chasis</label>
                                </div>
                                <div class="input-field col s2">
                                    <input id="Numero_Chasis" type="text" class="validate" name="RW_IDENTIFICACION_CHASIS" required maxlength="12">
                                    <label for="Numero_Chasis">Numero Chasis</label>
                                </div>
                                <div class="input-field col s2">
                                    <select class="js-example-basic-single" name="RW_PAIS_PLACA" required>
                                        <option value="" disabled selected>Pais Placa</option>
                                        <%                                                try {
                                                Conexion c = new Conexion();
                                                Connection con = c.getConexion();
                                                Statement st;
                                                st = con.createStatement();
                                                ResultSet rs = st.executeQuery("select pais, nombre from PUERTO.eopt_paises");
                                                while (rs.next()) {
                                        %>

                                        <option value="<%=rs.getString("pais")%>"><%=rs.getString("nombre")%></option>
                                        <%
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                out.println("Error " + e.getMessage());
                                            }
                                        %>

                                    </select>

                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col s12">
                                <span><h5 class="center">Datos Piloto</h5></span>
                                <div class="input-field col s3 ">
                                    <input id="Nombres" type="text" class="validate" name="RW_NOMBRE_PILOTO" required maxlength="100">
                                    <label for="Nombres">Nombres</label>
                                </div>
                                <div class="input-field col s3">
                                    <input id="Apellidos" type="text" class="validate" name="RW_APELLIDO_PILOTO" required maxlength="100">
                                    <label for="Apellidos">Apellidos</label>
                                </div>
                                <div class="input-field col s3">
                                    <input id="Licencia" type="text" class="validate" name="RW_LICENCIA_PILOTO" required maxlength="100">
                                    <label for="Licencia">Licencia</label>
                                </div>
                                <div class="input-field col s3">

                                    <select class="js-example-basic-single" name="RW_PAIS_LICENCIA_PILOTO" required>
                                        <option value="" disabled selected>PAIS LICENCIA PILOTO</option>
                                        <%
                                            try {
                                                Conexion c = new Conexion();
                                                Connection con = c.getConexion();
                                                Statement st;
                                                st = con.createStatement();
                                                ResultSet rs = st.executeQuery("select pais, nombre from PUERTO.eopt_paises");
                                                while (rs.next()) {
                                        %>

                                        <option value="<%=rs.getString("pais")%>"><%=rs.getString("nombre")%></option>
                                        <%
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                out.println("Error " + e.getMessage());
                                            }
                                        %>
                                    </select>

                                </div>
                            </div>

                        </div>


                        <table border="1" class="table" id="tablaprueba">
                            <thead class="thead-dark">
                                <tr>
                                    <th colspan="6" class="center">Declaracion Aduanera</th>
                                    
                                </tr>
                            </thead>
                            <thead class="thead-dark">
                                <tr>
                                    <th>Numero</th>
                                    <th>Modalidad</th>
                                    <th>Observaciones</th>
                                    <th>Codigo Region</th>
                                    <th>Numero de Orden</th>                            
                                    <th>Observaciones</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>

                        <div class="form-group">
                            <button type="button" class="waves-effect waves-light btn-small green darken-4" onclick="agregarFila()">Agregar Fila</button>
                            <button type="button" class="waves-effect waves-light btn-small red darken-4" onclick="eliminarFila()">Eliminar Fila</button>
                        </div>



                        <input type="hidden" value ="" id="cont" name="cont">
                        <input type="hidden"  name="RW_ID_RECEPCION" value="<%=a.getRW_ID_RECEPCION()%>" >
                        <input type="hidden"  name="USUARIO_DE_SERVICIO" value="19165011" required>

                        <div class="input-field col s offset-s9">
                            <input type="submit" value="Ingresar" class="btn-large light-blue accent-4" name="enviar"> 

                        </div>
                    </div>
                        
                       


                </form>

            </div>
        </div>

        <script>
            $(document).ready(function () {
                $('.js-example-basic-single').select2();
            });

        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    </body>
</html>
