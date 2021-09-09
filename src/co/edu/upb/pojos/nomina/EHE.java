package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class EHE {
    
    @XmlElement(name = "EHE_1")
    private String EHE_1;
    @XmlElement(name = "EHE_2")
    private String EHE_2;
    @XmlElement(name = "EHE_3")
    private String EHE_3;
    @XmlElement(name = "EHE_4")
    private Double EHE_4;
    @XmlElement(name = "EHE_5")
    private Double EHE_5;
    @XmlElement(name = "EHE_6")
    private Double EHE_6;

    public EHE() {
    }

    public EHE(String EHE_1, String EHE_2, String EHE_3, Double EHE_4, Double EHE_5, Double EHE_6) {
        this.EHE_1 = EHE_1;
        this.EHE_2 = EHE_2;
        this.EHE_3 = EHE_3;
        this.EHE_4 = EHE_4;
        this.EHE_5 = EHE_5;
        this.EHE_6 = EHE_6;
    }
    @XmlTransient
    public String getEHE_1() {
        return EHE_1;
    }

    public void setEHE_1(String EHE_1) {
        this.EHE_1 = EHE_1;
    }
    @XmlTransient
    public String getEHE_2() {
        return EHE_2;
    }

    public void setEHE_2(String EHE_2) {
        this.EHE_2 = EHE_2;
    }
    @XmlTransient
    public String getEHE_3() {
        return EHE_3;
    }

    public void setEHE_3(String EHE_3) {
        this.EHE_3 = EHE_3;
    }
    @XmlTransient
    public Double getEHE_4() {
        return EHE_4;
    }

    public void setEHE_4(Double EHE_4) {
        this.EHE_4 = EHE_4;
    }
    @XmlTransient
    public Double getEHE_5() {
        return EHE_5;
    }

    public void setEHE_5(Double EHE_5) {
        this.EHE_5 = EHE_5;
    }
    @XmlTransient
    public Double getEHE_6() {
        return EHE_6;
    }

    public void setEHE_6(Double EHE_6) {
        this.EHE_6 = EHE_6;
    }

    @Override
    public String toString() {
        return "EHE{" + "EHE_1=" + EHE_1 + ", EHE_2=" + EHE_2 + ", EHE_3=" + EHE_3 + ", EHE_4=" + EHE_4 + ", EHE_5=" + EHE_5 + ", EHE_6=" + EHE_6 + '}';
    }
    
}
