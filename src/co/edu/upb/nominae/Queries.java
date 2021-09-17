
package co.edu.upb.nominae;

/**
 *
 * @author 000329745 Juan Camilo Villa 
 * @since 01/09/2021
 * @version 1.0
 * 
 * CONSTANTES CON QUERYES PARA LLENADO DE OBJETOS DESDE BASE DE DATOS
 */
public class Queries {
    
    public static final String NOMINA_QUERY = "SELECT HZRNNOM_PREFIJO, HZRNNOM_TIPO_DOC, HZRNNOM_CUNE_INTERNO, HZRNNOM_ANO, HZRNNOM_NUM_DOC, HZRNNOM_MES, HZRNNOM_FECHA_EXT, HZRNNOM_ESTADO FROM UPB_NOMINAE.HZRNNOM WHERE HZRNNOM_CUNE_INTERNO = ?";
    
    //public static final String HZRNTIP_QUERY = "";
    
    public static final String HZRNENC_QUERY = "SELECT HZRNENC_CUNE_INTERNO, HZRNENC_TIPO_DOC, HZRNENC_FECHA_ING, HZRNENC_FECHA_RET, HZRNENC_FECHA_LIQ_INI, HZRNENC_FECHA_LIQ_FIN, HZRNENC_TIEMPO_LAB, HZRNENC_FECHA_EMISION, HZRNENC_CODIGO_TRAB, HZRNENC_PREFIJO, HZRNENC_CONSECUTIVO, HZRNENC_NUMERO, HZRNENC_PAIS, HZRNENC_DEPART_ESTADO, HZRNENC_MUNICIPIO_CIUDAD, HZRNENC_IDIOMA, HZRNENC_VERSION, HZRNENC_AMBIENTE, HZRNENC_TIPO_XML, HZRNENC_CUNE, HZRNENC_FECHA_GENERA, HZRNENC_HORA_GENERA, HZRNENC_PERIODO_NOM, HZRNENC_TIPO_MONEDA, HZRNENC_TRM, HZRNENC_NUM_PRED, HZRNENC_CUNE_PRED, HZRNENC_FECHA_GEN_PRED FROM UPB_NOMINAE.HZRNENC";
    
    //public static final String HZRNNOV_QUERY = "SELECT HZRNNOV_CUNE_INTERNO, HZRNNOV_NOVEDAD, HZRNNOV_CUNE_NOV FROM UPB_NOMINAE.HZRNNOV";
            public static final String HZRNNOV_QUERY = "SELECT 1 HZRNNOV_CUNE_INTERNO, 2 HZRNNOV_NOVEDAD, 3 HZRNNOV_CUNE_NOV FROM DUAL";
    
    //public static final String HZRNNOT_QUERY = "SELECT HZRNNOT_CUNE_INTERNO, HZRNNOT_NOTAS FROM UPB_NOMINAE.HZRNNOT";
            public static final String HZRNNOT_QUERY = "SELECT 1 HZRNNOT_CUNE_INTERNO, 2 HZRNNOT_NOTAS FROM DUAL "
                    + "union all SELECT 11 HZRNNOT_CUNE_INTERNO, 12 HZRNNOT_NOTAS FROM DUAL "
                    + "union all SELECT 21 HZRNNOT_CUNE_INTERNO, 22 HZRNNOT_NOTAS FROM DUAL "
                    + "union all SELECT 31 HZRNNOT_CUNE_INTERNO, 32 HZRNNOT_NOTAS FROM DUAL "
                    + "union all SELECT 41 HZRNNOT_CUNE_INTERNO, 42 HZRNNOT_NOTAS FROM DUAL";
    
    //public static final String HZRNEMI_QUERY = "SELECT HZRNEMI_CUNE_INTERNO, HZRNEMI_RAZON_SOCIAL, HZRNEMI_PRIMER_APELLIDO,HZRNEMI_SEGUNDO_APELLIDO, HZRNEMI_PRIMER_NOMBRE, HZRNEMI_OTROS_NOMBRES,HZRNEMI_NIT, HZRNEMI_DV, HZRNEMI_PAIS, HZRNEMI_DEPART_ESTADO, HZRNEMI_MUNICIPIO_CIUDAD, HZRNEMI_DIRECCION FROM UPB_NOMINAE.HZRNEMI";
            public static final String HZRNEMI_QUERY = "SELECT 1 HZRNEMI_CUNE_INTERNO, 2 HZRNEMI_RAZON_SOCIAL, 3 HZRNEMI_PRIMER_APELLIDO, 4 HZRNEMI_SEGUNDO_APELLIDO, 5 HZRNEMI_PRIMER_NOMBRE, 6 HZRNEMI_OTROS_NOMBRES, 7 HZRNEMI_NIT, 8 HZRNEMI_DV, 9 HZRNEMI_PAIS, 10 HZRNEMI_DEPART_ESTADO, 11 HZRNEMI_MUNICIPIO_CIUDAD, 12 HZRNEMI_DIRECCION FROM DUAL";
    
