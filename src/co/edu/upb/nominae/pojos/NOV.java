package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNNOV_NOVEDAD",
    "HZRNNOV_CUNE_NOV"})
public class NOV {
    private String HZRNNOV_CUNE_INTERNO;
    @XmlElement(name="NOV_1")
    private String      HZRNNOV_NOVEDAD;
    @XmlElement(name="NOV_2")
    private String      HZRNNOV_CUNE_NOV;

    
   @XmlTransient
    public String getHZRNNOV_CUNE_INTERNO() {
        return HZRNNOV_CUNE_INTERNO;
    }

    public void setHZRNNOV_CUNE_INTERNO(String HZRNNOV_CUNE_INTERNO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNNOV_CUNE_INTERNO,16)){
            this.HZRNNOV_CUNE_INTERNO = HZRNNOV_CUNE_INTERNO;
            data = null;            
        }else{
            throw new DataFormatException("NOV:" + HZRNNOV_CUNE_INTERNO + ":HZRNNOV_CUNE_INTERNO:El campo es nulo o excede la longitud definida por la DIAN");
        }         
    }
    @XmlTransient
    public String getHZRNNOV_NOVEDAD() {
        return HZRNNOV_NOVEDAD;
    }

    public void setHZRNNOV_NOVEDAD(String HZRNNOV_NOVEDAD) throws DataFormatException {
        this.HZRNNOV_NOVEDAD = HZRNNOV_NOVEDAD;      
    }
    @XmlTransient
    public String getHZRNNOV_CUNE_NOV() {
        return HZRNNOV_CUNE_NOV;
    }

    public void setHZRNNOV_CUNE_NOV(String HZRNNOV_CUNE_NOV) throws DataFormatException {
        Data data = new Data();   
        if(data.checklength(HZRNNOV_CUNE_NOV,96)){
            this.HZRNNOV_CUNE_NOV = HZRNNOV_CUNE_NOV;
            data = null;            
        }else{
            throw new DataFormatException("NOV:" + HZRNNOV_CUNE_NOV + ":HZRNNOV_CUNE_NOV:El campo es nulo o excede la longitud definida por la DIAN");
        }           
    }

    @Override
    public String toString() {
        return "NOV{" + "HZRNNOV_CUNE_INTERNO=" + HZRNNOV_CUNE_INTERNO + ", HZRNNOV_NOVEDAD=" + HZRNNOV_NOVEDAD + ", HZRNNOV_CUNE_NOV=" + HZRNNOV_CUNE_NOV + '}';
    }
  
    
    
    
}
