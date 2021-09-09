package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * NE
 * @author 000329745
 */
class EMI {
    
    @XmlElement(name = "EMI_1")
    private String EMI_1; 
    @XmlElement(name = "EMI_2")
    private String EMI_2; 
    @XmlElement(name = "EMI_3")
    private String EMI_3; 
    @XmlElement(name = "EMI_4")
    private String EMI_4; 
    @XmlElement(name = "EMI_5")
    private String EMI_5; 
    @XmlElement(name = "EMI_6")
    private long EMI_6; 
    @XmlElement(name = "EMI_7")
    private int EMI_7; 
    @XmlElement(name = "EMI_8")
    private String EMI_8; 
    @XmlElement(name = "EMI_9")
    private int EMI_9; 
    @XmlElement(name = "EMI_10")
    private int EMI_10; 
    @XmlElement(name = "EMI_11")
    private String EMI_11; 

    public EMI() {
    }

    public EMI(String EMI_1, String EMI_2, String EMI_3, String EMI_4, String EMI_5, long EMI_6, int EMI_7, String EMI_8, int EMI_9, int EMI_10, String EMI_11) {
        this.EMI_1 = EMI_1;
        this.EMI_2 = EMI_2;
        this.EMI_3 = EMI_3;
        this.EMI_4 = EMI_4;
        this.EMI_5 = EMI_5;
        this.EMI_6 = EMI_6;
        this.EMI_7 = EMI_7;
        this.EMI_8 = EMI_8;
        this.EMI_9 = EMI_9;
        this.EMI_10 = EMI_10;
        this.EMI_11 = EMI_11;
    }
    @XmlTransient
    public String getEMI_1() {
        return EMI_1;
    }

    public void setEMI_1(String EMI_1) {
        this.EMI_1 = EMI_1;
    }
    @XmlTransient
    public String getEMI_2() {
        return EMI_2;
    }

    public void setEMI_2(String EMI_2) {
        this.EMI_2 = EMI_2;
    }
    @XmlTransient
    public String getEMI_3() {
        return EMI_3;
    }

    public void setEMI_3(String EMI_3) {
        this.EMI_3 = EMI_3;
    }
    @XmlTransient
    public String getEMI_4() {
        return EMI_4;
    }

    public void setEMI_4(String EMI_4) {
        this.EMI_4 = EMI_4;
    }
    @XmlTransient
    public String getEMI_5() {
        return EMI_5;
    }

    public void setEMI_5(String EMI_5) {
        this.EMI_5 = EMI_5;
    }
    @XmlTransient
    public long getEMI_6() {
        return EMI_6;
    }

    public void setEMI_6(long EMI_6) {
        this.EMI_6 = EMI_6;
    }
    @XmlTransient
    public int getEMI_7() {
        return EMI_7;
    }

    public void setEMI_7(int EMI_7) {
        this.EMI_7 = EMI_7;
    }
    @XmlTransient
    public String getEMI_8() {
        return EMI_8;
    }

    public void setEMI_8(String EMI_8) {
        this.EMI_8 = EMI_8;
    }
    @XmlTransient
    public int getEMI_9() {
        return EMI_9;
    }

    public void setEMI_9(int EMI_9) {
        this.EMI_9 = EMI_9;
    }
    @XmlTransient
    public int getEMI_10() {
        return EMI_10;
    }

    public void setEMI_10(int EMI_10) {
        this.EMI_10 = EMI_10;
    }
    @XmlTransient
    public String getEMI_11() {
        return EMI_11;
    }

    public void setEMI_11(String EMI_11) {
        this.EMI_11 = EMI_11;
    }

    @Override
    public String toString() {
        return "EMI{" + "EMI_1=" + EMI_1 + ", EMI_2=" + EMI_2 + ", EMI_3=" + EMI_3 + ", EMI_4=" + EMI_4 + ", EMI_5=" + EMI_5 + ", EMI_6=" + EMI_6 + ", EMI_7=" + EMI_7 + ", EMI_8=" + EMI_8 + ", EMI_9=" + EMI_9 + ", EMI_10=" + EMI_10 + ", EMI_11=" + EMI_11 + '}';
    }

    
    
}
