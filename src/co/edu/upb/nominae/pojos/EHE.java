package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
 * Segmento Opcional. Utilizado para Atributos de Horas Extras. Este segmento es dependiente Ver Nota 3 
 * Puede repetirse hasta 100 veces por cada registro de Devengado  Basico(ITE). Ver nota 4
 */


@XmlType (propOrder={"HZRNEHE_HORAS_EXTRA",
    "HZRNEHE_HORA_INICIO",
    "HZRNEHE_HORA_FIN",
    "HZRNEHE_CANTIDAD",
    "HZRNEHE_PORCENTAJE",    
    "HZRNEHE_PAGO"})
public class EHE {
    
    @XmlElement(name = "EHE_1")
    private String HZRNEHE_HORAS_EXTRA;
    @XmlElement(name = "EHE_2")
    private String HZRNEHE_HORA_INICIO;
    @XmlElement(name = "EHE_3")
    private String HZRNEHE_HORA_FIN;
    @XmlElement(name = "EHE_4")
    private String HZRNEHE_CANTIDAD;
    @XmlElement(name = "EHE_5")
    private String HZRNEHE_PORCENTAJE;
    @XmlElement(name = "EHE_6")
    private String HZRNEHE_PAGO;
    private Integer HZRNEHE_ITE_ID;       

    @XmlTransient
    public String getHZRNEHE_HORAS_EXTRA() {
        return HZRNEHE_HORAS_EXTRA;
    }

    public void setHZRNEHE_HORAS_EXTRA(String HZRNEHE_HORAS_EXTRA) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEHE_HORAS_EXTRA,100)){
            this.HZRNEHE_HORAS_EXTRA = HZRNEHE_HORAS_EXTRA;
            data = null;            
        }else{
            throw new DataFormatException("EHE:HZRNEHE_HORAS_EXTRA:El campo es nulo o excede la longitud definida por la DIAN");
        }          
    }
    @XmlTransient
    public String getHZRNEHE_HORA_INICIO() {
        return HZRNEHE_HORA_INICIO;
    }

    public void setHZRNEHE_HORA_INICIO(String HZRNEHE_HORA_INICIO) {
        this.HZRNEHE_HORA_INICIO = HZRNEHE_HORA_INICIO;
    }
    @XmlTransient
    public String getHZRNEHE_HORA_FIN() {
        return HZRNEHE_HORA_FIN;
    }

    public void setHZRNEHE_HORA_FIN(String HZRNEHE_HORA_FIN) {
        this.HZRNEHE_HORA_FIN = HZRNEHE_HORA_FIN;
    }
    @XmlTransient
    public String getHZRNEHE_CANTIDAD() {
        return HZRNEHE_CANTIDAD;
    }

    public void setHZRNEHE_CANTIDAD(BigDecimal HZRNEHE_CANTIDAD) throws DataFormatException {
        if(HZRNEHE_CANTIDAD != null){
            this.HZRNEHE_CANTIDAD = new DecimalFormat("#.000000").format(HZRNEHE_CANTIDAD).replace(",",".");     
        }else{
            this.HZRNEHE_CANTIDAD = String.valueOf(HZRNEHE_CANTIDAD);
        } 
    }
    @XmlTransient
    public String getHZRNEHE_PORCENTAJE() {
        return HZRNEHE_PORCENTAJE;
    }

    public void setHZRNEHE_PORCENTAJE(BigDecimal HZRNEHE_PORCENTAJE) throws DataFormatException {     
        if(HZRNEHE_PORCENTAJE != null){
            this.HZRNEHE_PORCENTAJE = new DecimalFormat("#.00").format(HZRNEHE_PORCENTAJE).replace(",",".");
        }else{
            this.HZRNEHE_PORCENTAJE = String.valueOf(HZRNEHE_PORCENTAJE);
        } 
    }
    @XmlTransient
    public String getHZRNEHE_PAGO() {
        return HZRNEHE_PAGO;
    }

    public void setHZRNEHE_PAGO(BigDecimal HZRNEHE_PAGO) throws DataFormatException {
        if(HZRNEHE_PAGO != null){
            this.HZRNEHE_PAGO = new DecimalFormat("#.000000").format(HZRNEHE_PAGO).replace(",",".");   
        }else{
            this.HZRNEHE_PAGO = String.valueOf(HZRNEHE_PAGO);
        } 
    }
    @XmlTransient
    public Integer getHZRNEHE_ITE_ID() {
        return HZRNEHE_ITE_ID;
    }

    public void setHZRNEHE_ITE_ID(Integer HZRNEHE_ITE_ID) {
        this.HZRNEHE_ITE_ID = HZRNEHE_ITE_ID;
    }

    @Override
    public String toString() {
        return "EHE{" + "HZRNEHE_HORAS_EXTRA=" + HZRNEHE_HORAS_EXTRA + ", HZRNEHE_HORA_INICIO=" + HZRNEHE_HORA_INICIO + ", HZRNEHE_HORA_FIN=" + HZRNEHE_HORA_FIN + ", HZRNEHE_CANTIDAD=" + HZRNEHE_CANTIDAD + ", HZRNEHE_PORCENTAJE=" + HZRNEHE_PORCENTAJE + ", HZRNEHE_PAGO=" + HZRNEHE_PAGO + ", HZRNEHE_ITE_ID=" + HZRNEHE_ITE_ID + '}';
    }

}
