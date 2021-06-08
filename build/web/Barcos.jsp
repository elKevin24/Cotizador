<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="modelo.Barcos"%>
<%@page import="controlador.BeanBarcos"%>
<%@page import="java.util.*"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <!-- Compiled and minified JavaScript -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css"/>


        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>



        <jsp:include page="menu.jsp" flush="true"></jsp:include>

        </head>
        <body>
            <div class="row">
                <div class="col s1 push-s1">
                    <a  href="Barcos.jsp" class="btn-floating pulse" ><i class="material-icons">arrow_back</i></a>
                </div>
            </div>

            <div class="container">
                <h2> Escoger Barco a Cotizar</h2>



                <div>
                    <a class="waves-effect waves-light btn" href="BarcosFull.jsp">Todos</a>
                </div>

                <div class="col s12">

                    <table id="table_id" border="1"   class="table table-hover" >
                        <thead>
                            <tr>

                                <th>LR</th>
                                <th>Buque</th>
                                <th>Bandera</th>
                                <th>Trb</th>
                                <th>Slora</th>
                                <th>Cotizar</th>



                            </tr>
                        </thead>
                        <tbody>
                        <%
                            String usuario = String.valueOf(session.getAttribute("usuario"));
                            BeanUsuarios user = new BeanUsuarios();
                            user = Usuario.ObtenerUsuario(usuario);
                            String codigo = user.getUSUARIO_DE_SERVICIO();

                            LinkedList<BeanBarcos> lista = Barcos.consultarBarco(codigo);

                            for (int i = 0; i < lista.size(); i++) {

                                out.println("<tr>");
                                out.println("<td class='text-center'>" + lista.get(i).getLR() + "</td>");
                                out.println("<td >" + lista.get(i).getNOMBRE_DEL_BUQUE() + "</td>");
                                out.println("<td>" + lista.get(i).getBANDERA() + "</td>");
                                out.println("<td>" + lista.get(i).getTRB() + "</td>");
                                out.println("<td>" + lista.get(i).getESLORA() + "</td>");

                                out.println("<td>" + "<a class='waves-effect waves-light btn-small' onclick='return myFunction()' href=BarcoCotizar.jsp?LR=" + lista.get(i).getLR() + "&USE=" + codigo + ">" + "Cotizar" + "</a>" + "</td>");

                                out.println("</tr>");
                            }
                        %>  
                    </tbody>
                </table>

            </div>
        </div>

        <script type="text/javascript">

            $(document).ready(function () {
                $('#table_id').DataTable();
            });

        </script>
        <!--JavaScript at end of body for optimized loading-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>



    </body>


</html>
