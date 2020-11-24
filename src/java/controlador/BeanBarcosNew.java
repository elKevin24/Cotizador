package controlador;

public class BeanBarcosNew {

    public String getLR() {
        return LR;
    }

    public void setLR(String LR) {
        this.LR = LR;
    }

    public String getNOMBRE_DEL_BUQUE() {
        return NOMBRE_DEL_BUQUE;
    }

    public void setNOMBRE_DEL_BUQUE(String NOMBRE_DEL_BUQUE) {
        this.NOMBRE_DEL_BUQUE = NOMBRE_DEL_BUQUE;
    }

    public String getBANDERA() {
        return BANDERA;
    }

    public void setBANDERA(String BANDERA) {
        this.BANDERA = BANDERA;
    }

    public String getTRB() {
        return TRB;
    }

    public void setTRB(String TRB) {
        this.TRB = TRB;
    }

    public String getESLORA() {
        return ESLORA;
    }

    public void setESLORA(String ESLORA) {
        this.ESLORA = ESLORA;
    }

    public String getTRN() {
        return TRN;
    }

    public void setTRN(String TRN) {
        this.TRN = TRN;
    }

    public String getTPM() {
        return TPM;
    }

    public void setTPM(String TPM) {
        this.TPM = TPM;
    }

    public String getESTRUCTURA() {
        return ESTRUCTURA;
    }

    public void setESTRUCTURA(String ESTRUCTURA) {
        this.ESTRUCTURA = ESTRUCTURA;
    }

    public String getSENAL_DISTINTIVA() {
        return SENAL_DISTINTIVA;
    }

    public void setSENAL_DISTINTIVA(String SENAL_DISTINTIVA) {
        this.SENAL_DISTINTIVA = SENAL_DISTINTIVA;
    }

    public String getUSUARIO_DE_SERVICIO() {
        return USUARIO_DE_SERVICIO;
    }

    public void setUSUARIO_DE_SERVICIO(String USUARIO_DE_SERVICIO) {
        this.USUARIO_DE_SERVICIO = USUARIO_DE_SERVICIO;
    }

    public String getNAVIERO() {
        return NAVIERO;
    }

    public void setNAVIERO(String NAVIERO) {
        this.NAVIERO = NAVIERO;
    }

    public String getGRABADOR() {
        return GRABADOR;
    }

    public void setGRABADOR(String GRABADOR) {
        this.GRABADOR = GRABADOR;
    }
    
    
    


    public BeanBarcosNew(String LR, String NOMBRE_DEL_BUQUE, String BANDERA, 
            String TRB,  String ESLORA, String TRN, String TPM, String ESTRUCTURA, String SENAL_DISTINTIVA, 
            String USUARIO_DE_SERVICIO,  String NAVIERO, String GRABADOR) {
        
        
        this.LR = LR;
        this.NOMBRE_DEL_BUQUE = NOMBRE_DEL_BUQUE;
        this.BANDERA = BANDERA;
        this.TRB = TRB;
        this.ESLORA = ESLORA;
        this.TRN = TRN;
        this.TPM = TPM;
        this.ESTRUCTURA = ESTRUCTURA;
        this.SENAL_DISTINTIVA = SENAL_DISTINTIVA;
        this.USUARIO_DE_SERVICIO = USUARIO_DE_SERVICIO;
        this.NAVIERO = NAVIERO;
        this.GRABADOR = GRABADOR;
        


        
        
    }

    private String LR;
    private String NOMBRE_DEL_BUQUE;    
    private String BANDERA;
    private String TRB;
    private String ESLORA;
    private String TRN;
    private String TPM;    
    private String ESTRUCTURA;
    private String SENAL_DISTINTIVA;
    private String USUARIO_DE_SERVICIO;
    private String NAVIERO;
    private String GRABADOR;
    
    
    public BeanBarcosNew() {
    }

}
