package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.util.Date;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNEHL_FECHA_INICIO",
    "HZRNEHL_FECHA_FIN",
    "HZRNEHL_CANTIDAD"})
public class EHL {
    
    @XmlElement(name = "EHL_1")
    private String HZRNEHL_FECHA_INICIO;
    @XmlElement(name = "EHL_2")
    private String HZRNEHL_FECHA_FIN;
    @XmlElement(name = "EHL_3")
    private Long HZRNEHL_CANTIDAD;
    private Integer HZRNEHL_ITE_ID;       

    @XmlTransient
    public String getHZRNEHL_FECHA_INICIO() {
        return HZRNEHL_FECHA_INICIO;
    }

    public void setHZRNEHL_FECHA_INICIO(String HZRNEHL_FECHA_INICIO) {
        this.HZRNEHL_FECHA_INICIO = HZRNEHL_FECHA_INICIO;
    }
    @XmlTransient
    public String getHZRNEHL_FECHA_FIN() {
        return HZRNEHL_FECHA_FIN;
    }

    public void setHZRNEHL_FECHA_FIN(String HZRNEHL_FECHA_FIN) {
        this.HZRNEHL_FECHA_FIN = HZRNEHL_FECHA_FIN;
    }
    @XmlTransient
    public Long getHZRNEHL_CANTIDAD() {
        return HZRNEHL_CANTIDAD;
    }

    public void setHZRNEHL_CANTIDAD(Long HZRNEHL_CANTIDAD) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEHL_CANTIDAD,10)){
            this.HZRNEHL_CANTIDAD = HZRNEHL_CANTIDAD;
            data = null;            
        }else{
            throw new DataFormatException("EHL:HZRNEHL_CANTIDAD:El campo es nulo o excede la longitud definida por la DIAN");
        }            
    }
    @XmlTransient
    public Integer getHZRNEHL_ITE_ID() {
        return HZRNEHL_ITE_ID;
    }

    public void setHZRNEHL_ITE_ID(Integer HZRNEHL_ITE_ID) {
        this.HZRNEHL_ITE_ID = HZRNEHL_ITE_ID;
    }

    @Override
    public String toString() {
        return "EHL{" + "HZRNEHL_FECHA_INICIO=" + HZRNEHL_FECHA_INICIO + ", HZRNEHL_FECHA_FIN=" + HZRNEHL_FECHA_FIN + ", HZRNEHL_CANTIDAD=" + HZRNEHL_CANTIDAD + ", HZRNEHL_ITE_ID=" + HZRNEHL_ITE_ID + '}';
    }

 
}
