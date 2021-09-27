package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNEAX_AUX_SALARIAL",
    "HZRNEAX_AUX_NO_SALARIAL"})
public class EAX {
    
    @XmlElement(name = "EAX_1")
    private String HZRNEAX_AUX_SALARIAL;
    @XmlElement(name = "EAX_2")
    private String HZRNEAX_AUX_NO_SALARIAL;
    private Integer HZRNEAX_ITE_ID;       

    @XmlTransient
    public String getHZRNEAX_AUX_SALARIAL() {
        return HZRNEAX_AUX_SALARIAL;
    }

    public void setHZRNEAX_AUX_SALARIAL(BigDecimal HZRNEAX_AUX_SALARIAL) {
        if(HZRNEAX_AUX_SALARIAL != null){
            this.HZRNEAX_AUX_SALARIAL = new DecimalFormat("#.000000").format(HZRNEAX_AUX_SALARIAL).replace(",",".");  
        }else{
            this.HZRNEAX_AUX_SALARIAL = String.valueOf(HZRNEAX_AUX_SALARIAL);
        } 
    }
    @XmlTransient
    public String getHZRNEAX_AUX_NO_SALARIAL() {
        return HZRNEAX_AUX_NO_SALARIAL;
    }

    public void setHZRNEAX_AUX_NO_SALARIAL(BigDecimal HZRNEAX_AUX_NO_SALARIAL) {
        if(HZRNEAX_AUX_NO_SALARIAL != null){
            this.HZRNEAX_AUX_NO_SALARIAL = new DecimalFormat("#.000000").format(HZRNEAX_AUX_NO_SALARIAL).replace(",",".");    
        }else{
            this.HZRNEAX_AUX_NO_SALARIAL = String.valueOf(HZRNEAX_AUX_NO_SALARIAL);
        } 
    }
    @XmlTransient
    public Integer getHZRNEAX_ITE_ID() {
        return HZRNEAX_ITE_ID;
    }

    public void setHZRNEAX_ITE_ID(Integer HZRNEAX_ITE_ID) {
        this.HZRNEAX_ITE_ID = HZRNEAX_ITE_ID;
    }

    @Override
    public String toString() {
        return "EAX{" + "HZRNEAX_AUX_SALARIAL=" + HZRNEAX_AUX_SALARIAL + ", HZRNEAX_AUX_NO_SALARIAL=" + HZRNEAX_AUX_NO_SALARIAL + ", HZRNEAX_ITE_ID=" + HZRNEAX_ITE_ID + '}';
    }

     
}
