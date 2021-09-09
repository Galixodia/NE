package co.edu.upb.pojos.nomina;


import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

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

@XmlRootElement
public class Nomina {
    
    
    private ENC encabezado;
    private NOV novedad;
    public List<NOT> notas = null; //validar maximo 50
    private EMI emisor;
    private REC receptor;
    private PAG pago;
    public List<FEP> fecha_pagos = null;
    private ITE basico_trab;
        public List<ETR> transporte_pagado_trab = null;
        public List<EHE> horas_extras_trab = null;
        public List<EVC> vacaciones_trabajador = null;
        public List<EVA> vacaciones_comp_trab = null;
        private EPR primas_trab;
        private ECE cesantias_trab;
        public List<EIN> incapacidades_trab = null;
        public List<ELI> licencia_mat_pat = null;
        public List<ELR> licencia_remunerada = null;
        public List<ELN> licencia_no_remunerada = null;
        public List<EBN> bonificacion_para_trab = null;
        public List<EAX> auxilio_trab = null;
        //public List<EHL> huelgas_legales = null;
        public List<EOT> otros_conceptos_trab = null;
        public List<ECM> compensaciones_dev_trab = null;
        //public List<EBO> bonos_pagados_electro = null;
        public List<ECO> pago_terceros_anticipos_nom = null;
        private EVO opciones_varias_devengados;
    private ITS deducciones_salud;
        private SPE deducciones_pension;
        private SSP deduc_fondo_seguridad_p;
        public List<SPE> deduc_pension = null;
        public List<SIN> deduc_sindicatos = null;
        //public List<SAN> deduc_sanciones = null;
        public List<SLI> deduc_libranza = null;
        public List<SOT> otras_deduc = null;
        private SVA deduc_varias;
    private TOT totales_nomina;

    
            
    
}
