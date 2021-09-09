package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class SOT {
    
    @XmlElement(name = "SOT_1")
    private Double SOT_1;
    @XmlElement(name = "SOT_2")
    private Double SOT_2;
    @XmlElement(name = "SOT_3")
    private Double SOT_3;    

    public SOT() {
    }

    public SOT(Double SOT_1, Double SOT_2, Double SOT_3) {
        this.SOT_1 = SOT_1;
        this.SOT_2 = SOT_2;
        this.SOT_3 = SOT_3;
    }
    @XmlTransient
    public Double getSOT_1() {
        return SOT_1;
    }

    public void setSOT_1(Double SOT_1) {
        this.SOT_1 = SOT_1;
    }
    @XmlTransient
    public Double getSOT_2() {
        return SOT_2;
    }

    public void setSOT_2(Double SOT_2) {
        this.SOT_2 = SOT_2;
    }
    @XmlTransient
    public Double getSOT_3() {
        return SOT_3;
    }

    public void setSOT_3(Double SOT_3) {
        this.SOT_3 = SOT_3;
    }

    @Override
    public String toString() {
        return "SOT{" + "SOT_1=" + SOT_1 + ", SOT_2=" + SOT_2 + ", SOT_3=" + SOT_3 + '}';
    }
    
    
    
}
