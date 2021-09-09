
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
    
    public static final String HZRNTIP_QUERY = "";
    
    public static final String HZRNENC_QUERY = "SELECT HZRNENC_CUNE_INTERNO, HZRNENC_TIPO_DOC, HZRNENC_FECHA_ING, HZRNENC_FECHA_RET, HZRNENC_FECHA_LIQ_INI, HZRNENC_FECHA_LIQ_FIN, HZRNENC_TIEMPO_LAB, HZRNENC_FECHA_EMISION, HZRNENC_CODIGO_TRAB, HZRNENC_PREFIJO, HZRNENC_CONSECUTIVO, HZRNENC_NUMERO, HZRNENC_PAIS, HZRNENC_DEPART_ESTADO, HZRNENC_MUNICIPIO_CIUDAD, HZRNENC_IDIOMA, HZRNENC_VERSION, HZRNENC_AMBIENTE, HZRNENC_TIPO_XML, HZRNENC_CUNE, HZRNENC_FECHA_GENERA, HZRNENC_HORA_GENERA, HZRNENC_PERIODO_NOM, HZRNENC_TIPO_MONEDA, HZRNENC_TRM, HZRNENC_NUM_PRED, HZRNENC_CUNE_PRED, HZRNENC_FECHA_GEN_PRED FROM UPB_NOMINAE.HZRNENC";
            //public static final String HZRNENC_QUERY = "SELECT 1 HZRNENC_CUNE_INTERNO, 2 HZRNENC_TIPO_DOC, to_date('2021/12/12', 'yyyy/mm/dd') HZRNENC_FECHA_ING, to_date('2021/12/12', 'yyyy/mm/dd') HZRNENC_FECHA_RET, to_date('2021/12/12', 'yyyy/mm/dd') HZRNENC_FECHA_LIQ_INI, to_date('2021/12/12', 'yyyy/mm/dd') HZRNENC_FECHA_LIQ_FIN, 7 HZRNENC_TIEMPO_LAB, to_date('2021/12/12', 'yyyy/mm/dd') HZRNENC_FECHA_EMISION, 9 HZRNENC_CODIGO_TRAB, 10 HZRNENC_PREFIJO, 11 HZRNENC_CONSECUTIVO, 12 HZRNENC_NUMERO, 13 HZRNENC_PAIS, 14 HZRNENC_DEPART_ESTADO, 15 HZRNENC_MUNICIPIO_CIUDAD, 16 HZRNENC_IDIOMA, 17 HZRNENC_VERSION, 18 HZRNENC_AMBIENTE, 19 HZRNENC_TIPO_XML, 20 HZRNENC_CUNE, to_date('2021/12/12', 'yyyy/mm/dd') HZRNENC_FECHA_GENERA, 22 HZRNENC_HORA_GENERA, 23 HZRNENC_PERIODO_NOM, 24 HZRNENC_TIPO_MONEDA, 25 HZRNENC_TRM, 26 HZRNENC_NUM_PRED, 27 HZRNENC_CUNE_PRED, to_date('2021/12/12', 'yyyy/mm/dd') HZRNENC_FECHA_GEN_PRED FROM dual";
    
    //public static final String HZRNNOV_QUERY = "SELECT HZRNNOV_CUNE_INTERNO, HZRNNOV_NOVEDAD, HZRNNOV_CUNE_NOV FROM UPB_NOMINAE.HZRNNOV";
            public static final String HZRNNOV_QUERY = "SELECT 1 HZRNNOV_CUNE_INTERNO, 2 HZRNNOV_NOVEDAD, 3 HZRNNOV_CUNE_NOV FROM DUAL";
    
    public static final String HZRNNOT_QUERY = "";
            //public static final String HZRNNOT_QUERY = "";
    
    public static final String HZRNEMI_QUERY = "";
            //public static final String HZRNEMI_QUERY = "";
    
    public static final String HZRNREC_QUERY = "";
            //public static final String HZRNREC_QUERY = "";
    
    public static final String HZRNPAG_QUERY = "";
            //public static final String HZRNPAG_QUERY = "";
    
    public static final String HZRNFEP_QUERY = "";
            //public static final String HZRNFEP_QUERY = "";
    
    public static final String HZRNITE_QUERY = "";
            //public static final String HZRNITE_QUERY = "";
    
    public static final String HZRNETR_QUERY = "";
            //public static final String HZRNETR_QUERY = "";
    
    public static final String HZRNEHE_QUERY = "";
            //public static final String HZRNEHE_QUERY = "";
    
    public static final String HZRNEVC_QUERY = "";
            //public static final String HZRNEVC_QUERY = "";
    
    public static final String HZRNEVA_QUERY = "";
            //public static final String HZRNEVA_QUERY = "";
    
    public static final String HZRNEPR_QUERY = "";
            //public static final String HZRNEPR_QUERY = "";
    
    public static final String HZRNECE_QUERY = "";
            //public static final String HZRNECE_QUERY = "";
    
    public static final String HZRNEIN_QUERY = "";
            //public static final String HZRNEIN_QUERY = "";
    
    public static final String HZRNELI_QUERY = "";
            //public static final String HZRNELI_QUERY = "";
    
    public static final String HZRNELR_QUERY = "";
            //public static final String HZRNELR_QUERY = "";
    
    public static final String HZRNELN_QUERY = "";
            //public static final String HZRNELN_QUERY = "";
    
    public static final String HZRNEBN_QUERY = "";
            //public static final String HZRNEBN_QUERY = "";
    
    public static final String HZRNEAX_QUERY = "";
            //public static final String HZRNEAX_QUERY = "";
    
    public static final String HZRNEHL_QUERY = ""; //NO SE EMITIRA POR PARTE DE LA UPB
            //public static final String HZRNEHL_QUERY = ""; //NO SE EMITIRA POR PARTE DE LA UPB
    
    public static final String HZRNEOT_QUERY = "";
            //public static final String HZRNEOT_QUERY = "";
    
    public static final String HZRNECM_QUERY = "";
            //public static final String HZRNECM_QUERY = "";
    
    public static final String HZRNEBO_QUERY = ""; //NO SE EMITIRA POR PARTE DE LA UPB
            //public static final String HZRNEBO_QUERY = ""; //NO SE EMITIRA POR PARTE DE LA UPB
    
    public static final String HZRNECO_QUERY = "";
            //public static final String HZRNECO_QUERY = "";
    
    public static final String HZRNEVO_QUERY = "";
            //public static final String HZRNEVO_QUERY = "";
    
    public static final String HZRNITS_QUERY = "";
            //public static final String HZRNITS_QUERY = "";
    
    public static final String HZRNSPE_QUERY = "";
            //public static final String HZRNSPE_QUERY = "";
    
    public static final String HZRNSSP_QUERY = "";
            //public static final String HZRNSSP_QUERY = "";
    
    public static final String HZRNSIN_QUERY = "";
            //public static final String HZRNSIN_QUERY = "";
    
    public static final String HZRNSAN_QUERY = ""; //NO SE EMITIRA POR PARTE DE LA UPB
            //public static final String HZRNSAN_QUERY = ""; //NO SE EMITIRA POR PARTE DE LA UPB
    
    public static final String HZRNSLI_QUERY = "";
            //public static final String HZRNSLI_QUERY = "";
    
    public static final String HZRNSOT_QUERY = "";
            //public static final String HZRNSOT_QUERY = "";
    
    public static final String HZRNSVA_QUERY = "";
            //public static final String HZRNSVA_QUERY = "";
    
    public static final String HZRNTOT_QUERY = "";
            //public static final String HZRNTOT_QUERY = "";

    

    
}
