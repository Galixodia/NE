package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


//@XmlRootElement(name = "ITS")
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
    private Double HZRNITS_PORCENTAJE;
    @XmlElement(name = "ITS_2")
    private Double HZRNITS_DEDUCCION;
    
    private Double HZRNITS_CUNE_INTERNO;
    private Double HZRNITS_ID;
    
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
    @XmlElement(name = "V")
    public List<SLI> deduc_libranza = Arrays.asList(new SLI[50]);
    @XmlElement(name = "SOT")
    public List<SOT> otras_deduc = Arrays.asList(new SOT[50]);
    @XmlElement(name = "SVA")
    private SVA deduc_varias;

    
    @XmlTransient
    public Double getHZRNITS_PORCENTAJE() {
        return HZRNITS_PORCENTAJE;
    }

    public void setHZRNITS_PORCENTAJE(Double HZRNITS_PORCENTAJE) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNITS_PORCENTAJE,3,2)){
            this.HZRNITS_PORCENTAJE = HZRNITS_PORCENTAJE;
            data = null;            
        }else{
            throw new DataFormatException("ITS:HZRNITS_PORCENTAJE:El campo es nulo o excede la longitud definida por la DIAN");
        }             
    }
    @XmlTransient
    public Double getHZRNITS_DEDUCCION() {
        return HZRNITS_DEDUCCION;
    }

    public void setHZRNITS_DEDUCCION(Double HZRNITS_DEDUCCION) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNITS_DEDUCCION,15,6)){
            this.HZRNITS_DEDUCCION = HZRNITS_DEDUCCION;
            data = null;            
        }else{
            throw new DataFormatException("ITS:HZRNITS_DEDUCCION:El campo es nulo o excede la longitud definida por la DIAN");
        }           
    }
    @XmlTransient
    public Double getHZRNITS_CUNE_INTERNO() {
        return HZRNITS_CUNE_INTERNO;
    }

    public void setHZRNITS_CUNE_INTERNO(Double HZRNITS_CUNE_INTERNO) {
        this.HZRNITS_CUNE_INTERNO = HZRNITS_CUNE_INTERNO;
    }
    @XmlTransient
    public Double getHZRNITS_ID() {
        return HZRNITS_ID;
    }

    public void setHZRNITS_ID(Double HZRNITS_ID) {
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
