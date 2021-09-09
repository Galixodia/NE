package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class EIN {
    
    @XmlElement(name = "EIN_1")
    private String EIN_1;
    @XmlElement(name = "EIN_2")
    private String EIN_2;
    @XmlElement(name = "EIN_3")
    private long EIN_3;
    @XmlElement(name = "EIN_4")
    private int EIN_4;
    @XmlElement(name = "EIN_5")
    private Double EIN_5;

    public EIN() {
    }

    public EIN(String EIN_1, String EIN_2, long EIN_3, int EIN_4, Double EIN_5) {
        this.EIN_1 = EIN_1;
        this.EIN_2 = EIN_2;
        this.EIN_3 = EIN_3;
        this.EIN_4 = EIN_4;
        this.EIN_5 = EIN_5;
    }
    @XmlTransient
    public String getEIN_1() {
        return EIN_1;
    }

    public void setEIN_1(String EIN_1) {
        this.EIN_1 = EIN_1;
    }
    @XmlTransient
    public String getEIN_2() {
        return EIN_2;
    }

    public void setEIN_2(String EIN_2) {
        this.EIN_2 = EIN_2;
    }
    @XmlTransient
    public long getEIN_3() {
        return EIN_3;
    }

    public void setEIN_3(long EIN_3) {
        this.EIN_3 = EIN_3;
    }
    @XmlTransient
    public int getEIN_4() {
        return EIN_4;
    }

    public void setEIN_4(int EIN_4) {
        this.EIN_4 = EIN_4;
    }
    @XmlTransient
    public Double getEIN_5() {
        return EIN_5;
    }

    public void setEIN_5(Double EIN_5) {
        this.EIN_5 = EIN_5;
    }

    @Override
    public String toString() {
        return "EIN{" + "EIN_1=" + EIN_1 + ", EIN_2=" + EIN_2 + ", EIN_3=" + EIN_3 + ", EIN_4=" + EIN_4 + ", EIN_5=" + EIN_5 + '}';
    }
 
}
