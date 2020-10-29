package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Usuario;
import controlador.BeanTipoBuque;
import java.util.LinkedList;

public final class Tipo_005fBuque_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"ServletRegistro.do\" method=\"post\" >\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col s12\">\n");
      out.write("\n");
      out.write("                    <div class=\"input-field col s3\">\n");
      out.write("                        <input type=\"number\"  size=\"20\" name=\"Id\" required pattern=\"[0-9]+\" >\n");
      out.write("                        <label for=\"Id\">Id</label>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"input-field col s3\">\n");
      out.write("                        <input type=\"text\" size=\"20\" name=\"Nombre\">\n");
      out.write("                        <label for=\"Nombre\">Nombre</label>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"input-field col s3\">\n");
      out.write("                        <input type=\"submit\" value=\"Registrar\" class=\"btn-large light-blue accent-4\" name=\"enviar\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"col s12\">\n");
      out.write("\n");
      out.write("                <table border=\"1\"   class=\"highlight responsive-table striped \" >\n");
      out.write("                    <tr>\n");
      out.write("\n");
      out.write("                        <td>Id </td>\n");
      out.write("                        <td>Nombre</td>\n");
      out.write("                        \n");
      out.write("\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");
                        LinkedList<BeanTipoBuque> lista = Usuario.consultarTipoBuque();

                        for (int i = 0; i < lista.size(); i++) {

                            out.println("<tr>");
                            out.println("<td>" + lista.get(i).getCWTO_TIPO_OPERACION()+ "</td>");
                            out.println("<td>" + lista.get(i).getCWTO_OPERACION()+ "</td>");
                           

                            out.println("</tr>");
                        }
                    
      out.write("  \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
