package co.edu.upb.nominae.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "ECE")
@XmlType (propOrder={"HZRNECE_PAGO",
    "HZRNECE_PORCENTAJE",
    "HZRNECE_PAGO_INTERESES"})

public class ECE {
    
    @XmlElement(name = "ECE_1")
    private Double HZRNECE_PAGO;
    @XmlElement(name = "ECE_2")
    private Double HZRNECE_PORCENTAJE;
    @XmlElement(name = "ECE_3")
    private Double HZRNECE_PAGO_INTERESES;   
    private Integer HZRNECE_ITE_ID;    

    @XmlTransient
    public Double getHZRNECE_PAGO() {
        return HZRNECE_PAGO;
    }

    public void setHZRNECE_PAGO(Double HZRNECE_PAGO) {
        this.HZRNECE_PAGO = HZRNECE_PAGO;
    }
    @XmlTransient
    public Double getHZRNECE_PORCENTAJE() {
        return HZRNECE_PORCENTAJE;
    }

    public void setHZRNECE_PORCENTAJE(Double HZRNECE_PORCENTAJE) {
        this.HZRNECE_PORCENTAJE = HZRNECE_PORCENTAJE;
    }
    @XmlTransient
    public Double getHZRNECE_PAGO_INTERESES() {
        return HZRNECE_PAGO_INTERESES;
    }

    public void setHZRNECE_PAGO_INTERESES(Double HZRNECE_PAGO_INTERESES) {
        this.HZRNECE_PAGO_INTERESES = HZRNECE_PAGO_INTERESES;
    }
    @XmlTransient
    public Integer getHZRNECE_ITE_ID() {
        return HZRNECE_ITE_ID;
    }

    public void setHZRNECE_ITE_ID(Integer HZRNECE_ITE_ID) {
        this.HZRNECE_ITE_ID = HZRNECE_ITE_ID;
    }

    @Override
    public String toString() {
        return "ECE{" + "HZRNECE_PAGO=" + HZRNECE_PAGO + ", HZRNECE_PORCENTAJE=" + HZRNECE_PORCENTAJE + ", HZRNECE_PAGO_INTERESES=" + HZRNECE_PAGO_INTERESES + ", HZRNECE_ITE_ID=" + HZRNECE_ITE_ID + '}';
    }

    
}
