package modelo;

import controlador.BeanMulti;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Detalle_M {

    public static boolean agregarDetalle(BeanMulti En) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.CW_SRV_MULTIPROPOSITOS (CWSM_COTIZACION,"
                        + "CWSM_MUELLAJE_COF_IMPORT,"
                        + "CWSM_MUELLAJE_COF_EXPORT,"
                        + "CWSM_DESCARGA_LLENOS_GB_VI,"
                        + "CWSM_DESCARGA_LLENOS_GB_VD,"
                        + "CWSM_DESCARGA_LLENOS_GP_VI,"
                        + "CWSM_DESCARGA_LLENOS_GP_VD,"
                        + "CWSM_DESCARGA_VACIOS_GB_VI,"
                        + "CWSM_DESCARGA_VACIOS_GB_VD,"
                        + "CWSM_DESCARGA_VACIOS_GP_VI,"
                        + "CWSM_DESCARGA_VACIOS_GP_VD,"
                        + "CWSM_CARGA_LLENOS_GB_VI,"
                        + "CWSM_CARGA_LLENOS_GB_VD,"
                        + "CWSM_CARGA_LLENOS_GP_VI,"
                        + "CWSM_CARGA_LLENOS_GP_VD,"
                        + "CWSM_CARGA_VACIOS_GB_VI,"
                        + "CWSM_CARGA_VACIOS_GB_VD,"
                        + "CWSM_CARGA_VACIOS_GP_VI,"
                        + "CWSM_CARGA_VACIOS_GP_VD,"
                        + "CWSM_DESCARGA_VEHICULOS_GB,"
                        + "CWSM_DESCARGA_VEHICULOS_GP,"
                        + "CWSM_REESTIBAS_GB,"
                        + "CWSM_REESTIBAS_GP,"
                        + "CWSM_TAPA_ESCOTILLAS_GB,"
                        + "CWSM_TAPA_ESCOTILLAS_GP,"
                        + "CWSM_DEPOSITO_TEMP_LLENO_GB,"
                        + "CWSM_DEPOSITO_TEMP_LLENO_GP,"
                        + "CWSM_DEPOSITO_TEMP_VACIO_GB,"
                        + "CWSM_DEPOSITO_TEMP_VACIO_GP,"
                        + "CWSM_REEMBARQUE_LLENO_GB,"
                        + "CWSM_REEMBARQUE_LLENO_GP,"
                        + "CWSM_REEMBARQUE_VACIO_GB,"
                        + "CWSM_REEMBARQUE_VACIO_GP,"
                        + "CWSM_DEPOSITO_MOMENT_GB,"
                        + "CWSM_DEPOSITO_MOMENT_GP,"
                        + "CWSM_DESCARGA_MERCA_GB_VD,"
                        + "CWSM_DESCARGA_MERCA_GB_VI,"
                        + "CWSM_DESCARGA_MERCA_GP_VD,"
                        + "CWSM_DESCARGA_MERCA_GP_VI,"
                        + "CWSM_CARGA_MERCA_GB_VD,"
                        + "CWSM_CARGA_MERCA_GB_VI,"
                        + "CWSM_CARGA_MERCA_GP_VD,"
                        + "CWSM_CARGA_MERCA_GP_VI,"
                        + "GRABADOR, GRABADOR_FECHA,"
                        + "CWSM_REEMBARQUE_LLENO_RF_GP,"
                        + "CWSM_REEMBARQUE_LLENO_RF_GB,"
                        + "CWSM_DESCARGA_MERCA_GP_VD_HR,"
                        + "CWSM_DESCARGA_MERCA_GP_VI_HR,"
                        + "CWSM_CARGA_MERCA_GP_VD_HR,"
                        + "CWSM_CARGA_MERCA_GP_VI_HR) VALUES "
                        + "('" + En.getCWBC_COTIZACION() + "',"
                        + "'" + En.getCWSF_MUELLAJE_COF_IMPORT() + "','" + En.getCWSF_MUELLAJE_COF_EXPORT() + "',"
                        + "'" + En.getCWSF_DESCARGA_LLENOS_GB_VI() + "','" + En.getCWSF_DESCARGA_LLENOS_GB_VD() + "','" + En.getCWSF_DESCARGA_LLENOS_GP_VI() + "','" + En.getCWSF_DESCARGA_LLENOS_GP_VD() + "',"
                        + "'" + En.getCWSF_DESCARGA_VACIOS_GB_VI() + "','" + En.getCWSF_DESCARGA_VACIOS_GB_VD() + "','" + En.getCWSF_DESCARGA_VACIOS_GP_VI() + "','" + En.getCWSF_DESCARGA_VACIOS_GP_VD() + "',"
                        + "'" + En.getCWSF_CARGA_LLENOS_GB_VI() + "', '" + En.getCWSF_CARGA_LLENOS_GB_VD() + "' ,'" + En.getCWSF_CARGA_LLENOS_GP_VI() + "' ,'" + En.getCWSF_CARGA_LLENOS_GP_VD() + "',"
                        + "'" + En.getCWSF_CARGA_VACIOS_GB_VI() + "','" + En.getCWSF_CARGA_VACIOS_GB_VD() + "','" + En.getCWSF_CARGA_VACIOS_GP_VI() + "','" + En.getCWSF_CARGA_VACIOS_GP_VD() + "',"
                        + "'" + En.getCWSF_DESCARGA_VEHICULOS_GB() + "','" + En.getCWSF_DESCARGA_VEHICULOS_GP() + "',"
                        + "'" + En.getCWSF_REESTIBAS_GB() + "','" + En.getCWSF_REESTIBAS_GP() + "',"
                        + "'" + En.getCWSF_TAPA_ESCOTILLAS_GB() + "','" + En.getCWSF_TAPA_ESCOTILLAS_GP() + "',"
                        + "'" + En.getCWSF_DEPOSITO_TEMP_LLENO_GB() + "','" + En.getCWSF_DEPOSITO_TEMP_LLENO_GP() + "','" + En.getCWSF_DEPOSITO_TEMP_VACIO_GB() + "','" + En.getCWSF_DEPOSITO_TEMP_VACIO_GP() + "',"
                        + "'" + En.getCWSF_REEMBARQUE_LLENO_GB() + "','" + En.getCWSF_REEMBARQUE_LLENO_GP() + "','" + En.getCWSF_REEMBARQUE_VACIO_GB() + "','" + En.getCWSF_REEMBARQUE_VACIO_GP() + "',"
                        + "'" + En.getCWSF_DEPOSITO_MOMENT_GB() + "','" + En.getCWSF_DEPOSITO_MOMENT_GP() + "',"
                        + "'" + En.getCWSF_DESCARGA_MERCA_GB_VD() + "','" + En.getCWSF_DESCARGA_MERCA_GB_VI() + "','" + En.getCWSF_DESCARGA_MERCA_GP_VD() + "','" + En.getCWSF_DESCARGA_MERCA_GP_VI() + "',"
                        + "'" + En.getCWSF_CARGA_MERCA_GB_VD() + "','" + En.getCWSF_CARGA_MERCA_GB_VI() + "','" + En.getCWSF_CARGA_MERCA_GP_VD() + "','" + En.getCWSF_CARGA_MERCA_GP_VI() + "',"
                        + "'" + En.getGRABADOR() + "', sysdate, "
                        + "'" + En.getCWSM_REEMBARQUE_LLENO_RF_GP() + "' , '" + En.getCWSM_REEMBARQUE_LLENO_RF_GB() + "', "
                        + "'" + En.getCWSM_DESCARGA_MERCA_GP_VD_HR() + "' , '" + En.getCWSM_DESCARGA_MERCA_GP_VI_HR() + "', "
                        + "'" + En.getCWSM_CARGA_MERCA_GP_VD_HR() + "' , '" + En.getCWSM_CARGA_MERCA_GP_VI_HR() + "' )";

                st.execute(sql);

                agregado = true;
                st.close();
            }

        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }

    public static BeanMulti Obtenerxedit(String id) {
        BeanMulti user = new BeanMulti();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT cwbc_cotizacion, CWBC_HORA, cwbc_eta,"
                        + "CWSM_MUELLAJE_COF_IMPORT,"
                        + "CWSM_MUELLAJE_COF_EXPORT,"
                        + "CWSM_DESCARGA_LLENOS_GB_VI,"
                        + "CWSM_DESCARGA_LLENOS_GB_VD,"
                        + "CWSM_DESCARGA_LLENOS_GP_VI,"
                        + "CWSM_DESCARGA_LLENOS_GP_VD,"
                        + "CWSM_DESCARGA_VACIOS_GB_VI,"
                        + "CWSM_DESCARGA_VACIOS_GB_VD,"
                        + "CWSM_DESCARGA_VACIOS_GP_VI,"
                        + "CWSM_DESCARGA_VACIOS_GP_VD,"
                        + "CWSM_CARGA_LLENOS_GB_VI,"
                        + "CWSM_CARGA_LLENOS_GB_VD,"
                        + "CWSM_CARGA_LLENOS_GP_VI,"
                        + "CWSM_CARGA_LLENOS_GP_VD,"
                        + "CWSM_CARGA_VACIOS_GB_VI,"
                        + "CWSM_CARGA_VACIOS_GB_VD,"
                        + "CWSM_CARGA_VACIOS_GP_VI,"
                        + "CWSM_CARGA_VACIOS_GP_VD,"
                        + "CWSM_DESCARGA_VEHICULOS_GB,"
                        + "CWSM_DESCARGA_VEHICULOS_GP,"
                        + "CWSM_REESTIBAS_GB,"
                        + "CWSM_REESTIBAS_GP,"
                        + "CWSM_TAPA_ESCOTILLAS_GB,"
                        + "CWSM_TAPA_ESCOTILLAS_GP,"
                        + "CWSM_DEPOSITO_TEMP_LLENO_GB,"
                        + "CWSM_DEPOSITO_TEMP_LLENO_GP,"
                        + "CWSM_DEPOSITO_TEMP_VACIO_GB,"
                        + "CWSM_DEPOSITO_TEMP_VACIO_GP,"
                        + "CWSM_REEMBARQUE_LLENO_GB,"
                        + "CWSM_REEMBARQUE_LLENO_GP,"
                        + "CWSM_REEMBARQUE_VACIO_GB,"
                        + "CWSM_REEMBARQUE_VACIO_GP,"
                        + "CWSM_DEPOSITO_MOMENT_GB,"
                        + "CWSM_DEPOSITO_MOMENT_GP,"
                        + "CWSM_DESCARGA_MERCA_GB_VD,"
                        + "CWSM_DESCARGA_MERCA_GB_VI,"
                        + "CWSM_DESCARGA_MERCA_GP_VD,"
                        + "CWSM_DESCARGA_MERCA_GP_VI,"
                        + "CWSM_CARGA_MERCA_GB_VD,"
                        + "CWSM_CARGA_MERCA_GB_VI,"
                        + "CWSM_CARGA_MERCA_GP_VD,"
                        + "CWSM_CARGA_MERCA_GP_VI,"
                        + "CWSM_REEMBARQUE_LLENO_RF_GP,"
                        + "CWSM_REEMBARQUE_LLENO_RF_GB,"
                        + "CWSM_DESCARGA_MERCA_GP_VD_HR,"
                        + "CWSM_DESCARGA_MERCA_GP_VI_HR,"
                        + "CWSM_CARGA_MERCA_GP_VD_HR,"
                        + "CWSM_CARGA_MERCA_GP_VI_HR"
                        + "    FROM CW_BUQUE_COTIZA A RIGHT OUTER JOIN  cw_srv_multipropositos B"
                        + "   ON A.CWBC_COTIZACION = B.CWSM_COTIZACION"
                        + "   WHERE CWBC_COTIZACION = " + id + "")) {
                    while (rs.next()) {

                        user.setCWBC_COTIZACION(rs.getString("cwbc_cotizacion"));
                        user.setCWBC_HORA(rs.getString("CWBC_HORA"));
                        user.setCWBC_ETA(rs.getString("cwbc_eta"));
                        user.setCWSF_MUELLAJE_COF_IMPORT(rs.getString("CWSM_MUELLAJE_COF_IMPORT"));
                        user.setCWSF_DESCARGA_LLENOS_GB_VI(rs.getString("CWSM_DESCARGA_LLENOS_GB_VI"));
                        user.setCWSF_DESCARGA_LLENOS_GB_VD(rs.getString("CWSM_DESCARGA_LLENOS_GB_VD"));
                        user.setCWSF_DESCARGA_LLENOS_GP_VI(rs.getString("CWSM_DESCARGA_LLENOS_GP_VI"));
                        user.setCWSF_DESCARGA_LLENOS_GP_VD(rs.getString("CWSM_DESCARGA_LLENOS_GP_VD"));

                        user.setCWSF_DESCARGA_VACIOS_GB_VI(rs.getString("CWSM_DESCARGA_VACIOS_GB_VI"));
                        user.setCWSF_DESCARGA_VACIOS_GB_VD(rs.getString("CWSM_DESCARGA_VACIOS_GB_VD"));
                        user.setCWSF_DESCARGA_VACIOS_GP_VI(rs.getString("CWSM_DESCARGA_VACIOS_GP_VI"));
                        user.setCWSF_DESCARGA_VACIOS_GP_VD(rs.getString("CWSM_DESCARGA_VACIOS_GP_VD"));

                        user.setCWSF_CARGA_LLENOS_GB_VI(rs.getString("CWSM_CARGA_LLENOS_GB_VI"));
                        user.setCWSF_CARGA_LLENOS_GB_VD(rs.getString("CWSM_CARGA_LLENOS_GB_VD"));
                        user.setCWSF_CARGA_LLENOS_GP_VI(rs.getString("CWSM_CARGA_LLENOS_GP_VI"));
                        user.setCWSF_CARGA_LLENOS_GP_VD(rs.getString("CWSM_CARGA_LLENOS_GP_VD"));

                        user.setCWSF_CARGA_VACIOS_GB_VI(rs.getString("CWSM_CARGA_VACIOS_GB_VI"));
                        user.setCWSF_CARGA_VACIOS_GB_VD(rs.getString("CWSM_CARGA_VACIOS_GB_VD"));
                        user.setCWSF_CARGA_VACIOS_GP_VI(rs.getString("CWSM_CARGA_VACIOS_GP_VI"));
                        user.setCWSF_CARGA_VACIOS_GP_VD(rs.getString("CWSM_CARGA_VACIOS_GP_VD"));

                        user.setCWSF_DESCARGA_VEHICULOS_GB(rs.getString("CWSM_DESCARGA_VEHICULOS_GB"));
                        user.setCWSF_DESCARGA_VEHICULOS_GP(rs.getString("CWSM_DESCARGA_VEHICULOS_GP"));

                        user.setCWSF_REESTIBAS_GB(rs.getString("CWSM_REESTIBAS_GB"));
                        user.setCWSF_REESTIBAS_GP(rs.getString("CWSM_REESTIBAS_GP"));

                        user.setCWSF_DEPOSITO_MOMENT_GB(rs.getString("CWSM_DEPOSITO_MOMENT_GB"));
                        user.setCWSF_DEPOSITO_MOMENT_GP(rs.getString("CWSM_DEPOSITO_MOMENT_GP"));

                        user.setCWSF_TAPA_ESCOTILLAS_GB(rs.getString("CWSM_TAPA_ESCOTILLAS_GB"));
                        user.setCWSF_TAPA_ESCOTILLAS_GP(rs.getString("CWSM_TAPA_ESCOTILLAS_GP"));

                        user.setCWSF_DEPOSITO_TEMP_LLENO_GB(rs.getString("CWSM_DEPOSITO_TEMP_LLENO_GB"));
                        user.setCWSF_DEPOSITO_TEMP_LLENO_GP(rs.getString("CWSM_DEPOSITO_TEMP_LLENO_GP"));
                        user.setCWSF_DEPOSITO_TEMP_VACIO_GB(rs.getString("CWSM_DEPOSITO_TEMP_VACIO_GB"));
                        user.setCWSF_DEPOSITO_TEMP_VACIO_GP(rs.getString("CWSM_DEPOSITO_TEMP_VACIO_GP"));

                        user.setCWSF_REEMBARQUE_LLENO_GB(rs.getString("CWSM_REEMBARQUE_LLENO_GB"));
                        user.setCWSF_REEMBARQUE_LLENO_GP(rs.getString("CWSM_REEMBARQUE_LLENO_GP"));
                        user.setCWSF_REEMBARQUE_VACIO_GB(rs.getString("CWSM_REEMBARQUE_VACIO_GB"));
                        user.setCWSF_REEMBARQUE_VACIO_GP(rs.getString("CWSM_REEMBARQUE_VACIO_GP"));
                        user.setCWSM_REEMBARQUE_LLENO_RF_GB(rs.getString("CWSM_REEMBARQUE_LLENO_RF_GB"));
                        user.setCWSM_REEMBARQUE_LLENO_RF_GP(rs.getString("CWSM_REEMBARQUE_LLENO_RF_GP"));

                        user.setCWSF_DESCARGA_MERCA_GB_VI(rs.getString("CWSM_DESCARGA_MERCA_GB_VI"));

                        user.setCWSF_DESCARGA_MERCA_GP_VI(rs.getString("CWSM_DESCARGA_MERCA_GP_VI"));
                        user.setCWSF_DESCARGA_MERCA_GB_VD(rs.getString("CWSM_DESCARGA_MERCA_GB_VD"));

                        user.setCWSF_DESCARGA_MERCA_GP_VD(rs.getString("CWSM_DESCARGA_MERCA_GP_VD"));

                        user.setCWSF_CARGA_MERCA_GB_VI(rs.getString("CWSM_CARGA_MERCA_GB_VI"));

                        user.setCWSF_CARGA_MERCA_GP_VI(rs.getString("CWSM_CARGA_MERCA_GP_VI"));
                        user.setCWSF_CARGA_MERCA_GB_VD(rs.getString("CWSM_CARGA_MERCA_GB_VD"));

                        user.setCWSF_CARGA_MERCA_GP_VD(rs.getString("CWSM_CARGA_MERCA_GP_VD"));

                        user.setCWSM_DESCARGA_MERCA_GP_VI_HR(rs.getString("CWSM_DESCARGA_MERCA_GP_VI_HR"));
                        user.setCWSM_DESCARGA_MERCA_GP_VD_HR(rs.getString("CWSM_DESCARGA_MERCA_GP_VD_HR"));
                        user.setCWSM_CARGA_MERCA_GP_VI_HR(rs.getString("CWSM_CARGA_MERCA_GP_VI_HR"));
                        user.setCWSM_CARGA_MERCA_GP_VD_HR(rs.getString("CWSM_CARGA_MERCA_GP_VD_HR"));

                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;

    }

    public static String ActualizarDetalle(BeanMulti buque) {
        String actualizado = null;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {

                Statement st;
                st = con.createStatement();
//                UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA

                String sql = " update COTIZADOR_WEB.cw_srv_multipropositos SET "
                        + "CWSM_MUELLAJE_COF_IMPORT = '" + buque.getCWSF_MUELLAJE_COF_IMPORT() + "',"
                        + "CWSM_DESCARGA_LLENOS_GB_VI = '" + buque.getCWSF_DESCARGA_LLENOS_GB_VI() + "',"
                        + "CWSM_DESCARGA_LLENOS_GB_VD = '" + buque.getCWSF_DESCARGA_LLENOS_GB_VD() + "',"
                        + "CWSM_DESCARGA_LLENOS_GP_VI = '" + buque.getCWSF_DESCARGA_LLENOS_GP_VI() + "',"
                        + "CWSM_DESCARGA_LLENOS_GP_VD = '" + buque.getCWSF_DESCARGA_LLENOS_GP_VD() + "',"
                        + "CWSM_DESCARGA_VACIOS_GB_VI = '" + buque.getCWSF_DESCARGA_VACIOS_GB_VI() + "',"
                        + "CWSM_DESCARGA_VACIOS_GB_VD = '" + buque.getCWSF_DESCARGA_VACIOS_GB_VD() + "',"
                        + "CWSM_DESCARGA_VACIOS_GP_VI = '" + buque.getCWSF_DESCARGA_VACIOS_GP_VI() + "',"
                        + "CWSM_DESCARGA_VACIOS_GP_VD = '" + buque.getCWSF_DESCARGA_VACIOS_GP_VD() + "',"
                        + "CWSM_CARGA_LLENOS_GB_VI = '" + buque.getCWSF_CARGA_LLENOS_GB_VI() + "',"
                        + "CWSM_CARGA_LLENOS_GB_VD = '" + buque.getCWSF_CARGA_LLENOS_GB_VD() + "',"
                        + "CWSM_CARGA_LLENOS_GP_VI = '" + buque.getCWSF_CARGA_LLENOS_GP_VI() + "',"
                        + "CWSM_CARGA_LLENOS_GP_VD = '" + buque.getCWSF_CARGA_LLENOS_GP_VD() + "',"
                        + "CWSM_CARGA_VACIOS_GB_VI = '" + buque.getCWSF_CARGA_VACIOS_GB_VI() + "',"
                        + "CWSM_CARGA_VACIOS_GB_VD = '" + buque.getCWSF_CARGA_VACIOS_GB_VD() + "',"
                        + "CWSM_CARGA_VACIOS_GP_VI = '" + buque.getCWSF_CARGA_VACIOS_GP_VI() + "',"
                        + "CWSM_CARGA_VACIOS_GP_VD = '" + buque.getCWSF_CARGA_VACIOS_GP_VD() + "',"
                        + "CWSM_DEPOSITO_MOMENT_GP = '" + buque.getCWSF_DEPOSITO_MOMENT_GP() + "',"
                        + "CWSM_DEPOSITO_MOMENT_GB = '" + buque.getCWSF_DEPOSITO_MOMENT_GB() + "',"
                        + "CWSM_DESCARGA_VEHICULOS_GB = '" + buque.getCWSF_DESCARGA_VEHICULOS_GB() + "',"
                        + "CWSM_DESCARGA_VEHICULOS_GP = '" + buque.getCWSF_DESCARGA_VEHICULOS_GP() + "',"
                        + "CWSM_REESTIBAS_GB = '" + buque.getCWSF_REESTIBAS_GB() + "',"
                        + "CWSM_REESTIBAS_GP = '" + buque.getCWSF_REESTIBAS_GP() + "',"
                        + "CWSM_TAPA_ESCOTILLAS_GB = '" + buque.getCWSF_TAPA_ESCOTILLAS_GB() + "',"
                        + "CWSM_TAPA_ESCOTILLAS_GP = '" + buque.getCWSF_TAPA_ESCOTILLAS_GP() + "',"
                        + "CWSM_DEPOSITO_TEMP_LLENO_GB = '" + buque.getCWSF_DEPOSITO_TEMP_LLENO_GB() + "',"
                        + "CWSM_DEPOSITO_TEMP_LLENO_GP = '" + buque.getCWSF_DEPOSITO_TEMP_LLENO_GP() + "',"
                        + "CWSM_DEPOSITO_TEMP_VACIO_GB = '" + buque.getCWSF_DEPOSITO_TEMP_VACIO_GB() + "',"
                        + "CWSM_DEPOSITO_TEMP_VACIO_GP = '" + buque.getCWSF_DEPOSITO_TEMP_VACIO_GP() + "',"
                        + "CWSM_REEMBARQUE_LLENO_GB = '" + buque.getCWSF_REEMBARQUE_LLENO_GB() + "',"
                        + "CWSM_REEMBARQUE_LLENO_GP = '" + buque.getCWSF_REEMBARQUE_LLENO_GP() + "',"
                        + "CWSM_REEMBARQUE_VACIO_GB = '" + buque.getCWSF_REEMBARQUE_VACIO_GB() + "',"
                        + "CWSM_REEMBARQUE_VACIO_GP = '" + buque.getCWSF_REEMBARQUE_VACIO_GP() + "',"
                        + "CWSM_DESCARGA_MERCA_GB_VD = '" + buque.getCWSF_DESCARGA_MERCA_GB_VD() + "',"
                        + "CWSM_DESCARGA_MERCA_GB_VI = '" + buque.getCWSF_DESCARGA_MERCA_GB_VI() + "',"
                        + "CWSM_DESCARGA_MERCA_GP_VD = '" + buque.getCWSF_DESCARGA_MERCA_GP_VD() + "',"
                        + "CWSM_DESCARGA_MERCA_GP_VI = '" + buque.getCWSF_DESCARGA_MERCA_GP_VI() + "',"
                        + "CWSM_CARGA_MERCA_GB_VD = '" + buque.getCWSF_CARGA_MERCA_GB_VD() + "',"
                        + "CWSM_CARGA_MERCA_GB_VI = '" + buque.getCWSF_CARGA_MERCA_GB_VI() + "',"
                        + "CWSM_CARGA_MERCA_GP_VD = '" + buque.getCWSF_CARGA_MERCA_GP_VD() + "',"
                        + "CWSM_CARGA_MERCA_GP_VI = '" + buque.getCWSF_CARGA_MERCA_GP_VI() + "',"
                        + "CWSM_REEMBARQUE_LLENO_RF_GP = '" + buque.getCWSM_REEMBARQUE_LLENO_RF_GP() + "',"
                        + "CWSM_REEMBARQUE_LLENO_RF_GB = '" + buque.getCWSM_REEMBARQUE_LLENO_RF_GB() + "',"
                        + "CWSM_DESCARGA_MERCA_GP_VI_HR = '" + buque.getCWSM_DESCARGA_MERCA_GP_VI_HR() + "',"
                        + "CWSM_DESCARGA_MERCA_GP_VD_HR = '" + buque.getCWSM_DESCARGA_MERCA_GP_VD_HR() + "',"
                        + "CWSM_CARGA_MERCA_GP_VI_HR = '" + buque.getCWSM_CARGA_MERCA_GP_VI_HR() + "',"
                        + "CWSM_CARGA_MERCA_GP_VD_HR = '" + buque.getCWSM_CARGA_MERCA_GP_VD_HR() + "'"
                        + "where CWSM_COTIZACION = '" + buque.getCWBC_COTIZACION() + "'";

                st.execute(sql);
                actualizado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            actualizado = "mal" + e + buque.getCWBC_ETA();
        }

        return actualizado;
    }

    public static String Actualizar(BeanMulti buque) {
        String actualizado = null;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {

                Statement st;
                st = con.createStatement();
//                UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA
                String sql = "update COTIZADOR_WEB.CW_BUQUE_COTIZA set CWBC_ETA = TO_DATE('" + buque.getCWBC_ETA() + "', 'YYYY-MM-DD HH24:MI:SS'), CWBC_HORA='" + buque.getCWBC_HORA() + "'"
                        + "where CWBC_COTIZACION = '" + buque.getCWBC_COTIZACION() + "'";

                st.execute(sql);
                actualizado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            actualizado = "mal" + e + buque.getCWBC_ETA();
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
                String sql = "DELETE FROM cw_detalle_cotizacion WHERE cwbc_cotizacion =" + id + "";
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
