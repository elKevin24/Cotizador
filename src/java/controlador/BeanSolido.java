package controlador;

public class BeanSolido {

    public String getCWSL_COTIZACION() {
        return CWSL_COTIZACION;
    }

    public void setCWSL_COTIZACION(String CWSL_COTIZACION) {
        this.CWSL_COTIZACION = CWSL_COTIZACION;
    }

    public String getCWSL_DESC_ACEITE_GRASA_QUIMI() {
        return CWSL_DESC_ACEITE_GRASA_QUIMI;
    }

    public void setCWSL_DESC_ACEITE_GRASA_QUIMI(String CWSL_DESC_ACEITE_GRASA_QUIMI) {
        this.CWSL_DESC_ACEITE_GRASA_QUIMI = CWSL_DESC_ACEITE_GRASA_QUIMI;
    }

    public String getCWSL_DESC_COMBUSTIBLES_DERIV() {
        return CWSL_DESC_COMBUSTIBLES_DERIV;
    }

    public void setCWSL_DESC_COMBUSTIBLES_DERIV(String CWSL_DESC_COMBUSTIBLES_DERIV) {
        this.CWSL_DESC_COMBUSTIBLES_DERIV = CWSL_DESC_COMBUSTIBLES_DERIV;
    }

    

    public String getCWSL_CARGA_ACEITE_GRASA_QUIMI() {
        return CWSL_CARGA_ACEITE_GRASA_QUIMI;
    }

    public void setCWSL_CARGA_ACEITE_GRASA_QUIMI(String CWSL_CARGA_ACEITE_GRASA_QUIMI) {
        this.CWSL_CARGA_ACEITE_GRASA_QUIMI = CWSL_CARGA_ACEITE_GRASA_QUIMI;
    }

    public String getCWSL_CARGA_COMBUSTIBLES_DERIV() {
        return CWSL_CARGA_COMBUSTIBLES_DERIV;
    }

    public void setCWSL_CARGA_COMBUSTIBLES_DERIV(String CWSL_CARGA_COMBUSTIBLES_DERIV) {
        this.CWSL_CARGA_COMBUSTIBLES_DERIV = CWSL_CARGA_COMBUSTIBLES_DERIV;
    }

   

    
    
    public String getGRABADOR() {
        return GRABADOR;
    }

    public void setGRABADOR(String GRABADOR) {
        this.GRABADOR = GRABADOR;
    }

    public BeanSolido(String CWSL_COTIZACION, 
            String CWSL_DESC_ACEITE_GRASA_QUIMI, 
            String CWSL_DESC_COMBUSTIBLES_DERIV, 
            
            String CWSL_CARGA_ACEITE_GRASA_QUIMI,
            String CWSL_CARGA_COMBUSTIBLES_DERIV,
            
            String GRABADOR
            
    ) {

        this.CWSL_COTIZACION = CWSL_COTIZACION;
        this.CWSL_DESC_ACEITE_GRASA_QUIMI = CWSL_DESC_ACEITE_GRASA_QUIMI;
        this.CWSL_DESC_COMBUSTIBLES_DERIV = CWSL_DESC_COMBUSTIBLES_DERIV;
        
        this.CWSL_CARGA_ACEITE_GRASA_QUIMI = CWSL_CARGA_ACEITE_GRASA_QUIMI;
        this.CWSL_CARGA_COMBUSTIBLES_DERIV = CWSL_CARGA_COMBUSTIBLES_DERIV;
        
        this.GRABADOR = GRABADOR;

    }
    
  

    private String CWSL_COTIZACION;
    private String CWSL_DESC_ACEITE_GRASA_QUIMI;
    private String CWSL_DESC_COMBUSTIBLES_DERIV;
    
    private String CWSL_CARGA_ACEITE_GRASA_QUIMI;
    private String CWSL_CARGA_COMBUSTIBLES_DERIV;
   
    
    private String GRABADOR;

    public BeanSolido() {
    }

}