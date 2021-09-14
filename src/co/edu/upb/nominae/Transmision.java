package co.edu.upb.nominae;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

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
        Comprobante C;
        
        if(loop == null){
            loop = "30000";
        }else{
            if(Integer.parseInt(loop)<= 30000){
                loop = "30000";
            }
        }
        
        //THE MF MAGIC
        try {
            C = new Comprobante();
            
            System.out.println("getComprobanteLive: " + C.getComprobanteLive());
            System.out.println("getComprobanteExist: " + C.getComprobanteExist());
            

            while(true){                
                if(C.getComprobanteLive() == 0){
                    if(C.getComprobanteExist()==1){
                        C.getFileExtracted();   
                    }else{
                        Thread.sleep(Integer.parseInt(loop));
                    }
                }
                
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(Transmision.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(Transmision.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(Transmision.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Transmision.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
