package modelo;

import controlador.BeanLiquido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Detalle_L {

    public static boolean agregarDetalle(BeanLiquido En) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.CW_SRV_GRANELES_LIQUIDOS (CWSL_COTIZACION,"
                        + "CWSL_DESC_ACEITE_GRASA_QUIMI,"
                        + "CWSL_DESC_COMBUSTIBLES_DERIV,"
                        + "CWSL_DESC_GAS_PROPANO,"
                        + "CWSL_CARGA_ACEITE_GRASA_QUIMI,"
                        + "CWSL_CARGA_COMBUSTIBLES_DERIV,"
                        + "CWSL_CARGA_GAS_PROPANO,"
                        + "GRABADOR) VALUES ('" + En.getCWSL_COTIZACION() + "','" + En.getCWSL_DESC_ACEITE_GRASA_QUIMI() + "','" + En.getCWSL_DESC_COMBUSTIBLES_DERIV() + "','" + En.getCWSL_DESC_GAS_PROPANO() + "','" + En.getCWSL_CARGA_ACEITE_GRASA_QUIMI() + "','" + En.getCWSL_CARGA_COMBUSTIBLES_DERIV() + "','" + En.getCWSL_CARGA_GAS_PROPANO() + "','" + En.getGRABADOR() + "')";

                st.execute(sql);

                agregado = true;
                st.close();
            }

        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }

    public static BeanLiquido Obtenerxedit(String id) {
        BeanLiquido user = new BeanLiquido();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT    \n"
                        + "    cwbc_hora,\n"
                        + "    cwbc_eta, \n"
                        + "    cwsl_carga_aceite_grasa_quimi,\n"
                        + "    cwsl_carga_combustibles_deriv,\n"
                        + "    cwsl_carga_gas_propano,\n"
                        + "   \n"
                        + "    cwsl_desc_aceite_grasa_quimi,\n"
                        + "    cwsl_desc_combustibles_deriv,\n"
                        + "    cwsl_desc_gas_propano\n"
                        + "    from cw_buque_cotiza, cw_srv_graneles_liquidos\n"
                        + "    where cwbc_cotizacion = cwsl_cotizacion\n"
                        + "    and cwsl_cotizacion = " + id + "")) {
                    while (rs.next()) {

                        user.setCWBC_HORA(rs.getString("cwbc_hora"));
                        user.setCWBC_ETA(rs.getString("cwbc_eta"));
                        user.setCWSL_DESC_ACEITE_GRASA_QUIMI(rs.getString("cwsl_desc_aceite_grasa_quimi"));
                        user.setCWSL_CARGA_COMBUSTIBLES_DERIV(rs.getString("cwsl_carga_combustibles_deriv"));
                        user.setCWSL_CARGA_GAS_PROPANO(rs.getString("cwsl_carga_gas_propano"));
                        user.setCWSL_CARGA_ACEITE_GRASA_QUIMI(rs.getString("cwsl_carga_aceite_grasa_quimi"));
                        user.setCWSL_DESC_COMBUSTIBLES_DERIV(rs.getString("cwsl_desc_combustibles_deriv"));
                        user.setCWSL_DESC_GAS_PROPANO(rs.getString("cwsl_desc_gas_propano"));

                    }
                }
                st.close();
            }
        } catch (SQLException e) {

        }
        return user;

    }

    public static String ActualizarDetalle(BeanLiquido buque) {
        String actualizado = null;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {

                Statement st;
                st = con.createStatement();
//                UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA
                //            String sql = "update COTIZADOR_WEB.CW_BUQUE_COTIZA set CWBC_ETA =  to_date('" + buque.getCWBC_ETA()+ "','yyyy-mm-dd hh24:mi'), CWBC_HORA='" + buque.getCWBC_HORA()+ "'"
                //                  + "where CWBC_COTIZACION = '"+ buque.getCWBC_COTIZACION() +"'";

                String sql = " update COTIZADOR_WEB.cw_srv_graneles_liquidos SET "
                        + "cwsl_desc_aceite_grasa_quimi = '" + buque.getCWSL_DESC_ACEITE_GRASA_QUIMI()+ "',\n"
                        + "cwsl_desc_combustibles_deriv = '" + buque.getCWSL_DESC_COMBUSTIBLES_DERIV()+ "',\n"
                        + "cwsl_desc_gas_propano = '" + buque.getCWSL_DESC_GAS_PROPANO()+ "',\n"
                        + "cwsl_carga_combustibles_deriv = '" + buque.getCWSL_CARGA_COMBUSTIBLES_DERIV()+ "',\n"
                        + "cwsl_carga_gas_propano = '" + buque.getCWSL_CARGA_GAS_PROPANO()+ "',\n"
                        + "cwsl_carga_aceite_grasa_quimi = '" + buque.getCWSL_CARGA_ACEITE_GRASA_QUIMI()+ "'"
                        + "where CWSL_COTIZACION = '" + buque.getCWSL_COTIZACION() + "'";

                st.execute(sql);
                actualizado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            actualizado = "mal" + e + buque.getCWBC_ETA();
        }

        return actualizado;
    }

    public static String Actualizar(BeanLiquido buque) {
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
            actualizado = "mal" + e+ buque.getCWBC_HORA()+ buque.getCWSL_COTIZACION();
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
                String sql = "DELETE FROM cw_detalle_cotizacion\n"
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
