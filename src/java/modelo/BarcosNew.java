
package modelo;
import controlador.BeanBarcosNew;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;






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
                String sql = "INSERT INTO CW_EOPT_BARCOS (LR, SENAL_DISTINTICA, TIPO_DE_BARCO_POR_ESTRUCTURA, USUARIO_DE_SERVICIO, NOMBRE_DEL_BUQUE, BANDERA, TRB, TRN, TPM, CALADO, ESLORA, MANGA, BITA_USUARIO_INSERTA) VALUES "
                        + "('"+ En.getLR()+"','"+En.getSENAL_DISTINTIVA()+"','"+En.getESTRUCTURA()+"',"+En.getUSUARIO_DE_SERVICIO()+" ,'"+En.getNOMBRE_DEL_BUQUE()+"' ,'"+En.getBANDERA()+"','"+En.getTRB()+"','"+En.getTRN()+"','"+En.getTPM()+"','"+En.getCALADO()+"','"+En.getESLORA()+"','"+En.getMANGA()+"','"+En.getBITA_USUARIO_INSERTA()+"')";

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

}