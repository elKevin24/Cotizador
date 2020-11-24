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
    
    
    public static BeanSolido ObtenerDetalle(String Cotizacion) {
        BeanSolido user = new BeanSolido();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT CWSS_COTIZACION ,\n" +
"CWSS_DESC_GRANEL_SOLIDO ,\n" +
"CWSS_DESC_GRANEL_SOLIDO_PONTON ,\n" +
"CWSS_CARGA_GRANEL_SOLIDO ,\n" +
"CWSS_CARG_GRANEL_SOLIDO_PONTON ,\n" +
"GRABADOR FROM \n" +
"CW_SRV_GRANELES_SOLIDOS\n" +
"WHERE CWSS_COTIZACION = "+Cotizacion+"")) {
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

}
