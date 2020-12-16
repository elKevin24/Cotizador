package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import modelo.Conexion;
import modelo.DetalleCotizacion;
import controlador.BeanDetalleCotizacion;
import java.util.LinkedList;
import modelo.Detalle_S;
import controlador.BeanSolido;
import modelo.Encabezado;
import controlador.BeanEncabezado;

public final class Detalle_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
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
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!--Let browser know website is optimized for mobile-->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            String Cotizacion = request.getParameter("Cotizacion");
            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.Cotizacion(Cotizacion);
            String eta = enc.getCWBC_ETA();
            

            try {
                Conexion c = new Conexion();
                                    Connection con = c.getConexion();
                                    Statement st;
                                    st = con.createStatement();
                                    ResultSet rs = st.executeQuery("SELECT COTIZADOR_WEB.F_CW_TARIFA_X_COTIZACION("+Cotizacion+",'"+enc.getGRABADOR()+"', TO_DATE('"+enc.getCWBC_TIPO_CAMBIO_FECHA().substring(0, 10)+"','YYYY-MM-DD') , "+enc.getCWBC_HORA()+", "+enc.getCWBC_CODIGO_USUARIO() +") from dual");
                
            }catch(Exception e){
                
            }


        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, true);
      out.write("\n");
      out.write("\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <table id=\"1\" class=\"table table-bordered\">\n");
      out.write("                    <thead class=\"text-center\">\n");
      out.write("                        <tr >\n");
      out.write("                            <th WIDTH=\"25\" \n");
      out.write("                                HEIGHT=\"25\">\n");
      out.write("                                <img src=\"https://hh.santotomasport.com.gt/global/santotomasport.com.gt/EMPORNAC_logo.png\">\n");
      out.write("                            </th>\n");
      out.write("                            <th colspan=\"3.5\" class=\"text-center\">\n");
      out.write("                                EMPRESA PORTUARIA NACIONAL \"SANTO TOMAS DE CASTILLA\" </br>\n");
      out.write("                                IZABAL, GUATEMALA </br>\n");
      out.write("                                COTIZACION DE SERVICIOS PORTUARIOS </br>\n");
      out.write("\n");
      out.write("                            </th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("                <table id=\"2\" class=\"table table-bordered\">\n");
      out.write("                    <thead class=\"text-center\">\n");
      out.write("                        <tr >\n");
      out.write("                            <th >\n");
      out.write("                                Cotizacion: ");
      out.print( Cotizacion);
      out.write("\n");
      out.write("\n");
      out.write("                        </th>\n");
      out.write("                        <th  >\n");
      out.write("                            Fecha:\n");
      out.write("                            <script>\n");
      out.write("\n");
      out.write("                                var f = new Date();\n");
      out.write("                                document.write(f.getDate() + \"/\" + (f.getMonth() + 1) + \"/\" + f.getFullYear());\n");
      out.write("                            </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </th>\n");
      out.write("                        <th >\n");
      out.write("                            Fecha ETA:\n");
      out.write("                            ");
      out.print( eta);
      out.write("\n");
      out.write("                        </th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            <table id=\"3\" class=\"table table-bordered\">\n");
      out.write("                <th colspan=\"4\" class=\"text-center\">\n");
      out.write("                    Datos de Buque  \n");
      out.write("\n");
      out.write("                </th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th  >\n");
      out.write("                        Buque: ");
      out.print( enc.getCWBC_BUQUE_VIAJE());
      out.write("\n");
      out.write("                    </th>\n");
      out.write("\n");
      out.write("                    <th  >\n");
      out.write("                        LR: ");
      out.print( enc.getCWBC_LR());
      out.write("\n");
      out.write("                    </th>\n");
      out.write("                    <th  >\n");
      out.write("                        Señal Distintica: ");
      out.print( enc.getCWBC_SENAL_DISTINTIVA());
      out.write("\n");
      out.write("                    </th>\n");
      out.write("                    <th  >\n");
      out.write("                        Tipo Operacion: ");
      out.print( enc.getCWBC_TIPO_OPERACION());
      out.write("\n");
      out.write("                    </th>\n");
      out.write("                </tr>\n");
      out.write("                </thead>\n");
      out.write("            </table>\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th class=\"text-center\" colspan=\"5\"> \n");
      out.write("                            Datos \n");
      out.write("                        </th>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <th class=\"text-center\" colspan=\"2\" >\n");
      out.write("                            Dolar \n");
      out.write("                        </th>\n");
      out.write("\n");
      out.write("                        <th class=\"text-center\"  colspan=\"3\">\n");
      out.write("                            Usuario \n");
      out.write("                        </th>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <th class=\"text-center\" >\n");
      out.write("                            Precio:  ");
      out.print( enc.getCWBC_TIPO_CAMBIO());
      out.write("\n");
      out.write("                        </th>\n");
      out.write("\n");
      out.write("                        <th class=\"text-center\" >\n");
      out.write("                            Fecha Tipo Cambio: ");
      out.print( enc.getCWBC_TIPO_CAMBIO_FECHA().substring(0, 10));
      out.write("\n");
      out.write("                        </th>\n");
      out.write("\n");
      out.write("                        <th class=\"text-center\" >\n");
      out.write("                            Grabador:  ");
      out.print( enc.getGRABADOR());
      out.write("\n");
      out.write("                        </th>\n");
      out.write("\n");
      out.write("                        <th class=\"text-center\" >\n");
      out.write("                            Usuario Servicio: ");
      out.print( enc.getCWBC_USUARIO_SERVICIO());
      out.write("\n");
      out.write("                        </th>\n");
      out.write("                        \n");
      out.write("                        <th class=\"text-center\" >\n");
      out.write("                           Codigo Usuario: ");
      out.print( enc.getCWBC_CODIGO_USUARIO());
      out.write("\n");
      out.write("                           dias = ");
      out.print( enc.getCWBC_HORA());
      out.write("\n");
      out.write("                        </th>\n");
      out.write("                    </tr>                               \n");
      out.write("\n");
      out.write("                </thead> \n");
      out.write("                \n");
      out.write("\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("                        \n");
      out.write("                        <div class=\"container\">\n");
      out.write("            <div class=\"col s12\">\n");
      out.write("\n");
      out.write("                <table id=\"table_id\" border=\"1\"   class=\"highlight responsive-table striped \" >\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <th>CODIGO</th>\n");
      out.write("                            <th>CANTIDAD</th>\n");
      out.write("                            <th>VALOR</th>\n");
      out.write("                            <th>SUB_TOTAL</th>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");


                            LinkedList<BeanDetalleCotizacion> lista = DetalleCotizacion.ObtenerDatos2(Cotizacion);

                            for (int i = 0; i < lista.size(); i++) {

                                out.println("<tr>");

                                out.println("<td>" + lista.get(i).getWDC_TDS_CODIGO()+ "</td>");
                                out.println("<td>" + lista.get(i).getCWDC_CANTIDAD() + "</td>");
                                out.println("<td>" + lista.get(i).getCWDC_VALOR()+ "</td>");
                                out.println("<td>" + lista.get(i).getCWDC_SUB_TOTAL()+ "</td>");
                                
                                
                                out.println("</tr>");
                            }
                        
      out.write("  \n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                        \n");
      out.write("                       \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"javascript\">\n");
      out.write("                                var dd = hoy.getDate();\n");
      out.write("                                var mm = hoy.getMonth() + 1;\n");
      out.write("                                var yyyy = hoy.getFullYear();\n");
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
