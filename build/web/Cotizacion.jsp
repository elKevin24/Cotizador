<%-- 
    Document   : PDF
    Created on : 28/12/2020, 12:09:20 PM
    Author     : kcordon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.sf.jasperreports.engine.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.sql.*" %> 
<% /*Parametros para realizar la conexión*/
    Connection conexion;
    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
    conexion = DriverManager.getConnection("jdbc:oracle:thin:@172.20.10.5:1521:EMPORA", "COTIZADOR_WEB", "COTIZA#1");
    
    
    String Valor = request.getParameter("txtparametro");
    /*Establecemos la ruta del reporte*/
    File reportFile = new File(application.getRealPath("Report/Detalle.jasper"));
    /* No enviamos parámetros porque nuestro reporte no los necesita asi que escriba 
    cualquier cadena de texto ya que solo seguiremos el formato del método runReportToPdf*/
    Map parameters = new HashMap();
    parameters.put("COTIZACION", Valor);
    
    
    /*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/
    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);
    /*Indicamos que la respuesta va a ser en formato PDF*/ 
    response.setContentType("application/pdf");
    
   

    response.setContentLength(bytes.length);
    ServletOutputStream ouputStream = response.getOutputStream();
    ouputStream.write(bytes, 0, bytes.length);
    /*Limpiamos y cerramos flujos de salida*/ ouputStream.flush();
    ouputStream.close();%>


