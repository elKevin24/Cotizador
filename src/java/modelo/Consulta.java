package modelo;

import controlador.BeanBarcos;
import controlador.BeanConsulta;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.LinkedList;

public class Consulta {

    public static LinkedList<BeanConsulta> CotizacionEliminados(String entrada) throws SQLException {
        LinkedList<BeanConsulta> usuarios = new LinkedList<>();
        String sql;

        sql = "select \n"
                + "A.CWBC_COTIZACION,\n"
                + "A.CWBC_LR,\n"
                + "A.CWBC_SENAL_DISTINTIVA,\n"
                + "A.CWBC_BUQUE_VIAJE,\n"
                + "B.NOMBRE_DEL_BUQUE,\n"
                + "B.BANDERA,\n"
                + "A.CWBC_ETA,\n"
                + "A.CWBC_TIPO_CAMBIO,\n"
                + "A.CWBC_TIPO_CAMBIO_FECHA,\n"
                + "A.CWBC_USUARIO_SERVICIO,\n"
                + "A.CWBC_NIT,\n"
                + "A.CWBC_TIPO_OPERACION,\n"
                + "A.GRABADOR,\n"
                + "A.GRABADOR_FECHA,\n"
                + "A.ACTUALIZADOR,\n"
                + "A.ACTUALIZADOR_FECHA,\n"
                + "A.CWBC_ESTADO,\n"
                + "A.CWBC_HORA \n"
                + "from CW_BUQUE_COTIZA A, PUERTO.eopt_barcos B\n"
                + "WHERE A.CWBC_LR = B.LR \n"
                + "AND CWBC_USUARIO_SERVICIO = " + entrada + "\n"
                + "AND A.CWBC_ESTADO = 4\n"
                + "and tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanConsulta user = new BeanConsulta();
                        user.setCWBC_COTIZACION(rs.getString("CWBC_COTIZACION"));
                        user.setCWBC_LR(rs.getString("CWBC_LR"));
                        user.setCWBC_SENAL_DISTINTIVA(rs.getString("CWBC_SENAL_DISTINTIVA"));
                        user.setCWBC_BUQUE_VIAJE(rs.getString("CWBC_BUQUE_VIAJE"));
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
                        user.setBANDERA(rs.getString("BANDERA"));
                        user.setCWBC_ETA(rs.getString("CWBC_ETA"));
                        user.setCWBC_TIPO_CAMBIO(rs.getString("CWBC_TIPO_CAMBIO"));
                        user.setCWBC_TIPO_CAMBIO_FECHA(rs.getString("CWBC_TIPO_CAMBIO_FECHA"));
                        user.setCWBC_USUARIO_SERVICIO(rs.getString("CWBC_USUARIO_SERVICIO"));
                        user.setCWBC_NIT(rs.getString("CWBC_NIT"));
                        user.setCWBC_TIPO_OPERACION(rs.getString("CWBC_TIPO_OPERACION"));
                        user.setGRABADOR(rs.getString("GRABADOR"));
                        user.setGRABADOR_FECHA(rs.getString("GRABADOR_FECHA"));
                        user.setACTUALIZADOR(rs.getString("ACTUALIZADOR"));
                        user.setACTUALIZADOR_FECHA(rs.getString("ACTUALIZADOR_FECHA"));
                        user.setCWBC_ESTADO(rs.getString("CWBC_ESTADO"));
                        user.setCWBC_HORA(rs.getString("CWBC_HORA"));

                        usuarios.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }

