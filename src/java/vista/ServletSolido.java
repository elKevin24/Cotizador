/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanSolido;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Detalle_S;

/**
 *
 * @author nichodeveloper
 */
@WebServlet(name = "ServleSolido", urlPatterns = {"/ServleSolido.do"})
public class ServletSolido extends HttpServlet {

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

        String Muellaje1;

        if (Muellaje != null) {
            Muellaje1 = "1";
        } else {
            Muellaje1 = "0";

        }

        String CWSL_COTIZACION = request.getParameter("CWSL_COTIZACION");
        String CWSL_DESC_ACEITE_GRASA_QUIMI = request.getParameter("CWSL_DESC_ACEITE_GRASA_QUIMI");
        String CWSL_CARGA_ACEITE_GRASA_QUIMI = request.getParameter("CWSL_CARGA_ACEITE_GRASA_QUIMI");
       
        String CWSL_DESC_COMBUSTIBLES_DERIV = request.getParameter("CWSL_DESC_COMBUSTIBLES_DERIV");
        String CWSL_CARGA_COMBUSTIBLES_DERIV = request.getParameter("CWSL_CARGA_COMBUSTIBLES_DERIV");
       
        
        
       
        String GRABADOR = request.getParameter("GRABADOR");
        

        BeanSolido busuario = new BeanSolido(CWSL_COTIZACION, CWSL_DESC_ACEITE_GRASA_QUIMI, CWSL_CARGA_ACEITE_GRASA_QUIMI,
              CWSL_DESC_COMBUSTIBLES_DERIV, CWSL_CARGA_COMBUSTIBLES_DERIV, 
             GRABADOR);

           boolean sw = Detalle_S.agregarDetalle(busuario);

        PrintWriter out = response.getWriter();
        out.println(CWSL_COTIZACION +  CWSL_DESC_ACEITE_GRASA_QUIMI+ CWSL_DESC_COMBUSTIBLES_DERIV+
            CWSL_CARGA_ACEITE_GRASA_QUIMI+ CWSL_CARGA_COMBUSTIBLES_DERIV+ 
             GRABADOR);

        if (sw) {
            response.sendRedirect("Detalle.jsp?Cotizacion="+CWSL_COTIZACION+"");

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
