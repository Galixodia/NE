package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlElement;
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


@XmlType (propOrder={"HZRNETR_AUX_TRANSPORTE",
    "HZRNETR_VIAT_MANUT_SALARIAL",
    "HZRNETR_VIAT_MANUT_NO_SALARIAL"})
public class ETR {
    
    @XmlElement(name = "ETR_1")
    private String HZRNETR_AUX_TRANSPORTE;
    @XmlElement(name = "ETR_2")
    private String HZRNETR_VIAT_MANUT_SALARIAL;
    @XmlElement(name = "ETR_3")
    private String HZRNETR_VIAT_MANUT_NO_SALARIAL;
    private Integer HZRNETR_ITE_ID;    

    @XmlTransient
    public String getHZRNETR_AUX_TRANSPORTE() {
        return HZRNETR_AUX_TRANSPORTE;
    }

    public void setHZRNETR_AUX_TRANSPORTE(BigDecimal HZRNETR_AUX_TRANSPORTE) {
        if(HZRNETR_AUX_TRANSPORTE != null){
            this.HZRNETR_AUX_TRANSPORTE = new DecimalFormat("#.000000").format(HZRNETR_AUX_TRANSPORTE).replace(",",".");
        }
    }
    @XmlTransient
    public String getHZRNETR_VIAT_MANUT_SALARIAL() {
        return HZRNETR_VIAT_MANUT_SALARIAL;
    }

    public void setHZRNETR_VIAT_MANUT_SALARIAL(BigDecimal HZRNETR_VIAT_MANUT_SALARIAL) {
        if(HZRNETR_VIAT_MANUT_SALARIAL != null){
            this.HZRNETR_VIAT_MANUT_SALARIAL = new DecimalFormat("#.000000").format(HZRNETR_VIAT_MANUT_SALARIAL).replace(",","."); 
        }
    }
    @XmlTransient
    public String getHZRNETR_VIAT_MANUT_NO_SALARIAL() {
        return HZRNETR_VIAT_MANUT_NO_SALARIAL;
    }

    public void setHZRNETR_VIAT_MANUT_NO_SALARIAL(BigDecimal HZRNETR_VIAT_MANUT_NO_SALARIAL) {       
        if(HZRNETR_VIAT_MANUT_NO_SALARIAL != null){
            this.HZRNETR_VIAT_MANUT_NO_SALARIAL = new DecimalFormat("#.000000").format(HZRNETR_VIAT_MANUT_NO_SALARIAL).replace(",","."); 
        }
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
