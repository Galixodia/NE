package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNSAN_SANCION_PUBLICA",
    "HZRNSAN_SANCION_PRIVADA"})
public class SAN {
    
    @XmlElement(name = "SAN_1")
    private String HZRNSAN_SANCION_PUBLICA;
    @XmlElement(name = "SAN_2")
    private String HZRNSAN_SANCION_PRIVADA;
    private Integer HZRNSAN_ITS_ID;       

    @XmlTransient
    public String getHZRNSAN_SANCION_PUBLICA() {
        return HZRNSAN_SANCION_PUBLICA;
    }

    public void setHZRNSAN_SANCION_PUBLICA(BigDecimal HZRNSAN_SANCION_PUBLICA) throws DataFormatException {
        if(HZRNSAN_SANCION_PUBLICA != null){
            this.HZRNSAN_SANCION_PUBLICA = new DecimalFormat("#.000000").format(HZRNSAN_SANCION_PUBLICA).replace(",",".");  
        }else{
            this.HZRNSAN_SANCION_PUBLICA = String.valueOf(HZRNSAN_SANCION_PUBLICA);
        }
    }
    @XmlTransient
    public String getHZRNSAN_SANCION_PRIVADA() {
        return HZRNSAN_SANCION_PRIVADA;
    }

    public void setHZRNSAN_SANCION_PRIVADA(BigDecimal HZRNSAN_SANCION_PRIVADA) throws DataFormatException {
        if(HZRNSAN_SANCION_PRIVADA != null){
            this.HZRNSAN_SANCION_PRIVADA = new DecimalFormat("#.000000").format(HZRNSAN_SANCION_PRIVADA).replace(",",".");
        }else{
            this.HZRNSAN_SANCION_PRIVADA = String.valueOf(HZRNSAN_SANCION_PRIVADA);
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
