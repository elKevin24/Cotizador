/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
/**
 *
 * @author busqu
 */
public class Datosconexion extends Conexion {
    Connection con = getConexion();
    public int provarconexion (){
        int conexion =0;
        try {
            PreparedStatement ps = null;
            ResultSet rs= null;
            ps = con.prepareStatement("select * from USUARIOS_WEB.USUARIOS_PORTAL_INOW");
            rs = ps.executeQuery();
            if(rs.next()){
                conexion = 1;
            }
        } catch (SQLException e) {
        }
        return conexion ;
        
    }
    
    
    
}
