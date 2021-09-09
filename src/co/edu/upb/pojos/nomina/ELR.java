package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class ELR {
    
    @XmlElement(name = "ELR_1")
    private String ELR_1;
    @XmlElement(name = "ELR_2")
    private String ELR_2;
    @XmlElement(name = "ELR_3")
    private long ELR_3;
    @XmlElement(name = "ELR_4")
    private Double ELR_4;

    public ELR() {
    }

    public ELR(String ELR_1, String ELR_2, long ELR_3, Double ELR_4) {
        this.ELR_1 = ELR_1;
        this.ELR_2 = ELR_2;
        this.ELR_3 = ELR_3;
        this.ELR_4 = ELR_4;
    }
    @XmlTransient
    public String getELR_1() {
        return ELR_1;
    }

    public void setELR_1(String ELR_1) {
        this.ELR_1 = ELR_1;
    }
    @XmlTransient
    public String getELR_2() {
        return ELR_2;
    }

    public void setELR_2(String ELR_2) {
        this.ELR_2 = ELR_2;
    }
    @XmlTransient
    public long getELR_3() {
        return ELR_3;
    }

    public void setELR_3(long ELR_3) {
        this.ELR_3 = ELR_3;
    }
    @XmlTransient
    public Double getELR_4() {
        return ELR_4;
    }

    public void setELR_4(Double ELR_4) {
        this.ELR_4 = ELR_4;
    }

    @Override
    public String toString() {
        return "ELR{" + "ELR_1=" + ELR_1 + ", ELR_2=" + ELR_2 + ", ELR_3=" + ELR_3 + ", ELR_4=" + ELR_4 + '}';
    }

 
    
}
