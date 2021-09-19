package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
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
    private BigDecimal HZRNSVA_PENSION_VOLUNTARIA;
    @XmlElement(name = "SVA_2")
    private BigDecimal HZRNSVA_RENTENCION_FTE;
    @XmlElement(name = "SVA_3")
    private BigDecimal HZRNSVA_AFC;
    @XmlElement(name = "SVA_4")
    private BigDecimal HZRNSVA_COOPERATIVA;
    @XmlElement(name = "SVA_5")
    private BigDecimal HZRNSVA_EMBARGO;
    @XmlElement(name = "SVA_6")
    private BigDecimal HZRNSVA_PLAN_COMPLEMENT;
    @XmlElement(name = "SVA_7")
    private BigDecimal HZRNSVA_EDUCACION;
    @XmlElement(name = "SVA_8")
    private BigDecimal HZRNSVA_REINTEGRO;
    @XmlElement(name = "SVA_9")
    private BigDecimal HZRNSVA_DEUDA;
    private Integer HZRNSVA_ITS_ID;       

    @XmlTransient
    public BigDecimal getHZRNSVA_PENSION_VOLUNTARIA() {
        return HZRNSVA_PENSION_VOLUNTARIA;
    }

    public void setHZRNSVA_PENSION_VOLUNTARIA(BigDecimal HZRNSVA_PENSION_VOLUNTARIA) {
        this.HZRNSVA_PENSION_VOLUNTARIA = HZRNSVA_PENSION_VOLUNTARIA;
    }
    @XmlTransient
    public BigDecimal getHZRNSVA_RENTENCION_FTE() {
        return HZRNSVA_RENTENCION_FTE;
    }

    public void setHZRNSVA_RENTENCION_FTE(BigDecimal HZRNSVA_RENTENCION_FTE) {
        this.HZRNSVA_RENTENCION_FTE = HZRNSVA_RENTENCION_FTE;
    }
    @XmlTransient
    public BigDecimal getHZRNSVA_AFC() {
        return HZRNSVA_AFC;
    }

    public void setHZRNSVA_AFC(BigDecimal HZRNSVA_AFC) {
        this.HZRNSVA_AFC = HZRNSVA_AFC;
    }
    @XmlTransient
    public BigDecimal getHZRNSVA_COOPERATIVA() {
        return HZRNSVA_COOPERATIVA;
    }

    public void setHZRNSVA_COOPERATIVA(BigDecimal HZRNSVA_COOPERATIVA) {
        this.HZRNSVA_COOPERATIVA = HZRNSVA_COOPERATIVA;
    }
    @XmlTransient
    public BigDecimal getHZRNSVA_EMBARGO() {
        return HZRNSVA_EMBARGO;
    }

    public void setHZRNSVA_EMBARGO(BigDecimal HZRNSVA_EMBARGO) {
        this.HZRNSVA_EMBARGO = HZRNSVA_EMBARGO;
    }
    @XmlTransient
    public BigDecimal getHZRNSVA_PLAN_COMPLEMENT() {
        return HZRNSVA_PLAN_COMPLEMENT;
    }

    public void setHZRNSVA_PLAN_COMPLEMENT(BigDecimal HZRNSVA_PLAN_COMPLEMENT) {
        this.HZRNSVA_PLAN_COMPLEMENT = HZRNSVA_PLAN_COMPLEMENT;
    }
    @XmlTransient
    public BigDecimal getHZRNSVA_EDUCACION() {
        return HZRNSVA_EDUCACION;
    }

    public void setHZRNSVA_EDUCACION(BigDecimal HZRNSVA_EDUCACION) {
        this.HZRNSVA_EDUCACION = HZRNSVA_EDUCACION;
    }
    @XmlTransient
    public BigDecimal getHZRNSVA_REINTEGRO() {
        return HZRNSVA_REINTEGRO;
    }

    public void setHZRNSVA_REINTEGRO(BigDecimal HZRNSVA_REINTEGRO) {
        this.HZRNSVA_REINTEGRO = HZRNSVA_REINTEGRO;
    }
    @XmlTransient
    public BigDecimal getHZRNSVA_DEUDA() {
        return HZRNSVA_DEUDA;
    }

    public void setHZRNSVA_DEUDA(BigDecimal HZRNSVA_DEUDA) {
        this.HZRNSVA_DEUDA = HZRNSVA_DEUDA;
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
