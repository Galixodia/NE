package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class EVC {
    
    @XmlElement(name = "EVC_1")
    private String EVC_1;
    @XmlElement(name = "EVC_2")
    private String EVC_2;
    @XmlElement(name = "EVC_3")
    private String EVC_3;
    @XmlElement(name = "EVC_4")
    private long EVC_4;
    @XmlElement(name = "EVC_5")
    private Double EVC_5;

    public EVC() {
    }

    public EVC(String EVC_1, String EVC_2, String EVC_3, long EVC_4, Double EVC_5) {
        this.EVC_1 = EVC_1;
        this.EVC_2 = EVC_2;
        this.EVC_3 = EVC_3;
        this.EVC_4 = EVC_4;
        this.EVC_5 = EVC_5;
    }
    @XmlTransient
    public String getEVC_1() {
        return EVC_1;
    }

    public void setEVC_1(String EVC_1) {
        this.EVC_1 = EVC_1;
    }
    @XmlTransient
    public String getEVC_2() {
        return EVC_2;
    }

    public void setEVC_2(String EVC_2) {
        this.EVC_2 = EVC_2;
    }
    @XmlTransient
    public String getEVC_3() {
        return EVC_3;
    }

    public void setEVC_3(String EVC_3) {
        this.EVC_3 = EVC_3;
    }
    @XmlTransient
    public long getEVC_4() {
        return EVC_4;
    }

    public void setEVC_4(long EVC_4) {
        this.EVC_4 = EVC_4;
    }
    @XmlTransient
    public Double getEVC_5() {
        return EVC_5;
    }

    public void setEVC_5(Double EVC_5) {
        this.EVC_5 = EVC_5;
    }

    @Override
    public String toString() {
        return "EVC{" + "EVC_1=" + EVC_1 + ", EVC_2=" + EVC_2 + ", EVC_3=" + EVC_3 + ", EVC_4=" + EVC_4 + ", EVC_5=" + EVC_5 + '}';
    }
    
}
