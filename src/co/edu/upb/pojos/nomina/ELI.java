package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class ELI {
    
    @XmlElement(name = "ELI_1")
    private String ELI_1;
    @XmlElement(name = "ELI_2")
    private String ELI_2;
    @XmlElement(name = "ELI_3")
    private long ELI_3;
    @XmlElement(name = "ELI_4")
    private Double ELI_4;  

    public ELI() {
    }

    public ELI(String ELI_1, String ELI_2, long ELI_3, Double ELI_4) {
        this.ELI_1 = ELI_1;
        this.ELI_2 = ELI_2;
        this.ELI_3 = ELI_3;
        this.ELI_4 = ELI_4;
    }
    @XmlTransient
    public String getELI_1() {
        return ELI_1;
    }

    public void setELI_1(String ELI_1) {
        this.ELI_1 = ELI_1;
    }
    @XmlTransient
    public String getELI_2() {
        return ELI_2;
    }

    public void setELI_2(String ELI_2) {
        this.ELI_2 = ELI_2;
    }
    @XmlTransient
    public long getELI_3() {
        return ELI_3;
    }

    public void setELI_3(long ELI_3) {
        this.ELI_3 = ELI_3;
    }
    @XmlTransient
    public Double getELI_4() {
        return ELI_4;
    }

    public void setELI_4(Double ELI_4) {
        this.ELI_4 = ELI_4;
    }

    @Override
    public String toString() {
        return "ELI{" + "ELI_1=" + ELI_1 + ", ELI_2=" + ELI_2 + ", ELI_3=" + ELI_3 + ", ELI_4=" + ELI_4 + '}';
    }
    
    
    
}
