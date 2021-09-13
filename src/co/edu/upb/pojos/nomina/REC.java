package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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

@XmlRootElement(name = "REC")
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
    private Integer HZRNREC_TIPO_TRABAJADOR;
    @XmlElement(name = "REC_2")
    private Integer HZRNREC_SUB_TIPO_TRABAJ;
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
    private Integer HZRNREC_LUGAR_TRAB_PAIS;
    @XmlElement(name = "REC_11")
    private Integer HZRNREC_LUGAR_TRAB_DEPT_EST;
    @XmlElement(name = "REC_12")
    private Integer HZRNREC_LUGAR_TRAB_MUN_CIUD;
    @XmlElement(name = "REC_13")
    private String HZRNREC_LUGAR_TRAB_DIREC;
    @XmlElement(name = "REC_14")
    private String HZRNREC_SALARIO_INTEGRAL;
    @XmlElement(name = "REC_15")
    private Integer HZRNREC_TIPO_CONTRATO;
    @XmlElement(name = "REC_16")
    private Double HZRNREC_SUELDO;
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
    public Integer getHZRNREC_TIPO_TRABAJADOR() {
        return HZRNREC_TIPO_TRABAJADOR;
    }

    public void setHZRNREC_TIPO_TRABAJADOR(Integer HZRNREC_TIPO_TRABAJADOR) {
        this.HZRNREC_TIPO_TRABAJADOR = HZRNREC_TIPO_TRABAJADOR;
    }
    @XmlTransient
    public Integer getHZRNREC_SUB_TIPO_TRABAJ() {
        return HZRNREC_SUB_TIPO_TRABAJ;
    }

    public void setHZRNREC_SUB_TIPO_TRABAJ(Integer HZRNREC_SUB_TIPO_TRABAJ) {
        this.HZRNREC_SUB_TIPO_TRABAJ = HZRNREC_SUB_TIPO_TRABAJ;
    }
    @XmlTransient
    public String getHZRNREC_ALTO_RIESGO_PENS() {
        return HZRNREC_ALTO_RIESGO_PENS;
    }

    public void setHZRNREC_ALTO_RIESGO_PENS(String HZRNREC_ALTO_RIESGO_PENS) {
        this.HZRNREC_ALTO_RIESGO_PENS = HZRNREC_ALTO_RIESGO_PENS;
    }
    @XmlTransient
    public Integer getHZRNREC_TIPO_DOC() {
        return HZRNREC_TIPO_DOC;
    }

    public void setHZRNREC_TIPO_DOC(Integer HZRNREC_TIPO_DOC) {
        this.HZRNREC_TIPO_DOC = HZRNREC_TIPO_DOC;
    }
    @XmlTransient
    public Long getHZRNREC_NUM_DOC() {
        return HZRNREC_NUM_DOC;
    }

    public void setHZRNREC_NUM_DOC(Long HZRNREC_NUM_DOC) {
        this.HZRNREC_NUM_DOC = HZRNREC_NUM_DOC;
    }
    @XmlTransient
    public String getHZRNREC_PRIMER_APELLIDO() {
        return HZRNREC_PRIMER_APELLIDO;
    }

    public void setHZRNREC_PRIMER_APELLIDO(String HZRNREC_PRIMER_APELLIDO) {
        this.HZRNREC_PRIMER_APELLIDO = HZRNREC_PRIMER_APELLIDO;
    }
    @XmlTransient
    public String getHZRNREC_SEGUNDO_APELLIDO() {
        return HZRNREC_SEGUNDO_APELLIDO;
    }

    public void setHZRNREC_SEGUNDO_APELLIDO(String HZRNREC_SEGUNDO_APELLIDO) {
        this.HZRNREC_SEGUNDO_APELLIDO = HZRNREC_SEGUNDO_APELLIDO;
    }
    @XmlTransient
    public String getHZRNREC_PRIMER_NOMBRE() {
        return HZRNREC_PRIMER_NOMBRE;
    }

    public void setHZRNREC_PRIMER_NOMBRE(String HZRNREC_PRIMER_NOMBRE) {
        this.HZRNREC_PRIMER_NOMBRE = HZRNREC_PRIMER_NOMBRE;
    }
    @XmlTransient
    public String getHZRNREC_OTROS_NOMBRES() {
        return HZRNREC_OTROS_NOMBRES;
    }

    public void setHZRNREC_OTROS_NOMBRES(String HZRNREC_OTROS_NOMBRES) {
        this.HZRNREC_OTROS_NOMBRES = HZRNREC_OTROS_NOMBRES;
    }
    @XmlTransient
    public Integer getHZRNREC_LUGAR_TRAB_PAIS() {
        return HZRNREC_LUGAR_TRAB_PAIS;
    }

    public void setHZRNREC_LUGAR_TRAB_PAIS(Integer HZRNREC_LUGAR_TRAB_PAIS) {
        this.HZRNREC_LUGAR_TRAB_PAIS = HZRNREC_LUGAR_TRAB_PAIS;
    }
    @XmlTransient
    public Integer getHZRNREC_LUGAR_TRAB_DEPT_EST() {
        return HZRNREC_LUGAR_TRAB_DEPT_EST;
    }

    public void setHZRNREC_LUGAR_TRAB_DEPT_EST(Integer HZRNREC_LUGAR_TRAB_DEPT_EST) {
        this.HZRNREC_LUGAR_TRAB_DEPT_EST = HZRNREC_LUGAR_TRAB_DEPT_EST;
    }
    @XmlTransient
    public Integer getHZRNREC_LUGAR_TRAB_MUN_CIUD() {
        return HZRNREC_LUGAR_TRAB_MUN_CIUD;
    }

    public void setHZRNREC_LUGAR_TRAB_MUN_CIUD(Integer HZRNREC_LUGAR_TRAB_MUN_CIUD) {
        this.HZRNREC_LUGAR_TRAB_MUN_CIUD = HZRNREC_LUGAR_TRAB_MUN_CIUD;
    }
    @XmlTransient
    public String getHZRNREC_LUGAR_TRAB_DIREC() {
        return HZRNREC_LUGAR_TRAB_DIREC;
    }

    public void setHZRNREC_LUGAR_TRAB_DIREC(String HZRNREC_LUGAR_TRAB_DIREC) {
        this.HZRNREC_LUGAR_TRAB_DIREC = HZRNREC_LUGAR_TRAB_DIREC;
    }
    @XmlTransient
    public String getHZRNREC_SALARIO_INTEGRAL() {
        return HZRNREC_SALARIO_INTEGRAL;
    }

    public void setHZRNREC_SALARIO_INTEGRAL(String HZRNREC_SALARIO_INTEGRAL) {
        this.HZRNREC_SALARIO_INTEGRAL = HZRNREC_SALARIO_INTEGRAL;
    }
    @XmlTransient
    public Integer getHZRNREC_TIPO_CONTRATO() {
        return HZRNREC_TIPO_CONTRATO;
    }

    public void setHZRNREC_TIPO_CONTRATO(Integer HZRNREC_TIPO_CONTRATO) {
        this.HZRNREC_TIPO_CONTRATO = HZRNREC_TIPO_CONTRATO;
    }
    @XmlTransient
    public Double getHZRNREC_SUELDO() {
        return HZRNREC_SUELDO;
    }

    public void setHZRNREC_SUELDO(Double HZRNREC_SUELDO) {
        this.HZRNREC_SUELDO = HZRNREC_SUELDO;
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
