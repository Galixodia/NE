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
public class ComprobanteD{
    
    private Connection conn;
    private String stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private Log log;
    private Calendar calendario;
    private int i;
    public static String AMBIENTE;
    private String prefijo;
    private String num_doc;
    private String cune_interno;
    private String tipo_doc;
    private final int ano;
    private final int mes;
    private String xml_string;
    public int comp_alive;
    private final String local_dir;
    private final String log_file_name;
    private final String db_url;
    private final String db_user;
    private final String db_pwd;
    

    public ComprobanteD(String cune_interno, String tipo_doc, int ano, int mes, String local_dir, String db_url, String db_user, String db_pwd, String log_file_name, String ambiente) throws SQLException {
        this.cune_interno = cune_interno;
        this.tipo_doc = tipo_doc; 
        this.ano = ano;
        this.mes = mes;
        this.local_dir = local_dir; 
        this.db_url = db_url; 
        this.db_user = db_user; 
        this.db_pwd = db_pwd;
        this.log_file_name = log_file_name;
        
        calendario =Calendar.getInstance(); 
        
        AMBIENTE = ambiente;
        
        log = new Log();
        
        stmt = null;
        pstmt = null;
        rs = null;
        
        i = 0; // Iterador para listas
        

        calendario =Calendar.getInstance();
        log.logInFile(log_file_name,null, "(" + calendario.getTime() + "): <Comprobante:Comprobante> [" + this.cune_interno + "] (DB) Starting conection to data base.");
        
        conn = DriverManager.getConnection(this.db_url, this.db_user, this.db_pwd);
        
        calendario =Calendar.getInstance();
        log.logInFile(log_file_name,null, "(" + calendario.getTime() + "): <Comprobante:Comprobante> [" + this.cune_interno + "] (DB) Conection to data base successfully.");
    }

    public void run() throws SQLException {
        System.out.println("CUNE_INTERNO: " + this.cune_interno);
        System.out.println("TIPO_DOC: " + this.tipo_doc);
        try {
            
            this.comp_alive = 1;
            getFileExtracted();
            getLocalFile();
            getNullAll();
            
        } catch (SQLException ex) {
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:run> [" + cune_interno + "] (DB) Exception in connection with the database: " + ex.getMessage());
        } catch (JAXBException ex) {
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:run> [" + cune_interno + "] (XML) Exception in XML file construction: " + ex.getMessage());
        } catch (DataFormatException ex) {
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:run> [" + cune_interno + "] (FIELD) Exception in field setting: " + ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:run> [" + cune_interno + "] (UTF8) Exception in encoding: " + ex.getMessage());
        } catch (IOException ex) {
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:run> [" + cune_interno + "] (FILE) Exception in file creation: " + ex.getMessage());
        } finally{
            getNullAll();
            System.out.println("FIN _______________________________________________________________________________");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }
    
