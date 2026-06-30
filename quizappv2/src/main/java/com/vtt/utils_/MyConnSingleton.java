/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.utils_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TuPC
 */
public class MyConnSingleton {
    private static MyConnSingleton instance;
    private Connection conn;
    
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private MyConnSingleton(){
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/quizdb", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static MyConnSingleton getInstance(){
        if(instance == null)
            instance = new MyConnSingleton();
        
        return instance;
    }
    
    public Connection connect(){
        return this.conn;
    }
    
    public void close(){
        if(this.conn != null)
            try {
                this.conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyConnSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
