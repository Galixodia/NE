package co.edu.upb.nominae.pojos;


import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * NE
 * @author 000329745 Juan Camilo Villa P
 * @since 00/09/2021
 * @version 1.0
 * 
 * Clase Padre de todo documento soporte de nomina elecronica o CUNE
 * 
 * TIP  HZRNTIP                         TIPO NOTA/NOTE TYPE
 * ENC  HZRNENC                         ENCABEZADO / HEADING
 * NOV  HZRNNOV                         Novedad/Noveltyz
 * NOT  HZRNNOT                         Notas/ Notes
 * EMI  HZRNEMI                         DATOS DEL EMPLEADOR/EMISOR DEL DOCUMENTO   DATA OF THE EMPLOYER / ISSUER OF THE DOCUMENT
 * REC  HZRNREC                         DATOS DEL TRABAJADOR/RECEPTOR   WORKER / RECEIVER DATA
 * PAG  HZRNPAG                         PAGO DE LA NOMINA/ PAYMENT OF THE PAYROLL
 * FEP  HZRNFEP                         FECHAS DE PAGOS/ PAYMENT DATE/
 * ITE  HZRNITE                         DEVENGADO BASICO DEL TRABAJADOR/RECEPTOR
 *      ETR  HZRNETR                         DEVENGADO-TRANSPORTE PAGADO AL TRABAJADOR/RECEPTOR
 *      EHE  HZRNEHE                         DEVENGADO-HORAS EXTRAS Y RECARGOS DEVENGADAS POR EL TRABAJADOR/RECEPTOR
 *      EVC  HZRNEVC                         DEVENGADO - VACACIONES  COMUNES DEL TRABJADOR/RECEPTOR
 *      EVA  HZRNEVA                         DEVENGADO - VACACIONES COMPENSADAS DEL TRABAJADOR/RECEPTOR
 *      EPR  HZRNEPR                         PRIMAS DEVENGADAS POR EL TRABAJADOR/RECEPTOR
 *      ECE  HZRNECE                         CESANTIAS DEVENGADAS POR EL TRABAJADOR/RECEPTOR
 *      EIN  HZRNEIN                         DEVENGADO - INCAPACIDAD DEL TRABAJADOR/RECEPTOR
 *      ELI  HZRNELI                         DEVENGADO - LICENCIAS DE MATERNIDAD Y PATERNIDAD
 *      ELR  HZRNELR                         DEVENGADO - LICENCIA REMUNERADA
 *      ELN  HZRNELN                         DEVENGADO - LICENCIA NO REMUNERADA
 *      EBN  HZRNEBN                         DEVENGADO - BONIFICACIÓN PARA EL TRABAJADOR/RECEPTOR
 *      EAX  HZRNEAX                         DEVENGADO - AUXILIOS QUE SE LE OTORGAN AL TRABAJADOR/RECEPTOR
 *      EHL  HZRNEHL  [NO SE USARA POR UPB]  DEVENGADO- HUELGAS LEGALES 
 *      EOT  HZRNEOT                         OTROS CONCEPTOS DEVENGADOS POR EL TRABAJADOR/RECEPTOR
 *      ECM  HZRNECM                         COMPENSACIONES DEVENGADAS POR EL TRABAJADOR/RECEPTOR
 *      EBO  HZRNEBO  [NO SE USARA POR UPB]  DEVENGADO - BONOS PAGADOS POR MEDIO ELECTRONICO, RECARGAS, CHEQUES, VALES, TARJETAS ECT
 *      ECO  HZRNECO                         DEVENGADO -  PAGO DE COMISIONES, PAGO A TERCEREOS Y ANTICIPOS DE NOMINA
 *      EVO  HZRNEVO                         OPCIONES VARIAS DE DEVENGADOS
 * ITS  HZRNITS                         DEDUCCIONES DE SALUD 
 *      SPE  HZRNSPE                         DEDUCCIONES DE PENSIÓN 
 *      SSP  HZRNSSP                         DEDUCCIONES DE FONDO DE SEGURIDAD PENSIONAL
 *      SIN  HZRNSIN                         DEDUCCIONES DE SINDICATO
 *      SAN  HZRNSAN  [NO SE USARA POR UPB]  DEDUCCIONES POR SANCIONES
 *      SLI  HZRNSLI                         DEDUCCIONES POR LIBRANZA
 *      SOT  HZRNSOT                         OTRAS DEDUCCIONES
 *      SVA  HZRNSVA                         DEDUCCIONES VARIAS(pensiones voluntarias, Retención en la fuente, AFC, Cooperativas, Embargo Fiscal, Plan complementario, Educación, Reintegro, Deuda)
 * TOT  HZRNTOT                         TOTALES DE LA NÓMINA / PAYROLL TOTALS
 * 

 */

@XmlRootElement(name = "NOMINA")
@XmlType (propOrder={"encabezado",
    "novedad",
    "notas",
    "emisor",
    "receptor",
    "pago",
    "fecha_pagos",
    "basico_trab",
    "deducciones_salud",
    "totales_nomina"})
public class NOMINA {
    
