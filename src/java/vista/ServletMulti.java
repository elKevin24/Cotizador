/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanMulti;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Detalle_M;

/**
 *
 * @author nichodeveloper
 */
@WebServlet(name = "ServleMulti", urlPatterns = {"/ServleMulti.do"})
public class ServletMulti extends HttpServlet {

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

        String CWBC_COTIZACION = request.getParameter("CWSF_COTIZACION");
        String CWSF_DESCARGA_LLENOS_GB_VI = request.getParameter("CWSF_DESCARGA_LLENOS_GB_VI");
        String CWSF_DESCARGA_LLENOS_GB_VD = request.getParameter("CWSF_DESCARGA_LLENOS_GB_VD");
        String CWSF_DESCARGA_LLENOS_GP_VI = request.getParameter("CWSF_DESCARGA_LLENOS_GP_VI");
        String CWSF_DESCARGA_LLENOS_GP_VD = request.getParameter("CWSF_DESCARGA_LLENOS_GP_VD");
        
        String CWSF_DESCARGA_VACIOS_GB_VI = request.getParameter("CWSF_DESCARGA_VACIOS_GB_VI");
        String CWSF_DESCARGA_VACIOS_GB_VD = request.getParameter("CWSF_DESCARGA_VACIOS_GB_VD");
        String CWSF_DESCARGA_VACIOS_GP_VI = request.getParameter("CWSF_DESCARGA_VACIOS_GP_VI");
        String CWSF_DESCARGA_VACIOS_GP_VD = request.getParameter("CWSF_DESCARGA_VACIOS_GP_VD");
        
        String CWSF_CARGA_LLENOS_GB_VI = request.getParameter("CWSF_CARGA_LLENOS_GB_VI");
        String CWSF_CARGA_LLENOS_GB_VD = request.getParameter("CWSF_CARGA_LLENOS_GB_VD");
        String CWSF_CARGA_LLENOS_GP_VI = request.getParameter("CWSF_CARGA_LLENOS_GP_VI");
        String CWSF_CARGA_LLENOS_GP_VD = request.getParameter("CWSF_CARGA_LLENOS_GP_VD");
        
        String CWSF_CARGA_VACIOS_GB_VI = request.getParameter("CWSF_CARGA_VACIOS_GB_VI");
        String CWSF_CARGA_VACIOS_GB_VD = request.getParameter("CWSF_CARGA_VACIOS_GB_VD");
        String CWSF_CARGA_VACIOS_GP_VI = request.getParameter("CWSF_CARGA_VACIOS_GP_VI");
        String CWSF_CARGA_VACIOS_GP_VD = request.getParameter("CWSF_CARGA_VACIOS_GP_VD");
        
        String CWSF_DESCARGA_VEHICULOS_GB = request.getParameter("CWSF_DESCARGA_VEHICULOS_GB");
        String CWSF_DESCARGA_VEHICULOS_GP = request.getParameter("CWSF_DESCARGA_VEHICULOS_GP");
        
        String CWSF_REESTIBAS_GB = request.getParameter("CWSF_REESTIBAS_GB");
        String CWSF_REESTIBAS_GP = request.getParameter("CWSF_REESTIBAS_GP");
        
        String CWSF_TAPA_ESCOTILLAS_GB = request.getParameter("CWSF_TAPA_ESCOTILLAS_GB");
        String CWSF_TAPA_ESCOTILLAS_GP = request.getParameter("CWSF_TAPA_ESCOTILLAS_GP");
        
        
        String CWSF_DEPOSITO_TEMP_LLENO_GB = request.getParameter("CWSF_DEPOSITO_TEMP_LLENO_GB");
        String CWSF_DEPOSITO_TEMP_LLENO_GP = request.getParameter("CWSF_DEPOSITO_TEMP_LLENO_GP");        
        String CWSF_DEPOSITO_TEMP_VACIO_GB = request.getParameter("CWSF_DEPOSITO_TEMP_VACIO_GB");
        String CWSF_DEPOSITO_TEMP_VACIO_GP = request.getParameter("CWSF_DEPOSITO_TEMP_VACIO_GP");
        
        String CWSF_REEMBARQUE_LLENO_GB = request.getParameter("CWSF_REEMBARQUE_LLENO_GB");
        String CWSF_REEMBARQUE_LLENO_GP = request.getParameter("CWSF_REEMBARQUE_LLENO_GP");
        String CWSF_REEMBARQUE_VACIO_GB = request.getParameter("CWSF_REEMBARQUE_VACIO_GB");
        String CWSF_REEMBARQUE_VACIO_GP = request.getParameter("CWSF_REEMBARQUE_VACIO_GP");
        
        String CWSF_DEPOSITO_MOMENT_LLENO_GB = request.getParameter("CWSF_DEPOSITO_MOMENT_LLENO_GB");
        String CWSF_DEPOSITO_MOMENT_LLENO_GP = request.getParameter("CWSF_DEPOSITO_MOMENT_LLENO_GP");
        String CWSF_DEPOSITO_MOMENT_VACIO_GB = request.getParameter("CWSF_DEPOSITO_MOMENT_VACIO_GB");
        String CWSF_DEPOSITO_MOMENT_VACIO_GP = request.getParameter("CWSF_DEPOSITO_MOMENT_VACIO_GP");
        
