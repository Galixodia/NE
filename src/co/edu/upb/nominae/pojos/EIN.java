package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNEIN_FECHA_INICIO",
    "HZRNEIN_FECHA_FIN",
    "HZRNEIN_CANTIDAD",
    "HZRNEIN_TIPO",    
    "HZRNEIN_PAGO"})
public class EIN {
    
    @XmlElement(name = "EIN_1")
    private Date HZRNEIN_FECHA_INICIO;
    @XmlElement(name = "EIN_2")
    private Date HZRNEIN_FECHA_FIN;
    @XmlElement(name = "EIN_3")
    private Long HZRNEIN_CANTIDAD;
    @XmlElement(name = "EIN_4")
    private Integer HZRNEIN_TIPO;
    @XmlElement(name = "EIN_5")
    private BigDecimal HZRNEIN_PAGO;
    private Integer HZRNEIN_ITE_ID;      

    @XmlTransient
    public Date getHZRNEIN_FECHA_INICIO() {
        return HZRNEIN_FECHA_INICIO;
    }

    public void setHZRNEIN_FECHA_INICIO(Date HZRNEIN_FECHA_INICIO) {
        this.HZRNEIN_FECHA_INICIO = HZRNEIN_FECHA_INICIO;
    }
    @XmlTransient
    public Date getHZRNEIN_FECHA_FIN() {
        return HZRNEIN_FECHA_FIN;
    }

    public void setHZRNEIN_FECHA_FIN(Date HZRNEIN_FECHA_FIN) {
        this.HZRNEIN_FECHA_FIN = HZRNEIN_FECHA_FIN;
    }
    @XmlTransient
    public Long getHZRNEIN_CANTIDAD() {
        return HZRNEIN_CANTIDAD;
    }

    public void setHZRNEIN_CANTIDAD(Long HZRNEIN_CANTIDAD) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEIN_CANTIDAD,10)){
            this.HZRNEIN_CANTIDAD = HZRNEIN_CANTIDAD;
            data = null;            
        }else{
            throw new DataFormatException("EIN:HZRNEIN_CANTIDAD:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public Integer getHZRNEIN_TIPO() {
        return HZRNEIN_TIPO;
    }

    public void setHZRNEIN_TIPO(Integer HZRNEIN_TIPO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEIN_TIPO,1)){
            this.HZRNEIN_TIPO = HZRNEIN_TIPO;
            data = null;            
        }else{
            throw new DataFormatException("EIN:HZRNEIN_TIPO:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public BigDecimal getHZRNEIN_PAGO() {
        return HZRNEIN_PAGO;
    }

    public void setHZRNEIN_PAGO(BigDecimal HZRNEIN_PAGO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEIN_PAGO,15,6)){
           this.HZRNEIN_PAGO = HZRNEIN_PAGO;
            data = null;            
        }else{
            throw new DataFormatException("EIN:HZRNEIN_PAGO:El campo es nulo o excede la longitud definida por la DIAN");
        }            
    }
    @XmlTransient
    public Integer getHZRNEIN_ITE_ID() {
        return HZRNEIN_ITE_ID;
    }

    public void setHZRNEIN_ITE_ID(Integer HZRNEIN_ITE_ID) {
        this.HZRNEIN_ITE_ID = HZRNEIN_ITE_ID;
    }

    @Override
    public String toString() {
        return "EIN{" + "HZRNEIN_FECHA_INICIO=" + HZRNEIN_FECHA_INICIO + ", HZRNEIN_FECHA_FIN=" + HZRNEIN_FECHA_FIN + ", HZRNEIN_CANTIDAD=" + HZRNEIN_CANTIDAD + ", HZRNEIN_TIPO=" + HZRNEIN_TIPO + ", HZRNEIN_PAGO=" + HZRNEIN_PAGO + ", HZRNEIN_ITE_ID=" + HZRNEIN_ITE_ID + '}';
    }
 
}
