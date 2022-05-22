package zabavypos;

/**
 *
 * @author Juanez
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZabavyDB {
    Connection Conexion;
    Statement ST;
    ResultSet RS;
    
    public void Conection(String Host, String Base, String User, String Pass){
        try {
            Conexion = DriverManager.getConnection("jdbc:mysql://" + Host + ":3306/" + Base, User, Pass);
            ST = Conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ZabavyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Update(String SQL){
        try {
            ST.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(ZabavyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Delete(String SQL){
        try {
            ST.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(ZabavyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Insert(String SQL){
        try {
            ST.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(ZabavyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet Select(String SQL){
        try {
            RS = ST.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(ZabavyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return RS;
    }
    
}
