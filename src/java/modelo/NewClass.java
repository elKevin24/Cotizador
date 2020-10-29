/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author busqu
 */
public class NewClass {
    
    public static void main(String[] args){
        Datosconexion da= new Datosconexion ();
        if(da.provarconexion()==1)
        {
            JOptionPane.showMessageDialog(null, "Conectado");
            }else{
            JOptionPane.showMessageDialog(null,"NO conectado");
        }
    }
}
