
package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 000329745 Juan Camilo Villa 
 * @since 00/09/2021
 * @version 1.0
 * 
 * CLASE QUE DEFINE EL TIPO DE AJUSTE EN CASO DE SERLO.
 */
@XmlRootElement(name = "TIP")
public class TIP {
    
    @XmlElement(name = "TIP_1")
    private Integer TIP_1;


    public TIP() {
    }

    public TIP(Integer TIP_1) {
        this.TIP_1 = TIP_1;
    }

    
    @XmlTransient
    public Integer getTIP_1() {
        return TIP_1;
    }

    public void setTIP_1(Integer TIP_1) {
        this.TIP_1 = TIP_1;
    }

    @Override
    public String toString() {
        return "TIP{" + "TIP_1=" + TIP_1 + '}';
    }
    
    
    
}
