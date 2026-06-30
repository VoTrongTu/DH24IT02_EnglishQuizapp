/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.services;

import com.vtt.pojo.Category;
import com.vtt.pojo.Level;
import com.vtt.utils_.MyConnSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class LevelServices {
     public List<Level> getLevels() throws SQLException{
         String sql = "SELECT * FROM level";
            Statement stm = MyConnSingleton.getInstance().connect().createStatement(); 
            ResultSet rs  = stm.executeQuery(sql); 
            
            List<Level> levels = new ArrayList<>();
            while (rs.next()){
                levels.add(new Level(rs.getInt("id"),rs.getString("name")));
            }
            return levels;
    }
}
