package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


public class EVO {
    
    @XmlElement(name = "EVO_1")
    private Double EVO_1;
    @XmlElement(name = "EVO_2")
    private Double EVO_2;
    @XmlElement(name = "EVO_3")
    private Double EVO_3;
    @XmlElement(name = "EVO_4")
    private Double EVO_4;
    @XmlElement(name = "EVO_5")
    private Double EVO_5;
    @XmlElement(name = "EVO_6")
    private Double EVO_6;

    public EVO() {
    }

    public EVO(Double EVO_1, Double EVO_2, Double EVO_3, Double EVO_4, Double EVO_5, Double EVO_6) {
        this.EVO_1 = EVO_1;
        this.EVO_2 = EVO_2;
        this.EVO_3 = EVO_3;
        this.EVO_4 = EVO_4;
        this.EVO_5 = EVO_5;
        this.EVO_6 = EVO_6;
    }
    @XmlTransient
    public Double getEVO_1() {
        return EVO_1;
    }

    public void setEVO_1(Double EVO_1) {
        this.EVO_1 = EVO_1;
    }
    @XmlTransient
    public Double getEVO_2() {
        return EVO_2;
    }

    public void setEVO_2(Double EVO_2) {
        this.EVO_2 = EVO_2;
    }
    @XmlTransient
    public Double getEVO_3() {
        return EVO_3;
    }

    public void setEVO_3(Double EVO_3) {
        this.EVO_3 = EVO_3;
    }
    @XmlTransient
    public Double getEVO_4() {
        return EVO_4;
    }

    public void setEVO_4(Double EVO_4) {
        this.EVO_4 = EVO_4;
    }
    @XmlTransient
    public Double getEVO_5() {
        return EVO_5;
    }

    public void setEVO_5(Double EVO_5) {
        this.EVO_5 = EVO_5;
    }
    @XmlTransient
    public Double getEVO_6() {
        return EVO_6;
    }

    public void setEVO_6(Double EVO_6) {
        this.EVO_6 = EVO_6;
    }

    @Override
    public String toString() {
        return "EVO{" + "EVO_1=" + EVO_1 + ", EVO_2=" + EVO_2 + ", EVO_3=" + EVO_3 + ", EVO_4=" + EVO_4 + ", EVO_5=" + EVO_5 + ", EVO_6=" + EVO_6 + '}';
    }
    
}
