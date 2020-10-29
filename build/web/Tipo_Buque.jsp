<%-- 
    Document   : Tipo_Buque
    Created on : 29/10/2020, 11:15:29 AM
    Author     : kcordon
--%>

<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanTipoBuque"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ServletRegistro.do" method="post" >
            <div class="row">
                <div class="col s12">

                    <div class="input-field col s3">
                        <input type="number"  size="20" name="Id" required pattern="[0-9]+" >
                        <label for="Id">Id</label>
                    </div>
                    
                    <div class="input-field col s3">
                        <input type="text" size="20" name="Nombre">
                        <label for="Nombre">Nombre</label>
                    </div>


                    <div class="input-field col s3">
                        <input type="submit" value="Registrar" class="btn-large light-blue accent-4" name="enviar">

                    </div>
                </div>

            </div>
        </form>
        
        
        <div class="col s12">

                <table border="1"   class="highlight responsive-table striped " >
                    <tr>

                        <td>Id </td>
                        <td>Nombre</td>
                        


                    </tr>
                    <%                        LinkedList<BeanTipoBuque> lista = Usuario.consultarTipoBuque();

                        for (int i = 0; i < lista.size(); i++) {

                            out.println("<tr>");
                            out.println("<td>" + lista.get(i).getCWTO_TIPO_OPERACION()+ "</td>");
                            out.println("<td>" + lista.get(i).getCWTO_OPERACION()+ "</td>");
                           

                            out.println("</tr>");
                        }
                    %>  
            </div>
        </div>
    </body>
</html>
