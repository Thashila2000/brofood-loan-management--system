/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loan_management;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ACER
 */
public class dbConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/loandb"; 
        String username = "root"; 
        String password = "thashila2000#";
        
        try {
            // Establish connection
           
            Connection connect = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MySQL database!");
            
            // Close connection after usage
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Connection connect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

