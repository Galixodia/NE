package co.edu.upb.nominae.extractor;

import co.edu.upb.pojos.utilities.UtilitiesFile;
import co.edu.upb.utilities.Log;
import co.edu.upb.utilities.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


/**
 *
 * @author 000329745 Juan Camilo Villa 
 * @since 01/09/2021
 * @version 1.0
 * 
 * Orquestador de archivos XML extraccion de documentos soporte de nomina electronica
 * para la UPB a Operador Tecnologico Carvajal.
 */
public final class Extractor {
       
    public UtilitiesFile utilities_file;
    private Connection conn = null;
    private Log log;
    private Calendar calendario;
    public static Comprobante comp;
    
    private String stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    private String cune;
    private String tipo_doc;
    private int affected;
    private int ano;
    private int mes;
    
    private String host;
    private String port;
    private String ftp_user;
    private String ftp_pwd;
    private String ftp_dir;
    private String local_dir;
    private String db_url;
    private String db_user;
    private String db_pwd;
    private String log_file_name;
    private String ambiente;

    public Extractor()  {

        try {
            log = new Log();
            utilities_file = new Utilities().getUtilities("UtlNominaE.json");
            
            host = utilities_file.getServer();
            port = utilities_file.getPort();
            ftp_user = utilities_file.getFtpusername();
            ftp_pwd = utilities_file.getFtppassword();
            ftp_dir = utilities_file.getFtp_dir();
            local_dir = utilities_file.getLocal_dir();
            db_url = utilities_file.getUrl();
            db_user = utilities_file.getUsername();
            db_pwd = utilities_file.getPassword();
            log_file_name = utilities_file.getLog_file_name();
            ambiente = utilities_file.getEnvironment();
            
            conn = DriverManager.getConnection(db_url, db_user, db_pwd);
            
            createThreads();
            
            
        } catch (SQLException ex) {
            calendario =Calendar.getInstance();
            log.logInFile(utilities_file.getLog_file_name(),null, "(" + calendario.getTime() + "): <Transmision:main>  (DB) Exception in connection with the database: " + ex.getMessage());
        } catch (InterruptedException ex) {
            calendario =Calendar.getInstance();
            log.logInFile(utilities_file.getLog_file_name(),null, "(" + calendario.getTime() + "): <Transmision:main>  (THREAD) Exception in interrupt  Thread: " + ex.getMessage());
        }finally{
            log = null;
            utilities_file = null;
            calendario = null;
            conn = null;
        }
        
    }
    
    public void getCune() throws SQLException{
            //conn = DriverManager.getConnection(db_url, db_user, db_pwd);
            
            stmt = "SELECT HZRNNOM_CUNE_INTERNO, HZRNNOM_TIPO_DOC, HZRNNOM_ANO, HZRNNOM_MES FROM UPB_NOMINAE.HZRNNOM WHERE (HZRNNOM_ESTADO IS NULL OR HZRNNOM_ESTADO IN ('REEXTRACT')) AND rownum <= 1";
      
            pstmt = conn.prepareStatement(stmt);
            rs = pstmt.executeQuery();
            
            cune = null;
            tipo_doc = null;
            comp = null;
            affected = 0;

            while (rs.next()) {

                cune = rs.getString("HZRNNOM_CUNE_INTERNO");
                tipo_doc = rs.getString("HZRNNOM_TIPO_DOC");
                ano = rs.getInt("HZRNNOM_ANO");
                mes = rs.getInt("HZRNNOM_MES");

                if(cune != null && tipo_doc != null){
                    pstmt = conn.prepareStatement("UPDATE UPB_NOMINAE.HZRNNOM SET HZRNNOM_ESTADO = ? WHERE HZRNNOM_CUNE_INTERNO = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
                    pstmt.setString(1, "EXTRACTING");
                    pstmt.setString(2, cune);
                    affected = pstmt.executeUpdate();
                    
                    comp = new Comprobante(cune,tipo_doc,ano,mes,local_dir,db_url,db_user,db_pwd,log_file_name,ambiente);
                    
                    System.out.println("INICIO ____________________________________________________________________________");
                    System.out.println("CUNE: " + cune);
                    System.out.println("TIPO_DOC: " + tipo_doc);
                    System.out.println("comp.comp_alive: " + comp.comp_alive);
                    System.out.println("-------------------------------------------------------------------------------");
                }
            }
    }
    
    public void createThreads() throws SQLException, InterruptedException{
        while(true){
            
            getCune();

            if(comp != null){
                if(comp.comp_alive == 0){
                    comp.run();
                }else{
                    Thread.sleep(Integer.valueOf(utilities_file.getIteration_sleep_milis()));
                }     
            }else{
                calendario =Calendar.getInstance();
                System.out.println( "[" + calendario.getTime() + "]No hay Documentos para Extraer...");
                Thread.sleep(Integer.valueOf(utilities_file.getLoop_milis()));
            } 
        }
    }
    
    public static void main(String[] args) {
        Extractor e = new Extractor();
    }
    
}
