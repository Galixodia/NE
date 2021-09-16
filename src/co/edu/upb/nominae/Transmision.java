package co.edu.upb.nominae;

import java.sql.SQLException;
import java.util.zip.DataFormatException;
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
       
    public static void main(String[] args) throws DataFormatException {

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
             
            //System.out.println("getContructionLive: " + C.getContructionLive());
            //System.out.println("getComprobanteExist: " + C.getComprobanteExist());

            //throws DataFormatException, SQLException, JAXBException, ArrayIndexOutOfBoundsException
            
            while(true){    
                C = new Comprobante();
                if(C.getContructionLive() == 0){
                    if(C.getComprobanteExist()==1){
                        C.getFileExtracted();   
                    }else{
                        Thread.sleep(Integer.parseInt(loop));
                    }
                }
                C = null;
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            //Logger.getLogger(Transmision.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("1###############################################################################");
        } catch (JAXBException ex) {
            //Logger.getLogger(Transmision.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("2%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        } catch(DataFormatException ex){
            System.out.println("3&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        } finally{
            C = null;
        }
        
        
        
    }
    
}
