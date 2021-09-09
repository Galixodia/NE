package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class PAG {
    
    @XmlElement(name = "PAG_1")
    private int PAG_1;
    @XmlElement(name = "PAG_2")
    private String PAG_2;
    @XmlElement(name = "PAG_3")
    private String PAG_3;
    @XmlElement(name = "PAG_4")
    private String PAG_4;
    @XmlElement(name = "PAG_5")
    private String PAG_5;

    public PAG() {
    }

    public PAG(int PAG_1, String PAG_2, String PAG_3, String PAG_4, String PAG_5) {
        this.PAG_1 = PAG_1;
        this.PAG_2 = PAG_2;
        this.PAG_3 = PAG_3;
        this.PAG_4 = PAG_4;
        this.PAG_5 = PAG_5;
    }
    @XmlTransient
    public int getPAG_1() {
        return PAG_1;
    }

    public void setPAG_1(int PAG_1) {
        this.PAG_1 = PAG_1;
    }
    @XmlTransient
    public String getPAG_2() {
        return PAG_2;
    }

    public void setPAG_2(String PAG_2) {
        this.PAG_2 = PAG_2;
    }
    @XmlTransient
    public String getPAG_3() {
        return PAG_3;
    }

    public void setPAG_3(String PAG_3) {
        this.PAG_3 = PAG_3;
    }
    @XmlTransient
    public String getPAG_4() {
        return PAG_4;
    }

    public void setPAG_4(String PAG_4) {
        this.PAG_4 = PAG_4;
    }
    @XmlTransient
    public String getPAG_5() {
        return PAG_5;
    }

    public void setPAG_5(String PAG_5) {
        this.PAG_5 = PAG_5;
    }

    @Override
    public String toString() {
        return "PAG{" + "PAG_1=" + PAG_1 + ", PAG_2=" + PAG_2 + ", PAG_3=" + PAG_3 + ", PAG_4=" + PAG_4 + ", PAG_5=" + PAG_5 + '}';
    }
    
    
}
