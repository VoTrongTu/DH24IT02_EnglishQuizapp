/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.services.questions;


import com.vtt.pojo.Question;
import com.vtt.pojo.QuestionQueryBuilder;
import com.vtt.services.QueryServiceBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TuPC
 */
public class QuestionsServices extends QueryServiceBase<Question> implements  QuestionServicesBase{
    private QuestionQueryBuilder query;

    public QuestionsServices() {
    }

    public QuestionsServices(QuestionQueryBuilder query) {
        this.query = query;
    }
    
     @Override
    public PreparedStatement getStm() throws SQLException {
       return this.query.build();
    }

    @Override
    public List<Question> getResults(ResultSet rs) throws SQLException {
        List <Question> questions =     new ArrayList<>();
         while(rs.next()){
            questions.add(new Question.QuestionBuilder().setId(rs.getInt("id")).setContent(rs.getString("content")).build());
        }
        return questions;
    }
    
    public List<Question> list() throws SQLException{

        PreparedStatement stm = this.query.build();
        ResultSet rs = stm.executeQuery();
        List <Question> questions =     new ArrayList<>();
        while(rs.next()){
            questions.add(new Question.QuestionBuilder().setId(rs.getInt("id")).setContent(rs.getString("content")).build());
        }
        return questions;
    }

    /**
     * @param sql the sql to set
     */
    public void setSql(QuestionQueryBuilder query) {
        this.query = query;
    }

   
    
  
}
