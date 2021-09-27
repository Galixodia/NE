package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author 000329745 Juan Camilo Villa 
 * @since 00/09/2021
 * @version 1.0
 * 
 * Segmento Obligatorio. Puede repetirse  una sola (1) vez en el archivo.
 */


@XmlType (propOrder={"HZRNENC_TIPO_DOC",
    "HZRNENC_FECHA_ING",
    "HZRNENC_FECHA_RET",
    "HZRNENC_FECHA_LIQ_INI",
    "HZRNENC_FECHA_LIQ_FIN",
    "HZRNENC_TIEMPO_LAB",
    "HZRNENC_FECHA_EMISION",
    "HZRNENC_CODIGO_TRAB",
    "HZRNENC_PREFIJO",
    "HZRNENC_CONSECUTIVO",
    "HZRNENC_NUMERO",
    "HZRNENC_PAIS",
    "HZRNENC_DEPART_ESTADO",
    "HZRNENC_MUNICIPIO_CIUDAD",
    "HZRNENC_IDIOMA",
    "HZRNENC_VERSION",
    "HZRNENC_AMBIENTE",
    "HZRNENC_TIPO_XML",
    "HZRNENC_CUNE",
    "HZRNENC_FECHA_GENERA",
    "HZRNENC_HORA_GENERA",
    "HZRNENC_PERIODO_NOM",
    "HZRNENC_TIPO_MONEDA",
    "HZRNENC_TRM",
    "HZRNENC_NUM_PRED",
    "HZRNENC_CUNE_PRED",
    "HZRNENC_FECHA_GEN_PRED"})
public class ENC {
    
    private String      HZRNENC_CUNE_INTERNO;
    @XmlElement(name="ENC_1")
    private String      HZRNENC_TIPO_DOC;
    @XmlElement(name="ENC_2")
    private String      HZRNENC_FECHA_ING;
    @XmlElement(name="ENC_3")
    private String      HZRNENC_FECHA_RET;
    @XmlElement(name="ENC_4")
    private String      HZRNENC_FECHA_LIQ_INI;
    @XmlElement(name="ENC_5")
    private String      HZRNENC_FECHA_LIQ_FIN;
    @XmlElement(name="ENC_6")
    private String      HZRNENC_TIEMPO_LAB;
    @XmlElement(name="ENC_7")
    private String      HZRNENC_FECHA_EMISION;
    @XmlElement(name="ENC_8")
    private String      HZRNENC_CODIGO_TRAB;
    @XmlElement(name="ENC_9")
    private String      HZRNENC_PREFIJO;
    @XmlElement(name="ENC_10")
    private Long        HZRNENC_CONSECUTIVO;
    @XmlElement(name="ENC_11")
    private String      HZRNENC_NUMERO;
    @XmlElement(name="ENC_12")
    private String      HZRNENC_PAIS;
    @XmlElement(name="ENC_13")
    private String     HZRNENC_DEPART_ESTADO;
    @XmlElement(name="ENC_14")
    private String     HZRNENC_MUNICIPIO_CIUDAD;
    @XmlElement(name="ENC_15")
    private String      HZRNENC_IDIOMA;
    @XmlElement(name="ENC_16")
    private String      HZRNENC_VERSION;
    @XmlElement(name="ENC_17")
    private Integer     HZRNENC_AMBIENTE;
    @XmlElement(name="ENC_18")
    private Integer     HZRNENC_TIPO_XML;
    @XmlElement(name="ENC_19")
    private String      HZRNENC_CUNE;
    @XmlElement(name="ENC_20")
    private String      HZRNENC_FECHA_GENERA;
    @XmlElement(name="ENC_21")
    private String      HZRNENC_HORA_GENERA;
    @XmlElement(name="ENC_22")
    private Integer     HZRNENC_PERIODO_NOM;
    @XmlElement(name="ENC_23")
    private String      HZRNENC_TIPO_MONEDA;
    @XmlElement(name="ENC_24")
    private String      HZRNENC_TRM;
    @XmlElement(name="ENC_25")
    private String      HZRNENC_NUM_PRED;
    @XmlElement(name="ENC_26")
    private String      HZRNENC_CUNE_PRED;
    @XmlElement(name="ENC_27")
    private String      HZRNENC_FECHA_GEN_PRED;