    public void getFileExtracted() throws SQLException, JAXBException, DataFormatException {
        
        calendario =Calendar.getInstance();
        log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> [" + cune_interno + "] Starting getFileExtracted process.");
        
        //PENDIENTE----------------------------------------------------------------------------------------------------------------------------------------    

        if(tipo_doc.equalsIgnoreCase("NominaIndividual")){
            
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividual)> [" + cune_interno + "] (NominaIndividual) Starting extracting process.");          
            getComprobanteExtracted();
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividual)> [" + cune_interno + "] (NominaIndividual) Extracting process successfully.");
            
            
        }else if(tipo_doc.equalsIgnoreCase("NominaIndividualDeAjusteReemplazar")){
            
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividualDeAjusteReemplazar)> [" + cune_interno + "] (AjusteReemplazar) Starting extracting process.");

            getAdjustmentExtracted();
            
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividualDeAjusteReemplazar)> [" + cune_interno + "] (AjusteReemplazar) Extracting process successfully.");
            
        }else if(tipo_doc.equalsIgnoreCase("NominaIndividualDeAjusteEliminar")){
            
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividualDeAjusteEliminar)> [" + cune_interno + "] (AjusteEliminar) Starting extracting process.");

            getDeletementExtracted();

            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted(NominaIndividualDeAjusteEliminar)> [" + cune_interno + "] (AjusteEliminar) Extracting process successfully.");
            
        }
        
        
        calendario =Calendar.getInstance();
        log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getFileExtracted> [" + cune_interno + "] getFileExtracted process successfully.");
        
        
        //----------------------------------------------------------------------------------------------------------------------------------------  
    }

    private void getComprobanteExtracted() throws SQLException, DataFormatException, JAXBException  {
        //PENDIENTE----------------------------------------------------------------------------------------------------------------------------------------   
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
                        nom.setHZRNNOM_NUM_DOC(rs_nom.getInt("HZRNNOM_NUM_DOC"));
                        nom.setHZRNNOM_CUNE_INTERNO(rs_nom.getString("HZRNNOM_CUNE_INTERNO"));
                        nom.setHZRNNOM_TIPO_DOC(rs_nom.getString("HZRNNOM_TIPO_DOC"));
                        nom.setHZRNNOM_ANO(rs_nom.getInt("HZRNNOM_ANO"));
                        nom.setHZRNNOM_MES(rs_nom.getInt("HZRNNOM_MES"));
                        nom.setHZRNNOM_ESTADO(rs_nom.getString("HZRNNOM_ESTADO"));
                        nom.setHZRNNOM_FECHA_EXT(rs_nom.getDate("HZRNNOM_FECHA_EXT"));
                        
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
                            //enc.setHZRNENC_FECHA_ING(rs.getDate("HZRNENC_FECHA_ING"));
                            //enc.setHZRNENC_FECHA_RET(rs.getDate("HZRNENC_FECHA_RET"));
                            //enc.setHZRNENC_FECHA_LIQ_INI(rs.getDate("HZRNENC_FECHA_LIQ_INI"));
                            //enc.setHZRNENC_FECHA_LIQ_FIN(rs.getDate("HZRNENC_FECHA_LIQ_FIN"));
                            //enc.setHZRNENC_TIEMPO_LAB(rs.getBigDecimal("HZRNENC_TIEMPO_LAB"));
                            enc.setHZRNENC_FECHA_EMISION(rs.getDate("HZRNENC_FECHA_EMISION"));
                            //enc.setHZRNENC_CODIGO_TRAB(rs.getString("HZRNENC_CODIGO_TRAB"));
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
                            //enc.setHZRNENC_CUNE(rs.getString("HZRNENC_CUNE"));
                            enc.setHZRNENC_FECHA_GENERA(rs.getDate("HZRNENC_FECHA_GENERA"));
                            enc.setHZRNENC_HORA_GENERA(rs.getString("HZRNENC_HORA_GENERA"));
                            //enc.setHZRNENC_PERIODO_NOM(rs.getInt("HZRNENC_PERIODO_NOM"));
                            //enc.setHZRNENC_TIPO_MONEDA(rs.getString("HZRNENC_TIPO_MONEDA"));
                            //enc.setHZRNENC_TRM(rs.getBigDecimal("HZRNENC_TRM"));
                            enc.setHZRNENC_NUM_PRED(rs.getString("HZRNENC_NUM_PRED"));
                            //enc.setHZRNENC_CUNE_PRED(rs.getString("HZRNENC_CUNE_PRED"));
                            enc.setHZRNENC_FECHA_GEN_PRED(rs.getDate("HZRNENC_FECHA_GEN_PRED"));

                            nom.setEncabezado(enc);
                            enc = null;
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:ENC No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [ENC].");
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
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:NOT No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [NOT].");
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
                            emi.setHZRNEMI_DEPART_ESTADO(rs.getInt("HZRNEMI_DEPART_ESTADO"));
                            emi.setHZRNEMI_MUNICIPIO_CIUDAD(rs.getInt("HZRNEMI_MUNICIPIO_CIUDAD"));
                            emi.setHZRNEMI_DIRECCION(rs.getString("HZRNEMI_DIRECCION"));

                            nom.setEmisor(emi);
                            emi = null;
                        }
                    }else{
                        throw new DataFormatException("Comprobante:getComprobanteExtracted:REC No existen registros");
                    }
                    calendario =Calendar.getInstance();
                    log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [EMI].");
                }

                calendario =Calendar.getInstance();
                log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> [" + cune_interno + "] Mapping completed in [NOM].");
            }
 
        
        }else{
            //con es nulo
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");    
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

    private void getDeletementExtracted() throws SQLException, JAXBException, DataFormatException {
        //PENDIENTE----------------------------------------------------------------------------------------------------------------------------------------   
        if (!(conn == null)) {
            
            //NOMINA
            {
                stmt = NOMINA_QUERY;
                pstmt = conn.prepareStatement(stmt);
                ResultSet rs_nom = pstmt.executeQuery();

                NOMINA nom = new NOMINA();

                while (rs_nom.next()) {

                    nom.setHZRNNOM_ESTADO(rs_nom.getString("HZRNNOM_ESTADO"));
                    nom.setHZRNNOM_CUNE_INTERNO(rs_nom.getString("HZRNNOM_CUNE_INTERNO"));

                }
                
                //TIP  OJOOOOO TERMINAR
                TIP tip = new TIP(1);
                
                //ENC
                {
                    stmt = HZRNENC_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    rs = pstmt.executeQuery();

                    ENC enc = new ENC();

                    while (rs.next()) {

                        enc.setHZRNENC_CUNE_INTERNO(rs.getString("HZRNENC_CUNE_INTERNO"));
                        enc.setHZRNENC_TIPO_DOC(rs.getString("HZRNENC_TIPO_DOC"));
                        enc.setHZRNENC_FECHA_EMISION(rs.getDate("HZRNENC_FECHA_EMISION"));
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
                        enc.setHZRNENC_NUM_PRED(rs.getString("HZRNENC_NUM_PRED"));
                        enc.setHZRNENC_CUNE_PRED(rs.getString("HZRNENC_CUNE_PRED"));
                        enc.setHZRNENC_FECHA_GEN_PRED(rs.getDate("HZRNENC_FECHA_GEN_PRED"));

                        nom.setEncabezado(enc);
                        enc = null;
                    }

                }
                
                //NOT
                {
                    stmt = HZRNNOT_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    rs = pstmt.executeQuery();
                    
                    i= 0;
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
                    

                }
                
                //EMI
                {
                    stmt = HZRNEMI_QUERY;
                    pstmt = conn.prepareStatement(stmt);
                    rs = pstmt.executeQuery();

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
                        emi = null;
                    }

                }
             Xml xml = new Xml();
             System.out.println(xml.ObjectToXML(nom));
             nom = null;
            }

        }else{
            //con es nulo
        }
        //----------------------------------------------------------------------------------------------------------------------------------------   
    }

    private void getLocalFile() throws FileNotFoundException, UnsupportedEncodingException, IOException, SQLException {

        calendario =Calendar.getInstance();
        log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getLocalFile> [" + cune_interno + "] (FILE) Start the xml file generation process");
        
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
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getLocalFile> [" + cune_interno + "] (FILE) Completes the xml file generation process successfully");
        }else{
            updateStatus("FAILEXTRACTION");
            calendario =Calendar.getInstance();
            log.logInFile(log_file_name + "-" + cune_interno, ano + "/" + mes, "(" + calendario.getTime() + "): <Comprobante:getLocalFile> [" + cune_interno + "] (FILE) XML file generation error, xml_string empty or does not exist.");
        }
        
        
    }

    private void getNullAll() {
        stmt = null;
        pstmt = null;
        rs = null;
        log = null;
        calendario = null;
        AMBIENTE = null;
        prefijo = null;
        num_doc = null;
        cune_interno = null;
        tipo_doc = null;
        xml_string = null;
        conn = null;
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
