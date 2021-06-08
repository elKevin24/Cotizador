package modelo;

import controlador.Trazabilidad_Barcos;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.LinkedList;

public class TrazabilidadBarcos {

    public static LinkedList<Trazabilidad_Barcos> consultarBarco(String entrada) throws SQLException {
        LinkedList<Trazabilidad_Barcos> usuarios = new LinkedList<>();
        String sql = "select viaje_empornac, barco, viaje_naviera,  fecha_situacion\n" +
"from puerto.eopv_viajes\n" +
"where cod_nav = "+entrada+"\n" +
"and SITUACION = 9";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Trazabilidad_Barcos user = new Trazabilidad_Barcos();
                        user.setVIAJE_EMPORNAC(rs.getString("viaje_empornac"));
                        user.setNOMBRE_DEL_BUQUE(rs.getString("barco"));
                        user.setVIAJE_NAVIERA(rs.getString("viaje_naviera"));                        
                        user.setFECHA(rs.getString("fecha_situacion"));

                        usuarios.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("" + e);

        }

        return usuarios;
    }

//    public static LinkedList<BeanBarcos> consultarBarco() throws SQLException {
//        LinkedList<BeanBarcos> usuarios = new LinkedList<>();
//
//        try {
//            Conexion c = new Conexion();
//            try (Connection con = c.getConexion()) {
//                Statement st;
//                st = con.createStatement();
//
//                try (ResultSet rs = st.executeQuery("select LR, NOMBRE_DEL_BUQUE, senal_distintiva, TRB, ESLORA from PUERTO.eopt_barcos where tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)")) {
//                    while (rs.next()) {
//                        BeanBarcos user = new BeanBarcos();
//                        user.setLR(rs.getString("LR"));
//                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
//                        user.setBANDERA(rs.getString("senal_distintiva"));
//                        user.setTRB(rs.getString("TRB"));
//                        user.setESLORA(rs.getString("ESLORA"));
//
//                        usuarios.add(user);
//                    }
//                }
//                st.close();
//            }
//        } catch (SQLException e) {
//        }
//
//        return usuarios;
//    }
//
//    public static BeanBarcos ObtenerBarcos(String id) {
//        BeanBarcos user = new BeanBarcos();
//
//        try {
//            Conexion c = new Conexion();
//            try (Connection con = c.getConexion()) {
//                Statement st;
//                st = con.createStatement();
//                try (ResultSet rs = st.executeQuery("SELECT DISTINCT LR, NOMBRE_DEL_BUQUE, SENAL_DISTINTIVA, TRB, ESLORA\n"
//                        + "FROM(\n"
//                        + "SELECT A.LR, A.NOMBRE_DEL_BUQUE NOMBRE_DEL_BUQUE, A.SENAL_DISTINTIVA, A.TRB, A.ESLORA\n"
//                        + "FROM PUERTO.EOPT_BARCOS A\n"
//                        + "WHERE LR = " + id + "\n"
//                        + "UNION\n"
//                        + "SELECT B.LR, B.NOMBRE_DEL_BUQUE NOMBRE_DEL_BUQUE, B.SENAL_DISTINTIVA, B.TRB, B.ESLORA\n"
//                        + "FROM CW_EOPT_BARCOS B\n"
//                        + "WHERE LR = " + id + ")")) {
//                    while (rs.next()) {
//
//                        user.setLR(rs.getString("LR"));
//                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
//                        user.setBANDERA(rs.getString("senal_distintiva"));
//                        user.setTRB(rs.getString("TRB"));
//                        user.setESLORA(rs.getString("ESLORA"));
//
//                    }
//                }
//                st.close();
//            }
//        } catch (SQLException e) {
//        }
//        return user;
//
//    }
}
