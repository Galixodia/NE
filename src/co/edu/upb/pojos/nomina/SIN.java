package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "SIN")
@XmlType (propOrder={"HZRNSIN_PORCENTAJE",
    "HZRNSIN_DEDUCCION"})


public class SIN {
    
    @XmlElement(name = "SIN_1")
    private Double HZRNSIN_PORCENTAJE;
    @XmlElement(name = "SIN_2")
    private Double HZRNSIN_DEDUCCION;
    private Integer HZRNSIN_ITS_ID;       

    @XmlTransient
    public Double getHZRNSIN_PORCENTAJE() {
        return HZRNSIN_PORCENTAJE;
    }

    public void setHZRNSIN_PORCENTAJE(Double HZRNSIN_PORCENTAJE) {
        this.HZRNSIN_PORCENTAJE = HZRNSIN_PORCENTAJE;
    }
    @XmlTransient
    public Double getHZRNSIN_DEDUCCION() {
        return HZRNSIN_DEDUCCION;
    }

    public void setHZRNSIN_DEDUCCION(Double HZRNSIN_DEDUCCION) {
        this.HZRNSIN_DEDUCCION = HZRNSIN_DEDUCCION;
    }
    @XmlTransient
    public Integer getHZRNSIN_ITS_ID() {
        return HZRNSIN_ITS_ID;
    }

    public void setHZRNSIN_ITS_ID(Integer HZRNSIN_ITS_ID) {
        this.HZRNSIN_ITS_ID = HZRNSIN_ITS_ID;
    }

    @Override
    public String toString() {
        return "SIN{" + "HZRNSIN_PORCENTAJE=" + HZRNSIN_PORCENTAJE + ", HZRNSIN_DEDUCCION=" + HZRNSIN_DEDUCCION + ", HZRNSIN_ITS_ID=" + HZRNSIN_ITS_ID + '}';
    }
    
}
