package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 000329745
 */
class NOT {
    
    @XmlElement(name="NOT_1")
    private String NOT_1;

    public NOT() {
    }

    public NOT(String NOT_1) {
        this.NOT_1 = NOT_1;
    }
    @XmlTransient
    public String getNOT_1() {
        return NOT_1;
    }
    
    public void setNOT_1(String NOT_1) {
        this.NOT_1 = NOT_1;
    }

    @Override
    public String toString() {
        return "NOT{" + "NOT_1=" + NOT_1 + '}';
    }
    
    
}
