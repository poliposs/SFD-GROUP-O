/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.passwordmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;  
import java.sql.Statement;


/**
 *
 * @author paulp
 */
public class PasswordsMethod {
    
        public static void createNewTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:SSSIT.db";  
          
        // SQL statement for creating a new table  
        String sql = """
                     CREATE TABLE IF NOT EXISTS passwords (
                      websiteName text VARCHAR(25) NOT NULL,
                      passwordHash VARCHAR(64) NOT NULL
                     );""";  
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        createNewTable(); 
        innuuijuni
    }    
    
    
}
