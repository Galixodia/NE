package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class ECM {
    
    @XmlElement(name = "ECM_1")
    private Double ECM_1;
    @XmlElement(name = "ECM_2")
    private Double ECM_2;

    public ECM() {
    }

    public ECM(Double ECM_1, Double ECM_2) {
        this.ECM_1 = ECM_1;
        this.ECM_2 = ECM_2;
    }
    @XmlTransient
    public Double getECM_1() {
        return ECM_1;
    }

    public void setECM_1(Double ECM_1) {
        this.ECM_1 = ECM_1;
    }
    @XmlTransient
    public Double getECM_2() {
        return ECM_2;
    }

    public void setECM_2(Double ECM_2) {
        this.ECM_2 = ECM_2;
    }

    @Override
    public String toString() {
        return "ECM{" + "ECM_1=" + ECM_1 + ", ECM_2=" + ECM_2 + '}';
    }
    
    
    
}
