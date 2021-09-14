package co.edu.upb.nominae;

import co.edu.upb.mapp.Xml;
import static co.edu.upb.nominae.Constantes.TIPO_DOCUMENTO;
import static co.edu.upb.nominae.Queries.*;
import co.edu.upb.pojos.nomina.*;
import co.edu.upb.pojos.utilities.UtilitiesFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import co.edu.upb.utilities.*;
import java.util.Calendar;
import javax.xml.bind.JAXBException;


/**
 *
 * @author 000329745 Juan Camilo Villa 
 * @since 01/09/2021
 * @version 1.0
 * 
 * Clase que permite la extraccion, creacion y transmicion de el comprobante de nomina a carvajal.
 */
public class Comprobante {
    
    private int file_contruction_live;
    private int comprobante_exist;
    private Connection conn;
    private String stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private Log log;
    private Calendar calendario;
    private UtilitiesFile utilities_file;

    public Comprobante() throws SQLException {
        
        log = new Log();
        file_contruction_live = 0;
        comprobante_exist = 0;
        
        stmt = null;
        pstmt = null;
        rs = null;
        calendario =Calendar.getInstance();
        utilities_file = new Utilities().getUtilities("UtlNominaE.json");   
        
        calendario =Calendar.getInstance();
        log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:Comprobante> (1/2) Starting conection to data base.");
        
        conn = DriverManager.getConnection(utilities_file.getUrl(), utilities_file.getUsername(), utilities_file.getPassword());
        
        calendario =Calendar.getInstance();
        log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:Comprobante> (2/2) conection to data base successfully.");
        
        
        
    }

    public Connection getConn() {
        return conn;
    }
    
    public int getComprobanteLive() {
        return file_contruction_live;
    }
    
    public int getComprobanteExist() throws SQLException {
                
        stmt = "alter session set nls_date_format = 'DD/MM/YYYY HH:MI:SS AM'";
        pstmt = conn.prepareStatement(stmt);
        pstmt.execute();

        stmt = "SELECT 1 RESPUESTA FROM DUAL"; //WHERE ROWNUM <=1 AND tzrfefs_estado IS NULL AND TZRFEFS_TIPO_DOCUMENTO = 'FE' ";
        pstmt = conn.prepareStatement(stmt);
        rs = pstmt.executeQuery();

        while (rs.next()) {

            if (!rs.getNString("RESPUESTA").isEmpty()) {
                comprobante_exist = rs.getInt("RESPUESTA");
            } else {
                comprobante_exist = 0;
            }
        }
        return comprobante_exist;
    }

    public void getFileExtracted() throws SQLException, JAXBException, Exception {
     
        file_contruction_live = 1;

        calendario =Calendar.getInstance();
        log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> (1/) Starting getFileExtracted process.");
        

        stmt = "alter session set nls_date_format = 'DD/MM/YYYY HH:MI:SS AM'";
        pstmt = conn.prepareStatement(stmt);
        pstmt.execute();
        
        //PENDIENTE----------------------------------------------------------------------------------------------------------------------------------------    

        if(TIPO_DOCUMENTO.equalsIgnoreCase("Comprobante")){
            
            calendario =Calendar.getInstance();
            log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> (2/) Starting extracting voucher.");          
            
            getComprobanteExtracted();
            
            calendario =Calendar.getInstance();
            log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> (/) Extracting voucher successfully.");
            
            
        }else if(TIPO_DOCUMENTO.equalsIgnoreCase("Ajuste")){
            
            calendario =Calendar.getInstance();
            log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> (/) Starting extracting Adjustment.");

            getAdjustmentExtracted();
            
            calendario =Calendar.getInstance();
            log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> (/) Extracting Adjustment successfully.");
            
        }else{
            
            calendario =Calendar.getInstance();
            log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> (1/) Starting extracting Delete.");

            getDeletementExtracted();

            calendario =Calendar.getInstance();
            log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> (/) Extracting Delete successfully.");
            
        }
        
        
        calendario =Calendar.getInstance();
        log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> (/) getFileExtracted process successfully.");
        
        
        //----------------------------------------------------------------------------------------------------------------------------------------
        file_contruction_live = 0;    
    }