        String CWSF_DESCARGA_MERCA_GB_VD = request.getParameter("CWSF_DESCARGA_MERCA_GB_VD");
        String CWSF_DESCARGA_MERCA_GB_VI = request.getParameter("CWSF_DESCARGA_MERCA_GB_VI");
        String CWSF_DESCARGA_MERCA_GP_VD = request.getParameter("CWSF_DESCARGA_MERCA_GP_VD");
        String CWSF_DESCARGA_MERCA_GP_VI = request.getParameter("CWSF_DESCARGA_MERCA_GP_VI");
        
        String CWSF_CARGA_MERCA_GB_VD = request.getParameter("CWSF_CARGA_MERCA_GB_VD");
        String CWSF_CARGA_MERCA_GB_VI = request.getParameter("CWSF_CARGA_MERCA_GB_VI");
        String CWSF_CARGA_MERCA_GP_VD = request.getParameter("CWSF_CARGA_MERCA_GP_VD");
        String CWSF_CARGA_MERCA_GP_VI = request.getParameter("CWSF_CARGA_MERCA_GP_VI");
        
//        String CWSF_CARGA_FRUTA_PALE_GB_VD = request.getParameter("CWSF_CARGA_FRUTA_PALE_GB_VD");
//        String CWSF_CARGA_FRUTA_PALE_GB_VI = request.getParameter("CWSF_CARGA_FRUTA_PALE_GB_VI");
//        String CWSF_CARGA_FRUTA_PALE_GP_VD = request.getParameter("CWSF_CARGA_FRUTA_PALE_GP_VD");
//        String CWSF_CARGA_FRUTA_PALE_GP_VI = request.getParameter("CWSF_CARGA_FRUTA_PALE_GP_VI");
        String GRABADOR = request.getParameter("GRABADOR");
        //String GRABADOR_FECHA = request.getParameter("GRABADOR_FECHA");
        //String ACTUALIZADOR = request.getParameter("ACTUALIZADOR");
        //String ACTUALIZADOR_FECHA = request.getParameter("ACTUALIZADOR_FECHA");
        
        

        BeanMulti busuario = new BeanMulti(CWBC_COTIZACION, Muellaje1, Muellaje1,  CWSF_DESCARGA_LLENOS_GB_VI,  CWSF_DESCARGA_LLENOS_GB_VD,  CWSF_DESCARGA_LLENOS_GP_VI,
             CWSF_DESCARGA_LLENOS_GP_VD,  CWSF_DESCARGA_VACIOS_GB_VI,  CWSF_DESCARGA_VACIOS_GB_VD,  CWSF_DESCARGA_VACIOS_GP_VI,  CWSF_DESCARGA_VACIOS_GP_VD,
             CWSF_CARGA_LLENOS_GB_VI,  CWSF_CARGA_LLENOS_GB_VD,  CWSF_CARGA_LLENOS_GP_VI,  CWSF_CARGA_LLENOS_GP_VD,  CWSF_CARGA_VACIOS_GB_VI,  CWSF_CARGA_VACIOS_GB_VD,  CWSF_CARGA_VACIOS_GP_VI,
             CWSF_CARGA_VACIOS_GP_VD,  CWSF_DESCARGA_VEHICULOS_GB,  CWSF_DESCARGA_VEHICULOS_GP,  CWSF_REESTIBAS_GB,  CWSF_REESTIBAS_GP,  CWSF_TAPA_ESCOTILLAS_GB,  CWSF_TAPA_ESCOTILLAS_GP,
             CWSF_DEPOSITO_TEMP_LLENO_GB,  CWSF_DEPOSITO_TEMP_LLENO_GP,  CWSF_DEPOSITO_TEMP_VACIO_GB,  CWSF_DEPOSITO_TEMP_VACIO_GP,  CWSF_REEMBARQUE_LLENO_GB,  CWSF_REEMBARQUE_LLENO_GP,  CWSF_REEMBARQUE_VACIO_GB,
             CWSF_REEMBARQUE_VACIO_GP,  CWSF_DEPOSITO_MOMENT_LLENO_GB,  CWSF_DEPOSITO_MOMENT_LLENO_GP,  CWSF_DEPOSITO_MOMENT_VACIO_GB,  CWSF_DEPOSITO_MOMENT_VACIO_GP,
             CWSF_DESCARGA_MERCA_GB_VD,  CWSF_DESCARGA_MERCA_GB_VI,  CWSF_DESCARGA_MERCA_GP_VD,  CWSF_DESCARGA_MERCA_GP_VI,  CWSF_CARGA_MERCA_GB_VD,  CWSF_CARGA_MERCA_GB_VI,
             CWSF_CARGA_MERCA_GP_VD,  CWSF_CARGA_MERCA_GP_VI,  
             GRABADOR);

           boolean sw = Detalle_M.agregarDetalle(busuario);

        PrintWriter out = response.getWriter();
        out.println(CWBC_COTIZACION + Muellaje1 + Muellaje1 + CWSF_DESCARGA_LLENOS_GB_VI+ CWSF_DESCARGA_LLENOS_GB_VD+ CWSF_DESCARGA_LLENOS_GP_VI+ CWSF_DESCARGA_LLENOS_GP_VD);

        if (sw) {
            response.sendRedirect("Detalle.jsp?Cotizacion="+CWBC_COTIZACION+"");

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
