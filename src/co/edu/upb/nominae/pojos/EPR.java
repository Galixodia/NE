package co.edu.upb.nominae.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "EPR")
@XmlType (propOrder={"HZRNEPR_CANTIDAD",
    "HZRNEPR_PAGO",
    "HZRNEPR_PAGONS"})

public class EPR {
    
    @XmlElement(name = "EPR_1")
    private Integer HZRNEPR_CANTIDAD;
    @XmlElement(name = "EPR_2")
    private Double HZRNEPR_PAGO;
    @XmlElement(name = "EPR_3")
    private Double HZRNEPR_PAGONS;
    private Integer HZRNEPR_ITE_ID;

    @XmlTransient
    public Integer getHZRNEPR_CANTIDAD() {
        return HZRNEPR_CANTIDAD;
    }

    public void setHZRNEPR_CANTIDAD(Integer HZRNEPR_CANTIDAD) {
        this.HZRNEPR_CANTIDAD = HZRNEPR_CANTIDAD;
    }
    @XmlTransient
    public Double getHZRNEPR_PAGO() {
        return HZRNEPR_PAGO;
    }

    public void setHZRNEPR_PAGO(Double HZRNEPR_PAGO) {
        this.HZRNEPR_PAGO = HZRNEPR_PAGO;
    }
    @XmlTransient
    public Double getHZRNEPR_PAGONS() {
        return HZRNEPR_PAGONS;
    }

    public void setHZRNEPR_PAGONS(Double HZRNEPR_PAGONS) {
        this.HZRNEPR_PAGONS = HZRNEPR_PAGONS;
    }
    @XmlTransient
    public Integer getHZRNEPR_ITE_ID() {
        return HZRNEPR_ITE_ID;
    }

    public void setHZRNEPR_ITE_ID(Integer HZRNEPR_ITE_ID) {
        this.HZRNEPR_ITE_ID = HZRNEPR_ITE_ID;
    }

    @Override
    public String toString() {
        return "EPR{" + "HZRNEPR_CANTIDAD=" + HZRNEPR_CANTIDAD + ", HZRNEPR_PAGO=" + HZRNEPR_PAGO + ", HZRNEPR_PAGONS=" + HZRNEPR_PAGONS + ", HZRNEPR_ITE_ID=" + HZRNEPR_ITE_ID + '}';
    }

}