    @XmlTransient
    public String getHZRNENC_CUNE_INTERNO() {
        return HZRNENC_CUNE_INTERNO;
    }

    public void setHZRNENC_CUNE_INTERNO(String HZRNENC_CUNE_INTERNO) {
        this.HZRNENC_CUNE_INTERNO = HZRNENC_CUNE_INTERNO;
    }
    @XmlTransient
    public String getHZRNENC_TIPO_DOC() {
        return HZRNENC_TIPO_DOC;
    }

    public void setHZRNENC_TIPO_DOC(String HZRNENC_TIPO_DOC) throws DataFormatException {     
        Data data = new Data();        
        
        if(data.checkNull(HZRNENC_TIPO_DOC)){         
            this.HZRNENC_TIPO_DOC = HZRNENC_TIPO_DOC;
            data = null;
        }else{
            throw new DataFormatException("ENC:HZRNENC_TIPO_DOC:El campo es nulo");
        }         
        
    }
    @XmlTransient
    public String getHZRNENC_FECHA_ING() {
        return HZRNENC_FECHA_ING;
    }

    public void setHZRNENC_FECHA_ING(String HZRNENC_FECHA_ING) throws DataFormatException {
        Data data = new Data();
        
        if(data.checkNull(HZRNENC_FECHA_ING)){         
            this.HZRNENC_FECHA_ING = HZRNENC_FECHA_ING;
            data = null;
        }else{
            throw new DataFormatException("ENC:HZRNENC_FECHA_ING:El campo es nulo");
        }   
        
    }
    @XmlTransient
    public String getHZRNENC_FECHA_RET() {
        return HZRNENC_FECHA_RET;
    }

    public void setHZRNENC_FECHA_RET(String HZRNENC_FECHA_RET) {
            this.HZRNENC_FECHA_RET = HZRNENC_FECHA_RET;
   }
    @XmlTransient
    public String getHZRNENC_FECHA_LIQ_INI() {
        return HZRNENC_FECHA_LIQ_INI;
    }

    public void setHZRNENC_FECHA_LIQ_INI(String HZRNENC_FECHA_LIQ_INI) throws DataFormatException {
        Data data = new Data();        
        
        if(data.checkNull(HZRNENC_FECHA_LIQ_INI)){
            this.HZRNENC_FECHA_LIQ_INI = HZRNENC_FECHA_LIQ_INI;
            data = null;
        }else{
            throw new DataFormatException("ENC:HZRNENC_FECHA_LIQ_INI:El campo es nulo");
        }
    }
    @XmlTransient
    public String getHZRNENC_FECHA_LIQ_FIN() {
        return HZRNENC_FECHA_LIQ_FIN;
    }

    public void setHZRNENC_FECHA_LIQ_FIN(String HZRNENC_FECHA_LIQ_FIN) throws DataFormatException {
        Data data = new Data();        
        
        if(data.checkNull(HZRNENC_FECHA_LIQ_FIN)){        
            this.HZRNENC_FECHA_LIQ_FIN = HZRNENC_FECHA_LIQ_FIN;
            data = null;
        }else{
            throw new DataFormatException("ENC:HZRNENC_FECHA_LIQ_FIN:El campo es nulo");
        }        
    }
    @XmlTransient
    public String getHZRNENC_TIEMPO_LAB() {
        return HZRNENC_TIEMPO_LAB;
    }

    public void setHZRNENC_TIEMPO_LAB(BigDecimal HZRNENC_TIEMPO_LAB) throws DataFormatException {              
        if(HZRNENC_TIEMPO_LAB != null){
            this.HZRNENC_TIEMPO_LAB = new DecimalFormat("#.00").format(HZRNENC_TIEMPO_LAB).replace(",",".");
        }else{
            this.HZRNENC_TIEMPO_LAB = String.valueOf(HZRNENC_TIEMPO_LAB);
        } 
    }
    @XmlTransient
    public String getHZRNENC_FECHA_EMISION() {
        return HZRNENC_FECHA_EMISION;
    }

