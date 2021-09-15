package co.edu.upb.nominae.pojos;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author 000329744 Xiomara Torrez Muñoz
 * @since 00/09/2021
 * @version 1.0
 * 
 * Segmento Obligatorio. Puede repetirse hasta 50 veces en el archivo. Ver nota 4
 * Utilizado para Todos los Elementos de Fechas de Pagos del Documento. Este Segemento es dependiente Ver Nota 3
 */

//@XmlRootElement(name = "FEP")
@XmlType (propOrder={"HZRNFEP_FECHA_PAGO"})

public class FEP {
    
    private String HZRNFEP_CUNE_INTERNO;    
    @XmlElement(name = "FEP_1")
    private Date HZRNFEP_FECHA_PAGO;
    @XmlTransient
    public String getHZRNFEP_CUNE_INTERNO() {
        return HZRNFEP_CUNE_INTERNO;
    }

    public void setHZRNFEP_CUNE_INTERNO(String HZRNFEP_CUNE_INTERNO) {
        this.HZRNFEP_CUNE_INTERNO = HZRNFEP_CUNE_INTERNO;
    }
    @XmlTransient
    public Date getHZRNFEP_FECHA_PAGO() {
        return HZRNFEP_FECHA_PAGO;
    }

    public void setHZRNFEP_FECHA_PAGO(Date HZRNFEP_FECHA_PAGO) {
        this.HZRNFEP_FECHA_PAGO = HZRNFEP_FECHA_PAGO;
    }

    @Override
    public String toString() {
        return "FEP{" + "HZRNFEP_CUNE_INTERNO=" + HZRNFEP_CUNE_INTERNO + ", HZRNFEP_FECHA_PAGO=" + HZRNFEP_FECHA_PAGO + '}';
    }
   
}
