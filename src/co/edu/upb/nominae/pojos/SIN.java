package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNSIN_PORCENTAJE",
    "HZRNSIN_DEDUCCION"})
public class SIN {
    
    @XmlElement(name = "SIN_1")
    private BigDecimal HZRNSIN_PORCENTAJE;
    @XmlElement(name = "SIN_2")
    private BigDecimal HZRNSIN_DEDUCCION;
    private Integer HZRNSIN_ITS_ID;       

    @XmlTransient
    public BigDecimal getHZRNSIN_PORCENTAJE() {
        return HZRNSIN_PORCENTAJE;
    }

    public void setHZRNSIN_PORCENTAJE(BigDecimal HZRNSIN_PORCENTAJE) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNSIN_PORCENTAJE,3,2)){
            this.HZRNSIN_PORCENTAJE = HZRNSIN_PORCENTAJE;
            data = null;            
        }else{
            throw new DataFormatException("SIN:HZRNSIN_PORCENTAJE:El campo es nulo o excede la longitud definida por la DIAN");
        }           
    }
    @XmlTransient
    public BigDecimal getHZRNSIN_DEDUCCION() {
        return HZRNSIN_DEDUCCION;
    }

    public void setHZRNSIN_DEDUCCION(BigDecimal HZRNSIN_DEDUCCION) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNSIN_DEDUCCION,15,6)){
            this.HZRNSIN_DEDUCCION = HZRNSIN_DEDUCCION;
            data = null;            
        }else{
            throw new DataFormatException("SIN:HZRNSIN_DEDUCCION:El campo es nulo o excede la longitud definida por la DIAN");
        }         
    }
    @XmlTransient
    public Integer getHZRNSIN_ITS_ID() {
        return HZRNSIN_ITS_ID;
    }

    public void setHZRNSIN_ITS_ID(Integer HZRNSIN_ITS_ID) {
        this.HZRNSIN_ITS_ID = HZRNSIN_ITS_ID;
    }

    @Override
    public String toString() {
        return "SIN{" + "HZRNSIN_PORCENTAJE=" + HZRNSIN_PORCENTAJE + ", HZRNSIN_DEDUCCION=" + HZRNSIN_DEDUCCION + ", HZRNSIN_ITS_ID=" + HZRNSIN_ITS_ID + '}';
    }
    
}
