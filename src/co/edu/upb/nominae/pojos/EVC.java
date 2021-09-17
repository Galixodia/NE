package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.util.Date;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author 000329744 Xiomara Torrez Muñoz
 * @since 00/09/2021
 * @version 1.0
 * Segmento Opcional. Utilizado para Atributos de Vacaciones Comunes del Documento. Este segmento es dependiente Ver Nota 3
 * Puede repetirse hasta 50 veces por cada registro de Devengado  Basico(ITE). Ver nota 4
 */

//@XmlRootElement(name = "EVC")
@XmlType (propOrder={"HZRNEVC_FECHA_INICIO",
    "HZRNEVC_FECHA_FIN",
    "HZRNEVC_CANTIDAD",
    "HZRNEVC_PAGO"})

public class EVC {
    
    @XmlElement(name = "EVC_1")
    private Date HZRNEVC_FECHA_INICIO;
    @XmlElement(name = "EVC_2")
    private Date HZRNEVC_FECHA_FIN;
    @XmlElement(name = "EVC_3")
    private Long HZRNEVC_CANTIDAD;
    @XmlElement(name = "EVC_4")
    private Double HZRNEVC_PAGO;
    private Integer HZRNEVC_ITE_ID;

    @XmlTransient
    public Date getHZRNEVC_FECHA_INICIO() {
        return HZRNEVC_FECHA_INICIO;
    }

    public void setHZRNEVC_FECHA_INICIO(Date HZRNEVC_FECHA_INICIO) {
        this.HZRNEVC_FECHA_INICIO = HZRNEVC_FECHA_INICIO;
    }
    @XmlTransient
    public Date getHZRNEVC_FECHA_FIN() {
        return HZRNEVC_FECHA_FIN;
    }

    public void setHZRNEVC_FECHA_FIN(Date HZRNEVC_FECHA_FIN) {
        this.HZRNEVC_FECHA_FIN = HZRNEVC_FECHA_FIN;
    }
    @XmlTransient
    public Long getHZRNEVC_CANTIDAD() {
        return HZRNEVC_CANTIDAD;
    }

    public void setHZRNEVC_CANTIDAD(Long HZRNEVC_CANTIDAD) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEVC_CANTIDAD,10)){
            this.HZRNEVC_CANTIDAD = HZRNEVC_CANTIDAD;
            data = null;            
        }else{
            throw new DataFormatException("EVC:HZRNEVC_CANTIDAD:El campo es nulo");
        }          
    }
    @XmlTransient
    public Double getHZRNEVC_PAGO() {
        return HZRNEVC_PAGO;
    }

    public void setHZRNEVC_PAGO(Double HZRNEVC_PAGO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEVC_PAGO,15,6)){
            this.HZRNEVC_PAGO = HZRNEVC_PAGO;
            data = null;            
        }else{
            throw new DataFormatException("EVC:HZRNEVC_PAGO:El campo es nulo");
        }         
        
    }
    @XmlTransient
    public Integer getHZRNEVC_ITE_ID() {
        return HZRNEVC_ITE_ID;
    }

    public void setHZRNEVC_ITE_ID(Integer HZRNEVC_ITE_ID) {
        this.HZRNEVC_ITE_ID = HZRNEVC_ITE_ID;
    }

    @Override
    public String toString() {
        return "EVC{" + "HZRNEVC_FECHA_INICIO=" + HZRNEVC_FECHA_INICIO + ", HZRNEVC_FECHA_FIN=" + HZRNEVC_FECHA_FIN + ", HZRNEVC_CANTIDAD=" + HZRNEVC_CANTIDAD + ", HZRNEVC_PAGO=" + HZRNEVC_PAGO + ", HZRNEVC_ITE_ID=" + HZRNEVC_ITE_ID + '}';
    }

    
    
}
