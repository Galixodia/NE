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
@XmlType (propOrder={"tipo_nota",
    "encabezado",
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
    
    private String HZRNNOM_PREFIJO;
    private Integer HZRNNOM_NUM_DOC;
    private String HZRNNOM_CUNE_INTERNO;
    private String HZRNNOM_TIPO_DOC;
    private Integer HZRNNOM_ANO;
    private Integer HZRNNOM_MES;
    private String HZRNNOM_FECHA_EXT;
    private String HZRNNOM_HORA_EXT;
    private String HZRNNOM_FECHA_TRANS;
    private String HZRNNOM_HORA_TRANS;    
    private String HZRNNOM_ESTADO;
    private String HZRNNOM_RTA_CARVAJAL;
    private String HZRNNOM_RTA_DIAN;
    private String HZRNNOM_BASE64_PDF;
    private String HZRNNOM_PDF;
  
    
    @XmlElement(name = "TIP")
    private TIP tipo_nota;
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
    public Integer getHZRNNOM_NUM_DOC() {
        return HZRNNOM_NUM_DOC;
    }

    public void setHZRNNOM_NUM_DOC(Integer HZRNNOM_NUM_DOC) {
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
    public TIP getTipo_nota() {
        return tipo_nota;
    }

    public void setTipo_nota(TIP tipo_nota) {
        this.tipo_nota = tipo_nota;
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
    @XmlTransient
    public Integer getHZRNNOM_ANO() {
        return HZRNNOM_ANO;
    }

    public void setHZRNNOM_ANO(Integer HZRNNOM_ANO) {
        this.HZRNNOM_ANO = HZRNNOM_ANO;
    }
    @XmlTransient
    public Integer getHZRNNOM_MES() {
        return HZRNNOM_MES;
    }

    public void setHZRNNOM_MES(Integer HZRNNOM_MES) {
        this.HZRNNOM_MES = HZRNNOM_MES;
    }
    @XmlTransient
    public String getHZRNNOM_FECHA_EXT() {
        return HZRNNOM_FECHA_EXT;
    }

    public void setHZRNNOM_FECHA_EXT(String HZRNNOM_FECHA_EXT) {
        this.HZRNNOM_FECHA_EXT = HZRNNOM_FECHA_EXT;
    }
    @XmlTransient
    public String getHZRNNOM_HORA_EXT() {
        return HZRNNOM_HORA_EXT;
    }

    public void setHZRNNOM_HORA_EXT(String HZRNNOM_HORA_EXT) {
        this.HZRNNOM_HORA_EXT = HZRNNOM_HORA_EXT;
    }
    @XmlTransient
    public String getHZRNNOM_FECHA_TRANS() {
        return HZRNNOM_FECHA_TRANS;
    }

    public void setHZRNNOM_FECHA_TRANS(String HZRNNOM_FECHA_TRANS) {
        this.HZRNNOM_FECHA_TRANS = HZRNNOM_FECHA_TRANS;
    }
    @XmlTransient
    public String getHZRNNOM_HORA_TRANS() {
        return HZRNNOM_HORA_TRANS;
    }

    public void setHZRNNOM_HORA_TRANS(String HZRNNOM_HORA_TRANS) {
        this.HZRNNOM_HORA_TRANS = HZRNNOM_HORA_TRANS;
    }
    @XmlTransient
    public String getHZRNNOM_RTA_CARVAJAL() {
        return HZRNNOM_RTA_CARVAJAL;
    }

    public void setHZRNNOM_RTA_CARVAJAL(String HZRNNOM_RTA_CARVAJAL) {
        this.HZRNNOM_RTA_CARVAJAL = HZRNNOM_RTA_CARVAJAL;
    }
    @XmlTransient
    public String getHZRNNOM_RTA_DIAN() {
        return HZRNNOM_RTA_DIAN;
    }

    public void setHZRNNOM_RTA_DIAN(String HZRNNOM_RTA_DIAN) {
        this.HZRNNOM_RTA_DIAN = HZRNNOM_RTA_DIAN;
    }
    @XmlTransient
    public String getHZRNNOM_PDF() {
        return HZRNNOM_PDF;
    }

    public void setHZRNNOM_PDF(String HZRNNOM_PDF) {
        this.HZRNNOM_PDF = HZRNNOM_PDF;
    }
    @XmlTransient
    public String getHZRNNOM_TIPO_DOC() {
        return HZRNNOM_TIPO_DOC;
    }

    public void setHZRNNOM_TIPO_DOC(String HZRNNOM_TIPO_DOC) {
        this.HZRNNOM_TIPO_DOC = HZRNNOM_TIPO_DOC;
    }

    @Override
    public String toString() {
        return "NOMINA{" + "HZRNNOM_PREFIJO=" + HZRNNOM_PREFIJO + ", HZRNNOM_NUM_DOC=" + HZRNNOM_NUM_DOC + ", HZRNNOM_CUNE_INTERNO=" + HZRNNOM_CUNE_INTERNO + ", HZRNNOM_TIPO_DOC=" + HZRNNOM_TIPO_DOC + ", HZRNNOM_ANO=" + HZRNNOM_ANO + ", HZRNNOM_MES=" + HZRNNOM_MES + ", HZRNNOM_FECHA_EXT=" + HZRNNOM_FECHA_EXT + ", HZRNNOM_HORA_EXT=" + HZRNNOM_HORA_EXT + ", HZRNNOM_FECHA_TRANS=" + HZRNNOM_FECHA_TRANS + ", HZRNNOM_HORA_TRANS=" + HZRNNOM_HORA_TRANS + ", HZRNNOM_ESTADO=" + HZRNNOM_ESTADO + ", HZRNNOM_RTA_CARVAJAL=" + HZRNNOM_RTA_CARVAJAL + ", HZRNNOM_RTA_DIAN=" + HZRNNOM_RTA_DIAN + ", HZRNNOM_BASE64_PDF=" + HZRNNOM_BASE64_PDF + ", HZRNNOM_PDF=" + HZRNNOM_PDF + ", tipo_nota=" + tipo_nota + ", encabezado=" + encabezado + ", novedad=" + novedad + ", notas=" + notas + ", emisor=" + emisor + ", receptor=" + receptor + ", pago=" + pago + ", fecha_pagos=" + fecha_pagos + ", basico_trab=" + basico_trab + ", deducciones_salud=" + deducciones_salud + ", totales_nomina=" + totales_nomina + '}';
    }


}
