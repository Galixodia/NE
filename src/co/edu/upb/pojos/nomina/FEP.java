package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class FEP {
    
    @XmlElement(name = "FEP_1")
    private String FEP_1;

    public FEP() {
    }

    public FEP(String FEP_1) {
        this.FEP_1 = FEP_1;
    }
    @XmlTransient
    public String getFEP_1() {
        return FEP_1;
    }

    public void setFEP_1(String FEP_1) {
        this.FEP_1 = FEP_1;
    }

    @Override
    public String toString() {
        return "FEP{" + "FEP_1=" + FEP_1 + '}';
    }
    
    
    
}
