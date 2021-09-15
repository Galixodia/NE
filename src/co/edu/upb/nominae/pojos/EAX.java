package co.edu.upb.nominae.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "EAX")
@XmlType (propOrder={"HZRNEAX_AUX_SALARIAL",
    "HZRNEAX_AUX_NO_SALARIAL"})


public class EAX {
    
    @XmlElement(name = "EAX_1")
    private Double HZRNEAX_AUX_SALARIAL;
    @XmlElement(name = "EAX_2")
    private Double HZRNEAX_AUX_NO_SALARIAL;
    private Integer HZRNEAX_ITE_ID;       

    @XmlTransient
    public Double getHZRNEAX_AUX_SALARIAL() {
        return HZRNEAX_AUX_SALARIAL;
    }

    public void setHZRNEAX_AUX_SALARIAL(Double HZRNEAX_AUX_SALARIAL) {
        this.HZRNEAX_AUX_SALARIAL = HZRNEAX_AUX_SALARIAL;
    }
    @XmlTransient
    public Double getHZRNEAX_AUX_NO_SALARIAL() {
        return HZRNEAX_AUX_NO_SALARIAL;
    }

    public void setHZRNEAX_AUX_NO_SALARIAL(Double HZRNEAX_AUX_NO_SALARIAL) {
        this.HZRNEAX_AUX_NO_SALARIAL = HZRNEAX_AUX_NO_SALARIAL;
    }
    @XmlTransient
    public Integer getHZRNEAX_ITE_ID() {
        return HZRNEAX_ITE_ID;
    }

    public void setHZRNEAX_ITE_ID(Integer HZRNEAX_ITE_ID) {
        this.HZRNEAX_ITE_ID = HZRNEAX_ITE_ID;
    }

    @Override
    public String toString() {
        return "EAX{" + "HZRNEAX_AUX_SALARIAL=" + HZRNEAX_AUX_SALARIAL + ", HZRNEAX_AUX_NO_SALARIAL=" + HZRNEAX_AUX_NO_SALARIAL + ", HZRNEAX_ITE_ID=" + HZRNEAX_ITE_ID + '}';
    }

     
}
