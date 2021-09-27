package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNEPR_CANTIDAD",
    "HZRNEPR_PAGO",
    "HZRNEPR_PAGONS"})

public class EPR {
    
    @XmlElement(name = "EPR_1")
    private Long HZRNEPR_CANTIDAD;
    @XmlElement(name = "EPR_2")
    private String HZRNEPR_PAGO;
    @XmlElement(name = "EPR_3")
    private String HZRNEPR_PAGONS;
    private Integer HZRNEPR_ITE_ID;

    @XmlTransient
    public Long getHZRNEPR_CANTIDAD() {
        return HZRNEPR_CANTIDAD;
    }

    public void setHZRNEPR_CANTIDAD(Long HZRNEPR_CANTIDAD) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEPR_CANTIDAD,10)){
            this.HZRNEPR_CANTIDAD = HZRNEPR_CANTIDAD;
            data = null;            
        }else{
            throw new DataFormatException("EPR:HZRNEPR_CANTIDAD:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public String getHZRNEPR_PAGO() {
        return HZRNEPR_PAGO;
    }

    public void setHZRNEPR_PAGO(BigDecimal HZRNEPR_PAGO) throws DataFormatException {
        if(HZRNEPR_PAGO != null){
            this.HZRNEPR_PAGO = this.HZRNEPR_PAGO = new DecimalFormat("#.000000").format(HZRNEPR_PAGO).replace(",",".");  
        }else{
            this.HZRNEPR_PAGO = String.valueOf(HZRNEPR_PAGO);
        }       
    }
    @XmlTransient
    public String getHZRNEPR_PAGONS() {
        return HZRNEPR_PAGONS;
    }

    public void setHZRNEPR_PAGONS(BigDecimal HZRNEPR_PAGONS) {
        if(HZRNEPR_PAGONS != null){
            this.HZRNEPR_PAGONS = new DecimalFormat("#.000000").format(HZRNEPR_PAGONS).replace(",","."); 
        }else{
            this.HZRNEPR_PAGONS = String.valueOf(HZRNEPR_PAGO);
        }    
    }
    @XmlTransient
    public Integer getHZRNEPR_ITE_ID() {
        return HZRNEPR_ITE_ID;
    }

    public void setHZRNEPR_ITE_ID(Integer HZRNEPR_ITE_ID) {
        this.HZRNEPR_ITE_ID = HZRNEPR_ITE_ID;
    }

    @Override
    public String toString() {
        return "EPR{" + "HZRNEPR_CANTIDAD=" + HZRNEPR_CANTIDAD + ", HZRNEPR_PAGO=" + HZRNEPR_PAGO + ", HZRNEPR_PAGONS=" + HZRNEPR_PAGONS + ", HZRNEPR_ITE_ID=" + HZRNEPR_ITE_ID + '}';
    }

}
