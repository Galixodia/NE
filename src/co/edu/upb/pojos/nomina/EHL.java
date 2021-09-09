package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class EHL {
    
    @XmlElement(name = "EHL_1")
    private String EHL_1;
    @XmlElement(name = "EHL_2")
    private String EHL_2;
    @XmlElement(name = "EHL_3")
    private long EHL_3;

    public EHL() {
    }

    public EHL(String EHL_1, String EHL_2, long EHL_3) {
        this.EHL_1 = EHL_1;
        this.EHL_2 = EHL_2;
        this.EHL_3 = EHL_3;
    }
    @XmlTransient
    public String getEHL_1() {
        return EHL_1;
    }

    public void setEHL_1(String EHL_1) {
        this.EHL_1 = EHL_1;
    }
    @XmlTransient
    public String getEHL_2() {
        return EHL_2;
    }

    public void setEHL_2(String EHL_2) {
        this.EHL_2 = EHL_2;
    }
    @XmlTransient
    public long getEHL_3() {
        return EHL_3;
    }

    public void setEHL_3(long EHL_3) {
        this.EHL_3 = EHL_3;
    }

    @Override
    public String toString() {
        return "EHL{" + "EHL_1=" + EHL_1 + ", EHL_2=" + EHL_2 + ", EHL_3=" + EHL_3 + '}';
    }
    
}
