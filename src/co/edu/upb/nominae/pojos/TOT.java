package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNTOT_REDONDEO",
    "HZRNTOT_DEVENGADOS_TOTAL",
    "HZRNTOT_DEDUCCIONES_TOTAL",
    "HZRNTOT_COMPROBANTE_TOTAL"})
public class TOT {
    
    private String HZRNTOT_CUNE_INTERNO;      
    @XmlElement(name = "TOT_1")
    private String HZRNTOT_REDONDEO;
    @XmlElement(name = "TOT_2")
    private String HZRNTOT_DEVENGADOS_TOTAL;
    @XmlElement(name = "TOT_3")
    private String HZRNTOT_DEDUCCIONES_TOTAL;
    @XmlElement(name = "TOT_4")
    private String HZRNTOT_COMPROBANTE_TOTAL;

    @XmlTransient
    public String getHZRNTOT_CUNE_INTERNO() {
        return HZRNTOT_CUNE_INTERNO;
    }

    public void setHZRNTOT_CUNE_INTERNO(String HZRNTOT_CUNE_INTERNO) {
        this.HZRNTOT_CUNE_INTERNO = HZRNTOT_CUNE_INTERNO;
    }
    @XmlTransient
    public String getHZRNTOT_REDONDEO() {
        return HZRNTOT_REDONDEO;
    }

    public void setHZRNTOT_REDONDEO(BigDecimal HZRNTOT_REDONDEO) {
        if(HZRNTOT_REDONDEO != null){
            this.HZRNTOT_REDONDEO = new DecimalFormat("#.000000").format(HZRNTOT_REDONDEO).replace(",",".");
        }
    }
    @XmlTransient
    public String getHZRNTOT_DEVENGADOS_TOTAL() {
        return HZRNTOT_DEVENGADOS_TOTAL;
    }

    public void setHZRNTOT_DEVENGADOS_TOTAL(BigDecimal HZRNTOT_DEVENGADOS_TOTAL) throws DataFormatException {
        if(HZRNTOT_DEVENGADOS_TOTAL != null){
            this.HZRNTOT_DEVENGADOS_TOTAL = new DecimalFormat("#.000000").format(HZRNTOT_DEVENGADOS_TOTAL).replace(",","."); 
        }else{
            throw new DataFormatException("TOT:HZRNTOT_DEVENGADOS_TOTAL:El campo es nulo o excede la longitud definida por la DIAN");
        } 
    }
    @XmlTransient
    public String getHZRNTOT_DEDUCCIONES_TOTAL() {
        return HZRNTOT_DEDUCCIONES_TOTAL;
    }

    public void setHZRNTOT_DEDUCCIONES_TOTAL(BigDecimal HZRNTOT_DEDUCCIONES_TOTAL) throws DataFormatException { 
        if(HZRNTOT_DEDUCCIONES_TOTAL != null){
            this.HZRNTOT_DEDUCCIONES_TOTAL = new DecimalFormat("#.000000").format(HZRNTOT_DEDUCCIONES_TOTAL).replace(",",".");  
        }else{
            throw new DataFormatException("TOT:HZRNTOT_DEDUCCIONES_TOTAL:El campo es nulo o excede la longitud definida por la DIAN");
        } 
    }
    @XmlTransient
    public String getHZRNTOT_COMPROBANTE_TOTAL() {
        return HZRNTOT_COMPROBANTE_TOTAL;
    }

    public void setHZRNTOT_COMPROBANTE_TOTAL(BigDecimal HZRNTOT_COMPROBANTE_TOTAL) throws DataFormatException {
        if(HZRNTOT_COMPROBANTE_TOTAL != null){
            this.HZRNTOT_COMPROBANTE_TOTAL =  new DecimalFormat("#.000000").format(HZRNTOT_COMPROBANTE_TOTAL).replace(",","."); 
        }else{
            throw new DataFormatException("TOT:HZRNTOT_COMPROBANTE_TOTAL:El campo es nulo o excede la longitud definida por la DIAN");
        } 
    }

    @Override
    public String toString() {
        return "TOT{" + "HZRNTOT_CUNE_INTERNO=" + HZRNTOT_CUNE_INTERNO + ", HZRNTOT_REDONDEO=" + HZRNTOT_REDONDEO + ", HZRNTOT_DEVENGADOS_TOTAL=" + HZRNTOT_DEVENGADOS_TOTAL + ", HZRNTOT_DEDUCCIONES_TOTAL=" + HZRNTOT_DEDUCCIONES_TOTAL + ", HZRNTOT_COMPROBANTE_TOTAL=" + HZRNTOT_COMPROBANTE_TOTAL + '}';
    }

    
}
