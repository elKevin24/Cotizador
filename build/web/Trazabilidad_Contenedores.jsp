<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="modelo.TrazabilidadContenedores"%>
<%@page import="controlador.Trazabilidad_Contenedores"%>
<%@page import="modelo.TrazabilidadBarcos"%>
<%@page import="controlador.Trazabilidad_Barcos"%>
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
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">      <!--Import materialize.css-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Compiled and minified JavaScript -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <script src="js/retenciones.js" type="text/javascript"></script>
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <%

            String id = request.getParameter("id");
            session.setAttribute("viaje_barco", id);

            String retencion = null;


        %>

        <jsp:include page="menu.jsp" flush="true"></jsp:include>
       
            <title>Listado de Barcos</title>


        </head>
        <body>



            <div class="row">
                <div class="col s12">
                    <div class="col s1">

                    </div>
                    <div class="col s10">





                        <table id="example" border="1"   class="display table table-hover table-bordered table-striped" >
                            <thead>
                                <tr>

                                    <th>NUMERO CONTENEDOR</th>
                                    <th>FECHA DESCARGA</th>
                                    <th>REVISION NO INTRUSIVA</th>
                                    <th>PASO BASCULA</th>

                                    <th>RETENCION SAT</th>

                                    <th>SALIDA</th>
                                    <th>UBICACION</th>




                                </tr>
                            </thead>
                            <tbody>
                            <%                                System.err.println("Viaje Barco" + id);

                                LinkedList<Trazabilidad_Contenedores> lista = TrazabilidadContenedores.consultarCont(id);

                                for (int i = 0; i < lista.size(); i++) {

                                    out.println("<tr>");
                                    out.println("<td>" + lista.get(i).getC1() + "</td>");
                            %>
                        <script>


var resultset = null;
                            var cont = "<%=lista.get(i).getC1()%>";
                            resultset = reten(cont);

                            console.log("hola");

                            
                               // var campo = document.getElementById('prueba');
                               /// campo.style.backgroundColor = "blue";
                            



                            //console.log(cont);

                        </script>

                        <%

                                out.println("<td id='prueba' >" + lista.get(i).getC2().substring(0, 10) + "</td>");

                                if (lista.get(i).getC3() != null) {
                                    out.println("<td class='text-center'> <img src='img/bullet-green.png' class=' tooltipped ' data-position='bottom' data-tooltip='" + lista.get(i).getC3() + "'></></td>");

                                } else {
                                    out.println("<td class='text-center'> <img src='img/bullet-red.png' class=' tooltipped ' data-position='bottom' data-tooltip='Sin Escaneo'></></td>");
                                }

                                if (lista.get(i).getC4().equals("NO")) {
                                    out.println("<td class='text-center'> <img src='img/bullet-red.png' class=' tooltipped ' data-position='bottom' data-tooltip='Sin Peso'></></td>");
                                } else {

                                    out.println("<td class='text-center'> <img src='img/bullet-green.png' class=' tooltipped ' data-position='bottom' data-tooltip='" + lista.get(i).getC4() + "'></a></td>");

                                }

                                if (lista.get(i).getC7() == null) {
                                    out.println("<td id='"+lista.get(i).getC1()+"' class='text-center'> <img src='img/bullet-green.png' class=' tooltipped ' data-position='bottom' data-tooltip='Sin Retenciones'></></td>");

                                } else {
                                    out.println("<td class='text-center'> <img src='img/bullet-red.png' class=' tooltipped ' data-position='bottom' data-tooltip='Entidad que Retiene " + lista.get(i).getC7() + "'></></td>");
                                }

                                if (lista.get(i).getC5() != null) {
                                    out.println("<td class='text-center'> <img src='img/bullet-green.png' class=' tooltipped ' data-position='bottom' data-tooltip='" + lista.get(i).getC5() + "'></></td>");

                                } else {
                                    out.println("<td class='text-center'> <img src='img/bullet-red.png' class=' tooltipped ' data-position='bottom' data-tooltip='Sin Escaneo'></></td>");
                                }

                                if (lista.get(i).getC6() == null || (lista.get(i).getC6().equals("NO"))) {
                                    out.println("<td class='text-center'> <img src='img/bullet-red.png' class=' tooltipped ' data-position='bottom' data-tooltip='Sin Escaneo'></></td>");

                                } else {
                                    out.println("<td class='text-center'> <img src='img/bullet-green.png' class=' tooltipped ' data-position='bottom' data-tooltip='" + lista.get(i).getC6() + "'></></td>");

                                }

                                // out.println("<td> <a class='btn-floating btn-small waves-effect waves-light red'></a></td>");
                                // out.println("<td> <a class='btn-floating btn-small waves-effect waves-light green'></a></td>");
                                out.println("</tr>");
                            }
                        %>  
                        </tbody>

                        <tfoot>
                            <tr>

                                <th>NUMERO CONTENEDOR</th>
                                <th>FECHA DESCARGA</th>
                                <th>REVISION NO INTRUSIVA</th>
                                <th>PASO BASCULA</th>
                                <th>RETENCION SAT</th>

                                <th>SALIDA</th>
                                <th>UBICACION</th>

                            </tr>
                        </tfoot>
                    </table>

                </div>


            </div>





            <script type="text/javascript">
                $(document).ready(function () {
                    $('.tooltipped').tooltip();
                });

            </script>




            <script type="text/javascript">




                $(document).ready(function () {

                    // Setup - add a text input to each footer cell
                    $('#example tfoot th').each(function () {
                        var title = $(this).text();
                        $(this).html('<input type="text" placeholder="Search ' + title + '" />');
                    });

                    // DataTable
                    $('#example').DataTable({

                        initComplete: function () {
                            // Apply the search
                            this.api().columns().every(function () {
                                var that = this;

                                $('input', this.footer()).on('keyup change clear', function () {
                                    if (that.search() !== this.value) {
                                        that
                                                .search(this.value)
                                                .draw();
                                    }
                                });
                            });
                        }

                    });




                });






            </script>


            <!--JavaScript at end of body for optimized loading-->


            <script src="js/retenciones.js" type="text/javascript"></script>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
            <script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/jszip-2.5.0/dt-1.10.24/af-2.3.6/b-1.7.0/b-colvis-1.7.0/b-html5-1.7.0/b-print-1.7.0/cr-1.5.3/date-1.0.3/fc-3.3.2/fh-3.1.8/kt-2.6.1/r-2.2.7/rg-1.1.2/rr-1.2.7/sc-2.0.3/sb-1.0.1/sp-1.2.2/sl-1.3.3/datatables.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>


            <script type="text/javascript">
                $(document).ready(function () {
                    $('.tooltipped').tooltip();
                });

            </script>




    </body>


</html>