package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "SLI")
@XmlType (propOrder={"HZRNSLI_DESCRIPCION",
    "HZRNSLI_DEDUCCION"})

public class SLI {
    
    @XmlElement(name = "SLI_1")
    private String HZRNSLI_DESCRIPCION;
    @XmlElement(name = "SLI_2")
    private Double HZRNSLI_DEDUCCION;    
    private Integer HZRNSLI_ITS_ID;     

    @XmlTransient
    public String getHZRNSLI_DESCRIPCION() {
        return HZRNSLI_DESCRIPCION;
    }

    public void setHZRNSLI_DESCRIPCION(String HZRNSLI_DESCRIPCION) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNSLI_DESCRIPCION,14)){
            this.HZRNSLI_DESCRIPCION = HZRNSLI_DESCRIPCION;
            data = null;            
        }else{
            throw new DataFormatException("SLI:HZRNSLI_DESCRIPCION:El campo es nulo");
        }          
    }
    @XmlTransient
    public Double getHZRNSLI_DEDUCCION() {
        return HZRNSLI_DEDUCCION;
    }

    public void setHZRNSLI_DEDUCCION(Double HZRNSLI_DEDUCCION) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNSLI_DEDUCCION,15,6)){
            this.HZRNSLI_DEDUCCION = HZRNSLI_DEDUCCION;
            data = null;            
        }else{
            throw new DataFormatException("SLI:HZRNSLI_DEDUCCION:El campo es nulo");
        }          
    }
    @XmlTransient
    public Integer getHZRNSLI_ITS_ID() {
        return HZRNSLI_ITS_ID;
    }

    public void setHZRNSLI_ITS_ID(Integer HZRNSLI_ITS_ID) {
        this.HZRNSLI_ITS_ID = HZRNSLI_ITS_ID;
    }

    @Override
    public String toString() {
        return "SLI{" + "HZRNSLI_DESCRIPCION=" + HZRNSLI_DESCRIPCION + ", HZRNSLI_DEDUCCION=" + HZRNSLI_DEDUCCION + ", HZRNSLI_ITS_ID=" + HZRNSLI_ITS_ID + '}';
    }
    
}
