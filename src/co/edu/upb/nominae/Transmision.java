package co.edu.upb.nominae;

import co.edu.upb.pojos.utilities.UtilitiesFile;
import co.edu.upb.utilities.Log;
import co.edu.upb.utilities.Utilities;
import java.sql.SQLException;
import java.util.Calendar;


/**
 *
 * @author 000329745 Juan Camilo Villa 
 * @since 01/09/2021
 * @version 1.0
 * 
 * Orquestador de archivos XML transmicion de documentos soporte de nomina electronica
 * para la UPB a Operador Tecnologico Carvajal.
 */
public class Transmision {
       
    public static void main(String[] args) {

        String loop= "30000"; //eliminar valor quemado
        Comprobante C;
        Log log = new Log();
        UtilitiesFile utilities_file = new Utilities().getUtilities("UtlNominaE.json");
        Calendar calendario =Calendar.getInstance();

        //THE MF MAGIC
        try {

            while(true){    
                C = new Comprobante();
                
                if(!C.isAlive()){//C.getContructionLive() == 0
                    if(C.getComprobanteExist() != null){
                        C.start();
                    }else{
                        Thread.sleep(Integer.parseInt(loop));
                    }
                }
                C = null;
            }
        }catch (SQLException ex) {
            calendario =Calendar.getInstance();
            log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Transmision:main>  (DB) Exception in connection with the database: " + ex.getMessage());
        }catch (InterruptedException ex) {
            calendario =Calendar.getInstance();
            log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Transmision:main>  (THREAD) Exception in thead: " + ex.getMessage());
        }finally{
            loop = null;
            C = null;
            log = null;
            utilities_file = null;
            calendario = null;
        }
        
        
        
    }
    
}
