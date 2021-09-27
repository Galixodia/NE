package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNECO_COMISION",
    "HZRNECO_PAGO_TERCERO",
    "HZRNECO_ANTICIPOS_NOMINA"})
public class ECO {
    
    @XmlElement(name = "ECO_1")
    private String HZRNECO_COMISION;
    @XmlElement(name = "ECO_2")
    private String HZRNECO_PAGO_TERCERO;
    @XmlElement(name = "ECO_3")
    private String HZRNECO_ANTICIPOS_NOMINA;
    private Integer HZRNECO_ITE_ID;   

    @XmlTransient
    public String getHZRNECO_COMISION() {
        return HZRNECO_COMISION;
    }

    public void setHZRNECO_COMISION(BigDecimal HZRNECO_COMISION) {
        if(HZRNECO_COMISION != null){
            this.HZRNECO_COMISION = new DecimalFormat("#.000000").format(HZRNECO_COMISION).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNECO_PAGO_TERCERO() {
        return HZRNECO_PAGO_TERCERO;
    }

    public void setHZRNECO_PAGO_TERCERO(BigDecimal HZRNECO_PAGO_TERCERO) {       
        if(HZRNECO_PAGO_TERCERO != null){
            this.HZRNECO_PAGO_TERCERO = new DecimalFormat("#.000000").format(HZRNECO_PAGO_TERCERO).replace(",","."); 
        }
    }
    @XmlTransient
    public String getHZRNECO_ANTICIPOS_NOMINA() {
        return HZRNECO_ANTICIPOS_NOMINA;
    }

    public void setHZRNECO_ANTICIPOS_NOMINA(BigDecimal HZRNECO_ANTICIPOS_NOMINA) {
        if(HZRNECO_ANTICIPOS_NOMINA != null){
            this.HZRNECO_ANTICIPOS_NOMINA = new DecimalFormat("#.000000").format(HZRNECO_ANTICIPOS_NOMINA).replace(",",".");  
        }
    }
    @XmlTransient
    public Integer getHZRNECO_ITE_ID() {
        return HZRNECO_ITE_ID;
    }

    public void setHZRNECO_ITE_ID(Integer HZRNECO_ITE_ID) {
        this.HZRNECO_ITE_ID = HZRNECO_ITE_ID;
    }

    @Override
    public String toString() {
        return "ECO{" + "HZRNECO_COMISION=" + HZRNECO_COMISION + ", HZRNECO_PAGO_TERCERO=" + HZRNECO_PAGO_TERCERO + ", HZRNECO_ANTICIPOS_NOMINA=" + HZRNECO_ANTICIPOS_NOMINA + ", HZRNECO_ITE_ID=" + HZRNECO_ITE_ID + '}';
    }

}
