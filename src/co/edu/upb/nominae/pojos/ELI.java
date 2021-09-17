package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.util.Date;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


//@XmlRootElement(name = "ELI")
@XmlType (propOrder={"HZRNELI_FECHA_INICIO",
    "HZRNELI_FECHA_FIN",
    "HZRNELI_CANTIDAD",
    "HZRNELI_PAGO"})

public class ELI {
    
    @XmlElement(name = "ELI_1")
    private Date HZRNELI_FECHA_INICIO;
    @XmlElement(name = "ELI_2")
    private Date HZRNELI_FECHA_FIN;
    @XmlElement(name = "ELI_3")
    private Long HZRNELI_CANTIDAD;
    @XmlElement(name = "ELI_4")
    private Double HZRNELI_PAGO;  
    private Integer HZRNELI_ITE_ID;   

    @XmlTransient
    public Date getHZRNELI_FECHA_INICIO() {
        return HZRNELI_FECHA_INICIO;
    }

    public void setHZRNELI_FECHA_INICIO(Date HZRNELI_FECHA_INICIO) {
        this.HZRNELI_FECHA_INICIO = HZRNELI_FECHA_INICIO;
    }
    @XmlTransient
    public Date getHZRNELI_FECHA_FIN() {
        return HZRNELI_FECHA_FIN;
    }

    public void setHZRNELI_FECHA_FIN(Date HZRNELI_FECHA_FIN) {
        this.HZRNELI_FECHA_FIN = HZRNELI_FECHA_FIN;
    }
    @XmlTransient
    public Long getHZRNELI_CANTIDAD() {
        return HZRNELI_CANTIDAD;
    }

    public void setHZRNELI_CANTIDAD(Long HZRNELI_CANTIDAD) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNELI_CANTIDAD,10)){
            this.HZRNELI_CANTIDAD = HZRNELI_CANTIDAD;
            data = null;            
        }else{
            throw new DataFormatException("ELI:HZRNELI_CANTIDAD:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public Double getHZRNELI_PAGO() {
        return HZRNELI_PAGO;
    }

    public void setHZRNELI_PAGO(Double HZRNELI_PAGO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNELI_PAGO,15,6)){
            this.HZRNELI_PAGO = HZRNELI_PAGO;
            data = null;            
        }else{
            throw new DataFormatException("ELI:HZRNELI_PAGO:El campo es nulo o excede la longitud definida por la DIAN");
        }         
    }
    @XmlTransient
    public Integer getHZRNELI_ITE_ID() {
        return HZRNELI_ITE_ID;
    }

    public void setHZRNELI_ITE_ID(Integer HZRNELI_ITE_ID) {
        this.HZRNELI_ITE_ID = HZRNELI_ITE_ID;
    }

    @Override
    public String toString() {
        return "ELI{" + "HZRNELI_FECHA_INICIO=" + HZRNELI_FECHA_INICIO + ", HZRNELI_FECHA_FIN=" + HZRNELI_FECHA_FIN + ", HZRNELI_CANTIDAD=" + HZRNELI_CANTIDAD + ", HZRNELI_PAGO=" + HZRNELI_PAGO + ", HZRNELI_ITE_ID=" + HZRNELI_ITE_ID + '}';
    }
   
    
}
