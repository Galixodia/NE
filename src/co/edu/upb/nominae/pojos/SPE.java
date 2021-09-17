package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "SPE")
@XmlType (propOrder={"HZRNSPE_PORCENTAJE",
    "HZRNSPE_DEDUCCION"})

public class SPE {
    
    @XmlElement(name = "SPE_1")
    private Double HZRNSPE_PORCENTAJE;
    @XmlElement(name = "SPE_2")
    private Double HZRNSPE_DEDUCCION;
    private Integer HZRNSPE_ITS_ID;      

    @XmlTransient
    public Double getHZRNSPE_PORCENTAJE() {
        return HZRNSPE_PORCENTAJE;
    }

    public void setHZRNSPE_PORCENTAJE(Double HZRNSPE_PORCENTAJE) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNSPE_PORCENTAJE,3,2)){
            this.HZRNSPE_PORCENTAJE = HZRNSPE_PORCENTAJE;
            data = null;            
        }else{
            throw new DataFormatException("SPE:HZRNSPE_PORCENTAJE:El campo es nulo");
        }          
    }
    @XmlTransient
    public Double getHZRNSPE_DEDUCCION() {
        return HZRNSPE_DEDUCCION;
    }

    public void setHZRNSPE_DEDUCCION(Double HZRNSPE_DEDUCCION) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNSPE_DEDUCCION,15,6)){
            this.HZRNSPE_DEDUCCION = HZRNSPE_DEDUCCION;
            data = null;            
        }else{
            throw new DataFormatException("SPE:HZRNSPE_DEDUCCION:El campo es nulo");
        }          
    }
    @XmlTransient
    public Integer getHZRNSPE_ITS_ID() {
        return HZRNSPE_ITS_ID;
    }

    public void setHZRNSPE_ITS_ID(Integer HZRNSPE_ITS_ID) {
        this.HZRNSPE_ITS_ID = HZRNSPE_ITS_ID;
    }

    @Override
    public String toString() {
        return "SPE{" + "HZRNSPE_PORCENTAJE=" + HZRNSPE_PORCENTAJE + ", HZRNSPE_DEDUCCION=" + HZRNSPE_DEDUCCION + ", HZRNSPE_ITS_ID=" + HZRNSPE_ITS_ID + '}';
    }

    
}
