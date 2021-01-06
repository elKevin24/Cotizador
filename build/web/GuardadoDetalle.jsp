<%-- 
    Document   : Guardado
    Created on : 3/06/2018, 03:32:42 PM
    Author     : busqu
--%>

<%@page import="modelo.Encabezado"%>
<%@page import="controlador.BeanEncabezado"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexion"%>
<%@page import="modelo.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head> 
        <link href="https://fonts.googleapis.com/css?family=Playball" rel="stylesheet">
        <style>
            body {
                font-family: 'Playball', cursive;

            }
        </style>
        <title>Refrescar la URL</title> 
        <%
            String Cotizacion = request.getParameter("Cotizacion");
            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.Cotizacion(Cotizacion);

            try {
                Conexion c = new Conexion();
                Connection con = c.getConexion();
                Statement st;
                st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT COTIZADOR_WEB.F_CW_TARIFA_X_COTIZACION(" + Cotizacion + ",'" + enc.getGRABADOR() + "', TO_DATE('" + enc.getCWBC_TIPO_CAMBIO_FECHA().substring(0, 10) + "','YYYY-MM-DD') , " + enc.getCWBC_HORA() + ", " + enc.getCWBC_CODIGO_USUARIO() + ") from dual");

            } catch (Exception e) {

            }


        %>

        <META HTTP-EQUIV="REFRESH" CONTENT="2;URL=Detalle.jsp?Cotizacion=<%=  Cotizacion%>"> 
    </head> 
    <body> 


    <center> <h1> Registrado</h1></center>
    <center> <img src="IMG/descarga.png" width="400" alt=""/> </center>
    Hora: 
    <script>
        miFecha = new Date()
        document.write(miFecha.getHours() + ":" + miFecha.getMinutes() + ":" + miFecha.getSeconds())
    </script> 
</body> 
</html>