    private void getComprobanteExtracted() throws SQLException, JAXBException, Exception {
        //PENDIENTE----------------------------------------------------------------------------------------------------------------------------------------   
        
        if (!(conn == null)) {
            
            //NOMINA
            {
                stmt = NOMINA_QUERY;
                PreparedStatement pstmt = conn.prepareStatement(stmt);
                ResultSet rs_nom = pstmt.executeQuery();

                NOMINA nom = new NOMINA();

                while (rs_nom.next()) {

                    nom.setHZRNNOM_ESTADO(rs_nom.getString("HZRNNOM_ESTADO"));
                    nom.setHZRNNOM_CUNE_INTERNO(rs_nom.getString("HZRNNOM_CUNE_INTERNO"));

                }   
                
                //ENC
                {
                    stmt = HZRNENC_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    ResultSet rs = pstmt.executeQuery();

                    ENC enc = new ENC();

                    while (rs.next()) {

                        enc.setHZRNENC_CUNE_INTERNO(rs.getString("HZRNENC_CUNE_INTERNO"));
                        enc.setHZRNENC_TIPO_DOC(rs.getString("HZRNENC_TIPO_DOC"));
                        enc.setHZRNENC_FECHA_ING(rs.getDate("HZRNENC_FECHA_ING"));
                        enc.setHZRNENC_FECHA_RET(rs.getDate("HZRNENC_FECHA_RET"));
                        enc.setHZRNENC_FECHA_LIQ_INI(rs.getDate("HZRNENC_FECHA_LIQ_INI"));
                        enc.setHZRNENC_FECHA_LIQ_FIN(rs.getDate("HZRNENC_FECHA_LIQ_FIN"));
                        enc.setHZRNENC_TIEMPO_LAB(rs.getDouble("HZRNENC_TIEMPO_LAB"));
                        enc.setHZRNENC_FECHA_EMISION(rs.getDate("HZRNENC_FECHA_EMISION"));
                        enc.setHZRNENC_CODIGO_TRAB(rs.getString("HZRNENC_CODIGO_TRAB"));
                        enc.setHZRNENC_PREFIJO(rs.getString("HZRNENC_PREFIJO"));
                        enc.setHZRNENC_CONSECUTIVO(rs.getLong("HZRNENC_CONSECUTIVO"));
                        enc.setHZRNENC_NUMERO(rs.getString("HZRNENC_NUMERO"));
                        enc.setHZRNENC_PAIS(rs.getString("HZRNENC_PAIS"));
                        enc.setHZRNENC_DEPART_ESTADO(rs.getInt("HZRNENC_DEPART_ESTADO"));
                        enc.setHZRNENC_MUNICIPIO_CIUDAD(rs.getInt("HZRNENC_MUNICIPIO_CIUDAD"));
                        enc.setHZRNENC_IDIOMA(rs.getString("HZRNENC_IDIOMA"));
                        enc.setHZRNENC_VERSION(rs.getString("HZRNENC_VERSION"));
                        enc.setHZRNENC_AMBIENTE(rs.getInt("HZRNENC_AMBIENTE"));
                        enc.setHZRNENC_TIPO_XML(rs.getInt("HZRNENC_TIPO_XML"));
                        enc.setHZRNENC_CUNE(rs.getString("HZRNENC_CUNE"));
                        enc.setHZRNENC_FECHA_GENERA(rs.getDate("HZRNENC_FECHA_GENERA"));
                        enc.setHZRNENC_HORA_GENERA(rs.getString("HZRNENC_HORA_GENERA"));
                        enc.setHZRNENC_PERIODO_NOM(rs.getInt("HZRNENC_PERIODO_NOM"));
                        enc.setHZRNENC_TIPO_MONEDA(rs.getString("HZRNENC_TIPO_MONEDA"));
                        enc.setHZRNENC_TRM(rs.getDouble("HZRNENC_TRM"));
                        enc.setHZRNENC_NUM_PRED(rs.getString("HZRNENC_NUM_PRED"));
                        enc.setHZRNENC_CUNE_PRED(rs.getString("HZRNENC_CUNE_PRED"));
                        enc.setHZRNENC_FECHA_GEN_PRED(rs.getDate("HZRNENC_FECHA_GEN_PRED"));

                        nom.setEncabezado(enc);
                    }

                }
                
                //NOV
                {
                    stmt = HZRNNOV_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    ResultSet rs = pstmt.executeQuery();

                    NOV nov = new NOV();

                    while (rs.next()) {

                        nov.setHZRNNOV_CUNE_INTERNO(rs.getString("HZRNNOV_CUNE_INTERNO"));
                        nov.setHZRNNOV_NOVEDAD(rs.getString("HZRNNOV_NOVEDAD"));
                        nov.setHZRNNOV_CUNE_NOV(rs.getString("HZRNNOV_CUNE_NOV"));

                        nom.setNovedad(nov);
                    }

                }
                
                //NOT
                {
                    stmt = HZRNNOT_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        NOT not = new NOT();
                        not.setHZRNNOT_CUNE_INTERNO(rs.getString("HZRNNOT_CUNE_INTERNO"));
                        not.setHZRNNOT_NOTAS(rs.getString("HZRNNOT_NOTAS"));

                        nom.notas.add(not);
                        not = null;
                    }

                }
                
                //EMI
                {
                    stmt = HZRNEMI_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    ResultSet rs = pstmt.executeQuery();

                    EMI emi = new EMI();

                    while (rs.next()) {

                        emi.setHZRNEMI_CUNE_INTERNO(rs.getString("HZRNEMI_CUNE_INTERNO"));
                        emi.setHZRNEMI_RAZON_SOCIAL(rs.getString("HZRNEMI_RAZON_SOCIAL"));
                        emi.setHZRNEMI_PRIMER_APELLIDO(rs.getString("HZRNEMI_PRIMER_APELLIDO"));
                        emi.setHZRNEMI_SEGUNDO_APELLIDO(rs.getString("HZRNEMI_SEGUNDO_APELLIDO"));
                        emi.setHZRNEMI_PRIMER_NOMBRE(rs.getString("HZRNEMI_PRIMER_NOMBRE"));
                        emi.setHZRNEMI_OTROS_NOMBRES(rs.getString("HZRNEMI_OTROS_NOMBRES"));
                        emi.setHZRNEMI_NIT(rs.getLong("HZRNEMI_NIT"));
                        emi.setHZRNEMI_DV(rs.getInt("HZRNEMI_DV"));
                        emi.setHZRNEMI_PAIS(rs.getString("HZRNEMI_PAIS"));
                        emi.setHZRNEMI_DEPART_ESTADO(rs.getInt("HZRNEMI_DEPART_ESTADO"));
                        emi.setHZRNEMI_MUNICIPIO_CIUDAD(rs.getInt("HZRNEMI_MUNICIPIO_CIUDAD"));
                        emi.setHZRNEMI_DIRECCION(rs.getString("HZRNEMI_DIRECCION"));

                        nom.setEmisor(emi);
                    }

                }
                
                //REC
                {
                    stmt = HZRNREC_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    ResultSet rs = pstmt.executeQuery();

                    REC rec = new REC();

                    while (rs.next()) {

                        rec.setHZRNREC_CUNE_INTERNO(rs.getString("HZRNREC_CUNE_INTERNO"));
                        rec.setHZRNREC_TIPO_TRABAJADOR(rs.getInt("HZRNREC_TIPO_TRABAJADOR"));
                        rec.setHZRNREC_SUB_TIPO_TRABAJ(rs.getInt("HZRNREC_SUB_TIPO_TRABAJ"));
                        rec.setHZRNREC_ALTO_RIESGO_PENS(rs.getString("HZRNREC_ALTO_RIESGO_PENS"));
                        rec.setHZRNREC_TIPO_DOC(rs.getInt("HZRNREC_TIPO_DOC"));
                        rec.setHZRNREC_NUM_DOC(rs.getLong("HZRNREC_NUM_DOC"));
                        rec.setHZRNREC_PRIMER_APELLIDO(rs.getString("HZRNREC_PRIMER_APELLIDO"));
                        rec.setHZRNREC_SEGUNDO_APELLIDO(rs.getString("HZRNREC_SEGUNDO_APELLIDO"));
                        rec.setHZRNREC_PRIMER_NOMBRE(rs.getString("HZRNREC_PRIMER_NOMBRE"));
                        rec.setHZRNREC_OTROS_NOMBRES(rs.getString("HZRNREC_OTROS_NOMBRES"));
                        rec.setHZRNREC_LUGAR_TRAB_PAIS(rs.getInt("HZRNREC_LUGAR_TRAB_PAIS"));
                        rec.setHZRNREC_LUGAR_TRAB_DEPT_EST(rs.getInt("HZRNREC_LUGAR_TRAB_DEPT_EST"));
                        rec.setHZRNREC_LUGAR_TRAB_MUN_CIUD(rs.getInt("HZRNREC_LUGAR_TRAB_MUN_CIUD"));
                        rec.setHZRNREC_LUGAR_TRAB_DIREC(rs.getString("HZRNREC_LUGAR_TRAB_DIREC"));
                        rec.setHZRNREC_SALARIO_INTEGRAL(rs.getString("HZRNREC_SALARIO_INTEGRAL"));
                        rec.setHZRNREC_TIPO_CONTRATO(rs.getInt("HZRNREC_TIPO_CONTRATO"));
                        rec.setHZRNREC_SUELDO(rs.getDouble("HZRNREC_SUELDO"));
                        rec.setHZRNREC_COD_TRABAJADOR(rs.getString("HZRNREC_COD_TRABAJADOR"));

                        nom.setReceptor(rec);
                    }

                }
                
                //PAG
                {
                    stmt = HZRNPAG_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    ResultSet rs = pstmt.executeQuery();

                    PAG pag = new PAG();

                    while (rs.next()) {

                        pag.setHZRNPAG_CUNE_INTERNO(rs.getString("HZRNPAG_CUNE_INTERNO"));
                        pag.setHZRNPAG_FORMA_PAGO(rs.getInt("HZRNPAG_FORMA_PAGO"));
                        pag.setHZRNPAG_METODO_PAGO(rs.getString("HZRNPAG_METODO_PAGO"));
                        pag.setHZRNPAG_BANCO(rs.getString("HZRNPAG_BANCO"));
                        pag.setHZRNPAG_TIPO_CUENTA(rs.getString("HZRNPAG_TIPO_CUENTA"));
                        pag.setHZRNPAG_NUM_CUENTA(rs.getString("HZRNPAG_NUM_CUENTA"));                

                        nom.setPago(pag);
                    }

                }
                
                //FED
                {
                    stmt = HZRNFEP_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    ResultSet rs = pstmt.executeQuery();

                    FEP fep = new FEP();

                    while (rs.next()) {

                        fep.setHZRNFEP_CUNE_INTERNO(rs.getString("HZRNFEP_CUNE_INTERNO"));
                        fep.setHZRNFEP_FECHA_PAGO(rs.getDate("HZRNFEP_FECHA_PAGO"));

                        nom.fecha_pagos.add(fep);
                        fep = null;
                    }

                }
                
                //ITE
                {
                    stmt = HZRNITE_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    ResultSet rs_ite = pstmt.executeQuery();

                    ITE ite = new ITE();

                    while (rs_ite.next()) {

                        ite.setHZRNITE_DIAS_TRAB(rs_ite.getString("HZRNITE_DIAS_TRAB"));
                        ite.setHZRNITE_SUELDO_TRAB(rs_ite.getDouble("HZRNITE_SUELDO_TRAB"));

                        nom.setBasico_trab(ite);
                    }

                    //ETR
                    {
                        stmt = HZRNETR_QUERY;
                        pstmt = conn.prepareStatement(stmt);
                        ResultSet rs = pstmt.executeQuery();

                        ETR etr = new ETR();

                        while (rs.next()) {

                            etr.setHZRNETR_AUX_TRANSPORTE(rs.getDouble("HZRNETR_AUX_TRANSPORTE"));
                            etr.setHZRNETR_VIAT_MANUT_SALARIAL(rs.getDouble("HZRNETR_VIAT_MANUT_SALARIAL"));
                            etr.setHZRNETR_VIAT_MANUT_NO_SALARIAL(rs.getDouble("HZRNETR_VIAT_MANUT_NO_SALARIAL"));
                            etr.setHZRNETR_ITE_ID(rs.getInt("HZRNETR_ITE_ID"));

                            ite.transporte_pagado_trab.add(etr);
                            etr = null;
                        }

                    }
                    
                    //EHE
                    {
                        stmt = HZRNEHE_QUERY;
                        pstmt = conn.prepareStatement(stmt);
                        ResultSet rs = pstmt.executeQuery();

                        EHE ehe = new EHE();

                        while (rs.next()) {

                            ehe.setHZRNEHE_HORAS_EXTRA(rs.getString("HZRNEHE_HORAS_EXTRA"));                
                            ehe.setHZRNEHE_HORA_INICIO(rs.getString("HZRNEHE_HORA_INICIO"));                
                            ehe.setHZRNEHE_HORA_FIN(rs.getString("HZRNEHE_HORA_FIN"));                                
                            ehe.setHZRNEHE_CANTIDAD(rs.getDouble("HZRNEHE_CANTIDAD"));
                            ehe.setHZRNEHE_PORCENTAJE(rs.getDouble("HZRNEHE_PORCENTAJE"));
                            ehe.setHZRNEHE_PAGO(rs.getDouble("HZRNEHE_PAGO"));
                            ehe.setHZRNEHE_ITE_ID(rs.getInt("HZRNEHE_ITE_ID"));

                            ite.horas_extras_trab.add(ehe);
                            ehe = null;
                        }

                    }
                    
                    //EVC
                    {
                        stmt = HZRNEVC_QUERY;
                        pstmt = conn.prepareStatement(stmt);
                        ResultSet rs = pstmt.executeQuery();

                        EVC evc = new EVC();

                        while (rs.next()) {

                            evc.setHZRNEVC_FECHA_INICIO(rs.getDate("HZRNEVC_FECHA_INICIO"));                
                            evc.setHZRNEVC_FECHA_FIN(rs.getDate("HZRNEVC_FECHA_FIN"));                
                            evc.setHZRNEVC_CANTIDAD(rs.getLong("HZRNEVC_CANTIDAD"));                                
                            evc.setHZRNEVC_PAGO(rs.getDouble("HZRNEVC_PAGO"));
                            evc.setHZRNEVC_ITE_ID(rs.getInt("HZRNEVC_ITE_ID"));

                            ite.vacaciones_trabajador.add(evc);
                            evc = null;
                        }

                    }
                    
                    //SEGUIR ACA
                    
                    
                }  
            }
            
                
        
        }else{
            //con es nulo
        }
        








        
        
             
          
           
           
          
         
        
                
