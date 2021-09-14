package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "EVO")
@XmlType (propOrder={"HZRNEVO_DOTACION",
    "HZRNEVO_APOYO_SOSTENIMIENT",
    "HZRNEVO_TELETRABAJO",
    "HZRNEVO_BONIF_RETIRO",
    "HZRNEVO_INDEMNIZACION",    
    "HZRNEVO_REINTEGRO"})

public class EVO {
    
    @XmlElement(name = "EVO_1")
    private Double HZRNEVO_DOTACION;
    @XmlElement(name = "EVO_2")
    private Double HZRNEVO_APOYO_SOSTENIMIENT;
    @XmlElement(name = "EVO_3")
    private Double HZRNEVO_TELETRABAJO;
    @XmlElement(name = "EVO_4")
    private Double HZRNEVO_BONIF_RETIRO;
    @XmlElement(name = "EVO_5")
    private Double HZRNEVO_INDEMNIZACION;
    @XmlElement(name = "EVO_6")
    private Double HZRNEVO_REINTEGRO;    
    private Integer HZRNEVO_ITE_ID;

    @XmlTransient
    public Double getHZRNEVO_DOTACION() {
        return HZRNEVO_DOTACION;
    }

    public void setHZRNEVO_DOTACION(Double HZRNEVO_DOTACION) {
        this.HZRNEVO_DOTACION = HZRNEVO_DOTACION;
    }
    @XmlTransient
    public Double getHZRNEVO_APOYO_SOSTENIMIENT() {
        return HZRNEVO_APOYO_SOSTENIMIENT;
    }

    public void setHZRNEVO_APOYO_SOSTENIMIENT(Double HZRNEVO_APOYO_SOSTENIMIENT) {
        this.HZRNEVO_APOYO_SOSTENIMIENT = HZRNEVO_APOYO_SOSTENIMIENT;
    }
    @XmlTransient
    public Double getHZRNEVO_TELETRABAJO() {
        return HZRNEVO_TELETRABAJO;
    }

    public void setHZRNEVO_TELETRABAJO(Double HZRNEVO_TELETRABAJO) {
        this.HZRNEVO_TELETRABAJO = HZRNEVO_TELETRABAJO;
    }
    @XmlTransient
    public Double getHZRNEVO_BONIF_RETIRO() {
        return HZRNEVO_BONIF_RETIRO;
    }

    public void setHZRNEVO_BONIF_RETIRO(Double HZRNEVO_BONIF_RETIRO) {
        this.HZRNEVO_BONIF_RETIRO = HZRNEVO_BONIF_RETIRO;
    }
    @XmlTransient
    public Double getHZRNEVO_INDEMNIZACION() {
        return HZRNEVO_INDEMNIZACION;
    }

    public void setHZRNEVO_INDEMNIZACION(Double HZRNEVO_INDEMNIZACION) {
        this.HZRNEVO_INDEMNIZACION = HZRNEVO_INDEMNIZACION;
    }
    @XmlTransient
    public Double getHZRNEVO_REINTEGRO() {
        return HZRNEVO_REINTEGRO;
    }

    public void setHZRNEVO_REINTEGRO(Double HZRNEVO_REINTEGRO) {
        this.HZRNEVO_REINTEGRO = HZRNEVO_REINTEGRO;
    }
    @XmlTransient
    public Integer getHZRNEVO_ITE_ID() {
        return HZRNEVO_ITE_ID;
    }

    public void setHZRNEVO_ITE_ID(Integer HZRNEVO_ITE_ID) {
        this.HZRNEVO_ITE_ID = HZRNEVO_ITE_ID;
    }

    @Override
    public String toString() {
        return "EVO{" + "HZRNEVO_DOTACION=" + HZRNEVO_DOTACION + ", HZRNEVO_APOYO_SOSTENIMIENT=" + HZRNEVO_APOYO_SOSTENIMIENT + ", HZRNEVO_TELETRABAJO=" + HZRNEVO_TELETRABAJO + ", HZRNEVO_BONIF_RETIRO=" + HZRNEVO_BONIF_RETIRO + ", HZRNEVO_INDEMNIZACION=" + HZRNEVO_INDEMNIZACION + ", HZRNEVO_REINTEGRO=" + HZRNEVO_REINTEGRO + ", HZRNEVO_ITE_ID=" + HZRNEVO_ITE_ID + '}';
    }
     
}
