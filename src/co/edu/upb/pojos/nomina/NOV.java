package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class NOV {
    
    @XmlElement(name="NOV_1")
    private String      nov_1;
    @XmlElement(name="NOV_2")
    private String      nov_2;

    public NOV(String nov_1, String nov_2) {
        this.nov_1 = nov_1;
        this.nov_2 = nov_2;
    }

    
    @XmlTransient
    public String getNov_1() {
        return nov_1;
    }

    public void setNov_1(String nov_1) {
        this.nov_1 = nov_1;
    }
    @XmlTransient
    public String getNov_2() {
        return nov_2;
    }

    public void setNov_2(String nov_2) {
        this.nov_2 = nov_2;
    }

    @Override
    public String toString() {
        return "NOV{" + "nov_1=" + nov_1 + ", nov_2=" + nov_2 + '}';
    }
    
    
    
}
