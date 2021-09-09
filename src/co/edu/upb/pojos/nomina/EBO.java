package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class EBO {
    
    @XmlElement(name = "EBO_1")
    private Double EBO_1;
    @XmlElement(name = "EBO_2")
    private Double EBO_2;
    @XmlElement(name = "EBO_3")
    private Double EBO_3;
    @XmlElement(name = "EBO_4")
    private Double EBO_4;

    public EBO() {
    }

    public EBO(Double EBO_1, Double EBO_2, Double EBO_3, Double EBO_4) {
        this.EBO_1 = EBO_1;
        this.EBO_2 = EBO_2;
        this.EBO_3 = EBO_3;
        this.EBO_4 = EBO_4;
    }
    @XmlTransient
    public Double getEBO_1() {
        return EBO_1;
    }

    public void setEBO_1(Double EBO_1) {
        this.EBO_1 = EBO_1;
    }
    @XmlTransient
    public Double getEBO_2() {
        return EBO_2;
    }

    public void setEBO_2(Double EBO_2) {
        this.EBO_2 = EBO_2;
    }
    @XmlTransient
    public Double getEBO_3() {
        return EBO_3;
    }

    public void setEBO_3(Double EBO_3) {
        this.EBO_3 = EBO_3;
    }
    @XmlTransient
    public Double getEBO_4() {
        return EBO_4;
    }

    public void setEBO_4(Double EBO_4) {
        this.EBO_4 = EBO_4;
    }

    @Override
    public String toString() {
        return "EBO{" + "EBO_1=" + EBO_1 + ", EBO_2=" + EBO_2 + ", EBO_3=" + EBO_3 + ", EBO_4=" + EBO_4 + '}';
    }
               
}
