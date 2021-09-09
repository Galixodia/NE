package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class EVA {
    
    @XmlElement(name = "EVA_1")
    private long EVA_1;
    @XmlElement(name = "EVA_2")
    private Double EVA_2;    

    public EVA() {
    }

    public EVA(long EVA_1, Double EVA_2) {
        this.EVA_1 = EVA_1;
        this.EVA_2 = EVA_2;
    }
    @XmlTransient
    public long getEVA_1() {
        return EVA_1;
    }

    public void setEVA_1(long EVA_1) {
        this.EVA_1 = EVA_1;
    }
    @XmlTransient
    public Double getEVA_2() {
        return EVA_2;
    }

    public void setEVA_2(Double EVA_2) {
        this.EVA_2 = EVA_2;
    }

    @Override
    public String toString() {
        return "EVA{" + "EVA_1=" + EVA_1 + ", EVA_2=" + EVA_2 + '}';
    }

}