    public void setHZRNENC_FECHA_EMISION(String HZRNENC_FECHA_EMISION) throws DataFormatException {
        Data data = new Data();        
        
        if(data.checkNull(HZRNENC_FECHA_EMISION)){         
            this.HZRNENC_FECHA_EMISION = HZRNENC_FECHA_EMISION;
            data = null;
        }else{
            throw new DataFormatException("ENC:HZRNENC_FECHA_EMISION:El campo es nulo");
        }             
    }
    @XmlTransient
    public String getHZRNENC_CODIGO_TRAB() {
        return HZRNENC_CODIGO_TRAB;
    }

    public void setHZRNENC_CODIGO_TRAB(String HZRNENC_CODIGO_TRAB) {
        this.HZRNENC_CODIGO_TRAB = HZRNENC_CODIGO_TRAB;
       
    }
    @XmlTransient
    public String getHZRNENC_PREFIJO() {
        return HZRNENC_PREFIJO;
    }

    public void setHZRNENC_PREFIJO(String HZRNENC_PREFIJO) {
        this.HZRNENC_PREFIJO = HZRNENC_PREFIJO;
    }
    @XmlTransient
    public Long getHZRNENC_CONSECUTIVO() {
        return HZRNENC_CONSECUTIVO;
    }

    public void setHZRNENC_CONSECUTIVO(Long HZRNENC_CONSECUTIVO) throws DataFormatException {
        Data data = new Data();        
  
        if(data.checklength(HZRNENC_CONSECUTIVO,10)){
            this.HZRNENC_CONSECUTIVO = HZRNENC_CONSECUTIVO;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_CONSECUTIVO:El campo es nulo o excede la longitud definida por la DIAN");
        }             
          
    }
    @XmlTransient
    public String getHZRNENC_NUMERO() {
        return HZRNENC_NUMERO;
    }

    public void setHZRNENC_NUMERO(String HZRNENC_NUMERO) throws DataFormatException {
        Data data = new Data();        
        
        if(data.checklength(HZRNENC_NUMERO,16)){        
            this.HZRNENC_NUMERO = HZRNENC_NUMERO;
            data = null;
        }else{
            throw new DataFormatException("ENC:HZRNENC_NUMERO:El campo es nulo o excede la longitud definida por la DIAN");
        }              
    }
    @XmlTransient
    public String getHZRNENC_PAIS() {
        return HZRNENC_PAIS;
    }

    public void setHZRNENC_PAIS(String HZRNENC_PAIS) throws DataFormatException {
        Data data = new Data();    
        
        if(data.checklength(HZRNENC_PAIS,2)){
            this.HZRNENC_PAIS = HZRNENC_PAIS;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_PAIS:El campo es nulo o excede la longitud definida por la DIAN");
        }
        
    }
    @XmlTransient
    public String getHZRNENC_DEPART_ESTADO() {
        return HZRNENC_DEPART_ESTADO;
    }

    public void setHZRNENC_DEPART_ESTADO(String HZRNENC_DEPART_ESTADO) throws DataFormatException {
        Data data = new Data();    
        
        if(data.checklength(HZRNENC_DEPART_ESTADO,2)){
            this.HZRNENC_DEPART_ESTADO = HZRNENC_DEPART_ESTADO;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_DEPART_ESTADO:El campo es nulo o excede la longitud definida por la DIAN");
        }
    }
    @XmlTransient
    public String getHZRNENC_MUNICIPIO_CIUDAD() {
        return HZRNENC_MUNICIPIO_CIUDAD;
    }

    public void setHZRNENC_MUNICIPIO_CIUDAD(String HZRNENC_MUNICIPIO_CIUDAD) throws DataFormatException {
        Data data = new Data();    
        
        if(data.checklength(HZRNENC_MUNICIPIO_CIUDAD,5)){
            this.HZRNENC_MUNICIPIO_CIUDAD = HZRNENC_MUNICIPIO_CIUDAD;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_MUNICIPIO_CIUDAD:El campo es nulo o excede la longitud definida por la DIAN");
        }        
     }
    @XmlTransient
    public String getHZRNENC_IDIOMA() {
        return HZRNENC_IDIOMA;
    }

