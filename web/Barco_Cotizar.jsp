<%-- 
    Document   : Barcos_Cotizar
    Created on : 22/10/2020, 01:34:29 PM
    Author     : kcordon
--%>

<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="controlador.BeanBarcos"%>
<%@page import="modelo.Barcos"%>
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

                <form action='Actualizar.jsp' method='post'>
                    <div class="row">

                        <h5 class="">Datos Buque</h5>

                        <div class="input-field col s3">

                            <input type="date" name="fecha" id="fecha">
                            <label for="fecha">Fecha ETA</label>

                        </div>


                        <div class="input-field col s3">
                            <input id="Trb" type="text"  value="<%= des.getLR()%>">
                            <label for="Trb">Trb</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="Slora" type="text"  value="<%= des.getESLORA()%>">
                            <label for="Slora">Slora</label>
                        </div>

                        
                        <div class="input-field col s3">
                            <select>
                                <option value="" disabled selected>Tipo Buque</option>
                                <option value="1">BUQUE PORTACONTANEDOR</option>
                                <option value="2">BUQUE MULTIPROPOSITOS</option>
                                <option value="3">BUQUE MULTIPROPOSITOS FRIGORIFICOS</option>
                                <option value="4">BUQUES GRANEL LIQUIDO</option>
                                <option value="5">BUQUES GRANEL SOLIDO</option>
                            </select>
                            <label>Tipo Buque</label>
                        </div>

                        <div class="input-field col s3">
                            <input id="Cambio" type="text" class="validate" value="<%= user2.getCAMBIO()%>">
                            <label for="Cambio">Cambio Dolar</label>
                        </div>

                        <div class="input-field col s3">
                            <input id="Nit" type="text" class="validate" value="<%=user.getNIT()%>">
                            <label for="Nit">Nit</label>
                        </div>

                        
                        <div class="input-field col s3">
                            <input id="Tm_Exp" type="text" class="validate">
                            <label for="Tm_Exp">Tm Exp</label>
                        </div><div class="input-field col s3">
                            <input id="Tm_Imp" type="text" class="validate">
                            <label for="Tm_Imp">Tm Imp</label>
                        </div>

                        <div class="input-field col s3">
                            <input id="Horas" type="text" class="validate">
                            <label for="Horas">Horas</label>
                        </div>
                        
                            <div class="row col s12">

                            <a class="waves-effect waves-light btn-large " href="Barco_Cotizar_Detalle.jsp">Detalle</a>


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