        return usuarios;
    }
    
    public static LinkedList<BeanConsulta> Creados(String entrada) throws SQLException {
        LinkedList<BeanConsulta> usuarios = new LinkedList<>();
        String sql = "select \n" +
"A.CWBC_COTIZACION,\n" +
"A.CWBC_LR,\n" +
"A.CWBC_SENAL_DISTINTIVA,\n" +
"A.CWBC_BUQUE_VIAJE,\n" +
"B.NOMBRE_DEL_BUQUE,\n" +
"B.BANDERA,\n" +
"A.CWBC_ETA,\n" +
"A.CWBC_TIPO_CAMBIO,\n" +
"A.CWBC_TIPO_CAMBIO_FECHA,\n" +
"A.CWBC_USUARIO_SERVICIO,\n" +
"A.CWBC_NIT,\n" +
"C.CWTO_OPERACION,\n" +
"A.GRABADOR,\n" +
"A.GRABADOR_FECHA,\n" +
"A.ACTUALIZADOR,\n" +
"A.ACTUALIZADOR_FECHA,\n" +
"A.CWBC_ESTADO,\n" +
"A.CWBC_HORA \n" +
"from CW_BUQUE_COTIZA A, CW_TIPO_OPERACION C, PUERTO.eopt_barcos B\n" +
"WHERE A.CWBC_LR = B.LR \n" +
"AND CWBC_USUARIO_SERVICIO = "+entrada+"\n" +
"and a.cwbc_tipo_operacion = C.CWTO_TIPO_OPERACION\n" +
"AND A.CWBC_ESTADO = 1\n" +
"and tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanConsulta user = new BeanConsulta();
                        user.setCWBC_COTIZACION(rs.getString("CWBC_COTIZACION"));
                        user.setCWBC_LR(rs.getString("CWBC_LR"));
                        user.setCWBC_SENAL_DISTINTIVA(rs.getString("CWBC_SENAL_DISTINTIVA"));
                        user.setCWBC_BUQUE_VIAJE(rs.getString("CWBC_BUQUE_VIAJE"));
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
                        user.setBANDERA(rs.getString("BANDERA"));
                        user.setCWBC_ETA(rs.getString("CWBC_ETA"));
                        user.setCWBC_TIPO_CAMBIO(rs.getString("CWBC_TIPO_CAMBIO"));
                        user.setCWBC_TIPO_CAMBIO_FECHA(rs.getString("CWBC_TIPO_CAMBIO_FECHA"));
                        user.setCWBC_USUARIO_SERVICIO(rs.getString("CWBC_USUARIO_SERVICIO"));
                        user.setCWBC_NIT(rs.getString("CWBC_NIT"));
                        user.setCWBC_TIPO_OPERACION(rs.getString("CWTO_OPERACION"));
                        user.setGRABADOR(rs.getString("GRABADOR"));
                        user.setGRABADOR_FECHA(rs.getString("GRABADOR_FECHA"));
                        user.setACTUALIZADOR(rs.getString("ACTUALIZADOR"));
                        user.setACTUALIZADOR_FECHA(rs.getString("ACTUALIZADOR_FECHA"));
                        user.setCWBC_ESTADO(rs.getString("CWBC_ESTADO"));
                        user.setCWBC_HORA(rs.getString("CWBC_HORA"));

                        usuarios.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }

        return usuarios;
    }
    
    public static BeanConsulta ConsultaCreado(String id)
{                  
    BeanConsulta user = new BeanConsulta();
               
     try        
      {        
    Conexion c=new Conexion();
        try (Connection con = c.getConexion()) {
            Statement st;
            st = con.createStatement();
        try (ResultSet rs = st.executeQuery("select \n" +
"A.CWBC_COTIZACION,\n" +
"A.CWBC_LR,\n" +
"A.CWBC_SENAL_DISTINTIVA,\n" +
"A.CWBC_BUQUE_VIAJE,\n" +
"B.NOMBRE_DEL_BUQUE,\n" +
"B.BANDERA,\n" +
"A.CWBC_ETA,\n" +
"A.CWBC_TIPO_CAMBIO,\n" +
"A.CWBC_TIPO_CAMBIO_FECHA,\n" +
"A.CWBC_USUARIO_SERVICIO,\n" +
"A.CWBC_NIT,\n" +
"C.CWTO_OPERACION,\n" +
"A.GRABADOR,\n" +
"A.GRABADOR_FECHA,\n" +
"A.ACTUALIZADOR,\n" +
"A.ACTUALIZADOR_FECHA,\n" +
"A.CWBC_ESTADO,\n" +
"A.CWBC_HORA \n" +
"from CW_BUQUE_COTIZA A, CW_TIPO_OPERACION C, PUERTO.eopt_barcos B\n" +
"WHERE A.CWBC_LR = B.LR \n" +
"and a.cwbc_tipo_operacion = C.CWTO_TIPO_OPERACION\n" +
"and tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)\n" +
"AND A.CWBC_COTIZACION = "+id+"")) {
            while (rs.next())
            {
                
                user.setCWBC_COTIZACION(rs.getString("CWBC_COTIZACION"));
                        user.setCWBC_LR(rs.getString("CWBC_LR"));
                        user.setCWBC_SENAL_DISTINTIVA(rs.getString("CWBC_SENAL_DISTINTIVA"));
                        user.setCWBC_BUQUE_VIAJE(rs.getString("CWBC_BUQUE_VIAJE"));
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
                        user.setBANDERA(rs.getString("BANDERA"));
                        user.setCWBC_ETA(rs.getString("CWBC_ETA"));
                        user.setCWBC_TIPO_CAMBIO(rs.getString("CWBC_TIPO_CAMBIO"));
                        user.setCWBC_TIPO_CAMBIO_FECHA(rs.getString("CWBC_TIPO_CAMBIO_FECHA"));
                        user.setCWBC_USUARIO_SERVICIO(rs.getString("CWBC_USUARIO_SERVICIO"));
                        user.setCWBC_NIT(rs.getString("CWBC_NIT"));
                        user.setCWBC_TIPO_OPERACION(rs.getString("CWTO_OPERACION"));
                        user.setGRABADOR(rs.getString("GRABADOR"));
                        user.setGRABADOR_FECHA(rs.getString("GRABADOR_FECHA"));
                        user.setACTUALIZADOR(rs.getString("ACTUALIZADOR"));
                        user.setACTUALIZADOR_FECHA(rs.getString("ACTUALIZADOR_FECHA"));
                        user.setCWBC_ESTADO(rs.getString("CWBC_ESTADO"));
                        user.setCWBC_HORA(rs.getString("CWBC_HORA"));
                
                 
            }
        }
            st.close();
        }
      }
     catch(SQLException e)
     {
     }
    return user;
    
}   
    
    public static LinkedList<BeanConsulta> Pendientes(String entrada) throws SQLException {
        LinkedList<BeanConsulta> usuarios = new LinkedList<>();
        String sql;

        sql = "select \n"
                + "A.CWBC_COTIZACION,\n"
                + "A.CWBC_LR,\n"
                + "A.CWBC_SENAL_DISTINTIVA,\n"
                + "A.CWBC_BUQUE_VIAJE,\n"
                + "B.NOMBRE_DEL_BUQUE,\n"
                + "B.BANDERA,\n"
                + "A.CWBC_ETA,\n"
                + "A.CWBC_TIPO_CAMBIO,\n"
                + "A.CWBC_TIPO_CAMBIO_FECHA,\n"
                + "A.CWBC_USUARIO_SERVICIO,\n"
                + "A.CWBC_NIT,\n"
                + "A.CWBC_TIPO_OPERACION,\n"
                + "A.GRABADOR,\n"
                + "A.GRABADOR_FECHA,\n"
                + "A.ACTUALIZADOR,\n"
                + "A.ACTUALIZADOR_FECHA,\n"
                + "A.CWBC_ESTADO,\n"
                + "A.CWBC_HORA \n"
                + "from CW_BUQUE_COTIZA A, PUERTO.eopt_barcos B\n"
                + "WHERE A.CWBC_LR = B.LR \n"
                + "AND CWBC_USUARIO_SERVICIO = " + entrada + "\n"
                + "AND A.CWBC_ESTADO = 2\n"
                + "and tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanConsulta user = new BeanConsulta();
                        user.setCWBC_COTIZACION(rs.getString("CWBC_COTIZACION"));
                        user.setCWBC_LR(rs.getString("CWBC_LR"));
                        user.setCWBC_SENAL_DISTINTIVA(rs.getString("CWBC_SENAL_DISTINTIVA"));
                        user.setCWBC_BUQUE_VIAJE(rs.getString("CWBC_BUQUE_VIAJE"));
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
                        user.setBANDERA(rs.getString("BANDERA"));
                        user.setCWBC_ETA(rs.getString("CWBC_ETA"));
                        user.setCWBC_TIPO_CAMBIO(rs.getString("CWBC_TIPO_CAMBIO"));
                        user.setCWBC_TIPO_CAMBIO_FECHA(rs.getString("CWBC_TIPO_CAMBIO_FECHA"));
                        user.setCWBC_USUARIO_SERVICIO(rs.getString("CWBC_USUARIO_SERVICIO"));
                        user.setCWBC_NIT(rs.getString("CWBC_NIT"));
                        user.setCWBC_TIPO_OPERACION(rs.getString("CWBC_TIPO_OPERACION"));
                        user.setGRABADOR(rs.getString("GRABADOR"));
                        user.setGRABADOR_FECHA(rs.getString("GRABADOR_FECHA"));
                        user.setACTUALIZADOR(rs.getString("ACTUALIZADOR"));
                        user.setACTUALIZADOR_FECHA(rs.getString("ACTUALIZADOR_FECHA"));
                        user.setCWBC_ESTADO(rs.getString("CWBC_ESTADO"));
                        user.setCWBC_HORA(rs.getString("CWBC_HORA"));

                        usuarios.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }

        return usuarios;
    }
    
    public static LinkedList<BeanConsulta> AprobadoComercial(String entrada) throws SQLException {
        LinkedList<BeanConsulta> usuarios = new LinkedList<>();
        String sql;

        sql = "select \n"
                + "A.CWBC_COTIZACION,\n"
                + "A.CWBC_LR,\n"
                + "A.CWBC_SENAL_DISTINTIVA,\n"
                + "A.CWBC_BUQUE_VIAJE,\n"
                + "B.NOMBRE_DEL_BUQUE,\n"
                + "B.BANDERA,\n"
                + "A.CWBC_ETA,\n"
                + "A.CWBC_TIPO_CAMBIO,\n"
                + "A.CWBC_TIPO_CAMBIO_FECHA,\n"
                + "A.CWBC_USUARIO_SERVICIO,\n"
                + "A.CWBC_NIT,\n"
                + "A.CWBC_TIPO_OPERACION,\n"
                + "A.GRABADOR,\n"
                + "A.GRABADOR_FECHA,\n"
                + "A.ACTUALIZADOR,\n"
                + "A.ACTUALIZADOR_FECHA,\n"
                + "A.CWBC_ESTADO,\n"
                + "A.CWBC_HORA \n"
                + "from CW_BUQUE_COTIZA A, PUERTO.eopt_barcos B\n"
                + "WHERE A.CWBC_LR = B.LR \n"
                + "AND CWBC_USUARIO_SERVICIO = " + entrada + "\n"
                + "AND A.CWBC_ESTADO = 3\n"
                + "and tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanConsulta user = new BeanConsulta();
                        user.setCWBC_COTIZACION(rs.getString("CWBC_COTIZACION"));
                        user.setCWBC_LR(rs.getString("CWBC_LR"));
                        user.setCWBC_SENAL_DISTINTIVA(rs.getString("CWBC_SENAL_DISTINTIVA"));
                        user.setCWBC_BUQUE_VIAJE(rs.getString("CWBC_BUQUE_VIAJE"));
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
                        user.setBANDERA(rs.getString("BANDERA"));
                        user.setCWBC_ETA(rs.getString("CWBC_ETA"));
                        user.setCWBC_TIPO_CAMBIO(rs.getString("CWBC_TIPO_CAMBIO"));
                        user.setCWBC_TIPO_CAMBIO_FECHA(rs.getString("CWBC_TIPO_CAMBIO_FECHA"));
                        user.setCWBC_USUARIO_SERVICIO(rs.getString("CWBC_USUARIO_SERVICIO"));
                        user.setCWBC_NIT(rs.getString("CWBC_NIT"));
                        user.setCWBC_TIPO_OPERACION(rs.getString("CWBC_TIPO_OPERACION"));
                        user.setGRABADOR(rs.getString("GRABADOR"));
                        user.setGRABADOR_FECHA(rs.getString("GRABADOR_FECHA"));
                        user.setACTUALIZADOR(rs.getString("ACTUALIZADOR"));
                        user.setACTUALIZADOR_FECHA(rs.getString("ACTUALIZADOR_FECHA"));
                        user.setCWBC_ESTADO(rs.getString("CWBC_ESTADO"));
                        user.setCWBC_HORA(rs.getString("CWBC_HORA"));

                        usuarios.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }

        return usuarios;
    }

}
