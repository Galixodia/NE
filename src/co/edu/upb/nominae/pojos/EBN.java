package co.edu.upb.nominae.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "EBN")
@XmlType (propOrder={"HZRNEBN_BONI_SALARIAL",
    "HZRNEBN_BONI_NO_SALARIAL"})

public class EBN {
    
    @XmlElement(name = "EBN_1")
    private Double HZRNEBN_BONI_SALARIAL;
    @XmlElement(name = "EBN_2")
    private Double HZRNEBN_BONI_NO_SALARIAL;
    private Integer HZRNEBN_ITE_ID;   

    @XmlTransient
    public Double getHZRNEBN_BONI_SALARIAL() {
        return HZRNEBN_BONI_SALARIAL;
    }

    public void setHZRNEBN_BONI_SALARIAL(Double HZRNEBN_BONI_SALARIAL) {
        this.HZRNEBN_BONI_SALARIAL = HZRNEBN_BONI_SALARIAL;
    }
    @XmlTransient
    public Double getHZRNEBN_BONI_NO_SALARIAL() {
        return HZRNEBN_BONI_NO_SALARIAL;
    }

    public void setHZRNEBN_BONI_NO_SALARIAL(Double HZRNEBN_BONI_NO_SALARIAL) {
        this.HZRNEBN_BONI_NO_SALARIAL = HZRNEBN_BONI_NO_SALARIAL;
    }
    @XmlTransient
    public Integer getHZRNEBN_ITE_ID() {
        return HZRNEBN_ITE_ID;
    }

    public void setHZRNEBN_ITE_ID(Integer HZRNEBN_ITE_ID) {
        this.HZRNEBN_ITE_ID = HZRNEBN_ITE_ID;
    }

    @Override
    public String toString() {
        return "EBN{" + "HZRNEBN_BONI_SALARIAL=" + HZRNEBN_BONI_SALARIAL + ", HZRNEBN_BONI_NO_SALARIAL=" + HZRNEBN_BONI_NO_SALARIAL + ", HZRNEBN_ITE_ID=" + HZRNEBN_ITE_ID + '}';
    }
    
  
 }