    public void setHZRNENC_IDIOMA(String HZRNENC_IDIOMA) throws DataFormatException {
        Data data = new Data();    
        
        if(data.checklength(HZRNENC_IDIOMA,2)){
            this.HZRNENC_IDIOMA = HZRNENC_IDIOMA;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_IDIOMA:El campo es nulo o excede la longitud definida por la DIAN");
        }        
    }
    @XmlTransient
    public String getHZRNENC_VERSION() {
        return HZRNENC_VERSION;
    }

    public void setHZRNENC_VERSION(String HZRNENC_VERSION) throws DataFormatException {
        Data data = new Data();    
        
        if(data.checklength(HZRNENC_VERSION,75)){
            this.HZRNENC_VERSION = HZRNENC_VERSION;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_VERSION:El campo es nulo o excede la longitud definida por la DIAN");
        }    
    }
    @XmlTransient
    public Integer getHZRNENC_AMBIENTE() {
        return HZRNENC_AMBIENTE;
    }

    public void setHZRNENC_AMBIENTE(Integer HZRNENC_AMBIENTE) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNENC_AMBIENTE,1)){
            this.HZRNENC_AMBIENTE = HZRNENC_AMBIENTE;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_AMBIENTE:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public Integer getHZRNENC_TIPO_XML() {
        return HZRNENC_TIPO_XML;
    }

    public void setHZRNENC_TIPO_XML(Integer HZRNENC_TIPO_XML) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNENC_TIPO_XML,3)){
            this.HZRNENC_TIPO_XML = HZRNENC_TIPO_XML;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_TIPO_XML:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public String getHZRNENC_CUNE() {
        return HZRNENC_CUNE;
    }

    public void setHZRNENC_CUNE(String HZRNENC_CUNE) {
        this.HZRNENC_CUNE = HZRNENC_CUNE;
    }
    @XmlTransient
    public String getHZRNENC_FECHA_GENERA() {
        return HZRNENC_FECHA_GENERA;
    }

    public void setHZRNENC_FECHA_GENERA(String HZRNENC_FECHA_GENERA) throws DataFormatException {
        Data data = new Data();    

        if(data.checkNull(HZRNENC_FECHA_GENERA)){
            this.HZRNENC_FECHA_GENERA = HZRNENC_FECHA_GENERA;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_FECHA_GENERA:El campo es nulo");
        }             
    }
    @XmlTransient
    public String getHZRNENC_HORA_GENERA() {
        return HZRNENC_HORA_GENERA;
    }

    public void setHZRNENC_HORA_GENERA(String HZRNENC_HORA_GENERA) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNENC_HORA_GENERA,14)){
            this.HZRNENC_HORA_GENERA = HZRNENC_HORA_GENERA;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_HORA_GENERA:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public Integer getHZRNENC_PERIODO_NOM() {
        return HZRNENC_PERIODO_NOM;
    }

    public void setHZRNENC_PERIODO_NOM(Integer HZRNENC_PERIODO_NOM) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNENC_PERIODO_NOM,1)){
            this.HZRNENC_PERIODO_NOM = HZRNENC_PERIODO_NOM;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_PERIODO_NOM:El campo es nulo o excede la longitud definida por la DIAN");
        }            
    }
    @XmlTransient
    public String getHZRNENC_TIPO_MONEDA() {
        return HZRNENC_TIPO_MONEDA;
    }

    public void setHZRNENC_TIPO_MONEDA(String HZRNENC_TIPO_MONEDA) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNENC_TIPO_MONEDA,14)){
            this.HZRNENC_TIPO_MONEDA = HZRNENC_TIPO_MONEDA;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_TIPO_MONEDA:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public String getHZRNENC_TRM() {
        return HZRNENC_TRM;
    }

    public void setHZRNENC_TRM(BigDecimal HZRNENC_TRM) {
        if(HZRNENC_TRM != null){
            this.HZRNENC_TRM = new DecimalFormat("#.000000").format(HZRNENC_TRM).replace(",",".");
        }
    }
    @XmlTransient
    public String getHZRNENC_NUM_PRED() {
        return HZRNENC_NUM_PRED;
    }

    public void setHZRNENC_NUM_PRED(String HZRNENC_NUM_PRED) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNENC_NUM_PRED,16)){
            this.HZRNENC_NUM_PRED = HZRNENC_NUM_PRED;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_NUM_PRED:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public String getHZRNENC_CUNE_PRED() {
        return HZRNENC_CUNE_PRED;
    }

    public void setHZRNENC_CUNE_PRED(String HZRNENC_CUNE_PRED) {
        this.HZRNENC_CUNE_PRED = HZRNENC_CUNE_PRED;
    }
    @XmlTransient
    public String getHZRNENC_FECHA_GEN_PRED() {
        return HZRNENC_FECHA_GEN_PRED;
    }

    public void setHZRNENC_FECHA_GEN_PRED(String HZRNENC_FECHA_GEN_PRED) throws DataFormatException {
        Data data = new Data();    

        if(data.checkNull(HZRNENC_FECHA_GEN_PRED)){
            this.HZRNENC_FECHA_GEN_PRED = HZRNENC_FECHA_GEN_PRED;
            data = null;            
        }else{
            throw new DataFormatException("ENC:HZRNENC_FECHA_GEN_PRED:El campo es nulo");
        }           
    }

    @Override
    public String toString() {
        return "ENC{" + "HZRNENC_CUNE_INTERNO=" + HZRNENC_CUNE_INTERNO + ", HZRNENC_TIPO_DOC=" + HZRNENC_TIPO_DOC + ", HZRNENC_FECHA_ING=" + HZRNENC_FECHA_ING + ", HZRNENC_FECHA_RET=" + HZRNENC_FECHA_RET + ", HZRNENC_FECHA_LIQ_INI=" + HZRNENC_FECHA_LIQ_INI + ", HZRNENC_FECHA_LIQ_FIN=" + HZRNENC_FECHA_LIQ_FIN + ", HZRNENC_TIEMPO_LAB=" + HZRNENC_TIEMPO_LAB + ", HZRNENC_FECHA_EMISION=" + HZRNENC_FECHA_EMISION + ", HZRNENC_CODIGO_TRAB=" + HZRNENC_CODIGO_TRAB + ", HZRNENC_PREFIJO=" + HZRNENC_PREFIJO + ", HZRNENC_CONSECUTIVO=" + HZRNENC_CONSECUTIVO + ", HZRNENC_NUMERO=" + HZRNENC_NUMERO + ", HZRNENC_PAIS=" + HZRNENC_PAIS + ", HZRNENC_DEPART_ESTADO=" + HZRNENC_DEPART_ESTADO + ", HZRNENC_MUNICIPIO_CIUDAD=" + HZRNENC_MUNICIPIO_CIUDAD + ", HZRNENC_IDIOMA=" + HZRNENC_IDIOMA + ", HZRNENC_VERSION=" + HZRNENC_VERSION + ", HZRNENC_AMBIENTE=" + HZRNENC_AMBIENTE + ", HZRNENC_TIPO_XML=" + HZRNENC_TIPO_XML + ", HZRNENC_CUNE=" + HZRNENC_CUNE + ", HZRNENC_FECHA_GENERA=" + HZRNENC_FECHA_GENERA + ", HZRNENC_HORA_GENERA=" + HZRNENC_HORA_GENERA + ", HZRNENC_PERIODO_NOM=" + HZRNENC_PERIODO_NOM + ", HZRNENC_TIPO_MONEDA=" + HZRNENC_TIPO_MONEDA + ", HZRNENC_TRM=" + HZRNENC_TRM + ", HZRNENC_NUM_PRED=" + HZRNENC_NUM_PRED + ", HZRNENC_CUNE_PRED=" + HZRNENC_CUNE_PRED + ", HZRNENC_FECHA_GEN_PRED=" + HZRNENC_FECHA_GEN_PRED + '}';
    }
 
    
}
