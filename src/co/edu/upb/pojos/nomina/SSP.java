package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class SSP {
    
    @XmlElement(name = "SSP_1")
    private Double SSP_1;
    @XmlElement(name = "SSP_2")
    private Double SSP_2;
    @XmlElement(name = "SSP_3")
    private Double SSP_3;
    @XmlElement(name = "SSP_4")
    private Double SSP_4;
    @XmlElement(name = "SSP_5")
    private Double SSP_5;

    public SSP() {
    }

    public SSP(Double SSP_1, Double SSP_2, Double SSP_3, Double SSP_4, Double SSP_5) {
        this.SSP_1 = SSP_1;
        this.SSP_2 = SSP_2;
        this.SSP_3 = SSP_3;
        this.SSP_4 = SSP_4;
        this.SSP_5 = SSP_5;
    }
    @XmlTransient
    public Double getSSP_1() {
        return SSP_1;
    }

    public void setSSP_1(Double SSP_1) {
        this.SSP_1 = SSP_1;
    }
    @XmlTransient
    public Double getSSP_2() {
        return SSP_2;
    }

    public void setSSP_2(Double SSP_2) {
        this.SSP_2 = SSP_2;
    }
    @XmlTransient
    public Double getSSP_3() {
        return SSP_3;
    }

    public void setSSP_3(Double SSP_3) {
        this.SSP_3 = SSP_3;
    }
    @XmlTransient
    public Double getSSP_4() {
        return SSP_4;
    }

    public void setSSP_4(Double SSP_4) {
        this.SSP_4 = SSP_4;
    }
    @XmlTransient
    public Double getSSP_5() {
        return SSP_5;
    }

    public void setSSP_5(Double SSP_5) {
        this.SSP_5 = SSP_5;
    }

    @Override
    public String toString() {
        return "SSP{" + "SSP_1=" + SSP_1 + ", SSP_2=" + SSP_2 + ", SSP_3=" + SSP_3 + ", SSP_4=" + SSP_4 + ", SSP_5=" + SSP_5 + '}';
    }
    
    
    
    
}
