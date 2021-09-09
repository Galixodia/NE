package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class ETR {
    
    @XmlElement(name = "ETR_1")
    private Double ETR_1;
    @XmlElement(name = "ETR_2")
    private Double ETR_2;
    @XmlElement(name = "ETR_3")
    private Double ETR_3;

    public ETR() {
    }

    public ETR(Double ETR_1, Double ETR_2, Double ETR_3) {
        this.ETR_1 = ETR_1;
        this.ETR_2 = ETR_2;
        this.ETR_3 = ETR_3;
    }
    @XmlTransient
    public Double getETR_1() {
        return ETR_1;
    }

    public void setETR_1(Double ETR_1) {
        this.ETR_1 = ETR_1;
    }
    @XmlTransient
    public Double getETR_2() {
        return ETR_2;
    }

    public void setETR_2(Double ETR_2) {
        this.ETR_2 = ETR_2;
    }
    @XmlTransient
    public Double getETR_3() {
        return ETR_3;
    }

    public void setETR_3(Double ETR_3) {
        this.ETR_3 = ETR_3;
    }

    @Override
    public String toString() {
        return "ETR{" + "ETR_1=" + ETR_1 + ", ETR_2=" + ETR_2 + ", ETR_3=" + ETR_3 + '}';
    }
    
}
