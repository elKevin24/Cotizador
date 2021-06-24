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
                <div class="light-blue darken-4">
                    <%

                        String usuario = String.valueOf(session.getAttribute("usuario"));
                        BeanUsuarios user = new BeanUsuarios();
                        user = Usuario.ObtenerUsuario(usuario);
                        System.err.println("Usuario " + usuario);
                        System.err.println("Usuario2 " + user.getNOMBRE());
                        

                        if(usuario == "null"){
                            System.out.println("entro al if");
                            %>
                            
                             <META HTTP-EQUIV="REFRESH" CONTENT="0;URL=Login.jsp"> 
                            
                            <%
                        }
                    %>
                    
                   
                    <ul class="right hide-on-med-and-down"> 

                        <li><a href="Login.jsp">Salir</a></li>
                    </ul>
                    <ul id="slide-out" class="sidenav">
                        <li>
                            <div class="user-view">
                                <div class="background" >
                                    <img src="img/azul.jpg"/>
                                </div>

                                <a href="#user"><img class="circle" src="img/EMPORNAC_logo.png" ></a>                                
                                <a href="#name"><span class="white-text name"><%= user.getNOMBRE()%></span></a>
                                <a href="#name"><span class="white-text name"><%= user.getUSUARIO_INOW()%></span></a>
                                <a href="#email"><span class="white-text email"><%= user.getCORREO()%></span></a>
                            </div>
                        </li>

                        <li><a class="subheader">Menu Servicios</a></li>
                        <ul class="collapsible collapsible-accordion">
                            <li>
                                <a class="collapsible-header">Cotizador<i class="material-icons">account_boxarrow_drop_down</i></a>
                                <div class="collapsible-body">
                                    <ul>  
                                        
                                        
                                        <li><a href="Barcos.jsp">Crear Nueva Cotizacion</a></li>                                       
                                        <li><a href="BarcosNuevo.jsp">Crear Barco</a></li>
                                        <li><a class="subheader">Consultas</a></li>
                                        
                                        <li><a href="ConsultaCreados.jsp">Creados</a></li>
                                        <li><a href="ConsultaPendiente.jsp">Pendientes</a></li>
                                        <li><a href="ConsultaAprobado.jsp">Aprobados</a></li>
                                        <li><a href="ConsultaEliminados.jsp">Eliminados</a></li>
                                        
                                    </ul>
                                    
                                    
                                </div>
                            </li>
                            
                            <li>
                                <a class="collapsible-header">Trazabilidad Contenedores<i class="material-icons">directions_boatarrow_drop_down</i></a>
                                <div class="collapsible-body">
                                    <ul>
                                        <a href="carta/carta_porte_1.jsp"></a>
                                        <li><a href="Trazabilidad_Barcos.jsp">Trazabilidad Descarga</a></li>
                                        <li><a href="Trazabilidad_Barcos_Export.jsp">Trazabilidad Carga</a></li>

                                    </ul>
                                </div>
                            </li>
                            <li>
                                <a class="collapsible-header">Carta Porte<i class="material-icons">content_pastearrow_drop_down</i></a>
                                <div class="collapsible-body">
                                    <ul>                                       
                                        
                                        <li><a href="carta_porte_1.jsp">Crear Carta Porte</a></li>
                                        
                                    </ul>
                                </div>
                            </li>

                            <li><a href="Login.jsp">Salir</a></li>
                        </ul>
                    </ul>
                    <a href="#" data-target="slide-out" class="sidenav-trigger show-on-large"><i class="material-icons">menu</i></a>
                </div>
            </div>
        </nav>
    </body>

    <script language="javascript">

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
