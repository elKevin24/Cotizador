/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author kcordon
 */
public class BeanPersona {

    public String getPersona_id() {
        return Persona_id;
    }

    public void setPersona_id(String Persona_id) {
        this.Persona_id = Persona_id;
    }

    public String getPersona_nombre() {
        return Persona_nombre;
    }

    public void setPersona_nombre(String Persona_nombre) {
        this.Persona_nombre = Persona_nombre;
    }

    public String getPersona_ingreso() {
        return Persona_ingreso;
    }

    public void setPersona_ingreso(String Persona_ingreso) {
        this.Persona_ingreso = Persona_ingreso;
    }

    
    
    

    

    private String Persona_id;
    private String Persona_nombre;
    private String Persona_ingreso;
  
    
    
    public BeanPersona() {
    }

}