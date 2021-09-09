package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 000329745
 */
class REC {
    
    @XmlElement(name = "REC_1")
    private int REC_1;
    @XmlElement(name = "REC_2")
    private int REC_2;
    @XmlElement(name = "REC_3")
    private String REC_3;
    @XmlElement(name = "REC_4")
    private int REC_4;
    @XmlElement(name = "REC_5")
    private long REC_5;
    @XmlElement(name = "REC_6")
    private String REC_6;
    @XmlElement(name = "REC_7")
    private String REC_7;
    @XmlElement(name = "REC_8")
    private String REC_8;
    @XmlElement(name = "REC_9")
    private String REC_9;
    @XmlElement(name = "REC_10")
    private int REC_10;
    @XmlElement(name = "REC_11")
    private int REC_11;
    @XmlElement(name = "REC_12")
    private int REC_12;
    @XmlElement(name = "REC_13")
    private String REC_13;
    @XmlElement(name = "REC_14")
    private String REC_14;
    @XmlElement(name = "REC_15")
    private int REC_15;
    @XmlElement(name = "REC_16")
    private Double REC_16;
    @XmlElement(name = "REC_17")
    private String REC_17;

    public REC() {
    }

    public REC(int REC_1, int REC_2, String REC_3, int REC_4, long REC_5, String REC_6, String REC_7, String REC_8, String REC_9, int REC_10, int REC_11, int REC_12, String REC_13, String REC_14, int REC_15, Double REC_16, String REC_17) {
        this.REC_1 = REC_1;
        this.REC_2 = REC_2;
        this.REC_3 = REC_3;
        this.REC_4 = REC_4;
        this.REC_5 = REC_5;
        this.REC_6 = REC_6;
        this.REC_7 = REC_7;
        this.REC_8 = REC_8;
        this.REC_9 = REC_9;
        this.REC_10 = REC_10;
        this.REC_11 = REC_11;
        this.REC_12 = REC_12;
        this.REC_13 = REC_13;
        this.REC_14 = REC_14;
        this.REC_15 = REC_15;
        this.REC_16 = REC_16;
        this.REC_17 = REC_17;
    }

    @XmlTransient
    public int getREC_1() {
        return REC_1;
    }

    public void setREC_1(int REC_1) {
        this.REC_1 = REC_1;
    }
    @XmlTransient
    public int getREC_2() {
        return REC_2;
    }

    public void setREC_2(int REC_2) {
        this.REC_2 = REC_2;
    }
    @XmlTransient
    public String getREC_3() {
        return REC_3;
    }

    public void setREC_3(String REC_3) {
        this.REC_3 = REC_3;
    }
    @XmlTransient
    public int getREC_4() {
        return REC_4;
    }

    public void setREC_4(int REC_4) {
        this.REC_4 = REC_4;
    }
    @XmlTransient
    public long getREC_5() {
        return REC_5;
    }

    public void setREC_5(long REC_5) {
        this.REC_5 = REC_5;
    }
    @XmlTransient
    public String getREC_6() {
        return REC_6;
    }

    public void setREC_6(String REC_6) {
        this.REC_6 = REC_6;
    }
    @XmlTransient
    public String getREC_7() {
        return REC_7;
    }

    public void setREC_7(String REC_7) {
        this.REC_7 = REC_7;
    }
    @XmlTransient
    public String getREC_8() {
        return REC_8;
    }

    public void setREC_8(String REC_8) {
        this.REC_8 = REC_8;
    }
    @XmlTransient
    public String getREC_9() {
        return REC_9;
    }

    public void setREC_9(String REC_9) {
        this.REC_9 = REC_9;
    }
    @XmlTransient
    public int getREC_10() {
        return REC_10;
    }

    public void setREC_10(int REC_10) {
        this.REC_10 = REC_10;
    }
    @XmlTransient
    public int getREC_11() {
        return REC_11;
    }

    public void setREC_11(int REC_11) {
        this.REC_11 = REC_11;
    }
    @XmlTransient
    public int getREC_12() {
        return REC_12;
    }

    public void setREC_12(int REC_12) {
        this.REC_12 = REC_12;
    }
    @XmlTransient
    public String getREC_13() {
        return REC_13;
    }

    public void setREC_13(String REC_13) {
        this.REC_13 = REC_13;
    }
    @XmlTransient
    public String getREC_14() {
        return REC_14;
    }

    public void setREC_14(String REC_14) {
        this.REC_14 = REC_14;
    }
    @XmlTransient
    public int getREC_15() {
        return REC_15;
    }

    public void setREC_15(int REC_15) {
        this.REC_15 = REC_15;
    }
    @XmlTransient
    public Double getREC_16() {
        return REC_16;
    }

    public void setREC_16(Double REC_16) {
        this.REC_16 = REC_16;
    }
    @XmlTransient
    public String getREC_17() {
        return REC_17;
    }

    public void setREC_17(String REC_17) {
        this.REC_17 = REC_17;
    }

    @Override
    public String toString() {
        return "REC{" + "REC_1=" + REC_1 + ", REC_2=" + REC_2 + ", REC_3=" + REC_3 + ", REC_4=" + REC_4 + ", REC_5=" + REC_5 + ", REC_6=" + REC_6 + ", REC_7=" + REC_7 + ", REC_8=" + REC_8 + ", REC_9=" + REC_9 + ", REC_10=" + REC_10 + ", REC_11=" + REC_11 + ", REC_12=" + REC_12 + ", REC_13=" + REC_13 + ", REC_14=" + REC_14 + ", REC_15=" + REC_15 + ", REC_16=" + REC_16 + ", REC_17=" + REC_17 + '}';
    }

    
    
}
