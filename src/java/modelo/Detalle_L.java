package modelo;

import controlador.BeanLiquido;


import java.sql.Connection;
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
                String sql = "INSERT INTO COTIZADOR_WEB.CW_SRV_GRANELES_LIQUIDOS (CWSL_COTIZACION," +
"CWSL_DESC_ACEITE_GRASA_QUIMI," +
"CWSL_DESC_COMBUSTIBLES_DERIV," +
"CWSL_DESC_GAS_PROPANO," +
"CWSL_CARGA_ACEITE_GRASA_QUIMI," +
"CWSL_CARGA_COMBUSTIBLES_DERIV," +
"CWSL_CARGA_GAS_PROPANO," +
"GRABADOR) VALUES ('" + En.getCWSL_COTIZACION() + "','"+En.getCWSL_DESC_ACEITE_GRASA_QUIMI()+"','"+En.getCWSL_DESC_COMBUSTIBLES_DERIV()+"','"+En.getCWSL_DESC_GAS_PROPANO()+"','"+En.getCWSL_CARGA_ACEITE_GRASA_QUIMI()+"','"+En.getCWSL_CARGA_COMBUSTIBLES_DERIV()+"','"+En.getCWSL_CARGA_GAS_PROPANO()+"','"+En.getGRABADOR()+"')";
                
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
