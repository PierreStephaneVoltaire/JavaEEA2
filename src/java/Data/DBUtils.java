/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.*;

/**
 *
 * @author steph
 */
public class DBUtils {
     public static void closeStatement(Statement stm) throws SQLException{
        if(stm != null){
            stm.close();
        }
    }
    
    public static void closePreparedStatement(PreparedStatement ps) throws SQLException{
        if(ps != null){
            ps.close();
        }
    }
    
    public static void closeResultSet(ResultSet rs) throws SQLException{
        if(rs != null){
            rs.close();
        }
    }
    
}
