package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNSAN_SANCION_PUBLICA",
    "HZRNSAN_SANCION_PRIVADA"})
public class SAN {
    
    @XmlElement(name = "SAN_1")
    private BigDecimal HZRNSAN_SANCION_PUBLICA;
    @XmlElement(name = "SAN_2")
    private BigDecimal HZRNSAN_SANCION_PRIVADA;
    private Integer HZRNSAN_ITS_ID;       

    @XmlTransient
    public BigDecimal getHZRNSAN_SANCION_PUBLICA() {
        return HZRNSAN_SANCION_PUBLICA;
    }

    public void setHZRNSAN_SANCION_PUBLICA(BigDecimal HZRNSAN_SANCION_PUBLICA) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNSAN_SANCION_PUBLICA,15,6)){
            this.HZRNSAN_SANCION_PUBLICA = HZRNSAN_SANCION_PUBLICA;
            data = null;            
        }else{
            throw new DataFormatException("SAN:HZRNSAN_SANCION_PUBLICA:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public BigDecimal getHZRNSAN_SANCION_PRIVADA() {
        return HZRNSAN_SANCION_PRIVADA;
    }

    public void setHZRNSAN_SANCION_PRIVADA(BigDecimal HZRNSAN_SANCION_PRIVADA) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNSAN_SANCION_PRIVADA,15,6)){
            this.HZRNSAN_SANCION_PRIVADA = HZRNSAN_SANCION_PRIVADA;
            data = null;            
        }else{
            throw new DataFormatException("SAN:HZRNSAN_SANCION_PRIVADA:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public Integer getHZRNSAN_ITS_ID() {
        return HZRNSAN_ITS_ID;
    }

    public void setHZRNSAN_ITS_ID(Integer HZRNSAN_ITS_ID) {
        this.HZRNSAN_ITS_ID = HZRNSAN_ITS_ID;
    }

    @Override
    public String toString() {
        return "SAN{" + "HZRNSAN_SANCION_PUBLICA=" + HZRNSAN_SANCION_PUBLICA + ", HZRNSAN_SANCION_PRIVADA=" + HZRNSAN_SANCION_PRIVADA + ", HZRNSAN_ITS_ID=" + HZRNSAN_ITS_ID + '}';
    }
 
    
}
