package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNSPE_PORCENTAJE",
    "HZRNSPE_DEDUCCION"})
public class SPE {
    
    @XmlElement(name = "SPE_1")
    private String HZRNSPE_PORCENTAJE;
    @XmlElement(name = "SPE_2")
    private String HZRNSPE_DEDUCCION;
    private Integer HZRNSPE_ITS_ID;      

    @XmlTransient
    public String getHZRNSPE_PORCENTAJE() {
        return HZRNSPE_PORCENTAJE;
    }

    public void setHZRNSPE_PORCENTAJE(BigDecimal HZRNSPE_PORCENTAJE) throws DataFormatException {
        if(HZRNSPE_PORCENTAJE != null){
            this.HZRNSPE_PORCENTAJE = new DecimalFormat("#.00").format(HZRNSPE_PORCENTAJE).replace(",",".");  
        }else{
            throw new DataFormatException("SPE:HZRNSPE_PORCENTAJE:El campo es nulo o excede la longitud definida por la DIAN");
        } 
    }
    @XmlTransient
    public String getHZRNSPE_DEDUCCION() {
        return HZRNSPE_DEDUCCION;
    }

    public void setHZRNSPE_DEDUCCION(BigDecimal HZRNSPE_DEDUCCION) throws DataFormatException {   
        if(HZRNSPE_DEDUCCION != null){
            this.HZRNSPE_DEDUCCION = new DecimalFormat("#.000000").format(HZRNSPE_DEDUCCION).replace(",",".");
        }else{
            throw new DataFormatException("SPE:HZRNSPE_DEDUCCION:El campo es nulo o excede la longitud definida por la DIAN");
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
