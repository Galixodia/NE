package co.edu.upb.nominae.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "ECO")
@XmlType (propOrder={"HZRNECO_COMISION",
    "HZRNECO_PAGO_TERCERO",
    "HZRNECO_ANTICIPOS_NOMINA"})

public class ECO {
    
    @XmlElement(name = "ECO_1")
    private Double HZRNECO_COMISION;
    @XmlElement(name = "ECO_2")
    private Double HZRNECO_PAGO_TERCERO;
    @XmlElement(name = "ECO_3")
    private Double HZRNECO_ANTICIPOS_NOMINA;
    private Integer HZRNECO_ITE_ID;   

    @XmlTransient
    public Double getHZRNECO_COMISION() {
        return HZRNECO_COMISION;
    }

    public void setHZRNECO_COMISION(Double HZRNECO_COMISION) {
        this.HZRNECO_COMISION = HZRNECO_COMISION;
    }
    @XmlTransient
    public Double getHZRNECO_PAGO_TERCERO() {
        return HZRNECO_PAGO_TERCERO;
    }

    public void setHZRNECO_PAGO_TERCERO(Double HZRNECO_PAGO_TERCERO) {
        this.HZRNECO_PAGO_TERCERO = HZRNECO_PAGO_TERCERO;
    }
    @XmlTransient
    public Double getHZRNECO_ANTICIPOS_NOMINA() {
        return HZRNECO_ANTICIPOS_NOMINA;
    }

    public void setHZRNECO_ANTICIPOS_NOMINA(Double HZRNECO_ANTICIPOS_NOMINA) {
        this.HZRNECO_ANTICIPOS_NOMINA = HZRNECO_ANTICIPOS_NOMINA;
    }
    @XmlTransient
    public Integer getHZRNECO_ITE_ID() {
        return HZRNECO_ITE_ID;
    }

    public void setHZRNECO_ITE_ID(Integer HZRNECO_ITE_ID) {
        this.HZRNECO_ITE_ID = HZRNECO_ITE_ID;
    }

    @Override
    public String toString() {
        return "ECO{" + "HZRNECO_COMISION=" + HZRNECO_COMISION + ", HZRNECO_PAGO_TERCERO=" + HZRNECO_PAGO_TERCERO + ", HZRNECO_ANTICIPOS_NOMINA=" + HZRNECO_ANTICIPOS_NOMINA + ", HZRNECO_ITE_ID=" + HZRNECO_ITE_ID + '}';
    }

}