        //EVA
        {
            stmt = HZRNEVA_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            EVA eva = new EVA();
            
            while (rs.next()) {
                               
                eva.setHZRNEVA_CANTIDAD(rs.getLong("HZRNEVA_CANTIDAD"));
                eva.setHZRNEVA_PAGO(rs.getDouble("HZRNEVA_PAGO"));
                eva.setHZRNEVA_ITE_ID(rs.getInt("HZRNEVA_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(eva));
            }
    
        }        
        //EPR
        {
            stmt = HZRNEPR_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            EPR epr = new EPR();
            
            while (rs.next()) {
                               
                epr.setHZRNEPR_CANTIDAD(rs.getInt("HZRNEPR_CANTIDAD"));
                epr.setHZRNEPR_PAGO(rs.getDouble("HZRNEPR_PAGO"));
                epr.setHZRNEPR_PAGONS(rs.getDouble("HZRNEPR_PAGONS"));
                epr.setHZRNEPR_ITE_ID(rs.getInt("HZRNEPR_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(epr));
            }
    
        }          
        //ECE
        {
            stmt = HZRNECE_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            ECE ece = new ECE();
            
            while (rs.next()) {
                               
                ece.setHZRNECE_PAGO(rs.getDouble("HZRNECE_PAGO"));
                ece.setHZRNECE_PORCENTAJE(rs.getDouble("HZRNECE_PORCENTAJE"));
                ece.setHZRNECE_PAGO_INTERESES(rs.getDouble("HZRNECE_PAGO_INTERESES"));
                ece.setHZRNECE_ITE_ID(rs.getInt("HZRNECE_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(ece));
            }
    
        }           
        //EIN
        {
            stmt = HZRNEIN_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            EIN ein = new EIN();
            
            while (rs.next()) {
                               
                ein.setHZRNEIN_FECHA_INICIO(rs.getDate("HZRNEIN_FECHA_INICIO"));
                ein.setHZRNEIN_FECHA_FIN(rs.getDate("HZRNEIN_FECHA_FIN"));
                ein.setHZRNEIN_CANTIDAD(rs.getLong("HZRNEIN_CANTIDAD"));
                ein.setHZRNEIN_TIPO(rs.getInt("HZRNEIN_TIPO"));
                ein.setHZRNEIN_PAGO(rs.getDouble("HZRNEIN_PAGO"));
                ein.setHZRNEIN_ITE_ID(rs.getInt("HZRNEIN_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(ein));
            }
    
        }           
        //ELI
        {
            stmt = HZRNELI_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            ELI eli = new ELI();
            
            while (rs.next()) {
                               
                eli.setHZRNELI_FECHA_INICIO(rs.getDate("HZRNELI_FECHA_INICIO"));
                eli.setHZRNELI_FECHA_FIN(rs.getDate("HZRNELI_FECHA_FIN"));
                eli.setHZRNELI_CANTIDAD(rs.getLong("HZRNELI_CANTIDAD"));
                eli.setHZRNELI_PAGO(rs.getDouble("HZRNELI_PAGO"));
                eli.setHZRNELI_ITE_ID(rs.getInt("HZRNELI_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(eli));
            }
    
        }         
        //ELR
        {
            stmt = HZRNELR_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            ELR elr = new ELR();
            
            while (rs.next()) {
                               
                elr.setHZRNELR_FECHA_INICIO(rs.getDate("HZRNELR_FECHA_INICIO"));
                elr.setHZRNELR_FECHA_FIN(rs.getDate("HZRNELR_FECHA_FIN"));
                elr.setHZRNELR_CANTIDAD(rs.getLong("HZRNELR_CANTIDAD"));
                elr.setHZRNELR_PAGO(rs.getDouble("HZRNELR_PAGO"));
                elr.setHZRNELR_ITE_ID(rs.getInt("HZRNELR_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(elr));
            }
    
        }         
        //ELN
        {
            stmt = HZRNELN_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            ELN eln = new ELN();
            
            while (rs.next()) {
                               
                eln.setHZRNELN_FECHA_INICIO(rs.getDate("HZRNELN_FECHA_INICIO"));
                eln.setHZRNELN_FECHA_FIN(rs.getDate("HZRNELN_FECHA_FIN"));
                eln.setHZRNELN_CANTIDAD(rs.getLong("HZRNELN_CANTIDAD"));
                eln.setHZRNELN_ITE_ID(rs.getInt("HZRNELN_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(eln));
            }
    
        }       
        //EBN
        {
            stmt = HZRNEBN_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            EBN ebn = new EBN();
            
            while (rs.next()) {
                               
                ebn.setHZRNEBN_BONI_SALARIAL(rs.getDouble("HZRNEBN_BONI_SALARIAL"));
                ebn.setHZRNEBN_BONI_NO_SALARIAL(rs.getDouble("HZRNEBN_BONI_NO_SALARIAL"));
                ebn.setHZRNEBN_ITE_ID(rs.getInt("HZRNEBN_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(ebn));
            }
    
        }    
        //EAX
        {
            stmt = HZRNEAX_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            EAX eax = new EAX();
            
            while (rs.next()) {
                               
                eax.setHZRNEAX_AUX_SALARIAL(rs.getDouble("HZRNEAX_AUX_SALARIAL"));
                eax.setHZRNEAX_AUX_NO_SALARIAL(rs.getDouble("HZRNEAX_AUX_NO_SALARIAL"));
                eax.setHZRNEAX_ITE_ID(rs.getInt("HZRNEAX_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(eax));
            }
    
        }    
        //EHL //NO SE EMITIRA POR PARTE DE LA UPB
//        {
//            stmt = HZRNEHL_QUERY;
//            PreparedStatement pstmt = conn.prepareStatement(stmt);
//            ResultSet rs = pstmt.executeQuery();
//
//            EHL ehl = new EHL();
//            
//            while (rs.next()) {
//                               
//                ehl.setHZRNEHL_FECHA_INICIO(rs.getDate("HZRNEHL_FECHA_INICIO"));
//                ehl.setHZRNEHL_FECHA_FIN(rs.getDate("HZRNEHL_FECHA_FIN"));
//                ehl.setHZRNEHL_CANTIDAD(rs.getLong("HZRNEHL_CANTIDAD"));
//                ehl.setHZRNEHL_ITE_ID(rs.getInt("HZRNEHL_ITE_ID"));
//                
//                Xml xml = new Xml();
//                System.out.println(xml.ObjectToXML(ehl));
//            }
//    
//        } 
        //EOT
        {
            stmt = HZRNEOT_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            EOT eot = new EOT();
            
            while (rs.next()) {
                               
                eot.setHZRNEOT_DESC_CONCEPTO(rs.getString("HZRNEOT_DESC_CONCEPTO"));
                eot.setHZRNEOT_CONCEP_SALARIAL(rs.getDouble("HZRNEOT_CONCEP_SALARIAL"));
                eot.setHZRNEOT_CONCEP_NO_SALARIAL(rs.getDouble("HZRNEOT_CONCEP_NO_SALARIAL"));
                eot.setHZRNEOT_ITE_ID(rs.getInt("HZRNEOT_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(eot));
            }
    
        }  
        //ECM
        {
            stmt = HZRNECM_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            ECM ecm = new ECM();
            
            while (rs.next()) {
                               
                ecm.setHZRNECM_COMPENS_ORDINARIA(rs.getDouble("HZRNECM_COMPENS_ORDINARIA"));
                ecm.setHZRNECM_COMPENS_EXTRAORDINARIA(rs.getDouble("HZRNECM_COMPENS_EXTRAORDINARIA"));
                ecm.setHZRNECM_ITE_ID(rs.getInt("HZRNECM_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(ecm));
            }
    
        }     
        //EBO //NO SE EMITIRA POR PARTE DE LA UPB
//        {
//            stmt = HZRNEBO_QUERY;
//            PreparedStatement pstmt = conn.prepareStatement(stmt);
//            ResultSet rs = pstmt.executeQuery();
//
//            EBO ebo = new EBO();
//            
//            while (rs.next()) {
//                               
//                ebo.setHZRNEBO_PAGO_SALARIAL(rs.getDouble("HZRNEBO_PAGO_SALARIAL"));
//                ebo.setHZRNEBO_PAGO_NO_SALARIAL(rs.getDouble("HZRNEBO_PAGO_NO_SALARIAL"));
//                ebo.setHZRNEBO_PAGO_ALIMENT_SALARIAL(rs.getDouble("HZRNEBO_PAGO_ALIMENT_SALARIAL"));
//                ebo.setHZRNEBO_PAGO_ALIMENT_NO_SALARY(rs.getDouble("HZRNEBO_PAGO_ALIMENT_NO_SALARY"));
//                ebo.setHZRNEBO_ITE_ID(rs.getInt("HZRNEBO_ITE_ID"));
//                
//                Xml xml = new Xml();
//                System.out.println(xml.ObjectToXML(ebo));
//            }
//    
//        }  
        //ECO
        {
            stmt = HZRNECO_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            ECO eco = new ECO();
            
            while (rs.next()) {
                               
                eco.setHZRNECO_COMISION(rs.getDouble("HZRNECO_COMISION"));
                eco.setHZRNECO_PAGO_TERCERO(rs.getDouble("HZRNECO_PAGO_TERCERO"));
                eco.setHZRNECO_ANTICIPOS_NOMINA(rs.getDouble("HZRNECO_ANTICIPOS_NOMINA"));
                eco.setHZRNECO_ITE_ID(rs.getInt("HZRNECO_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(eco));
            }
    
        }         
        //EVO
        {
            stmt = HZRNEVO_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            EVO evo = new EVO();
            
            while (rs.next()) {
                               
                evo.setHZRNEVO_DOTACION(rs.getDouble("HZRNEVO_DOTACION"));
                evo.setHZRNEVO_APOYO_SOSTENIMIENT(rs.getDouble("HZRNEVO_APOYO_SOSTENIMIENT"));
                evo.setHZRNEVO_TELETRABAJO(rs.getDouble("HZRNEVO_TELETRABAJO"));
                evo.setHZRNEVO_BONIF_RETIRO(rs.getDouble("HZRNEVO_BONIF_RETIRO"));
                evo.setHZRNEVO_INDEMNIZACION(rs.getDouble("HZRNEVO_INDEMNIZACION"));
                evo.setHZRNEVO_REINTEGRO(rs.getDouble("HZRNEVO_REINTEGRO"));
                evo.setHZRNEVO_ITE_ID(rs.getInt("HZRNEVO_ITE_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(evo));
            }
    
        }     
        //SPE
        {
            stmt = HZRNSPE_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            SPE spe = new SPE();
            
            while (rs.next()) {
                               
                spe.setHZRNSPE_PORCENTAJE(rs.getDouble("HZRNSPE_PORCENTAJE"));
                spe.setHZRNSPE_DEDUCCION(rs.getDouble("HZRNSPE_DEDUCCION"));
                spe.setHZRNSPE_ITS_ID(rs.getInt("HZRNSPE_ITS_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(spe));
            }
    
        }    
        //SSP
        {
            stmt = HZRNSSP_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            SSP ssp = new SSP();
            
            while (rs.next()) {
                               
                ssp.setHZRNSSP_PORCENTAJE(rs.getDouble("HZRNSSP_PORCENTAJE"));
                ssp.setHZRNSSP_DEDUC_SEG_PENSIONAL(rs.getDouble("HZRNSSP_DEDUC_SEG_PENSIONAL"));
                ssp.setHZRNSSP_PORCENTAJE_SUBSISTEN(rs.getDouble("HZRNSSP_PORCENTAJE_SUBSISTEN"));
                ssp.setHZRNSSP_DEDUC_SUBSISTEN(rs.getDouble("HZRNSSP_DEDUC_SUBSISTEN"));
                ssp.setHZRNSSP_ITS_ID(rs.getInt("HZRNSSP_ITS_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(ssp));
            }
    
        }          
        //SIN
        {
            stmt = HZRNSIN_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            SIN sin = new SIN();
            
            while (rs.next()) {
                               
                sin.setHZRNSIN_PORCENTAJE(rs.getDouble("HZRNSIN_PORCENTAJE"));
                sin.setHZRNSIN_DEDUCCION(rs.getDouble("HZRNSIN_DEDUCCION"));
                sin.setHZRNSIN_ITS_ID(rs.getInt("HZRNSIN_ITS_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(sin));
            }
    
        }          
        //SAN
//        {
//            stmt = HZRNSAN_QUERY;
//            PreparedStatement pstmt = conn.prepareStatement(stmt);
//            ResultSet rs = pstmt.executeQuery();
//
//            SAN san = new SAN();
//            
//            while (rs.next()) {
//                               
//                san.setHZRNSAN_SANCION_PUBLICA(rs.getDouble("HZRNSAN_SANCION_PUBLICA"));
//                san.setHZRNSAN_SANCION_PRIVADA(rs.getDouble("HZRNSAN_SANCION_PRIVADA"));
//                san.setHZRNSAN_ITS_ID(rs.getInt("HZRNSAN_ITS_ID"));
//                
//                Xml xml = new Xml();
//                System.out.println(xml.ObjectToXML(san));
//            }
//    
//        }          
        //SLI
        {
            stmt = HZRNSLI_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            SLI sli = new SLI();
            
            while (rs.next()) {
                               
                sli.setHZRNSLI_DESCRIPCION(rs.getString("HZRNSLI_DESCRIPCION"));
                sli.setHZRNSLI_DEDUCCION(rs.getDouble("HZRNSLI_DEDUCCION"));
                sli.setHZRNSLI_ITS_ID(rs.getInt("HZRNSLI_ITS_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(sli));
            }
    
        }     
        //SOT
        {
            stmt = HZRNSOT_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            SOT sot = new SOT();
            
            while (rs.next()) {
                               
                sot.setHZRNSOT_PAGO_TERCERO(rs.getDouble("HZRNSOT_PAGO_TERCERO"));
                sot.setHZRNSOT_ANTICIPO(rs.getDouble("HZRNSOT_ANTICIPO"));
                sot.setHZRNSOT_OTRA_DEDUCCION(rs.getDouble("HZRNSOT_OTRA_DEDUCCION"));
                sot.setHZRNSOT_ITS_ID(rs.getInt("HZRNSOT_ITS_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(sot));
            }
    
        }    
        //SVA
        {
            stmt = HZRNSVA_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            SVA sva = new SVA();
            
            while (rs.next()) {
                               
                sva.setHZRNSVA_PENSION_VOLUNTARIA(rs.getDouble("HZRNSVA_PENSION_VOLUNTARIA"));
                sva.setHZRNSVA_RENTENCION_FTE(rs.getDouble("HZRNSVA_RENTENCION_FTE"));
                sva.setHZRNSVA_AFC(rs.getDouble("HZRNSVA_AFC"));
                sva.setHZRNSVA_COOPERATIVA(rs.getDouble("HZRNSVA_COOPERATIVA"));
                sva.setHZRNSVA_EMBARGO(rs.getDouble("HZRNSVA_EMBARGO"));
                sva.setHZRNSVA_PLAN_COMPLEMENT(rs.getDouble("HZRNSVA_PLAN_COMPLEMENT"));
                sva.setHZRNSVA_EDUCACION(rs.getDouble("HZRNSVA_EDUCACION"));
                sva.setHZRNSVA_REINTEGRO(rs.getDouble("HZRNSVA_REINTEGRO"));
                sva.setHZRNSVA_DEUDA(rs.getDouble("HZRNSVA_DEUDA"));                
                sva.setHZRNSVA_ITS_ID(rs.getInt("HZRNSVA_ITS_ID"));
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(sva));
            }
    
        } 
        //TOT
        {
            stmt = HZRNTOT_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            TOT tot = new TOT();
            
            while (rs.next()) {
                               
                tot.setHZRNTOT_CUNE_INTERNO(rs.getString("HZRNTOT_CUNE_INTERNO"));
                tot.setHZRNTOT_REDONDEO(rs.getDouble("HZRNTOT_REDONDEO"));
                tot.setHZRNTOT_DEVENGADOS_TOTAL(rs.getDouble("HZRNTOT_DEVENGADOS_TOTAL"));
                tot.setHZRNTOT_DEDUCCIONES_TOTAL(rs.getDouble("HZRNTOT_DEDUCCIONES_TOTAL"));
                tot.setHZRNTOT_COMPROBANTE_TOTAL(rs.getDouble("HZRNTOT_COMPROBANTE_TOTAL"));
                                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(tot));
            }
    
        }         

        
        //----------------------------------------------------------------------------------------------------------------------------------------   
    }

    private void getAdjustmentExtracted() throws JAXBException {
        //PENDIENTE----------------------------------------------------------------------------------------------------------------------------------------   
        TIP tip = new TIP(1);
        System.out.println(tip.getTIP_1());
        Xml xml = new Xml();
        System.out.println(xml.ObjectToXML(tip));
            //AUN NO
        
        //----------------------------------------------------------------------------------------------------------------------------------------   
    }

    private void getDeletementExtracted() {
        //PENDIENTE----------------------------------------------------------------------------------------------------------------------------------------   
        
            //AUN NO
        
        //----------------------------------------------------------------------------------------------------------------------------------------   
    }
    
}
