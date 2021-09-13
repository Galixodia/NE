package co.edu.upb.pojos.nomina;

import co.edu.upb.nominae.Comprobante;
import static co.edu.upb.nominae.Queries.HZRNENC_QUERY;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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

@XmlRootElement(name = "ENC")
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
    private Date      HZRNENC_FECHA_ING;
    @XmlElement(name="ENC_3")
    private Date      HZRNENC_FECHA_RET;
    @XmlElement(name="ENC_4")
    private Date      HZRNENC_FECHA_LIQ_INI;
    @XmlElement(name="ENC_5")
    private Date      HZRNENC_FECHA_LIQ_FIN;
    @XmlElement(name="ENC_6")
    private Double      HZRNENC_TIEMPO_LAB;
    @XmlElement(name="ENC_7")
    private Date      HZRNENC_FECHA_EMISION;
    @XmlElement(name="ENC_8")
    private String      HZRNENC_CODIGO_TRAB;
    @XmlElement(name="ENC_9")
    private String      HZRNENC_PREFIJO;
    @XmlElement(name="ENC_10")
    private Long        HZRNENC_CONSECUTIVO;
    @XmlElement(name="ENC_12")
    private String      HZRNENC_NUMERO;
    @XmlElement(name="ENC_13")
    private String      HZRNENC_PAIS;
    @XmlElement(name="ENC_1")
    private Integer     HZRNENC_DEPART_ESTADO;
    @XmlElement(name="ENC_14")
    private Integer     HZRNENC_MUNICIPIO_CIUDAD;
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
    private Date      HZRNENC_FECHA_GENERA;
    @XmlElement(name="ENC_21")
    private String      HZRNENC_HORA_GENERA;
    @XmlElement(name="ENC_22")
    private Integer     HZRNENC_PERIODO_NOM;
    @XmlElement(name="ENC_23")
    private String      HZRNENC_TIPO_MONEDA;
    @XmlElement(name="ENC_24")
    private Double      HZRNENC_TRM;
    @XmlElement(name="ENC_25")
    private String      HZRNENC_NUM_PRED;
    @XmlElement(name="ENC_26")
    private String      HZRNENC_CUNE_PRED;
    @XmlElement(name="ENC_27")
    private Date      HZRNENC_FECHA_GEN_PRED;

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

    public void setHZRNENC_TIPO_DOC(String HZRNENC_TIPO_DOC) {
        this.HZRNENC_TIPO_DOC = HZRNENC_TIPO_DOC;
    }
    @XmlTransient
    public Date getHZRNENC_FECHA_ING() {
        return HZRNENC_FECHA_ING;
    }

    public void setHZRNENC_FECHA_ING(Date HZRNENC_FECHA_ING) {
        this.HZRNENC_FECHA_ING = HZRNENC_FECHA_ING;
    }
    @XmlTransient
    public Date getHZRNENC_FECHA_RET() {
        return HZRNENC_FECHA_RET;
    }

    public void setHZRNENC_FECHA_RET(Date HZRNENC_FECHA_RET) {
        this.HZRNENC_FECHA_RET = HZRNENC_FECHA_RET;
    }
    @XmlTransient
    public Date getHZRNENC_FECHA_LIQ_INI() {
        return HZRNENC_FECHA_LIQ_INI;
    }

    public void setHZRNENC_FECHA_LIQ_INI(Date HZRNENC_FECHA_LIQ_INI) {
        this.HZRNENC_FECHA_LIQ_INI = HZRNENC_FECHA_LIQ_INI;
    }
    @XmlTransient
    public Date getHZRNENC_FECHA_LIQ_FIN() {
        return HZRNENC_FECHA_LIQ_FIN;
    }

    public void setHZRNENC_FECHA_LIQ_FIN(Date HZRNENC_FECHA_LIQ_FIN) {
        this.HZRNENC_FECHA_LIQ_FIN = HZRNENC_FECHA_LIQ_FIN;
    }
    @XmlTransient
    public Double getHZRNENC_TIEMPO_LAB() {
        return HZRNENC_TIEMPO_LAB;
    }

    public void setHZRNENC_TIEMPO_LAB(Double HZRNENC_TIEMPO_LAB) {
        this.HZRNENC_TIEMPO_LAB = HZRNENC_TIEMPO_LAB;
    }
    @XmlTransient
    public Date getHZRNENC_FECHA_EMISION() {
        return HZRNENC_FECHA_EMISION;
    }

    public void setHZRNENC_FECHA_EMISION(Date HZRNENC_FECHA_EMISION) {
        this.HZRNENC_FECHA_EMISION = HZRNENC_FECHA_EMISION;
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

    public void setHZRNENC_CONSECUTIVO(Long HZRNENC_CONSECUTIVO) {
        this.HZRNENC_CONSECUTIVO = HZRNENC_CONSECUTIVO;
    }
    @XmlTransient
    public String getHZRNENC_NUMERO() {
        return HZRNENC_NUMERO;
    }

    public void setHZRNENC_NUMERO(String HZRNENC_NUMERO) {
        this.HZRNENC_NUMERO = HZRNENC_NUMERO;
    }
    @XmlTransient
    public String getHZRNENC_PAIS() {
        return HZRNENC_PAIS;
    }

    public void setHZRNENC_PAIS(String HZRNENC_PAIS) {
        this.HZRNENC_PAIS = HZRNENC_PAIS;
    }
    @XmlTransient
    public Integer getHZRNENC_DEPART_ESTADO() {
        return HZRNENC_DEPART_ESTADO;
    }

    public void setHZRNENC_DEPART_ESTADO(Integer HZRNENC_DEPART_ESTADO) {
        this.HZRNENC_DEPART_ESTADO = HZRNENC_DEPART_ESTADO;
    }
    @XmlTransient
    public Integer getHZRNENC_MUNICIPIO_CIUDAD() {
        return HZRNENC_MUNICIPIO_CIUDAD;
    }

    public void setHZRNENC_MUNICIPIO_CIUDAD(Integer HZRNENC_MUNICIPIO_CIUDAD) {
        this.HZRNENC_MUNICIPIO_CIUDAD = HZRNENC_MUNICIPIO_CIUDAD;
    }
    @XmlTransient
    public String getHZRNENC_IDIOMA() {
        return HZRNENC_IDIOMA;
    }

    public void setHZRNENC_IDIOMA(String HZRNENC_IDIOMA) {
        this.HZRNENC_IDIOMA = HZRNENC_IDIOMA;
    }
    @XmlTransient
    public String getHZRNENC_VERSION() {
        return HZRNENC_VERSION;
    }

    public void setHZRNENC_VERSION(String HZRNENC_VERSION) {
        this.HZRNENC_VERSION = HZRNENC_VERSION;
    }
    @XmlTransient
    public Integer getHZRNENC_AMBIENTE() {
        return HZRNENC_AMBIENTE;
    }

    public void setHZRNENC_AMBIENTE(Integer HZRNENC_AMBIENTE) {
        this.HZRNENC_AMBIENTE = HZRNENC_AMBIENTE;
    }
    @XmlTransient
    public Integer getHZRNENC_TIPO_XML() {
        return HZRNENC_TIPO_XML;
    }

    public void setHZRNENC_TIPO_XML(Integer HZRNENC_TIPO_XML) {
        this.HZRNENC_TIPO_XML = HZRNENC_TIPO_XML;
    }
    @XmlTransient
    public String getHZRNENC_CUNE() {
        return HZRNENC_CUNE;
    }

    public void setHZRNENC_CUNE(String HZRNENC_CUNE) {
        this.HZRNENC_CUNE = HZRNENC_CUNE;
    }
    @XmlTransient
    public Date getHZRNENC_FECHA_GENERA() {
        return HZRNENC_FECHA_GENERA;
    }

    public void setHZRNENC_FECHA_GENERA(Date HZRNENC_FECHA_GENERA) {
        this.HZRNENC_FECHA_GENERA = HZRNENC_FECHA_GENERA;
    }
    @XmlTransient
    public String getHZRNENC_HORA_GENERA() {
        return HZRNENC_HORA_GENERA;
    }

    public void setHZRNENC_HORA_GENERA(String HZRNENC_HORA_GENERA) {
        this.HZRNENC_HORA_GENERA = HZRNENC_HORA_GENERA;
    }
    @XmlTransient
    public Integer getHZRNENC_PERIODO_NOM() {
        return HZRNENC_PERIODO_NOM;
    }

    public void setHZRNENC_PERIODO_NOM(Integer HZRNENC_PERIODO_NOM) {
        this.HZRNENC_PERIODO_NOM = HZRNENC_PERIODO_NOM;
    }
    @XmlTransient
    public String getHZRNENC_TIPO_MONEDA() {
        return HZRNENC_TIPO_MONEDA;
    }

    public void setHZRNENC_TIPO_MONEDA(String HZRNENC_TIPO_MONEDA) {
        this.HZRNENC_TIPO_MONEDA = HZRNENC_TIPO_MONEDA;
    }
    @XmlTransient
    public Double getHZRNENC_TRM() {
        return HZRNENC_TRM;
    }

    public void setHZRNENC_TRM(Double HZRNENC_TRM) {
        this.HZRNENC_TRM = HZRNENC_TRM;
    }
    @XmlTransient
    public String getHZRNENC_NUM_PRED() {
        return HZRNENC_NUM_PRED;
    }

    public void setHZRNENC_NUM_PRED(String HZRNENC_NUM_PRED) {
        this.HZRNENC_NUM_PRED = HZRNENC_NUM_PRED;
    }
    @XmlTransient
    public String getHZRNENC_CUNE_PRED() {
        return HZRNENC_CUNE_PRED;
    }

    public void setHZRNENC_CUNE_PRED(String HZRNENC_CUNE_PRED) {
        this.HZRNENC_CUNE_PRED = HZRNENC_CUNE_PRED;
    }
    @XmlTransient
    public Date getHZRNENC_FECHA_GEN_PRED() {
        return HZRNENC_FECHA_GEN_PRED;
    }

    public void setHZRNENC_FECHA_GEN_PRED(Date HZRNENC_FECHA_GEN_PRED) {
        this.HZRNENC_FECHA_GEN_PRED = HZRNENC_FECHA_GEN_PRED;
    }

    @Override
    public String toString() {
        return "ENC{" + "HZRNENC_CUNE_INTERNO=" + HZRNENC_CUNE_INTERNO + ", HZRNENC_TIPO_DOC=" + HZRNENC_TIPO_DOC + ", HZRNENC_FECHA_ING=" + HZRNENC_FECHA_ING + ", HZRNENC_FECHA_RET=" + HZRNENC_FECHA_RET + ", HZRNENC_FECHA_LIQ_INI=" + HZRNENC_FECHA_LIQ_INI + ", HZRNENC_FECHA_LIQ_FIN=" + HZRNENC_FECHA_LIQ_FIN + ", HZRNENC_TIEMPO_LAB=" + HZRNENC_TIEMPO_LAB + ", HZRNENC_FECHA_EMISION=" + HZRNENC_FECHA_EMISION + ", HZRNENC_CODIGO_TRAB=" + HZRNENC_CODIGO_TRAB + ", HZRNENC_PREFIJO=" + HZRNENC_PREFIJO + ", HZRNENC_CONSECUTIVO=" + HZRNENC_CONSECUTIVO + ", HZRNENC_NUMERO=" + HZRNENC_NUMERO + ", HZRNENC_PAIS=" + HZRNENC_PAIS + ", HZRNENC_DEPART_ESTADO=" + HZRNENC_DEPART_ESTADO + ", HZRNENC_MUNICIPIO_CIUDAD=" + HZRNENC_MUNICIPIO_CIUDAD + ", HZRNENC_IDIOMA=" + HZRNENC_IDIOMA + ", HZRNENC_VERSION=" + HZRNENC_VERSION + ", HZRNENC_AMBIENTE=" + HZRNENC_AMBIENTE + ", HZRNENC_TIPO_XML=" + HZRNENC_TIPO_XML + ", HZRNENC_CUNE=" + HZRNENC_CUNE + ", HZRNENC_FECHA_GENERA=" + HZRNENC_FECHA_GENERA + ", HZRNENC_HORA_GENERA=" + HZRNENC_HORA_GENERA + ", HZRNENC_PERIODO_NOM=" + HZRNENC_PERIODO_NOM + ", HZRNENC_TIPO_MONEDA=" + HZRNENC_TIPO_MONEDA + ", HZRNENC_TRM=" + HZRNENC_TRM + ", HZRNENC_NUM_PRED=" + HZRNENC_NUM_PRED + ", HZRNENC_CUNE_PRED=" + HZRNENC_CUNE_PRED + ", HZRNENC_FECHA_GEN_PRED=" + HZRNENC_FECHA_GEN_PRED + '}';
    }
 
    
}
