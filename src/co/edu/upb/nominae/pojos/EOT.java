package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNEOT_DESC_CONCEPTO",
    "HZRNEOT_CONCEP_SALARIAL",
    "HZRNEOT_CONCEP_NO_SALARIAL"})

public class EOT {
    
    @XmlElement(name = "EOT_1")
    private String HZRNEOT_DESC_CONCEPTO;
    @XmlElement(name = "EOT_2")
    private String HZRNEOT_CONCEP_SALARIAL;
    @XmlElement(name = "EOT_3")
    private String HZRNEOT_CONCEP_NO_SALARIAL;
    private Integer HZRNEOT_ITE_ID;       

    @XmlTransient
    public String getHZRNEOT_DESC_CONCEPTO() {
        return HZRNEOT_DESC_CONCEPTO;
    }

    public void setHZRNEOT_DESC_CONCEPTO(String HZRNEOT_DESC_CONCEPTO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEOT_DESC_CONCEPTO,250)){
            this.HZRNEOT_DESC_CONCEPTO = HZRNEOT_DESC_CONCEPTO;
            data = null;            
        }else{
            throw new DataFormatException("EOT:HZRNEOT_DESC_CONCEPTO:El campo es nulo o excede la longitud definida por la DIAN");
        }           
    }
    @XmlTransient
    public String getHZRNEOT_CONCEP_SALARIAL() {
        return HZRNEOT_CONCEP_SALARIAL;
    }

    public void setHZRNEOT_CONCEP_SALARIAL(BigDecimal HZRNEOT_CONCEP_SALARIAL) {
        if(HZRNEOT_CONCEP_SALARIAL != null){
            this.HZRNEOT_CONCEP_SALARIAL = new DecimalFormat("#.000000").format(HZRNEOT_CONCEP_SALARIAL).replace(",",".");  
        }else{
            this.HZRNEOT_CONCEP_SALARIAL = String.valueOf(HZRNEOT_CONCEP_SALARIAL);
        } 
    }
    @XmlTransient
    public String getHZRNEOT_CONCEP_NO_SALARIAL() {
        return HZRNEOT_CONCEP_NO_SALARIAL;
    }

    public void setHZRNEOT_CONCEP_NO_SALARIAL(BigDecimal HZRNEOT_CONCEP_NO_SALARIAL) {
        if(HZRNEOT_CONCEP_NO_SALARIAL != null){
            this.HZRNEOT_CONCEP_NO_SALARIAL = new DecimalFormat("#.000000").format(HZRNEOT_CONCEP_NO_SALARIAL).replace(",",".");   
        }else{
            this.HZRNEOT_CONCEP_NO_SALARIAL = String.valueOf(HZRNEOT_CONCEP_NO_SALARIAL);
        } 
    }
    @XmlTransient
    public Integer getHZRNEOT_ITE_ID() {
        return HZRNEOT_ITE_ID;
    }

    public void setHZRNEOT_ITE_ID(Integer HZRNEOT_ITE_ID) {
        this.HZRNEOT_ITE_ID = HZRNEOT_ITE_ID;
    }

    @Override
    public String toString() {
        return "EOT{" + "HZRNEOT_DESC_CONCEPTO=" + HZRNEOT_DESC_CONCEPTO + ", HZRNEOT_CONCEP_SALARIAL=" + HZRNEOT_CONCEP_SALARIAL + ", HZRNEOT_CONCEP_NO_SALARIAL=" + HZRNEOT_CONCEP_NO_SALARIAL + ", HZRNEOT_ITE_ID=" + HZRNEOT_ITE_ID + '}';
    }
       
}
