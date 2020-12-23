<%-- 
    Document   : Conexion1
    Created on : 21/12/2020, 12:28:29 PM
    Author     : kcordon
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            Connection con = null;
            try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    //jdbc:sqlserver://localhost:1433;databaseName=db_proyecto [sa on dbo]
                    con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@172.20.10.5:1521:EMPORA", "COTIZADOR_WEB", "COTIZA#1");
                    out.print("Conexion en Linea");} 
            catch(Exception ex){
                out.print("Error: "+ ex.getMessage());
                }

              

        %>
    </body>
</html>
