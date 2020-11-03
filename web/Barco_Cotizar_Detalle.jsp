<%-- 
    Document   : DetalleCotizacion
    Created on : 27/10/2020, 09:44:57 AM
    Author     : kcordon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controlador.BeanTipoBuque"%>
<%@page import="modelo.Tipo"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>

        <jsp:include page="menu.jsp" flush="true"></jsp:include>
        <%
           
            String FECHA = request.getParameter("FECHA");
            String TRB = request.getParameter("TRB");
            String Slora = request.getParameter("Slora");
            
            String Cambio = request.getParameter("Cambio");
            String Nit = request.getParameter("Nit");
            String Horas = request.getParameter("Horas");
            
            String Tipo2 = request.getParameter("Tipo");
            


        %>
        
        <script>
            
   
    if("<%= Tipo2 %>"==="BUQUE PORTACONTANEDOR"){
         alert("<%= Tipo2 %>");
         window.window.location.href = "Barco_Cotizar_1.jsp"
    }
            
            </script>

            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
        <body>
        
        <div class="container">
            <h3 class="aling center">Cotizacion en Linea</h3>

            <div class="divider"></div>
            <div class="section">
                <h3>Datos Generales</h3>
                <h5>Fecha: <%= FECHA%>, TRB: <%= TRB%>, Slora: <%= Slora%>, Tipo: <%= Tipo2 %>, </h5> <h5>Cambio: <%= Cambio%>, Nit: <%= Nit%>, Horas: <%= Horas%> </h5>
            </div>
            <div class="divider"></div>



            <div class="row">

                <h5 class="">Detalles de Servicios Solicitados</h5>



                <div class="input-field col s2">
                    <select>
                        <option value="" disabled selected>Grupo</option>
                        <option value="1">Option 1</option>
                        <option value="2">Option 2</option>
                        <option value="3">Option 3</option>
                    </select>
                    <label>Grupo</label>
                </div>
                <div class="input-field col s2">
                    <select>
                        <option value="" disabled selected>Tipo</option>
                        <option value="1">Option 1</option>
                        <option value="2">Option 2</option>
                        <option value="3">Option 3</option>
                    </select>
                    <label>Tipo</label>
                </div>

                <div class="input-field col s2">
                    <select>
                        <option value="" disabled selected>Tarifas</option>
                        <option value="1">Option 1</option>
                        <option value="2">Option 2</option>
                        <option value="3">Option 3</option>
                    </select>
                    <label>Tarifas</label>
                </div>

                <div class="input-field col s2">
                    <input id="Medidas" type="text" class="validate">
                    <label for="Medidas">Medidas</label>
                </div>

                <div class="input-field col s2">
                    <input id="Cantidad" type="text" class="validate" >
                    <label for="Cantidad">Cantidad</label>
                </div>







            </div>   
            <a class="waves-effect waves-light btn-large blue accent-4" onclick="location.href = 'detallepagar.html'">Ir a Detalle</a>











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
