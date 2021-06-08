<%-- 
    Document   : newjsp
    Created on : 4/06/2021, 06:36:38 PM
    Author     : kcordon
--%>

<%@page import="modelo.TrazabilidadContenedores"%>
<%@page import="controlador.Trazabilidad_Contenedores"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>



        </script>
    </head>
    <body>

        <%

            String viaje = String.valueOf(session.getAttribute("viaje_barco"));

            LinkedList<Trazabilidad_Contenedores> lista = TrazabilidadContenedores.consultarCont(viaje);

            for (int i = 0; i < lista.size(); i++) {
               


        %>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>


        <script>

            var settings = {
                "url": "http://bkedifact:7001/sat/ConsultaRetLibConteWeb.php?p_contenedor=<%=lista.get(i).getC1()%>&p_viajeSistema=<%=viaje%>",
                "method": "GET",
                "timeout": 0,
            };

            $.ajax(settings).done(function (response) {
                console.log(response + "" +<%=i%>);

            });


        </script>

        <%
            }
        %>

    </body>
</html>
