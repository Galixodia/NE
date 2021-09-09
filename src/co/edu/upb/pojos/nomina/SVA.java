package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class SVA {
    
    @XmlElement(name = "SVA_1")
    private Double SVA_1;
    @XmlElement(name = "SVA_2")
    private Double SVA_2;
    @XmlElement(name = "SVA_3")
    private Double SVA_3;
    @XmlElement(name = "SVA_4")
    private Double SVA_4;
    @XmlElement(name = "SVA_5")
    private Double SVA_5;
    @XmlElement(name = "SVA_6")
    private Double SVA_6;
    @XmlElement(name = "SVA_7")
    private Double SVA_7;
    @XmlElement(name = "SVA_8")
    private Double SVA_8;
    @XmlElement(name = "SVA_9")
    private Double SVA_9;

    public SVA() {
    }

    public SVA(Double SVA_1, Double SVA_2, Double SVA_3, Double SVA_4, Double SVA_5, Double SVA_6, Double SVA_7, Double SVA_8, Double SVA_9) {
        this.SVA_1 = SVA_1;
        this.SVA_2 = SVA_2;
        this.SVA_3 = SVA_3;
        this.SVA_4 = SVA_4;
        this.SVA_5 = SVA_5;
        this.SVA_6 = SVA_6;
        this.SVA_7 = SVA_7;
        this.SVA_8 = SVA_8;
        this.SVA_9 = SVA_9;
    }
    @XmlTransient
    public Double getSVA_1() {
        return SVA_1;
    }

    public void setSVA_1(Double SVA_1) {
        this.SVA_1 = SVA_1;
    }
    @XmlTransient
    public Double getSVA_2() {
        return SVA_2;
    }

    public void setSVA_2(Double SVA_2) {
        this.SVA_2 = SVA_2;
    }
    @XmlTransient
    public Double getSVA_3() {
        return SVA_3;
    }

    public void setSVA_3(Double SVA_3) {
        this.SVA_3 = SVA_3;
    }
    @XmlTransient
    public Double getSVA_4() {
        return SVA_4;
    }

    public void setSVA_4(Double SVA_4) {
        this.SVA_4 = SVA_4;
    }
    @XmlTransient
    public Double getSVA_5() {
        return SVA_5;
    }

    public void setSVA_5(Double SVA_5) {
        this.SVA_5 = SVA_5;
    }
    @XmlTransient
    public Double getSVA_6() {
        return SVA_6;
    }

    public void setSVA_6(Double SVA_6) {
        this.SVA_6 = SVA_6;
    }
    @XmlTransient
    public Double getSVA_7() {
        return SVA_7;
    }

    public void setSVA_7(Double SVA_7) {
        this.SVA_7 = SVA_7;
    }
    @XmlTransient
    public Double getSVA_8() {
        return SVA_8;
    }

    public void setSVA_8(Double SVA_8) {
        this.SVA_8 = SVA_8;
    }
    @XmlTransient
    public Double getSVA_9() {
        return SVA_9;
    }

    public void setSVA_9(Double SVA_9) {
        this.SVA_9 = SVA_9;
    }

    @Override
    public String toString() {
        return "SVA{" + "SVA_1=" + SVA_1 + ", SVA_2=" + SVA_2 + ", SVA_3=" + SVA_3 + ", SVA_4=" + SVA_4 + ", SVA_5=" + SVA_5 + ", SVA_6=" + SVA_6 + ", SVA_7=" + SVA_7 + ", SVA_8=" + SVA_8 + ", SVA_9=" + SVA_9 + '}';
    }
    
    
    
    
}
