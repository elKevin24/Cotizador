
package modelo;
import controlador.BeanBarcos;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.ResultSet;
import java.util.LinkedList;



public class Barcos {
 
public static LinkedList<BeanBarcos> consultarBarco(String entrada) throws SQLException
{
     LinkedList<BeanBarcos> usuarios = new LinkedList<>();
     String sql;
     
    
          sql =  "select LR, NOMBRE_DEL_BUQUE, senal_distintiva, TRB, ESLORA from PUERTO.eopt_barcos WHERE USUARIO_DE_SERVICIO = '"+entrada+"'";
     
    try
      {
            Conexion c=new Conexion();
         try (Connection con = c.getConexion()) {
             Statement st;
             st = con.createStatement();
           
                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next())
                    {
                        BeanBarcos user = new BeanBarcos();
                        user.setLR(rs.getString("LR"));       
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));             
                        user.setBANDERA(rs.getString("senal_distintiva"));   
                        user.setTRB(rs.getString("TRB"));
                        user.setESLORA(rs.getString("ESLORA"));         
                               
                                                                        
                        usuarios.add(user);                                 
                    }  }
             st.close();
         }                    
      }                        
     catch (SQLException e)
      {                                                            
      }                     
                             
    return usuarios;
}

public static LinkedList<BeanBarcos> consultarBarco() throws SQLException
{
     LinkedList<BeanBarcos> usuarios = new LinkedList<>();
     
         
            
    try
      {
            Conexion c=new Conexion();
         try (Connection con = c.getConexion()) {
             Statement st;
             st = con.createStatement();
           
                try (ResultSet rs = st.executeQuery("select LR, NOMBRE_DEL_BUQUE, senal_distintiva, TRB, ESLORA from PUERTO.eopt_barcos ")) {
                    while (rs.next())
                    {
                        BeanBarcos user = new BeanBarcos();
                        user.setLR(rs.getString("LR"));       
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));             
                        user.setBANDERA(rs.getString("senal_distintiva"));   
                        user.setTRB(rs.getString("TRB"));
                        user.setESLORA(rs.getString("ESLORA"));         
                               
                                                                        
                        usuarios.add(user);                                 
                    }  }
             st.close();
         }                    
      }                        
     catch (SQLException e)
      {                                                            
      }                     
                             
    return usuarios;
}



public static BeanBarcos ObtenerBarcos(String id)
{                  
    BeanBarcos user = new BeanBarcos();
               
     try        
      {        
    Conexion c=new Conexion();
        try (Connection con = c.getConexion()) {
            Statement st;
            st = con.createStatement();
        try (ResultSet rs = st.executeQuery("select LR, NOMBRE_DEL_BUQUE, senal_distintiva, TRB, ESLORA from PUERTO.eopt_barcos WHERE LR = "+id+"")) {
            while (rs.next())
            {
                
                user.setLR(rs.getString("LR"));
                user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
                user.setBANDERA(rs.getString("senal_distintiva"));
                user.setTRB(rs.getString("TRB"));
                user.setESLORA(rs.getString("ESLORA"));
                
                 
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