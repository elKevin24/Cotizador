<%-- 
    Document   : ACTUALIZAR_BUQUE_PORTACONTENEDOR
    Created on : 7/01/2021, 09:23:36 AM
    Author     : kcordon
--%>

<%@page import="controlador.BeanLiquido"%>
<%@page import="modelo.Detalle_L"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <%

            String res = null;
            String detalle = null;
            boolean Eliminar;

            String CWSF_COTIZACION = request.getParameter("CWSL_COTIZACION");
            String CWBC_HORA = request.getParameter("CWBC_HORA");
            String CWBC_ETA = request.getParameter("CWBC_ETA");

            CWBC_ETA = CWBC_ETA.replace('T', ' ');
            CWBC_ETA = CWBC_ETA + ":00";

            BeanLiquido user = new BeanLiquido();
            user.setCWSL_COTIZACION(CWSF_COTIZACION);
            user.setCWBC_HORA(CWBC_HORA);
            user.setCWBC_ETA(CWBC_ETA);

            user.setCWSL_DESC_ACEITE_GRASA_QUIMI(request.getParameter("CWSL_DESC_ACEITE_GRASA_QUIMI"));
            user.setCWSL_CARGA_ACEITE_GRASA_QUIMI(request.getParameter("CWSL_CARGA_ACEITE_GRASA_QUIMI"));
            user.setCWSL_DESC_COMBUSTIBLES_DERIV(request.getParameter("CWSL_DESC_COMBUSTIBLES_DERIV"));
            user.setCWSL_CARGA_COMBUSTIBLES_DERIV(request.getParameter("CWSL_CARGA_COMBUSTIBLES_DERIV"));

            detalle = Detalle_L.ActualizarDetalle(user);
            res = Detalle_L.Actualizar(user);
            Eliminar = Detalle_L.EliminarDetalle(CWSF_COTIZACION);
            if (res.equalsIgnoreCase("bien")) {

                response.sendRedirect("GuardadoDetalle.jsp?Cotizacion=" + CWSF_COTIZACION + "");

            } else {
                out.println(res);
            }


        %>
    </body>
</html>
