package modelo;

import controlador.BeanSolido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Detalle_S {

    public static boolean agregarDetalle(BeanSolido En) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.CW_SRV_GRANELES_SOLIDOS (CWSS_COTIZACION,"
                        + "CWSS_DESC_GRANEL_SOLIDO,"
                        + "CWSS_DESC_GRANEL_SOLIDO_PONTON,"
                        + "CWSS_CARGA_GRANEL_SOLIDO,"
                        + "CWSS_CARG_GRANEL_SOLIDO_PONTON,"
                        + "GRABADOR) VALUES ('" + En.getCWSL_COTIZACION() + "','" + En.getCWSL_DESC_ACEITE_GRASA_QUIMI() + "','" + En.getCWSL_DESC_COMBUSTIBLES_DERIV() + "','" + En.getCWSL_CARGA_ACEITE_GRASA_QUIMI() + "','" + En.getCWSL_CARGA_COMBUSTIBLES_DERIV() + "','" + En.getGRABADOR() + "')";

                st.execute(sql);

                agregado = true;
                st.close();
            }

        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }

    public static BeanSolido ObtenerDetalle(String Cotizacion) {
        BeanSolido user = new BeanSolido();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT CWSS_COTIZACION ,\n"
                        + "CWSS_DESC_GRANEL_SOLIDO ,\n"
                        + "CWSS_DESC_GRANEL_SOLIDO_PONTON ,\n"
                        + "CWSS_CARGA_GRANEL_SOLIDO ,\n"
                        + "CWSS_CARG_GRANEL_SOLIDO_PONTON ,\n"
                        + "GRABADOR FROM \n"
                        + "COTIZADOR_WEB.CW_SRV_GRANELES_SOLIDOS\n"
                        + "WHERE CWSS_COTIZACION = " + Cotizacion + "")) {
                    while (rs.next()) {
                        user.setCWSL_COTIZACION(rs.getString("CWSS_COTIZACION"));
                        user.setCWSL_DESC_ACEITE_GRASA_QUIMI(rs.getString("CWSS_DESC_GRANEL_SOLIDO"));
                        user.setCWSL_DESC_COMBUSTIBLES_DERIV(rs.getString("CWSS_DESC_GRANEL_SOLIDO_PONTON"));
                        user.setCWSL_CARGA_ACEITE_GRASA_QUIMI(rs.getString("CWSS_CARGA_GRANEL_SOLIDO"));
                        user.setCWSL_CARGA_COMBUSTIBLES_DERIV(rs.getString("CWSS_CARG_GRANEL_SOLIDO_PONTON"));
                        user.setGRABADOR(rs.getString("GRABADOR"));

                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;
    }

    public static BeanSolido Obtenerxedit(String id) {
        BeanSolido user = new BeanSolido();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    cwbc_hora,\n"
                        + "    cwbc_eta,\n"
                        + "    cwss_desc_granel_solido,\n"
                        + "    cwss_desc_granel_solido_ponton,\n"
                        + "    cwss_carga_granel_solido,\n"
                        + "    cwss_carg_granel_solido_ponton\n"
                        + "FROM\n"
                        + "    COTIZADOR_WEB.cw_buque_cotiza,\n"
                        + "    COTIZADOR_WEB.cw_srv_graneles_solidos\n"
                        + "WHERE\n"
                        + "    cwbc_cotizacion = cwss_cotizacion\n"
                        + "    AND cwss_cotizacion = " + id + "")) {
                    while (rs.next()) {

                        user.setCWBC_HORA(rs.getString("cwbc_hora"));
                        user.setCWBC_ETA(rs.getString("cwbc_eta"));
                        user.setCWSL_DESC_ACEITE_GRASA_QUIMI(rs.getString("cwss_desc_granel_solido"));
                        user.setCWSL_CARGA_COMBUSTIBLES_DERIV(rs.getString("cwss_carga_granel_solido"));

                        user.setCWSL_CARGA_ACEITE_GRASA_QUIMI(rs.getString("cwss_carg_granel_solido_ponton"));
                        user.setCWSL_DESC_COMBUSTIBLES_DERIV(rs.getString("cwss_desc_granel_solido_ponton"));

                    }
                }
                st.close();
            }
        } catch (SQLException e) {

        }
        return user;

    }

    public static String ActualizarDetalle(BeanSolido buque) {
        String actualizado = null;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {

                Statement st;
                st = con.createStatement();

                String sql = " update COTIZADOR_WEB.cw_srv_graneles_solidos SET"
                        + "    CWSS_DESC_GRANEL_SOLIDO = '" + buque.getCWSL_DESC_ACEITE_GRASA_QUIMI() + "',"
                        + "    CWSS_CARGA_GRANEL_SOLIDO = '" + buque.getCWSL_CARGA_ACEITE_GRASA_QUIMI() + "',"
                        + "    CWSS_DESC_GRANEL_SOLIDO_PONTON = '" + buque.getCWSL_DESC_COMBUSTIBLES_DERIV() + "',"
                        + "    CWSS_CARG_GRANEL_SOLIDO_PONTON = '" + buque.getCWSL_CARGA_COMBUSTIBLES_DERIV() + "'"
                        + "    where CWSS_COTIZACION = '" + buque.getCWSL_COTIZACION() + "'";

                //+ "CWSS_DESC_GRANEL_SOLIDO = '" + buque.getCWSL_DESC_ACEITE_GRASA_QUIMI() + "'"
                //      + "where CWSS_COTIZACION = '" + buque.getCWSL_COTIZACION() + "'";
                st.execute(sql);
                actualizado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            actualizado = "mal" + e + buque.getCWSL_DESC_ACEITE_GRASA_QUIMI();
        }

        return actualizado;
    }

    public static String Actualizar(BeanSolido buque) {
        String actualizado = null;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {

                Statement st;
                st = con.createStatement();
//                UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA
                String sql = "update COTIZADOR_WEB.CW_BUQUE_COTIZA set CWBC_ETA = TO_DATE('" + buque.getCWBC_ETA() + "', 'YYYY-MM-DD HH24:MI:SS'), CWBC_HORA='" + buque.getCWBC_HORA() + "'"
                        + "where CWBC_COTIZACION = '" + buque.getCWSL_COTIZACION() + "'";

                st.execute(sql);
                actualizado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            actualizado = "mal" + e + buque.getCWBC_HORA() + buque.getCWSL_COTIZACION();
        }

        return actualizado;
    }

    public static boolean EliminarDetalle(String id) {
        boolean actualizado = false;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA
                String sql = "DELETE FROM COTIZADOR_WEB.cw_detalle_cotizacion\n"
                        + "WHERE\n"
                        + "    cwbc_cotizacion =" + id + "";
                //"update tbl_seccion set grado ='"+usuario.getGrado()+"', seccion='"+usuario.getSeccion()+"', Id_nivel='"+usuario.getId_nivel()+"' where Id_seccion="+usuario.getId_seccion()+"";

                st.execute(sql);
                actualizado = true;
                st.close();
            }

        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

}
