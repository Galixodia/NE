package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType (propOrder={"HZRNECE_PAGO",
    "HZRNECE_PORCENTAJE",
    "HZRNECE_PAGO_INTERESES"})
public class ECE {
    
    @XmlElement(name = "ECE_1")
    private String HZRNECE_PAGO;
    @XmlElement(name = "ECE_2")
    private String HZRNECE_PORCENTAJE;
    @XmlElement(name = "ECE_3")
    private String HZRNECE_PAGO_INTERESES;   
    private Integer HZRNECE_ITE_ID;    

    @XmlTransient
    public String getHZRNECE_PAGO() {
        return HZRNECE_PAGO;
    }

    public void setHZRNECE_PAGO(BigDecimal HZRNECE_PAGO) throws DataFormatException {  
        if(HZRNECE_PAGO != null){
            this.HZRNECE_PAGO = new DecimalFormat("#.000000").format(HZRNECE_PAGO).replace(",",".");
        }else{
            this.HZRNECE_PAGO = String.valueOf(HZRNECE_PAGO);
        } 
    }
    @XmlTransient
    public String getHZRNECE_PORCENTAJE() {
        return HZRNECE_PORCENTAJE;
    }

    public void setHZRNECE_PORCENTAJE(BigDecimal HZRNECE_PORCENTAJE) throws DataFormatException {
        if(HZRNECE_PORCENTAJE != null){
            this.HZRNECE_PORCENTAJE = new DecimalFormat("#.00").format(HZRNECE_PORCENTAJE).replace(",","."); 
        }else{
            this.HZRNECE_PORCENTAJE = String.valueOf(HZRNECE_PORCENTAJE);
        } 
    }
    @XmlTransient
    public String getHZRNECE_PAGO_INTERESES() {
        return HZRNECE_PAGO_INTERESES;
    }

    public void setHZRNECE_PAGO_INTERESES(BigDecimal HZRNECE_PAGO_INTERESES) throws DataFormatException {
        if(HZRNECE_PAGO_INTERESES != null){
            this.HZRNECE_PAGO_INTERESES = new DecimalFormat("#.000000").format(HZRNECE_PAGO_INTERESES).replace(",",".");
        }else{
            this.HZRNECE_PAGO_INTERESES = String.valueOf(HZRNECE_PAGO_INTERESES);
        } 
    }
    @XmlTransient
    public Integer getHZRNECE_ITE_ID() {
        return HZRNECE_ITE_ID;
    }

    public void setHZRNECE_ITE_ID(Integer HZRNECE_ITE_ID) {
        this.HZRNECE_ITE_ID = HZRNECE_ITE_ID;
    }

    @Override
    public String toString() {
        return "ECE{" + "HZRNECE_PAGO=" + HZRNECE_PAGO + ", HZRNECE_PORCENTAJE=" + HZRNECE_PORCENTAJE + ", HZRNECE_PAGO_INTERESES=" + HZRNECE_PAGO_INTERESES + ", HZRNECE_ITE_ID=" + HZRNECE_ITE_ID + '}';
    }

    
}
