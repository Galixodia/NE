package co.edu.upb.pojos.nomina;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "EBO")
@XmlType (propOrder={"HZRNEBO_PAGO_SALARIAL",
    "HZRNEBO_PAGO_NO_SALARIAL",
    "HZRNEBO_PAGO_ALIMENT_SALARIAL",
    "HZRNEBO_PAGO_ALIMENT_NO_SALARY"})

public class EBO {
    
    @XmlElement(name = "EBO_1")
    private Double HZRNEBO_PAGO_SALARIAL;
    @XmlElement(name = "EBO_2")
    private Double HZRNEBO_PAGO_NO_SALARIAL;
    @XmlElement(name = "EBO_3")
    private Double HZRNEBO_PAGO_ALIMENT_SALARIAL;
    @XmlElement(name = "EBO_4")
    private Double HZRNEBO_PAGO_ALIMENT_NO_SALARY;
    private Integer HZRNEBO_ITE_ID;      

    @XmlTransient
    public Double getHZRNEBO_PAGO_SALARIAL() {
        return HZRNEBO_PAGO_SALARIAL;
    }

    public void setHZRNEBO_PAGO_SALARIAL(Double HZRNEBO_PAGO_SALARIAL) {
        this.HZRNEBO_PAGO_SALARIAL = HZRNEBO_PAGO_SALARIAL;
    }
    @XmlTransient
    public Double getHZRNEBO_PAGO_NO_SALARIAL() {
        return HZRNEBO_PAGO_NO_SALARIAL;
    }

    public void setHZRNEBO_PAGO_NO_SALARIAL(Double HZRNEBO_PAGO_NO_SALARIAL) {
        this.HZRNEBO_PAGO_NO_SALARIAL = HZRNEBO_PAGO_NO_SALARIAL;
    }
    @XmlTransient
    public Double getHZRNEBO_PAGO_ALIMENT_SALARIAL() {
        return HZRNEBO_PAGO_ALIMENT_SALARIAL;
    }

    public void setHZRNEBO_PAGO_ALIMENT_SALARIAL(Double HZRNEBO_PAGO_ALIMENT_SALARIAL) {
        this.HZRNEBO_PAGO_ALIMENT_SALARIAL = HZRNEBO_PAGO_ALIMENT_SALARIAL;
    }
    @XmlTransient
    public Double getHZRNEBO_PAGO_ALIMENT_NO_SALARY() {
        return HZRNEBO_PAGO_ALIMENT_NO_SALARY;
    }

    public void setHZRNEBO_PAGO_ALIMENT_NO_SALARY(Double HZRNEBO_PAGO_ALIMENT_NO_SALARY) {
        this.HZRNEBO_PAGO_ALIMENT_NO_SALARY = HZRNEBO_PAGO_ALIMENT_NO_SALARY;
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
