/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.services.questions;

import com.vtt.pojo.Question;
import com.vtt.pojo.QuestionQueryBuilder;
import com.vtt.utils_.Configs;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionFacade {
    public static List<Question> getQuestion(QuestionQueryBuilder query) throws SQLException{
        Configs.questionService.setSql(query);
        return Configs.questionService.list();
    }
}
