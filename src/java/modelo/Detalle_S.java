package modelo;


import controlador.BeanSolido;
import java.sql.Connection;
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
                String sql = "INSERT INTO COTIZADOR_WEB.CW_SRV_GRANELES_SOLIDOS (CWSS_COTIZACION," +
"CWSS_DESC_GRANEL_SOLIDO," +
"CWSS_DESC_GRANEL_SOLIDO_PONTON," +
"CWSS_CARGA_GRANEL_SOLIDO," +
"CWSS_CARG_GRANEL_SOLIDO_PONTON," +

"GRABADOR) VALUES ('" + En.getCWSL_COTIZACION() + "','"+En.getCWSL_DESC_ACEITE_GRASA_QUIMI()+"','"+En.getCWSL_DESC_COMBUSTIBLES_DERIV()+"','"+En.getCWSL_CARGA_ACEITE_GRASA_QUIMI()+"','"+En.getCWSL_CARGA_COMBUSTIBLES_DERIV()+"','"+En.getGRABADOR()+"')";
                
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
