package modelo;

import controlador.BeanEncabezado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Encabezado {

    public static String agregarEncabezado(BeanEncabezado En) {
        String agregado = null;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.CW_BUQUE_COTIZA (CWBC_COTIZACION, CWBC_LR, CWBC_SENAL_DISTINTIVA, CWBC_ETA, CWBC_TIPO_CAMBIO, CWBC_TIPO_CAMBIO_FECHA, CWBC_USUARIO_SERVICIO, CWBC_NIT, CWBC_TIPO_OPERACION, GRABADOR, CWBC_ESTADO, CWBC_HORA, CWBC_TRB, CWBC_ESLORA) VALUES "
                        + "('" + En.getCWBC_COTIZACION() + "','" + En.getCWBC_LR() + "','" + En.getCWBC_SENAL_DISTINTIVA() + "',TO_DATE('" + En.getCWBC_ETA() + "', 'YYYY-MM-DD HH24:MI:SS')," + En.getCWBC_TIPO_CAMBIO() + " ,TO_DATE('" + En.getCWBC_TIPO_CAMBIO_FECHA() + "','YYYY-MM-DD' ),'" + En.getCWBC_USUARIO_SERVICIO() + "' ,'" + En.getCWBC_NIT() + "','" + En.getCWBC_TIPO_OPERACION() + "','" + En.getGRABADOR() + "'," + 1 + ", '" + En.getCWBC_HORA() + "', '" + En.getTRB() + "', '" + En.getSLORA() + "')";

//"INSERT INTO COTIZADOR_WEB.CW_BUQUE_COTIZA (CWBC_COTIZACION, CWBC_LR, CWBC_SENAL_DISTINTIVA, CWBC_ETA, CWBC_TIPO_CAMBIO, CWBC_TIPO_CAMBIO_FECHA, CWBC_USUARIO_SERVICIO, CWBC_NIT, CWBC_TIPO_OPERACION, GRABADOR, CWBC_ESTADO, CWBC_HORA, CWBC_TRB, CWBC_ESLORA) VALUES "
 //                       + "('" + En.getCWBC_COTIZACION() + "','" + En.getCWBC_LR() + "','" + En.getCWBC_SENAL_DISTINTIVA() + "',TO_DATE('" + En.getCWBC_ETA() + "', 'YYYY-MM-DD HH24:MI:SS')," + En.getCWBC_TIPO_CAMBIO() + " ,TO_DATE('" + En.getCWBC_TIPO_CAMBIO_FECHA() + "','YYYY-MM-DD' ),'" + En.getCWBC_USUARIO_SERVICIO() + "' ,'" + En.getCWBC_NIT() + "','" + En.getCWBC_TIPO_OPERACION() + "','" + En.getGRABADOR() + "'," + 1 + ", '" + En.getCWBC_HORA() + "', '" + En.getTRB() + "', '" + En.getSLORA() + "')";
               System.out.println(sql);
                st.execute(sql);

                agregado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            agregado = "mal"+e;
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

    public static boolean CambiarEstadoPendiente(String id) {
        boolean actualizado = false;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA
                String sql = "update COTIZADOR_WEB.CW_BUQUE_COTIZA set CWBC_ESTADO = 2 where CWBC_COTIZACION =" + id + "";
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
                try (ResultSet rs = st.executeQuery("SELECT CWBC_COTIZACION, cwbc_lr, cwbc_senal_distintiva, cwbc_eta, cwbc_tipo_cambio,cwto_operacion, cw_buque_cotiza.grabador FROM\n"
                        + "COTIZADOR_WEB.CW_BUQUE_COTIZA , COTIZADOR_WEB.CW_TIPO_OPERACION \n"
                        + "where CWBC_TIPO_OPERACION = CWTO_TIPO_OPERACION\n"
                        + "AND CWBC_COTIZACION = '" + id + "'")) {
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
                try (ResultSet rs = st.executeQuery("SELECT DISTINCT COTIZACION,  LR, SENAL_DISTINTIVA, ETA, TIPO_CAMBIO, TIPO_CAMBIO_FECHA, NIT, OPERACION, HORA, USUARIO_SERVICIO, grabador,\n"
                        + "NOMBRE_BUQUE, NOMBRE_USUARIO\n"
                        + "FROM(\n"
                        + "SELECT A.CWBC_COTIZACION COTIZACION,  A.cwbc_lr LR, A.CWBC_SENAL_DISTINTIVA SENAL_DISTINTIVA, A.CWBC_ETA ETA, A.CWBC_TIPO_CAMBIO TIPO_CAMBIO, A.CWBC_TIPO_CAMBIO_FECHA TIPO_CAMBIO_FECHA, A.CWBC_NIT NIT, B.CWTO_OPERACION OPERACION, A.CWBC_HORA HORA, A.CWBC_USUARIO_SERVICIO USUARIO_SERVICIO, A.grabador grabador,\n"
                        + "G.nombre_del_buque NOMBRE_BUQUE, H.NOMBRE NOMBRE_USUARIO\n"
                        + "FROM\n"
                        + "COTIZADOR_WEB.CW_BUQUE_COTIZA A, \n"
                        + "COTIZADOR_WEB.cw_tipo_operacion B, \n"
                        + "PUERTO.eopt_barcos G, \n"
                        + "FINANCIERO.ASFT_USUARIOS_DE_SERVICIOS H \n"
                        + "where A.CWBC_TIPO_OPERACION = B.CWTO_TIPO_OPERACION\n"
                        + "AND A.CWBC_LR = G.lr\n"
                        + "AND A.CWBC_USUARIO_SERVICIO = H.codigo\n"
                        + "AND A.CWBC_COTIZACION = " + id + "\n"
                        + "UNION\n"
                        + "SELECT A.CWBC_COTIZACION COTIZACION,  A.cwbc_lr LR, A.CWBC_SENAL_DISTINTIVA SENAL_DISTINTIVA, A.CWBC_ETA ETA, A.CWBC_TIPO_CAMBIO TIPO_CAMBIO, A.CWBC_TIPO_CAMBIO_FECHA TIPO_CAMBIO_FECHA, A.CWBC_NIT NIT, B.CWTO_OPERACION OPERACION,  A.CWBC_HORA HORA, A.CWBC_USUARIO_SERVICIO USUARIO_SERVICIO, A.grabador grabador,\n"
                        + "C.nombre_del_buque NOMBRE_BUQUE, D.NOMBRE NOMBRE_USUARIO\n"
                        + "FROM\n"
                        + "COTIZADOR_WEB.CW_BUQUE_COTIZA A, \n"
                        + "COTIZADOR_WEB.cw_tipo_operacion B, \n"
                        + "COTIZADOR_WEB.CW_EOPT_BARCOS C, \n"
                        + "FINANCIERO.ASFT_USUARIOS_DE_SERVICIOS D\n"
                        + "where A.CWBC_TIPO_OPERACION = B.CWTO_TIPO_OPERACION\n"
                        + "AND A.CWBC_LR = C.lr\n"
                        + "AND A.CWBC_USUARIO_SERVICIO = D.codigo\n"
                        + "AND A.CWBC_COTIZACION = " + id + ")")) {
                    while (rs.next()) {
                        user.setCWBC_COTIZACION(rs.getString("COTIZACION"));
                        user.setCWBC_LR(rs.getString("LR"));
                        user.setCWBC_SENAL_DISTINTIVA(rs.getString("SENAL_DISTINTIVA"));
                        user.setCWBC_ETA(rs.getString("ETA"));
                        user.setCWBC_TIPO_CAMBIO(rs.getDouble("TIPO_CAMBIO"));
                        user.setCWBC_TIPO_CAMBIO_FECHA(rs.getString("TIPO_CAMBIO_FECHA"));
                        user.setCWBC_TIPO_OPERACION(rs.getString("OPERACION"));
                        user.setCWBC_BUQUE_VIAJE(rs.getString("NOMBRE_BUQUE"));
                        user.setCWBC_HORA(rs.getString("HORA"));
                        user.setCWBC_CODIGO_USUARIO(rs.getString("USUARIO_SERVICIO"));
                        user.setGRABADOR(rs.getString("grabador"));

                        
                        
                        user.setCWBC_USUARIO_SERVICIO(rs.getString("NOMBRE_USUARIO"));
                        
                        

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

                try (ResultSet rs = st.executeQuery("SELECT CWBC_COTIZACION, cwbc_lr, cwbc_senal_distintiva, cwbc_eta, cwbc_tipo_cambio, cwbc_tipo_cambio_fecha,  cwto_operacion  FROM\n"
                        + "COTIZADOR_WEB.CW_BUQUE_COTIZA , COTIZADOR_WEB.CW_TIPO_OPERACION \n"
                        + "where CWBC_TIPO_OPERACION = CWTO_TIPO_OPERACION\n"
                        + "AND CWBC_LR ='" + id + "' ORDER BY CWBC_COTIZACION")) {
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
