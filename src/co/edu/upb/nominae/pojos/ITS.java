package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNITS_PORCENTAJE",
    "HZRNITS_DEDUCCION",
    "deducciones_pension",
    "deduc_fondo_seguridad_p",
    "deduc_pension",
    "deduc_sindicatos",
    "deduc_libranza",
    "otras_deduc",
    "deduc_varias"})
public class ITS {
    
    @XmlElement(name = "ITS_1")
    private String HZRNITS_PORCENTAJE;
    @XmlElement(name = "ITS_2")
    private String HZRNITS_DEDUCCION;
    
    private String HZRNITS_CUNE_INTERNO;
    private Integer HZRNITS_ID;
    
    @XmlElement(name = "SPE")
    private SPE deducciones_pension;
    @XmlElement(name = "SSP")
    private SSP deduc_fondo_seguridad_p;
    @XmlElement(name = "SPE")
    public List<SPE> deduc_pension = Arrays.asList(new SPE[50]);
    @XmlElement(name = "SIN")
    public List<SIN> deduc_sindicatos = Arrays.asList(new SIN[50]);
    //@XmlElement(name = "SAN")
    //public List<SAN> deduc_sanciones = null;
    @XmlElement(name = "SLI")
    public List<SLI> deduc_libranza = Arrays.asList(new SLI[50]);
    @XmlElement(name = "SOT")
    public List<SOT> otras_deduc = Arrays.asList(new SOT[50]);
    @XmlElement(name = "SVA")
    private SVA deduc_varias;

    
    @XmlTransient
    public String getHZRNITS_PORCENTAJE() {
        return HZRNITS_PORCENTAJE;
    }

    public void setHZRNITS_PORCENTAJE(BigDecimal HZRNITS_PORCENTAJE) throws DataFormatException {   
        if(HZRNITS_PORCENTAJE != null){
            this.HZRNITS_PORCENTAJE = new DecimalFormat("0.00").format(HZRNITS_PORCENTAJE).replace(",",".");  
        }else{
            throw new DataFormatException("ITS:HZRNITS_PORCENTAJE:El campo es nulo o excede la longitud definida por la DIAN");
        }
    }
    @XmlTransient
    public String getHZRNITS_DEDUCCION() {
        return HZRNITS_DEDUCCION;
    }

    public void setHZRNITS_DEDUCCION(BigDecimal HZRNITS_DEDUCCION) throws DataFormatException {
        if(HZRNITS_DEDUCCION != null){
            this.HZRNITS_DEDUCCION = new DecimalFormat("0.000000").format(HZRNITS_DEDUCCION).replace(",","."); 
        }else{
            throw new DataFormatException("ITS:HZRNITS_DEDUCCION:El campo es nulo o excede la longitud definida por la DIAN");
        }
    }
    @XmlTransient
    public String getHZRNITS_CUNE_INTERNO() {
        return HZRNITS_CUNE_INTERNO;
    }

    public void setHZRNITS_CUNE_INTERNO(String HZRNITS_CUNE_INTERNO) {
        this.HZRNITS_CUNE_INTERNO = HZRNITS_CUNE_INTERNO;
    }
    @XmlTransient
    public Integer getHZRNITS_ID() {
        return HZRNITS_ID;
    }

    public void setHZRNITS_ID(Integer HZRNITS_ID) {
        this.HZRNITS_ID = HZRNITS_ID;
    }
  
    @XmlTransient
    public SPE getDeducciones_pension() {
        return deducciones_pension;
    }

    public void setDeducciones_pension(SPE deducciones_pension) {
        this.deducciones_pension = deducciones_pension;
    }
    @XmlTransient
    public SSP getDeduc_fondo_seguridad_p() {
        return deduc_fondo_seguridad_p;
    }

    public void setDeduc_fondo_seguridad_p(SSP deduc_fondo_seguridad_p) {
        this.deduc_fondo_seguridad_p = deduc_fondo_seguridad_p;
    }
    @XmlTransient
    public SVA getDeduc_varias() {
        return deduc_varias;
    }

    public void setDeduc_varias(SVA deduc_varias) {
        this.deduc_varias = deduc_varias;
    }

    @Override
    public String toString() {
        return "ITS{" + "HZRNITS_PORCENTAJE=" + HZRNITS_PORCENTAJE + ", HZRNITS_DEDUCCION=" + HZRNITS_DEDUCCION + ", HZRNITS_CUNE_INTERNO=" + HZRNITS_CUNE_INTERNO + ", HZRNITS_ID=" + HZRNITS_ID + ", deducciones_pension=" + deducciones_pension + ", deduc_fondo_seguridad_p=" + deduc_fondo_seguridad_p + ", deduc_pension=" + deduc_pension + ", deduc_sindicatos=" + deduc_sindicatos + ", deduc_libranza=" + deduc_libranza + ", otras_deduc=" + otras_deduc + ", deduc_varias=" + deduc_varias + '}';
    }

   
    
}
