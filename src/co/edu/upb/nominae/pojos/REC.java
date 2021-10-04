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
 * @author 000329744 Xiomara Torrez Muñoz
 * @since 00/09/2021
 * @version 1.0
 * Segmento Obligatorio. Puede repetirse  una sola (1) vez en el archivo.
 * Utilizado para Atributos del Trabajador o Receptor del Documento. Este Segemento es dependiente Ver Nota 3
 */


@XmlType (propOrder={"HZRNREC_TIPO_TRABAJADOR",
    "HZRNREC_SUB_TIPO_TRABAJ",
    "HZRNREC_ALTO_RIESGO_PENS",
    "HZRNREC_TIPO_DOC",
    "HZRNREC_NUM_DOC",
    "HZRNREC_PRIMER_APELLIDO",
    "HZRNREC_SEGUNDO_APELLIDO",
    "HZRNREC_PRIMER_NOMBRE",
    "HZRNREC_OTROS_NOMBRES",
    "HZRNREC_LUGAR_TRAB_PAIS",
    "HZRNREC_LUGAR_TRAB_DEPT_EST",
    "HZRNREC_LUGAR_TRAB_MUN_CIUD",
    "HZRNREC_LUGAR_TRAB_DIREC",
    "HZRNREC_SALARIO_INTEGRAL",
    "HZRNREC_TIPO_CONTRATO",
    "HZRNREC_SUELDO",
    "HZRNREC_COD_TRABAJADOR"})
public class REC {
    
    private String HZRNREC_CUNE_INTERNO;
    @XmlElement(name = "REC_1")
    private String HZRNREC_TIPO_TRABAJADOR;
    @XmlElement(name = "REC_2")
    private String HZRNREC_SUB_TIPO_TRABAJ;
    @XmlElement(name = "REC_3")
    private String HZRNREC_ALTO_RIESGO_PENS;
    @XmlElement(name = "REC_4")
    private Integer HZRNREC_TIPO_DOC;
    @XmlElement(name = "REC_5")
    private Long HZRNREC_NUM_DOC;
    @XmlElement(name = "REC_6")
    private String HZRNREC_PRIMER_APELLIDO;
    @XmlElement(name = "REC_7")
    private String HZRNREC_SEGUNDO_APELLIDO;
    @XmlElement(name = "REC_8")
    private String HZRNREC_PRIMER_NOMBRE;
    @XmlElement(name = "REC_9")
    private String HZRNREC_OTROS_NOMBRES;
    @XmlElement(name = "REC_10")
    private String HZRNREC_LUGAR_TRAB_PAIS;
    @XmlElement(name = "REC_11")
    private String HZRNREC_LUGAR_TRAB_DEPT_EST;
    @XmlElement(name = "REC_12")
    private String HZRNREC_LUGAR_TRAB_MUN_CIUD;
    @XmlElement(name = "REC_13")
    private String HZRNREC_LUGAR_TRAB_DIREC;
    @XmlElement(name = "REC_14")
    private String HZRNREC_SALARIO_INTEGRAL;
    @XmlElement(name = "REC_15")
    private Integer HZRNREC_TIPO_CONTRATO;
    @XmlElement(name = "REC_16")
    private String HZRNREC_SUELDO;
    @XmlElement(name = "REC_17")
    private String HZRNREC_COD_TRABAJADOR;
    
    @XmlTransient
    public String getHZRNREC_CUNE_INTERNO() {
        return HZRNREC_CUNE_INTERNO;
    }

    public void setHZRNREC_CUNE_INTERNO(String HZRNREC_CUNE_INTERNO) {
        this.HZRNREC_CUNE_INTERNO = HZRNREC_CUNE_INTERNO;
    }
    @XmlTransient
    public String getHZRNREC_TIPO_TRABAJADOR() {
        return HZRNREC_TIPO_TRABAJADOR;
    }

