
package modelo;
import controlador.BeanBarcosNew;
import controlador.BeanEncabezado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;






public class BarcosNew {

    public static boolean agregarBarco(BeanBarcosNew En) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.CW_EOPT_BARCOS (LR, SENAL_DISTINTIVA, TIPO_DE_BARCO_POR_ESTRUCTURA, USUARIO_DE_SERVICIO, BANDERA) VALUES "
                        + "('"+En.getLR()+"',2,'13','19165011 ','"+En.getBANDERA()+"')";

//                INSERT INTO COTIZADOR_WEB.CW_EOPT_BARCOS (LR, SENAL_DISTINTICA, TIPO_DE_BARCO_POR_ESTRUCTURA, USUARIO_DE_SERVICIO, NOMBRE_DEL_BUQUE, BANDERA, TRB, TRN, TPM, CALADO, ESLORA, MANGA, BITA_USUARIO_INSERTA) VALUES "
//                        + "('"+ En.getLR()+"','"+En.getSENAL_DISTINTIVA()+"','"+En.getTIPO_DE_BARCO_POR_ESTRUCTURA()+"',"+En.getUSUARIO_DE_SERVICIO()+" ,'"+En.getNOMBRE_DEL_BUQUE()+"' ,'"+En.getBANDERA()+"','"+En.getTRB()+"','"+En.getTRN()+"','"+En.getTPM()+"','"+En.getCALADO()+"','"+En.getESLORA()+"','"+En.getMANGA()+"','"+En.getBITA_USUARIO_INSERTA()+"')";
                
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
    
    
    
    public static LinkedList<BeanBarcosNew> Barcos() throws SQLException {
        LinkedList<BeanBarcosNew> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("select A.LR,\n" +
" A.SENAL_DISTINTIVA,\n" +
"B.DESCRIPCION,\n" +
" A.USUARIO_DE_SERVICIO,\n" +
" A.NOMBRE_DEL_BUQUE,\n" +
"C.NOMBRE,\n" +
" A.TRB,\n" +
" A.TRN,\n" +
" A.TPM,\n" +
" A.CALADO,\n" +
" A.ESLORA,\n" +
" A.MANGA,\n" +
" A.BITA_USUARIO_INSERTA\n" +
"from\n" +
"CW_EOPT_BARCOS A, PUERTO.eopt_tipos_barc_estru B, PUERTO.EOPT_PAISES C\n" +
"WHERE A.TIPO_DE_BARCO_POR_ESTRUCTURA = B.TIPO_DE_BARCO_POR_ESTRUCTURA\n" +
"AND A.BANDERA = C.PAIS")) {
                    while (rs.next()) {
                        BeanBarcosNew user = new BeanBarcosNew();
                        user.setLR(rs.getString("LR"));
                        user.setSENAL_DISTINTIVA(rs.getString("SENAL_DISTINTIVA"));
                        user.setTIPO_DE_BARCO_POR_ESTRUCTURA(rs.getString("DESCRIPCION"));
                        user.setUSUARIO_DE_SERVICIO(rs.getString("USUARIO_DE_SERVICIO"));
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
                        user.setBANDERA(rs.getString("NOMBRE"));
                        user.setTRB(rs.getString("TRB"));
                        user.setTRN(rs.getString("TRN"));
                        user.setTPM(rs.getString("TPM"));
                        user.setCALADO(rs.getString("CALADO"));
                        user.setESLORA(rs.getString("ESLORA"));
                        user.setMANGA(rs.getString("MANGA"));
                        user.setBITA_USUARIO_INSERTA(rs.getString("BITA_USUARIO_INSERTA"));

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