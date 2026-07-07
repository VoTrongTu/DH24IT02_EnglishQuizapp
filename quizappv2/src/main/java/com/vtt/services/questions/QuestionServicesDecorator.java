/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.services.questions;

import com.vtt.pojo.Question;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TuPC
 */
public class QuestionServicesDecorator extends QuestionServicesBase{
    private QuestionServicesBase service;

    public QuestionServicesDecorator(QuestionServicesBase service) {
        this.service = service;
    }

    @Override
    public List<Question> getQuestions() throws SQLException {
        List<Question> questions = this.service.getQuestions();
        
        ChoiceServices choiceService = new ChoiceServices();
        for(var q: questions)
            q.setChoice(choiceService.getChoicesByQuestionId(q.getId()));
        return questions;
    }
    
    
}
