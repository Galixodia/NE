package co.edu.upb.nominae.pojos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"HZRNEBO_PAGO_SALARIAL",
    "HZRNEBO_PAGO_NO_SALARIAL",
    "HZRNEBO_PAGO_ALIMENT_SALARIAL",
    "HZRNEBO_PAGO_ALIMENT_NO_SALARY"})
public class EBO {
    
    @XmlElement(name = "EBO_1")
    private String HZRNEBO_PAGO_SALARIAL;
    @XmlElement(name = "EBO_2")
    private String HZRNEBO_PAGO_NO_SALARIAL;
    @XmlElement(name = "EBO_3")
    private String HZRNEBO_PAGO_ALIMENT_SALARIAL;
    @XmlElement(name = "EBO_4")
    private String HZRNEBO_PAGO_ALIMENT_NO_SALARY;
    private Integer HZRNEBO_ITE_ID;      

    @XmlTransient
    public String getHZRNEBO_PAGO_SALARIAL() {
        return HZRNEBO_PAGO_SALARIAL;
    }

    public void setHZRNEBO_PAGO_SALARIAL(BigDecimal HZRNEBO_PAGO_SALARIAL) {
        if(HZRNEBO_PAGO_SALARIAL != null){
            this.HZRNEBO_PAGO_SALARIAL = new DecimalFormat("#.000000").format(HZRNEBO_PAGO_SALARIAL).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNEBO_PAGO_NO_SALARIAL() {
        return HZRNEBO_PAGO_NO_SALARIAL;
    }

    public void setHZRNEBO_PAGO_NO_SALARIAL(BigDecimal HZRNEBO_PAGO_NO_SALARIAL) {
        if(HZRNEBO_PAGO_NO_SALARIAL != null){
            this.HZRNEBO_PAGO_NO_SALARIAL = new DecimalFormat("#.000000").format(HZRNEBO_PAGO_NO_SALARIAL).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNEBO_PAGO_ALIMENT_SALARIAL() {
        return HZRNEBO_PAGO_ALIMENT_SALARIAL;
    }

    public void setHZRNEBO_PAGO_ALIMENT_SALARIAL(BigDecimal HZRNEBO_PAGO_ALIMENT_SALARIAL) {
        if(HZRNEBO_PAGO_ALIMENT_SALARIAL != null){
            this.HZRNEBO_PAGO_ALIMENT_SALARIAL = new DecimalFormat("#.000000").format(HZRNEBO_PAGO_ALIMENT_SALARIAL).replace(",",".");  
        }
    }
    @XmlTransient
    public String getHZRNEBO_PAGO_ALIMENT_NO_SALARY() {
        return HZRNEBO_PAGO_ALIMENT_NO_SALARY;
    }

    public void setHZRNEBO_PAGO_ALIMENT_NO_SALARY(BigDecimal HZRNEBO_PAGO_ALIMENT_NO_SALARY) {
        if(HZRNEBO_PAGO_ALIMENT_NO_SALARY != null){
            this.HZRNEBO_PAGO_ALIMENT_NO_SALARY = new DecimalFormat("#.000000").format(HZRNEBO_PAGO_ALIMENT_NO_SALARY).replace(",",".");  
        }
    }
    @XmlTransient
    public Integer getHZRNEBO_ITE_ID() {
        return HZRNEBO_ITE_ID;
    }

    public void setHZRNEBO_ITE_ID(Integer HZRNEBO_ITE_ID) {
        this.HZRNEBO_ITE_ID = HZRNEBO_ITE_ID;
    }

    @Override
    public String toString() {
        return "EBO{" + "HZRNEBO_PAGO_SALARIAL=" + HZRNEBO_PAGO_SALARIAL + ", HZRNEBO_PAGO_NO_SALARIAL=" + HZRNEBO_PAGO_NO_SALARIAL + ", HZRNEBO_PAGO_ALIMENT_SALARIAL=" + HZRNEBO_PAGO_ALIMENT_SALARIAL + ", HZRNEBO_PAGO_ALIMENT_NO_SALARY=" + HZRNEBO_PAGO_ALIMENT_NO_SALARY + ", HZRNEBO_ITE_ID=" + HZRNEBO_ITE_ID + '}';
    }

}
