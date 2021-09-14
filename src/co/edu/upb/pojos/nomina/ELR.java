package co.edu.upb.pojos.nomina;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "ELR")
@XmlType (propOrder={"HZRNELR_FECHA_INICIO",
    "HZRNELR_FECHA_FIN",
    "HZRNELR_CANTIDAD",
    "HZRNELR_PAGO"})

public class ELR {
    
    @XmlElement(name = "ELR_1")
    private Date HZRNELR_FECHA_INICIO;
    @XmlElement(name = "ELR_2")
    private Date HZRNELR_FECHA_FIN;
    @XmlElement(name = "ELR_3")
    private Long HZRNELR_CANTIDAD;
    @XmlElement(name = "ELR_4")
    private Double HZRNELR_PAGO;
    private Integer HZRNELR_ITE_ID;   

    @XmlTransient
    public Date getHZRNELR_FECHA_INICIO() {
        return HZRNELR_FECHA_INICIO;
    }

    public void setHZRNELR_FECHA_INICIO(Date HZRNELR_FECHA_INICIO) {
        this.HZRNELR_FECHA_INICIO = HZRNELR_FECHA_INICIO;
    }
    @XmlTransient
    public Date getHZRNELR_FECHA_FIN() {
        return HZRNELR_FECHA_FIN;
    }

    public void setHZRNELR_FECHA_FIN(Date HZRNELR_FECHA_FIN) {
        this.HZRNELR_FECHA_FIN = HZRNELR_FECHA_FIN;
    }
    @XmlTransient
    public Long getHZRNELR_CANTIDAD() {
        return HZRNELR_CANTIDAD;
    }

    public void setHZRNELR_CANTIDAD(Long HZRNELR_CANTIDAD) {
        this.HZRNELR_CANTIDAD = HZRNELR_CANTIDAD;
    }
    @XmlTransient
    public Double getHZRNELR_PAGO() {
        return HZRNELR_PAGO;
    }

    public void setHZRNELR_PAGO(Double HZRNELR_PAGO) {
        this.HZRNELR_PAGO = HZRNELR_PAGO;
    }
    @XmlTransient
    public Integer getHZRNELR_ITE_ID() {
        return HZRNELR_ITE_ID;
    }

    public void setHZRNELR_ITE_ID(Integer HZRNELR_ITE_ID) {
        this.HZRNELR_ITE_ID = HZRNELR_ITE_ID;
    }

    @Override
    public String toString() {
        return "ELR{" + "HZRNELR_FECHA_INICIO=" + HZRNELR_FECHA_INICIO + ", HZRNELR_FECHA_FIN=" + HZRNELR_FECHA_FIN + ", HZRNELR_CANTIDAD=" + HZRNELR_CANTIDAD + ", HZRNELR_PAGO=" + HZRNELR_PAGO + ", HZRNELR_ITE_ID=" + HZRNELR_ITE_ID + '}';
    }
    
}
