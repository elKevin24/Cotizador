package modelo;


import controlador.BeanDetalleCotizacion;
import controlador.BeanEncabezado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DetalleCotizacion {

    public static BeanDetalleCotizacion ObtenerDetalle(String Cotizacion) {
        BeanDetalleCotizacion user = new BeanDetalleCotizacion();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT COTIZADOR_WEB.F_CW_TARIFA_X_COTIZACION("+ Cotizacion +","+ Cotizacion+", "+ Cotizacion+", "+ Cotizacion+", "+ Cotizacion+") from dual")) {
                    while (rs.next()) {
                        
                       
                        

                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;
    }
    
    public static BeanDetalleCotizacion ObtenerDatos(String Cotizacion) {
        BeanDetalleCotizacion user = new BeanDetalleCotizacion();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("select CWDC_CORRELATIVO, cwdc_cantidad, cwdc_tds_codigo, cwdc_valor, cwdc_sub_total from cw_detalle_cotizacion WHERE = "+ Cotizacion+"")) {
                    while (rs.next()) {
                        user.setCWDC_CORRELATIVO(rs.getString("CWDC_CORRELATIVO"));
                        user.setCWDC_CANTIDAD(rs.getString("cwdc_cantidad"));
                        user.setWDC_TDS_CODIGO(rs.getString("cwdc_tds_codigo"));
                        user.setCWDC_VALOR(rs.getString("cwdc_valor"));
                        user.setCWDC_SUB_TOTAL(rs.getString("cwdc_sub_total"));
                       
                        

                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;
    }
    
    public static LinkedList<BeanDetalleCotizacion> ObtenerDatos2(String id) throws SQLException {
        LinkedList<BeanDetalleCotizacion> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("select CWDC_CORRELATIVO, cwdc_cantidad, cwdc_tds_codigo, cwdc_valor, cwdc_sub_total from cw_detalle_cotizacion WHERE CWBC_COTIZACION = "+id+"")) {
                    while (rs.next()) {
                        BeanDetalleCotizacion user = new BeanDetalleCotizacion();
                        user.setCWDC_CORRELATIVO(rs.getString("CWDC_CORRELATIVO"));
                        user.setCWDC_CANTIDAD(rs.getString("cwdc_cantidad"));
                        user.setWDC_TDS_CODIGO(rs.getString("cwdc_tds_codigo"));
                        user.setCWDC_VALOR(rs.getString("cwdc_valor"));
                        user.setCWDC_SUB_TOTAL(rs.getString("cwdc_sub_total"));
                       

                        datos.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }

        return datos;
    }

    
    
    
}
