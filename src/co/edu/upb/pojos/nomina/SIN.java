package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class SIN {
    
    @XmlElement(name = "SIN_1")
    private Double SIN_1;
    @XmlElement(name = "SIN_2")
    private Double SIN_5;

    public SIN() {
    }

    public SIN(Double SIN_1, Double SIN_5) {
        this.SIN_1 = SIN_1;
        this.SIN_5 = SIN_5;
    }
    @XmlTransient
    public Double getSIN_1() {
        return SIN_1;
    }

    public void setSIN_1(Double SIN_1) {
        this.SIN_1 = SIN_1;
    }
    @XmlTransient
    public Double getSIN_5() {
        return SIN_5;
    }

    public void setSIN_5(Double SIN_5) {
        this.SIN_5 = SIN_5;
    }

    @Override
    public String toString() {
        return "SIN{" + "SIN_1=" + SIN_1 + ", SIN_5=" + SIN_5 + '}';
    }
    
    
    
}
