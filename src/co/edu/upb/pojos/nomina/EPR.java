package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class EPR {
    
    @XmlElement(name = "EPR_1")
    private long EPR_1;
    @XmlElement(name = "EPR_2")
    private Double EPR_2;
    @XmlElement(name = "EPR_3")
    private Double EPR_3;

    public EPR() {
    }

    public EPR(long EPR_1, Double EPR_2) {
        this.EPR_1 = EPR_1;
        this.EPR_2 = EPR_2;
    }
    @XmlTransient
    public long getEPR_1() {
        return EPR_1;
    }

    public void setEPR_1(long EPR_1) {
        this.EPR_1 = EPR_1;
    }
    @XmlTransient
    public Double getEPR_2() {
        return EPR_2;
    }

    public void setEPR_2(Double EPR_2) {
        this.EPR_2 = EPR_2;
    }
    @XmlTransient
    public Double getEPR_3() {
        return EPR_3;
    }

    public void setEPR_3(Double EPR_3) {
        this.EPR_3 = EPR_3;
    }

    @Override
    public String toString() {
        return "EPR{" + "EPR_1=" + EPR_1 + ", EPR_2=" + EPR_2 + ", EPR_3=" + EPR_3 + '}';
    }
    
    
    
}
