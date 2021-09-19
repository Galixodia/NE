package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNECM_COMPENS_ORDINARIA",
    "HZRNECM_COMPENS_EXTRAORDINARIA"})
public class ECM {
    
    @XmlElement(name = "ECM_1")
    private BigDecimal HZRNECM_COMPENS_ORDINARIA;
    @XmlElement(name = "ECM_2")
    private BigDecimal HZRNECM_COMPENS_EXTRAORDINARIA;
    private Integer HZRNECM_ITE_ID;       

    @XmlTransient
    public BigDecimal getHZRNECM_COMPENS_ORDINARIA() {
        return HZRNECM_COMPENS_ORDINARIA;
    }

    public void setHZRNECM_COMPENS_ORDINARIA(BigDecimal HZRNECM_COMPENS_ORDINARIA) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNECM_COMPENS_ORDINARIA,15,6)){
            this.HZRNECM_COMPENS_ORDINARIA = HZRNECM_COMPENS_ORDINARIA;
            data = null;            
        }else{
            throw new DataFormatException("ECM:HZRNECM_COMPENS_ORDINARIA:El campo es nulo o excede la longitud definida por la DIAN");
        }             
    }
    @XmlTransient
    public BigDecimal getHZRNECM_COMPENS_EXTRAORDINARIA() {
        return HZRNECM_COMPENS_EXTRAORDINARIA;
    }

    public void setHZRNECM_COMPENS_EXTRAORDINARIA(BigDecimal HZRNECM_COMPENS_EXTRAORDINARIA) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNECM_COMPENS_EXTRAORDINARIA,15,6)){
            this.HZRNECM_COMPENS_EXTRAORDINARIA = HZRNECM_COMPENS_EXTRAORDINARIA;
            data = null;            
        }else{
            throw new DataFormatException("ECM:HZRNECM_COMPENS_EXTRAORDINARIA:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public Integer getHZRNECM_ITE_ID() {
        return HZRNECM_ITE_ID;
    }

    public void setHZRNECM_ITE_ID(Integer HZRNECM_ITE_ID) {
        this.HZRNECM_ITE_ID = HZRNECM_ITE_ID;
    }

    @Override
    public String toString() {
        return "ECM{" + "HZRNECM_COMPENS_ORDINARIA=" + HZRNECM_COMPENS_ORDINARIA + ", HZRNECM_COMPENS_EXTRAORDINARIA=" + HZRNECM_COMPENS_EXTRAORDINARIA + ", HZRNECM_ITE_ID=" + HZRNECM_ITE_ID + '}';
    }

}
