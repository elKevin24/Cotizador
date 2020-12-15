<%-- 
    Document   : FUNCION
    Created on : 14/12/2020, 12:04:07 PM
    Author     : kcordon
--%>

<%@page import="modelo.DetalleCotizacion"%>
<%@page import="controlador.BeanDetalleCotizacion"%>
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
    BeanDetalleCotizacion enc = new BeanDetalleCotizacion();
    enc = DetalleCotizacion.ObtenerDetalle(Cotizacion);
    
    
    
    
   
  %>

  <META HTTP-EQUIV="REFRESH" CONTENT="2;URL=.jsp?Cotizacion=<%= Cotizacion %>"> 
</head> 
<body> 
    
    
<center> <h1> Registrado  </h1></center>
    <center> <img src="IMG/descarga.png" width="400" alt=""/> </center>
Hora: 
<script> 
miFecha = new Date() 
document.write(miFecha.getHours() + ":" + miFecha.getMinutes() + ":" + miFecha.getSeconds()) 
</script> 
</body> 
</html>