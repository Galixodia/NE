package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class SAN {
    
    @XmlElement(name = "SAN_1")
    private Double SAN_1;
    @XmlElement(name = "SAN_2")
    private Double SAN_2;

    public SAN() {
    }

    public SAN(Double SAN_1, Double SAN_2) {
        this.SAN_1 = SAN_1;
        this.SAN_2 = SAN_2;
    }
    @XmlTransient
    public Double getSAN_1() {
        return SAN_1;
    }

    public void setSAN_1(Double SAN_1) {
        this.SAN_1 = SAN_1;
    }
    @XmlTransient
    public Double getSAN_2() {
        return SAN_2;
    }

    public void setSAN_2(Double SAN_2) {
        this.SAN_2 = SAN_2;
    }

    @Override
    public String toString() {
        return "SAN{" + "SAN_1=" + SAN_1 + ", SAN_2=" + SAN_2 + '}';
    }
    
    
    
    
}