    //public static final String HZRNREC_QUERY = "SELECT HZRNREC_CUNE_INTERNO, HZRNREC_TIPO_TRABAJADOR, HZRNREC_SUB_TIPO_TRABAJ, HZRNREC_ALTO_RIESGO_PENS, HZRNREC_TIPO_DOC, HZRNREC_NUM_DOC,HZRNREC_PRIMER_APELLIDO, HZRNREC_SEGUNDO_APELLIDO, HZRNREC_PRIMER_NOMBRE, HZRNREC_OTROS_NOMBRES, HZRNREC_LUGAR_TRAB_PAIS, HZRNREC_LUGAR_TRAB_DEPT_EST, HZRNREC_LUGAR_TRAB_MUN_CIUD, HZRNREC_LUGAR_TRAB_DIREC, HZRNREC_SALARIO_INTEGRAL, HZRNREC_TIPO_CONTRATO, HZRNREC_SUELDO, HZRNREC_COD_TRABAJADOR FROM UPB_NOMINAE.HZRNREC" ;

            public static final String HZRNREC_QUERY = "SELECT 1 HZRNREC_CUNE_INTERNO, 2 HZRNREC_TIPO_TRABAJADOR, 3 HZRNREC_SUB_TIPO_TRABAJ, '4' HZRNREC_ALTO_RIESGO_PENS, 5 HZRNREC_TIPO_DOC, '6' HZRNREC_NUM_DOC, '7' HZRNREC_PRIMER_APELLIDO, '8' HZRNREC_SEGUNDO_APELLIDO, '9' HZRNREC_PRIMER_NOMBRE, '10' HZRNREC_OTROS_NOMBRES, 11 HZRNREC_LUGAR_TRAB_PAIS, 12 HZRNREC_LUGAR_TRAB_DEPT_EST, 13 HZRNREC_LUGAR_TRAB_MUN_CIUD, '14' HZRNREC_LUGAR_TRAB_DIREC, 15 HZRNREC_SALARIO_INTEGRAL, 1 HZRNREC_TIPO_CONTRATO, 17 HZRNREC_SUELDO, '18' HZRNREC_COD_TRABAJADOR FROM DUAL";
    
    //public static final String HZRNPAG_QUERY = "SELECT HZRNPAG_CUNE_INTERNO, HZRNPAG_FORMA_PAGO, HZRNPAG_METODO_PAGO,HZRNPAG_BANCO, HZRNPAG_TIPO_CUENTA, HZRNPAG_NUM_CUENTA FROM UPB_NOMINAE.HZRNPAG";
            public static final String HZRNPAG_QUERY = "SELECT 1 HZRNPAG_CUNE_INTERNO, 2 HZRNPAG_FORMA_PAGO, 3 HZRNPAG_METODO_PAGO, 4 HZRNPAG_BANCO, 5 HZRNPAG_TIPO_CUENTA, 6 HZRNPAG_NUM_CUENTA FROM DUAL";
    
    //public static final String HZRNFEP_QUERY = "SELECT HZRNFEP_CUNE_INTERNO, HZRNFEP_FECHA_PAGO FROM UPB_NOMINAE.HZRNFEP";
            public static final String HZRNFEP_QUERY = "SELECT 1 HZRNFEP_CUNE_INTERNO, to_date('2021/12/12', 'yyyy/mm/dd') HZRNFEP_FECHA_PAGO FROM DUAL";
    
    public static final String HZRNITE_QUERY = "SELECT HZRNITE_CUNE_INTERNO, HZRNITE_DIAS_TRAB, HZRNITE_SUELDO_TRAB, HZRNITE_ID FROM UPB_NOMINAE.HZRNITE WHERE HZRNITE_CUNE_INTERNO = ?";
    
