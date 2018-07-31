/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
/**
 *
 * @author Admin
 */
public class InsUpDelSel {

    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/rentdvd";
    String USER = "root";
    String PASSWORD = "";
    Connection con = null;
    Statement stmt = null;

    private void getCon() {
        try
        {Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        catch (Exception ex)
        {JOptionPane.showMessageDialog(null,ex.getMessage());
    }
    }
       
    
    public int execStmt(String sql) {
        int rtn = 0;
        try
        {
            getCon();
        stmt = con.createStatement();
        rtn = stmt.executeUpdate(sql);
        }
        catch (Exception ex)
                {JOptionPane.showMessageDialog(null,ex.getMessage());}
        return rtn;
              
        }
    

    public ResultSet selectData(String sql) {
        ResultSet rtn = null;
        try
        {getCon();
        stmt=con.createStatement();
        rtn=stmt.executeQuery(sql);
        }
        catch (Exception ex)
        {JOptionPane.showMessageDialog(null,ex.getMessage());}
        return rtn;
    }
        
}           
    

