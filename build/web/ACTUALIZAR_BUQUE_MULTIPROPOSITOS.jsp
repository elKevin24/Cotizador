<%-- 
    Document   : ACTUALIZAR_BUQUE_PORTACONTENEDOR
    Created on : 7/01/2021, 09:23:36 AM
    Author     : kcordon
--%>

<%@page import="controlador.BeanMulti"%>
<%@page import="modelo.Detalle_M"%>

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

            String MuellajeImport = request.getParameter("Muellaje");
            if (MuellajeImport != null) {
                MuellajeImport = "S";
            } else {
                MuellajeImport = "N";

            }
            String CWSF_COTIZACION = request.getParameter("CWSF_COTIZACION");
            String CWBC_HORA = request.getParameter("CWBC_HORA");
            String CWBC_ETA = request.getParameter("CWBC_ETA");

            CWBC_ETA = CWBC_ETA.replace('T', ' ');
            CWBC_ETA = CWBC_ETA + ":00";
            String CWSF_DESCARGA_LLENOS_GP_VI = request.getParameter("CWSF_DESCARGA_LLENOS_GP_VI");
            String CWSF_DESCARGA_LLENOS_GB_VI = request.getParameter("CWSF_DESCARGA_LLENOS_GB_VI");
            String CWSF_DESCARGA_LLENOS_GP_VD = request.getParameter("CWSF_DESCARGA_LLENOS_GP_VD");
            String CWSF_DESCARGA_LLENOS_GB_VD = request.getParameter("CWSF_DESCARGA_LLENOS_GB_VD");

            String CWSF_DESCARGA_VACIOS_GP_VI = request.getParameter("CWSF_DESCARGA_VACIOS_GP_VI");
            String CWSF_DESCARGA_VACIOS_GB_VI = request.getParameter("CWSF_DESCARGA_VACIOS_GB_VI");
            String CWSF_DESCARGA_VACIOS_GP_VD = request.getParameter("CWSF_DESCARGA_VACIOS_GP_VD");
            String CWSF_DESCARGA_VACIOS_GB_VD = request.getParameter("CWSF_DESCARGA_VACIOS_GB_VD");

            String CWSF_CARGA_LLENOS_GP_VI = request.getParameter("CWSF_CARGA_LLENOS_GP_VI");
            String CWSF_CARGA_LLENOS_GB_VI = request.getParameter("CWSF_CARGA_LLENOS_GB_VI");
            String CWSF_CARGA_LLENOS_GP_VD = request.getParameter("CWSF_CARGA_LLENOS_GP_VD");
            String CWSF_CARGA_LLENOS_GB_VD = request.getParameter("CWSF_CARGA_LLENOS_GB_VD");

            String CWSF_CARGA_VACIOS_GP_VI = request.getParameter("CWSF_CARGA_VACIOS_GP_VI");
            String CWSF_CARGA_VACIOS_GB_VI = request.getParameter("CWSF_CARGA_VACIOS_GB_VI");
            String CWSF_CARGA_VACIOS_GP_VD = request.getParameter("CWSF_CARGA_VACIOS_GP_VD");
            String CWSF_CARGA_VACIOS_GB_VD = request.getParameter("CWSF_CARGA_VACIOS_GB_VD");

            String CWSF_DEPOSITO_MOMENT_GP = request.getParameter("CWSF_DEPOSITO_MOMENT_GP");
            String CWSF_DEPOSITO_MOMENT_GB = request.getParameter("CWSF_DEPOSITO_MOMENT_GB");

            String CWSF_DESCARGA_VEHICULOS_GP = request.getParameter("CWSF_DESCARGA_VEHICULOS_GP");
            String CWSF_DESCARGA_VEHICULOS_GB = request.getParameter("CWSF_DESCARGA_VEHICULOS_GB");

            String CWSF_REESTIBAS_GP = request.getParameter("CWSF_REESTIBAS_GP");
            String CWSF_REESTIBAS_GB = request.getParameter("CWSF_REESTIBAS_GB");

            String CWSF_TAPA_ESCOTILLAS_GP = request.getParameter("CWSF_TAPA_ESCOTILLAS_GP");
            String CWSF_TAPA_ESCOTILLAS_GB = request.getParameter("CWSF_TAPA_ESCOTILLAS_GB");

            String CWSF_DEPOSITO_TEMP_LLENO_GP = request.getParameter("CWSF_DEPOSITO_TEMP_LLENO_GP");
            String CWSF_DEPOSITO_TEMP_VACIO_GP = request.getParameter("CWSF_DEPOSITO_TEMP_VACIO_GP");
            String CWSF_DEPOSITO_TEMP_LLENO_GB = request.getParameter("CWSF_DEPOSITO_TEMP_LLENO_GB");
            String CWSF_DEPOSITO_TEMP_VACIO_GB = request.getParameter("CWSF_DEPOSITO_TEMP_VACIO_GB");

            String CWSF_REEMBARQUE_LLENO_GP = request.getParameter("CWSF_REEMBARQUE_LLENO_GP");
            String CWSF_REEMBARQUE_LLENO_RF_GP = request.getParameter("CWSF_REEMBARQUE_LLENO_RF_GP");
            String CWSF_REEMBARQUE_VACIO_GP = request.getParameter("CWSF_REEMBARQUE_VACIO_GP");
            String CWSF_REEMBARQUE_LLENO_GB = request.getParameter("CWSF_REEMBARQUE_LLENO_GB");
            String CWSF_REEMBARQUE_LLENO_RF_GB = request.getParameter("CWSF_REEMBARQUE_LLENO_RF_GB");
            String CWSF_REEMBARQUE_VACIO_GB = request.getParameter("CWSF_REEMBARQUE_VACIO_GB");

            String CWSF_DESCARGA_MERCA_GB_VD = request.getParameter("CWSF_DESCARGA_MERCA_GB_VD");
            
            String CWSF_DESCARGA_MERCA_GP_VD = request.getParameter("CWSF_DESCARGA_MERCA_GP_VD");
            String CWSF_DESCARGA_MERCA_GB_VI = request.getParameter("CWSF_DESCARGA_MERCA_GB_VI");
            
            String CWSF_DESCARGA_MERCA_GP_VI = request.getParameter("CWSF_DESCARGA_MERCA_GP_VI");

            String CWSF_CARGA_MERCA_GB_VD = request.getParameter("CWSF_CARGA_MERCA_GB_VD");
            
            String CWSF_CARGA_MERCA_GP_VD = request.getParameter("CWSF_CARGA_MERCA_GP_VD");
            String CWSF_CARGA_MERCA_GB_VI = request.getParameter("CWSF_CARGA_MERCA_GB_VI");
            
            String CWSF_CARGA_MERCA_GP_VI = request.getParameter("CWSF_CARGA_MERCA_GP_VI");

            BeanMulti user = new BeanMulti();
            user.setCWBC_COTIZACION(CWSF_COTIZACION);
            user.setCWBC_HORA(CWBC_HORA);
            user.setCWBC_ETA(CWBC_ETA);
            
            user.setCWSF_MUELLAJE_COF_IMPORT(MuellajeImport);
            user.setCWSF_DESCARGA_LLENOS_GP_VI(CWSF_DESCARGA_LLENOS_GP_VI);
            user.setCWSF_DESCARGA_LLENOS_GB_VI(CWSF_DESCARGA_LLENOS_GB_VI);
            user.setCWSF_DESCARGA_LLENOS_GP_VD(CWSF_DESCARGA_LLENOS_GP_VD);
            user.setCWSF_DESCARGA_LLENOS_GB_VD(CWSF_DESCARGA_LLENOS_GB_VD);
            user.setCWSF_DESCARGA_VACIOS_GP_VI(CWSF_DESCARGA_VACIOS_GP_VI);
            user.setCWSF_DESCARGA_VACIOS_GB_VI(CWSF_DESCARGA_VACIOS_GB_VI);
            user.setCWSF_DESCARGA_VACIOS_GP_VD(CWSF_DESCARGA_VACIOS_GP_VD);
            user.setCWSF_DESCARGA_VACIOS_GB_VD(CWSF_DESCARGA_VACIOS_GB_VD);

            user.setCWSF_CARGA_LLENOS_GP_VI(CWSF_CARGA_LLENOS_GP_VI);
            user.setCWSF_CARGA_LLENOS_GB_VI(CWSF_CARGA_LLENOS_GB_VI);
            user.setCWSF_CARGA_LLENOS_GP_VD(CWSF_CARGA_LLENOS_GP_VD);
            user.setCWSF_CARGA_LLENOS_GB_VD(CWSF_CARGA_LLENOS_GB_VD);
            user.setCWSF_CARGA_VACIOS_GP_VI(CWSF_CARGA_VACIOS_GP_VI);
            user.setCWSF_CARGA_VACIOS_GB_VI(CWSF_CARGA_VACIOS_GB_VI);
            user.setCWSF_CARGA_VACIOS_GP_VD(CWSF_CARGA_VACIOS_GP_VD);
            user.setCWSF_CARGA_VACIOS_GB_VD(CWSF_CARGA_VACIOS_GB_VD);

            user.setCWSF_DESCARGA_VEHICULOS_GP(CWSF_DESCARGA_VEHICULOS_GP);
            user.setCWSF_DESCARGA_VEHICULOS_GB(CWSF_DESCARGA_VEHICULOS_GB);
            user.setCWSF_REESTIBAS_GP(CWSF_REESTIBAS_GP);
            user.setCWSF_REESTIBAS_GB(CWSF_REESTIBAS_GB);
            user.setCWSF_TAPA_ESCOTILLAS_GP(CWSF_TAPA_ESCOTILLAS_GP);
            user.setCWSF_TAPA_ESCOTILLAS_GB(CWSF_TAPA_ESCOTILLAS_GB);
            user.setCWSF_DEPOSITO_TEMP_LLENO_GP(CWSF_DEPOSITO_TEMP_LLENO_GP);
            user.setCWSF_DEPOSITO_TEMP_VACIO_GP(CWSF_DEPOSITO_TEMP_VACIO_GP);
            user.setCWSF_DEPOSITO_TEMP_LLENO_GB(CWSF_DEPOSITO_TEMP_LLENO_GB);
            user.setCWSF_DEPOSITO_TEMP_VACIO_GB(CWSF_DEPOSITO_TEMP_VACIO_GB);

            user.setCWSF_REEMBARQUE_LLENO_GP(CWSF_REEMBARQUE_LLENO_GP);
            user.setCWSM_REEMBARQUE_LLENO_RF_GP(CWSF_REEMBARQUE_LLENO_RF_GP);
            user.setCWSF_REEMBARQUE_VACIO_GP(CWSF_REEMBARQUE_VACIO_GP);
            user.setCWSF_REEMBARQUE_LLENO_GB(CWSF_REEMBARQUE_LLENO_GB);
            user.setCWSM_REEMBARQUE_LLENO_RF_GB(CWSF_REEMBARQUE_LLENO_RF_GB);
            user.setCWSF_REEMBARQUE_VACIO_GB(CWSF_REEMBARQUE_VACIO_GB);

            user.setCWSF_DEPOSITO_MOMENT_GP(CWSF_DEPOSITO_MOMENT_GP);
            user.setCWSF_DEPOSITO_MOMENT_GB(CWSF_DEPOSITO_MOMENT_GB);

            user.setCWSF_DESCARGA_MERCA_GB_VD(CWSF_DESCARGA_MERCA_GB_VD);
            user.setCWSF_DESCARGA_MERCA_GB_VI(CWSF_DESCARGA_MERCA_GB_VI);
            user.setCWSF_DESCARGA_MERCA_GP_VD(CWSF_DESCARGA_MERCA_GP_VD);
            user.setCWSF_DESCARGA_MERCA_GP_VI(CWSF_DESCARGA_MERCA_GP_VI);

            user.setCWSF_CARGA_MERCA_GB_VD(CWSF_CARGA_MERCA_GB_VD);
            user.setCWSF_CARGA_MERCA_GB_VI(CWSF_CARGA_MERCA_GB_VI);
            user.setCWSF_CARGA_MERCA_GP_VD(CWSF_CARGA_MERCA_GP_VD);
            user.setCWSF_CARGA_MERCA_GP_VI(CWSF_CARGA_MERCA_GP_VI);
            
            user.setCWSM_DESCARGA_MERCA_GP_VD_HR(request.getParameter("CWSM_DESCARGA_MERCA_GP_VD_HR"));
            user.setCWSM_DESCARGA_MERCA_GP_VI_HR(request.getParameter("CWSM_DESCARGA_MERCA_GP_VI_HR"));
            user.setCWSM_CARGA_MERCA_GP_VD_HR(request.getParameter("CWSM_CARGA_MERCA_GP_VD_HR"));
            user.setCWSM_CARGA_MERCA_GP_VI_HR(request.getParameter("CWSM_CARGA_MERCA_GP_VI_HR"));
            
            

            detalle = Detalle_M.ActualizarDetalle(user);
            res = Detalle_M.Actualizar(user);
            //Eliminar = Detalle_M.EliminarDetalle(CWSF_COTIZACION);
            if (res.equalsIgnoreCase("bien")) {

                response.sendRedirect("GuardadoDetalle.jsp?Cotizacion=" + CWSF_COTIZACION + "");

            } else {
                out.println(res);
            }


        %>
    </body>
</html>
