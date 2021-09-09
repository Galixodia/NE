package upb_nominae;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private String filename;
    private Transmision T = new Transmision();
    
    
    
        
    public static void main(String[] args) {
        
        String url = null;
        String username = null;
        String password = null;
        String loop= "30000"; //eliminar valor quemado
        Comprobante C = new Comprobante();
        
        //CONECCION
        System.out.println("UPB_FacturacionE: <1> Obtaining Connection Data...");
//        url      = T.getConnection("Url");
//        username = T.getConnection("Username");
//        password = T.getConnection("Password");
//        loop     = T.getConnection("loop-milis");
        System.out.println("UPB_FacturacionE: <2> Connection data obtained.");
        //System.out.println(username+"----"+password);
        
        if(loop == null){
            loop = "30000";
        }else{
            if(Integer.parseInt(loop)<= 30000){
                loop = "30000";
            }
        }
        
        //THE MF MAGIC
        try {
            while(true){                
                if(C.getComprobanteLive() == 0){
                    if(C.getComprobanteExist()==1){
                        C.getComprobanteExtracted(url, username, password);   
                    }else{
                        Thread.sleep(Integer.parseInt(loop));
                    }
                }
                
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(Transmision.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
