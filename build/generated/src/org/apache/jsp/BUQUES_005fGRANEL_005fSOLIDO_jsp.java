package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Encabezado;
import controlador.BeanEncabezado;
import modelo.Usuario;
import controlador.BeanUsuarios;
import modelo.Barcos;
import controlador.BeanBarcos;
import java.util.*;

public final class BUQUES_005fGRANEL_005fSOLIDO_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <!--Import Google Icon Font-->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("        <!--Import materialize.css-->\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"  media=\"screen,projection\"/>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/newcss.css\">\r\n");
      out.write("        <!-- Compiled and minified JavaScript -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css\"/>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.js\"></script>\r\n");
      out.write("        ");

            String Cotizacion = request.getParameter("Cotizacion");
            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.CotizacionGeneral(Cotizacion);
        
      out.write("\r\n");
      out.write("        <!--Let browser know website is optimized for mobile-->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, true);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </head>\r\n");
      out.write("        <body>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col s1 push-s1\">\r\n");
      out.write("                    <a  href=\"index.jsp\" class=\"btn-floating pulse\" ><i class=\"material-icons\">arrow_back</i></a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("                <h5> Cotizacion LR: ");
      out.print( enc.getCWBC_LR() + "  ETA: " + enc.getCWBC_ETA() + "  SEÑAL DISTINTIVA: " + enc.getCWBC_SENAL_DISTINTIVA());
      out.write("</h5>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <form action=\"ServleLiquido.do\" method=\"post\" >\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"divider\"></div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"section\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <table class=\"responsive-table highlight striped\">\r\n");
      out.write("\r\n");
      out.write("                    <thead>\r\n");
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("\r\n");
      out.write("                            <th></th>\r\n");
      out.write("\r\n");
      out.write("                            <th colspan=\"1\">IMPORT</th>\r\n");
      out.write("\r\n");
      out.write("                            <th colspan=\"2\">EXPORT</th>\r\n");
      out.write("\r\n");
      out.write("                        </tr>\r\n");
      out.write("\r\n");
      out.write("                    </thead>\r\n");
      out.write("\r\n");
      out.write("                    <tbody>\r\n");
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("\r\n");
      out.write("                            <th>Granel Solido</th>\r\n");
      out.write("\r\n");
      out.write("                            <td>\r\n");
      out.write("\r\n");
      out.write("                                <input  placeholder=\"Toneladas\" name=\"CWSL_DESC_ACEITE_GRASA_QUIMI\" type=\"text\" class=\"validate\">\r\n");
      out.write("                                <label for=\"CWSL_DESC_ACEITE_GRASA_QUIMI\"></label>\r\n");
      out.write("\r\n");
      out.write("                            </td>\r\n");
      out.write("\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <input  placeholder=\"Toneladas\" name=\"CWSL_CARGA_ACEITE_GRASA_QUIMI\" type=\"text\" class=\"validate\">\r\n");
      out.write("                                <label for=\"CWSL_CARGA_ACEITE_GRASA_QUIMI\"></label>\r\n");
      out.write("                            </td>\r\n");
      out.write("\r\n");
      out.write("                        </tr>\r\n");
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("\r\n");
      out.write("                            <th>Granel Solido en Pontones</th>\r\n");
      out.write("\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <input  placeholder=\"Toneladas\" name=\"CWSL_DESC_COMBUSTIBLES_DERIV\" type=\"text\" class=\"validate\">\r\n");
      out.write("                                <label for=\"CWSL_DESC_COMBUSTIBLES_DERIV\"></label>\r\n");
      out.write("                            </td>\r\n");
      out.write("\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <input  placeholder=\"Toneladas\" name=\"CWSL_CARGA_COMBUSTIBLES_DERIV\" type=\"text\" class=\"validate\">\r\n");
      out.write("                                <label for=\"CWSL_CARGA_COMBUSTIBLES_DERIV\"></label>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                </table>\r\n");
      out.write("\r\n");
      out.write("                <!-- valores que no se ven en pantalla\r\n");
      out.write("                -->\r\n");
      out.write("\r\n");
      out.write("                <input type=\"hidden\" id=\"custId\" name=\"CWSL_COTIZACION\" value=\"");
      out.print( Cotizacion);
      out.write("\">\r\n");
      out.write("                <input type=\"hidden\" id=\"custId\" name=\"GRABADOR\" value=\"");
      out.print( enc.getGRABADOR());
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"input-field col s3\">\r\n");
      out.write("                    <input type=\"submit\" value=\"Registrar\" class=\"btn-large light-blue accent-4\" name=\"enviar\">\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!--JavaScript at end of body for optimized loading-->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\r\n");
      out.write("        <script src=\"https://unpkg.com/jquery@3.3.1/dist/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" charset=\"utf8\" src=\"https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("            $(document).ready(function () {\r\n");
      out.write("                $('#table_id').DataTable();\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
