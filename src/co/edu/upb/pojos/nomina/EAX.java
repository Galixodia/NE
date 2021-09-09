package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class EAX {
    
    @XmlElement(name = "EAX_1")
    private Double EAX_1;
    @XmlElement(name = "EAX_2")
    private Double EAX_2;

    public EAX() {
    }

    public EAX(Double EAX_1, Double EAX_2) {
        this.EAX_1 = EAX_1;
        this.EAX_2 = EAX_2;
    }
    @XmlTransient
    public Double getEAX_1() {
        return EAX_1;
    }

    public void setEAX_1(Double EAX_1) {
        this.EAX_1 = EAX_1;
    }
    @XmlTransient
    public Double getEAX_2() {
        return EAX_2;
    }

    public void setEAX_2(Double EAX_2) {
        this.EAX_2 = EAX_2;
    }

    @Override
    public String toString() {
        return "EAX{" + "EAX_1=" + EAX_1 + ", EAX_2=" + EAX_2 + '}';
    }
    
    
    
}
