/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vtt.quizappv2;

import com.vtt.pojo.Question;
import com.vtt.services.exam.ExamStratery;
import com.vtt.services.exam.ExamTypes;
import com.vtt.services.exam.SpecificExam;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ExamController implements Initializable {

    @FXML private ComboBox<ExamTypes> cbExamTypes;
    @FXML private TextField txtNum;
    @FXML private ListView<Question> lvQuestions;
    private List<Question> questions;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      this.cbExamTypes.setItems(FXCollections.observableArrayList(ExamTypes.values()));
    }    
    
     public void start(ActionEvent e){
         if(this.cbExamTypes.getSelectionModel().getSelectedItem() == ExamTypes.SPECIFIC){
             ExamStratery  ex = new SpecificExam(this.txtNum.getText());
             this.questions = ex.getQuestions();
             
             
                   this.lvQuestions.setItems(FXCollections.observableArrayList(this.questions));
         }
     }
    
}
