package modelo;

import controlador.Trazabilidad_Contenedores;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.LinkedList;

public class TrazabilidadContenedores {

    public static LinkedList<Trazabilidad_Contenedores> consultarCont(String entrada) throws SQLException {
        LinkedList<Trazabilidad_Contenedores> usuarios = new LinkedList<>();
        String sql = "select tc.tcf_prefijo||tc.tcf_identificacion as cont, dtc.dtcf_fecha_operacion fecha_descarga,\n" +
"puerto.busca_escaneo(tc.tcf_prefijo||tc.tcf_identificacion, "+entrada+") escaneo,\n" +
"puerto.busca_peso_salida(tc.tcf_correlativo_tarjeta) bascula,\n" +
"puerto.busca_despacho(tc.tcf_correlativo_tarjeta) salida_recinto,\n" +
"puerto.ubicacion_actual(tc.tcf_correlativo_tarjeta) ubicacion_contenedor\n" +
"from PUERTO.descarga_tarjeta_cof dtc, PUERTO.tarjeta_cof tc\n" +
"where dtc.dtcf_correlativo_tarjeta = tc.tcf_correlativo_tarjeta\n" +
"and tc.tcf_viaje_sistema = "+entrada+" ";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Trazabilidad_Contenedores user = new Trazabilidad_Contenedores();
                        user.setC1(rs.getString("cont"));
                        user.setC2(rs.getString("fecha_descarga"));
                        user.setC3(rs.getString("escaneo"));
                        user.setC4(rs.getString("bascula"));
                        user.setC5(rs.getString("salida_recinto"));
                        user.setC6(rs.getString("ubicacion_contenedor"));
                        

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

    public static LinkedList<Trazabilidad_Contenedores> consultarContPuerto(String entrada) throws SQLException {
        LinkedList<Trazabilidad_Contenedores> usuarios = new LinkedList<>();
        String sql = "SELECT  tar.tcf_correlativo_tarjeta tarjeta_kardex, tar.tcf_prefijo || tar.tcf_identificacion CONTENEDOR,DECODE (tar.tcf_refrigerado_seco,'S', 'SECO','R', 'REFRIGERADO') TIPO,\n" +
"DECODE (MAX (TARU.TCU_MODALIDAD),'V', 'VACIO','L', 'LLENO') MODALIDAD,\n" +
"TARU.TCU_PATIO PATIO, TARU.TCU_FILA FILA, TARU.TCU_MODULO MODULO, TARU.TCU_NIVEL NIVEL, tar.tcf_viaje_sistema viaje_sistema,\n" +
"(SELECT BARCO FROM PUERTO.EOPV_VIAJES WHERE VIAJE_EMPORNAC = tcf_viaje_sistema and tcf_viaje_sistema is not null) BUQUE,\n" +
"(SELECT VIAJE_NAVIERA FROM PUERTO.EOPV_VIAJES WHERE VIAJE_EMPORNAC = tcf_viaje_sistema and tcf_viaje_sistema is not null) VIAJE_BUQUE,\n" +
"puerto.busca_escaneo(tar.tcf_prefijo || tar.tcf_identificacion, tcf_viaje_sistema) escaneo,puerto.busca_peso_salida(tcf_viaje_sistema) bascula,\n" +
"(SELECT USUARIO FROM puerto.EOPT_REGISTRO_CONTENEDORES WHERE PREFIJO||NUMERO_DE_IDENTIFICACION LIKE tar.tcf_prefijo || tar.tcf_identificacion ) OPERADOR\n" +
"FROM PUERTO.tarjeta_cof tar, PUERTO.TARJETA_COF_UBICACION taru\n" +
"WHERE TAR.TCF_CORRELATIVO_TARJETA =  TARU.TCF_CORRELATIVO_TARJETA\n" +
"AND tar.tcf_estado_tarjeta = 'A'\n" +
"and tar.tcf_adentro_afuera is null\n" +
"GROUP BY tar.tcf_correlativo_tarjeta, tar.tcf_prefijo || tar.tcf_identificacion,tar.tcf_refrigerado_seco, TARU.TCU_PATIO,TARU.TCU_FILA,TARU.TCU_MODULO,TARU.TCU_NIVEL,tar.tcf_viaje_sistema";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Trazabilidad_Contenedores user = new Trazabilidad_Contenedores();
                        user.setC1(rs.getString("CONTENEDOR"));
                        user.setC2(rs.getString("OPERACION"));
                        user.setC3(rs.getString("FECHA_INGRESO"));
                        user.setC4(rs.getString("PATIO"));
//                        user.setC5(rs.getString("fila"));
//                        user.setC6(rs.getString("modulo"));
//                        user.setC7(rs.getString("nivel"));
//                        user.setC8(rs.getString("tarjeta"));
//                        user.setC9(rs.getString("viaje_sistema"));
//                        user.setC10(rs.getString("buque"));
//                        user.setC11(rs.getString("viaje_buque"));
//                        user.setC12(rs.getString("naviera"));
//                        user.setC13(rs.getString("escaneo"));
//                        user.setC14(rs.getString("bascula"));

                        System.err.println("" + rs.getString("CONTENEDOR"));

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
