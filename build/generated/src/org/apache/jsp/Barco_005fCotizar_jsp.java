package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Usuario;
import controlador.BeanUsuarios;
import controlador.BeanBarcos;
import modelo.Barcos;

public final class Barco_005fCotizar_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, true);
      out.write("\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("\n");
      out.write("        ");

            String LR = request.getParameter("LR");
            BeanBarcos des = new BeanBarcos();
            des = Barcos.ObtenerBarcos(LR);

            String usuario = String.valueOf(session.getAttribute("usuario"));
            BeanUsuarios user = new BeanUsuarios();
            user = Usuario.ObtenerUsuario(usuario);

            BeanUsuarios user2 = new BeanUsuarios();
            user2 = Usuario.ObtenerCambioDolar();


        
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            \n");
      out.write("            <h3 class=\"aling center\">Cotizacion en Linea \"");
      out.print( des.getNOMBRE_DEL_BUQUE());
      out.write("\" </h3>\n");
      out.write("\n");
      out.write("            <div class=\"col s12\">\n");
      out.write("\n");
      out.write("                <form action='Actualizar.jsp' method='post'>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("\n");
      out.write("                        <h5 class=\"\">Datos Buque</h5>\n");
      out.write("\n");
      out.write("                        <div class=\"input-field col s3\">\n");
      out.write("\n");
      out.write("                            <input type=\"date\" name=\"fecha\" id=\"fecha\">\n");
      out.write("                            <label for=\"fecha\">Fecha ETA</label>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"input-field col s3\">\n");
      out.write("                            <input id=\"Trb\" type=\"text\"  value=\"");
      out.print( des.getLR());
      out.write("\">\n");
      out.write("                            <label for=\"Trb\">Trb</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field col s3\">\n");
      out.write("                            <input id=\"Slora\" type=\"text\"  value=\"");
      out.print( des.getESLORA());
      out.write("\">\n");
      out.write("                            <label for=\"Slora\">Slora</label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                        <div class=\"input-field col s3\">\n");
      out.write("                            <select>\n");
      out.write("                                <option value=\"\" disabled selected>Tipo Buque</option>\n");
      out.write("                                <option value=\"1\">BUQUE PORTACONTANEDOR</option>\n");
      out.write("                                <option value=\"2\">BUQUE MULTIPROPOSITOS</option>\n");
      out.write("                                <option value=\"3\">BUQUE MULTIPROPOSITOS FRIGORIFICOS</option>\n");
      out.write("                                <option value=\"4\">BUQUES GRANEL LIQUIDO</option>\n");
      out.write("                                <option value=\"5\">BUQUES GRANEL SOLIDO</option>\n");
      out.write("                            </select>\n");
      out.write("                            <label>Tipo Buque</label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"input-field col s3\">\n");
      out.write("                            <input id=\"Cambio\" type=\"text\" class=\"validate\" value=\"");
      out.print( user2.getCAMBIO());
      out.write("\">\n");
      out.write("                            <label for=\"Cambio\">Cambio Dolar</label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"input-field col s3\">\n");
      out.write("                            <input id=\"Nit\" type=\"text\" class=\"validate\" value=\"");
      out.print(user.getNIT());
      out.write("\">\n");
      out.write("                            <label for=\"Nit\">Nit</label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                        <div class=\"input-field col s3\">\n");
      out.write("                            <input id=\"Tm_Exp\" type=\"text\" class=\"validate\">\n");
      out.write("                            <label for=\"Tm_Exp\">Tm Exp</label>\n");
      out.write("                        </div><div class=\"input-field col s3\">\n");
      out.write("                            <input id=\"Tm_Imp\" type=\"text\" class=\"validate\">\n");
      out.write("                            <label for=\"Tm_Imp\">Tm Imp</label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"input-field col s3\">\n");
      out.write("                            <input id=\"Horas\" type=\"text\" class=\"validate\">\n");
      out.write("                            <label for=\"Horas\">Horas</label>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                            <div class=\"row col s12\">\n");
      out.write("\n");
      out.write("                            <a class=\"waves-effect waves-light btn-large \" href=\"Barco_Cotizar_Detalle.jsp\">Detalle</a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                     \n");
      out.write("\n");
      out.write("                        \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>   \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            document.addEventListener('DOMContentLoaded', function () {\n");
      out.write("                var elems = document.querySelectorAll('select');\n");
      out.write("                var instances = M.FormSelect.init(elems, instances);\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
