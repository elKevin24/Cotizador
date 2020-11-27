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

    public String getTIPO_DE_BARCO_POR_ESTRUCTURA() {
        return TIPO_DE_BARCO_POR_ESTRUCTURA;
    }

    public void setTIPO_DE_BARCO_POR_ESTRUCTURA(String TIPO_DE_BARCO_POR_ESTRUCTURA) {
        this.TIPO_DE_BARCO_POR_ESTRUCTURA = TIPO_DE_BARCO_POR_ESTRUCTURA;
    }

    public String getCALADO() {
        return CALADO;
    }

    public void setCALADO(String CALADO) {
        this.CALADO = CALADO;
    }

    public String getMANGA() {
        return MANGA;
    }

    public void setMANGA(String MANGA) {
        this.MANGA = MANGA;
    }

    public String getBITA_USUARIO_INSERTA() {
        return BITA_USUARIO_INSERTA;
    }

    public void setBITA_USUARIO_INSERTA(String BITA_USUARIO_INSERTA) {
        this.BITA_USUARIO_INSERTA = BITA_USUARIO_INSERTA;
    }

    
    
    
    public BeanBarcosNew(String LR, String NOMBRE_DEL_BUQUE, String BANDERA, 
            String TRB,  String ESLORA, String TRN, String TPM, String TIPO_DE_BARCO_POR_ESTRUCTURA, String SENAL_DISTINTIVA, 
            String USUARIO_DE_SERVICIO, String CALADO, String MANGA, String BITA_USUARIO_INSERTA) {
        
        
        this.LR = LR;
        this.SENAL_DISTINTIVA = SENAL_DISTINTIVA;
        this.TIPO_DE_BARCO_POR_ESTRUCTURA = TIPO_DE_BARCO_POR_ESTRUCTURA;
        this.USUARIO_DE_SERVICIO = USUARIO_DE_SERVICIO;
        this.NOMBRE_DEL_BUQUE = NOMBRE_DEL_BUQUE;
        this.BANDERA = BANDERA;
        this.TRB = TRB;        
        this.TRN = TRN;
        this.TPM = TPM;
        this.CALADO = CALADO;
        this.ESLORA = ESLORA;                  
        this.MANGA = MANGA;
        this.BITA_USUARIO_INSERTA = BITA_USUARIO_INSERTA;
        
        


        
        
    }

    private String LR;
    private String SENAL_DISTINTIVA;    
    private String TIPO_DE_BARCO_POR_ESTRUCTURA;
    private String USUARIO_DE_SERVICIO;
    private String NOMBRE_DEL_BUQUE;
    private String BANDERA;
    private String TRB;
    private String TRN;
    private String TPM;    
    private String CALADO;    
    private String ESLORA;    
    private String MANGA;    
    private String BITA_USUARIO_INSERTA;    
    
    
    
    public BeanBarcosNew() {
    }

}
