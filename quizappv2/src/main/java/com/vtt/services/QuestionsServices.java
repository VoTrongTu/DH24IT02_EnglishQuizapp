/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.services;

import com.vtt.utils_.MyConnSingleton;
import com.vtt.pojo.Question;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TuPC
 */
public class QuestionsServices {
    public List<Question> getQuestions(String kw) throws SQLException{
        String sql = "SELECT * FROM question";
        PreparedStatement stm = MyConnSingleton.getInstance().connect().prepareCall(sql);
        ResultSet rs = stm.executeQuery();
        
        List <Question> questions =     new ArrayList<>();
        while(rs.next()){
            Question q = new Question();
            q.setId(rs.getInt("id"));
            q.setContent(rs.getString("content"));
            questions.add(q);
        }
        return questions;
    }
    
  
}
