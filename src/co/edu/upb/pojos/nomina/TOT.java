package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "TOT")
@XmlType (propOrder={"HZRNTOT_REDONDEO",
    "HZRNTOT_DEVENGADOS_TOTAL",
    "HZRNTOT_DEDUCCIONES_TOTAL",
    "HZRNTOT_COMPROBANTE_TOTAL"})

public class TOT {
    
    private String HZRNTOT_CUNE_INTERNO;      
    @XmlElement(name = "TOT_1")
    private Double HZRNTOT_REDONDEO;
    @XmlElement(name = "TOT_2")
    private Double HZRNTOT_DEVENGADOS_TOTAL;
    @XmlElement(name = "TOT_3")
    private Double HZRNTOT_DEDUCCIONES_TOTAL;
    @XmlElement(name = "TOT_4")
    private Double HZRNTOT_COMPROBANTE_TOTAL;

    @XmlTransient
    public String getHZRNTOT_CUNE_INTERNO() {
        return HZRNTOT_CUNE_INTERNO;
    }

    public void setHZRNTOT_CUNE_INTERNO(String HZRNTOT_CUNE_INTERNO) {
        this.HZRNTOT_CUNE_INTERNO = HZRNTOT_CUNE_INTERNO;
    }
    @XmlTransient
    public Double getHZRNTOT_REDONDEO() {
        return HZRNTOT_REDONDEO;
    }

    public void setHZRNTOT_REDONDEO(Double HZRNTOT_REDONDEO) {
        this.HZRNTOT_REDONDEO = HZRNTOT_REDONDEO;
    }
    @XmlTransient
    public Double getHZRNTOT_DEVENGADOS_TOTAL() {
        return HZRNTOT_DEVENGADOS_TOTAL;
    }

    public void setHZRNTOT_DEVENGADOS_TOTAL(Double HZRNTOT_DEVENGADOS_TOTAL) {
        this.HZRNTOT_DEVENGADOS_TOTAL = HZRNTOT_DEVENGADOS_TOTAL;
    }
    @XmlTransient
    public Double getHZRNTOT_DEDUCCIONES_TOTAL() {
        return HZRNTOT_DEDUCCIONES_TOTAL;
    }

    public void setHZRNTOT_DEDUCCIONES_TOTAL(Double HZRNTOT_DEDUCCIONES_TOTAL) {
        this.HZRNTOT_DEDUCCIONES_TOTAL = HZRNTOT_DEDUCCIONES_TOTAL;
    }
    @XmlTransient
    public Double getHZRNTOT_COMPROBANTE_TOTAL() {
        return HZRNTOT_COMPROBANTE_TOTAL;
    }

    public void setHZRNTOT_COMPROBANTE_TOTAL(Double HZRNTOT_COMPROBANTE_TOTAL) {
        this.HZRNTOT_COMPROBANTE_TOTAL = HZRNTOT_COMPROBANTE_TOTAL;
    }

    @Override
    public String toString() {
        return "TOT{" + "HZRNTOT_CUNE_INTERNO=" + HZRNTOT_CUNE_INTERNO + ", HZRNTOT_REDONDEO=" + HZRNTOT_REDONDEO + ", HZRNTOT_DEVENGADOS_TOTAL=" + HZRNTOT_DEVENGADOS_TOTAL + ", HZRNTOT_DEDUCCIONES_TOTAL=" + HZRNTOT_DEDUCCIONES_TOTAL + ", HZRNTOT_COMPROBANTE_TOTAL=" + HZRNTOT_COMPROBANTE_TOTAL + '}';
    }

    
}
