package co.edu.upb.nominae;

import java.sql.SQLException;


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

        //THE MF MAGIC
        try {
             
            //System.out.println("getContructionLive: " + C.getContructionLive());
            //System.out.println("getComprobanteExist: " + C.getComprobanteExist());

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
            //Logger.getLogger(Transmision.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("1###############################################################################");
            System.out.println(ex.getMessage());
        }catch (InterruptedException ex) {
            //Logger.getLogger(Transmision.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("2%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println(ex.getMessage());
        }finally{
            C = null;
        }
        
        
        
    }
    
}
