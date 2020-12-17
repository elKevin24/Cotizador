package modelo;

import controlador.BeanMulti;

import java.sql.Connection;
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

}
