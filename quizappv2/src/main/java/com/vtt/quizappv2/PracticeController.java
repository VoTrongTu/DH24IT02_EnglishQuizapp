/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vtt.quizappv2;

import com.vtt.pojo.Category;
import com.vtt.pojo.Level;
import com.vtt.pojo.Question;
import com.vtt.pojo.QuestionQueryBuilder;
import com.vtt.services.questions.QuestionServicesDecorator;
import com.vtt.utils_.Configs;
import com.vtt.utils_.MyAlertSingleton;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class PracticeController implements Initializable {
    @FXML private ComboBox<Category> cbSearchCates;
    @FXML private ComboBox<Level> cbSearchLevels;
    @FXML private TextField txtNum;
    @FXML private Label lblContent;
    @FXML private VBox vchoices;
    private List<Question> questions;
    private int currentIdx = -1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbSearchCates.setItems(FXCollections.observableList(Configs.cateService.getCates()));
            this.cbSearchLevels.setItems(FXCollections.observableList(Configs.lvlService.getLevels()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    public void start(ActionEvent e){
        QuestionQueryBuilder b = new QuestionQueryBuilder()
                .setLimit(this.txtNum.getText()).setOrderBy("rand()")
                .widthCategory(this.cbSearchCates.getSelectionModel().getSelectedItem())
                .widthLevel(this.cbSearchLevels.getSelectionModel().getSelectedItem());
        Configs.questionService.setSql(b);
        try {
            this.questions =  new QuestionServicesDecorator(Configs.questionService).getQuestions();
            this.loadQuestion(1);
        } catch (SQLException ex) {
            Logger.getLogger(PracticeController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void next(ActionEvent e){
        this.loadQuestion(1);
    }
    
    public void previous(ActionEvent e){
     this.loadQuestion(-1);
    }
    
    public void checkAnswer(ActionEvent e){
        Question q = this.questions.get(this.currentIdx);
        
        for(int i=0;i<this.vchoices.getChildren().size();i++){
            RadioButton r = (RadioButton)this.vchoices.getChildren().get(i);
            
            if(r.isSelected()){
                if(q.getChoice().get(i).isCorrect()==true)
                    MyAlertSingleton.getInstance().showAlert("CHÍNH XÁC!");
                else MyAlertSingleton.getInstance().showAlert("SAI RỒI!", Alert.AlertType.ERROR);
                break;
            }
        }
   }
    
    private void loadQuestion(int step){
        this.currentIdx += step;
        if (this.currentIdx >= 0 && this.currentIdx < this.questions.size()) {
            Question q = this.questions.get(this.currentIdx);
            this.lblContent.setText(q.getContent());

            ToggleGroup t = new ToggleGroup();
            this.vchoices.getChildren().clear();
            for (var c : q.getChoice()) {
                RadioButton r = new RadioButton(c.getContent());
                r.setToggleGroup(t);
                this.vchoices.getChildren().add(r);
            }
        }
    }
}
