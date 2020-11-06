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
import controlador.BeanMultiFrigo;
import modelo.Detalle_MF;
/**
 *
 * @author nichodeveloper
 */
@WebServlet(name = "ServleMultiFrigo", urlPatterns = {"/ServleMultiFrigo.do"})
public class ServletMultiFrigo extends HttpServlet {

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
        
        
        
            
            
            
            
            
        String Muellaje = request.getParameter("Muellaje");
        String CWBC_COTIZACION = request.getParameter("CWSF_COTIZACION");
        String Muellaje1;
        
        if(Muellaje!=null){
            Muellaje1 = "1";
        }else{
            Muellaje1 = "0";
            
        }
        
        
       
        
         
        BeanMultiFrigo busuario;
        busuario = new BeanMultiFrigo(CWBC_COTIZACION, Muellaje1, Muellaje1);
        
        //String nombre, String num_convenio, String descripcion, 
           //BigDecimal monto_total, String direccion, String id_municipio, String fecha, String id_tipo_proyecto
        boolean sw = Detalle_MF.agregarDetalleMF(busuario);

        PrintWriter out = response.getWriter();
        out.println( CWBC_COTIZACION  + Muellaje1 + Muellaje1);

        if (sw) {
            response.sendRedirect("Guardado.jsp");

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
