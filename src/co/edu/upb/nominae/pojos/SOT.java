package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNSOT_PAGO_TERCERO",
    "HZRNSOT_ANTICIPO",
    "HZRNSOT_OTRA_DEDUCCION"})
public class SOT {
    
    @XmlElement(name = "SOT_1")
    private String HZRNSOT_PAGO_TERCERO;
    @XmlElement(name = "SOT_2")
    private String HZRNSOT_ANTICIPO;
    @XmlElement(name = "SOT_3")
    private String HZRNSOT_OTRA_DEDUCCION;   
    private Integer HZRNSOT_ITS_ID;       

    @XmlTransient
    public String getHZRNSOT_PAGO_TERCERO() {
        return HZRNSOT_PAGO_TERCERO;
    }

    public void setHZRNSOT_PAGO_TERCERO(BigDecimal HZRNSOT_PAGO_TERCERO) {
        if(HZRNSOT_PAGO_TERCERO != null){
            this.HZRNSOT_PAGO_TERCERO = new DecimalFormat("#.000000").format(HZRNSOT_PAGO_TERCERO).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNSOT_ANTICIPO() {
        return HZRNSOT_ANTICIPO;
    }

    public void setHZRNSOT_ANTICIPO(BigDecimal HZRNSOT_ANTICIPO) {
        if(HZRNSOT_ANTICIPO != null){
            this.HZRNSOT_ANTICIPO = new DecimalFormat("#.000000").format(HZRNSOT_ANTICIPO).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNSOT_OTRA_DEDUCCION() {
        return HZRNSOT_OTRA_DEDUCCION;
    }

    public void setHZRNSOT_OTRA_DEDUCCION(BigDecimal HZRNSOT_OTRA_DEDUCCION) {
        if(HZRNSOT_OTRA_DEDUCCION != null){
            this.HZRNSOT_OTRA_DEDUCCION = new DecimalFormat("#.000000").format(HZRNSOT_OTRA_DEDUCCION).replace(",","."); 
        }
    }
    @XmlTransient
    public Integer getHZRNSOT_ITS_ID() {
        return HZRNSOT_ITS_ID;
    }

    public void setHZRNSOT_ITS_ID(Integer HZRNSOT_ITS_ID) {
        this.HZRNSOT_ITS_ID = HZRNSOT_ITS_ID;
    }

    @Override
    public String toString() {
        return "SOT{" + "HZRNSOT_PAGO_TERCERO=" + HZRNSOT_PAGO_TERCERO + ", HZRNSOT_ANTICIPO=" + HZRNSOT_ANTICIPO + ", HZRNSOT_OTRA_DEDUCCION=" + HZRNSOT_OTRA_DEDUCCION + ", HZRNSOT_ITS_ID=" + HZRNSOT_ITS_ID + '}';
    }

    
    
}
