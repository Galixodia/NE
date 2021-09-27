package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNELI_FECHA_INICIO",
    "HZRNELI_FECHA_FIN",
    "HZRNELI_CANTIDAD",
    "HZRNELI_PAGO"})

public class ELI {
    
    @XmlElement(name = "ELI_1")
    private String HZRNELI_FECHA_INICIO;
    @XmlElement(name = "ELI_2")
    private String HZRNELI_FECHA_FIN;
    @XmlElement(name = "ELI_3")
    private Long HZRNELI_CANTIDAD;
    @XmlElement(name = "ELI_4")
    private String HZRNELI_PAGO;  
    private Integer HZRNELI_ITE_ID;   

    @XmlTransient
    public String getHZRNELI_FECHA_INICIO() {
        return HZRNELI_FECHA_INICIO;
    }

    public void setHZRNELI_FECHA_INICIO(String HZRNELI_FECHA_INICIO) {
        this.HZRNELI_FECHA_INICIO = HZRNELI_FECHA_INICIO;
    }
    @XmlTransient
    public String getHZRNELI_FECHA_FIN() {
        return HZRNELI_FECHA_FIN;
    }

    public void setHZRNELI_FECHA_FIN(String HZRNELI_FECHA_FIN) {
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
    public String getHZRNELI_PAGO() {
        return HZRNELI_PAGO;
    }

    public void setHZRNELI_PAGO(BigDecimal HZRNELI_PAGO) throws DataFormatException {
        if(HZRNELI_PAGO != null){
            this.HZRNELI_PAGO = new DecimalFormat("#.000000").format(HZRNELI_PAGO).replace(",",".");  
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
