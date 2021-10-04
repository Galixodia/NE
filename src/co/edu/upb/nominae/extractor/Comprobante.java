package co.edu.upb.nominae.extractor;

import co.edu.upb.nominae.pojos.*;
import co.edu.upb.mapp.Xml;
import static co.edu.upb.nominae.extractor.Queries.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import co.edu.upb.utilities.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.zip.DataFormatException;
import javax.xml.bind.JAXBException;


/**
 *
 * @author 000329745 Juan Camilo Villa 
 * @since 01/09/2021
 * @version 1.0
 * 
 * documento DB->obj transmicion de documentos soporte de nomina electronica
 * para la UPB a Operador Tecnologico Carvajal.
 * CANAL JDBC
 * FORMATO XML_CARVAJAL
 */
public class Comprobante{
    
    private Connection conn;
    private String stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ResultSet rs_nom;
    private ResultSet rs_ite;
    private ResultSet rs_its;
    private Log log;
    private Calendar calendario;
    private int i;
    public static String AMBIENTE;
    private String prefijo;
    private String num_doc;
    private String cune_interno;
    private String tipo_doc;
    private int ano;
    private int mes;
    private String xml_string;
    public int comp_alive;
    private String local_dir;
    private String log_file_name;
    private String db_url;
    private String db_user;
    private String db_pwd;
    private String sleep_milis;
    private DecimalFormat df;
    private int ite_id;
    private int its_id;
    
    

    public Comprobante(String local_dir, String db_url, String db_user, String db_pwd, String log_file_name, String ambiente, String sleep_milis) throws SQLException, InterruptedException {
        
        AMBIENTE = ambiente;
        
        this.local_dir = local_dir; 
        this.db_url = db_url; 
        this.db_user = db_user; 
        this.db_pwd = db_pwd;
        this.log_file_name = log_file_name;
        this.sleep_milis = sleep_milis;
        
        log = new Log();
        calendario =Calendar.getInstance(); 
        
        calendario =Calendar.getInstance();
        log.logInFile(log_file_name,null, "(" + calendario.getTime() + "): <Comprobante:Comprobante> [" + this.cune_interno + "] (DB) Starting conection to data base.");
        
        Thread.sleep(Integer.valueOf(sleep_milis));
        conn = DriverManager.getConnection(this.db_url, this.db_user, this.db_pwd);

        calendario =Calendar.getInstance();
        log.logInFile(log_file_name,null, "(" + calendario.getTime() + "): <Comprobante:Comprobante> [" + this.cune_interno + "] (DB) Conection to data base successfully.");

        stmt = COM_QUERY;
        pstmt = conn.prepareStatement(stmt);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            cune_interno = rs.getString("HZRNNOM_CUNE_INTERNO");
            tipo_doc = rs.getString("HZRNNOM_TIPO_DOC");
            ano = rs.getInt("HZRNNOM_ANO");
            mes = rs.getInt("HZRNNOM_MES"); 
        }

        if(cune_interno != null && tipo_doc != null){
            
            this.comp_alive = 1;
            System.out.println("INICIO ____________________________________________________________________________");
            System.out.println("CUNE: " + cune_interno);
            System.out.println("TIPO_DOC: " + tipo_doc);
            
        }else{
            this.comp_alive = 0;
        }

        rs_nom = null;
        rs_ite = null;
        rs_its = null;
        
        i = 0; // Iterador para listas

