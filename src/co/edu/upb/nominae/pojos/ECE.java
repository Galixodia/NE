package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "ECE")
@XmlType (propOrder={"HZRNECE_PAGO",
    "HZRNECE_PORCENTAJE",
    "HZRNECE_PAGO_INTERESES"})

public class ECE {
    
    @XmlElement(name = "ECE_1")
    private Double HZRNECE_PAGO;
    @XmlElement(name = "ECE_2")
    private Double HZRNECE_PORCENTAJE;
    @XmlElement(name = "ECE_3")
    private Double HZRNECE_PAGO_INTERESES;   
    private Integer HZRNECE_ITE_ID;    

    @XmlTransient
    public Double getHZRNECE_PAGO() {
        return HZRNECE_PAGO;
    }

    public void setHZRNECE_PAGO(Double HZRNECE_PAGO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNECE_PAGO,15,6)){
        this.HZRNECE_PAGO = HZRNECE_PAGO;
            data = null;            
        }else{
            throw new DataFormatException("ECE:HZRNENC_NUM_PRED:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public Double getHZRNECE_PORCENTAJE() {
        return HZRNECE_PORCENTAJE;
    }

    public void setHZRNECE_PORCENTAJE(Double HZRNECE_PORCENTAJE) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNECE_PORCENTAJE,3,2)){
        this.HZRNECE_PORCENTAJE = HZRNECE_PORCENTAJE;
            data = null;            
        }else{
            throw new DataFormatException("ECE:HZRNECE_PORCENTAJE:El campo es nulo o excede la longitud definida por la DIAN");
        }         
    }
    @XmlTransient
    public Double getHZRNECE_PAGO_INTERESES() {
        return HZRNECE_PAGO_INTERESES;
    }

    public void setHZRNECE_PAGO_INTERESES(Double HZRNECE_PAGO_INTERESES) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNECE_PAGO_INTERESES,15,6)){
        this.HZRNECE_PAGO_INTERESES = HZRNECE_PAGO_INTERESES;
            data = null;            
        }else{
            throw new DataFormatException("ECE:HZRNECE_PAGO_INTERESES:El campo es nulo o excede la longitud definida por la DIAN");
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
