package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class ELN {
    
    @XmlElement(name = "ELN_1")
    private String ELN_1;
    @XmlElement(name = "ELN_2")
    private String ELN_2;
    @XmlElement(name = "ELN_3")
    private long ELN_3;

    public ELN() {
    }

    public ELN(String ELN_1, String ELN_2, long ELN_3) {
        this.ELN_1 = ELN_1;
        this.ELN_2 = ELN_2;
        this.ELN_3 = ELN_3;
    }
    @XmlTransient
    public String getELN_1() {
        return ELN_1;
    }

    public void setELN_1(String ELN_1) {
        this.ELN_1 = ELN_1;
    }
    @XmlTransient
    public String getELN_2() {
        return ELN_2;
    }

    public void setELN_2(String ELN_2) {
        this.ELN_2 = ELN_2;
    }
    @XmlTransient
    public long getELN_3() {
        return ELN_3;
    }

    public void setELN_3(long ELN_3) {
        this.ELN_3 = ELN_3;
    }

    @Override
    public String toString() {
        return "ELN{" + "ELN_1=" + ELN_1 + ", ELN_2=" + ELN_2 + ", ELN_3=" + ELN_3 + '}';
    }
    
    
    
}