    public static final String HZRNETR_QUERY = "SELECT HZRNETR_AUX_TRANSPORTE, HZRNETR_VIAT_MANUT_SALARIAL, HZRNETR_VIAT_MANUT_NO_SALARIAL, HZRNETR_ITE_ID FROM UPB_NOMINAE.HZRNETR WHERE HZRNETR_ITE_ID =  ?";

    //public static final String HZRNEHE_QUERY = "SELECT HZRNEHE_HORAS_EXTRA, HZRNEHE_HORA_INICIO, HZRNEHE_HORA_FIN,HZRNEHE_CANTIDAD, HZRNEHE_PORCENTAJE, HZRNEHE_PAGO,HZRNEHE_ITE_ID FROM UPB_NOMINAE.HZRNEHE";
            public static final String HZRNEHE_QUERY = "SELECT 1 HZRNEHE_HORAS_EXTRA, 2 HZRNEHE_HORA_INICIO, 3 HZRNEHE_HORA_FIN, 4 HZRNEHE_CANTIDAD, 5 HZRNEHE_PORCENTAJE, 6 HZRNEHE_PAGO, 7 HZRNEHE_ITE_ID FROM DUAL";
    
    //public static final String HZRNEVC_QUERY = "SELECT HZRNEVC_FECHA_INICIO, HZRNEVC_FECHA_FIN, HZRNEVC_CANTIDAD,HZRNEVC_PAGO, HZRNEVC_ITE_ID FROM UPB_NOMINAE.HZRNEVC";
            public static final String HZRNEVC_QUERY = "SELECT to_date('2021/12/12', 'yyyy/mm/dd') HZRNEVC_FECHA_INICIO, to_date('2021/12/12', 'yyyy/mm/dd') HZRNEVC_FECHA_FIN,3 HZRNEVC_CANTIDAD, 4 HZRNEVC_PAGO, 5 HZRNEVC_ITE_ID FROM DUAL";
    
    //public static final String HZRNEVA_QUERY = "SELECT HZRNEVA_CANTIDAD, HZRNEVA_PAGO, HZRNEVA_ITE_ID FROM UPB_NOMINAE.HZRNEVA";
            public static final String HZRNEVA_QUERY = "SELECT 1 HZRNEVA_CANTIDAD, 2 HZRNEVA_PAGO, 3 HZRNEVA_ITE_ID FROM DUAL";
    
    //public static final String HZRNEPR_QUERY = "SELECT HZRNEPR_CANTIDAD, HZRNEPR_PAGO, HZRNEPR_PAGONS,HZRNEPR_ITE_ID FROM UPB_NOMINAE.HZRNEPR";
            public static final String HZRNEPR_QUERY = "SELECT 1 HZRNEPR_CANTIDAD, 2 HZRNEPR_PAGO,3 HZRNEPR_PAGONS, 4 HZRNEPR_ITE_ID FROM DUAL";
    
    //public static final String HZRNECE_QUERY = "SELECT HZRNECE_PAGO, HZRNECE_PORCENTAJE, HZRNECE_PAGO_INTERESES,HZRNECE_ITE_ID FROM UPB_NOMINAE.HZRNECE";
            public static final String HZRNECE_QUERY = "SELECT 1 HZRNECE_PAGO, 2 HZRNECE_PORCENTAJE, 3 HZRNECE_PAGO_INTERESES, 4 HZRNECE_ITE_ID FROM DUAL";
    
    //public static final String HZRNEIN_QUERY = "SELECT HZRNEIN_FECHA_INICIO, HZRNEIN_FECHA_FIN, HZRNEIN_CANTIDAD, HZRNEIN_TIPO, HZRNEIN_PAGO, HZRNEIN_ITE_ID FROM UPB_NOMINAE.HZRNEIN";
            public static final String HZRNEIN_QUERY = "SELECT to_date('2021/12/12', 'yyyy/mm/dd')  HZRNEIN_FECHA_INICIO, to_date('2021/12/12', 'yyyy/mm/dd')  HZRNEIN_FECHA_FIN, 3 HZRNEIN_CANTIDAD, 4 HZRNEIN_TIPO, 5 HZRNEIN_PAGO, 6 HZRNEIN_ITE_ID FROM DUAL";
    
