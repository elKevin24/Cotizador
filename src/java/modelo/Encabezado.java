package modelo;

import controlador.BeanEncabezado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Encabezado {

    public static boolean agregarEncabezado(BeanEncabezado En) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.CW_BUQUE_COTIZA (CWBC_COTIZACION, CWBC_LR, CWBC_SENAL_DISTINTIVA, CWBC_ETA, CWBC_TIPO_CAMBIO, CWBC_TIPO_CAMBIO_FECHA, CWBC_USUARIO_SERVICIO) VALUES ('"+ En.getCWBC_COTIZACION()+"','"+En.getCWBC_LR()+"','"+En.getCWBC_SENAL_DISTINTIVA()+"',TO_DATE('"+En.getCWBC_ETA()+"', 'YYYY-MM-DD'),"+En.getCWBC_TIPO_CAMBIO()+" ,TO_DATE('"+En.getCWBC_TIPO_CAMBIO_FECHA()+"','YYYY-MM-DD' ),'"+En.getCWBC_USUARIO_SERVICIO()+"' )";

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

    public static BeanEncabezado ObtenerCotizacion(String id) {

        BeanEncabezado user = new BeanEncabezado();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT NVL(MAX(CWBC_COTIZACION), '1') COTIZACION FROM CW_BUQUE_COTIZA")) {
                    while (rs.next()) {
                        user.setCWBC_COTIZACION(rs.getString("COTIZACION"));
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;

    }

    public static BeanEncabezado CotizacionGeneral(String id) {

        BeanEncabezado user = new BeanEncabezado();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT CWBC_COTIZACION, CWBC_LR, CWBC_SENAL_DISTINTIVA,CWBC_ETA, CWBC_TIPO_CAMBIO FROM CW_BUQUE_COTIZA WHERE LR = " + id + " ")) {
                    while (rs.next()) {
                        user.setCWBC_COTIZACION(rs.getString("COTIZACION"));
                        user.setCWBC_LR(rs.getString("CWBC_LR"));
                        user.setCWBC_SENAL_DISTINTIVA(rs.getString("CWBC_SENAL_DISTINTIVA"));
                        user.setCWBC_ETA(rs.getString("CWBC_ETA"));
                        user.setCWBC_TIPO_CAMBIO(rs.getDouble("CWBC_TIPO_CAMBIO"));
                        
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;

    }

    public static LinkedList<BeanEncabezado> CotizacionesBarco(String id) throws SQLException {
        LinkedList<BeanEncabezado> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("SELECT CWBC_COTIZACION,CWBC_LR, CWBC_SENAL_DISTINTIVA, CWBC_ETA, CWBC_TIPO_CAMBIO FROM  CW_BUQUE_COTIZA WHERE CWBC_LR = '" + id + "' ORDER BY CWBC_COTIZACION")) {
                    while (rs.next()) {
                        BeanEncabezado user = new BeanEncabezado();
                        user.setCWBC_COTIZACION(rs.getString("CWBC_COTIZACION"));
                        user.setCWBC_LR(rs.getString("CWBC_LR"));
                        user.setCWBC_SENAL_DISTINTIVA(rs.getString("CWBC_SENAL_DISTINTIVA"));
                        user.setCWBC_ETA(rs.getString("CWBC_ETA"));
                        user.setCWBC_TIPO_CAMBIO(rs.getDouble("CWBC_TIPO_CAMBIO"));

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
