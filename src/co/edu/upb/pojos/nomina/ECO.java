package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class ECO {
    
    @XmlElement(name = "ECO_1")
    private Double ECO_1;
    @XmlElement(name = "ECO_2")
    private Double ECO_2;
    @XmlElement(name = "ECO_3")
    private Double ECO_3;

    public ECO() {
    }

    public ECO(Double ECO_1, Double ECO_2, Double ECO_3) {
        this.ECO_1 = ECO_1;
        this.ECO_2 = ECO_2;
        this.ECO_3 = ECO_3;
    }
    @XmlTransient
    public Double getECO_1() {
        return ECO_1;
    }

    public void setECO_1(Double ECO_1) {
        this.ECO_1 = ECO_1;
    }
    @XmlTransient
    public Double getECO_2() {
        return ECO_2;
    }

    public void setECO_2(Double ECO_2) {
        this.ECO_2 = ECO_2;
    }
    @XmlTransient
    public Double getECO_3() {
        return ECO_3;
    }

    public void setECO_3(Double ECO_3) {
        this.ECO_3 = ECO_3;
    }

    @Override
    public String toString() {
        return "ECO{" + "ECO_1=" + ECO_1 + ", ECO_2=" + ECO_2 + ", ECO_3=" + ECO_3 + '}';
    }
    
    
    
}