    //public static final String HZRNELI_QUERY = "SELECT HZRNELI_FECHA_INICIO, HZRNELI_FECHA_FIN, HZRNELI_CANTIDAD, HZRNELI_PAGO, HZRNELI_ITE_ID FROM UPB_NOMINAE.HZRNELI";
            public static final String HZRNELI_QUERY = "SELECT to_date('2021/12/12', 'yyyy/mm/dd')HZRNELI_FECHA_INICIO, to_date('2021/12/12', 'yyyy/mm/dd')HZRNELI_FECHA_FIN,1 HZRNELI_CANTIDAD, 2 HZRNELI_PAGO, 3 HZRNELI_ITE_ID FROM DUAL";
    
    //public static final String HZRNELR_QUERY = "SELECT HZRNELR_FECHA_INICIO, HZRNELR_FECHA_FIN, HZRNELR_CANTIDAD,HZRNELR_PAGO, HZRNELR_ITE_ID FROM UPB_NOMINAE.HZRNELR";
            public static final String HZRNELR_QUERY = "SELECT to_date('2021/12/12', 'yyyy/mm/dd') HZRNELR_FECHA_INICIO, to_date('2021/12/12', 'yyyy/mm/dd')HZRNELR_FECHA_FIN,3 HZRNELR_CANTIDAD, 4 HZRNELR_PAGO, 5 HZRNELR_ITE_ID FROM DUAL";
    
    //public static final String HZRNELN_QUERY = "SELECT HZRNELN_FECHA_INICIO, HZRNELN_FECHA_FIN, HZRNELN_CANTIDAD,HZRNELN_ITE_ID FROM UPB_NOMINAE.HZRNELN";
            public static final String HZRNELN_QUERY = "SELECT to_date('2021/12/12', 'yyyy/mm/dd') HZRNELN_FECHA_INICIO, to_date('2021/12/12', 'yyyy/mm/dd') HZRNELN_FECHA_FIN, 3 HZRNELN_CANTIDAD, 4 HZRNELN_ITE_ID FROM DUAL";
    
    //public static final String HZRNEBN_QUERY = "SELECT HZRNEBN_BONI_SALARIAL, HZRNEBN_BONI_NO_SALARIAL, HZRNEBN_ITE_ID FROM UPB_NOMINAE.HZRNEBN";
            public static final String HZRNEBN_QUERY = "SELECT 1 HZRNEBN_BONI_SALARIAL, 2 HZRNEBN_BONI_NO_SALARIAL, 3 HZRNEBN_ITE_ID FROM DUAL";
    
    //public static final String HZRNEAX_QUERY = "SELECT HZRNEAX_AUX_SALARIAL, HZRNEAX_AUX_NO_SALARIAL, HZRNEAX_ITE_ID FROM UPB_NOMINAE.HZRNEAX";
            public static final String HZRNEAX_QUERY = "SELECT 1 HZRNEAX_AUX_SALARIAL, 2 HZRNEAX_AUX_NO_SALARIAL, 3 HZRNEAX_ITE_ID FROM DUAL";
    
    //NO SE EMITIRA POR PARTE DE LA UPB
    //public static final String HZRNEHL_QUERY = "SELECT HZRNEHL_FECHA_INICIO, HZRNEHL_FECHA_FIN, HZRNEHL_CANTIDAD, HZRNEHL_ITE_ID FROM UPB_NOMINAE.HZRNEHL"; 
            //public static final String HZRNEHL_QUERY = "SELECT to_date('2021/12/12', 'yyyy/mm/dd') HZRNEHL_FECHA_INICIO, to_date('2021/12/12', 'yyyy/mm/dd') HZRNEHL_FECHA_FIN, 3 HZRNEHL_CANTIDAD, 4 HZRNEHL_ITE_ID FROM DUAL"; 
    
    //public static final String HZRNEOT_QUERY = "SELECT HZRNEOT_DESC_CONCEPTO, HZRNEOT_CONCEP_SALARIAL, HZRNEOT_CONCEP_NO_SALARIAL,HZRNEOT_ITE_ID FROM UPB_NOMINAE.HZRNEOT";
            public static final String HZRNEOT_QUERY = "SELECT 1 HZRNEOT_DESC_CONCEPTO, 2 HZRNEOT_CONCEP_SALARIAL, 3 HZRNEOT_CONCEP_NO_SALARIAL,4 HZRNEOT_ITE_ID FROM DUAL";
    