        df = null;
        ite_id = 0;
        its_id = 0;

    }

    public void run() throws SQLException {
        try {

            updateStatus("EXTRACTING");
            getFileExtracted();
            getLocalFile();
            
            if (rs_its != null) {try {rs_its.close();} catch (SQLException e) { /* Ignored */}}
            if (rs_ite != null) {try {rs_ite.close();} catch (SQLException e) { /* Ignored */}}
            if (rs_nom != null) {try {rs_nom.close();} catch (SQLException e) { /* Ignored */}}
            if (rs != null) {try {rs.close();} catch (SQLException e) { /* Ignored */}}
            if (pstmt != null) {try {pstmt.close();} catch (SQLException e) { /* Ignored */}}
            if (conn != null) {try {conn.close();} catch (SQLException e) { /* Ignored */}}
            
        } catch (SQLException ex) {
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:run> [" + cune_interno + "] (DB) Exception in connection with the database: " + ex.getMessage());
        } catch (JAXBException ex) {
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:run> [" + cune_interno + "] (XML) Exception in XML file construction: " + ex.getMessage());
        } catch (DataFormatException ex) {
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:run> [" + cune_interno + "] (FIELD) Exception in field setting: " + ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:run> [" + cune_interno + "] (UTF8) Exception in encoding: " + ex.getMessage());
        } catch (IOException ex) {
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:run> [" + cune_interno + "] (FILE) Exception in file creation: " + ex.getMessage());
        } finally{
            getNullAll();
            if (rs_its != null) {try {rs_its.close();} catch (SQLException e) { /* Ignored */}}
            if (rs_ite != null) {try {rs_ite.close();} catch (SQLException e) { /* Ignored */}}
            if (rs_nom != null) {try {rs_nom.close();} catch (SQLException e) { /* Ignored */}}
            if (rs != null) {try {rs.close();} catch (SQLException e) { /* Ignored */}}
            if (pstmt != null) {try {pstmt.close();} catch (SQLException e) { /* Ignored */}}
            if (conn != null) {try {conn.close();} catch (SQLException e) { /* Ignored */}}
            System.out.println("FIN _______________________________________________________________________________");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }
    
    public void getFileExtracted() throws SQLException, JAXBException, DataFormatException {
        
        calendario =Calendar.getInstance();
        log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> [" + cune_interno + "] Starting getFileExtracted process.");
        
        //PENDIENTE----------------------------------------------------------------------------------------------------------------------------------------    

        if(tipo_doc.equalsIgnoreCase("NominaIndividual")){
            
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividual)> [" + cune_interno + "] (NominaIndividual) Starting extracting process.");          
            
            getComprobanteExtracted();
            
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividual)> [" + cune_interno + "] (NominaIndividual) Extracting process successfully.");
            
            
        }else if(tipo_doc.equalsIgnoreCase("NominaIndividualDeAjusteReemplazar")){
            
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividualDeAjusteReemplazar)> [" + cune_interno + "] (AjusteReemplazar) Starting extracting process.");

            getAdjustmentExtracted();
            
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividualDeAjusteReemplazar)> [" + cune_interno + "] (AjusteReemplazar) Extracting process successfully.");
            
        }else if(tipo_doc.equalsIgnoreCase("NominaIndividualDeAjusteEliminar")){
            
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividualDeAjusteEliminar)> [" + cune_interno + "] (AjusteEliminar) Starting extracting process.");

            getDeletementExtracted();

            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividualDeAjusteEliminar)> [" + cune_interno + "] (AjusteEliminar) Extracting process successfully.");
            
        }
        
        
        calendario =Calendar.getInstance();
        log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> [" + cune_interno + "] getFileExtracted process successfully.");
        
        
        //----------------------------------------------------------------------------------------------------------------------------------------  
    }

    private void getComprobanteExtracted() throws SQLException, DataFormatException, JAXBException  {
        if (!(conn == null)) {
            
            //NOMINA
            {
                
                stmt = NOMINA_QUERY;
                pstmt = conn.prepareStatement(stmt);
                pstmt.setString(1, cune_interno);
                rs_nom = pstmt.executeQuery();
                
                NOMINA nom = new NOMINA();
                if(rs_nom != null){
                    while (rs_nom.next()) {
                        nom.setHZRNNOM_PREFIJO(rs_nom.getString("HZRNNOM_PREFIJO"));
                        nom.setHZRNNOM_CONSECUTIVO_DOC(rs_nom.getInt("HZRNNOM_CONSECUTIVO_DOC"));
                        nom.setHZRNNOM_CUNE_INTERNO(rs_nom.getString("HZRNNOM_CUNE_INTERNO"));
                        nom.setHZRNNOM_TIPO_DOC(rs_nom.getString("HZRNNOM_TIPO_DOC"));
                        nom.setHZRNNOM_ANO(rs_nom.getInt("HZRNNOM_ANO"));
                        nom.setHZRNNOM_MES(rs_nom.getInt("HZRNNOM_MES"));
                        nom.setHZRNNOM_ESTADO(rs_nom.getString("HZRNNOM_ESTADO"));
                        nom.setHZRNNOM_FECHA_EXT(rs_nom.getString("HZRNNOM_FECHA_EXT"));
                        
                    }   
                }else{
                    throw new DataFormatException("Comprobante:getComprobanteExtracted:NOMINA No existen registros");
                }
                
                //ENC
                {
                    stmt = HZRNENC_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                    
                    rs = pstmt.executeQuery();

                    if(rs != null){            
                        while (rs.next()) {
                            ENC enc = new ENC();
                            enc.setHZRNENC_CUNE_INTERNO(rs.getString("HZRNENC_CUNE_INTERNO"));
                            enc.setHZRNENC_TIPO_DOC(rs.getString("HZRNENC_TIPO_DOC"));
                            enc.setHZRNENC_FECHA_ING(rs.getString("HZRNENC_FECHA_ING"));
                            enc.setHZRNENC_FECHA_RET(rs.getString("HZRNENC_FECHA_RET"));
                            enc.setHZRNENC_FECHA_LIQ_INI(rs.getString("HZRNENC_FECHA_LIQ_INI"));
                            enc.setHZRNENC_FECHA_LIQ_FIN(rs.getString("HZRNENC_FECHA_LIQ_FIN"));
                            enc.setHZRNENC_TIEMPO_LAB(rs.getBigDecimal("HZRNENC_TIEMPO_LAB"));
                            enc.setHZRNENC_FECHA_EMISION(rs.getString("HZRNENC_FECHA_EMISION"));
                            enc.setHZRNENC_CODIGO_TRAB(rs.getString("HZRNENC_CODIGO_TRAB"));
                            enc.setHZRNENC_PREFIJO(rs.getString("HZRNENC_PREFIJO"));
                            enc.setHZRNENC_CONSECUTIVO(rs.getLong("HZRNENC_CONSECUTIVO"));
                            enc.setHZRNENC_NUMERO(rs.getString("HZRNENC_NUMERO"));
                            enc.setHZRNENC_PAIS(rs.getString("HZRNENC_PAIS"));
                            enc.setHZRNENC_DEPART_ESTADO(rs.getString("HZRNENC_DEPART_ESTADO"));
                            enc.setHZRNENC_MUNICIPIO_CIUDAD(rs.getString("HZRNENC_MUNICIPIO_CIUDAD"));
                            enc.setHZRNENC_IDIOMA(rs.getString("HZRNENC_IDIOMA"));
                            enc.setHZRNENC_VERSION(rs.getString("HZRNENC_VERSION"));
                            enc.setHZRNENC_AMBIENTE(rs.getInt("HZRNENC_AMBIENTE"));
                            enc.setHZRNENC_TIPO_XML(rs.getInt("HZRNENC_TIPO_XML"));
                            //enc.setHZRNENC_CUNE(rs.getString("HZRNENC_CUNE"));
                            enc.setHZRNENC_FECHA_GENERA(rs.getString("HZRNENC_FECHA_GENERA"));
                            enc.setHZRNENC_HORA_GENERA(rs.getString("HZRNENC_HORA_GENERA"));
                            enc.setHZRNENC_PERIODO_NOM(rs.getInt("HZRNENC_PERIODO_NOM"));
                            enc.setHZRNENC_TIPO_MONEDA(rs.getString("HZRNENC_TIPO_MONEDA"));
                            enc.setHZRNENC_TRM(rs.getBigDecimal("HZRNENC_TRM"));
                            //enc.setHZRNENC_NUM_PRED(rs.getString("HZRNENC_NUM_PRED"));
                            //enc.setHZRNENC_CUNE_PRED(rs.getString("HZRNENC_CUNE_PRED"));
                            //enc.setHZRNENC_FECHA_GEN_PRED(rs.getString("HZRNENC_FECHA_GEN_PRED"));

                            nom.setEncabezado(enc);
                            enc = null;
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:ENC No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [ENC].");
                }
                
                //NOV
                //CARVAJAL QUEDA PENDIENTE DE RVISAR ESTE APARTADO PROQUE SE REFIERE A UN CUNE SOBRE EL DOCUMENTO INDIVIDUAL
//                {
//                    stmt = HZRNNOV_QUERY;
//                    pstmt = conn.prepareStatement(stmt);
//                    pstmt.setString(1, cune_interno);                       
//                    rs = pstmt.executeQuery();
//
//                    if(rs != null){
//                        while (rs.next()) {
//                            NOV nov = new NOV();
//                            nov.setHZRNNOV_CUNE_INTERNO(rs.getString("HZRNNOV_CUNE_INTERNO"));
//                            nov.setHZRNNOV_NOVEDAD(rs.getString("HZRNNOV_NOVEDAD"));
//                            nov.setHZRNNOV_CUNE_NOV(rs.getString("HZRNNOV_CUNE_NOV"));
//
//                            nom.setNovedad(nov);
//                            nov = null;
//                        }
//                    }else{
//                        throw new DataFormatException("Comprobante:getComprobanteExtracted:NOV No existen registros");
//                    }
//                }
                
                //NOT
                {
                    stmt = HZRNNOT_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                      
                    rs = pstmt.executeQuery();
                    
                    i= 0;
                    if(rs != null){
                        while (rs.next()) {
                            NOT not = new NOT();
                            not.setHZRNNOT_CUNE_INTERNO(rs.getString("HZRNNOT_CUNE_INTERNO"));
                            not.setHZRNNOT_NOTAS(rs.getString("HZRNNOT_NOTAS"));                     

                            nom.notas.set(i, not);

    //                        for (int j = 0; j < nom.notas.size(); j++) {
    //                            System.out.println("for:" + j + ":" + nom.notas.get(j));
    //                        }
                            not = null;
                            if (i < nom.notas.size()){i++;}
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:NOT No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [NOT].");
                }
                
                //EMI
                {
                    stmt = HZRNEMI_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                      
                    rs = pstmt.executeQuery();

                    if(rs != null){
                        
                        while (rs.next()) {
                            EMI emi = new EMI();
                            emi.setHZRNEMI_CUNE_INTERNO(rs.getString("HZRNEMI_CUNE_INTERNO"));
                            emi.setHZRNEMI_RAZON_SOCIAL(rs.getString("HZRNEMI_RAZON_SOCIAL"));
                            //emi.setHZRNEMI_PRIMER_APELLIDO(rs.getString("HZRNEMI_PRIMER_APELLIDO"));
                            //emi.setHZRNEMI_SEGUNDO_APELLIDO(rs.getString("HZRNEMI_SEGUNDO_APELLIDO"));
                            //emi.setHZRNEMI_PRIMER_NOMBRE(rs.getString("HZRNEMI_PRIMER_NOMBRE"));
                            //emi.setHZRNEMI_OTROS_NOMBRES(rs.getString("HZRNEMI_OTROS_NOMBRES"));
                            emi.setHZRNEMI_NIT(rs.getLong("HZRNEMI_NIT"));
                            emi.setHZRNEMI_DV(rs.getInt("HZRNEMI_DV"));
                            emi.setHZRNEMI_PAIS(rs.getString("HZRNEMI_PAIS"));
                            emi.setHZRNEMI_DEPART_ESTADO(rs.getString("HZRNEMI_DEPART_ESTADO"));
                            emi.setHZRNEMI_MUNICIPIO_CIUDAD(rs.getString("HZRNEMI_MUNICIPIO_CIUDAD"));
                            emi.setHZRNEMI_DIRECCION(rs.getString("HZRNEMI_DIRECCION"));

                            nom.setEmisor(emi);
                            emi = null;
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:REC No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [EMI].");
                }
                
                //REC
                {
                    stmt = HZRNREC_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                          
                    rs = pstmt.executeQuery();
                    
                    if(rs != null){
                        while (rs.next()) {
                            REC rec = new REC();

                            rec.setHZRNREC_CUNE_INTERNO(rs.getString("HZRNREC_CUNE_INTERNO"));
                            rec.setHZRNREC_TIPO_TRABAJADOR(rs.getString("HZRNREC_TIPO_TRABAJADOR"));
                            rec.setHZRNREC_SUB_TIPO_TRABAJ(rs.getString("HZRNREC_SUB_TIPO_TRABAJ"));
                            rec.setHZRNREC_ALTO_RIESGO_PENS(rs.getString("HZRNREC_ALTO_RIESGO_PENS"));
                            rec.setHZRNREC_TIPO_DOC(rs.getInt("HZRNREC_TIPO_DOC"));
                            rec.setHZRNREC_NUM_DOC(rs.getLong("HZRNREC_NUM_DOC"));
                            rec.setHZRNREC_PRIMER_APELLIDO(rs.getString("HZRNREC_PRIMER_APELLIDO"));
                            rec.setHZRNREC_SEGUNDO_APELLIDO(rs.getString("HZRNREC_SEGUNDO_APELLIDO"));
                            rec.setHZRNREC_PRIMER_NOMBRE(rs.getString("HZRNREC_PRIMER_NOMBRE"));
                            rec.setHZRNREC_OTROS_NOMBRES(rs.getString("HZRNREC_OTROS_NOMBRES"));
                            rec.setHZRNREC_LUGAR_TRAB_PAIS(rs.getString("HZRNREC_LUGAR_TRAB_PAIS"));
                            rec.setHZRNREC_LUGAR_TRAB_DEPT_EST(rs.getString("HZRNREC_LUGAR_TRAB_DEPT_EST"));
                            rec.setHZRNREC_LUGAR_TRAB_MUN_CIUD(rs.getString("HZRNREC_LUGAR_TRAB_MUN_CIUD"));
                            rec.setHZRNREC_LUGAR_TRAB_DIREC(rs.getString("HZRNREC_LUGAR_TRAB_DIREC"));
                            rec.setHZRNREC_SALARIO_INTEGRAL(rs.getString("HZRNREC_SALARIO_INTEGRAL"));
                            rec.setHZRNREC_TIPO_CONTRATO(rs.getInt("HZRNREC_TIPO_CONTRATO"));
                            rec.setHZRNREC_SUELDO(rs.getBigDecimal("HZRNREC_SUELDO"));
                            rec.setHZRNREC_COD_TRABAJADOR(rs.getString("HZRNREC_COD_TRABAJADOR"));

                            nom.setReceptor(rec);
                            rec = null;
                        }
                    }else{
                        
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:REC No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [REC].");
                }
                
                //PAG
                {
                    stmt = HZRNPAG_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                      
                    rs = pstmt.executeQuery();

                    if(rs != null){
                        while (rs.next()) {
                            PAG pag = new PAG();
                            pag.setHZRNPAG_CUNE_INTERNO(rs.getString("HZRNPAG_CUNE_INTERNO"));
                            pag.setHZRNPAG_FORMA_PAGO(rs.getInt("HZRNPAG_FORMA_PAGO"));
                            pag.setHZRNPAG_METODO_PAGO(rs.getString("HZRNPAG_METODO_PAGO"));
                            pag.setHZRNPAG_BANCO(rs.getString("HZRNPAG_BANCO"));
                            pag.setHZRNPAG_TIPO_CUENTA(rs.getString("HZRNPAG_TIPO_CUENTA"));
                            pag.setHZRNPAG_NUM_CUENTA(rs.getString("HZRNPAG_NUM_CUENTA"));                

                            nom.setPago(pag);
                            pag = null;
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:FEP No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [PAG].");
                }
                
                //FEP
                {
                    stmt = HZRNFEP_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                      
                    rs = pstmt.executeQuery();

                    i = 0;
                    if(rs != null){
                        while (rs.next()) {
                        FEP fep = new FEP();
                        fep.setHZRNFEP_CUNE_INTERNO(rs.getString("HZRNFEP_CUNE_INTERNO"));
                        fep.setHZRNFEP_FECHA_PAGO(rs.getString("HZRNFEP_FECHA_PAGO"));

                        nom.fecha_pagos.set(i, fep);
                        fep = null;
                        if (i < nom.fecha_pagos.size()){i++;}
                    } 
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:FEP No existen registros");
                    }     
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [FEP].");
                }
                
                //ITE
                {
                    stmt = HZRNITE_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);
                    rs_ite = pstmt.executeQuery();

                    ITE ite = new ITE();
                    if(rs != null){
                        while (rs_ite.next()) {
                            ite.setHZRNITE_CUNE_INTERNO(rs_ite.getString("HZRNITE_CUNE_INTERNO"));
                            ite.setHZRNITE_DIAS_TRAB(rs_ite.getString("HZRNITE_DIAS_TRAB"));
                            ite.setHZRNITE_SUELDO_TRAB(rs_ite.getBigDecimal("HZRNITE_SUELDO_TRAB"));
                            ite.setHZRNITE_ID(rs_ite.getInt("HZRNITE_ID"));
                            nom.setBasico_trab(ite);
                            
                            ite_id = rs_ite.getInt("HZRNITE_ID");
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:ITE No existen registros");
                    }
                    
                    if(ite_id != 0){
                      
                        //ETR
                        {
                            stmt = HZRNETR_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                i = 0;
                                while (rs.next()) {
                                    ETR etr = new ETR();
                                    etr.setHZRNETR_AUX_TRANSPORTE(rs.getBigDecimal("HZRNETR_AUX_TRANSPORTE"));
                                    etr.setHZRNETR_VIAT_MANUT_SALARIAL(rs.getBigDecimal("HZRNETR_VIAT_MANUT_SALARIAL"));
                                    etr.setHZRNETR_VIAT_MANUT_NO_SALARIAL(rs.getBigDecimal("HZRNETR_VIAT_MANUT_NO_SALARIAL"));
                                    etr.setHZRNETR_ITE_ID(rs.getInt("HZRNETR_ITE_ID"));

                                    ite.transporte_pagado_trab.set(i,etr);
                                    etr = null;
                                    if (i < ite.transporte_pagado_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ETR No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ETR].");
                        }

                        //EHE
                        {
                            stmt = HZRNEHE_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                        
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                i = 0;
                                while (rs.next()) {
                                    EHE ehe = new EHE();
                                    ehe.setHZRNEHE_HORAS_EXTRA(rs.getString("HZRNEHE_HORAS_EXTRA"));                
                                    ehe.setHZRNEHE_HORA_INICIO(rs.getString("HZRNEHE_HORA_INICIO"));                
                                    ehe.setHZRNEHE_HORA_FIN(rs.getString("HZRNEHE_HORA_FIN"));                                
                                    ehe.setHZRNEHE_CANTIDAD(rs.getBigDecimal("HZRNEHE_CANTIDAD"));
                                    ehe.setHZRNEHE_PORCENTAJE(rs.getBigDecimal("HZRNEHE_PORCENTAJE"));
                                    ehe.setHZRNEHE_PAGO(rs.getBigDecimal("HZRNEHE_PAGO"));
                                    ehe.setHZRNEHE_ITE_ID(rs.getInt("HZRNEHE_ITE_ID"));

                                    ite.horas_extras_trab.set(i,ehe);
                                    ehe = null;
                                    if (i < ite.horas_extras_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EHE No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EHE].");                        
                        }

                        //EVC
                        {
                            stmt = HZRNEVC_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                         
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                i = 0;
                                while (rs.next()) {
                                    EVC evc = new EVC();
                                    evc.setHZRNEVC_FECHA_INICIO(rs.getString("HZRNEVC_FECHA_INICIO"));                
                                    evc.setHZRNEVC_FECHA_FIN(rs.getString("HZRNEVC_FECHA_FIN"));                
                                    evc.setHZRNEVC_CANTIDAD(rs.getLong("HZRNEVC_CANTIDAD"));                                
                                    evc.setHZRNEVC_PAGO(rs.getBigDecimal("HZRNEVC_PAGO"));
                                    evc.setHZRNEVC_ITE_ID(rs.getInt("HZRNEVC_ITE_ID"));

                                    ite.vacaciones_trabajador.set(i,evc);
                                    evc = null;
                                    if (i < ite.vacaciones_trabajador.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EVC No existen registros");
                            }    
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EVC].");                        
                        }

                        //EVA
                        {
                            stmt = HZRNEVA_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                          
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                i = 0;
                                while (rs.next()) {
                                    EVA eva = new EVA();
                                    eva.setHZRNEVA_CANTIDAD(rs.getLong("HZRNEVA_CANTIDAD"));
                                    eva.setHZRNEVA_PAGO(rs.getBigDecimal("HZRNEVA_PAGO"));
                                    eva.setHZRNEVA_ITE_ID(rs.getInt("HZRNEVA_ITE_ID"));

                                    ite.vacaciones_comp_trab.set(i,eva);
                                    eva = null;
                                    if (i < ite.vacaciones_comp_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EVA No existen registros");
                            }    
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EVA].");                        
                        }

                        //EPR
                        {
                            stmt = HZRNEPR_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                          
                            rs = pstmt.executeQuery();

                            if(rs != null){  
                                while (rs.next()) {
                                    EPR epr = new EPR();
                                    epr.setHZRNEPR_CANTIDAD(rs.getLong("HZRNEPR_CANTIDAD"));
                                    epr.setHZRNEPR_PAGO(rs.getBigDecimal("HZRNEPR_PAGO"));
                                    epr.setHZRNEPR_PAGONS(rs.getBigDecimal("HZRNEPR_PAGONS"));
                                    epr.setHZRNEPR_ITE_ID(rs.getInt("HZRNEPR_ITE_ID"));

                                    ite.setPrimas_trab(epr);
                                    epr = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EPR No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EPR].");                        
                        }

                        //ECE
                        {
                            stmt = HZRNECE_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                         
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                while (rs.next()) {
                                    ECE ece = new ECE();
                                    ece.setHZRNECE_PAGO(rs.getBigDecimal("HZRNECE_PAGO"));
                                    ece.setHZRNECE_PORCENTAJE(rs.getBigDecimal("HZRNECE_PORCENTAJE"));
                                    ece.setHZRNECE_PAGO_INTERESES(rs.getBigDecimal("HZRNECE_PAGO_INTERESES"));
                                    ece.setHZRNECE_ITE_ID(rs.getInt("HZRNECE_ITE_ID"));

                                    ite.setCesantias_trab(ece);
                                    ece = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ECE No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ECE].");                        
                        }

                        //EIN
                        {
                            stmt = HZRNEIN_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                         
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){   
                                while (rs.next()) {
                                    EIN ein = new EIN();
                                    ein.setHZRNEIN_FECHA_INICIO(rs.getString("HZRNEIN_FECHA_INICIO"));
                                    ein.setHZRNEIN_FECHA_FIN(rs.getString("HZRNEIN_FECHA_FIN"));
                                    ein.setHZRNEIN_CANTIDAD(rs.getLong("HZRNEIN_CANTIDAD"));
                                    ein.setHZRNEIN_TIPO(rs.getInt("HZRNEIN_TIPO"));
                                    ein.setHZRNEIN_PAGO(rs.getBigDecimal("HZRNEIN_PAGO"));
                                    ein.setHZRNEIN_ITE_ID(rs.getInt("HZRNEIN_ITE_ID"));

                                    ite.incapacidades_trab.set(i,ein);
                                    ein = null;
                                    if (i < ite.incapacidades_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EIN No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EIN].");                        
                        }

                        //ELI
                        {
                            stmt = HZRNELI_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                          
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    ELI eli = new ELI();
                                    eli.setHZRNELI_FECHA_INICIO(rs.getString("HZRNELI_FECHA_INICIO"));
                                    eli.setHZRNELI_FECHA_FIN(rs.getString("HZRNELI_FECHA_FIN"));
                                    eli.setHZRNELI_CANTIDAD(rs.getLong("HZRNELI_CANTIDAD"));
                                    eli.setHZRNELI_PAGO(rs.getBigDecimal("HZRNELI_PAGO"));
                                    eli.setHZRNELI_ITE_ID(rs.getInt("HZRNELI_ITE_ID"));

                                    ite.licencia_mat_pat.set(i,eli);
                                    eli = null;
                                    if (i < ite.licencia_mat_pat.size()){i++;}

                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ELI No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ELI].");                        
                        }

                        //ELR
                        {
                            stmt = HZRNELR_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                           
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    ELR elr = new ELR();
                                    elr.setHZRNELR_FECHA_INICIO(rs.getString("HZRNELR_FECHA_INICIO"));
                                    elr.setHZRNELR_FECHA_FIN(rs.getString("HZRNELR_FECHA_FIN"));
                                    elr.setHZRNELR_CANTIDAD(rs.getLong("HZRNELR_CANTIDAD"));
                                    elr.setHZRNELR_PAGO(rs.getBigDecimal("HZRNELR_PAGO"));
                                    elr.setHZRNELR_ITE_ID(rs.getInt("HZRNELR_ITE_ID"));

                                    ite.licencia_remunerada.set(i,elr);
                                    elr = null;       
                                    if (i < ite.licencia_remunerada.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ELR No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ELR].");                        
                        }

                        //ELN
                        {
                            stmt = HZRNELN_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                                  
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    ELN eln = new ELN();
                                    eln.setHZRNELN_FECHA_INICIO(rs.getString("HZRNELN_FECHA_INICIO"));
                                    eln.setHZRNELN_FECHA_FIN(rs.getString("HZRNELN_FECHA_FIN"));
                                    eln.setHZRNELN_CANTIDAD(rs.getLong("HZRNELN_CANTIDAD"));
                                    eln.setHZRNELN_ITE_ID(rs.getInt("HZRNELN_ITE_ID"));

                                    ite.licencia_no_remunerada.set(i,eln);
                                    eln = null;
                                    if (i < ite.licencia_no_remunerada.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ELN No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ELN].");                        
                        }

                        //EBN
                        {
                            stmt = HZRNEBN_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                                  
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    EBN ebn = new EBN();
                                    ebn.setHZRNEBN_BONI_SALARIAL(rs.getBigDecimal("HZRNEBN_BONI_SALARIAL"));
                                    ebn.setHZRNEBN_BONI_NO_SALARIAL(rs.getBigDecimal("HZRNEBN_BONI_NO_SALARIAL"));
                                    ebn.setHZRNEBN_ITE_ID(rs.getInt("HZRNEBN_ITE_ID"));

                                    ite.bonificacion_para_trab.set(i,ebn);
                                    ebn = null;
                                    if (i < ite.bonificacion_para_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EBN No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EBN].");                        
                        }

                        //EAX
                        {
                            stmt = HZRNEAX_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                          
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    EAX eax = new EAX();
                                    eax.setHZRNEAX_AUX_SALARIAL(rs.getBigDecimal("HZRNEAX_AUX_SALARIAL"));
                                    eax.setHZRNEAX_AUX_NO_SALARIAL(rs.getBigDecimal("HZRNEAX_AUX_NO_SALARIAL"));
                                    eax.setHZRNEAX_ITE_ID(rs.getInt("HZRNEAX_ITE_ID"));

                                    ite.auxilio_trab.set(i,eax);
                                    eax = null;
                                    if (i < ite.auxilio_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EAX No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EAX].");                        
                        }

                         //EHL //NO SE EMITIRA POR PARTE DE LA UPB
    //                {
    //                    stmt = HZRNEHL_QUERY;
    //                    pstmt = conn.prepareStatement(stmt);
    //                    pstmt.setInt(1, ite_id);                                
    //                    rs = pstmt.executeQuery();
    //        
    //                    i = 0;
    //                    if(rs != null){
    //                        while (rs.next()) {
    //                            EHL ehl = new EHL();                  
    //                            ehl.setHZRNEHL_FECHA_INICIO(rs.getString("HZRNEHL_FECHA_INICIO"));
    //                            ehl.setHZRNEHL_FECHA_FIN(rs.getString("HZRNEHL_FECHA_FIN"));
    //                            ehl.setHZRNEHL_CANTIDAD(rs.getLong("HZRNEHL_CANTIDAD"));
    //                            ehl.setHZRNEHL_ITE_ID(rs.getInt("HZRNEHL_ITE_ID"));
    //
    //                            ite.huelgas_legales.set(i,ehl);
    //                            ehl = null;
    //                            if (i < ite.huelgas_legales.size()){i++;}
    //                        }
    //                    }else{
    //                          throw new DataFormatException("Comprobante:getComprobanteExtracted:EHL No existen registros");
    //                    }
    //                } 

                        //EOT
                        {
                            stmt = HZRNEOT_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                            
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    EOT eot = new EOT();
                                    eot.setHZRNEOT_DESC_CONCEPTO(rs.getString("HZRNEOT_DESC_CONCEPTO"));
                                    eot.setHZRNEOT_CONCEP_SALARIAL(rs.getBigDecimal("HZRNEOT_CONCEP_SALARIAL"));
                                    eot.setHZRNEOT_CONCEP_NO_SALARIAL(rs.getBigDecimal("HZRNEOT_CONCEP_NO_SALARIAL"));
                                    eot.setHZRNEOT_ITE_ID(rs.getInt("HZRNEOT_ITE_ID"));

                                    ite.otros_conceptos_trab.set(i,eot);
                                    eot = null;
                                    if (i < ite.otros_conceptos_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EOT No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EOT].");                        
                        }  

                        //ECM
                        {
                            stmt = HZRNECM_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                         
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    ECM ecm = new ECM();
                                    ecm.setHZRNECM_COMPENS_ORDINARIA(rs.getBigDecimal("HZRNECM_COMPENS_ORDINARIA"));
                                    ecm.setHZRNECM_COMPENS_EXTRAORDINARIA(rs.getBigDecimal("HZRNECM_COMPENS_EXTRAORDINARIA"));
                                    ecm.setHZRNECM_ITE_ID(rs.getInt("HZRNECM_ITE_ID"));

                                    ite.compensaciones_dev_trab.set(i,ecm);
                                    ecm = null;
                                    if (i < ite.compensaciones_dev_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ECM No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ECM].");                        
                        }   

                        //EBO //NO SE EMITIRA POR PARTE DE LA UPB
    //                    {
    //                        stmt = HZRNEBO_QUERY;
    //                        pstmt = conn.prepareStatement(stmt);
    //                        pstmt.setInt(1, ite_id);                     
    //                        rs = pstmt.executeQuery();
    //
    //                        i = 0;
    //                        if(rs != null){
    //                            while (rs.next()) {
    //                                EBO ebo = new EBO();               
    //                                ebo.setHZRNEBO_PAGO_SALARIAL(rs.getBigDecimal("HZRNEBO_PAGO_SALARIAL"));
    //                                ebo.setHZRNEBO_PAGO_NO_SALARIAL(rs.getBigDecimal("HZRNEBO_PAGO_NO_SALARIAL"));
    //                                ebo.setHZRNEBO_PAGO_ALIMENT_SALARIAL(rs.getBigDecimal("HZRNEBO_PAGO_ALIMENT_SALARIAL"));
    //                                ebo.setHZRNEBO_PAGO_ALIMENT_NO_SALARY(rs.getBigDecimal("HZRNEBO_PAGO_ALIMENT_NO_SALARY"));
    //                                ebo.setHZRNEBO_ITE_ID(rs.getInt("HZRNEBO_ITE_ID"));
    //
    //                                ite.bonos_pagados_electro.set(i,ebo);
    //                                ecm = ebo;
    //                                if (i < ite.bonos_pagados_electro.size()){i++;}
    //                            }
    //                        }else{
    //                              throw new DataFormatException("Comprobante:getComprobanteExtracted:EBO No existen registros");
    //                        }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EBO].");                    
    //                    }

                        //ECO
                        {
                            stmt = HZRNECO_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                         
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    ECO eco = new ECO();
                                    eco.setHZRNECO_COMISION(rs.getBigDecimal("HZRNECO_COMISION"));
                                    eco.setHZRNECO_PAGO_TERCERO(rs.getBigDecimal("HZRNECO_PAGO_TERCERO"));
                                    eco.setHZRNECO_ANTICIPOS_NOMINA(rs.getBigDecimal("HZRNECO_ANTICIPOS_NOMINA"));
                                    eco.setHZRNECO_ITE_ID(rs.getInt("HZRNECO_ITE_ID"));

                                    ite.pago_terceros_anticipos_nom.set(i,eco);
                                    eco = null;
                                    if (i < ite.pago_terceros_anticipos_nom.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ECO No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ECO].");                        
                        } 

                        //EVO
                        {
                            stmt = HZRNEVO_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                            
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                while (rs.next()) {
                                    EVO evo = new EVO();
                                    evo.setHZRNEVO_DOTACION(rs.getBigDecimal("HZRNEVO_DOTACION"));
                                    evo.setHZRNEVO_APOYO_SOSTENIMIENT(rs.getBigDecimal("HZRNEVO_APOYO_SOSTENIMIENT"));
                                    evo.setHZRNEVO_TELETRABAJO(rs.getBigDecimal("HZRNEVO_TELETRABAJO"));
                                    evo.setHZRNEVO_BONIF_RETIRO(rs.getBigDecimal("HZRNEVO_BONIF_RETIRO"));
                                    evo.setHZRNEVO_INDEMNIZACION(rs.getBigDecimal("HZRNEVO_INDEMNIZACION"));
                                    evo.setHZRNEVO_REINTEGRO(rs.getBigDecimal("HZRNEVO_REINTEGRO"));
                                    evo.setHZRNEVO_ITE_ID(rs.getInt("HZRNEVO_ITE_ID"));

                                    ite.setOpciones_varias_devengados(evo);
                                    evo = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EVO No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EVO].");                        
                        }
                        
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:ITE No existen registros");
                    }
                          
                    nom.setBasico_trab(ite);
                    ite  = null;
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [ITE].");
                }
                
                //ITS
                {
                    stmt = HZRNITS_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                    
                    rs_its = pstmt.executeQuery();
                    

                    ITS its = new ITS();
                    if(rs != null){
                        while (rs_its.next()) {
                            its.setHZRNITS_CUNE_INTERNO(rs_its.getString("HZRNITS_CUNE_INTERNO"));
                            its.setHZRNITS_PORCENTAJE(rs_its.getBigDecimal("HZRNITS_PORCENTAJE"));
                            its.setHZRNITS_DEDUCCION(rs_its.getBigDecimal("HZRNITS_DEDUCCION"));
                            its.setHZRNITS_ID(rs_its.getInt("HZRNITS_ID"));

                            nom.setDeducciones_salud(its);
                            
                            its_id = rs_its.getInt("HZRNITS_ID");
                            
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:ITS No existen registros");
                    }
                    
                    if(its_id != 0){
                    
                        //SPE
                        {
                            stmt = HZRNSPE_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1,its_id);
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                while (rs.next()) {
                                    SPE spe = new SPE();
                                    spe.setHZRNSPE_PORCENTAJE(rs.getBigDecimal("HZRNSPE_PORCENTAJE"));
                                    spe.setHZRNSPE_DEDUCCION(rs.getBigDecimal("HZRNSPE_DEDUCCION"));
                                    spe.setHZRNSPE_ITS_ID(rs.getInt("HZRNSPE_ITS_ID"));

                                    its.setDeducciones_pension(spe);
                                    spe = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SPE No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SPE].");                        
                        }

                        //SSP
                        {
                            stmt = HZRNSSP_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, its_id);                        
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                while (rs.next()) {
                                    SSP ssp = new SSP();
                                    ssp.setHZRNSSP_PORCENTAJE(rs.getBigDecimal("HZRNSSP_PORCENTAJE"));
                                    ssp.setHZRNSSP_DEDUC_SEG_PENSIONAL(rs.getBigDecimal("HZRNSSP_DEDUC_SEG_PENSIONAL"));
                                    ssp.setHZRNSSP_PORCENTAJE_SUBSISTEN(rs.getBigDecimal("HZRNSSP_PORCENTAJE_SUBSISTEN"));
                                    ssp.setHZRNSSP_DEDUC_SUBSISTEN(rs.getBigDecimal("HZRNSSP_DEDUC_SUBSISTEN"));
                                    ssp.setHZRNSSP_ITS_ID(rs.getInt("HZRNSSP_ITS_ID"));

                                    its.setDeduc_fondo_seguridad_p(ssp);
                                    ssp = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SSP No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SSP].");                        
                        }  

                        //SIN
                        {
                            stmt = HZRNSIN_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, its_id);                          
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    SIN sin = new SIN();
                                    sin.setHZRNSIN_PORCENTAJE(rs.getBigDecimal("HZRNSIN_PORCENTAJE"));
                                    sin.setHZRNSIN_DEDUCCION(rs.getBigDecimal("HZRNSIN_DEDUCCION"));
                                    sin.setHZRNSIN_ITS_ID(rs.getInt("HZRNSIN_ITS_ID"));

                                    its.deduc_sindicatos.set(i,sin);
                                    sin = null;
                                    if (i < its.deduc_sindicatos.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SIN No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SIN].");                                                
                        } 

                      //SAN
    //                {
    //                    stmt = HZRNSAN_QUERY;
    //                    pstmt = conn.prepareStatement(stmt);
    //                    pstmt.setInt(1, its_id);                      
    //                    rs = pstmt.executeQuery();
    //        
    //                    i= 0;
    //                    if(rs != null){
    //                        while (rs.next()) {
    //                            SAN san = new SAN();                
    //                            san.setHZRNSAN_SANCION_PUBLICA(rs.getBigDecimal("HZRNSAN_SANCION_PUBLICA"));
    //                            san.setHZRNSAN_SANCION_PRIVADA(rs.getBigDecimal("HZRNSAN_SANCION_PRIVADA"));
    //                            san.setHZRNSAN_ITS_ID(rs.getInt("HZRNSAN_ITS_ID"));
    //
    //                            its.deduc_varias.set(i,san);
    //                            san = null;
    //                            if (i < its.deduc_varias.size()){i++;}
    //                        }
    //                    }else{
    //                          throw new DataFormatException("Comprobante:getComprobanteExtracted:SAN No existen registros");
    //                    }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SAN].");                                            
    //                }  

                        //SLI
                        {
                            stmt = HZRNSLI_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, its_id);                           
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    SLI sli = new SLI();
                                    sli.setHZRNSLI_DESCRIPCION(rs.getString("HZRNSLI_DESCRIPCION"));
                                    sli.setHZRNSLI_DEDUCCION(rs.getBigDecimal("HZRNSLI_DEDUCCION"));
                                    sli.setHZRNSLI_ITS_ID(rs.getInt("HZRNSLI_ITS_ID"));

                                    its.deduc_libranza.set(i,sli);
                                    sli = null;
                                    if (i < its.deduc_libranza.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SLI No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SLI].");                                                
                        }   

                        //SOT
                        {
                            stmt = HZRNSOT_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, its_id);                           
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                 while (rs.next()) {
                                    SOT sot = new SOT();
                                    sot.setHZRNSOT_PAGO_TERCERO(rs.getBigDecimal("HZRNSOT_PAGO_TERCERO"));
                                    sot.setHZRNSOT_ANTICIPO(rs.getBigDecimal("HZRNSOT_ANTICIPO"));
                                    sot.setHZRNSOT_OTRA_DEDUCCION(rs.getBigDecimal("HZRNSOT_OTRA_DEDUCCION"));
                                    sot.setHZRNSOT_ITS_ID(rs.getInt("HZRNSOT_ITS_ID"));

                                    its.otras_deduc.set(i,sot);
                                    sot = null;
                                    if (i < its.otras_deduc.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SOT No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SOT].");                                                
                        }

                        //SVA
                        {
                            stmt = HZRNSVA_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, its_id);                                 
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                while (rs.next()) {
                                    SVA sva = new SVA();
                                    sva.setHZRNSVA_PENSION_VOLUNTARIA(rs.getBigDecimal("HZRNSVA_PENSION_VOLUNTARIA"));
                                    sva.setHZRNSVA_RENTENCION_FTE(rs.getBigDecimal("HZRNSVA_RENTENCION_FTE"));
                                    sva.setHZRNSVA_AFC(rs.getBigDecimal("HZRNSVA_AFC"));
                                    sva.setHZRNSVA_COOPERATIVA(rs.getBigDecimal("HZRNSVA_COOPERATIVA"));
                                    sva.setHZRNSVA_EMBARGO(rs.getBigDecimal("HZRNSVA_EMBARGO"));
                                    sva.setHZRNSVA_PLAN_COMPLEMENT(rs.getBigDecimal("HZRNSVA_PLAN_COMPLEMENT"));
                                    sva.setHZRNSVA_EDUCACION(rs.getBigDecimal("HZRNSVA_EDUCACION"));
                                    sva.setHZRNSVA_REINTEGRO(rs.getBigDecimal("HZRNSVA_REINTEGRO"));
                                    sva.setHZRNSVA_DEUDA(rs.getBigDecimal("HZRNSVA_DEUDA"));                
                                    sva.setHZRNSVA_ITS_ID(rs.getInt("HZRNSVA_ITS_ID"));

                                    its.setDeduc_varias(sva);
                                    sva = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SVA No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SVA].");                                                
                        } 
                        
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:ITS No existen registros");
                    }
                    
                    nom.setDeducciones_salud(its);
                    its = null;
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [ITS].");
                }
                
                 //TOT
                {
                    stmt = HZRNTOT_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                           
                    rs = pstmt.executeQuery();

                    if(rs != null){
                        while (rs.next()) {
                            TOT tot = new TOT();
                            tot.setHZRNTOT_CUNE_INTERNO(rs.getString("HZRNTOT_CUNE_INTERNO"));
                            tot.setHZRNTOT_REDONDEO(rs.getBigDecimal("HZRNTOT_REDONDEO"));
                            tot.setHZRNTOT_DEVENGADOS_TOTAL(rs.getBigDecimal("HZRNTOT_DEVENGADOS_TOTAL"));
                            tot.setHZRNTOT_DEDUCCIONES_TOTAL(rs.getBigDecimal("HZRNTOT_DEDUCCIONES_TOTAL"));
                            tot.setHZRNTOT_COMPROBANTE_TOTAL(rs.getBigDecimal("HZRNTOT_COMPROBANTE_TOTAL"));

                            nom.setTotales_nomina(tot);
                            tot = null;

//                            Xml xml = new Xml();
//                            
//                            if(nom != null){
//                                xml_string = xml.ObjectToXML(nom);
//                                //System.out.println(xml_string);
//                                
//                                
//                            }else{
//                                throw new DataFormatException("Comprobante:getComprobanteExtracted:TOT No existen registros");
//                            }
//                            
//                            nom = null;
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:TOT No existen registros");
                    }
                     calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [TOT].");
                }
                
                Xml xml = new Xml();
                            
                if(nom != null){
                    xml_string = xml.ObjectToXML(nom);
                    nom = null;
                    xml = null;
                    //System.out.println(xml_string);
                }else{
                    throw new DataFormatException("Comprobante:getComprobanteExtracted: No existen registros");
                }
                
                calendario =Calendar.getInstance();
                log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [NOM].");
            }
 
        
        }else{
            //con es nulo
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");    
        }
    }

    private void getAdjustmentExtracted() throws SQLException, DataFormatException, JAXBException {
        if (!(conn == null)) {
            
            //NOMINA
            {
                
                stmt = NOMINA_QUERY;
                pstmt = conn.prepareStatement(stmt);
                pstmt.setString(1, cune_interno);
                ResultSet rs_nom = pstmt.executeQuery();
                
                NOMINA nom = new NOMINA();
                if(rs_nom != null){
                    while (rs_nom.next()) {
                        nom.setHZRNNOM_PREFIJO(rs_nom.getString("HZRNNOM_PREFIJO"));
                        nom.setHZRNNOM_CONSECUTIVO_DOC(rs_nom.getInt("HZRNNOM_CONSECUTIVO_DOC"));
                        nom.setHZRNNOM_CUNE_INTERNO(rs_nom.getString("HZRNNOM_CUNE_INTERNO"));
                        nom.setHZRNNOM_TIPO_DOC(rs_nom.getString("HZRNNOM_TIPO_DOC"));
                        nom.setHZRNNOM_ANO(rs_nom.getInt("HZRNNOM_ANO"));
                        nom.setHZRNNOM_MES(rs_nom.getInt("HZRNNOM_MES"));
                        nom.setHZRNNOM_ESTADO(rs_nom.getString("HZRNNOM_ESTADO"));
                        nom.setHZRNNOM_FECHA_EXT(rs_nom.getString("HZRNNOM_FECHA_EXT"));
                        
                    }   
                }else{
                    throw new DataFormatException("Comprobante:getComprobanteExtracted:NOMINA No existen registros");
                }
                
                //TIP
                {
                    TIP tip = new TIP(1);
                    nom.setTipo_nota(tip);
                    tip = null;
                }
                
                //ENC
                {
                    stmt = HZRNENC_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                    
                    rs = pstmt.executeQuery();

                    if(rs != null){            
                        while (rs.next()) {
                            ENC enc = new ENC();
                            enc.setHZRNENC_CUNE_INTERNO(rs.getString("HZRNENC_CUNE_INTERNO"));
                            enc.setHZRNENC_TIPO_DOC(rs.getString("HZRNENC_TIPO_DOC"));
                            enc.setHZRNENC_FECHA_ING(rs.getString("HZRNENC_FECHA_ING"));
                            enc.setHZRNENC_FECHA_RET(rs.getString("HZRNENC_FECHA_RET"));
                            enc.setHZRNENC_FECHA_LIQ_INI(rs.getString("HZRNENC_FECHA_LIQ_INI"));
                            enc.setHZRNENC_FECHA_LIQ_FIN(rs.getString("HZRNENC_FECHA_LIQ_FIN"));
                            enc.setHZRNENC_TIEMPO_LAB(rs.getBigDecimal("HZRNENC_TIEMPO_LAB"));
                            enc.setHZRNENC_FECHA_EMISION(rs.getString("HZRNENC_FECHA_EMISION"));
                            enc.setHZRNENC_CODIGO_TRAB(rs.getString("HZRNENC_CODIGO_TRAB"));
                            enc.setHZRNENC_PREFIJO(rs.getString("HZRNENC_PREFIJO"));
                            enc.setHZRNENC_CONSECUTIVO(rs.getLong("HZRNENC_CONSECUTIVO"));
                            enc.setHZRNENC_NUMERO(rs.getString("HZRNENC_NUMERO"));
                            enc.setHZRNENC_PAIS(rs.getString("HZRNENC_PAIS"));
                            enc.setHZRNENC_DEPART_ESTADO(rs.getString("HZRNENC_DEPART_ESTADO"));
                            enc.setHZRNENC_MUNICIPIO_CIUDAD(rs.getString("HZRNENC_MUNICIPIO_CIUDAD"));
                            enc.setHZRNENC_IDIOMA(rs.getString("HZRNENC_IDIOMA"));
                            enc.setHZRNENC_VERSION(rs.getString("HZRNENC_VERSION"));
                            enc.setHZRNENC_AMBIENTE(rs.getInt("HZRNENC_AMBIENTE"));
                            enc.setHZRNENC_TIPO_XML(rs.getInt("HZRNENC_TIPO_XML"));
                            //enc.setHZRNENC_CUNE(rs.getString("HZRNENC_CUNE"));
                            enc.setHZRNENC_FECHA_GENERA(rs.getString("HZRNENC_FECHA_GENERA"));
                            enc.setHZRNENC_HORA_GENERA(rs.getString("HZRNENC_HORA_GENERA"));
                            enc.setHZRNENC_PERIODO_NOM(rs.getInt("HZRNENC_PERIODO_NOM"));
                            enc.setHZRNENC_TIPO_MONEDA(rs.getString("HZRNENC_TIPO_MONEDA"));
                            enc.setHZRNENC_TRM(rs.getBigDecimal("HZRNENC_TRM"));
                            enc.setHZRNENC_NUM_PRED(rs.getString("HZRNENC_NUM_PRED"));
                            //enc.setHZRNENC_CUNE_PRED(rs.getString("HZRNENC_CUNE_PRED"));
                            enc.setHZRNENC_FECHA_GEN_PRED(rs.getString("HZRNENC_FECHA_GEN_PRED"));

                            nom.setEncabezado(enc);
                            enc = null;
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:ENC No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [ENC].");
                }

                //NOT
                {
                    stmt = HZRNNOT_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                      
                    rs = pstmt.executeQuery();
                    
                    i= 0;
                    if(rs != null){
                        while (rs.next()) {
                            NOT not = new NOT();
                            not.setHZRNNOT_CUNE_INTERNO(rs.getString("HZRNNOT_CUNE_INTERNO"));
                            not.setHZRNNOT_NOTAS(rs.getString("HZRNNOT_NOTAS"));                     

                            nom.notas.set(i, not);

    //                        for (int j = 0; j < nom.notas.size(); j++) {
    //                            System.out.println("for:" + j + ":" + nom.notas.get(j));
    //                        }
                            not = null;
                            if (i < nom.notas.size()){i++;}
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:NOT No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [NOT].");
                }
                
                //EMI
                {
                    stmt = HZRNEMI_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                      
                    rs = pstmt.executeQuery();

                    if(rs != null){
                        
                        while (rs.next()) {
                            EMI emi = new EMI();
                            emi.setHZRNEMI_CUNE_INTERNO(rs.getString("HZRNEMI_CUNE_INTERNO"));
                            emi.setHZRNEMI_RAZON_SOCIAL(rs.getString("HZRNEMI_RAZON_SOCIAL"));
                            //emi.setHZRNEMI_PRIMER_APELLIDO(rs.getString("HZRNEMI_PRIMER_APELLIDO"));
                            //emi.setHZRNEMI_SEGUNDO_APELLIDO(rs.getString("HZRNEMI_SEGUNDO_APELLIDO"));
                            //emi.setHZRNEMI_PRIMER_NOMBRE(rs.getString("HZRNEMI_PRIMER_NOMBRE"));
                            //emi.setHZRNEMI_OTROS_NOMBRES(rs.getString("HZRNEMI_OTROS_NOMBRES"));
                            emi.setHZRNEMI_NIT(rs.getLong("HZRNEMI_NIT"));
                            emi.setHZRNEMI_DV(rs.getInt("HZRNEMI_DV"));
                            emi.setHZRNEMI_PAIS(rs.getString("HZRNEMI_PAIS"));
                            emi.setHZRNEMI_DEPART_ESTADO(rs.getString("HZRNEMI_DEPART_ESTADO"));
                            emi.setHZRNEMI_MUNICIPIO_CIUDAD(rs.getString("HZRNEMI_MUNICIPIO_CIUDAD"));
                            emi.setHZRNEMI_DIRECCION(rs.getString("HZRNEMI_DIRECCION"));

                            nom.setEmisor(emi);
                            emi = null;
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:REC No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [EMI].");
                }
                
                //REC
                {
                    stmt = HZRNREC_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                          
                    rs = pstmt.executeQuery();
                    
                    if(rs != null){
                        while (rs.next()) {
                            REC rec = new REC();

                            rec.setHZRNREC_CUNE_INTERNO(rs.getString("HZRNREC_CUNE_INTERNO"));
                            rec.setHZRNREC_TIPO_TRABAJADOR(rs.getString("HZRNREC_TIPO_TRABAJADOR"));
                            rec.setHZRNREC_SUB_TIPO_TRABAJ(rs.getString("HZRNREC_SUB_TIPO_TRABAJ"));
                            rec.setHZRNREC_ALTO_RIESGO_PENS(rs.getString("HZRNREC_ALTO_RIESGO_PENS"));
                            rec.setHZRNREC_TIPO_DOC(rs.getInt("HZRNREC_TIPO_DOC"));
                            rec.setHZRNREC_NUM_DOC(rs.getLong("HZRNREC_NUM_DOC"));
                            rec.setHZRNREC_PRIMER_APELLIDO(rs.getString("HZRNREC_PRIMER_APELLIDO"));
                            rec.setHZRNREC_SEGUNDO_APELLIDO(rs.getString("HZRNREC_SEGUNDO_APELLIDO"));
                            rec.setHZRNREC_PRIMER_NOMBRE(rs.getString("HZRNREC_PRIMER_NOMBRE"));
                            rec.setHZRNREC_OTROS_NOMBRES(rs.getString("HZRNREC_OTROS_NOMBRES"));
                            rec.setHZRNREC_LUGAR_TRAB_PAIS(rs.getString("HZRNREC_LUGAR_TRAB_PAIS"));
                            rec.setHZRNREC_LUGAR_TRAB_DEPT_EST(rs.getString("HZRNREC_LUGAR_TRAB_DEPT_EST"));
                            rec.setHZRNREC_LUGAR_TRAB_MUN_CIUD(rs.getString("HZRNREC_LUGAR_TRAB_MUN_CIUD"));
                            rec.setHZRNREC_LUGAR_TRAB_DIREC(rs.getString("HZRNREC_LUGAR_TRAB_DIREC"));
                            rec.setHZRNREC_SALARIO_INTEGRAL(rs.getString("HZRNREC_SALARIO_INTEGRAL"));
                            rec.setHZRNREC_TIPO_CONTRATO(rs.getInt("HZRNREC_TIPO_CONTRATO"));
                            rec.setHZRNREC_SUELDO(rs.getBigDecimal("HZRNREC_SUELDO"));
                            rec.setHZRNREC_COD_TRABAJADOR(rs.getString("HZRNREC_COD_TRABAJADOR"));

                            nom.setReceptor(rec);
                            rec = null;
                        }
                    }else{
                        
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:REC No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [REC].");
                }
                
                //PAG
                {
                    stmt = HZRNPAG_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                      
                    rs = pstmt.executeQuery();

                    if(rs != null){
                        while (rs.next()) {
                            PAG pag = new PAG();
                            pag.setHZRNPAG_CUNE_INTERNO(rs.getString("HZRNPAG_CUNE_INTERNO"));
                            pag.setHZRNPAG_FORMA_PAGO(rs.getInt("HZRNPAG_FORMA_PAGO"));
                            pag.setHZRNPAG_METODO_PAGO(rs.getString("HZRNPAG_METODO_PAGO"));
                            pag.setHZRNPAG_BANCO(rs.getString("HZRNPAG_BANCO"));
                            pag.setHZRNPAG_TIPO_CUENTA(rs.getString("HZRNPAG_TIPO_CUENTA"));
                            pag.setHZRNPAG_NUM_CUENTA(rs.getString("HZRNPAG_NUM_CUENTA"));                

                            nom.setPago(pag);
                            pag = null;
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:FEP No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [PAG].");
                }
                
                //FEP
                {
                    stmt = HZRNFEP_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                      
                    rs = pstmt.executeQuery();

                    i = 0;
                    if(rs != null){
                        while (rs.next()) {
                        FEP fep = new FEP();
                        fep.setHZRNFEP_CUNE_INTERNO(rs.getString("HZRNFEP_CUNE_INTERNO"));
                        fep.setHZRNFEP_FECHA_PAGO(rs.getString("HZRNFEP_FECHA_PAGO"));

                        nom.fecha_pagos.set(i, fep);
                        fep = null;
                        if (i < nom.fecha_pagos.size()){i++;}
                    } 
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:FEP No existen registros");
                    }     
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [FEP].");
                }
                
                //ITE
                {
                    stmt = HZRNITE_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);
                    ResultSet rs_ite = pstmt.executeQuery();

                    ITE ite = new ITE();
                    if(rs != null){
                        while (rs_ite.next()) {
                            ite.setHZRNITE_CUNE_INTERNO(rs_ite.getString("HZRNITE_CUNE_INTERNO"));
                            ite.setHZRNITE_DIAS_TRAB(rs_ite.getString("HZRNITE_DIAS_TRAB"));
                            ite.setHZRNITE_SUELDO_TRAB(rs_ite.getBigDecimal("HZRNITE_SUELDO_TRAB"));
                            ite.setHZRNITE_ID(rs_ite.getInt("HZRNITE_ID"));
                            nom.setBasico_trab(ite);
                            
                            ite_id = rs_ite.getInt("HZRNITE_ID");
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:ITE No existen registros");
                    }

                    
                    if(ite_id != 0){
                    
                        //ETR
                        {
                            stmt = HZRNETR_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                i = 0;
                                while (rs.next()) {
                                    ETR etr = new ETR();
                                    etr.setHZRNETR_AUX_TRANSPORTE(rs.getBigDecimal("HZRNETR_AUX_TRANSPORTE"));
                                    etr.setHZRNETR_VIAT_MANUT_SALARIAL(rs.getBigDecimal("HZRNETR_VIAT_MANUT_SALARIAL"));
                                    etr.setHZRNETR_VIAT_MANUT_NO_SALARIAL(rs.getBigDecimal("HZRNETR_VIAT_MANUT_NO_SALARIAL"));
                                    etr.setHZRNETR_ITE_ID(rs.getInt("HZRNETR_ITE_ID"));

                                    ite.transporte_pagado_trab.set(i,etr);
                                    etr = null;
                                    if (i < ite.transporte_pagado_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ETR No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ETR].");
                        }

                        //EHE
                        {
                            stmt = HZRNEHE_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                        
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                i = 0;
                                while (rs.next()) {
                                    EHE ehe = new EHE();
                                    ehe.setHZRNEHE_HORAS_EXTRA(rs.getString("HZRNEHE_HORAS_EXTRA"));                
                                    ehe.setHZRNEHE_HORA_INICIO(rs.getString("HZRNEHE_HORA_INICIO"));                
                                    ehe.setHZRNEHE_HORA_FIN(rs.getString("HZRNEHE_HORA_FIN"));                                
                                    ehe.setHZRNEHE_CANTIDAD(rs.getBigDecimal("HZRNEHE_CANTIDAD"));
                                    ehe.setHZRNEHE_PORCENTAJE(rs.getBigDecimal("HZRNEHE_PORCENTAJE"));
                                    ehe.setHZRNEHE_PAGO(rs.getBigDecimal("HZRNEHE_PAGO"));
                                    ehe.setHZRNEHE_ITE_ID(rs.getInt("HZRNEHE_ITE_ID"));

                                    ite.horas_extras_trab.set(i,ehe);
                                    ehe = null;
                                    if (i < ite.horas_extras_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EHE No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EHE].");                        
                        }

                        //EVC
                        {
                            stmt = HZRNEVC_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                         
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                i = 0;
                                while (rs.next()) {
                                    EVC evc = new EVC();
                                    evc.setHZRNEVC_FECHA_INICIO(rs.getString("HZRNEVC_FECHA_INICIO"));                
                                    evc.setHZRNEVC_FECHA_FIN(rs.getString("HZRNEVC_FECHA_FIN"));                
                                    evc.setHZRNEVC_CANTIDAD(rs.getLong("HZRNEVC_CANTIDAD"));                                
                                    evc.setHZRNEVC_PAGO(rs.getBigDecimal("HZRNEVC_PAGO"));
                                    evc.setHZRNEVC_ITE_ID(rs.getInt("HZRNEVC_ITE_ID"));

                                    ite.vacaciones_trabajador.set(i,evc);
                                    evc = null;
                                    if (i < ite.vacaciones_trabajador.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EVC No existen registros");
                            }    
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EVC].");                        
                        }

                        //EVA
                        {
                            stmt = HZRNEVA_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                          
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                i = 0;
                                while (rs.next()) {
                                    EVA eva = new EVA();
                                    eva.setHZRNEVA_CANTIDAD(rs.getLong("HZRNEVA_CANTIDAD"));
                                    eva.setHZRNEVA_PAGO(rs.getBigDecimal("HZRNEVA_PAGO"));
                                    eva.setHZRNEVA_ITE_ID(rs.getInt("HZRNEVA_ITE_ID"));

                                    ite.vacaciones_comp_trab.set(i,eva);
                                    eva = null;
                                    if (i < ite.vacaciones_comp_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EVA No existen registros");
                            }    
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EVA].");                        
                        }

                        //EPR
                        {
                            stmt = HZRNEPR_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                          
                            rs = pstmt.executeQuery();

                            if(rs != null){  
                                while (rs.next()) {
                                    EPR epr = new EPR();
                                    epr.setHZRNEPR_CANTIDAD(rs.getLong("HZRNEPR_CANTIDAD"));
                                    epr.setHZRNEPR_PAGO(rs.getBigDecimal("HZRNEPR_PAGO"));
                                    epr.setHZRNEPR_PAGONS(rs.getBigDecimal("HZRNEPR_PAGONS"));
                                    epr.setHZRNEPR_ITE_ID(rs.getInt("HZRNEPR_ITE_ID"));

                                    ite.setPrimas_trab(epr);
                                    epr = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EPR No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EPR].");                        
                        }

                        //ECE
                        {
                            stmt = HZRNECE_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                         
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                while (rs.next()) {
                                    ECE ece = new ECE();
                                    ece.setHZRNECE_PAGO(rs.getBigDecimal("HZRNECE_PAGO"));
                                    ece.setHZRNECE_PORCENTAJE(rs.getBigDecimal("HZRNECE_PORCENTAJE"));
                                    ece.setHZRNECE_PAGO_INTERESES(rs.getBigDecimal("HZRNECE_PAGO_INTERESES"));
                                    ece.setHZRNECE_ITE_ID(rs.getInt("HZRNECE_ITE_ID"));

                                    ite.setCesantias_trab(ece);
                                    ece = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ECE No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ECE].");                        
                        }

                        //EIN
                        {
                            stmt = HZRNEIN_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                         
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){   
                                while (rs.next()) {
                                    EIN ein = new EIN();
                                    ein.setHZRNEIN_FECHA_INICIO(rs.getString("HZRNEIN_FECHA_INICIO"));
                                    ein.setHZRNEIN_FECHA_FIN(rs.getString("HZRNEIN_FECHA_FIN"));
                                    ein.setHZRNEIN_CANTIDAD(rs.getLong("HZRNEIN_CANTIDAD"));
                                    ein.setHZRNEIN_TIPO(rs.getInt("HZRNEIN_TIPO"));
                                    ein.setHZRNEIN_PAGO(rs.getBigDecimal("HZRNEIN_PAGO"));
                                    ein.setHZRNEIN_ITE_ID(rs.getInt("HZRNEIN_ITE_ID"));

                                    ite.incapacidades_trab.set(i,ein);
                                    ein = null;
                                    if (i < ite.incapacidades_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EIN No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EIN].");                        
                        }

                        //ELI
                        {
                            stmt = HZRNELI_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                          
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    ELI eli = new ELI();
                                    eli.setHZRNELI_FECHA_INICIO(rs.getString("HZRNELI_FECHA_INICIO"));
                                    eli.setHZRNELI_FECHA_FIN(rs.getString("HZRNELI_FECHA_FIN"));
                                    eli.setHZRNELI_CANTIDAD(rs.getLong("HZRNELI_CANTIDAD"));
                                    eli.setHZRNELI_PAGO(rs.getBigDecimal("HZRNELI_PAGO"));
                                    eli.setHZRNELI_ITE_ID(rs.getInt("HZRNELI_ITE_ID"));

                                    ite.licencia_mat_pat.set(i,eli);
                                    eli = null;
                                    if (i < ite.licencia_mat_pat.size()){i++;}

                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ELI No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ELI].");                        
                        }

                        //ELR
                        {
                            stmt = HZRNELR_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                           
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    ELR elr = new ELR();
                                    elr.setHZRNELR_FECHA_INICIO(rs.getString("HZRNELR_FECHA_INICIO"));
                                    elr.setHZRNELR_FECHA_FIN(rs.getString("HZRNELR_FECHA_FIN"));
                                    elr.setHZRNELR_CANTIDAD(rs.getLong("HZRNELR_CANTIDAD"));
                                    elr.setHZRNELR_PAGO(rs.getBigDecimal("HZRNELR_PAGO"));
                                    elr.setHZRNELR_ITE_ID(rs.getInt("HZRNELR_ITE_ID"));

                                    ite.licencia_remunerada.set(i,elr);
                                    elr = null;       
                                    if (i < ite.licencia_remunerada.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ELR No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ELR].");                        
                        }

                        //ELN
                        {
                            stmt = HZRNELN_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                                  
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    ELN eln = new ELN();
                                    eln.setHZRNELN_FECHA_INICIO(rs.getString("HZRNELN_FECHA_INICIO"));
                                    eln.setHZRNELN_FECHA_FIN(rs.getString("HZRNELN_FECHA_FIN"));
                                    eln.setHZRNELN_CANTIDAD(rs.getLong("HZRNELN_CANTIDAD"));
                                    eln.setHZRNELN_ITE_ID(rs.getInt("HZRNELN_ITE_ID"));

                                    ite.licencia_no_remunerada.set(i,eln);
                                    eln = null;
                                    if (i < ite.licencia_no_remunerada.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ELN No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ELN].");                        
                        }

                        //EBN
                        {
                            stmt = HZRNEBN_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                                  
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    EBN ebn = new EBN();
                                    ebn.setHZRNEBN_BONI_SALARIAL(rs.getBigDecimal("HZRNEBN_BONI_SALARIAL"));
                                    ebn.setHZRNEBN_BONI_NO_SALARIAL(rs.getBigDecimal("HZRNEBN_BONI_NO_SALARIAL"));
                                    ebn.setHZRNEBN_ITE_ID(rs.getInt("HZRNEBN_ITE_ID"));

                                    ite.bonificacion_para_trab.set(i,ebn);
                                    ebn = null;
                                    if (i < ite.bonificacion_para_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EBN No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EBN].");                        
                        }

                        //EAX
                        {
                            stmt = HZRNEAX_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                          
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    EAX eax = new EAX();
                                    eax.setHZRNEAX_AUX_SALARIAL(rs.getBigDecimal("HZRNEAX_AUX_SALARIAL"));
                                    eax.setHZRNEAX_AUX_NO_SALARIAL(rs.getBigDecimal("HZRNEAX_AUX_NO_SALARIAL"));
                                    eax.setHZRNEAX_ITE_ID(rs.getInt("HZRNEAX_ITE_ID"));

                                    ite.auxilio_trab.set(i,eax);
                                    eax = null;
                                    if (i < ite.auxilio_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EAX No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EAX].");                        
                        }

                         //EHL //NO SE EMITIRA POR PARTE DE LA UPB
    //                {
    //                    stmt = HZRNEHL_QUERY;
    //                    pstmt = conn.prepareStatement(stmt);
    //                    pstmt.setInt(1, ite_id);                                
    //                    rs = pstmt.executeQuery();
    //        
    //                    i = 0;
    //                    if(rs != null){
    //                        while (rs.next()) {
    //                            EHL ehl = new EHL();                  
    //                            ehl.setHZRNEHL_FECHA_INICIO(rs.getString("HZRNEHL_FECHA_INICIO"));
    //                            ehl.setHZRNEHL_FECHA_FIN(rs.getString("HZRNEHL_FECHA_FIN"));
    //                            ehl.setHZRNEHL_CANTIDAD(rs.getLong("HZRNEHL_CANTIDAD"));
    //                            ehl.setHZRNEHL_ITE_ID(rs.getInt("HZRNEHL_ITE_ID"));
    //
    //                            ite.huelgas_legales.set(i,ehl);
    //                            ehl = null;
    //                            if (i < ite.huelgas_legales.size()){i++;}
    //                        }
    //                    }else{
    //                          throw new DataFormatException("Comprobante:getComprobanteExtracted:EHL No existen registros");
    //                    }
    //                } 

                        //EOT
                        {
                            stmt = HZRNEOT_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                            
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    EOT eot = new EOT();
                                    eot.setHZRNEOT_DESC_CONCEPTO(rs.getString("HZRNEOT_DESC_CONCEPTO"));
                                    eot.setHZRNEOT_CONCEP_SALARIAL(rs.getBigDecimal("HZRNEOT_CONCEP_SALARIAL"));
                                    eot.setHZRNEOT_CONCEP_NO_SALARIAL(rs.getBigDecimal("HZRNEOT_CONCEP_NO_SALARIAL"));
                                    eot.setHZRNEOT_ITE_ID(rs.getInt("HZRNEOT_ITE_ID"));

                                    ite.otros_conceptos_trab.set(i,eot);
                                    eot = null;
                                    if (i < ite.otros_conceptos_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EOT No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EOT].");                        
                        }  

                        //ECM
                        {
                            stmt = HZRNECM_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                         
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    ECM ecm = new ECM();
                                    ecm.setHZRNECM_COMPENS_ORDINARIA(rs.getBigDecimal("HZRNECM_COMPENS_ORDINARIA"));
                                    ecm.setHZRNECM_COMPENS_EXTRAORDINARIA(rs.getBigDecimal("HZRNECM_COMPENS_EXTRAORDINARIA"));
                                    ecm.setHZRNECM_ITE_ID(rs.getInt("HZRNECM_ITE_ID"));

                                    ite.compensaciones_dev_trab.set(i,ecm);
                                    ecm = null;
                                    if (i < ite.compensaciones_dev_trab.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ECM No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ECM].");                        
                        }   

                        //EBO //NO SE EMITIRA POR PARTE DE LA UPB
    //                    {
    //                        stmt = HZRNEBO_QUERY;
    //                        pstmt = conn.prepareStatement(stmt);
    //                        pstmt.setInt(1, ite_id);                     
    //                        rs = pstmt.executeQuery();
    //
    //                        i = 0;
    //                        if(rs != null){
    //                            while (rs.next()) {
    //                                EBO ebo = new EBO();               
    //                                ebo.setHZRNEBO_PAGO_SALARIAL(rs.getBigDecimal("HZRNEBO_PAGO_SALARIAL"));
    //                                ebo.setHZRNEBO_PAGO_NO_SALARIAL(rs.getBigDecimal("HZRNEBO_PAGO_NO_SALARIAL"));
    //                                ebo.setHZRNEBO_PAGO_ALIMENT_SALARIAL(rs.getBigDecimal("HZRNEBO_PAGO_ALIMENT_SALARIAL"));
    //                                ebo.setHZRNEBO_PAGO_ALIMENT_NO_SALARY(rs.getBigDecimal("HZRNEBO_PAGO_ALIMENT_NO_SALARY"));
    //                                ebo.setHZRNEBO_ITE_ID(rs.getInt("HZRNEBO_ITE_ID"));
    //
    //                                ite.bonos_pagados_electro.set(i,ebo);
    //                                ecm = ebo;
    //                                if (i < ite.bonos_pagados_electro.size()){i++;}
    //                            }
    //                        }else{
    //                              throw new DataFormatException("Comprobante:getComprobanteExtracted:EBO No existen registros");
    //                        }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EBO].");                    
    //                    }

                        //ECO
                        {
                            stmt = HZRNECO_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                         
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    ECO eco = new ECO();
                                    eco.setHZRNECO_COMISION(rs.getBigDecimal("HZRNECO_COMISION"));
                                    eco.setHZRNECO_PAGO_TERCERO(rs.getBigDecimal("HZRNECO_PAGO_TERCERO"));
                                    eco.setHZRNECO_ANTICIPOS_NOMINA(rs.getBigDecimal("HZRNECO_ANTICIPOS_NOMINA"));
                                    eco.setHZRNECO_ITE_ID(rs.getInt("HZRNECO_ITE_ID"));

                                    ite.pago_terceros_anticipos_nom.set(i,eco);
                                    eco = null;
                                    if (i < ite.pago_terceros_anticipos_nom.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:ECO No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [ECO].");                        
                        } 

                        //EVO
                        {
                            stmt = HZRNEVO_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, ite_id);                            
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                while (rs.next()) {
                                    EVO evo = new EVO();
                                    evo.setHZRNEVO_DOTACION(rs.getBigDecimal("HZRNEVO_DOTACION"));
                                    evo.setHZRNEVO_APOYO_SOSTENIMIENT(rs.getBigDecimal("HZRNEVO_APOYO_SOSTENIMIENT"));
                                    evo.setHZRNEVO_TELETRABAJO(rs.getBigDecimal("HZRNEVO_TELETRABAJO"));
                                    evo.setHZRNEVO_BONIF_RETIRO(rs.getBigDecimal("HZRNEVO_BONIF_RETIRO"));
                                    evo.setHZRNEVO_INDEMNIZACION(rs.getBigDecimal("HZRNEVO_INDEMNIZACION"));
                                    evo.setHZRNEVO_REINTEGRO(rs.getBigDecimal("HZRNEVO_REINTEGRO"));
                                    evo.setHZRNEVO_ITE_ID(rs.getInt("HZRNEVO_ITE_ID"));

                                    ite.setOpciones_varias_devengados(evo);
                                    evo = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:EVO No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + ite.getHZRNITE_ID() + "> Mapping completed in [EVO].");                        
                        }
                        
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:ITE No existen registros");
                    }
                                
                    nom.setBasico_trab(ite);
                    ite  = null;
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [ITE].");
                }
                
                //ITS
                {
                    stmt = HZRNITS_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                    
                    ResultSet rs_its = pstmt.executeQuery();
                    

                    ITS its = new ITS();
                    if(rs != null){
                        while (rs_its.next()) {
                            its.setHZRNITS_PORCENTAJE(rs_its.getBigDecimal("HZRNITS_PORCENTAJE"));
                            its.setHZRNITS_DEDUCCION(rs_its.getBigDecimal("HZRNITS_DEDUCCION"));
                            its.setHZRNITS_ID(rs_its.getInt("HZRNITS_ID"));

                            nom.setDeducciones_salud(its);
                            
                            its_id = rs_its.getInt("HZRNITS_ID");
                            
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:ITS No existen registros");
                    }
                    
                    if(its_id != 0){
                    
                        //SPE
                        {
                            stmt = HZRNSPE_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, its_id);
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                while (rs.next()) {
                                    SPE spe = new SPE();
                                    spe.setHZRNSPE_PORCENTAJE(rs.getBigDecimal("HZRNSPE_PORCENTAJE"));
                                    spe.setHZRNSPE_DEDUCCION(rs.getBigDecimal("HZRNSPE_DEDUCCION"));
                                    spe.setHZRNSPE_ITS_ID(rs.getInt("HZRNSPE_ITS_ID"));

                                    its.setDeducciones_pension(spe);
                                    spe = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SPE No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SPE].");                        
                        }

                        //SSP
                        {
                            stmt = HZRNSSP_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, its_id);                        
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                while (rs.next()) {
                                    SSP ssp = new SSP();
                                    ssp.setHZRNSSP_PORCENTAJE(rs.getBigDecimal("HZRNSSP_PORCENTAJE"));
                                    ssp.setHZRNSSP_DEDUC_SEG_PENSIONAL(rs.getBigDecimal("HZRNSSP_DEDUC_SEG_PENSIONAL"));
                                    ssp.setHZRNSSP_PORCENTAJE_SUBSISTEN(rs.getBigDecimal("HZRNSSP_PORCENTAJE_SUBSISTEN"));
                                    ssp.setHZRNSSP_DEDUC_SUBSISTEN(rs.getBigDecimal("HZRNSSP_DEDUC_SUBSISTEN"));
                                    ssp.setHZRNSSP_ITS_ID(rs.getInt("HZRNSSP_ITS_ID"));

                                    its.setDeduc_fondo_seguridad_p(ssp);
                                    ssp = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SSP No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SSP].");                        
                        }  

                        //SIN
                        {
                            stmt = HZRNSIN_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, its_id);                          
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    SIN sin = new SIN();
                                    sin.setHZRNSIN_PORCENTAJE(rs.getBigDecimal("HZRNSIN_PORCENTAJE"));
                                    sin.setHZRNSIN_DEDUCCION(rs.getBigDecimal("HZRNSIN_DEDUCCION"));
                                    sin.setHZRNSIN_ITS_ID(rs.getInt("HZRNSIN_ITS_ID"));

                                    its.deduc_sindicatos.set(i,sin);
                                    sin = null;
                                    if (i < its.deduc_sindicatos.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SIN No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SIN].");                                                
                        } 

                      //SAN
    //                {
    //                    stmt = HZRNSAN_QUERY;
    //                    pstmt = conn.prepareStatement(stmt);
    //                    pstmt.setInt(1, its_id);                      
    //                    rs = pstmt.executeQuery();
    //        
    //                    i= 0;
    //                    if(rs != null){
    //                        while (rs.next()) {
    //                            SAN san = new SAN();                
    //                            san.setHZRNSAN_SANCION_PUBLICA(rs.getBigDecimal("HZRNSAN_SANCION_PUBLICA"));
    //                            san.setHZRNSAN_SANCION_PRIVADA(rs.getBigDecimal("HZRNSAN_SANCION_PRIVADA"));
    //                            san.setHZRNSAN_ITS_ID(rs.getInt("HZRNSAN_ITS_ID"));
    //
    //                            its.deduc_varias.set(i,san);
    //                            san = null;
    //                            if (i < its.deduc_varias.size()){i++;}
    //                        }
    //                    }else{
    //                          throw new DataFormatException("Comprobante:getComprobanteExtracted:SAN No existen registros");
    //                    }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SAN].");                                            
    //                }  

                        //SLI
                        {
                            stmt = HZRNSLI_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, its_id);                           
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                while (rs.next()) {
                                    SLI sli = new SLI();
                                    sli.setHZRNSLI_DESCRIPCION(rs.getString("HZRNSLI_DESCRIPCION"));
                                    sli.setHZRNSLI_DEDUCCION(rs.getBigDecimal("HZRNSLI_DEDUCCION"));
                                    sli.setHZRNSLI_ITS_ID(rs.getInt("HZRNSLI_ITS_ID"));

                                    its.deduc_libranza.set(i,sli);
                                    sli = null;
                                    if (i < its.deduc_libranza.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SLI No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SLI].");                                                
                        }   

                        //SOT
                        {
                            stmt = HZRNSOT_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, its_id);                           
                            rs = pstmt.executeQuery();

                            i = 0;
                            if(rs != null){
                                 while (rs.next()) {
                                    SOT sot = new SOT();
                                    sot.setHZRNSOT_PAGO_TERCERO(rs.getBigDecimal("HZRNSOT_PAGO_TERCERO"));
                                    sot.setHZRNSOT_ANTICIPO(rs.getBigDecimal("HZRNSOT_ANTICIPO"));
                                    sot.setHZRNSOT_OTRA_DEDUCCION(rs.getBigDecimal("HZRNSOT_OTRA_DEDUCCION"));
                                    sot.setHZRNSOT_ITS_ID(rs.getInt("HZRNSOT_ITS_ID"));

                                    its.otras_deduc.set(i,sot);
                                    sot = null;
                                    if (i < its.otras_deduc.size()){i++;}
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SOT No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SOT].");                                                
                        }

                        //SVA
                        {
                            stmt = HZRNSVA_QUERY;
                            pstmt = conn.prepareStatement(stmt);
                            pstmt.setInt(1, its_id);                                 
                            rs = pstmt.executeQuery();

                            if(rs != null){
                                while (rs.next()) {
                                    SVA sva = new SVA();
                                    sva.setHZRNSVA_PENSION_VOLUNTARIA(rs.getBigDecimal("HZRNSVA_PENSION_VOLUNTARIA"));
                                    sva.setHZRNSVA_RENTENCION_FTE(rs.getBigDecimal("HZRNSVA_RENTENCION_FTE"));
                                    sva.setHZRNSVA_AFC(rs.getBigDecimal("HZRNSVA_AFC"));
                                    sva.setHZRNSVA_COOPERATIVA(rs.getBigDecimal("HZRNSVA_COOPERATIVA"));
                                    sva.setHZRNSVA_EMBARGO(rs.getBigDecimal("HZRNSVA_EMBARGO"));
                                    sva.setHZRNSVA_PLAN_COMPLEMENT(rs.getBigDecimal("HZRNSVA_PLAN_COMPLEMENT"));
                                    sva.setHZRNSVA_EDUCACION(rs.getBigDecimal("HZRNSVA_EDUCACION"));
                                    sva.setHZRNSVA_REINTEGRO(rs.getBigDecimal("HZRNSVA_REINTEGRO"));
                                    sva.setHZRNSVA_DEUDA(rs.getBigDecimal("HZRNSVA_DEUDA"));                
                                    sva.setHZRNSVA_ITS_ID(rs.getInt("HZRNSVA_ITS_ID"));

                                    its.setDeduc_varias(sva);
                                    sva = null;
                                }
                            }else{
                                throw new DataFormatException("Comprobante:getComprobanteExtracted:SVA No existen registros");
                            }
                            calendario =Calendar.getInstance();
                            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] <" + its.getHZRNITS_ID() + "> Mapping completed in [SVA].");                                                
                        } 
                        
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:ITS No existen registros");
                    }
                    
                    
                    
                    nom.setDeducciones_salud(its);
                    its = null;
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [ITS].");
                }
                
                 //TOT
                {
                    stmt = HZRNTOT_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                           
                    rs = pstmt.executeQuery();

                    if(rs != null){
                        while (rs.next()) {
                            TOT tot = new TOT();
                            tot.setHZRNTOT_CUNE_INTERNO(rs.getString("HZRNTOT_CUNE_INTERNO"));
                            tot.setHZRNTOT_REDONDEO(rs.getBigDecimal("HZRNTOT_REDONDEO"));
                            tot.setHZRNTOT_DEVENGADOS_TOTAL(rs.getBigDecimal("HZRNTOT_DEVENGADOS_TOTAL"));
                            tot.setHZRNTOT_DEDUCCIONES_TOTAL(rs.getBigDecimal("HZRNTOT_DEDUCCIONES_TOTAL"));
                            tot.setHZRNTOT_COMPROBANTE_TOTAL(rs.getBigDecimal("HZRNTOT_COMPROBANTE_TOTAL"));

                            nom.setTotales_nomina(tot);
                            tot = null;
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:TOT No existen registros");
                    }
                }
                
                Xml xml = new Xml();
                            
                if(nom != null){
                    xml_string = xml.ObjectToXML(nom);
                    nom = null;
                    //System.out.println(xml_string);
                }else{
                    throw new DataFormatException("Comprobante:getComprobanteExtracted: No existen registros");
                }
                
                calendario =Calendar.getInstance();
                log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [NOM].");
            }
 
        
        }else{
            //con es nulo
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");    
        }
    }

    private void getDeletementExtracted() throws SQLException, JAXBException, DataFormatException {
        if (!(conn == null)) {
            
            //NOMINA
            {
                
                stmt = NOMINA_QUERY;
                pstmt = conn.prepareStatement(stmt);
                pstmt.setString(1, cune_interno);
                ResultSet rs_nom = pstmt.executeQuery();
                
                NOMINA nom = new NOMINA();
                if(rs_nom != null){
                    while (rs_nom.next()) {
                        nom.setHZRNNOM_PREFIJO(rs_nom.getString("HZRNNOM_PREFIJO"));
                        nom.setHZRNNOM_CONSECUTIVO_DOC(rs_nom.getInt("HZRNNOM_CONSECUTIVO_DOC"));
                        nom.setHZRNNOM_CUNE_INTERNO(rs_nom.getString("HZRNNOM_CUNE_INTERNO"));
                        nom.setHZRNNOM_TIPO_DOC(rs_nom.getString("HZRNNOM_TIPO_DOC"));
                        nom.setHZRNNOM_ANO(rs_nom.getInt("HZRNNOM_ANO"));
                        nom.setHZRNNOM_MES(rs_nom.getInt("HZRNNOM_MES"));
                        nom.setHZRNNOM_ESTADO(rs_nom.getString("HZRNNOM_ESTADO"));
                        nom.setHZRNNOM_FECHA_EXT(rs_nom.getString("HZRNNOM_FECHA_EXT"));
                        
                    }   
                }else{
                    throw new DataFormatException("Comprobante:getDeletementExtracted:NOMINA No existen registros");
                }
                
                //TIP
                {
                    TIP tip = new TIP(2);
                    nom.setTipo_nota(tip);
                    tip = null;
                }
                
                //ENC
                {
                    stmt = HZRNENC_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                    
                    rs = pstmt.executeQuery();

                    if(rs != null){            
                        while (rs.next()) {
                            ENC enc = new ENC();
                            enc.setHZRNENC_CUNE_INTERNO(rs.getString("HZRNENC_CUNE_INTERNO"));
                            enc.setHZRNENC_TIPO_DOC(rs.getString("HZRNENC_TIPO_DOC"));
                            //enc.setHZRNENC_FECHA_ING(rs.getString("HZRNENC_FECHA_ING"));
                            //enc.setHZRNENC_FECHA_RET(rs.getString("HZRNENC_FECHA_RET"));
                            //enc.setHZRNENC_FECHA_LIQ_INI(rs.getString("HZRNENC_FECHA_LIQ_INI"));
                            //enc.setHZRNENC_FECHA_LIQ_FIN(rs.getString("HZRNENC_FECHA_LIQ_FIN"));
                            //enc.setHZRNENC_TIEMPO_LAB(rs.getBigDecimal("HZRNENC_TIEMPO_LAB"));
                            enc.setHZRNENC_FECHA_EMISION(rs.getString("HZRNENC_FECHA_EMISION"));
                            //enc.setHZRNENC_CODIGO_TRAB(rs.getString("HZRNENC_CODIGO_TRAB"));
                            enc.setHZRNENC_PREFIJO(rs.getString("HZRNENC_PREFIJO"));
                            enc.setHZRNENC_CONSECUTIVO(rs.getLong("HZRNENC_CONSECUTIVO"));
                            enc.setHZRNENC_NUMERO(rs.getString("HZRNENC_NUMERO"));
                            enc.setHZRNENC_PAIS(rs.getString("HZRNENC_PAIS"));
                            enc.setHZRNENC_DEPART_ESTADO(rs.getString("HZRNENC_DEPART_ESTADO"));
                            enc.setHZRNENC_MUNICIPIO_CIUDAD(rs.getString("HZRNENC_MUNICIPIO_CIUDAD"));
                            enc.setHZRNENC_IDIOMA(rs.getString("HZRNENC_IDIOMA"));
                            enc.setHZRNENC_VERSION(rs.getString("HZRNENC_VERSION"));
                            enc.setHZRNENC_AMBIENTE(rs.getInt("HZRNENC_AMBIENTE"));
                            enc.setHZRNENC_TIPO_XML(rs.getInt("HZRNENC_TIPO_XML"));
                            //enc.setHZRNENC_CUNE(rs.getString("HZRNENC_CUNE"));
                            enc.setHZRNENC_FECHA_GENERA(rs.getString("HZRNENC_FECHA_GENERA"));
                            enc.setHZRNENC_HORA_GENERA(rs.getString("HZRNENC_HORA_GENERA"));
                            //enc.setHZRNENC_PERIODO_NOM(rs.getInt("HZRNENC_PERIODO_NOM"));
                            //enc.setHZRNENC_TIPO_MONEDA(rs.getString("HZRNENC_TIPO_MONEDA"));
                            //enc.setHZRNENC_TRM(rs.getBigDecimal("HZRNENC_TRM"));
                            enc.setHZRNENC_NUM_PRED(rs.getString("HZRNENC_NUM_PRED"));
                            //enc.setHZRNENC_CUNE_PRED(rs.getString("HZRNENC_CUNE_PRED"));
                            enc.setHZRNENC_FECHA_GEN_PRED(rs.getString("HZRNENC_FECHA_GEN_PRED"));

                            nom.setEncabezado(enc);
                            enc = null;
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getDeletementExtracted:ENC No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getDeletementExtracted> [" + cune_interno + "] Mapping completed in [ENC].");
                }
                
                //NOT
                {
                    stmt = HZRNNOT_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                      
                    rs = pstmt.executeQuery();
                    
                    i= 0;
                    if(rs != null){
                        while (rs.next()) {
                            NOT not = new NOT();
                            not.setHZRNNOT_CUNE_INTERNO(rs.getString("HZRNNOT_CUNE_INTERNO"));
                            not.setHZRNNOT_NOTAS(rs.getString("HZRNNOT_NOTAS"));                     

                            nom.notas.set(i, not);
                            not = null;
                            if (i < nom.notas.size()){i++;}
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getDeletementExtracted:NOT No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getDeletementExtracted> [" + cune_interno + "] Mapping completed in [NOT].");
                }
                
                //EMI
                {
                    stmt = HZRNEMI_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    pstmt.setString(1, cune_interno);                      
                    rs = pstmt.executeQuery();

                    if(rs != null){
                        
                        while (rs.next()) {
                            EMI emi = new EMI();
                            emi.setHZRNEMI_CUNE_INTERNO(rs.getString("HZRNEMI_CUNE_INTERNO"));
                            emi.setHZRNEMI_RAZON_SOCIAL(rs.getString("HZRNEMI_RAZON_SOCIAL"));
                            //emi.setHZRNEMI_PRIMER_APELLIDO(rs.getString("HZRNEMI_PRIMER_APELLIDO"));
                            //emi.setHZRNEMI_SEGUNDO_APELLIDO(rs.getString("HZRNEMI_SEGUNDO_APELLIDO"));
                            //emi.setHZRNEMI_PRIMER_NOMBRE(rs.getString("HZRNEMI_PRIMER_NOMBRE"));
                            //emi.setHZRNEMI_OTROS_NOMBRES(rs.getString("HZRNEMI_OTROS_NOMBRES"));
                            emi.setHZRNEMI_NIT(rs.getLong("HZRNEMI_NIT"));
                            emi.setHZRNEMI_DV(rs.getInt("HZRNEMI_DV"));
                            emi.setHZRNEMI_PAIS(rs.getString("HZRNEMI_PAIS"));
                            emi.setHZRNEMI_DEPART_ESTADO(rs.getString("HZRNEMI_DEPART_ESTADO"));
                            emi.setHZRNEMI_MUNICIPIO_CIUDAD(rs.getString("HZRNEMI_MUNICIPIO_CIUDAD"));
                            emi.setHZRNEMI_DIRECCION(rs.getString("HZRNEMI_DIRECCION"));

                            nom.setEmisor(emi);
                            emi = null;
                        }
                        
                    }else{
                        throw new DataFormatException("Comprobante:getDeletementExtracted:REC No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getDeletementExtracted> [" + cune_interno + "] Mapping completed in [EMI].");
                }
                
                Xml xml = new Xml();
                            
                if(nom != null){
                    xml_string = xml.ObjectToXML(nom);
                    nom = null;
                    //System.out.println(xml_string);
                }else{
                    throw new DataFormatException("Comprobante:getComprobanteExtracted: No existen registros");
                }

                calendario =Calendar.getInstance();
                log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getDeletementExtracted> [" + cune_interno + "] Mapping completed in [NOM].");
            }
 
        
        }else{
            //con es nulo
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");    
        }
    }

    private void getLocalFile() throws FileNotFoundException, UnsupportedEncodingException, IOException, SQLException {

        calendario =Calendar.getInstance();
        log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getLocalFile> [" + cune_interno + "] (FILE) Start the xml file generation process");
        
        String path = "LocalXMLS/" + String.valueOf(ano) + "/" + String.valueOf(mes) + "/" + tipo_doc + "/" + cune_interno + ".xml";
        File local_dir = new File("LocalXMLS/" + String.valueOf(ano) + "/" + String.valueOf(mes) + "/" + tipo_doc);
        
        //File local_file = new File(cune_interno + ".xml");
        if (!local_dir.exists()){local_dir.mkdirs();}
        
        if(xml_string != null){
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF8"));
            out.append(xml_string);
            out.close();
            
            updateStatus("EXTRACTED");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getLocalFile> [" + cune_interno + "] (FILE) Completes the xml file generation process successfully");
        }else{
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes + "/" + tipo_doc, "(" + calendario.getTime() + "): <Comprobante:getLocalFile> [" + cune_interno + "] (FILE) XML file generation error, xml_string empty or does not exist.");
        }
        
        
    }

    private void getNullAll() {      
        
        log = null;
        calendario = null;
        AMBIENTE = null;
        cune_interno = null;
        tipo_doc = null;
        xml_string = null;
        local_dir = null;
        log_file_name = null;
        db_url = null;
        db_user = null;
        db_pwd = null;
        df = null;
        prefijo = null;
        num_doc = null;
        comp_alive=0;
    }
    
    public void updateStatus(String estado) throws SQLException {

        pstmt = conn.prepareStatement("UPDATE UPB_NOMINAE.HZRNNOM SET HZRNNOM_ESTADO = ? WHERE HZRNNOM_CUNE_INTERNO = ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        pstmt.setString(1, estado);
        pstmt.setString(2, cune_interno);
        int affected = pstmt.executeUpdate();
    }
}
