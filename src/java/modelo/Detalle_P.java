package modelo;

import controlador.BeanPorta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Detalle_P {

    public static boolean agregarDetalle(BeanPorta En) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.CW_SRV_PORTACONTENEDORES (CWSP_COTIZACION," +
"CWSP_MUELLAJE_COF_IMPORT," +
"CWSP_MUELLAJE_COF_EXPORT," +
"CWSP_DESCARGA_LLENOS_GB_VI," +
"CWSP_DESCARGA_LLENOS_GB_VD," +
"CWSP_DESCARGA_LLENOS_GP_VI," +
"CWSP_DESCARGA_LLENOS_GP_VD," +
"CWSP_DESCARGA_VACIOS_GB_VI," +
"CWSP_DESCARGA_VACIOS_GB_VD," +
"CWSP_DESCARGA_VACIOS_GP_VI," +
"CWSP_DESCARGA_VACIOS_GP_VD," +
"CWSP_CARGA_LLENOS_GB_VI," +
"CWSP_CARGA_LLENOS_GB_VD," +
"CWSP_CARGA_LLENOS_GP_VI," +
"CWSP_CARGA_LLENOS_GP_VD," +
"CWSP_CARGA_VACIOS_GB_VI," +
"CWSP_CARGA_VACIOS_GB_VD," +
"CWSP_CARGA_VACIOS_GP_VI," +
"CWSP_CARGA_VACIOS_GP_VD," +
"CWSP_DESCARGA_VEHICULOS_GB," +
"CWSP_DESCARGA_VEHICULOS_GP," +
"CWSP_REESTIBAS_GB," +
"CWSP_REESTIBAS_GP," +
"CWSP_TAPA_ESCOTILLAS_GB," +
"CWSP_TAPA_ESCOTILLAS_GP," +
"CWSP_DEPOSITO_TEMP_LLENO_GB," +
"CWSP_DEPOSITO_TEMP_LLENO_GP," +
"CWSP_DEPOSITO_TEMP_VACIO_GB," +
"CWSP_DEPOSITO_TEMP_VACIO_GP," +
"CWSP_REEMBARQUE_LLENO_GB," +
"CWSP_REEMBARQUE_LLENO_GP," +
"CWSP_REEMBARQUE_VACIO_GB," +
"CWSP_REEMBARQUE_VACIO_GP," +
"CWSP_DEPOSITO_MOMENT_LLENO_GB," +
"CWSP_DEPOSITO_MOMENT_LLENO_GP," +
"CWSP_DEPOSITO_MOMENT_VACIO_GB," +
"CWSP_DEPOSITO_MOMENT_VACIO_GP," +
"GRABADOR) VALUES "
                        + "('" + En.getCWBC_COTIZACION() + "','"+En.getCWSF_MUELLAJE_COF_IMPORT()+"','"+En.getCWSF_MUELLAJE_COF_EXPORT()+"','"+En.getCWSF_DESCARGA_LLENOS_GB_VI()+"','"+En.getCWSF_DESCARGA_LLENOS_GB_VD()+"','"+En.getCWSF_DESCARGA_LLENOS_GP_VI()+"','"+En.getCWSF_DESCARGA_LLENOS_GP_VD()+"','"+En.getCWSF_DESCARGA_VACIOS_GB_VI()+"','"+En.getCWSF_DESCARGA_VACIOS_GB_VD()+"','"+En.getCWSF_DESCARGA_VACIOS_GP_VI()+"','"+En.getCWSF_DESCARGA_VACIOS_GP_VD()+"' ,'"+En.getCWSF_CARGA_LLENOS_GB_VI()+"', '"+En.getCWSF_CARGA_LLENOS_GB_VD()+"' ,'"+En.getCWSF_CARGA_LLENOS_GP_VI()+"' ,'"+En.getCWSF_CARGA_LLENOS_GP_VD()+"',"
                        + "'"+ En.getCWSF_CARGA_VACIOS_GB_VI()+"','"+En.getCWSF_CARGA_VACIOS_GB_VD()+"','"+En.getCWSF_CARGA_VACIOS_GP_VI()+"','"+En.getCWSF_CARGA_VACIOS_GP_VD()+"','"+En.getCWSF_DESCARGA_VEHICULOS_GB()+"','"+En.getCWSF_DESCARGA_VEHICULOS_GP()+"','"+En.getCWSF_REESTIBAS_GB()+"','"+En.getCWSF_REESTIBAS_GP()+"',"
                        + "'"+ En.getCWSF_TAPA_ESCOTILLAS_GB()+"','"+ En.getCWSF_TAPA_ESCOTILLAS_GP()+"','"+ En.getCWSF_DEPOSITO_TEMP_LLENO_GB()+"','"+ En.getCWSF_DEPOSITO_TEMP_LLENO_GP()+"','"+ En.getCWSF_DEPOSITO_TEMP_VACIO_GB()+"','"+ En.getCWSF_DEPOSITO_TEMP_VACIO_GP()+"',"
                        + "'"+ En.getCWSF_REEMBARQUE_LLENO_GB()+"','"+ En.getCWSF_REEMBARQUE_LLENO_GP()+"','"+ En.getCWSF_REEMBARQUE_VACIO_GB()+"','"+ En.getCWSF_REEMBARQUE_VACIO_GP()+"',"
                        + "'"+ En.getCWSF_DEPOSITO_MOMENT_LLENO_GB()+"','"+ En.getCWSF_DEPOSITO_MOMENT_LLENO_GP()+"','"+ En.getCWSF_DEPOSITO_MOMENT_VACIO_GB()+"','"+ En.getCWSF_DEPOSITO_MOMENT_VACIO_GP()+"',"
                        + "'"+En.getGRABADOR()+"')";
                
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
