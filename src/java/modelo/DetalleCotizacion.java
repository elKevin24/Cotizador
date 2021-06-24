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
                try (ResultSet rs = st.executeQuery("SELECT COTIZADOR_WEB.F_CW_TARIFA_X_COTIZACION(" + Cotizacion + "," + Cotizacion + ", " + Cotizacion + ", " + Cotizacion + ", " + Cotizacion + ") from dual")) {
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
                try (ResultSet rs = st.executeQuery("select CWDC_CORRELATIVO, cwdc_cantidad, cwdc_tds_codigo, cwdc_valor, cwdc_sub_total from COTIZADOR_WEB.cw_detalle_cotizacion WHERE = " + Cotizacion + "")) {
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

                try (ResultSet rs = st.executeQuery(" SELECT\n"
                        + "    SUM(A3.CWDC_SUB_TOTAL) CWDC_SUB_TOTAL,\n"
                        + "    SUM(A3.CWDC_CANTIDAD) CWDC_CANTIDAD,\n"
                        + "    A3.CWDC_TDS_CODIGO   CWDC_TDS_CODIGO,\n"
                        + "    A2.DESCRIPCION       DESCRIPCION,\n"
                        + "    A2.VALOR_QUETZAL     VALOR_QUETZAL,\n"
                        + "    A2.FACTOR_AJUSTE     FACTOR_AJUSTE,\n"
                        + "    A1.REFERENCIA        REFERENCIA,\n"
                        + "    A1.DESCRIPCION       UNIDAD\n"
                        + "FROM\n"
                        + "    COTIZADOR_WEB.CW_DETALLE_COTIZACION    A3,\n"
                        + "    FINANCIERO.ASFT_TARIFAS_DE_SERVICIOS   A2,\n"
                        + "    FINANCIERO.ASFT_UNIDADES_DE_MEDIDA     A1\n"
                        + "WHERE\n"
                        + "    A3.CWBC_COTIZACION = " + id + "\n"
                        + "    AND A3.CWDC_TDS_CODIGO = A2.CODIGO\n"
                        + "    AND A2.UNIDAD_MEDIDA = A1.CODIGO\n"
                        + "    AND A2.IVA <> 'N'\n"
                        + "GROUP BY\n"
                        + "    A3.CWDC_TDS_CODIGO,\n"
                        + "    A2.DESCRIPCION,\n"
                        + "    A2.VALOR_QUETZAL,\n"
                        + "    A2.FACTOR_AJUSTE,\n"
                        + "    A1.REFERENCIA,\n"
                        + "    A1.DESCRIPCION\n"
                        + "ORDER BY\n"
                        + "    A3.CWDC_TDS_CODIGO ")) {
                    while (rs.next()) {
                        BeanDetalleCotizacion user = new BeanDetalleCotizacion();

                        user.setCWDC_SUB_TOTAL(rs.getString("CWDC_SUB_TOTAL"));
                        user.setCWDC_CANTIDAD(rs.getString("CWDC_CANTIDAD"));
                        user.setWDC_TDS_CODIGO(rs.getString("CWDC_TDS_CODIGO"));
                        user.setDESCRIPCION(rs.getString("DESCRIPCION"));
                        user.setFACTOR_AJUSTE(rs.getString("FACTOR_AJUSTE"));
                        user.setREFERENCIA_UNIDAD_MEDIDA(rs.getString("REFERENCIA"));
                        user.setDESCRIPCION_UNIDAD_MEDIDA(rs.getString("UNIDAD"));

                        datos.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
            System.out.println("" + e);
        }

        return datos;

    }

    public static LinkedList<BeanDetalleCotizacion> Noiva(String id) throws SQLException {
        LinkedList<BeanDetalleCotizacion> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("SELECT\n" +
"    A3.CWDC_SUB_TOTAL CWDC_SUB_TOTAL,\n" +
"    A3.CWDC_CANTIDAD CWDC_CANTIDAD,\n" +
"    A3.CWDC_TDS_CODIGO   CWDC_TDS_CODIGO,\n" +
"    A2.DESCRIPCION       DESCRIPCION,\n" +
"    A2.VALOR_QUETZAL     VALOR_QUETZAL,\n" +
"    A2.FACTOR_AJUSTE     FACTOR_AJUSTE,\n" +
"    A1.REFERENCIA        REFERENCIA,\n" +
"    A1.DESCRIPCION       UNIDAD\n" +
"FROM\n" +
"    COTIZADOR_WEB.CW_DETALLE_COTIZACION    A3,\n" +
"    FINANCIERO.ASFT_TARIFAS_DE_SERVICIOS   A2,\n" +
"    FINANCIERO.ASFT_UNIDADES_DE_MEDIDA     A1\n" +
"WHERE\n" +
"    A3.CWBC_COTIZACION = "+id+"\n" +
"    AND A3.CWDC_TDS_CODIGO = A2.CODIGO\n" +
"    AND A2.UNIDAD_MEDIDA = A1.CODIGO\n" +
"    AND A2.IVA = 'N'\n" +
"\n" +
"ORDER BY\n" +
"    A3.CWDC_TDS_CODIGO DESC")) {
                    while (rs.next()) {
                        BeanDetalleCotizacion user = new BeanDetalleCotizacion();

                        user.setCWDC_SUB_TOTAL(rs.getString("CWDC_SUB_TOTAL"));
                        user.setCWDC_CANTIDAD(rs.getString("CWDC_CANTIDAD"));
                        user.setWDC_TDS_CODIGO(rs.getString("CWDC_TDS_CODIGO"));
                        user.setDESCRIPCION(rs.getString("DESCRIPCION"));
                        user.setFACTOR_AJUSTE(rs.getString("FACTOR_AJUSTE"));
                        user.setREFERENCIA_UNIDAD_MEDIDA(rs.getString("REFERENCIA"));
                        user.setDESCRIPCION_UNIDAD_MEDIDA(rs.getString("UNIDAD"));
                        

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
