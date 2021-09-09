package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class EOT {
    
    @XmlElement(name = "EOT_1")
    private String EOT_1;
    @XmlElement(name = "EOT_2")
    private Double EOT_2;
    @XmlElement(name = "EOT_3")
    private Double EOT_3;

    public EOT() {
    }

    public EOT(String EOT_1, Double EOT_2, Double EOT_3) {
        this.EOT_1 = EOT_1;
        this.EOT_2 = EOT_2;
        this.EOT_3 = EOT_3;
    }
    @XmlTransient
    public String getEOT_1() {
        return EOT_1;
    }

    public void setEOT_1(String EOT_1) {
        this.EOT_1 = EOT_1;
    }
    @XmlTransient
    public Double getEOT_2() {
        return EOT_2;
    }

    public void setEOT_2(Double EOT_2) {
        this.EOT_2 = EOT_2;
    }
    @XmlTransient
    public Double getEOT_3() {
        return EOT_3;
    }

    public void setEOT_3(Double EOT_3) {
        this.EOT_3 = EOT_3;
    }

    @Override
    public String toString() {
        return "EOT{" + "EOT_1=" + EOT_1 + ", EOT_2=" + EOT_2 + ", EOT_3=" + EOT_3 + '}';
    }
      
}
