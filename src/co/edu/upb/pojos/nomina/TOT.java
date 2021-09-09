package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


public class TOT {
    
    @XmlElement(name = "TOT_1")
    private Double TOT_1;
    @XmlElement(name = "TOT_2")
    private Double TOT_2;
    @XmlElement(name = "TOT_3")
    private Double TOT_3;
    @XmlElement(name = "TOT_4")
    private Double TOT_4;

    public TOT() {
    }

    public TOT(Double TOT_1, Double TOT_2, Double TOT_3, Double TOT_4) {
        this.TOT_1 = TOT_1;
        this.TOT_2 = TOT_2;
        this.TOT_3 = TOT_3;
        this.TOT_4 = TOT_4;
    }
    @XmlTransient
    public Double getTOT_1() {
        return TOT_1;
    }

    public void setTOT_1(Double TOT_1) {
        this.TOT_1 = TOT_1;
    }
    @XmlTransient
    public Double getTOT_2() {
        return TOT_2;
    }

    public void setTOT_2(Double TOT_2) {
        this.TOT_2 = TOT_2;
    }
    @XmlTransient
    public Double getTOT_3() {
        return TOT_3;
    }

    public void setTOT_3(Double TOT_3) {
        this.TOT_3 = TOT_3;
    }
    @XmlTransient
    public Double getTOT_4() {
        return TOT_4;
    }

    public void setTOT_4(Double TOT_4) {
        this.TOT_4 = TOT_4;
    }

    @Override
    public String toString() {
        return "TOT{" + "TOT_1=" + TOT_1 + ", TOT_2=" + TOT_2 + ", TOT_3=" + TOT_3 + ", TOT_4=" + TOT_4 + '}';
    }

    
}
