package co.edu.upb.nominae.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author 000329744 Xiomara Torrez Muñoz
 * @since 00/09/2021
 * @version 1.0
 * Segmento Obligatorio. Puede repetirse  una sola (1) vez en el archivo.
 * Utilizado para Atributos del Pago del Documento. Este Segemento es dependiente Ver Nota 3
 */

//@XmlRootElement(name = "PAG")
@XmlType (propOrder={"HZRNPAG_FORMA_PAGO",
    "HZRNPAG_METODO_PAGO",
    "HZRNPAG_BANCO",
    "HZRNPAG_TIPO_CUENTA",
    "HZRNPAG_NUM_CUENTA"})

public class PAG {
    
    private String HZRNPAG_CUNE_INTERNO;    
    @XmlElement(name = "PAG_1")
    private Integer HZRNPAG_FORMA_PAGO;
    @XmlElement(name = "PAG_2")
    private String HZRNPAG_METODO_PAGO;
    @XmlElement(name = "PAG_3")
    private String HZRNPAG_BANCO;
    @XmlElement(name = "PAG_4")
    private String HZRNPAG_TIPO_CUENTA;
    @XmlElement(name = "PAG_5")
    private String HZRNPAG_NUM_CUENTA;

    @XmlTransient
    public String getHZRNPAG_CUNE_INTERNO() {
        return HZRNPAG_CUNE_INTERNO;
    }

    public void setHZRNPAG_CUNE_INTERNO(String HZRNPAG_CUNE_INTERNO) {
        this.HZRNPAG_CUNE_INTERNO = HZRNPAG_CUNE_INTERNO;
    }
    @XmlTransient
    public Integer getHZRNPAG_FORMA_PAGO() {
        return HZRNPAG_FORMA_PAGO;
    }

    public void setHZRNPAG_FORMA_PAGO(Integer HZRNPAG_FORMA_PAGO) {
        this.HZRNPAG_FORMA_PAGO = HZRNPAG_FORMA_PAGO;
    }
    @XmlTransient
    public String getHZRNPAG_METODO_PAGO() {
        return HZRNPAG_METODO_PAGO;
    }

    public void setHZRNPAG_METODO_PAGO(String HZRNPAG_METODO_PAGO) {
        this.HZRNPAG_METODO_PAGO = HZRNPAG_METODO_PAGO;
    }
    @XmlTransient
    public String getHZRNPAG_BANCO() {
        return HZRNPAG_BANCO;
    }

    public void setHZRNPAG_BANCO(String HZRNPAG_BANCO) {
        this.HZRNPAG_BANCO = HZRNPAG_BANCO;
    }
    @XmlTransient
    public String getHZRNPAG_TIPO_CUENTA() {
        return HZRNPAG_TIPO_CUENTA;
    }

    public void setHZRNPAG_TIPO_CUENTA(String HZRNPAG_TIPO_CUENTA) {
        this.HZRNPAG_TIPO_CUENTA = HZRNPAG_TIPO_CUENTA;
    }
    @XmlTransient
    public String getHZRNPAG_NUM_CUENTA() {
        return HZRNPAG_NUM_CUENTA;
    }

    public void setHZRNPAG_NUM_CUENTA(String HZRNPAG_NUM_CUENTA) {
        this.HZRNPAG_NUM_CUENTA = HZRNPAG_NUM_CUENTA;
    }

    @Override
    public String toString() {
        return "PAG{" + "HZRNPAG_CUNE_INTERNO=" + HZRNPAG_CUNE_INTERNO + ", HZRNPAG_FORMA_PAGO=" + HZRNPAG_FORMA_PAGO + ", HZRNPAG_METODO_PAGO=" + HZRNPAG_METODO_PAGO + ", HZRNPAG_BANCO=" + HZRNPAG_BANCO + ", HZRNPAG_TIPO_CUENTA=" + HZRNPAG_TIPO_CUENTA + ", HZRNPAG_NUM_CUENTA=" + HZRNPAG_NUM_CUENTA + '}';
    }


}
