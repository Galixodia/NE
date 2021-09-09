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

    public void getFileExtracted() throws SQLException, JAXBException {
     
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

    private void getComprobanteExtracted() throws SQLException, JAXBException {
        //PENDIENTE----------------------------------------------------------------------------------------------------------------------------------------   
        //ENC
        {
            stmt = HZRNENC_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
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
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(enc));
            }
    
        }
        //NOV
        {
            stmt = HZRNNOV_QUERY;
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();

            NOV nov = new NOV();
            
            while (rs.next()) {
                               
                nov.setHZRNNOV_CUNE_INTERNO(rs.getString("HZRNNOV_CUNE_INTERNO"));
                nov.setHZRNNOV_NOVEDAD(rs.getString("HZRNNOV_NOVEDAD"));
                nov.setHZRNNOV_CUNE_NOV(rs.getString("HZRNNOV_CUNE_NOV"));
                
                
                Xml xml = new Xml();
                System.out.println(xml.ObjectToXML(nov));
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
