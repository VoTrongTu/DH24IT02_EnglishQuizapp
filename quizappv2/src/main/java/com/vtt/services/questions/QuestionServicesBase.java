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
public interface  QuestionServicesBase {
      List<Question> list() throws SQLException;
}
