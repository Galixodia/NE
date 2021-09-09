package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class ITE {
    
    @XmlElement(name = "ITE_1")
    private String ITE_1;
    @XmlElement(name = "ITE_2")
    private Double ITE_2;    

    public ITE() {
    }

    public ITE(String ITE_1, Double ITE_2) {
        this.ITE_1 = ITE_1;
        this.ITE_2 = ITE_2;
    }

    public String getITE_1() {
        return ITE_1;
    }

    public void setITE_1(String ITE_1) {
        this.ITE_1 = ITE_1;
    }
    @XmlTransient
    public Double getITE_2() {
        return ITE_2;
    }

    public void setITE_2(Double ITE_2) {
        this.ITE_2 = ITE_2;
    }

    @Override
    public String toString() {
        return "ITE{" + "ITE_1=" + ITE_1 + ", ITE_2=" + ITE_2 + '}';
    }
   
}
