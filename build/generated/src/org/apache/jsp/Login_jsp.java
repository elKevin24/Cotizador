package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("<!------ Include the above in your HEAD tag ---------->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("         <link rel=\"icon\" type=\"image/jpeg\" href=\"https://hh.santotomasport.com.gt/global/santotomasport.com.gt/EMPORNAC_logo.png\" />\n");
      out.write("<title>Cotizador Empornac</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.1/css/all.css\" integrity=\"sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">\n");
      out.write("    </head>\n");
      out.write("    <!--Coded with love by Mutiullah Samim-->\n");
      out.write("    <body>          \n");
      out.write("        <div class=\"container h-100\">\n");
      out.write("            <div class=\"d-flex justify-content-center h-100\">\n");
      out.write("                \n");
      out.write("                \n");
      out.write("\n");
      out.write("                <div class=\"user_card\">\n");
      out.write("                    <div class=\"d-flex justify-content-center\">\n");
      out.write("                        <div class=\"brand_logo_container\">                                                                                   \n");
      out.write("                            <img src=\"https://hh.santotomasport.com.gt/global/santotomasport.com.gt/EMPORNAC_logo.png\" class=\"brand_logo\" alt=\"Logo\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"d-flex justify-content-center form_container\">\n");
      out.write("                        <form action=\"Controlador\" method=\"post\">\n");
      out.write("                            <div class=\"input-group mb-3\">\n");
      out.write("                                <div class=\"input-group-append\">\n");
      out.write("                                    <span class=\"input-group-text\"><i class=\"fas fa-user\"></i></span>\n");
      out.write("                                </div>\n");
      out.write("                                <input type=\"text\" name=\"usuario\" class=\"form-control input_user\" value=\"\" placeholder=\"Usuario\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"input-group mb-2\">\n");
      out.write("                                <div class=\"input-group-append\">\n");
      out.write("                                    <span class=\"input-group-text\"><i class=\"fas fa-key\"></i></span>\n");
      out.write("                                </div>\n");
      out.write("                                <input type=\"password\" name=\"clave\" class=\"form-control input_pass\" value=\"\" placeholder=\"Contraseña\">\n");
      out.write("                            </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"d-flex justify-content-center mt-3 login_container\">\n");
      out.write("\n");
      out.write("                        <input type=\"submit\" value=\"Ingresar\" name=\"accion\" class=\"btn login_btn\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>        \n");
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
