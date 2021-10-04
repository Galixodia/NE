package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNSSP_PORCENTAJE",
    "HZRNSSP_DEDUC_SEG_PENSIONAL",
    "HZRNSSP_PORCENTAJE_SUBSISTEN",
    "HZRNSSP_DEDUC_SUBSISTEN"})
public class SSP {
    
    @XmlElement(name = "SSP_1")
    private String HZRNSSP_PORCENTAJE;
    @XmlElement(name = "SSP_2")
    private String HZRNSSP_DEDUC_SEG_PENSIONAL;
    @XmlElement(name = "SSP_3")
    private String HZRNSSP_PORCENTAJE_SUBSISTEN;
    @XmlElement(name = "SSP_4")
    private String HZRNSSP_DEDUC_SUBSISTEN;
    private Integer HZRNSSP_ITS_ID;   

    @XmlTransient
    public String getHZRNSSP_PORCENTAJE() {
        return HZRNSSP_PORCENTAJE;
    }

    public void setHZRNSSP_PORCENTAJE(BigDecimal HZRNSSP_PORCENTAJE) {
        if(HZRNSSP_PORCENTAJE != null){
            this.HZRNSSP_PORCENTAJE = new DecimalFormat("0.00").format(HZRNSSP_PORCENTAJE).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNSSP_DEDUC_SEG_PENSIONAL() {
        return HZRNSSP_DEDUC_SEG_PENSIONAL;
    }

    public void setHZRNSSP_DEDUC_SEG_PENSIONAL(BigDecimal HZRNSSP_DEDUC_SEG_PENSIONAL) {
        if(HZRNSSP_DEDUC_SEG_PENSIONAL != null){
            this.HZRNSSP_DEDUC_SEG_PENSIONAL = new DecimalFormat("0.000000").format(HZRNSSP_DEDUC_SEG_PENSIONAL).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNSSP_PORCENTAJE_SUBSISTEN() {
        return HZRNSSP_PORCENTAJE_SUBSISTEN;
    }

    public void setHZRNSSP_PORCENTAJE_SUBSISTEN(BigDecimal HZRNSSP_PORCENTAJE_SUBSISTEN) {
        if(HZRNSSP_PORCENTAJE_SUBSISTEN != null){
            this.HZRNSSP_PORCENTAJE_SUBSISTEN = new DecimalFormat("0.00").format(HZRNSSP_PORCENTAJE_SUBSISTEN).replace(",",".");
        }
    }
    @XmlTransient
    public String getHZRNSSP_DEDUC_SUBSISTEN() {
        return HZRNSSP_DEDUC_SUBSISTEN;
    }

    public void setHZRNSSP_DEDUC_SUBSISTEN(BigDecimal HZRNSSP_DEDUC_SUBSISTEN) {
        if(HZRNSSP_DEDUC_SUBSISTEN != null){
            this.HZRNSSP_DEDUC_SUBSISTEN = new DecimalFormat("0.000000").format(HZRNSSP_DEDUC_SUBSISTEN).replace(",","."); 
        }
    }
    @XmlTransient
    public Integer getHZRNSSP_ITS_ID() {
        return HZRNSSP_ITS_ID;
    }

    public void setHZRNSSP_ITS_ID(Integer HZRNSSP_ITS_ID) {
        this.HZRNSSP_ITS_ID = HZRNSSP_ITS_ID;
    }

    @Override
    public String toString() {
        return "SSP{" + "HZRNSSP_PORCENTAJE=" + HZRNSSP_PORCENTAJE + ", HZRNSSP_DEDUC_SEG_PENSIONAL=" + HZRNSSP_DEDUC_SEG_PENSIONAL + ", HZRNSSP_PORCENTAJE_SUBSISTEN=" + HZRNSSP_PORCENTAJE_SUBSISTEN + ", HZRNSSP_DEDUC_SUBSISTEN=" + HZRNSSP_DEDUC_SUBSISTEN + ", HZRNSSP_ITS_ID=" + HZRNSSP_ITS_ID + '}';
    }
    
}
