/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.utils_;

import com.vtt.services.CategoryServices;
import com.vtt.services.LevelServices;
import com.vtt.services.questions.QuestionsServices;
import com.vtt.services.questions.UpdateQuestionsServices;

/**
 *
 * @author admin
 */
public class Configs {

    public static final CategoryServices cateService = new CategoryServices();
    public static final LevelServices lvlService = new LevelServices();
    public static final QuestionsServices questionService = new QuestionsServices();
    public static final UpdateQuestionsServices uQuestionService  =  new UpdateQuestionsServices();
}
