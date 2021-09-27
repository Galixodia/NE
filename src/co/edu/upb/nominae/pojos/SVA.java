package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNSVA_PENSION_VOLUNTARIA",
    "HZRNSVA_RENTENCION_FTE",
    "HZRNSVA_AFC",
    "HZRNSVA_COOPERATIVA",
    "HZRNSVA_EMBARGO",
    "HZRNSVA_PLAN_COMPLEMENT",
    "HZRNSVA_EDUCACION",    
    "HZRNSVA_REINTEGRO",
    "HZRNSVA_DEUDA"})
public class SVA {
    
    @XmlElement(name = "SVA_1")
    private String HZRNSVA_PENSION_VOLUNTARIA;
    @XmlElement(name = "SVA_2")
    private String HZRNSVA_RENTENCION_FTE;
    @XmlElement(name = "SVA_3")
    private String HZRNSVA_AFC;
    @XmlElement(name = "SVA_4")
    private String HZRNSVA_COOPERATIVA;
    @XmlElement(name = "SVA_5")
    private String HZRNSVA_EMBARGO;
    @XmlElement(name = "SVA_6")
    private String HZRNSVA_PLAN_COMPLEMENT;
    @XmlElement(name = "SVA_7")
    private String HZRNSVA_EDUCACION;
    @XmlElement(name = "SVA_8")
    private String HZRNSVA_REINTEGRO;
    @XmlElement(name = "SVA_9")
    private String HZRNSVA_DEUDA;
    private Integer HZRNSVA_ITS_ID;       

    @XmlTransient
    public String getHZRNSVA_PENSION_VOLUNTARIA() {
        return HZRNSVA_PENSION_VOLUNTARIA;
    }

    public void setHZRNSVA_PENSION_VOLUNTARIA(BigDecimal HZRNSVA_PENSION_VOLUNTARIA) {
        if(HZRNSVA_PENSION_VOLUNTARIA != null){
            this.HZRNSVA_PENSION_VOLUNTARIA = new DecimalFormat("#.000000").format(HZRNSVA_PENSION_VOLUNTARIA).replace(",","."); 
        }
    }
    @XmlTransient
    public String getHZRNSVA_RENTENCION_FTE() {
        return HZRNSVA_RENTENCION_FTE;
    }

    public void setHZRNSVA_RENTENCION_FTE(BigDecimal HZRNSVA_RENTENCION_FTE) {
        if(HZRNSVA_RENTENCION_FTE != null){
            this.HZRNSVA_RENTENCION_FTE = new DecimalFormat("#.000000").format(HZRNSVA_RENTENCION_FTE).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNSVA_AFC() {
        return HZRNSVA_AFC;
    }

    public void setHZRNSVA_AFC(BigDecimal HZRNSVA_AFC) {
        if(HZRNSVA_AFC != null){
            this.HZRNSVA_AFC = new DecimalFormat("#.000000").format(HZRNSVA_AFC).replace(",",".");   
        }
    }
    @XmlTransient
    public String getHZRNSVA_COOPERATIVA() {
        return HZRNSVA_COOPERATIVA;
    }

    public void setHZRNSVA_COOPERATIVA(BigDecimal HZRNSVA_COOPERATIVA) {
        if(HZRNSVA_COOPERATIVA != null){
            this.HZRNSVA_COOPERATIVA = new DecimalFormat("#.000000").format(HZRNSVA_COOPERATIVA).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNSVA_EMBARGO() {
        return HZRNSVA_EMBARGO;
    }

    public void setHZRNSVA_EMBARGO(BigDecimal HZRNSVA_EMBARGO) {
        if(HZRNSVA_EMBARGO != null){
            this.HZRNSVA_EMBARGO = new DecimalFormat("#.000000").format(HZRNSVA_EMBARGO).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNSVA_PLAN_COMPLEMENT() {
        return HZRNSVA_PLAN_COMPLEMENT;
    }

    public void setHZRNSVA_PLAN_COMPLEMENT(BigDecimal HZRNSVA_PLAN_COMPLEMENT) {
        if(HZRNSVA_PLAN_COMPLEMENT != null){
            this.HZRNSVA_PLAN_COMPLEMENT = new DecimalFormat("#.000000").format(HZRNSVA_PLAN_COMPLEMENT).replace(",","."); 
        }
    }
    @XmlTransient
    public String getHZRNSVA_EDUCACION() {
        return HZRNSVA_EDUCACION;
    }

    public void setHZRNSVA_EDUCACION(BigDecimal HZRNSVA_EDUCACION) { 
        if(HZRNSVA_EDUCACION != null){
            this.HZRNSVA_EDUCACION = new DecimalFormat("#.000000").format(HZRNSVA_EDUCACION).replace(",",".");
        }
    }
    @XmlTransient
    public String getHZRNSVA_REINTEGRO() {
        return HZRNSVA_REINTEGRO;
    }

    public void setHZRNSVA_REINTEGRO(BigDecimal HZRNSVA_REINTEGRO) {
        if(HZRNSVA_REINTEGRO != null){
            this.HZRNSVA_REINTEGRO = new DecimalFormat("#.000000").format(HZRNSVA_REINTEGRO).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNSVA_DEUDA() {
        return HZRNSVA_DEUDA;
    }

    public void setHZRNSVA_DEUDA(BigDecimal HZRNSVA_DEUDA) {
        if(HZRNSVA_DEUDA != null){
            this.HZRNSVA_DEUDA = new DecimalFormat("#.000000").format(HZRNSVA_DEUDA).replace(",","."); 
        }
    }
    @XmlTransient
    public Integer getHZRNSVA_ITS_ID() {
        return HZRNSVA_ITS_ID;
    }

    public void setHZRNSVA_ITS_ID(Integer HZRNSVA_ITS_ID) {
        this.HZRNSVA_ITS_ID = HZRNSVA_ITS_ID;
    }

    @Override
    public String toString() {
        return "SVA{" + "HZRNSVA_PENSION_VOLUNTARIA=" + HZRNSVA_PENSION_VOLUNTARIA + ", HZRNSVA_RENTENCION_FTE=" + HZRNSVA_RENTENCION_FTE + ", HZRNSVA_AFC=" + HZRNSVA_AFC + ", HZRNSVA_COOPERATIVA=" + HZRNSVA_COOPERATIVA + ", HZRNSVA_EMBARGO=" + HZRNSVA_EMBARGO + ", HZRNSVA_PLAN_COMPLEMENT=" + HZRNSVA_PLAN_COMPLEMENT + ", HZRNSVA_EDUCACION=" + HZRNSVA_EDUCACION + ", HZRNSVA_REINTEGRO=" + HZRNSVA_REINTEGRO + ", HZRNSVA_DEUDA=" + HZRNSVA_DEUDA + ", HZRNSVA_ITS_ID=" + HZRNSVA_ITS_ID + '}';
    }

   
    
}
