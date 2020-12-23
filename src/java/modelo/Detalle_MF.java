package modelo;

import controlador.BeanMultiFrigo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
                        + "('" + En.getCWBC_COTIZACION() + "','"+En.getCWSF_MUELLAJE_COF_IMPORT()+"','"+En.getCWSF_MUELLAJE_COF_EXPORT()+"','"+En.getCWSF_DESCARGA_LLENOS_GB_VI()+"','"+En.getCWSF_DESCARGA_LLENOS_GB_VD()+"','"+En.getCWSF_DESCARGA_LLENOS_GP_VI()+"','"+En.getCWSF_DESCARGA_LLENOS_GP_VD()+"','"+En.getCWSF_DESCARGA_VACIOS_GB_VI()+"','"+En.getCWSF_DESCARGA_VACIOS_GB_VD()+"','"+En.getCWSF_DESCARGA_VACIOS_GP_VI()+"','"+En.getCWSF_DESCARGA_VACIOS_GP_VD()+"' ,'"+En.getCWSF_CARGA_LLENOS_GB_VI()+"', '"+En.getCWSF_CARGA_LLENOS_GB_VD()+"' ,'"+En.getCWSF_CARGA_LLENOS_GP_VI()+"' ,'"+En.getCWSF_CARGA_LLENOS_GP_VD()+"',"
                        + "'"+ En.getCWSF_CARGA_VACIOS_GB_VI()+"','"+En.getCWSF_CARGA_VACIOS_GB_VD()+"','"+En.getCWSF_CARGA_VACIOS_GP_VI()+"','"+En.getCWSF_CARGA_VACIOS_GP_VD()+"','"+En.getCWSF_DESCARGA_VEHICULOS_GB()+"','"+En.getCWSF_DESCARGA_VEHICULOS_GP()+"','"+En.getCWSF_REESTIBAS_GB()+"','"+En.getCWSF_REESTIBAS_GP()+"',"
                        + "'"+ En.getCWSF_TAPA_ESCOTILLAS_GB()+"','"+ En.getCWSF_TAPA_ESCOTILLAS_GP()+"','"+ En.getCWSF_DEPOSITO_TEMP_LLENO_GB()+"','"+ En.getCWSF_DEPOSITO_TEMP_LLENO_GP()+"','"+ En.getCWSF_DEPOSITO_TEMP_VACIO_GB()+"','"+ En.getCWSF_DEPOSITO_TEMP_VACIO_GP()+"',"
                        + "'"+ En.getCWSF_REEMBARQUE_LLENO_GB()+"','"+ En.getCWSF_REEMBARQUE_LLENO_GP()+"','"+ En.getCWSF_REEMBARQUE_VACIO_GB()+"','"+ En.getCWSF_REEMBARQUE_VACIO_GP()+"',"
                        + "'"+ En.getCWSF_DEPOSITO_MOMENT_GB()+"','"+ En.getCWSF_DEPOSITO_MOMENT_GP()+"',"
                        + "'"+ En.getCWSF_DESCARGA_MERCA_GB_VD()+"','"+ En.getCWSF_DESCARGA_MERCA_GB_VI()+"','"+ En.getCWSF_DESCARGA_MERCA_GP_VD()+"','"+ En.getCWSF_DESCARGA_MERCA_GP_VI()+"',"
                        + "'"+ En.getCWSF_CARGA_MERCA_GB_VD()+"','"+ En.getCWSF_CARGA_MERCA_GB_VI()+"','"+ En.getCWSF_CARGA_MERCA_GP_VD()+"','"+ En.getCWSF_CARGA_MERCA_GP_VI()+"',"
                        + "'"+ En.getCWSF_CARGA_FRUTA_PALE_GB_VD()+"','"+ En.getCWSF_CARGA_FRUTA_PALE_GB_VI()+"','"+ En.getCWSF_CARGA_FRUTA_PALE_GP_VD()+"','"+ En.getCWSF_CARGA_FRUTA_PALE_GP_VI()+"',"
                        + "'"+En.getGRABADOR()+"', sysdate,"
                        + "'"+En.getCWSF_REEMBARQUE_LLENO_RF_GP()+"',"
                        + "'"+En.getCWSF_REEMBARQUE_LLENO_RF_GB()+"',"
                        + "'"+En.getCWSF_DESCARGA_MERCA_GP_VD_HR()+"',"
                        + "'"+En.getCWSF_DESCARGA_MERCA_GP_VI_HR()+"',"
                        + "'"+En.getCWSF_CARGA_MERCA_GP_VD_HR()+"',"
                        + "'"+En.getCWSF_CARGA_MERCA_GP_VI_HR()+"',"
                        + "'"+En.getCWSF_CARGA_FRUTA_PALE_GP_VI_HR()+"',"
                        + "'"+En.getCWSF_CARGA_FRUTA_PALE_GP_VD_HR()+"',"
                        + "'"+En.getCWSF_DESCA_FRUTA_PALE_GP_VI_HR()+"',"
                        + "'"+En.getCWSF_DESCA_FRUTA_PALE_GP_VD_HR()+"',"
                        + "'"+En.getCWSF_DESCARGA_FRUTA_PALE_GB_VD()+"',"
                        + "'"+En.getCWSF_DESCARGA_FRUTA_PALE_GB_VI()+"',"
                        + "'"+En.getCWSF_DESCARGA_FRUTA_PALE_GP_VD()+"',"
                        + "'"+En.getCWSF_DESCARGA_FRUTA_PALE_GP_VI ()+"'"
                        + ")";
                
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
