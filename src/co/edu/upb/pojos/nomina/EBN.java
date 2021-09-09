package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class EBN {
    
    @XmlElement(name = "EBN_1")
    private Double EBN_1;
    @XmlElement(name = "EBN_2")
    private Double EBN_2;

    public EBN() {
    }

    public EBN(Double EBN_1, Double EBN_2) {
        this.EBN_1 = EBN_1;
        this.EBN_2 = EBN_2;
    }
    @XmlTransient
    public Double getEBN_1() {
        return EBN_1;
    }

    public void setEBN_1(Double EBN_1) {
        this.EBN_1 = EBN_1;
    }
    @XmlTransient
    public Double getEBN_2() {
        return EBN_2;
    }

    public void setEBN_2(Double EBN_2) {
        this.EBN_2 = EBN_2;
    }

    @Override
    public String toString() {
        return "EBN{" + "EBN_1=" + EBN_1 + ", EBN_2=" + EBN_2 + '}';
    }
    
    
}
