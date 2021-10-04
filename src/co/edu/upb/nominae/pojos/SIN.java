package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNSIN_PORCENTAJE",
    "HZRNSIN_DEDUCCION"})
public class SIN {
    
    @XmlElement(name = "SIN_1")
    private String HZRNSIN_PORCENTAJE;
    @XmlElement(name = "SIN_2")
    private String HZRNSIN_DEDUCCION;
    private Integer HZRNSIN_ITS_ID;       

    @XmlTransient
    public String getHZRNSIN_PORCENTAJE() {
        return HZRNSIN_PORCENTAJE;
    }

    public void setHZRNSIN_PORCENTAJE(BigDecimal HZRNSIN_PORCENTAJE) throws DataFormatException {       
        if(HZRNSIN_PORCENTAJE != null){
            this.HZRNSIN_PORCENTAJE = new DecimalFormat("0.00").format(HZRNSIN_PORCENTAJE).replace(",",".");
        }else{
            throw new DataFormatException("SIN:HZRNSIN_PORCENTAJE:El campo es nulo o excede la longitud definida por la DIAN");
        }
    }
    @XmlTransient
    public String getHZRNSIN_DEDUCCION() {
        return HZRNSIN_DEDUCCION;
    }

    public void setHZRNSIN_DEDUCCION(BigDecimal HZRNSIN_DEDUCCION) throws DataFormatException {       
        if(HZRNSIN_DEDUCCION != null){
            this.HZRNSIN_DEDUCCION = new DecimalFormat("0.000000").format(HZRNSIN_DEDUCCION).replace(",",".");
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
