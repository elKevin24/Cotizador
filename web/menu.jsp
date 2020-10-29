<%-- 
    Document   : index
    Created on : 21/05/2018, 12:12:11 PM
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="modelo.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/jpeg" href="https://hh.santotomasport.com.gt/global/santotomasport.com.gt/EMPORNAC_logo.png" />
        <title>Cotizador Empornac</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        
      
    </head>

    <body>
        <nav>
            <div class="nav-wrapper light-blue darken-4">
                <div class="light-blue darken-4"


                     <a href="#!" class="brand-logo"></a>

                    <ul class="right hide-on-med-and-down"> 

                        <li><a href="index.jsp">Salir</a></li>
                    </ul>
                     

                    <%
                        String usuario = String.valueOf(session.getAttribute("usuario"));
                        BeanUsuarios user = new BeanUsuarios();
                        user = Usuario.ObtenerUsuario(usuario);

                       

                    %>
                    
                   


                    <ul id="slide-out" class="sidenav">
                        <li><div class="user-view">
                                <div class="background">
                                    <img src="imagenes/442703.png" alt=""/>

                                </div>


                                <a href="#name"><span class="white-text name"><%= user.getNOMBRE()%></span></a>
                                <a href="#name"><span class="white-text name"><%= user.getUSUARIO_INOW()%></span></a>
                                <a href="#email"><span class="white-text email"><%= user.getCORREO()%></span></a>
                            </div>
                        </li>

                        <li><a class="subheader">Menu Cotizaciones</a></li>
                        <ul class="collapsible collapsible-accordion">
                            <li>

                                <a class="collapsible-header">Proyectos<i class="material-icons">account_boxarrow_drop_down</i></a>
                                <div class="collapsible-body">
                                    <ul>
                                        <li><a href="Barcos.jsp">Ingreso</a></li>
                                        <li><a href="Barco.jsp">Consulta</a></li>

                                    </ul>
                                </div>
                            </li>
                        </ul>

                    </ul>

                    <a href="#" data-target="slide-out" class="sidenav-trigger show-on-large"><i class="material-icons">menu</i></a>
                </div>
            </div>
        </nav>

    </body>

    <script>

        document.addEventListener('DOMContentLoaded', function () {
            var elems = document.querySelectorAll('.sidenav');
            var instances = M.Sidenav.init(elems, {
                direction: 'left',
                hoverEnabled: false
            });
            var collapsibleElem = document.querySelector('.collapsible');
            var collapsibleInstance = M.Collapsible.init(collapsibleElem, {
                direction: 'left',
                hoverEnabled: false
            });
        });

    </script>
</html>
