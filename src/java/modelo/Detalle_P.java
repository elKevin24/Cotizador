package modelo;

import controlador.BeanPorta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Detalle_P {

    public static String agregarDetalle(BeanPorta En) {
        String agregado = null;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.CW_SRV_PORTACONTENEDORES ("
                        + "CWSP_COTIZACION,"
                        + "CWSP_MUELLAJE_COF_IMPORT,"
                        + "CWSP_MUELLAJE_COF_EXPORT,"
                        + "CWSP_DESCARGA_LLENOS_GB_VI,"
                        + "CWSP_DESCARGA_LLENOS_GB_VD,"
                        + "CWSP_DESCARGA_LLENOS_GP_VI,"
                        + "CWSP_DESCARGA_LLENOS_GP_VD,"
                        + "CWSP_DESCARGA_VACIOS_GB_VI,"
                        + "CWSP_DESCARGA_VACIOS_GB_VD,"
                        + "CWSP_DESCARGA_VACIOS_GP_VI,"
                        + "CWSP_DESCARGA_VACIOS_GP_VD,"
                        + "CWSP_CARGA_LLENOS_GB_VI,"
                        + "CWSP_CARGA_LLENOS_GB_VD,"
                        + "CWSP_CARGA_LLENOS_GP_VI,"
                        + "CWSP_CARGA_LLENOS_GP_VD,"
                        + "CWSP_CARGA_VACIOS_GB_VI,"
                        + "CWSP_CARGA_VACIOS_GB_VD,"
                        + "CWSP_CARGA_VACIOS_GP_VI,"
                        + "CWSP_CARGA_VACIOS_GP_VD,"
                        + "CWSP_DESCARGA_VEHICULOS_GB,"
                        + "CWSP_DESCARGA_VEHICULOS_GP,"
                        + "CWSP_REESTIBAS_GB,"
                        + "CWSP_REESTIBAS_GP,"
                        + "CWSP_TAPA_ESCOTILLAS_GB, "
                        + "CWSP_TAPA_ESCOTILLAS_GP, "
                        + "CWSP_DEPOSITO_TEMP_LLENO_GB, "
                        + "CWSP_DEPOSITO_TEMP_LLENO_GP,"
                        + "CWSP_DEPOSITO_TEMP_VACIO_GB,"
                        + "CWSP_DEPOSITO_TEMP_VACIO_GP,"
                        + "CWSP_REEMBARQUE_LLENO_GB, "
                        + "CWSP_REEMBARQUE_LLENO_GP, "
                        + "CWSP_REEMBARQUE_VACIO_GB, "
                        + "CWSP_REEMBARQUE_VACIO_GP,"
                        + "CWSP_DEPOSITO_MOMENT_GB,"
                        + "CWSP_DEPOSITO_MOMENT_GP,"                      
                        + "GRABADOR, GRABADOR_FECHA, CWSP_REEMBARQUE_LLENO_RF_GP, CWSP_REEMBARQUE_LLENO_RF_GB) VALUES "
                        + "('" + En.getCWBC_COTIZACION() + "',"
                        + "'" + En.getCWSF_MUELLAJE_COF_IMPORT() + "','" + En.getCWSF_MUELLAJE_COF_EXPORT() + "',"
                        + "'" + En.getCWSF_DESCARGA_LLENOS_GB_VI() + "','" + En.getCWSF_DESCARGA_LLENOS_GB_VD() + "','" + En.getCWSF_DESCARGA_LLENOS_GP_VI() + "','" + En.getCWSF_DESCARGA_LLENOS_GP_VD() + "',"
                        + "'" + En.getCWSF_DESCARGA_VACIOS_GB_VI() + "','" + En.getCWSF_DESCARGA_VACIOS_GB_VD() + "','" + En.getCWSF_DESCARGA_VACIOS_GP_VI() + "','" + En.getCWSF_DESCARGA_VACIOS_GP_VD() + "',"
                        + "'" + En.getCWSF_CARGA_LLENOS_GB_VI() + "','" + En.getCWSF_CARGA_LLENOS_GB_VD() + "','" + En.getCWSF_CARGA_LLENOS_GP_VI() + "','" + En.getCWSF_CARGA_LLENOS_GP_VD() + "',"
                        + "'" + En.getCWSF_CARGA_VACIOS_GB_VI() + "','" + En.getCWSF_CARGA_VACIOS_GB_VD() + "','" + En.getCWSF_CARGA_VACIOS_GP_VI() + "','" + En.getCWSF_CARGA_VACIOS_GP_VD() + "',"
                        + "'" + En.getCWSF_DESCARGA_VEHICULOS_GB() + "','" + En.getCWSF_DESCARGA_VEHICULOS_GP() + "',"
                        + "'" + En.getCWSF_REESTIBAS_GB() + "','" + En.getCWSF_REESTIBAS_GP() + "',"
                        + "'" + En.getCWSF_TAPA_ESCOTILLAS_GB() + "','" + En.getCWSF_TAPA_ESCOTILLAS_GP() + "',"
                        + "'" + En.getCWSF_DEPOSITO_TEMP_LLENO_GB() + "','" + En.getCWSF_DEPOSITO_TEMP_LLENO_GP() + "','" + En.getCWSF_DEPOSITO_TEMP_VACIO_GB() + "','" + En.getCWSF_DEPOSITO_TEMP_VACIO_GP() + "',"
                        + "'" + En.getCWSF_REEMBARQUE_LLENO_GB() + "','" + En.getCWSF_REEMBARQUE_LLENO_GP() + "','" + En.getCWSF_REEMBARQUE_VACIO_GB() + "','" + En.getCWSF_REEMBARQUE_VACIO_GP() + "',"
                        + "'" + En.getCWSF_DEPOSITO_MOMENT_GB() + "','" + En.getCWSF_DEPOSITO_MOMENT_GP()+ "', "
                        
                        + "'" + En.getGRABADOR() + "',sysdate, '"+ En.getCWSF_REEMBARQUE_LLENO_RF_GP() + "' , '"+ En.getCWSF_REEMBARQUE_LLENO_RF_GB() + "')";

                st.execute(sql);

                agregado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            agregado = "mal"+e;
        }
        return agregado;
    }
    
    
    public static BeanPorta Obtenerxedit(String id)
{
    BeanPorta user = new BeanPorta();
    
     try
      {
    Conexion c=new Conexion();
        try (Connection con = c.getConexion()) {
            Statement st;
            st = con.createStatement();
        try (ResultSet rs = st.executeQuery("SELECT cwbc_cotizacion, CWBC_HORA, cwbc_eta, cwsp_muellaje_cof_import,\n" +
                "    cwsp_muellaje_cof_export,\n" +
                "    cwsp_descarga_llenos_gb_vi,\n" +
                "    cwsp_descarga_llenos_gb_vd,\n" +
                "    cwsp_descarga_llenos_gp_vi,\n" +
                "    cwsp_descarga_llenos_gp_vd,\n" +
                "    cwsp_descarga_vacios_gb_vi,\n" +
                "    cwsp_descarga_vacios_gb_vd,\n" +
                "    cwsp_descarga_vacios_gp_vi,\n" +
                "    cwsp_descarga_vacios_gp_vd,\n" +
                "    cwsp_carga_llenos_gb_vi,\n" +
                "    cwsp_carga_llenos_gb_vd,\n" +
                "    cwsp_carga_llenos_gp_vi,\n" +
                "    cwsp_carga_llenos_gp_vd,\n" +
                "    cwsp_carga_vacios_gb_vi,\n" +
                "    cwsp_carga_vacios_gb_vd,\n" +
                "    cwsp_carga_vacios_gp_vi,\n" +
                "    cwsp_carga_vacios_gp_vd,\n" +
                "    cwsp_descarga_vehiculos_gb,\n" +
                "    cwsp_descarga_vehiculos_gp,\n" +
                "    cwsp_reestibas_gb,\n" +
                "    cwsp_reestibas_gp,\n" +
                "    cwsp_tapa_escotillas_gb,\n" +
                "    cwsp_tapa_escotillas_gp,\n" +
                "    cwsp_deposito_temp_lleno_gb,\n" +
                "    cwsp_deposito_temp_lleno_gp,\n" +
                "    cwsp_deposito_temp_vacio_gb,\n" +
                "    cwsp_deposito_temp_vacio_gp,\n" +
                "    cwsp_reembarque_lleno_gb,\n" +
                "    cwsp_reembarque_lleno_gp,\n" +
                "    cwsp_reembarque_vacio_gb,\n" +
                "    cwsp_reembarque_vacio_gp,\n" +
                "    cwsp_deposito_moment_gb,\n" +
                "    cwsp_deposito_moment_gp,\n" +
                "    cwsp_reembarque_lleno_rf_gp,\n" +
                "    cwsp_reembarque_lleno_rf_gb\n" +
                "    FROM\n" +
                "CW_BUQUE_COTIZA A\n" +
                "\n" +
                "RIGHT OUTER JOIN  cw_srv_portacontenedores B\n" +
                "   ON A.CWBC_COTIZACION = B.CWSP_COTIZACION\n" +
                "   WHERE CWBC_COTIZACION = "+id+"")) {
            while (rs.next())
            {
                
                user.setCWBC_COTIZACION(rs.getString("cwbc_cotizacion"));
                user.setCWBC_HORA(rs.getString("CWBC_HORA"));
                user.setCWBC_ETA(rs.getString("cwbc_eta"));
                user.setCWSF_MUELLAJE_COF_IMPORT("cwsp_muellaje_cof_import");
                user.setCWSF_DESCARGA_LLENOS_GB_VI(rs.getString("cwsp_descarga_llenos_gb_vi"));
                user.setCWSF_DESCARGA_LLENOS_GB_VD(rs.getString("cwsp_descarga_llenos_gb_vd"));
                user.setCWSF_DESCARGA_LLENOS_GP_VI(rs.getString("cwsp_descarga_llenos_gp_vi"));
                user.setCWSF_DESCARGA_LLENOS_GP_VD(rs.getString("cwsp_descarga_llenos_gp_vd"));
                
                user.setCWSF_DESCARGA_VACIOS_GB_VI(rs.getString("cwsp_descarga_vacios_gb_vi"));
                user.setCWSF_DESCARGA_VACIOS_GB_VD(rs.getString("cwsp_descarga_vacios_gb_vd"));
                user.setCWSF_DESCARGA_VACIOS_GP_VI(rs.getString("cwsp_descarga_vacios_gp_vi"));
                user.setCWSF_DESCARGA_VACIOS_GP_VD(rs.getString("cwsp_descarga_vacios_gp_vd"));
                
                user.setCWSF_CARGA_LLENOS_GB_VI(rs.getString("cwsp_carga_llenos_gb_vi"));
                user.setCWSF_CARGA_LLENOS_GB_VD(rs.getString("cwsp_carga_llenos_gb_vd"));
                user.setCWSF_CARGA_LLENOS_GP_VI(rs.getString("cwsp_carga_llenos_gp_vi"));
                user.setCWSF_CARGA_LLENOS_GP_VD(rs.getString("cwsp_carga_llenos_gp_vd"));
                
                user.setCWSF_CARGA_VACIOS_GB_VI(rs.getString("cwsp_carga_vacios_gb_vi"));
                user.setCWSF_CARGA_VACIOS_GB_VD(rs.getString("cwsp_carga_vacios_gb_vd"));
                user.setCWSF_CARGA_VACIOS_GP_VI(rs.getString("cwsp_carga_vacios_gp_vi"));
                user.setCWSF_CARGA_VACIOS_GP_VD(rs.getString("cwsp_carga_vacios_gp_vd"));
                
                user.setCWSF_DESCARGA_VEHICULOS_GB(rs.getString("cwsp_descarga_vehiculos_gb"));
                user.setCWSF_DESCARGA_VEHICULOS_GP(rs.getString("cwsp_descarga_vehiculos_gp"));
                
                user.setCWSF_REESTIBAS_GB(rs.getString("cwsp_reestibas_gb"));
                user.setCWSF_REESTIBAS_GP(rs.getString("cwsp_reestibas_gp"));
                
                user.setCWSF_TAPA_ESCOTILLAS_GB(rs.getString("cwsp_tapa_escotillas_gb"));
                user.setCWSF_TAPA_ESCOTILLAS_GP(rs.getString("cwsp_tapa_escotillas_gp"));
                
                user.setCWSF_DEPOSITO_TEMP_LLENO_GB(rs.getString("cwsp_deposito_temp_lleno_gb"));
                user.setCWSF_DEPOSITO_TEMP_LLENO_GP(rs.getString("cwsp_deposito_temp_lleno_gp"));
                user.setCWSF_DEPOSITO_TEMP_VACIO_GB(rs.getString("cwsp_deposito_temp_vacio_gb"));
                user.setCWSF_DEPOSITO_TEMP_VACIO_GP(rs.getString("cwsp_deposito_temp_vacio_gp"));
                
                user.setCWSF_REEMBARQUE_LLENO_GB(rs.getString("cwsp_reembarque_lleno_gb"));
                user.setCWSF_REEMBARQUE_LLENO_GP(rs.getString("cwsp_reembarque_lleno_gp"));
                user.setCWSF_REEMBARQUE_VACIO_GB(rs.getString("cwsp_reembarque_vacio_gb"));
                user.setCWSF_REEMBARQUE_VACIO_GP(rs.getString("cwsp_reembarque_vacio_gp"));
                
                user.setCWSF_REEMBARQUE_LLENO_RF_GP(rs.getString("cwsp_reembarque_lleno_rf_gp"));
                user.setCWSF_REEMBARQUE_LLENO_RF_GB(rs.getString("cwsp_reembarque_lleno_rf_gb"));
                
                user.setCWSF_DEPOSITO_MOMENT_GB(rs.getString("cwsp_DEPOSITO_MOMENT_GB"));
                user.setCWSF_DEPOSITO_MOMENT_GP(rs.getString("cwsp_DEPOSITO_MOMENT_GP"));
                
                
                
                
            }
        }
            st.close();
        }
      }
     catch(SQLException e)
     {
     }
    return user;
    
}
    
    
    public static String ActualizarPortacontenedor(BeanPorta buque) {
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
      
      String sql = " update COTIZADOR_WEB.cw_srv_portacontenedores SET "
              + "CWSP_DESCARGA_LLENOS_GB_VI = '"+ buque.getCWSF_DESCARGA_LLENOS_GB_VI() +"',\n" +
"CWSP_DESCARGA_LLENOS_GB_VD = '"+ buque.getCWSF_DESCARGA_LLENOS_GB_VD() +"',\n" +
"CWSP_DESCARGA_LLENOS_GP_VI = '"+ buque.getCWSF_DESCARGA_LLENOS_GP_VI() +"',\n" +
"CWSP_DESCARGA_LLENOS_GP_VD = '"+ buque.getCWSF_DESCARGA_LLENOS_GP_VD() +"',\n" +
"CWSP_DESCARGA_VACIOS_GB_VI = '"+ buque.getCWSF_DESCARGA_VACIOS_GB_VI() +"',\n" +
"CWSP_DESCARGA_VACIOS_GB_VD = '"+ buque.getCWSF_DESCARGA_VACIOS_GB_VD() +"',\n" +
"CWSP_DESCARGA_VACIOS_GP_VI = '"+ buque.getCWSF_DESCARGA_VACIOS_GP_VI() +"',\n" +
"CWSP_DESCARGA_VACIOS_GP_VD = '"+ buque.getCWSF_DESCARGA_VACIOS_GP_VD() +"',\n" +
"CWSP_CARGA_LLENOS_GB_VI = '"+ buque.getCWSF_CARGA_LLENOS_GB_VI() +"',\n" +
"CWSP_CARGA_LLENOS_GB_VD = '"+ buque.getCWSF_CARGA_LLENOS_GB_VD() +"',\n" +
"CWSP_CARGA_LLENOS_GP_VI = '"+ buque.getCWSF_CARGA_LLENOS_GP_VI() +"',\n" +
"CWSP_CARGA_LLENOS_GP_VD = '"+ buque.getCWSF_CARGA_LLENOS_GP_VD() +"',\n" +
"CWSP_CARGA_VACIOS_GB_VI = '"+ buque.getCWSF_CARGA_VACIOS_GB_VI() +"',\n" +
"CWSP_CARGA_VACIOS_GB_VD = '"+ buque.getCWSF_CARGA_VACIOS_GB_VD() +"',\n" +
"CWSP_CARGA_VACIOS_GP_VI = '"+ buque.getCWSF_CARGA_VACIOS_GP_VI() +"',\n" +
"CWSP_CARGA_VACIOS_GP_VD = '"+ buque.getCWSF_CARGA_VACIOS_GP_VD() +"',\n" +
"CWSP_DESCARGA_VEHICULOS_GB = '"+ buque.getCWSF_DESCARGA_VEHICULOS_GB() +"',\n" +
"CWSP_DESCARGA_VEHICULOS_GP = '"+ buque.getCWSF_DESCARGA_VEHICULOS_GP() +"',\n" +
"CWSP_REESTIBAS_GB = '"+ buque.getCWSF_REESTIBAS_GB() +"',\n" +
"CWSP_REESTIBAS_GP = '"+ buque.getCWSF_REESTIBAS_GP() +"',\n" +
"CWSP_TAPA_ESCOTILLAS_GB = '"+ buque.getCWSF_TAPA_ESCOTILLAS_GB() +"',\n" +
"CWSP_TAPA_ESCOTILLAS_GP = '"+ buque.getCWSF_TAPA_ESCOTILLAS_GP() +"',\n" +
"CWSP_DEPOSITO_TEMP_LLENO_GB = '"+ buque.getCWSF_DEPOSITO_TEMP_LLENO_GB() +"',\n" +
"CWSP_DEPOSITO_TEMP_LLENO_GP = '"+ buque.getCWSF_DEPOSITO_TEMP_LLENO_GP() +"',\n" +
"CWSP_DEPOSITO_TEMP_VACIO_GB = '"+ buque.getCWSF_DEPOSITO_TEMP_VACIO_GB() +"',\n" +
"CWSP_DEPOSITO_TEMP_VACIO_GP = '"+ buque.getCWSF_DEPOSITO_TEMP_VACIO_GP() +"',\n" +
"CWSP_REEMBARQUE_LLENO_GB = '"+ buque.getCWSF_REEMBARQUE_LLENO_GB() +"',\n" +
"CWSP_REEMBARQUE_LLENO_GP = '"+ buque.getCWSF_REEMBARQUE_LLENO_GP() +"',\n" +
"CWSP_REEMBARQUE_VACIO_GB = '"+ buque.getCWSF_REEMBARQUE_VACIO_GB() +"',\n" +
"CWSP_REEMBARQUE_VACIO_GP = '"+ buque.getCWSF_REEMBARQUE_VACIO_GP() +"',\n" +
"CWSP_DEPOSITO_MOMENT_GB = '"+ buque.getCWSF_DEPOSITO_MOMENT_GB() +"',\n" +
"CWSP_DEPOSITO_MOMENT_GP = '"+ buque.getCWSF_DEPOSITO_MOMENT_GP() +"',\n" +
"CWSP_REEMBARQUE_LLENO_RF_GP = '"+ buque.getCWSF_REEMBARQUE_LLENO_RF_GP() +"',\n" +
"CWSP_REEMBARQUE_LLENO_RF_GB = '"+ buque.getCWSF_REEMBARQUE_LLENO_RF_GB() +"'"
              + "where CWSP_COTIZACION = '"+buque.getCWBC_COTIZACION()+"'";

                st.execute(sql);
                actualizado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            actualizado = "mal"+e+ buque.getCWBC_ETA();
        }

        return actualizado;
    }
    
    
    public static String ActualizarPortacontenedorDetalle(BeanPorta buque) {
        String actualizado = null;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {

                Statement st;
                st = con.createStatement();
//                UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA
                String sql = "update COTIZADOR_WEB.CW_BUQUE_COTIZA set CWBC_ETA = TO_DATE('" + buque.getCWBC_ETA() + "', 'YYYY-MM-DD HH24:MI:SS'), CWBC_HORA='" + buque.getCWBC_HORA()+ "'"
                        + "where CWBC_COTIZACION = '"+ buque.getCWBC_COTIZACION() +"'";

                st.execute(sql);
                actualizado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            actualizado = "mal"+e+ buque.getCWBC_ETA();
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
                String sql = "DELETE FROM cw_detalle_cotizacion\n" +
"WHERE\n" +
"    cwbc_cotizacion =" + id + "";
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

