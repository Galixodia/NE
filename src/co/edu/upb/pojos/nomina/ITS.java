package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class ITS {
    
    @XmlElement(name = "ITS_1")
    private Double ITS_1;
    @XmlElement(name = "ITS_2")
    private Double ITS_2;

    public ITS() {
    }

    public ITS(Double ITS_1, Double ITS_2) {
        this.ITS_1 = ITS_1;
        this.ITS_2 = ITS_2;
    }
    @XmlTransient
    public Double getITS_1() {
        return ITS_1;
    }

    public void setITS_1(Double ITS_1) {
        this.ITS_1 = ITS_1;
    }
    @XmlTransient
    public Double getITS_2() {
        return ITS_2;
    }

    public void setITS_2(Double ITS_2) {
        this.ITS_2 = ITS_2;
    }

    @Override
    public String toString() {
        return "ITS{" + "ITS_1=" + ITS_1 + ", ITS_2=" + ITS_2 + '}';
    }
    
}
