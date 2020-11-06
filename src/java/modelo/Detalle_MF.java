package modelo;

import controlador.BeanMultiFrigo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Detalle_MF {

    public static boolean agregarDetalleMF(BeanMultiFrigo En) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.CW_SRV_MULTIPROPOSITOS_FRIGO (CWSF_COTIZACION, CWSF_MUELLAJE_COF_IMPORT, CWSF_MUELLAJE_COF_EXPORT) VALUES ('" + En.getCWBC_COTIZACION() + "', '" + En.getCWSF_MUELLAJE_COF_IMPORT() + "' ,'" + En.getCWSF_MUELLAJE_COF_EXPORT() + "')";

//    "INSERT INTO COTIZADOR_WEB.CW_BUQUE_COTIZA (CWBC_COTIZACION, CWBC_LR, CWBC_SENAL_DISTINTIVA, CWBC_BUQUE_VIAJE, CWBC_ETA, CWBC_TIPO_CAMBIO, CWBC_TIPO_CAMBIO_FECHA, CWBC_USUARIO_SERVICIO, CWBC_NIT, CWBC_TIPO_OPERACION, GRABADOR) \n" +
//"                                        VALUES ('"+En.getCWBC_COTIZACION()+"','"+En.getCWBC_LR()+"','"+En.getCWBC_BUQUE_VIAJE()+"','"+En.getCWBC_ETA()+"','"+En.getCWBC_TIPO_CAMBIO()+"','"+En.getCWBC_TIPO_CAMBIO_FECHA()+"','"+En.getCWBC_USUARIO_SERVICIO()+"','"+En.getCWBC_NIT()+"','"+En.getCWBC_TIPO_OPERACION()+"','"+En.getCWBC_GRABADOR()+"')";
                System.out.println(sql);
                st.execute(sql);

                agregado = true;
                st.close();
            }

        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }

    public static BeanMultiFrigo CotizacionGeneral(String id) {

        BeanMultiFrigo user = new BeanMultiFrigo();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("select * from \n" +
"cw_srv_multipropositos_frigo\n" +
"where cwsf_cotizacion = "+id+"")) {
                    while (rs.next()) {
                        user.setCWBC_COTIZACION(rs.getString("CWBC_COTIZACION"));
                        user.setCWSF_MUELLAJE_COF_EXPORT(rs.getString("CWSF_MUELLAJE_COF_EXPORT"));
                        user.setCWSF_MUELLAJE_COF_IMPORT(rs.getString("CWSF_MUELLAJE_COF_IMPORT"));
                        

                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;

    }

    public static LinkedList<BeanMultiFrigo> CotizacionesBarco(String id) throws SQLException {
        LinkedList<BeanMultiFrigo> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("SELECT CWBC_COTIZACION, cwbc_lr, cwbc_senal_distintiva, cwbc_eta, cwbc_tipo_cambio, cwbc_tipo_cambio_fecha,  cwto_operacion  FROM\n"
                        + "CW_BUQUE_COTIZA , CW_TIPO_OPERACION \n"
                        + "where CWBC_TIPO_OPERACION = CWTO_TIPO_OPERACION\n"
                        + "AND CWBC_LR ='" + id + "' ORDER BY CWBC_COTIZACION")) {
                    while (rs.next()) {
                        BeanMultiFrigo user = new BeanMultiFrigo();
                        user.setCWBC_COTIZACION(rs.getString("CWBC_COTIZACION"));
                       

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
