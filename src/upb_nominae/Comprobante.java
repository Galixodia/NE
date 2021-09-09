package upb_nominae;

import co.edu.upb.pojos.utilities.UtilitiesFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import co.edu.upb.utilities.Log;
import java.util.Calendar;
import co.edu.upb.utilities.Utilities;

/**
 *
 * @author 000329745 Juan Camilo Villa 
 * @since 01/09/2021
 * @version 1.0
 * 
 * Clase que permite la extraccion, creacion y transmicion de el comprobante de nomina a carvajal.
 */
public class Comprobante {
    
    private int comprobante_live;
    private int comprobante_exist;
    private Connection conn;
    private String stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private Log log;
    private Calendar calendario;
    private UtilitiesFile utilities_file;

    public Comprobante() {
        comprobante_live = 0;
        comprobante_exist = 0;
        conn = null;
        stmt = null;
        pstmt = null;
        rs = null;
        calendario =Calendar.getInstance();
        utilities_file = new Utilities().getUtilities("UtlNominaE.json");
        
    }

    
    public int getComprobanteLive() {
        return comprobante_live;
    }
    
    public int getComprobanteExist() throws SQLException {
                
        conn = DriverManager.getConnection(utilities_file.getUrl(), utilities_file.getUsername(), utilities_file.getPassword());

        stmt = "alter session set nls_date_format = 'DD/MM/YYYY HH:MI:SS AM'";
        pstmt = conn.prepareStatement(stmt);
        pstmt.execute();

        stmt = "SELECT 1+1 RESPUESTA FROM DUAL"; //WHERE ROWNUM <=1 AND tzrfefs_estado IS NULL AND TZRFEFS_TIPO_DOCUMENTO = 'FE' ";
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

    public void getComprobanteExtracted(String url, String username, String password) throws SQLException {
     
        comprobante_live = 1;
        
        
        
        calendario =Calendar.getInstance();
        log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> (1/) Starting conection to data base.");
        
        conn = DriverManager.getConnection(url, username, password);

        stmt = "alter session set nls_date_format = 'DD/MM/YYYY HH:MI:SS AM'";
        pstmt = conn.prepareStatement(stmt);
        pstmt.execute();
        
        calendario =Calendar.getInstance();
        log.logInFile(utilities_file.getLog_file_name(), "(" + calendario.getTime() + "): <Comprobante:getComprobanteExtracted> (2/) The connection with the data base has been successfully completed.");
            
            
    }
    
}
