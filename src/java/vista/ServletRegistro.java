/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controlador.BeanEncabezado;
import controlador.BeanUsuarios;
import java.math.BigDecimal;
import java.sql.Date;
import modelo.Encabezado;
import modelo.Usuario;
/**
 *
 * @author nichodeveloper
 */
@WebServlet(name = "ServletRegistro", urlPatterns = {"/ServletRegistro.do"})
public class ServletRegistro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        
            
            
            
            
            
        String CWBC_COTIZACION = request.getParameter("CWBC_COTIZACION");
        String LR = request.getParameter("LR");
        String CWBC_SENAL_DISTINTIVA = request.getParameter("CWBC_SENAL_DISTINTIVA");
        String CWBC_ETA = request.getParameter("CWBC_ETA");
        String CWBC_TIPO_CAMBIO_FECHA = request.getParameter("CWBC_TIPO_CAMBIO_FECHA");
        String CWBC_USUARIO_SERVICIO = request.getParameter("CWBC_USUARIO_SERVICIO");
        String CWBC_NIT = request.getParameter("CWBC_NIT");
        String CWBC_TIPO_OPERACION = request.getParameter("Tipo");
        String GRABADOR = request.getParameter("GRABADOR");
       
        
        BeanUsuarios cambio = new BeanUsuarios();
            cambio = Usuario.ObtenerCambioDolar();
        
        int Cotizacion = Integer.parseInt(CWBC_COTIZACION);
        Cotizacion = Cotizacion + 1;
        CWBC_COTIZACION = String.valueOf(Cotizacion);
         
        BeanEncabezado busuario;
        busuario = new BeanEncabezado(CWBC_COTIZACION, LR, CWBC_SENAL_DISTINTIVA, CWBC_ETA, cambio.getCAMBIO(), CWBC_TIPO_CAMBIO_FECHA.substring(0, 10), CWBC_USUARIO_SERVICIO, CWBC_NIT, CWBC_TIPO_OPERACION, GRABADOR);
        
        //String nombre, String num_convenio, String descripcion, 
           //BigDecimal monto_total, String direccion, String id_municipio, String fecha, String id_tipo_proyecto
        boolean sw = Encabezado.agregarEncabezado(busuario);

        PrintWriter out = response.getWriter();
        out.println( CWBC_COTIZACION  + LR + CWBC_SENAL_DISTINTIVA + CWBC_ETA+  cambio.getCAMBIO() +  CWBC_TIPO_CAMBIO_FECHA.substring(0, 10)+CWBC_USUARIO_SERVICIO+ CWBC_NIT+ "tipo operacion: "+ CWBC_TIPO_OPERACION);

        if (sw) {
            response.sendRedirect("Guardado.jsp?LR="+LR+"");

        } else {

            out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
