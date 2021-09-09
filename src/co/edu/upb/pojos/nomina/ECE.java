package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class ECE {
    
    @XmlElement(name = "ECE_1")
    private Double ECE_1;
    @XmlElement(name = "ECE_2")
    private int ECE_2;
    @XmlElement(name = "ECE_3")
    private Double ECE_3;   

    public ECE() {
    }

    public ECE(Double ECE_1, int ECE_2, Double ECE_3) {
        this.ECE_1 = ECE_1;
        this.ECE_2 = ECE_2;
        this.ECE_3 = ECE_3;
    }
    @XmlTransient
    public Double getECE_1() {
        return ECE_1;
    }

    public void setECE_1(Double ECE_1) {
        this.ECE_1 = ECE_1;
    }
    @XmlTransient
    public int getECE_2() {
        return ECE_2;
    }

    public void setECE_2(int ECE_2) {
        this.ECE_2 = ECE_2;
    }
    @XmlTransient
    public Double getECE_3() {
        return ECE_3;
    }

    public void setECE_3(Double ECE_3) {
        this.ECE_3 = ECE_3;
    }

    @Override
    public String toString() {
        return "ECE{" + "ECE_1=" + ECE_1 + ", ECE_2=" + ECE_2 + ", ECE_3=" + ECE_3 + '}';
    }

    
}
