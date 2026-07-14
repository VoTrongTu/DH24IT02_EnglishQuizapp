/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.services;

import com.vtt.pojo.Category;
import com.vtt.utils_.MyConnSingleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public abstract class QueryServiceBase<T> {
    public  List<T> list() throws SQLException{
            PreparedStatement stm = this.getStm(); 
            ResultSet rs  = stm.executeQuery(); 
            
            return this.getResults(rs);
    }//template method
    
    public abstract PreparedStatement getStm() throws SQLException;
    public abstract List<T> getResults(ResultSet rs) throws SQLException;
}