    public void setHZRNREC_TIPO_TRABAJADOR(String HZRNREC_TIPO_TRABAJADOR) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_TIPO_TRABAJADOR,2)){
            this.HZRNREC_TIPO_TRABAJADOR = HZRNREC_TIPO_TRABAJADOR;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_TIPO_TRABAJADOR:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public String getHZRNREC_SUB_TIPO_TRABAJ() {
        return HZRNREC_SUB_TIPO_TRABAJ;
    }

    public void setHZRNREC_SUB_TIPO_TRABAJ(String HZRNREC_SUB_TIPO_TRABAJ) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_SUB_TIPO_TRABAJ,2)){
            this.HZRNREC_SUB_TIPO_TRABAJ = HZRNREC_SUB_TIPO_TRABAJ;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_SUB_TIPO_TRABAJ:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public String getHZRNREC_ALTO_RIESGO_PENS() {
        return HZRNREC_ALTO_RIESGO_PENS;
    }

    public void setHZRNREC_ALTO_RIESGO_PENS(String HZRNREC_ALTO_RIESGO_PENS) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_ALTO_RIESGO_PENS,5)){
            this.HZRNREC_ALTO_RIESGO_PENS = HZRNREC_ALTO_RIESGO_PENS;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_ALTO_RIESGO_PENS:El campo es nulo o excede la longitud definida por la DIAN");
        }           
    }
    @XmlTransient
    public Integer getHZRNREC_TIPO_DOC() {
        return HZRNREC_TIPO_DOC;
    }

    public void setHZRNREC_TIPO_DOC(Integer HZRNREC_TIPO_DOC) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_TIPO_DOC,2)){
            this.HZRNREC_TIPO_DOC = HZRNREC_TIPO_DOC;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_TIPO_DOC:El campo es nulo o excede la longitud definida por la DIAN");
        }         
    }
    @XmlTransient
    public Long getHZRNREC_NUM_DOC() {
        return HZRNREC_NUM_DOC;
    }

    public void setHZRNREC_NUM_DOC(Long HZRNREC_NUM_DOC) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_NUM_DOC,20)){
            this.HZRNREC_NUM_DOC = HZRNREC_NUM_DOC;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_NUM_DOC:El campo es nulo o excede la longitud definida por la DIAN");
        }           
    }
    @XmlTransient
    public String getHZRNREC_PRIMER_APELLIDO() {
        return HZRNREC_PRIMER_APELLIDO;
    }

    public void setHZRNREC_PRIMER_APELLIDO(String HZRNREC_PRIMER_APELLIDO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_PRIMER_APELLIDO,60)){
            this.HZRNREC_PRIMER_APELLIDO = HZRNREC_PRIMER_APELLIDO;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_PRIMER_APELLIDO:El campo es nulo o excede la longitud definida por la DIAN");
        }           
    }
    @XmlTransient
    public String getHZRNREC_SEGUNDO_APELLIDO() {
        return HZRNREC_SEGUNDO_APELLIDO;
    }

    public void setHZRNREC_SEGUNDO_APELLIDO(String HZRNREC_SEGUNDO_APELLIDO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_SEGUNDO_APELLIDO,60)){
            this.HZRNREC_SEGUNDO_APELLIDO = HZRNREC_SEGUNDO_APELLIDO;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_SEGUNDO_APELLIDO:El campo es nulo o excede la longitud definida por la DIAN");
        }         
    }
    @XmlTransient
    public String getHZRNREC_PRIMER_NOMBRE() {
        return HZRNREC_PRIMER_NOMBRE;
    }

    public void setHZRNREC_PRIMER_NOMBRE(String HZRNREC_PRIMER_NOMBRE) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_PRIMER_NOMBRE,60)){
            this.HZRNREC_PRIMER_NOMBRE = HZRNREC_PRIMER_NOMBRE;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_PRIMER_NOMBRE:El campo es nulo o excede la longitud definida por la DIAN");
        }         
    }
    @XmlTransient
    public String getHZRNREC_OTROS_NOMBRES() {
        return HZRNREC_OTROS_NOMBRES;
    }

    public void setHZRNREC_OTROS_NOMBRES(String HZRNREC_OTROS_NOMBRES) {
        this.HZRNREC_OTROS_NOMBRES = HZRNREC_OTROS_NOMBRES;
    }
    @XmlTransient
    public String getHZRNREC_LUGAR_TRAB_PAIS() {
        return HZRNREC_LUGAR_TRAB_PAIS;
    }

    public void setHZRNREC_LUGAR_TRAB_PAIS(String HZRNREC_LUGAR_TRAB_PAIS) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_LUGAR_TRAB_PAIS,3)){
            this.HZRNREC_LUGAR_TRAB_PAIS = HZRNREC_LUGAR_TRAB_PAIS;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_LUGAR_TRAB_PAIS:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public String getHZRNREC_LUGAR_TRAB_DEPT_EST() {
        return HZRNREC_LUGAR_TRAB_DEPT_EST;
    }

    public void setHZRNREC_LUGAR_TRAB_DEPT_EST(String HZRNREC_LUGAR_TRAB_DEPT_EST) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_LUGAR_TRAB_DEPT_EST,2)){
            this.HZRNREC_LUGAR_TRAB_DEPT_EST = HZRNREC_LUGAR_TRAB_DEPT_EST;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_LUGAR_TRAB_DEPT_EST:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public String getHZRNREC_LUGAR_TRAB_MUN_CIUD() {
        return HZRNREC_LUGAR_TRAB_MUN_CIUD;
    }

    public void setHZRNREC_LUGAR_TRAB_MUN_CIUD(String HZRNREC_LUGAR_TRAB_MUN_CIUD) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_LUGAR_TRAB_MUN_CIUD,5)){
            this.HZRNREC_LUGAR_TRAB_MUN_CIUD = HZRNREC_LUGAR_TRAB_MUN_CIUD;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_LUGAR_TRAB_MUN_CIUD:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public String getHZRNREC_LUGAR_TRAB_DIREC() {
        return HZRNREC_LUGAR_TRAB_DIREC;
    }

    public void setHZRNREC_LUGAR_TRAB_DIREC(String HZRNREC_LUGAR_TRAB_DIREC) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_LUGAR_TRAB_DIREC,300)){
            this.HZRNREC_LUGAR_TRAB_DIREC = HZRNREC_LUGAR_TRAB_DIREC;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_LUGAR_TRAB_DIREC:El campo es nulo o excede la longitud definida por la DIAN");
        }            
    }
    @XmlTransient
    public String getHZRNREC_SALARIO_INTEGRAL() {
        return HZRNREC_SALARIO_INTEGRAL;
    }

    public void setHZRNREC_SALARIO_INTEGRAL(String HZRNREC_SALARIO_INTEGRAL) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_SALARIO_INTEGRAL,5)){
            this.HZRNREC_SALARIO_INTEGRAL = HZRNREC_SALARIO_INTEGRAL;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_SALARIO_INTEGRAL:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public Integer getHZRNREC_TIPO_CONTRATO() {
        return HZRNREC_TIPO_CONTRATO;
    }

    public void setHZRNREC_TIPO_CONTRATO(Integer HZRNREC_TIPO_CONTRATO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNREC_TIPO_CONTRATO,1)){
            this.HZRNREC_TIPO_CONTRATO = HZRNREC_TIPO_CONTRATO;
            data = null;            
        }else{
            throw new DataFormatException("REC:HZRNREC_TIPO_CONTRATO:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public String getHZRNREC_SUELDO() {
        return HZRNREC_SUELDO;
    }

    public void setHZRNREC_SUELDO(BigDecimal HZRNREC_SUELDO) throws DataFormatException {
        if(HZRNREC_SUELDO != null){
            this.HZRNREC_SUELDO = new DecimalFormat("0.000000").format(HZRNREC_SUELDO).replace(",",".");    
        }else{
            this.HZRNREC_SUELDO = String.valueOf(HZRNREC_SUELDO);
        }
    }
    @XmlTransient
    public String getHZRNREC_COD_TRABAJADOR() {
        return HZRNREC_COD_TRABAJADOR;
    }

    public void setHZRNREC_COD_TRABAJADOR(String HZRNREC_COD_TRABAJADOR) {
        this.HZRNREC_COD_TRABAJADOR = HZRNREC_COD_TRABAJADOR;
    }

    @Override
    public String toString() {
        return "REC{" + "HZRNREC_CUNE_INTERNO=" + HZRNREC_CUNE_INTERNO + ", HZRNREC_TIPO_TRABAJADOR=" + HZRNREC_TIPO_TRABAJADOR + ", HZRNREC_SUB_TIPO_TRABAJ=" + HZRNREC_SUB_TIPO_TRABAJ + ", HZRNREC_ALTO_RIESGO_PENS=" + HZRNREC_ALTO_RIESGO_PENS + ", HZRNREC_TIPO_DOC=" + HZRNREC_TIPO_DOC + ", HZRNREC_NUM_DOC=" + HZRNREC_NUM_DOC + ", HZRNREC_PRIMER_APELLIDO=" + HZRNREC_PRIMER_APELLIDO + ", HZRNREC_SEGUNDO_APELLIDO=" + HZRNREC_SEGUNDO_APELLIDO + ", HZRNREC_PRIMER_NOMBRE=" + HZRNREC_PRIMER_NOMBRE + ", HZRNREC_OTROS_NOMBRES=" + HZRNREC_OTROS_NOMBRES + ", HZRNREC_LUGAR_TRAB_PAIS=" + HZRNREC_LUGAR_TRAB_PAIS + ", HZRNREC_LUGAR_TRAB_DEPT_EST=" + HZRNREC_LUGAR_TRAB_DEPT_EST + ", HZRNREC_LUGAR_TRAB_MUN_CIUD=" + HZRNREC_LUGAR_TRAB_MUN_CIUD + ", HZRNREC_LUGAR_TRAB_DIREC=" + HZRNREC_LUGAR_TRAB_DIREC + ", HZRNREC_SALARIO_INTEGRAL=" + HZRNREC_SALARIO_INTEGRAL + ", HZRNREC_TIPO_CONTRATO=" + HZRNREC_TIPO_CONTRATO + ", HZRNREC_SUELDO=" + HZRNREC_SUELDO + ", HZRNREC_COD_TRABAJADOR=" + HZRNREC_COD_TRABAJADOR + '}';
    }
    
}
