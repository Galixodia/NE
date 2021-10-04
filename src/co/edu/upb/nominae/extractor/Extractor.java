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
    private Log log;
    private Calendar calendario;
    public static Comprobante comp;
    
    private String local_dir;
    private String db_url;
    private String db_user;
    private String db_pwd;
    private String log_file_name;
    private String ambiente;
    private String sleep_milis;

    public Extractor()  {

        try {
            log = new Log();
            utilities_file = new Utilities().getUtilities("UtlNominaE.json");
            
            local_dir = utilities_file.getLocal_dir();
            db_url = utilities_file.getUrl();
            db_user = utilities_file.getUsername();
            db_pwd = utilities_file.getPassword();
            log_file_name = utilities_file.getLog_file_name();
            ambiente = utilities_file.getEnvironment();
            sleep_milis = utilities_file.getIteration_sleep_milis();
            
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
        }
        
    }

    public void createThreads() throws SQLException, InterruptedException{
        while(true){
            
            comp = new Comprobante(local_dir,db_url,db_user,db_pwd,log_file_name,ambiente,sleep_milis); 

            if(comp.comp_alive == 1){
                comp.run();
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
