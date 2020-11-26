<%-- 
    Document   : Editar
    Created on : 05-may-2018, 12:51:49
    Author     : nichodeveloper
--%>




<%@ page import="controlador.BeanConsulta"%> 
<%@ page import="modelo.Consulta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
    
     <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
        <title>Modificacion de datos</title>
    </head>
    <body>
        
        
        <%
               String id = request.getParameter("id");
               
               BeanConsulta user = new BeanConsulta();
               user = Consulta.Creados(id);
                
                 out.println("<h3>Modificación de alumno</h3>");
                 out.println("<img src='logo.png' width='100'/>");
                 out.println("<div class='row'>");            
                 out.println("<form action='Actualizar.jsp' method='post'>");
                 out.println("<div class='row'>");
                 out.println("<div class='input-field col s6'>");
                 out.println("<input type='text' size='20' name='Nombre' value="+user.getNombre()+">");
                 out.println("<input type='hidden' name='Id_alumno' value="+user.getId_alumno()+"");
                 out.println("<label for='Nombre'>Nombre</label>");
                 out.println("</div>");
                 out.println("<div class='input-field col s6'>");
                 out.println("<input type='text' size='20' name='Snombre' value="+user.getSnombre()+">");
                 out.println("<label for='Snombre'>Segundo nombre</label>");
                 out.println("</div>");
                 out.println("</div>");
                 out.println("<div class='input-field col s6'>");
                 out.println("<input type='text' size='20' name='Apellido' value="+user.getApellido()+">");
                 out.println("<label for='Apellido'>Apellido</label>");
                 out.println("</div>");
                 out.println("<div class='input-field col s6'>");
                 out.println("<input type='text' size='20' name='Sapellido' value="+user.getSapellido()+">");
                 out.println("<label for='Sapellido'>Segundo apellido</label>");
                 out.println("</div>");              
                 out.println("<div class='input-field col s3'>");
                 out.println("<input type='text' size='20' name='Id_seccion' value="+user.getId_seccion()+">");
                 out.println("<label for='Id_seccion'>Id_seccion</label>");
                 out.println("</div>");
                                 

                 out.println("<div class='row'>");
                 out.println("<input type='submit' value='Actualizar' class='btn-large'>");                 
                 out.println("<a href='Alumnos.jsp' value='Regresar' class='btn-large'>Regresar</a>");                 
                 out.println("'</div>'");                 
                 out.println("</form>");
                 out.println("</div>");
                




        %>
            
        
        
        
        
    </body>
</html>
