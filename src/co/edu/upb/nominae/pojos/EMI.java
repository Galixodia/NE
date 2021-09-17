package co.edu.upb.nominae.pojos;

import co.edu.upb.utilities.Data;
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
 * 
 * Segmento  Obligatorio. Puede repetirse  una sola (1) vez en el archivo.
 * Utilizado para Atributos del Empleador o Emisor del Documento 
 */

//@XmlRootElement(name = "EMI")
@XmlType (propOrder={"HZRNEMI_RAZON_SOCIAL",
    "HZRNEMI_PRIMER_APELLIDO",
    "HZRNEMI_SEGUNDO_APELLIDO",
    "HZRNEMI_PRIMER_NOMBRE",
    "HZRNEMI_OTROS_NOMBRES",
    "HZRNEMI_NIT",
    "HZRNEMI_DV",
    "HZRNEMI_PAIS",
    "HZRNEMI_DEPART_ESTADO",
    "HZRNEMI_MUNICIPIO_CIUDAD",
    "HZRNEMI_DIRECCION"})
public class EMI {

    private String HZRNEMI_CUNE_INTERNO;
    @XmlElement(name = "EMI_1")
    private String HZRNEMI_RAZON_SOCIAL; 
    @XmlElement(name = "EMI_2")
    private String HZRNEMI_PRIMER_APELLIDO; 
    @XmlElement(name = "EMI_3")
    private String HZRNEMI_SEGUNDO_APELLIDO; 
    @XmlElement(name = "EMI_4")
    private String HZRNEMI_PRIMER_NOMBRE; 
    @XmlElement(name = "EMI_5")
    private String HZRNEMI_OTROS_NOMBRES; 
    @XmlElement(name = "EMI_6")
    private Long HZRNEMI_NIT; 
    @XmlElement(name = "EMI_7")
    private Integer HZRNEMI_DV; 
    @XmlElement(name = "EMI_8")
    private String HZRNEMI_PAIS; 
    @XmlElement(name = "EMI_9")
    private Integer HZRNEMI_DEPART_ESTADO; 
    @XmlElement(name = "EMI_10")
    private Integer HZRNEMI_MUNICIPIO_CIUDAD; 
    @XmlElement(name = "EMI_11")
    private String HZRNEMI_DIRECCION; 
    @XmlTransient
    public String getHZRNEMI_CUNE_INTERNO() {
        return HZRNEMI_CUNE_INTERNO;
    }

    public void setHZRNEMI_CUNE_INTERNO(String HZRNEMI_CUNE_INTERNO) {
        this.HZRNEMI_CUNE_INTERNO = HZRNEMI_CUNE_INTERNO;
    }
    @XmlTransient
    public String getHZRNEMI_RAZON_SOCIAL() {
        return HZRNEMI_RAZON_SOCIAL;
    }

