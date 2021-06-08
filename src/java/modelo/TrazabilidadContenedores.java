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
"and tc.tcf_viaje_sistema = "+entrada+"";

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
        String sql = "SELECT CONTENEDOR,OPERACION,FECHA_INGRESO,PATIO,FILA,MODULO,NIVEL, TARJETA, viaje_sistema, BUQUE,VIAJE_BUQUE, NAVIERA, escaneo, bascula\n"
                + "FROM (\n"
                + "SELECT  CONTENEDOR,OPERACION,FECHA_INGRESO,PATIO,FILA,MODULO,NIVEL,TARJETA_KARDEX TARJETA, viaje_sistema,\n"
                + "        (SELECT BARCO FROM PUERTO.EOPV_VIAJES WHERE VIAJE_EMPORNAC = VIAJE_SISTEMA and 'IMPORT' = OPERACION) BUQUE,\n"
                + "        (SELECT VIAJE_NAVIERA FROM PUERTO.EOPV_VIAJES WHERE VIAJE_EMPORNAC = VIAJE_SISTEMA and 'IMPORT' = OPERACION) VIAJE_BUQUE,\n"
                + "        (SELECT COD_NAV FROM PUERTO.EOPV_VIAJES WHERE VIAJE_EMPORNAC = VIAJE_SISTEMA) NAVIERA,\n"
                + "        puerto.busca_escaneo(CONTENEDOR, viaje_sistema) escaneo,\n"
                + "        puerto.busca_peso_salida(viaje_sistema) bascula\n"
                + "               FROM (  SELECT   tar.tcf_correlativo_tarjeta tarjeta_kardex,\n"
                + "                                tar.tcf_prefijo || tar.tcf_identificacion CONTENEDOR,\n"
                + "                                --DECODE (tar.tcf_refrigerado_seco,'S', 'SECO','R', 'REFRIGERADO') TIPO,\n"
                + "                                Decode(MAX (des.dtcf_fecha_operacion), nvl(MAX (rec.rtcf_fecha_operacion),MAX (des.dtcf_fecha_operacion)),NVL(puerto.F_MODALIDAD_CONTE(MAX (DES.DTCF_CORRELATIVO_DESCARGA), tar.tcf_prefijo || tar.tcf_identificacion),'IMPORT'),'EXPORT') OPERACION,\n"
                + "                                TO_CHAR(  (Decode(MAX (des.dtcf_fecha_operacion), nvl(MAX (rec.rtcf_fecha_operacion),MAX (des.dtcf_fecha_operacion)),MAX (des.dtcf_fecha_operacion),MAX (rec.rtcf_fecha_operacion))),'YYYY/MM/DD hh24:mi') FECHA_INGRESO,\n"
                + "                                MAX (rec.rtcf_fecha_operacion) fecha_recepcion, MAX (des.dtcf_fecha_operacion) fecha_descarga, MAX (DESP.DTCF_FECHA_OPERACION) fecha_despacho, MAX (DES.DTCF_CORRELATIVO_DESCARGA) VIAJE_DESCARGA,\n"
                + "                                --DECODE (MAX (TARU.TCU_MODALIDAD),'V', 'VACIO','L', 'LLENO') MODALIDAD,\n"
                + "                                TARU.TCU_PATIO PATIO, TARU.TCU_FILA FILA, TARU.TCU_MODULO MODULO, TARU.TCU_NIVEL NIVEL,\n"
                + "                                --TAR.tcf_observaciones observaciones,\n"
                + "                                tar.tcf_viaje_sistema viaje_sistema\n"
                + "                        FROM PUERTO.tarjeta_cof tar, PUERTO.TARJETA_COF_UBICACION taru, PUERTO.descarga_tarjeta_cof des,PUERTO.recepcion_tarjeta_cof rec, PUERTO.DESPACHO_TARJETA_COF DESP\n"
                + "                        WHERE TAR.TCF_CORRELATIVO_TARJETA =  TARU.TCF_CORRELATIVO_TARJETA\n"
                + "                              AND tar.tcf_correlativo_tarjeta = des.dtcf_correlativo_tarjeta(+)\n"
                + "                              AND tar.tcf_correlativo_tarjeta = rec.rtcf_correlativo_tarjeta(+)\n"
                + "                              AND tar.tcf_correlativo_tarjeta = DESP.DTCF_CORRELATIVO_TARJETA(+)\n"
                + "                              AND tcf_estado_tarjeta = 'A'\n"
                + "                     GROUP BY tar.tcf_correlativo_tarjeta, tar.tcf_prefijo || tar.tcf_identificacion, TARU.TCU_PATIO,TARU.TCU_FILA,TARU.TCU_MODULO,TARU.TCU_NIVEL, tar.tcf_viaje_sistema\n"
                + "                    )\n"
                + "                    where nvl(fecha_recepcion,fecha_descarga)> nvl((fecha_despacho+1.5),sysdate-8000)\n"
                + "                    ORDER BY  FECHA_INGRESO desc NULLS LAST\n"
                + "                    )where NAVIERA = " + entrada + " FETCH NEXT 10 ROWS ONLY ";

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
