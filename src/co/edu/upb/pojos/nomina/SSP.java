package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "SSP")
@XmlType (propOrder={"HZRNSSP_PORCENTAJE",
    "HZRNSSP_DEDUC_SEG_PENSIONAL",
    "HZRNSSP_PORCENTAJE_SUBSISTEN",
    "HZRNSSP_DEDUC_SUBSISTEN"})

public class SSP {
    
    @XmlElement(name = "SSP_1")
    private Double HZRNSSP_PORCENTAJE;
    @XmlElement(name = "SSP_2")
    private Double HZRNSSP_DEDUC_SEG_PENSIONAL;
    @XmlElement(name = "SSP_3")
    private Double HZRNSSP_PORCENTAJE_SUBSISTEN;
    @XmlElement(name = "SSP_4")
    private Double HZRNSSP_DEDUC_SUBSISTEN;
    private Integer HZRNSSP_ITS_ID;   

    @XmlTransient
    public Double getHZRNSSP_PORCENTAJE() {
        return HZRNSSP_PORCENTAJE;
    }

    public void setHZRNSSP_PORCENTAJE(Double HZRNSSP_PORCENTAJE) {
        this.HZRNSSP_PORCENTAJE = HZRNSSP_PORCENTAJE;
    }
    @XmlTransient
    public Double getHZRNSSP_DEDUC_SEG_PENSIONAL() {
        return HZRNSSP_DEDUC_SEG_PENSIONAL;
    }

    public void setHZRNSSP_DEDUC_SEG_PENSIONAL(Double HZRNSSP_DEDUC_SEG_PENSIONAL) {
        this.HZRNSSP_DEDUC_SEG_PENSIONAL = HZRNSSP_DEDUC_SEG_PENSIONAL;
    }
    @XmlTransient
    public Double getHZRNSSP_PORCENTAJE_SUBSISTEN() {
        return HZRNSSP_PORCENTAJE_SUBSISTEN;
    }

    public void setHZRNSSP_PORCENTAJE_SUBSISTEN(Double HZRNSSP_PORCENTAJE_SUBSISTEN) {
        this.HZRNSSP_PORCENTAJE_SUBSISTEN = HZRNSSP_PORCENTAJE_SUBSISTEN;
    }
    @XmlTransient
    public Double getHZRNSSP_DEDUC_SUBSISTEN() {
        return HZRNSSP_DEDUC_SUBSISTEN;
    }

    public void setHZRNSSP_DEDUC_SUBSISTEN(Double HZRNSSP_DEDUC_SUBSISTEN) {
        this.HZRNSSP_DEDUC_SUBSISTEN = HZRNSSP_DEDUC_SUBSISTEN;
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
