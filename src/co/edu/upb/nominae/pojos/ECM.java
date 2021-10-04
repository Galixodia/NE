package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNECM_COMPENS_ORDINARIA",
    "HZRNECM_COMPENS_EXTRAORDINARIA"})
public class ECM {
    
    @XmlElement(name = "ECM_1")
    private String HZRNECM_COMPENS_ORDINARIA;
    @XmlElement(name = "ECM_2")
    private String HZRNECM_COMPENS_EXTRAORDINARIA;
    private Integer HZRNECM_ITE_ID;       

    @XmlTransient
    public String getHZRNECM_COMPENS_ORDINARIA() {
        return HZRNECM_COMPENS_ORDINARIA;
    }

    public void setHZRNECM_COMPENS_ORDINARIA(BigDecimal HZRNECM_COMPENS_ORDINARIA) throws DataFormatException {        
        if(HZRNECM_COMPENS_ORDINARIA != null){
            this.HZRNECM_COMPENS_ORDINARIA = new DecimalFormat("0.000000").format(HZRNECM_COMPENS_ORDINARIA).replace(",","."); 
        }else{
            throw new DataFormatException("ECM:HZRNECM_COMPENS_ORDINARIA:El campo es nulo o excede la longitud definida por la DIAN");
        } 
    }
    @XmlTransient
    public String getHZRNECM_COMPENS_EXTRAORDINARIA() {
        return HZRNECM_COMPENS_EXTRAORDINARIA;
    }

    public void setHZRNECM_COMPENS_EXTRAORDINARIA(BigDecimal HZRNECM_COMPENS_EXTRAORDINARIA) throws DataFormatException { 
        if(HZRNECM_COMPENS_EXTRAORDINARIA != null){
            this.HZRNECM_COMPENS_EXTRAORDINARIA = new DecimalFormat("0.000000").format(HZRNECM_COMPENS_EXTRAORDINARIA).replace(",",".");   
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
