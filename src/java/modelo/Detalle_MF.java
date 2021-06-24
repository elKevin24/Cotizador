package modelo;

import controlador.BeanMultiFrigo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Detalle_MF {

    public static String agregarDetalleMF(BeanMultiFrigo En) {
        String agregado = null;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.CW_SRV_MULTIPROPOSITOS_FRIGO (CWSF_COTIZACION, CWSF_MUELLAJE_COF_IMPORT, CWSF_MUELLAJE_COF_EXPORT, CWSF_DESCARGA_LLENOS_GB_VI, CWSF_DESCARGA_LLENOS_GB_VD,CWSF_DESCARGA_LLENOS_GP_VI,CWSF_DESCARGA_LLENOS_GP_VD, CWSF_DESCARGA_VACIOS_GB_VI, CWSF_DESCARGA_VACIOS_GB_VD, CWSF_DESCARGA_VACIOS_GP_VI, CWSF_DESCARGA_VACIOS_GP_VD, CWSF_CARGA_LLENOS_GB_VI, CWSF_CARGA_LLENOS_GB_VD, CWSF_CARGA_LLENOS_GP_VI, CWSF_CARGA_LLENOS_GP_VD, "
                        + "CWSF_CARGA_VACIOS_GB_VI, CWSF_CARGA_VACIOS_GB_VD, CWSF_CARGA_VACIOS_GP_VI, CWSF_CARGA_VACIOS_GP_VD, CWSF_DESCARGA_VEHICULOS_GB,  CWSF_DESCARGA_VEHICULOS_GP, CWSF_REESTIBAS_GB, CWSF_REESTIBAS_GP, "
                        + "CWSF_TAPA_ESCOTILLAS_GB, CWSF_TAPA_ESCOTILLAS_GP, CWSF_DEPOSITO_TEMP_LLENO_GB, CWSF_DEPOSITO_TEMP_LLENO_GP,CWSF_DEPOSITO_TEMP_VACIO_GB, CWSF_DEPOSITO_TEMP_VACIO_GP,"
                        + "CWSF_REEMBARQUE_LLENO_GB, CWSF_REEMBARQUE_LLENO_GP, CWSF_REEMBARQUE_VACIO_GB, CWSF_REEMBARQUE_VACIO_GP,"
                        + "CWSF_DEPOSITO_MOMENT_GB, CWSF_DEPOSITO_MOMENT_GP,"
                        + "CWSF_DESCARGA_MERCA_GB_VD, CWSF_DESCARGA_MERCA_GB_VI, CWSF_DESCARGA_MERCA_GP_VD, CWSF_DESCARGA_MERCA_GP_VI,"
                        + "CWSF_CARGA_MERCA_GB_VD, CWSF_CARGA_MERCA_GB_VI,CWSF_CARGA_MERCA_GP_VD,CWSF_CARGA_MERCA_GP_VI,"
                        + "CWSF_CARGA_FRUTA_PALE_GB_VD, CWSF_CARGA_FRUTA_PALE_GB_VI,CWSF_CARGA_FRUTA_PALE_GP_VD,CWSF_CARGA_FRUTA_PALE_GP_VI,"
                        + "GRABADOR, GRABADOR_FECHA, "
                        + "CWSF_REEMBARQUE_LLENO_RF_GP, "
                        + "CWSF_REEMBARQUE_LLENO_RF_GB,"
                        + "CWSF_DESCARGA_MERCA_GP_VD_HR, "
                        + "CWSF_DESCARGA_MERCA_GP_VI_HR, "
                        + "CWSF_CARGA_MERCA_GP_VD_HR, "
                        + "CWSF_CARGA_MERCA_GP_VI_HR, "
                        + "CWSF_CARGA_FRUTA_PALE_GP_VI_HR, "
                        + "CWSF_CARGA_FRUTA_PALE_GP_VD_HR, "
                        + "CWSF_DESCA_FRUTA_PALE_GP_VI_HR, "
                        + "CWSF_DESCA_FRUTA_PALE_GP_VD_HR, "
                        + "CWSF_DESCARGA_FRUTA_PALE_GB_VD, "
                        + "CWSF_DESCARGA_FRUTA_PALE_GB_VI, "
                        + "CWSF_DESCARGA_FRUTA_PALE_GP_VD, "
                        + "CWSF_DESCARGA_FRUTA_PALE_GP_VI) VALUES "
                        + "('" + En.getCWBC_COTIZACION() + "','" + En.getCWSF_MUELLAJE_COF_IMPORT() + "','" + En.getCWSF_MUELLAJE_COF_EXPORT() + "','" + En.getCWSF_DESCARGA_LLENOS_GB_VI() + "','" + En.getCWSF_DESCARGA_LLENOS_GB_VD() + "','" + En.getCWSF_DESCARGA_LLENOS_GP_VI() + "','" + En.getCWSF_DESCARGA_LLENOS_GP_VD() + "','" + En.getCWSF_DESCARGA_VACIOS_GB_VI() + "','" + En.getCWSF_DESCARGA_VACIOS_GB_VD() + "','" + En.getCWSF_DESCARGA_VACIOS_GP_VI() + "','" + En.getCWSF_DESCARGA_VACIOS_GP_VD() + "' ,'" + En.getCWSF_CARGA_LLENOS_GB_VI() + "', '" + En.getCWSF_CARGA_LLENOS_GB_VD() + "' ,'" + En.getCWSF_CARGA_LLENOS_GP_VI() + "' ,'" + En.getCWSF_CARGA_LLENOS_GP_VD() + "',"
                        + "'" + En.getCWSF_CARGA_VACIOS_GB_VI() + "','" + En.getCWSF_CARGA_VACIOS_GB_VD() + "','" + En.getCWSF_CARGA_VACIOS_GP_VI() + "','" + En.getCWSF_CARGA_VACIOS_GP_VD() + "','" + En.getCWSF_DESCARGA_VEHICULOS_GB() + "','" + En.getCWSF_DESCARGA_VEHICULOS_GP() + "','" + En.getCWSF_REESTIBAS_GB() + "','" + En.getCWSF_REESTIBAS_GP() + "',"
                        + "'" + En.getCWSF_TAPA_ESCOTILLAS_GB() + "','" + En.getCWSF_TAPA_ESCOTILLAS_GP() + "','" + En.getCWSF_DEPOSITO_TEMP_LLENO_GB() + "','" + En.getCWSF_DEPOSITO_TEMP_LLENO_GP() + "','" + En.getCWSF_DEPOSITO_TEMP_VACIO_GB() + "','" + En.getCWSF_DEPOSITO_TEMP_VACIO_GP() + "',"
                        + "'" + En.getCWSF_REEMBARQUE_LLENO_GB() + "','" + En.getCWSF_REEMBARQUE_LLENO_GP() + "','" + En.getCWSF_REEMBARQUE_VACIO_GB() + "','" + En.getCWSF_REEMBARQUE_VACIO_GP() + "',"
                        + "'" + En.getCWSF_DEPOSITO_MOMENT_GB() + "','" + En.getCWSF_DEPOSITO_MOMENT_GP() + "',"
                        + "'" + En.getCWSF_DESCARGA_MERCA_GB_VD() + "','" + En.getCWSF_DESCARGA_MERCA_GB_VI() + "','" + En.getCWSF_DESCARGA_MERCA_GP_VD() + "','" + En.getCWSF_DESCARGA_MERCA_GP_VI() + "',"
                        + "'" + En.getCWSF_CARGA_MERCA_GB_VD() + "','" + En.getCWSF_CARGA_MERCA_GB_VI() + "','" + En.getCWSF_CARGA_MERCA_GP_VD() + "','" + En.getCWSF_CARGA_MERCA_GP_VI() + "',"
                        + "'" + En.getCWSF_CARGA_FRUTA_PALE_GB_VD() + "','" + En.getCWSF_CARGA_FRUTA_PALE_GB_VI() + "','" + En.getCWSF_CARGA_FRUTA_PALE_GP_VD() + "','" + En.getCWSF_CARGA_FRUTA_PALE_GP_VI() + "',"
                        + "'" + En.getGRABADOR() + "', sysdate,"
                        + "'" + En.getCWSF_REEMBARQUE_LLENO_RF_GP() + "',"
                        + "'" + En.getCWSF_REEMBARQUE_LLENO_RF_GB() + "',"
                        + "'" + En.getCWSF_DESCARGA_MERCA_GP_VD_HR() + "',"
                        + "'" + En.getCWSF_DESCARGA_MERCA_GP_VI_HR() + "',"
                        + "'" + En.getCWSF_CARGA_MERCA_GP_VD_HR() + "',"
                        + "'" + En.getCWSF_CARGA_MERCA_GP_VI_HR() + "',"
                        + "'" + En.getCWSF_CARGA_FRUTA_PALE_GP_VI_HR() + "',"
                        + "'" + En.getCWSF_CARGA_FRUTA_PALE_GP_VD_HR() + "',"
                        + "'" + En.getCWSF_DESCA_FRUTA_PALE_GP_VI_HR() + "',"
                        + "'" + En.getCWSF_DESCA_FRUTA_PALE_GP_VD_HR() + "',"
                        + "'" + En.getCWSF_DESCARGA_FRUTA_PALE_GB_VD() + "',"
                        + "'" + En.getCWSF_DESCARGA_FRUTA_PALE_GB_VI() + "',"
                        + "'" + En.getCWSF_DESCARGA_FRUTA_PALE_GP_VD() + "',"
                        + "'" + En.getCWSF_DESCARGA_FRUTA_PALE_GP_VI() + "'"
                        + ")";

                st.execute(sql);

                agregado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            agregado = "mal: " + e;
        }
        return agregado;
    }

    public static BeanMultiFrigo Obtenerxedit(String id) {
        BeanMultiFrigo user = new BeanMultiFrigo();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT cwbc_cotizacion, CWBC_HORA, cwbc_eta,"
                        + "    CWSF_MUELLAJE_COF_IMPORT,"
                        + "CWSF_MUELLAJE_COF_EXPORT,"
                        + "CWSF_DESCARGA_LLENOS_GB_VI,"
                        + "CWSF_DESCARGA_LLENOS_GB_VD,"
                        + "CWSF_DESCARGA_LLENOS_GP_VI,"
                        + "CWSF_DESCARGA_LLENOS_GP_VD,"
                        + "CWSF_DESCARGA_VACIOS_GB_VI,"
                        + "CWSF_DESCARGA_VACIOS_GB_VD,"
                        + "CWSF_DESCARGA_VACIOS_GP_VI,"
                        + "CWSF_DESCARGA_VACIOS_GP_VD,"
                        + "CWSF_CARGA_LLENOS_GB_VI,"
                        + "CWSF_CARGA_LLENOS_GB_VD,"
                        + "CWSF_CARGA_LLENOS_GP_VI,"
                        + "CWSF_CARGA_LLENOS_GP_VD,"
                        + "CWSF_CARGA_VACIOS_GB_VI,"
                        + "CWSF_CARGA_VACIOS_GB_VD,"
                        + "CWSF_CARGA_VACIOS_GP_VI,"
                        + "CWSF_CARGA_VACIOS_GP_VD,"
                        + "CWSF_DESCARGA_VEHICULOS_GB,"
                        + "CWSF_DESCARGA_VEHICULOS_GP,"
                        + "CWSF_REESTIBAS_GB,"
                        + "CWSF_REESTIBAS_GP,"
                        + "CWSF_TAPA_ESCOTILLAS_GB,"
                        + "CWSF_TAPA_ESCOTILLAS_GP,"
                        + "CWSF_DEPOSITO_TEMP_LLENO_GB,"
                        + "CWSF_DEPOSITO_TEMP_LLENO_GP,"
                        + "CWSF_DEPOSITO_TEMP_VACIO_GB,"
                        + "CWSF_DEPOSITO_TEMP_VACIO_GP,"
                        + "CWSF_REEMBARQUE_LLENO_GB,"
                        + "CWSF_REEMBARQUE_LLENO_GP,"
                        + "CWSF_REEMBARQUE_VACIO_GB,"
                        + "CWSF_REEMBARQUE_VACIO_GP,"
                        + "CWSF_DEPOSITO_MOMENT_GB,"
                        + "CWSF_DEPOSITO_MOMENT_GP,"
                        + "CWSF_DESCARGA_MERCA_GB_VD,"
                        + "CWSF_DESCARGA_MERCA_GB_VI,"
                        + "CWSF_DESCARGA_MERCA_GP_VD,"
                        + "CWSF_DESCARGA_MERCA_GP_VI,"
                        + "CWSF_CARGA_MERCA_GB_VD,"
                        + "CWSF_CARGA_MERCA_GB_VI,"
                        + "CWSF_CARGA_MERCA_GP_VD,"
                        + "CWSF_CARGA_MERCA_GP_VI,"
                        + "CWSF_CARGA_FRUTA_PALE_GB_VD,"
                        + "CWSF_CARGA_FRUTA_PALE_GB_VI,"
                        + "CWSF_CARGA_FRUTA_PALE_GP_VD,"
                        + "CWSF_CARGA_FRUTA_PALE_GP_VI, CWSF_REEMBARQUE_LLENO_RF_GP,"
                        + "CWSF_REEMBARQUE_LLENO_RF_GB,"
                        + "CWSF_DESCARGA_MERCA_GP_VD_HR,"
                        + "CWSF_DESCARGA_MERCA_GP_VI_HR,"
                        + "CWSF_CARGA_MERCA_GP_VD_HR,"
                        + "CWSF_CARGA_MERCA_GP_VI_HR,"
                        + "CWSF_CARGA_FRUTA_PALE_GP_VI_HR,"
                        + "CWSF_CARGA_FRUTA_PALE_GP_VD_HR,"
                        + "CWSF_DESCA_FRUTA_PALE_GP_VI_HR,"
                        + "CWSF_DESCA_FRUTA_PALE_GP_VD_HR,"
                        + "CWSF_DESCARGA_FRUTA_PALE_GB_VD,"
                        + "CWSF_DESCARGA_FRUTA_PALE_GB_VI,"
                        + "CWSF_DESCARGA_FRUTA_PALE_GP_VD,"
                        + "CWSF_DESCARGA_FRUTA_PALE_GP_VI"
                        + "    FROM COTIZADOR_WEB.CW_BUQUE_COTIZA A  RIGHT OUTER JOIN  COTIZADOR_WEB.cw_srv_multipropositos_frigo B"
                        + "   ON A.CWBC_COTIZACION = B.CWsf_COTIZACION"
                        + "   WHERE CWBC_COTIZACION = " + id + "")) {
                    while (rs.next()) {

                        user.setCWBC_COTIZACION(rs.getString("cwbc_cotizacion"));
                        user.setCWBC_HORA(rs.getString("CWBC_HORA"));
                        user.setCWBC_ETA(rs.getString("cwbc_eta"));
                        user.setCWSF_MUELLAJE_COF_IMPORT(rs.getString("CWSF_MUELLAJE_COF_IMPORT"));
                        user.setCWSF_DESCARGA_LLENOS_GB_VI(rs.getString("CWSF_DESCARGA_LLENOS_GB_VI"));
                        user.setCWSF_DESCARGA_LLENOS_GB_VD(rs.getString("CWSF_DESCARGA_LLENOS_GB_VD"));
                        user.setCWSF_DESCARGA_LLENOS_GP_VI(rs.getString("CWSF_DESCARGA_LLENOS_GP_VI"));
                        user.setCWSF_DESCARGA_LLENOS_GP_VD(rs.getString("CWSF_DESCARGA_LLENOS_GP_VD"));

                        user.setCWSF_DESCARGA_VACIOS_GB_VI(rs.getString("CWSF_DESCARGA_VACIOS_GB_VI"));
                        user.setCWSF_DESCARGA_VACIOS_GB_VD(rs.getString("CWSF_DESCARGA_VACIOS_GB_VD"));
                        user.setCWSF_DESCARGA_VACIOS_GP_VI(rs.getString("CWSF_DESCARGA_VACIOS_GP_VI"));
                        user.setCWSF_DESCARGA_VACIOS_GP_VD(rs.getString("CWSF_DESCARGA_VACIOS_GP_VD"));

                        user.setCWSF_CARGA_LLENOS_GB_VI(rs.getString("CWSF_CARGA_LLENOS_GB_VI"));
                        user.setCWSF_CARGA_LLENOS_GB_VD(rs.getString("CWSF_CARGA_LLENOS_GB_VD"));
                        user.setCWSF_CARGA_LLENOS_GP_VI(rs.getString("CWSF_CARGA_LLENOS_GP_VI"));
                        user.setCWSF_CARGA_LLENOS_GP_VD(rs.getString("CWSF_CARGA_LLENOS_GP_VD"));

                        user.setCWSF_CARGA_VACIOS_GB_VI(rs.getString("CWSF_CARGA_VACIOS_GB_VI"));
                        user.setCWSF_CARGA_VACIOS_GB_VD(rs.getString("CWSF_CARGA_VACIOS_GB_VD"));
                        user.setCWSF_CARGA_VACIOS_GP_VI(rs.getString("CWSF_CARGA_VACIOS_GP_VI"));
                        user.setCWSF_CARGA_VACIOS_GP_VD(rs.getString("CWSF_CARGA_VACIOS_GP_VD"));

                        user.setCWSF_DESCARGA_VEHICULOS_GB(rs.getString("CWSF_DESCARGA_VEHICULOS_GB"));
                        user.setCWSF_DESCARGA_VEHICULOS_GP(rs.getString("CWSF_DESCARGA_VEHICULOS_GP"));

                        user.setCWSF_REESTIBAS_GB(rs.getString("CWSF_REESTIBAS_GB"));
                        user.setCWSF_REESTIBAS_GP(rs.getString("CWSF_REESTIBAS_GP"));

                        user.setCWSF_TAPA_ESCOTILLAS_GB(rs.getString("CWSF_TAPA_ESCOTILLAS_GB"));
                        user.setCWSF_TAPA_ESCOTILLAS_GP(rs.getString("CWSF_TAPA_ESCOTILLAS_GP"));

                        user.setCWSF_DEPOSITO_TEMP_LLENO_GB(rs.getString("CWSF_DEPOSITO_TEMP_LLENO_GB"));
                        user.setCWSF_DEPOSITO_TEMP_LLENO_GP(rs.getString("CWSF_DEPOSITO_TEMP_LLENO_GP"));
                        user.setCWSF_DEPOSITO_TEMP_VACIO_GB(rs.getString("CWSF_DEPOSITO_TEMP_VACIO_GB"));
                        user.setCWSF_DEPOSITO_TEMP_VACIO_GP(rs.getString("CWSF_DEPOSITO_TEMP_VACIO_GP"));

                        user.setCWSF_REEMBARQUE_LLENO_GB(rs.getString("CWSF_REEMBARQUE_LLENO_GB"));
                        user.setCWSF_REEMBARQUE_LLENO_GP(rs.getString("CWSF_REEMBARQUE_LLENO_GP"));
                        user.setCWSF_REEMBARQUE_VACIO_GB(rs.getString("CWSF_REEMBARQUE_VACIO_GB"));
                        user.setCWSF_REEMBARQUE_VACIO_GP(rs.getString("CWSF_REEMBARQUE_VACIO_GP"));

                        user.setCWSF_REEMBARQUE_LLENO_RF_GP(rs.getString("CWSF_REEMBARQUE_LLENO_RF_GP"));
                        user.setCWSF_REEMBARQUE_LLENO_RF_GB(rs.getString("CWSF_REEMBARQUE_LLENO_RF_GB"));

                        user.setCWSF_DEPOSITO_MOMENT_GB(rs.getString("CWSF_DEPOSITO_MOMENT_GB"));
                        user.setCWSF_DEPOSITO_MOMENT_GP(rs.getString("CWSF_DEPOSITO_MOMENT_GP"));

                        user.setCWSF_DESCARGA_MERCA_GB_VD(rs.getString("CWSF_DESCARGA_MERCA_GB_VD"));
                        user.setCWSF_DESCARGA_MERCA_GB_VI(rs.getString("CWSF_DESCARGA_MERCA_GB_VI"));
                        user.setCWSF_DESCARGA_MERCA_GP_VD(rs.getString("CWSF_DESCARGA_MERCA_GP_VD"));
                        user.setCWSF_DESCARGA_MERCA_GP_VI(rs.getString("CWSF_DESCARGA_MERCA_GP_VI"));

                        user.setCWSF_CARGA_MERCA_GB_VD(rs.getString("CWSF_CARGA_MERCA_GB_VD"));
                        user.setCWSF_CARGA_MERCA_GB_VI(rs.getString("CWSF_CARGA_MERCA_GB_VI"));
                        user.setCWSF_CARGA_MERCA_GP_VD(rs.getString("CWSF_CARGA_MERCA_GP_VD"));
                        user.setCWSF_CARGA_MERCA_GP_VI(rs.getString("CWSF_CARGA_MERCA_GP_VI"));

                        user.setCWSF_CARGA_FRUTA_PALE_GB_VD(rs.getString("CWSF_CARGA_FRUTA_PALE_GB_VD"));
                        user.setCWSF_CARGA_FRUTA_PALE_GB_VI(rs.getString("CWSF_CARGA_FRUTA_PALE_GB_VI"));
                        user.setCWSF_CARGA_FRUTA_PALE_GP_VD(rs.getString("CWSF_CARGA_FRUTA_PALE_GP_VD"));
                        user.setCWSF_CARGA_FRUTA_PALE_GP_VI(rs.getString("CWSF_CARGA_FRUTA_PALE_GP_VI"));

                        user.setCWSF_DESCARGA_MERCA_GP_VD_HR(rs.getString("CWSF_DESCARGA_MERCA_GP_VD_HR"));
                        user.setCWSF_DESCARGA_MERCA_GP_VI_HR(rs.getString("CWSF_DESCARGA_MERCA_GP_VI_HR"));

                        user.setCWSF_CARGA_MERCA_GP_VD_HR(rs.getString("CWSF_CARGA_MERCA_GP_VD_HR"));
                        user.setCWSF_CARGA_MERCA_GP_VI_HR(rs.getString("CWSF_CARGA_MERCA_GP_VI_HR"));

                        user.setCWSF_CARGA_FRUTA_PALE_GP_VI_HR(rs.getString("CWSF_CARGA_FRUTA_PALE_GP_VI_HR"));
                        user.setCWSF_CARGA_FRUTA_PALE_GP_VD_HR(rs.getString("CWSF_CARGA_FRUTA_PALE_GP_VD_HR"));
                        user.setCWSF_DESCA_FRUTA_PALE_GP_VI_HR(rs.getString("CWSF_DESCA_FRUTA_PALE_GP_VI_HR"));
                        user.setCWSF_DESCA_FRUTA_PALE_GP_VD_HR(rs.getString("CWSF_DESCA_FRUTA_PALE_GP_VD_HR"));

                        user.setCWSF_DESCARGA_FRUTA_PALE_GB_VD(rs.getString("CWSF_DESCARGA_FRUTA_PALE_GB_VD"));
                        user.setCWSF_DESCARGA_FRUTA_PALE_GB_VI(rs.getString("CWSF_DESCARGA_FRUTA_PALE_GB_VI"));
                        user.setCWSF_DESCARGA_FRUTA_PALE_GP_VD(rs.getString("CWSF_DESCARGA_FRUTA_PALE_GP_VD"));
                        user.setCWSF_DESCARGA_FRUTA_PALE_GP_VI(rs.getString("CWSF_DESCARGA_FRUTA_PALE_GP_VI"));

                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;

    }

    public static String ActualizarDetalle(BeanMultiFrigo buque) {
        String actualizado = null;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {

                Statement st;
                st = con.createStatement();
//                UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA

                String sql = " update COTIZADOR_WEB.cw_srv_multipropositos_frigo SET "
                        + "CWSF_MUELLAJE_COF_IMPORT = '" + buque.getCWSF_MUELLAJE_COF_IMPORT() + "',"
                        + "CWSF_DESCARGA_LLENOS_GB_VI = '" + buque.getCWSF_DESCARGA_LLENOS_GB_VI() + "',"
                        + "CWSF_DESCARGA_LLENOS_GB_VD = '" + buque.getCWSF_DESCARGA_LLENOS_GB_VD() + "',"
                        + "CWSF_DESCARGA_LLENOS_GP_VI = '" + buque.getCWSF_DESCARGA_LLENOS_GP_VI() + "',"
                        + "CWSF_DESCARGA_LLENOS_GP_VD = '" + buque.getCWSF_DESCARGA_LLENOS_GP_VD() + "',"
                        + "CWSF_DESCARGA_VACIOS_GB_VI = '" + buque.getCWSF_DESCARGA_VACIOS_GB_VI() + "',"
                        + "CWSF_DESCARGA_VACIOS_GB_VD = '" + buque.getCWSF_DESCARGA_VACIOS_GB_VD() + "',"
                        + "CWSF_DESCARGA_VACIOS_GP_VI = '" + buque.getCWSF_DESCARGA_VACIOS_GP_VI() + "',"
                        + "CWSF_DESCARGA_VACIOS_GP_VD = '" + buque.getCWSF_DESCARGA_VACIOS_GP_VD() + "',"
                        + "CWSF_CARGA_LLENOS_GB_VI = '" + buque.getCWSF_CARGA_LLENOS_GB_VI() + "',"
                        + "CWSF_CARGA_LLENOS_GB_VD = '" + buque.getCWSF_CARGA_LLENOS_GB_VD() + "',"
                        + "CWSF_CARGA_LLENOS_GP_VI = '" + buque.getCWSF_CARGA_LLENOS_GP_VI() + "',"
                        + "CWSF_CARGA_LLENOS_GP_VD = '" + buque.getCWSF_CARGA_LLENOS_GP_VD() + "',"
                        + "CWSF_CARGA_VACIOS_GB_VI = '" + buque.getCWSF_CARGA_VACIOS_GB_VI() + "',"
                        + "CWSF_CARGA_VACIOS_GB_VD = '" + buque.getCWSF_CARGA_VACIOS_GB_VD() + "',"
                        + "CWSF_CARGA_VACIOS_GP_VI = '" + buque.getCWSF_CARGA_VACIOS_GP_VI() + "',"
                        + "CWSF_CARGA_VACIOS_GP_VD = '" + buque.getCWSF_CARGA_VACIOS_GP_VD() + "',"
                        + "CWSF_DESCARGA_VEHICULOS_GB = '" + buque.getCWSF_DESCARGA_VEHICULOS_GB() + "',"
                        + "CWSF_DESCARGA_VEHICULOS_GP = '" + buque.getCWSF_DESCARGA_VEHICULOS_GP() + "',"
                        + "CWSF_REESTIBAS_GB = '" + buque.getCWSF_REESTIBAS_GB() + "',"
                        + "CWSF_REESTIBAS_GP = '" + buque.getCWSF_REESTIBAS_GP() + "',"
                        + "CWSF_TAPA_ESCOTILLAS_GB = '" + buque.getCWSF_TAPA_ESCOTILLAS_GB() + "',"
                        + "CWSF_TAPA_ESCOTILLAS_GP = '" + buque.getCWSF_TAPA_ESCOTILLAS_GP() + "',"
                        + "CWSF_DEPOSITO_MOMENT_GP = '" + buque.getCWSF_DEPOSITO_MOMENT_GP() + "',"
                        + "CWSF_DEPOSITO_MOMENT_GB = '" + buque.getCWSF_DEPOSITO_MOMENT_GB() + "',"
                        + "CWSF_DEPOSITO_TEMP_LLENO_GB = '" + buque.getCWSF_DEPOSITO_TEMP_LLENO_GB() + "',"
                        + "CWSF_DEPOSITO_TEMP_LLENO_GP = '" + buque.getCWSF_DEPOSITO_TEMP_LLENO_GP() + "',"
                        + "CWSF_DEPOSITO_TEMP_VACIO_GB = '" + buque.getCWSF_DEPOSITO_TEMP_VACIO_GB() + "',"
                        + "CWSF_DEPOSITO_TEMP_VACIO_GP = '" + buque.getCWSF_DEPOSITO_TEMP_VACIO_GP() + "',"
                        + "CWSF_REEMBARQUE_LLENO_GB = '" + buque.getCWSF_REEMBARQUE_LLENO_GB() + "',"
                        + "CWSF_REEMBARQUE_LLENO_GP = '" + buque.getCWSF_REEMBARQUE_LLENO_GP() + "',"
                        + "CWSF_REEMBARQUE_VACIO_GB = '" + buque.getCWSF_REEMBARQUE_VACIO_GB() + "',"
                        + "CWSF_REEMBARQUE_VACIO_GP = '" + buque.getCWSF_REEMBARQUE_VACIO_GP() + "',"
                        + "CWSF_REEMBARQUE_LLENO_RF_GP = '" + buque.getCWSF_REEMBARQUE_LLENO_RF_GP() + "',"
                        + "CWSF_REEMBARQUE_LLENO_RF_GB = '" + buque.getCWSF_REEMBARQUE_LLENO_RF_GB() + "',"
                        + "CWSF_DESCARGA_MERCA_GB_VD = '" + buque.getCWSF_DESCARGA_MERCA_GB_VD() + "',"
                        + "CWSF_DESCARGA_MERCA_GB_VI = '" + buque.getCWSF_DESCARGA_MERCA_GB_VI() + "',"
                        + "CWSF_DESCARGA_MERCA_GP_VD = '" + buque.getCWSF_DESCARGA_MERCA_GP_VD() + "',"
                        + "CWSF_DESCARGA_MERCA_GP_VI = '" + buque.getCWSF_DESCARGA_MERCA_GP_VI() + "',"
                        + "CWSF_CARGA_MERCA_GB_VD = '" + buque.getCWSF_CARGA_MERCA_GB_VD() + "',"
                        + "CWSF_CARGA_MERCA_GB_VI = '" + buque.getCWSF_CARGA_MERCA_GB_VI() + "',"
                        + "CWSF_CARGA_MERCA_GP_VD = '" + buque.getCWSF_CARGA_MERCA_GP_VD() + "',"
                        + "CWSF_CARGA_MERCA_GP_VI = '" + buque.getCWSF_CARGA_MERCA_GP_VI() + "',"
                        + "CWSF_DESCARGA_MERCA_GP_VD_HR = '" + buque.getCWSF_DESCARGA_MERCA_GP_VD_HR() + "',"
                        + "CWSF_DESCARGA_MERCA_GP_VI_HR = '" + buque.getCWSF_DESCARGA_MERCA_GP_VI_HR() + "',"
                        + "CWSF_CARGA_MERCA_GP_VD_HR = '" + buque.getCWSF_CARGA_MERCA_GP_VD_HR() + "', "
                        + "CWSF_CARGA_MERCA_GP_VI_HR = '" + buque.getCWSF_CARGA_MERCA_GP_VI_HR() + "',"
                        
                         + "CWSF_CARGA_FRUTA_PALE_GB_VD = '" + buque.getCWSF_CARGA_FRUTA_PALE_GB_VD() + "', "
                        + "CWSF_CARGA_FRUTA_PALE_GB_VI = '" + buque.getCWSF_CARGA_FRUTA_PALE_GB_VI() + "', "
                        + "CWSF_CARGA_FRUTA_PALE_GP_VD = '" + buque.getCWSF_CARGA_FRUTA_PALE_GP_VD() + "', "
                        + "CWSF_CARGA_FRUTA_PALE_GP_VI = '" + buque.getCWSF_CARGA_FRUTA_PALE_GP_VI() + "', "
                      
                        
                        + "CWSF_CARGA_FRUTA_PALE_GP_VI_HR = '" + buque.getCWSF_CARGA_FRUTA_PALE_GP_VI_HR() + "', "
                        + "CWSF_CARGA_FRUTA_PALE_GP_VD_HR = '" + buque.getCWSF_CARGA_FRUTA_PALE_GP_VD_HR() + "', "
                        + "CWSF_DESCA_FRUTA_PALE_GP_VI_HR = '" + buque.getCWSF_DESCA_FRUTA_PALE_GP_VI_HR() + "', "
                        + "CWSF_DESCA_FRUTA_PALE_GP_VD_HR = '" + buque.getCWSF_DESCA_FRUTA_PALE_GP_VD_HR() + "', "
                        
                        + "CWSF_DESCARGA_FRUTA_PALE_GB_VD = '" + buque.getCWSF_DESCARGA_FRUTA_PALE_GB_VD() + "', "
                        + "CWSF_DESCARGA_FRUTA_PALE_GB_VI = '" + buque.getCWSF_DESCARGA_FRUTA_PALE_GB_VI() + "', "
                        + "CWSF_DESCARGA_FRUTA_PALE_GP_VD = '" + buque.getCWSF_DESCARGA_FRUTA_PALE_GP_VD() + "', "
                        + "CWSF_DESCARGA_FRUTA_PALE_GP_VI = '" + buque.getCWSF_DESCARGA_FRUTA_PALE_GP_VI() + "'"
                        
                      
                        + "where CWSF_COTIZACION = '" + buque.getCWBC_COTIZACION() + "'";

                st.execute(sql);
                actualizado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            actualizado = "mal" + e + buque.getCWBC_ETA();
        }

        return actualizado;
    }

    public static String Actualizar(BeanMultiFrigo buque) {
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
