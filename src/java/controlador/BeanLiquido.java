package controlador;

public class BeanLiquido {

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

    public String getCWSL_DESC_GAS_PROPANO() {
        return CWSL_DESC_GAS_PROPANO;
    }

    public void setCWSL_DESC_GAS_PROPANO(String CWSL_DESC_GAS_PROPANO) {
        this.CWSL_DESC_GAS_PROPANO = CWSL_DESC_GAS_PROPANO;
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

    public String getCWSL_CARGA_GAS_PROPANO() {
        return CWSL_CARGA_GAS_PROPANO;
    }

    public void setCWSL_CARGA_GAS_PROPANO(String CWSL_CARGA_GAS_PROPANO) {
        this.CWSL_CARGA_GAS_PROPANO = CWSL_CARGA_GAS_PROPANO;
    }

    public String getGRABADOR() {
        return GRABADOR;
    }

    public void setGRABADOR(String GRABADOR) {
        this.GRABADOR = GRABADOR;
    }

    public String getCWBC_HORA() {
        return CWBC_HORA;
    }

    public void setCWBC_HORA(String CWBC_HORA) {
        this.CWBC_HORA = CWBC_HORA;
    }

    public String getCWBC_ETA() {
        return CWBC_ETA;
    }

    public void setCWBC_ETA(String CWBC_ETA) {
        this.CWBC_ETA = CWBC_ETA;
    }
    
    

    public BeanLiquido(String CWSL_COTIZACION,
            String CWSL_DESC_ACEITE_GRASA_QUIMI,
            String CWSL_DESC_COMBUSTIBLES_DERIV,
            String CWSL_DESC_GAS_PROPANO,
            String CWSL_CARGA_ACEITE_GRASA_QUIMI,
            String CWSL_CARGA_COMBUSTIBLES_DERIV,
            String CWSL_CARGA_GAS_PROPANO,
            String GRABADOR
    ) {

        this.CWSL_COTIZACION = CWSL_COTIZACION;
        this.CWSL_DESC_ACEITE_GRASA_QUIMI = CWSL_DESC_ACEITE_GRASA_QUIMI;
        this.CWSL_DESC_COMBUSTIBLES_DERIV = CWSL_DESC_COMBUSTIBLES_DERIV;
        this.CWSL_DESC_GAS_PROPANO = CWSL_DESC_GAS_PROPANO;
        this.CWSL_CARGA_ACEITE_GRASA_QUIMI = CWSL_CARGA_ACEITE_GRASA_QUIMI;
        this.CWSL_CARGA_COMBUSTIBLES_DERIV = CWSL_CARGA_COMBUSTIBLES_DERIV;
        this.CWSL_CARGA_GAS_PROPANO = CWSL_CARGA_GAS_PROPANO;
        this.GRABADOR = GRABADOR;

    }

    private String CWSL_COTIZACION;
    private String CWBC_HORA;
    private String CWBC_ETA;
    private String CWSL_DESC_ACEITE_GRASA_QUIMI;
    private String CWSL_DESC_COMBUSTIBLES_DERIV;
    private String CWSL_DESC_GAS_PROPANO;
    private String CWSL_CARGA_ACEITE_GRASA_QUIMI;
    private String CWSL_CARGA_COMBUSTIBLES_DERIV;
    private String CWSL_CARGA_GAS_PROPANO;

    private String GRABADOR;

    public BeanLiquido() {
    }

}
