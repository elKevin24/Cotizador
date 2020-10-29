<%-- 
    Document   : DetalleCotizacion
    Created on : 27/10/2020, 09:44:57 AM
    Author     : kcordon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        
        <jsp:include page="menu.jsp" flush="true"></jsp:include>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <div class="container">
            <h3 class="aling center">Cotizacion en Linea</h3>

            <div class="col s12">

                
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
                <a class="waves-effect waves-light btn-large blue accent-4" onclick="location.href='detallepagar.html'">Ir a Detalle</a>
            



           






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
