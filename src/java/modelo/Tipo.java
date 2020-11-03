/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.BeanTipoBuque;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kcordon
 */
public class Tipo {
    
    public static BeanTipoBuque ObtenerTipo(String id)
{                  
    BeanTipoBuque user = new BeanTipoBuque();
               
     try        
      {        
    Conexion c=new Conexion();
        try (Connection con = c.getConexion()) {
            Statement st;
            st = con.createStatement();
        try (ResultSet rs = st.executeQuery("SELECT CWTO_TIPO_OPERACION,CWTO_OPERACION FROM  COTIZADOR_WEB.cw_tipo_operacion where CWTO_TIPO_OPERACION = 1")) {
            while (rs.next())
            {
                
                user.setCWTO_TIPO_OPERACION(rs.getString("CWTO_TIPO_OPERACION"));
                user.setCWTO_OPERACION(rs.getString("CWTO_OPERACION"));
   
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
    
}