    //public static final String HZRNECM_QUERY = "SELECT HZRNECM_COMPENS_ORDINARIA, HZRNECM_COMPENS_EXTRAORDINARIA, HZRNECM_ITE_ID FROM UPB_NOMINAE.HZRNECM";
            public static final String HZRNECM_QUERY = "SELECT 1 HZRNECM_COMPENS_ORDINARIA, 2 HZRNECM_COMPENS_EXTRAORDINARIA, 3 HZRNECM_ITE_ID FROM DUAL";
    
    //NO SE EMITIRA POR PARTE DE LA UPB
    //public static final String HZRNEBO_QUERY = "SELECT HZRNEBO_PAGO_SALARIAL, HZRNEBO_PAGO_NO_SALARIAL, HZRNEBO_PAGO_ALIMENT_SALARIAL,HZRNEBO_PAGO_ALIMENT_NO_SALARY, HZRNEBO_ITE_ID FROM UPB_NOMINAE.HZRN"; 
            //public static final String HZRNEBO_QUERY = "SELECT 1 HZRNEBO_PAGO_SALARIAL, 2 HZRNEBO_PAGO_NO_SALARIAL, 3 HZRNEBO_PAGO_ALIMENT_SALARIAL, 4 HZRNEBO_PAGO_ALIMENT_NO_SALARY, 5 HZRNEBO_ITE_ID FROM DUAL";     
    
    //public static final String HZRNECO_QUERY = "SELECT HZRNECO_COMISION, HZRNECO_PAGO_TERCERO, HZRNECO_ANTICIPOS_NOMINA,HZRNECO_ITE_ID FROM UPB_NOMINAE.HZRNECO";
            public static final String HZRNECO_QUERY = "SELECT 1 HZRNECO_COMISION, 2 HZRNECO_PAGO_TERCERO, 3 HZRNECO_ANTICIPOS_NOMINA, 4 HZRNECO_ITE_ID FROM DUAL";
    
    //public static final String HZRNEVO_QUERY = "SELECT HZRNEVO_DOTACION, HZRNEVO_APOYO_SOSTENIMIENT, HZRNEVO_TELETRABAJO,HZRNEVO_BONIF_RETIRO, HZRNEVO_INDEMNIZACION, HZRNEVO_REINTEGRO,HZRNEVO_ITE_ID FROM UPB_NOMINAE.HZRNEVO";
            public static final String HZRNEVO_QUERY = "SELECT 1 HZRNEVO_DOTACION, 2 HZRNEVO_APOYO_SOSTENIMIENT, 3 HZRNEVO_TELETRABAJO, 4 HZRNEVO_BONIF_RETIRO, 5 HZRNEVO_INDEMNIZACION, 6 HZRNEVO_REINTEGRO, 7 HZRNEVO_ITE_ID FROM DUAL";
    
    //public static final String HZRNITS_QUERY = "SELECT HZRNITS_CUNE_INTERNO, HZRNITS_PORCENTAJE, HZRNITS_DEDUCCION,HZRNITS_ID FROM UPB_NOMINAE.HZRNITS";
            public static final String HZRNITS_QUERY = "SELECT 1 HZRNITS_CUNE_INTERNO, 2 HZRNITS_PORCENTAJE, 3 HZRNITS_DEDUCCION, 4 HZRNITS_ID FROM DUAL";
    
    //public static final String HZRNSPE_QUERY = "SELECT HZRNSPE_PORCENTAJE, HZRNSPE_DEDUCCION, HZRNSPE_ITS_ID FROM UPB_NOMINAE.HZRNSPE";
            public static final String HZRNSPE_QUERY = "SELECT 1 HZRNSPE_PORCENTAJE, 2 HZRNSPE_DEDUCCION, 3 HZRNSPE_ITS_ID FROM DUAL";
    
    //public static final String HZRNSSP_QUERY = "SELECT HZRNSSP_PORCENTAJE, HZRNSSP_DEDUC_SEG_PENSIONAL, HZRNSSP_PORCENTAJE_SUBSISTEN,HZRNSSP_DEDUC_SUBSISTEN, HZRNSSP_ITS_ID FROM UPB_NOMINAE.HZRNSSP";
            public static final String HZRNSSP_QUERY = "SELECT 1 HZRNSSP_PORCENTAJE, 2 HZRNSSP_DEDUC_SEG_PENSIONAL, 3 HZRNSSP_PORCENTAJE_SUBSISTEN, 4 HZRNSSP_DEDUC_SUBSISTEN, 5 HZRNSSP_ITS_ID FROM DUAL";
    
