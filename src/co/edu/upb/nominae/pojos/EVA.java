package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author 000329744 Xiomara Torrez Muñoz
 * @since 00/09/2021
 * @version 1.0
 *
 * Segmento  Opcional. Utilizado para Atributos de Vacaciones Compensadas del Documento. Este segmento es dependiente Ver Nota 3
 * Puede repetirse hasta 50 veces por cada registro de Devengado  Basico(ITE). Ver nota 4
 */

//@XmlRootElement(name = "EVA")
@XmlType (propOrder={"HZRNEVA_CANTIDAD",
    "HZRNEVA_PAGO"})

public class EVA {
    
    @XmlElement(name = "EVA_1")
    private Long HZRNEVA_CANTIDAD;
    @XmlElement(name = "EVA_2")
    private Double HZRNEVA_PAGO;   
    private Integer HZRNEVA_ITE_ID;        

    @XmlTransient
    public Long getHZRNEVA_CANTIDAD() {
        return HZRNEVA_CANTIDAD;
    }

    public void setHZRNEVA_CANTIDAD(Long HZRNEVA_CANTIDAD) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEVA_CANTIDAD,10)){
            this.HZRNEVA_CANTIDAD = HZRNEVA_CANTIDAD;
            data = null;            
        }else{
            throw new DataFormatException("EVA:HZRNEVA_CANTIDAD:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public Double getHZRNEVA_PAGO() {
        return HZRNEVA_PAGO;
    }

    public void setHZRNEVA_PAGO(Double HZRNEVA_PAGO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEVA_PAGO,15,6)){
            this.HZRNEVA_PAGO = HZRNEVA_PAGO;
            data = null;            
        }else{
            throw new DataFormatException("EVA:HZRNEVA_PAGO:El campo es nulo o excede la longitud definida por la DIAN");
        }         
    }
    @XmlTransient
    public Integer getHZRNEVA_ITE_ID() {
        return HZRNEVA_ITE_ID;
    }

    public void setHZRNEVA_ITE_ID(Integer HZRNEVA_ITE_ID) {
        this.HZRNEVA_ITE_ID = HZRNEVA_ITE_ID;
    }

    @Override
    public String toString() {
        return "EVA{" + "HZRNEVA_CANTIDAD=" + HZRNEVA_CANTIDAD + ", HZRNEVA_PAGO=" + HZRNEVA_PAGO + ", HZRNEVA_ITE_ID=" + HZRNEVA_ITE_ID + '}';
    }

 
}
