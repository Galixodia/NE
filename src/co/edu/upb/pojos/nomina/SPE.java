package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class SPE {
    
    @XmlElement(name = "SPE_1")
    private Double SPE_1;
    @XmlElement(name = "SPE_2")
    private Double SPE_2;    

    public SPE() {
    }

    public SPE(Double SPE_1, Double SPE_2) {
        this.SPE_1 = SPE_1;
        this.SPE_2 = SPE_2;
    }
    @XmlTransient
    public Double getSPE_1() {
        return SPE_1;
    }

    public void setSPE_1(Double SPE_1) {
        this.SPE_1 = SPE_1;
    }
    @XmlTransient
    public Double getSPE_2() {
        return SPE_2;
    }

    public void setSPE_2(Double SPE_2) {
        this.SPE_2 = SPE_2;
    }

    @Override
    public String toString() {
        return "SPE{" + "SPE_1=" + SPE_1 + ", SPE_2=" + SPE_2 + '}';
    }
    
    
    
}
