package modelo;


import controlador.BeanDetalleCotizacion;

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

                try (ResultSet rs = st.executeQuery("SELECT\n" +
"    c.cwdc_correlativo,\n" +
"    c.cwdc_cantidad,  \n" +
"    C.cwdc_tds_codigo,\n" +
"    c.cwdc_valor,  \n" +
"    c.cwdc_dias,\n" +
"    c.cwdc_sub_total,\n" +
"    nvl(c.cwdc_descuento,0) cwdc_descuento ,\n" +
"    A.descripcion,\n" +
"    A.valor_quetzal,\n" +
"    A.factor_ajuste,\n" +
"  \n" +
"    b.referencia,\n" +
"    b.descripcion\n" +
"    \n" +
"FROM\n" +
"    financiero.asft_tarifas_de_servicios A, financiero.asft_unidades_de_medida B, cotizador_web.cw_detalle_cotizacion C\n" +
"    WHERE a.unidad_medida = b.codigo\n" +
"    AND a.codigo = C.cwdc_tds_codigo\n" +
"    AND C.CWBC_COTIZACION = "+id+""
        + "order by cwdc_correlativo")) {
                    while (rs.next()) {
                        BeanDetalleCotizacion user = new BeanDetalleCotizacion();
                        user.setCWDC_CORRELATIVO(rs.getString("cwdc_correlativo"));
                        user.setCWDC_CANTIDAD(rs.getString("cwdc_cantidad"));
                        user.setWDC_TDS_CODIGO(rs.getString("cwdc_tds_codigo"));
                        user.setCWDC_VALOR(rs.getString("cwdc_valor"));
                        user.setCWDC_SUB_TOTAL(rs.getString("cwdc_sub_total"));
                        user.setDESCUENTO(rs.getString("cwdc_descuento"));
                        user.setDESCRIPCION(rs.getString("descripcion"));
                        user.setVALOR_QUETZAL(rs.getString("valor_quetzal"));
                        user.setFACTOR_AJUSTE(rs.getString("factor_ajuste"));
                        user.setREFERENCIA_UNIDAD_MEDIDA(rs.getString("referencia"));
                        user.setDESCRIPCION_UNIDAD_MEDIDA(rs.getString("descripcion"));
                        
                       

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
