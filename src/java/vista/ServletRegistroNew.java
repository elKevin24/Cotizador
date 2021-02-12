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

import controlador.BeanBarcosNuevo;
import modelo.BarcosNuevo;

/**
 *
 * @author nichodeveloper
 */
@WebServlet(name = "ServletRegistroNew", urlPatterns = {"/ServletRegistroNew.do"})
public class ServletRegistroNew extends HttpServlet {

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
        
     
        String LR = request.getParameter("LR");
        String SENAL_DISTINTIVA = request.getParameter("SENAL_DISTINTIVA");
        String TIPO_DE_BARCO_POR_ESTRUCTURA = request.getParameter("TIPO_DE_BARCO_POR_ESTRUCTURA");
        String USUARIO_DE_SERVICIO = request.getParameter("USUARIO_DE_SERVICIO");
        String NOMBRE_DEL_BUQUE = request.getParameter("NOMBRE_DEL_BUQUE");
        String BANDERA = request.getParameter("BANDERA");
        String TRB = request.getParameter("TRB");
        String TRN = request.getParameter("TRN");
        String TPM = request.getParameter("TPM");
        String CALADO = request.getParameter("CALADO");
        String ESLORA = request.getParameter("ESLORA");
        String MANGA = request.getParameter("MANGA");
        String BITA_USUARIO_INSERTA = request.getParameter("BITA_USUARIO_INSERTA");
        String BITA_FECHA_INSERTA = request.getParameter("CWBC_HORA");
        
  
        
        
         
        BeanBarcosNuevo busuario;
        busuario = new BeanBarcosNuevo(LR, SENAL_DISTINTIVA, TIPO_DE_BARCO_POR_ESTRUCTURA, USUARIO_DE_SERVICIO, NOMBRE_DEL_BUQUE, BANDERA, TRB, TRN, TPM, CALADO, ESLORA, MANGA, BITA_USUARIO_INSERTA);
        
        //String nombre, String num_convenio, String descripcion, 
           //BigDecimal monto_total, String direccion, String id_municipio, String fecha, String id_tipo_proyecto
        boolean sw = BarcosNuevo.agregarBarco(busuario);

        PrintWriter out = response.getWriter();
        out.println( "BITA_USUARIO_INSERTA: " + BITA_USUARIO_INSERTA +" SENAL_DISTINTIVA: " + SENAL_DISTINTIVA + " TIPO_DE_BARCO_POR_ESTRUCTURA: "+TIPO_DE_BARCO_POR_ESTRUCTURA+ " USUARIO_DE_SERVICIO: " + USUARIO_DE_SERVICIO +  " BANDERA: " + BANDERA);
        if (sw) {
            response.sendRedirect("BarcosNuevo.jsp");

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
