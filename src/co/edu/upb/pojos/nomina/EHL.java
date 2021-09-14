package co.edu.upb.pojos.nomina;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "EHL")
@XmlType (propOrder={"HZRNEHL_FECHA_INICIO",
    "HZRNEHL_FECHA_FIN",
    "HZRNEHL_CANTIDAD"})

public class EHL {
    
    @XmlElement(name = "EHL_1")
    private Date HZRNEHL_FECHA_INICIO;
    @XmlElement(name = "EHL_2")
    private Date HZRNEHL_FECHA_FIN;
    @XmlElement(name = "EHL_3")
    private Long HZRNEHL_CANTIDAD;
    private Integer HZRNEHL_ITE_ID;       

    @XmlTransient
    public Date getHZRNEHL_FECHA_INICIO() {
        return HZRNEHL_FECHA_INICIO;
    }

    public void setHZRNEHL_FECHA_INICIO(Date HZRNEHL_FECHA_INICIO) {
        this.HZRNEHL_FECHA_INICIO = HZRNEHL_FECHA_INICIO;
    }
    @XmlTransient
    public Date getHZRNEHL_FECHA_FIN() {
        return HZRNEHL_FECHA_FIN;
    }

    public void setHZRNEHL_FECHA_FIN(Date HZRNEHL_FECHA_FIN) {
        this.HZRNEHL_FECHA_FIN = HZRNEHL_FECHA_FIN;
    }
    @XmlTransient
    public Long getHZRNEHL_CANTIDAD() {
        return HZRNEHL_CANTIDAD;
    }

    public void setHZRNEHL_CANTIDAD(Long HZRNEHL_CANTIDAD) {
        this.HZRNEHL_CANTIDAD = HZRNEHL_CANTIDAD;
    }
    @XmlTransient
    public Integer getHZRNEHL_ITE_ID() {
        return HZRNEHL_ITE_ID;
    }

    public void setHZRNEHL_ITE_ID(Integer HZRNEHL_ITE_ID) {
        this.HZRNEHL_ITE_ID = HZRNEHL_ITE_ID;
    }

    @Override
    public String toString() {
        return "EHL{" + "HZRNEHL_FECHA_INICIO=" + HZRNEHL_FECHA_INICIO + ", HZRNEHL_FECHA_FIN=" + HZRNEHL_FECHA_FIN + ", HZRNEHL_CANTIDAD=" + HZRNEHL_CANTIDAD + ", HZRNEHL_ITE_ID=" + HZRNEHL_ITE_ID + '}';
    }

 
}
