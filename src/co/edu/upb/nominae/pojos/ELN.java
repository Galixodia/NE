package co.edu.upb.nominae.pojos;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "ELN")
@XmlType (propOrder={"HZRNELN_FECHA_INICIO",
    "HZRNELN_FECHA_FIN",
    "HZRNELN_CANTIDAD"})

public class ELN {
    
    @XmlElement(name = "ELN_1")
    private Date HZRNELN_FECHA_INICIO;
    @XmlElement(name = "ELN_2")
    private Date HZRNELN_FECHA_FIN;
    @XmlElement(name = "ELN_3")
    private Long HZRNELN_CANTIDAD;
    private Integer HZRNELN_ITE_ID;       

    @XmlTransient
    public Date getHZRNELN_FECHA_INICIO() {
        return HZRNELN_FECHA_INICIO;
    }

    public void setHZRNELN_FECHA_INICIO(Date HZRNELN_FECHA_INICIO) {
        this.HZRNELN_FECHA_INICIO = HZRNELN_FECHA_INICIO;
    }
    @XmlTransient
    public Date getHZRNELN_FECHA_FIN() {
        return HZRNELN_FECHA_FIN;
    }

    public void setHZRNELN_FECHA_FIN(Date HZRNELN_FECHA_FIN) {
        this.HZRNELN_FECHA_FIN = HZRNELN_FECHA_FIN;
    }
    @XmlTransient
    public Long getHZRNELN_CANTIDAD() {
        return HZRNELN_CANTIDAD;
    }

    public void setHZRNELN_CANTIDAD(Long HZRNELN_CANTIDAD) {
        this.HZRNELN_CANTIDAD = HZRNELN_CANTIDAD;
    }
    @XmlTransient
    public Integer getHZRNELN_ITE_ID() {
        return HZRNELN_ITE_ID;
    }

    public void setHZRNELN_ITE_ID(Integer HZRNELN_ITE_ID) {
        this.HZRNELN_ITE_ID = HZRNELN_ITE_ID;
    }

    @Override
    public String toString() {
        return "ELN{" + "HZRNELN_FECHA_INICIO=" + HZRNELN_FECHA_INICIO + ", HZRNELN_FECHA_FIN=" + HZRNELN_FECHA_FIN + ", HZRNELN_CANTIDAD=" + HZRNELN_CANTIDAD + ", HZRNELN_ITE_ID=" + HZRNELN_ITE_ID + '}';
    }
    
}
