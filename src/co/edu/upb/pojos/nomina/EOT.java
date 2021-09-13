package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EOT")
@XmlType (propOrder={"HZRNEOT_DESC_CONCEPTO",
    "HZRNEOT_CONCEP_SALARIAL",
    "HZRNEOT_CONCEP_NO_SALARIAL"})

public class EOT {
    
    @XmlElement(name = "EOT_1")
    private String HZRNEOT_DESC_CONCEPTO;
    @XmlElement(name = "EOT_2")
    private Double HZRNEOT_CONCEP_SALARIAL;
    @XmlElement(name = "EOT_3")
    private Double HZRNEOT_CONCEP_NO_SALARIAL;
    private Integer HZRNEOT_ITE_ID;       

    @XmlTransient
    public String getHZRNEOT_DESC_CONCEPTO() {
        return HZRNEOT_DESC_CONCEPTO;
    }

    public void setHZRNEOT_DESC_CONCEPTO(String HZRNEOT_DESC_CONCEPTO) {
        this.HZRNEOT_DESC_CONCEPTO = HZRNEOT_DESC_CONCEPTO;
    }
    @XmlTransient
    public Double getHZRNEOT_CONCEP_SALARIAL() {
        return HZRNEOT_CONCEP_SALARIAL;
    }

    public void setHZRNEOT_CONCEP_SALARIAL(Double HZRNEOT_CONCEP_SALARIAL) {
        this.HZRNEOT_CONCEP_SALARIAL = HZRNEOT_CONCEP_SALARIAL;
    }
    @XmlTransient
    public Double getHZRNEOT_CONCEP_NO_SALARIAL() {
        return HZRNEOT_CONCEP_NO_SALARIAL;
    }

    public void setHZRNEOT_CONCEP_NO_SALARIAL(Double HZRNEOT_CONCEP_NO_SALARIAL) {
        this.HZRNEOT_CONCEP_NO_SALARIAL = HZRNEOT_CONCEP_NO_SALARIAL;
    }
    @XmlTransient
    public Integer getHZRNEOT_ITE_ID() {
        return HZRNEOT_ITE_ID;
    }

    public void setHZRNEOT_ITE_ID(Integer HZRNEOT_ITE_ID) {
        this.HZRNEOT_ITE_ID = HZRNEOT_ITE_ID;
    }

    @Override
    public String toString() {
        return "EOT{" + "HZRNEOT_DESC_CONCEPTO=" + HZRNEOT_DESC_CONCEPTO + ", HZRNEOT_CONCEP_SALARIAL=" + HZRNEOT_CONCEP_SALARIAL + ", HZRNEOT_CONCEP_NO_SALARIAL=" + HZRNEOT_CONCEP_NO_SALARIAL + ", HZRNEOT_ITE_ID=" + HZRNEOT_ITE_ID + '}';
    }
       
}
