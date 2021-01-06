/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanEncabezado;
import controlador.BeanLiquido;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexion;
import modelo.Detalle_L;
import modelo.Encabezado;

/**
 *
 * @author nichodeveloper
 */
@WebServlet(name = "ServleLiquido", urlPatterns = {"/ServleLiquido.do"})
public class ServletLiquido extends HttpServlet {

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
        String CWSL_DESC_COMBUSTIBLES_DERIV = request.getParameter("CWSL_DESC_COMBUSTIBLES_DERIV");
        String CWSL_DESC_GAS_PROPANO = request.getParameter("CWSL_DESC_GAS_PROPANO");
        String CWSL_CARGA_ACEITE_GRASA_QUIMI = request.getParameter("CWSL_CARGA_ACEITE_GRASA_QUIMI");
        String CWSL_CARGA_COMBUSTIBLES_DERIV = request.getParameter("CWSL_CARGA_COMBUSTIBLES_DERIV");
        String CWSL_CARGA_GAS_PROPANO = request.getParameter("CWSL_CARGA_GAS_PROPANO");
        String Tipo = request.getParameter("Tipo");
        
        
       
        String GRABADOR = request.getParameter("GRABADOR");
        

        BeanLiquido busuario = new BeanLiquido(CWSL_COTIZACION, CWSL_DESC_ACEITE_GRASA_QUIMI, CWSL_DESC_COMBUSTIBLES_DERIV,
            CWSL_DESC_GAS_PROPANO,  CWSL_CARGA_ACEITE_GRASA_QUIMI, CWSL_CARGA_COMBUSTIBLES_DERIV,CWSL_CARGA_GAS_PROPANO, 
             GRABADOR);

           boolean sw = Detalle_L.agregarDetalle(busuario);

        PrintWriter out = response.getWriter();
        out.println(CWSL_COTIZACION +  CWSL_DESC_ACEITE_GRASA_QUIMI+ CWSL_DESC_COMBUSTIBLES_DERIV+
            CWSL_DESC_GAS_PROPANO+  CWSL_CARGA_ACEITE_GRASA_QUIMI+ CWSL_CARGA_COMBUSTIBLES_DERIV+CWSL_CARGA_GAS_PROPANO+ 
             GRABADOR);

        if (sw) {
            
            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.Cotizacion(CWSL_COTIZACION);

            try {
                Conexion c = new Conexion();
                Connection con = c.getConexion();
                Statement st;
                st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT COTIZADOR_WEB.F_CW_TARIFA_X_COTIZACION(" + CWSL_COTIZACION + ",'" + enc.getGRABADOR() + "', TO_DATE('" + enc.getCWBC_TIPO_CAMBIO_FECHA().substring(0, 10) + "','YYYY-MM-DD') , " + enc.getCWBC_HORA() + ", " + enc.getCWBC_CODIGO_USUARIO() + ") from dual");

            } catch (SQLException e) {

            }
           
            response.sendRedirect("GuardadoDetalle.jsp?Cotizacion="+CWSL_COTIZACION+"");

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
