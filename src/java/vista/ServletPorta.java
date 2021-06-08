/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanEncabezado;
import controlador.BeanPorta;
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
import modelo.Detalle_P;
import modelo.Encabezado;

/**
 *
 * @author nichodeveloper
 */
@WebServlet(name = "ServlePorta", urlPatterns = {"/ServlePorta.do"})
public class ServletPorta extends HttpServlet {

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
        String MuellajeExport = "S";
        String Muellaje = request.getParameter("Muellaje");

        String Muellaje1;

        if (Muellaje != null) {
            Muellaje1 = "S";
        } else {
            Muellaje1 = "N";

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
        String CWSF_REEMBARQUE_LLENO_RF_GB = request.getParameter("CWSF_REEMBARQUE_LLENO_RF_GB");
        String CWSF_REEMBARQUE_LLENO_RF_GP = request.getParameter("CWSF_REEMBARQUE_LLENO_RF_GP");
        String CWSF_REEMBARQUE_VACIO_GB = request.getParameter("CWSF_REEMBARQUE_VACIO_GB");
        String CWSF_REEMBARQUE_VACIO_GP = request.getParameter("CWSF_REEMBARQUE_VACIO_GP");

        String CWSF_DEPOSITO_MOMENT_GB = request.getParameter("CWSF_DEPOSITO_MOMENT_GB");
        String CWSF_DEPOSITO_MOMENT_GP = request.getParameter("CWSF_DEPOSITO_MOMENT_GP");
        String timport = request.getParameter("timport");
        String texport = request.getParameter("texport");

        String GRABADOR = request.getParameter("GRABADOR");

        BeanPorta busuario = new BeanPorta(CWBC_COTIZACION,
                Muellaje1, MuellajeExport,
                CWSF_DESCARGA_LLENOS_GB_VI, CWSF_DESCARGA_LLENOS_GB_VD, CWSF_DESCARGA_LLENOS_GP_VI, CWSF_DESCARGA_LLENOS_GP_VD,
                CWSF_DESCARGA_VACIOS_GB_VI, CWSF_DESCARGA_VACIOS_GB_VD, CWSF_DESCARGA_VACIOS_GP_VI, CWSF_DESCARGA_VACIOS_GP_VD,
                CWSF_CARGA_LLENOS_GB_VI, CWSF_CARGA_LLENOS_GB_VD, CWSF_CARGA_LLENOS_GP_VI, CWSF_CARGA_LLENOS_GP_VD,
                CWSF_CARGA_VACIOS_GB_VI, CWSF_CARGA_VACIOS_GB_VD, CWSF_CARGA_VACIOS_GP_VI, CWSF_CARGA_VACIOS_GP_VD,
                CWSF_DESCARGA_VEHICULOS_GB, CWSF_DESCARGA_VEHICULOS_GP,
                CWSF_REESTIBAS_GB, CWSF_REESTIBAS_GP,
                CWSF_TAPA_ESCOTILLAS_GB, CWSF_TAPA_ESCOTILLAS_GP,
                CWSF_DEPOSITO_TEMP_LLENO_GB, CWSF_DEPOSITO_TEMP_LLENO_GP, CWSF_DEPOSITO_TEMP_VACIO_GB, CWSF_DEPOSITO_TEMP_VACIO_GP,
                CWSF_REEMBARQUE_LLENO_GB, CWSF_REEMBARQUE_LLENO_RF_GB, CWSF_REEMBARQUE_LLENO_GP, CWSF_REEMBARQUE_LLENO_RF_GP, CWSF_REEMBARQUE_VACIO_GB, CWSF_REEMBARQUE_VACIO_GP,
                CWSF_DEPOSITO_MOMENT_GP, CWSF_DEPOSITO_MOMENT_GB,
                GRABADOR, GRABADOR, timport, texport);

        String sw = Detalle_P.agregarDetalle(busuario);

        PrintWriter out = response.getWriter();
        out.println(CWBC_COTIZACION + Muellaje1 + MuellajeExport + CWSF_DESCARGA_LLENOS_GB_VI + CWSF_DESCARGA_LLENOS_GB_VD + CWSF_DESCARGA_LLENOS_GP_VI + CWSF_DESCARGA_LLENOS_GP_VD);

        if (sw.equalsIgnoreCase("bien")) {

            BeanEncabezado enc = new BeanEncabezado();
            enc = Encabezado.Cotizacion(CWBC_COTIZACION);

            try {
                Conexion c = new Conexion();
                Connection con = c.getConexion();
                Statement st;
                st = con.createStatement();
                
                
                String sql = "SELECT COTIZADOR_WEB.F_CW_TARIFA_X_COTIZACION(" + CWBC_COTIZACION + ",'" + enc.getGRABADOR() + "', TO_DATE('" + enc.getCWBC_TIPO_CAMBIO_FECHA().substring(0, 10) + "','YYYY-MM-DD') , " + enc.getCWBC_HORA() + ", " + enc.getCWBC_CODIGO_USUARIO() + ") from dual";
                 System.err.println("sql detalle portacontenedro"+sql);
                st.execute(sql);
            } catch (SQLException e) {
                System.err.println("ERROR"+e);

            }
            response.sendRedirect("Detalle.jsp?Cotizacion=" + CWBC_COTIZACION + "");

        } else {

            out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud." + sw);
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
