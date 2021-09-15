package co.edu.upb.nominae.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author 000329744 Xiomara Torrez Muñoz
 * @since 00/09/2021
 * @version 1.0
 * 
 * Segmento Opcional. Utilizado para Atributos de Transporte de Devengos del Documento. Este segmento es dependiente Ver Nota 3
 * Puede repetirse hasta 50 veces por cada registro de Devengado  Basico(ITE). Ver nota 4
 */

//@XmlRootElement(name = "ETR")
@XmlType (propOrder={"HZRNETR_AUX_TRANSPORTE",
    "HZRNETR_VIAT_MANUT_SALARIAL",
    "HZRNETR_VIAT_MANUT_NO_SALARIAL"})

public class ETR {
    
    @XmlElement(name = "ETR_1")
    private Double HZRNETR_AUX_TRANSPORTE;
    @XmlElement(name = "ETR_2")
    private Double HZRNETR_VIAT_MANUT_SALARIAL;
    @XmlElement(name = "ETR_3")
    private Double HZRNETR_VIAT_MANUT_NO_SALARIAL;
    private Integer HZRNETR_ITE_ID;    

    @XmlTransient
    public Double getHZRNETR_AUX_TRANSPORTE() {
        return HZRNETR_AUX_TRANSPORTE;
    }

    public void setHZRNETR_AUX_TRANSPORTE(Double HZRNETR_AUX_TRANSPORTE) {
        this.HZRNETR_AUX_TRANSPORTE = HZRNETR_AUX_TRANSPORTE;
    }
    @XmlTransient
    public Double getHZRNETR_VIAT_MANUT_SALARIAL() {
        return HZRNETR_VIAT_MANUT_SALARIAL;
    }

    public void setHZRNETR_VIAT_MANUT_SALARIAL(Double HZRNETR_VIAT_MANUT_SALARIAL) {
        this.HZRNETR_VIAT_MANUT_SALARIAL = HZRNETR_VIAT_MANUT_SALARIAL;
    }
    @XmlTransient
    public Double getHZRNETR_VIAT_MANUT_NO_SALARIAL() {
        return HZRNETR_VIAT_MANUT_NO_SALARIAL;
    }

    public void setHZRNETR_VIAT_MANUT_NO_SALARIAL(Double HZRNETR_VIAT_MANUT_NO_SALARIAL) {
        this.HZRNETR_VIAT_MANUT_NO_SALARIAL = HZRNETR_VIAT_MANUT_NO_SALARIAL;
    }
    @XmlTransient
    public Integer getHZRNETR_ITE_ID() {
        return HZRNETR_ITE_ID;
    }

    public void setHZRNETR_ITE_ID(Integer HZRNETR_ITE_ID) {
        this.HZRNETR_ITE_ID = HZRNETR_ITE_ID;
    }

    @Override
    public String toString() {
        return "ETR{" + "HZRNETR_AUX_TRANSPORTE=" + HZRNETR_AUX_TRANSPORTE + ", HZRNETR_VIAT_MANUT_SALARIAL=" + HZRNETR_VIAT_MANUT_SALARIAL + ", HZRNETR_VIAT_MANUT_NO_SALARIAL=" + HZRNETR_VIAT_MANUT_NO_SALARIAL + ", HZRNETR_ITE_ID=" + HZRNETR_ITE_ID + '}';
    }

}
