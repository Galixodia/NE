package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNEBN_BONI_SALARIAL",
    "HZRNEBN_BONI_NO_SALARIAL"})
public class EBN {
    
    @XmlElement(name = "EBN_1")
    private String HZRNEBN_BONI_SALARIAL;
    @XmlElement(name = "EBN_2")
    private String HZRNEBN_BONI_NO_SALARIAL;
    private Integer HZRNEBN_ITE_ID;   

    @XmlTransient
    public String getHZRNEBN_BONI_SALARIAL() {
        return HZRNEBN_BONI_SALARIAL;
    }

    public void setHZRNEBN_BONI_SALARIAL(BigDecimal HZRNEBN_BONI_SALARIAL) {
        if(HZRNEBN_BONI_SALARIAL != null){
            this.HZRNEBN_BONI_SALARIAL = new DecimalFormat("#.000000").format(HZRNEBN_BONI_SALARIAL).replace(",",".");
        }else{
            this.HZRNEBN_BONI_SALARIAL = String.valueOf(HZRNEBN_BONI_SALARIAL);
        } 
    }
    @XmlTransient
    public String getHZRNEBN_BONI_NO_SALARIAL() {
        return HZRNEBN_BONI_NO_SALARIAL;
    }

    public void setHZRNEBN_BONI_NO_SALARIAL(BigDecimal HZRNEBN_BONI_NO_SALARIAL) { 
        if(HZRNEBN_BONI_NO_SALARIAL != null){
            this.HZRNEBN_BONI_NO_SALARIAL = new DecimalFormat("#.000000").format(HZRNEBN_BONI_NO_SALARIAL).replace(",","."); 
        }else{
            this.HZRNEBN_BONI_NO_SALARIAL = String.valueOf(HZRNEBN_BONI_SALARIAL);
        } 
    }
    @XmlTransient
    public Integer getHZRNEBN_ITE_ID() {
        return HZRNEBN_ITE_ID;
    }

    public void setHZRNEBN_ITE_ID(Integer HZRNEBN_ITE_ID) {
        this.HZRNEBN_ITE_ID = HZRNEBN_ITE_ID;
    }

    @Override
    public String toString() {
        return "EBN{" + "HZRNEBN_BONI_SALARIAL=" + HZRNEBN_BONI_SALARIAL + ", HZRNEBN_BONI_NO_SALARIAL=" + HZRNEBN_BONI_NO_SALARIAL + ", HZRNEBN_ITE_ID=" + HZRNEBN_ITE_ID + '}';
    }
    
  
 }
