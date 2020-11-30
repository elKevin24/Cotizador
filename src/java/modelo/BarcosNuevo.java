package modelo;

import controlador.BeanBarcosNuevo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BarcosNuevo {

    public static boolean agregarBarco(BeanBarcosNuevo En) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                 String sql = "INSERT INTO COTIZADOR_WEB.CW_EOPT_BARCOS (LR, SENAL_DISTINTIVA, TIPO_DE_BARCO_POR_ESTRUCTURA, NOMBRE_DEL_BUQUE, USUARIO_DE_SERVICIO, BANDERA, TRB, TRN, TPM, CALADO, ESLORA, MANGA, BITA_USUARIO_INSERTA) VALUES "
                        + "('"+En.getLR()+"','"+En.getSENAL_DISTINTIVA()+"','"+En.getTIPO_DE_BARCO_POR_ESTRUCTURA()+"','"+En.getNOMBRE_DEL_BUQUE()+"','"+En.getUSUARIO_DE_SERVICIO()+"','"+En.getBANDERA()+"','"+En.getTRB()+"','"+En.getTRN() +"','"+En.getTPM()+"','"+En.getCALADO()+"','"+En.getESLORA()+"','"+En.getMANGA()+"','"+En.getBITA_USUARIO_INSERTA()+"')";
               
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