    private String HZRNNOM_ESTADO;
    private String HZRNNOM_CUNE_INTERNO;
    private String HZRNNOM_PREFIJO;
    private String HZRNNOM_NUM_DOC;
    private String HZRNNOM_BASE64_PDF;
    
    
    @XmlElement(name = "ENC")
    private ENC encabezado;
    @XmlElement(name = "NOV")
    private NOV novedad;
    @XmlElement(name = "NOT")
    public List<NOT> notas =  Arrays.asList(new NOT[50]); //validar maximo 50
    @XmlElement(name = "EMI")
    private EMI emisor;
    @XmlElement(name = "REC")
    private REC receptor;
    @XmlElement(name = "PAG")
    private PAG pago;
    @XmlElement(name = "FEP")
    public List<FEP> fecha_pagos = Arrays.asList(new FEP[50]);
    @XmlElement(name = "ITE")
    private ITE basico_trab;
//        public List<ETR> transporte_pagado_trab = null;
//        public List<EHE> horas_extras_trab = null;
//        public List<EVC> vacaciones_trabajador = null;
//        public List<EVA> vacaciones_comp_trab = null;
//        private EPR primas_trab;
//        private ECE cesantias_trab;
//        public List<EIN> incapacidades_trab = null;
//        public List<ELI> licencia_mat_pat = null;
//        public List<ELR> licencia_remunerada = null;
//        public List<ELN> licencia_no_remunerada = null;
//        public List<EBN> bonificacion_para_trab = null;
//        public List<EAX> auxilio_trab = null;
//        //public List<EHL> huelgas_legales = null;
//        public List<EOT> otros_conceptos_trab = null;
//        public List<ECM> compensaciones_dev_trab = null;
//        //public List<EBO> bonos_pagados_electro = null;
//        public List<ECO> pago_terceros_anticipos_nom = null;
//        private EVO opciones_varias_devengados;
    @XmlElement(name = "ITS")
    private ITS deducciones_salud;
//        private SPE deducciones_pension;
//        private SSP deduc_fondo_seguridad_p;
//        public List<SPE> deduc_pension = null;
//        public List<SIN> deduc_sindicatos = null;
//        //public List<SAN> deduc_sanciones = null;
//        public List<SLI> deduc_libranza = null;
//        public List<SOT> otras_deduc = null;
//        private SVA deduc_varias;
    @XmlElement(name = "TOT")
    private TOT totales_nomina;

    @XmlTransient
    public String getHZRNNOM_BASE64_PDF() {
        return HZRNNOM_BASE64_PDF;
    }

    public void setHZRNNOM_BASE64_PDF(String HZRNNOM_BASE64_PDF) {
        this.HZRNNOM_BASE64_PDF = HZRNNOM_BASE64_PDF;
    }
    
    @XmlTransient
    public String getHZRNNOM_PREFIJO() {
        return HZRNNOM_PREFIJO;
    }

    public void setHZRNNOM_PREFIJO(String HZRNNOM_PREFIJO) {
        this.HZRNNOM_PREFIJO = HZRNNOM_PREFIJO;
    }
    @XmlTransient
    public String getHZRNNOM_NUM_DOC() {
        return HZRNNOM_NUM_DOC;
    }

    public void setHZRNNOM_NUM_DOC(String HZRNNOM_NUM_DOC) {
        this.HZRNNOM_NUM_DOC = HZRNNOM_NUM_DOC;
    }

    @XmlTransient
    public String getHZRNNOM_CUNE_INTERNO() {
        return HZRNNOM_CUNE_INTERNO;
    }

    public void setHZRNNOM_CUNE_INTERNO(String HZRNNOM_CUNE_INTERNO) {
        this.HZRNNOM_CUNE_INTERNO = HZRNNOM_CUNE_INTERNO;
    }

    @XmlTransient
    public String getHZRNNOM_ESTADO() {
        return HZRNNOM_ESTADO;
    }

    public void setHZRNNOM_ESTADO(String HZRNNOM_ESTADO) {
        this.HZRNNOM_ESTADO = HZRNNOM_ESTADO;
    }
    
    @XmlTransient
    public ENC getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(ENC encabezado) {
        this.encabezado = encabezado;
    }
    @XmlTransient
    public NOV getNovedad() {
        return novedad;
    }

    public void setNovedad(NOV novedad) {
        this.novedad = novedad;
    }
    @XmlTransient
    public EMI getEmisor() {
        return emisor;
    }

    public void setEmisor(EMI emisor) {
        this.emisor = emisor;
    }
    @XmlTransient
    public REC getReceptor() {
        return receptor;
    }

    public void setReceptor(REC receptor) {
        this.receptor = receptor;
    }
    @XmlTransient
    public PAG getPago() {
        return pago;
    }

    public void setPago(PAG pago) {
        this.pago = pago;
    }
    @XmlTransient
    public ITE getBasico_trab() {
        return basico_trab;
    }

    public void setBasico_trab(ITE basico_trab) {
        this.basico_trab = basico_trab;
    }
    @XmlTransient
    public ITS getDeducciones_salud() {
        return deducciones_salud;
    }

    public void setDeducciones_salud(ITS deducciones_salud) {
        this.deducciones_salud = deducciones_salud;
    }
    @XmlTransient
    public TOT getTotales_nomina() {
        return totales_nomina;
    }

    public void setTotales_nomina(TOT totales_nomina) {
        this.totales_nomina = totales_nomina;
    }

    @Override
    public String toString() {
        return "NOMINA{" + "HZRNNOM_ESTADO=" + HZRNNOM_ESTADO + ", HZRNNOM_CUNE_INTERNO=" + HZRNNOM_CUNE_INTERNO + ", HZRNNOM_PREFIJO=" + HZRNNOM_PREFIJO + ", HZRNNOM_NUM_DOC=" + HZRNNOM_NUM_DOC + ", encabezado=" + encabezado + ", novedad=" + novedad + ", notas=" + notas + ", emisor=" + emisor + ", receptor=" + receptor + ", pago=" + pago + ", fecha_pagos=" + fecha_pagos + ", basico_trab=" + basico_trab + ", deducciones_salud=" + deducciones_salud + ", totales_nomina=" + totales_nomina + '}';
    }

            
    
}
