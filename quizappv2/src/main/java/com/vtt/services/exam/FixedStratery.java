 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.services.exam;

import com.vtt.pojo.Question;
import com.vtt.pojo.QuestionQueryBuilder;
import com.vtt.services.questions.QuestionFacade;
import com.vtt.utils_.Configs;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class FixedStratery implements ExamStratery {

    @Override
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < Configs.RATES.length; i++) {
            QuestionQueryBuilder q = new QuestionQueryBuilder().widthLevel(i + 1).setLimit((int) (Configs.RATES[i] * Configs.EXAM_NUM)).setOrderBy("Rand()");
            try {
                questions.addAll(QuestionFacade.getLazyQuestions(q));
            } catch (SQLException ex) {
                Logger.getLogger(FixedStratery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return questions;
    }
}
