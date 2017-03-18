/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author steph
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConControl {
    private Connection conn;
    
    public Connection connection() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        String driverName="com.mysql.jdbc.Driver";
        String dbUrl="jdbc:mysql://localhost:3307/cardb";
        String userName="steph";
        String password="root";
        
        Class.forName(driverName).newInstance();
        
        try{
            conn = DriverManager.getConnection(dbUrl, userName, password);
            return conn;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }      
    }
    public int endConnection(Connection c){
        try{
            if(c!=null){c.close();}
            return 1;
        }catch(SQLException e){
            return 0;
        }
    }
    

    
}