    //public static final String HZRNSIN_QUERY = "SELECT HZRNSIN_PORCENTAJE, HZRNSIN_DEDUCCION, HZRNSIN_ITS_ID FROM UPB_NOMINAE.HZRNSIN";
            public static final String HZRNSIN_QUERY = "SELECT 1 HZRNSIN_PORCENTAJE, 2 HZRNSIN_DEDUCCION, 3 HZRNSIN_ITS_ID FROM DUAL";
    
    //NO SE EMITIRA POR PARTE DE LA UPB
    //public static final String HZRNSAN_QUERY = "SELECT HZRNSAN_SANCION_PUBLICA, HZRNSAN_SANCION_PRIVADA, HZRNSAN_ITS_ID FROM UPB_NOMINAE.HZRNSAN"; 
            //public static final String HZRNSAN_QUERY = "SELECT 1 HZRNSAN_SANCION_PUBLICA, 2 HZRNSAN_SANCION_PRIVADA, 3 HZRNSAN_ITS_ID FROM DUAL";
    
    //public static final String HZRNSLI_QUERY = "SELECT HZRNSLI_DESCRIPCION, HZRNSLI_DEDUCCION, HZRNSLI_ITS_ID FROM UPB_NOMINAE.HZRNSLI";
            public static final String HZRNSLI_QUERY = "SELECT 1 HZRNSLI_DESCRIPCION, 2 HZRNSLI_DEDUCCION, 3 HZRNSLI_ITS_ID FROM DUAL";
    
    //public static final String HZRNSOT_QUERY = "SELECT HZRNSOT_PAGO_TERCERO, HZRNSOT_ANTICIPO, HZRNSOT_OTRA_DEDUCCION,HZRNSOT_ITS_ID FROM UPB_NOMINAE.HZRNSOT";
            public static final String HZRNSOT_QUERY = "SELECT 1 HZRNSOT_PAGO_TERCERO, 2 HZRNSOT_ANTICIPO, 3 HZRNSOT_OTRA_DEDUCCION, 4 HZRNSOT_ITS_ID FROM DUAL";
    
    //public static final String HZRNSVA_QUERY = "SELECT HZRNSVA_PENSION_VOLUNTARIA, HZRNSVA_RENTENCION_FTE, HZRNSVA_AFC,HZRNSVA_COOPERATIVA, HZRNSVA_EMBARGO, HZRNSVA_PLAN_COMPLEMENT,HZRNSVA_EDUCACION, HZRNSVA_REINTEGRO, HZRNSVA_DEUDA, HZRNSVA_ITS_ID FROM UPB_NOMINAE.HZRNSVA";
            public static final String HZRNSVA_QUERY = "SELECT 1 HZRNSVA_PENSION_VOLUNTARIA, 2 HZRNSVA_RENTENCION_FTE, 3 HZRNSVA_AFC, 4 HZRNSVA_COOPERATIVA, 5 HZRNSVA_EMBARGO, 6 HZRNSVA_PLAN_COMPLEMENT, 7 HZRNSVA_EDUCACION, 8 HZRNSVA_REINTEGRO, 9 HZRNSVA_DEUDA, 10 HZRNSVA_ITS_ID FROM DUAL";
    
    //public static final String HZRNTOT_QUERY = "SELECT HZRNTOT_CUNE_INTERNO, HZRNTOT_REDONDEO, HZRNTOT_DEVENGADOS_TOTAL,HZRNTOT_DEDUCCIONES_TOTAL, HZRNTOT_COMPROBANTE_TOTAL FROM UPB_NOMINAE.HZRNTOT";
            public static final String HZRNTOT_QUERY = "SELECT 1 HZRNTOT_CUNE_INTERNO, 2 HZRNTOT_REDONDEO, 3 HZRNTOT_DEVENGADOS_TOTAL, 4 HZRNTOT_DEDUCCIONES_TOTAL, 5 HZRNTOT_COMPROBANTE_TOTAL FROM DUAL";

    

    
}
