package co.edu.upb.nominae.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author 000329744 Xiomara Torrez Muñoz
 * @since 00/09/2021
 * @version 1.0
 * 
 * Segmento Opcional. Puede repetirse  hasta 50 veces en el archivo. 
 * Ver nota 4
 * Campo de libre uso para Observaciones en el documento
 */


@XmlType (propOrder={"HZRNNOT_NOTAS"})
public class NOT {
    
    private String HZRNNOT_CUNE_INTERNO;
    @XmlElement(name="NOT_1")
    private String HZRNNOT_NOTAS;
    @XmlTransient
    public String getHZRNNOT_CUNE_INTERNO() {
        return HZRNNOT_CUNE_INTERNO;
    }

    public void setHZRNNOT_CUNE_INTERNO(String HZRNNOT_CUNE_INTERNO) {
        this.HZRNNOT_CUNE_INTERNO = HZRNNOT_CUNE_INTERNO;
    }
    @XmlTransient
    public String getHZRNNOT_NOTAS() {
        return HZRNNOT_NOTAS;
    }

    public void setHZRNNOT_NOTAS(String HZRNNOT_NOTAS) {
        this.HZRNNOT_NOTAS = HZRNNOT_NOTAS;
    }

    @Override
    public String toString() {
        return "NOT{" + "HZRNNOT_CUNE_INTERNO=" + HZRNNOT_CUNE_INTERNO + ", HZRNNOT_NOTAS=" + HZRNNOT_NOTAS + '}';
    }
    
}
