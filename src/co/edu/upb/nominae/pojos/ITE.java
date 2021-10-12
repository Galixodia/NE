package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNITE_DIAS_TRAB",
    "HZRNITE_SUELDO_TRAB",
    "transporte_pagado_trab",
    "horas_extras_trab",
    "vacaciones_trabajador",
    "vacaciones_comp_trab",
    "primas_trab",
    "cesantias_trab",
    "incapacidades_trab",
    "licencia_mat_pat",
    "licencia_remunerada",
    "licencia_no_remunerada",
    "bonificacion_para_trab",
    "auxilio_trab",
    "otros_conceptos_trab",
    "compensaciones_dev_trab",
    "pago_terceros_anticipos_nom",
    "opciones_varias_devengados"})
public class ITE {
    
    @XmlElement(name = "ITE_1")
    private String HZRNITE_DIAS_TRAB;
    @XmlElement(name = "ITE_2")
    private String HZRNITE_SUELDO_TRAB;    
    
    private String HZRNITE_CUNE_INTERNO;    
    private Integer HZRNITE_ID;    

    @XmlElement(name = "ETR")
    public List<ETR> transporte_pagado_trab = Arrays.asList(new ETR[50]);
    @XmlElement(name = "EHE")
    public List<EHE> horas_extras_trab = Arrays.asList(new EHE[100]);
    @XmlElement(name = "EVC")
    public List<EVC> vacaciones_trabajador = Arrays.asList(new EVC[50]);
    @XmlElement(name = "EVA")
    public List<EVA> vacaciones_comp_trab = Arrays.asList(new EVA[50]);
    @XmlElement(name = "EPR")
    private EPR primas_trab;
    @XmlElement(name = "ECE")
    private ECE cesantias_trab;
    @XmlElement(name = "EIN")
    public List<EIN> incapacidades_trab = Arrays.asList(new EIN[50]);
    @XmlElement(name = "ELI")
    public List<ELI> licencia_mat_pat = Arrays.asList(new ELI[50]);
    @XmlElement(name = "ELR")
    public List<ELR> licencia_remunerada = Arrays.asList(new ELR[50]);
    @XmlElement(name = "ELN")
    public List<ELN> licencia_no_remunerada = Arrays.asList(new ELN[50]);
    @XmlElement(name = "EBN")
    public List<EBN> bonificacion_para_trab = Arrays.asList(new EBN[50]);
    @XmlElement(name = "EAX")
    public List<EAX> auxilio_trab = Arrays.asList(new EAX[50]);
    //@XmlElement(name = "EHL")
    //public List<EHL> huelgas_legales = null;
    @XmlElement(name = "EOT")
    public List<EOT> otros_conceptos_trab = Arrays.asList(new EOT[50]);
    @XmlElement(name = "ECM")
    public List<ECM> compensaciones_dev_trab = Arrays.asList(new ECM[50]);
    //@XmlElement(name = "EBO")
    //public List<EBO> bonos_pagados_electro = null;
    @XmlElement(name = "ECO")
    public List<ECO> pago_terceros_anticipos_nom = Arrays.asList(new ECO[50]);
    @XmlElement(name = "EVO")
    private EVO opciones_varias_devengados;

    
    @XmlTransient
    public String getHZRNITE_DIAS_TRAB() {
        return HZRNITE_DIAS_TRAB;
    }

    public void setHZRNITE_DIAS_TRAB(String HZRNITE_DIAS_TRAB) throws DataFormatException {
        Data data = new Data();        
  
        if(data.checklength(HZRNITE_DIAS_TRAB,2)){
            this.HZRNITE_DIAS_TRAB = HZRNITE_DIAS_TRAB;
            data = null;            
        }else{
            throw new DataFormatException("ITE:HZRNITE_DIAS_TRAB:El campo es nulo o excede la longitud definida por la DIAN");
        }    
    }
    @XmlTransient
    public String getHZRNITE_SUELDO_TRAB() {
        return HZRNITE_SUELDO_TRAB;
    }

    public void setHZRNITE_SUELDO_TRAB(BigDecimal HZRNITE_SUELDO_TRAB) throws DataFormatException {  
        if(HZRNITE_SUELDO_TRAB != null){
            this.HZRNITE_SUELDO_TRAB = new DecimalFormat("0.000000").format(HZRNITE_SUELDO_TRAB).replace(",",".");  
        }else{
            this.HZRNITE_SUELDO_TRAB = String.valueOf(HZRNITE_SUELDO_TRAB);
        }
    }
    @XmlTransient
    public String getHZRNITE_CUNE_INTERNO() {
        return HZRNITE_CUNE_INTERNO;
    }

    public void setHZRNITE_CUNE_INTERNO(String HZRNITE_CUNE_INTERNO) {
        this.HZRNITE_CUNE_INTERNO = HZRNITE_CUNE_INTERNO;
    }
    @XmlTransient
    public Integer getHZRNITE_ID() {
        return HZRNITE_ID;
    }

    public void setHZRNITE_ID(Integer HZRNITE_ID) {
        this.HZRNITE_ID = HZRNITE_ID;
    }
    @XmlTransient
    public EPR getPrimas_trab() {
        return primas_trab;
    }

    public void setPrimas_trab(EPR primas_trab) {
        this.primas_trab = primas_trab;
    }
    @XmlTransient
    public ECE getCesantias_trab() {
        return cesantias_trab;
    }

    public void setCesantias_trab(ECE cesantias_trab) {
        this.cesantias_trab = cesantias_trab;
    }
    @XmlTransient
    public EVO getOpciones_varias_devengados() {
        return opciones_varias_devengados;
    }

    public void setOpciones_varias_devengados(EVO opciones_varias_devengados) {
        this.opciones_varias_devengados = opciones_varias_devengados;
    }

    @Override
    public String toString() {
        return "ITE{" + "HZRNITE_DIAS_TRAB=" + HZRNITE_DIAS_TRAB + ", HZRNITE_SUELDO_TRAB=" + HZRNITE_SUELDO_TRAB + ", HZRNITE_CUNE_INTERNO=" + HZRNITE_CUNE_INTERNO + ", HZRNITE_ID=" + HZRNITE_ID + ", transporte_pagado_trab=" + transporte_pagado_trab + ", horas_extras_trab=" + horas_extras_trab + ", vacaciones_trabajador=" + vacaciones_trabajador + ", vacaciones_comp_trab=" + vacaciones_comp_trab + ", primas_trab=" + primas_trab + ", cesantias_trab=" + cesantias_trab + ", incapacidades_trab=" + incapacidades_trab + ", licencia_mat_pat=" + licencia_mat_pat + ", licencia_remunerada=" + licencia_remunerada + ", licencia_no_remunerada=" + licencia_no_remunerada + ", bonificacion_para_trab=" + bonificacion_para_trab + ", auxilio_trab=" + auxilio_trab + ", otros_conceptos_trab=" + otros_conceptos_trab + ", compensaciones_dev_trab=" + compensaciones_dev_trab + ", pago_terceros_anticipos_nom=" + pago_terceros_anticipos_nom + ", opciones_varias_devengados=" + opciones_varias_devengados + '}';
    }
    
    
   
}
