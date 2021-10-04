package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNEVO_DOTACION",
    "HZRNEVO_APOYO_SOSTENIMIENT",
    "HZRNEVO_TELETRABAJO",
    "HZRNEVO_BONIF_RETIRO",
    "HZRNEVO_INDEMNIZACION",    
    "HZRNEVO_REINTEGRO"})

public class EVO {
    
    @XmlElement(name = "EVO_1")
    private String HZRNEVO_DOTACION;
    @XmlElement(name = "EVO_2")
    private String HZRNEVO_APOYO_SOSTENIMIENT;
    @XmlElement(name = "EVO_3")
    private String HZRNEVO_TELETRABAJO;
    @XmlElement(name = "EVO_4")
    private String HZRNEVO_BONIF_RETIRO;
    @XmlElement(name = "EVO_5")
    private String HZRNEVO_INDEMNIZACION;
    @XmlElement(name = "EVO_6")
    private String HZRNEVO_REINTEGRO;    
    private Integer HZRNEVO_ITE_ID;

    @XmlTransient
    public String getHZRNEVO_DOTACION() {
        return HZRNEVO_DOTACION;
    }

    public void setHZRNEVO_DOTACION(BigDecimal HZRNEVO_DOTACION) {
        if(HZRNEVO_DOTACION != null){
            this.HZRNEVO_DOTACION = new DecimalFormat("0.000000").format(HZRNEVO_DOTACION).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNEVO_APOYO_SOSTENIMIENT() {
        return HZRNEVO_APOYO_SOSTENIMIENT;
    }

    public void setHZRNEVO_APOYO_SOSTENIMIENT(BigDecimal HZRNEVO_APOYO_SOSTENIMIENT) {   
        if(HZRNEVO_APOYO_SOSTENIMIENT != null){
            this.HZRNEVO_APOYO_SOSTENIMIENT = new DecimalFormat("0.000000").format(HZRNEVO_APOYO_SOSTENIMIENT).replace(",","."); 
        }
    }
    @XmlTransient
    public String getHZRNEVO_TELETRABAJO() {
        return HZRNEVO_TELETRABAJO;
    }

    public void setHZRNEVO_TELETRABAJO(BigDecimal HZRNEVO_TELETRABAJO) {
        if(HZRNEVO_TELETRABAJO != null){
            this.HZRNEVO_TELETRABAJO = new DecimalFormat("0.000000").format(HZRNEVO_TELETRABAJO).replace(",","."); 
        }
    }
    @XmlTransient
    public String getHZRNEVO_BONIF_RETIRO() {
        return HZRNEVO_BONIF_RETIRO;
    }

    public void setHZRNEVO_BONIF_RETIRO(BigDecimal HZRNEVO_BONIF_RETIRO) {
        if(HZRNEVO_BONIF_RETIRO != null){
            this.HZRNEVO_BONIF_RETIRO = new DecimalFormat("0.000000").format(HZRNEVO_BONIF_RETIRO).replace(",","."); 
        }
    }
    @XmlTransient
    public String getHZRNEVO_INDEMNIZACION() {
        return HZRNEVO_INDEMNIZACION;
    }

    public void setHZRNEVO_INDEMNIZACION(BigDecimal HZRNEVO_INDEMNIZACION) {
        if(HZRNEVO_INDEMNIZACION != null){
            this.HZRNEVO_INDEMNIZACION = new DecimalFormat("0.000000").format(HZRNEVO_INDEMNIZACION).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNEVO_REINTEGRO() {
        return HZRNEVO_REINTEGRO;
    }

    public void setHZRNEVO_REINTEGRO(BigDecimal HZRNEVO_REINTEGRO) {
        if(HZRNEVO_REINTEGRO != null){
            this.HZRNEVO_REINTEGRO = new DecimalFormat("0.000000").format(HZRNEVO_REINTEGRO).replace(",","."); 
        }
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