    public void setHZRNEMI_RAZON_SOCIAL(String HZRNEMI_RAZON_SOCIAL) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEMI_RAZON_SOCIAL,450)){
            this.HZRNEMI_RAZON_SOCIAL = HZRNEMI_RAZON_SOCIAL;
            data = null;            
        }else{
            throw new DataFormatException("EMI:HZRNEMI_RAZON_SOCIAL:El campo es nulo");
        }         
    }
    @XmlTransient
    public String getHZRNEMI_PRIMER_APELLIDO() {
        return HZRNEMI_PRIMER_APELLIDO;
    }

    public void setHZRNEMI_PRIMER_APELLIDO(String HZRNEMI_PRIMER_APELLIDO) {
        this.HZRNEMI_PRIMER_APELLIDO = HZRNEMI_PRIMER_APELLIDO;
    }
    @XmlTransient
    public String getHZRNEMI_SEGUNDO_APELLIDO() {
        return HZRNEMI_SEGUNDO_APELLIDO;
    }

    public void setHZRNEMI_SEGUNDO_APELLIDO(String HZRNEMI_SEGUNDO_APELLIDO) {
        this.HZRNEMI_SEGUNDO_APELLIDO = HZRNEMI_SEGUNDO_APELLIDO;
    }
    @XmlTransient
    public String getHZRNEMI_PRIMER_NOMBRE() {
        return HZRNEMI_PRIMER_NOMBRE;
    }

    public void setHZRNEMI_PRIMER_NOMBRE(String HZRNEMI_PRIMER_NOMBRE) {
        this.HZRNEMI_PRIMER_NOMBRE = HZRNEMI_PRIMER_NOMBRE;
    }
    @XmlTransient
    public String getHZRNEMI_OTROS_NOMBRES() {
        return HZRNEMI_OTROS_NOMBRES;
    }

    public void setHZRNEMI_OTROS_NOMBRES(String HZRNEMI_OTROS_NOMBRES) {
        this.HZRNEMI_OTROS_NOMBRES = HZRNEMI_OTROS_NOMBRES;
    }
    @XmlTransient
    public Long getHZRNEMI_NIT() {
        return HZRNEMI_NIT;
    }

    public void setHZRNEMI_NIT(Long HZRNEMI_NIT) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEMI_NIT,13)){
            this.HZRNEMI_NIT = HZRNEMI_NIT;
            data = null;            
        }else{
            throw new DataFormatException("EMI:HZRNEMI_NIT:El campo es nulo");
        }          
    }
    @XmlTransient
    public Integer getHZRNEMI_DV() {
        return HZRNEMI_DV;
    }

    public void setHZRNEMI_DV(Integer HZRNEMI_DV) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEMI_DV,2)){
            this.HZRNEMI_DV = HZRNEMI_DV;
            data = null;            
        }else{
            throw new DataFormatException("EMI:HZRNEMI_DV:El campo es nulo");
        }          
    }
    @XmlTransient
    public String getHZRNEMI_PAIS() {
        return HZRNEMI_PAIS;
    }

    public void setHZRNEMI_PAIS(String HZRNEMI_PAIS) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEMI_PAIS,2)){
            this.HZRNEMI_PAIS = HZRNEMI_PAIS;
            data = null;            
        }else{
            throw new DataFormatException("EMI:HZRNEMI_PAIS:El campo es nulo");
        }          
    }
    @XmlTransient
    public Integer getHZRNEMI_DEPART_ESTADO() {
        return HZRNEMI_DEPART_ESTADO;
    }

    public void setHZRNEMI_DEPART_ESTADO(Integer HZRNEMI_DEPART_ESTADO) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEMI_DEPART_ESTADO,2)){
            this.HZRNEMI_DEPART_ESTADO = HZRNEMI_DEPART_ESTADO;
            data = null;            
        }else{
            throw new DataFormatException("EMI:HZRNEMI_DEPART_ESTADO:El campo es nulo");
        }           
    }
    @XmlTransient
    public Integer getHZRNEMI_MUNICIPIO_CIUDAD() {
        return HZRNEMI_MUNICIPIO_CIUDAD;
    }

    public void setHZRNEMI_MUNICIPIO_CIUDAD(Integer HZRNEMI_MUNICIPIO_CIUDAD) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEMI_MUNICIPIO_CIUDAD,5)){
            this.HZRNEMI_MUNICIPIO_CIUDAD = HZRNEMI_MUNICIPIO_CIUDAD;
            data = null;            
        }else{
            throw new DataFormatException("EMI:HZRNEMI_MUNICIPIO_CIUDAD:El campo es nulo");
        }         
    }
    @XmlTransient
    public String getHZRNEMI_DIRECCION() {
        return HZRNEMI_DIRECCION;
    }

    public void setHZRNEMI_DIRECCION(String HZRNEMI_DIRECCION) throws DataFormatException {
        Data data = new Data();    

        if(data.checklength(HZRNEMI_DIRECCION,300)){
            this.HZRNEMI_DIRECCION = HZRNEMI_DIRECCION;
            data = null;            
        }else{
            throw new DataFormatException("EMI:HZRNEMI_DIRECCION:El campo es nulo");
        }           
    }

    @Override
    public String toString() {
        return "EMI{" + "HZRNEMI_CUNE_INTERNO=" + HZRNEMI_CUNE_INTERNO + ", HZRNEMI_RAZON_SOCIAL=" + HZRNEMI_RAZON_SOCIAL + ", HZRNEMI_PRIMER_APELLIDO=" + HZRNEMI_PRIMER_APELLIDO + ", HZRNEMI_SEGUNDO_APELLIDO=" + HZRNEMI_SEGUNDO_APELLIDO + ", HZRNEMI_PRIMER_NOMBRE=" + HZRNEMI_PRIMER_NOMBRE + ", HZRNEMI_OTROS_NOMBRES=" + HZRNEMI_OTROS_NOMBRES + ", HZRNEMI_NIT=" + HZRNEMI_NIT + ", HZRNEMI_DV=" + HZRNEMI_DV + ", HZRNEMI_PAIS=" + HZRNEMI_PAIS + ", HZRNEMI_DEPART_ESTADO=" + HZRNEMI_DEPART_ESTADO + ", HZRNEMI_MUNICIPIO_CIUDAD=" + HZRNEMI_MUNICIPIO_CIUDAD + ", HZRNEMI_DIRECCION=" + HZRNEMI_DIRECCION + '}';
    }

    
}
