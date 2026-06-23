/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizappv2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // B1. Nạp driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // B2. Mở kết nối
            Connection conn = DriverManager.getConnection("jbdc:mysql//localhost", "root", "root");
            
            // B3. Truy vấn dl
            String sql = "SELECT *FROM category";
            Statement stm = conn.createStatement();
            ResultSet rs  = stm.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
}
