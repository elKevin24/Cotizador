package modelo;

import controlador.BeanEncabezado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Encabezado {

    public static boolean agregarEncabezado(BeanEncabezado En) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.CW_BUQUE_COTIZA (CWBC_COTIZACION, CWBC_LR, CWBC_SENAL_DISTINTIVA, CWBC_ETA, CWBC_TIPO_CAMBIO, CWBC_TIPO_CAMBIO_FECHA, CWBC_USUARIO_SERVICIO, CWBC_NIT, CWBC_TIPO_OPERACION, GRABADOR, CWBC_HORA) VALUES "
                        + "('"+ En.getCWBC_COTIZACION()+"','"+En.getCWBC_LR()+"','"+En.getCWBC_SENAL_DISTINTIVA()+"',TO_DATE('"+En.getCWBC_ETA()+"', 'YYYY-MM-DD HH24:MI:SS'),"+En.getCWBC_TIPO_CAMBIO()+" ,TO_DATE('"+En.getCWBC_TIPO_CAMBIO_FECHA()+"','YYYY-MM-DD' ),'"+En.getCWBC_USUARIO_SERVICIO()+"' ,'"+En.getCWBC_NIT()+"','"+En.getCWBC_TIPO_OPERACION()+"','"+En.getGRABADOR()+"','"+En.getCWBC_HORA()+"')";

//    "INSERT INTO COTIZADOR_WEB.CW_BUQUE_COTIZA (CWBC_COTIZACION, CWBC_LR, CWBC_SENAL_DISTINTIVA, CWBC_BUQUE_VIAJE, CWBC_ETA, CWBC_TIPO_CAMBIO, CWBC_TIPO_CAMBIO_FECHA, CWBC_USUARIO_SERVICIO, CWBC_NIT, CWBC_TIPO_OPERACION, GRABADOR) \n" +
//"                                        VALUES ('"+En.getCWBC_COTIZACION()+"','"+En.getCWBC_LR()+"','"+En.getCWBC_BUQUE_VIAJE()+"','"+En.getCWBC_ETA()+"','"+En.getCWBC_TIPO_CAMBIO()+"','"+En.getCWBC_TIPO_CAMBIO_FECHA()+"','"+En.getCWBC_USUARIO_SERVICIO()+"','"+En.getCWBC_NIT()+"','"+En.getCWBC_TIPO_OPERACION()+"','"+En.getCWBC_GRABADOR()+"')";
                System.out.println(sql);
                st.execute(sql);

                agregado = true;
                st.close();
            }

        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }

    public static BeanEncabezado ObtenerCotizacion() {

        BeanEncabezado user = new BeanEncabezado();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("select CC_NEXT_VALUE+1 COTIZACION from PUERTO.CG_CODE_CONTROLS a WHERE CC_DOMAIN = 'NUMERO_COTIZACION_WEB'")) {
                    while (rs.next()) {
                        user.setCWBC_COTIZACION(rs.getString("COTIZACION"));
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;

    }
    
    
    public static BeanEncabezado ObtenerCotizacion1() {

        BeanEncabezado user = new BeanEncabezado();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT PUERTO.F_CG_CODE_CONTROLS(1,'NUMERO_COTIZACION_WEB') COTIZACION FROM DUAL")) {
                    while (rs.next()) {
                        user.setCWBC_COTIZACION(rs.getString("COTIZACION"));
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;

    }
    
    public static boolean CambiarEstado(String id) {
        boolean actualizado = false;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA
                String sql = "update COTIZADOR_WEB.CW_BUQUE_COTIZA set CWBC_ESTADO = 4 where CWBC_COTIZACION =" + id + "";
                //"update tbl_seccion set grado ='"+usuario.getGrado()+"', seccion='"+usuario.getSeccion()+"', Id_nivel='"+usuario.getId_nivel()+"' where Id_seccion="+usuario.getId_seccion()+"";

                st.execute(sql);
                actualizado = true;
                st.close();
            }

        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }
    
    
    

    public static BeanEncabezado CotizacionGeneral(String id) {

        BeanEncabezado user = new BeanEncabezado();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT CWBC_COTIZACION, cwbc_lr, cwbc_senal_distintiva, cwbc_eta, cwbc_tipo_cambio,cwto_operacion, cw_buque_cotiza.grabador FROM\n" +
"CW_BUQUE_COTIZA , CW_TIPO_OPERACION \n" +
"where CWBC_TIPO_OPERACION = CWTO_TIPO_OPERACION\n" +
"AND CWBC_COTIZACION = '"+id+"'")) {
                    while (rs.next()) {
                        user.setCWBC_COTIZACION(rs.getString("CWBC_COTIZACION"));
                        user.setCWBC_LR(rs.getString("cwbc_lr"));
                        user.setCWBC_SENAL_DISTINTIVA(rs.getString("cwbc_senal_distintiva"));
                        user.setCWBC_ETA(rs.getString("cwbc_eta"));
                        user.setCWBC_TIPO_CAMBIO(rs.getDouble("cwbc_tipo_cambio"));
                        user.setCWBC_TIPO_OPERACION(rs.getString("cwto_operacion"));
                        user.setGRABADOR(rs.getString("grabador"));
                        
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;

    }
    
     

        public static BeanEncabezado Cotizacion(String id) {

        BeanEncabezado user = new BeanEncabezado();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT CWBC_COTIZACION,  cwbc_lr, puerto.eopt_barcos.nombre_del_buque, CWBC_SENAL_DISTINTIVA,CWBC_ETA , CWBC_TIPO_CAMBIO , CWBC_TIPO_CAMBIO_FECHA , NOMBRE , CWBC_NIT , CWTO_OPERACION,\n" +
"cw_buque_cotiza.grabador\n" +
"FROM \n" +
"CW_BUQUE_COTIZA, cw_tipo_operacion, PUERTO.eopt_barcos, FINANCIERO.ASFT_USUARIOS_DE_SERVICIOS\n" +
"where CWBC_TIPO_OPERACION = CWTO_TIPO_OPERACION \n" +
"AND CWBC_LR = puerto.eopt_barcos.lr\n" +
"AND CWBC_USUARIO_SERVICIO = financiero.asft_usuarios_de_servicios.codigo\n" +
"AND CWBC_COTIZACION = "+id+"")) {
                    while (rs.next()) {
                        user.setCWBC_COTIZACION(rs.getString("CWBC_COTIZACION"));
                        user.setCWBC_LR(rs.getString("cwbc_lr"));
                        user.setCWBC_BUQUE_VIAJE(rs.getString("nombre_del_buque"));
                        user.setCWBC_SENAL_DISTINTIVA(rs.getString("cwbc_senal_distintiva"));
                        
                        user.setCWBC_ETA(rs.getString("cwbc_eta"));
                        
                        user.setCWBC_TIPO_CAMBIO(rs.getDouble("cwbc_tipo_cambio"));
                        user.setCWBC_TIPO_CAMBIO_FECHA(rs.getString("CWBC_TIPO_CAMBIO_FECHA"));
                        
                        user.setCWBC_TIPO_OPERACION(rs.getString("CWTO_OPERACION"));
                        user.setCWBC_USUARIO_SERVICIO(rs.getString("NOMBRE"));
                        user.setGRABADOR(rs.getString("grabador"));
                        
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;

    }
    

    public static LinkedList<BeanEncabezado> CotizacionesBarco(String id) throws SQLException {
        LinkedList<BeanEncabezado> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("SELECT CWBC_COTIZACION, cwbc_lr, cwbc_senal_distintiva, cwbc_eta, cwbc_tipo_cambio, cwbc_tipo_cambio_fecha,  cwto_operacion  FROM\n" +
"CW_BUQUE_COTIZA , CW_TIPO_OPERACION \n" +
"where CWBC_TIPO_OPERACION = CWTO_TIPO_OPERACION\n" +
"AND CWBC_LR ='" + id + "' ORDER BY CWBC_COTIZACION")) {
                    while (rs.next()) {
                        BeanEncabezado user = new BeanEncabezado();
                        user.setCWBC_COTIZACION(rs.getString("CWBC_COTIZACION"));
                        user.setCWBC_LR(rs.getString("CWBC_LR"));
                        user.setCWBC_SENAL_DISTINTIVA(rs.getString("CWBC_SENAL_DISTINTIVA"));
                        user.setCWBC_ETA(rs.getString("CWBC_ETA"));
                        user.setCWBC_TIPO_CAMBIO(rs.getDouble("CWBC_TIPO_CAMBIO"));
                        user.setCWBC_TIPO_CAMBIO_FECHA(rs.getString("cwbc_tipo_cambio_fecha"));
                        user.setCWBC_TIPO_OPERACION(rs.getString("cwto_operacion"));

                        datos.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }

        return datos;
    }

}
