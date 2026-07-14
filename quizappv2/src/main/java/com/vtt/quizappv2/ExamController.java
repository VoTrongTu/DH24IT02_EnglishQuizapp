/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vtt.quizappv2;

import com.vtt.pojo.Choice;
import com.vtt.pojo.Question;
import com.vtt.services.exam.ExamStratery;
import com.vtt.services.exam.ExamTypes;
import com.vtt.services.exam.FixedStratery;
import com.vtt.services.exam.SpecificExam;
import com.vtt.utils_.MyAlertSingleton;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ExamController implements Initializable {

    @FXML
    private ComboBox<ExamTypes> cbExamTypes;
    @FXML
    private TextField txtNum;
    @FXML
    private ListView<Question> lvQuestions;
    private List<Question> questions;
    private Map<Integer, Choice> answers = new HashMap<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbExamTypes.setItems(FXCollections.observableArrayList(ExamTypes.values()));
        
        this.txtNum.setVisible(false);
        this.cbExamTypes.getSelectionModel().selectedIndexProperty().addListener(e-> {
            if(this.cbExamTypes.getSelectionModel().getSelectedItem()== ExamTypes.FIXED){
                this.txtNum.setVisible(false);
            }else 
                this.txtNum.setVisible(true);
        });
        
        this.lvQuestions.setCellFactory(callback-> new ListCell<Question>(){
            @Override
            protected void updateItem(Question q, boolean empty) {
                super.updateItem(q, empty);
                if(q==null|| empty == true){
                    setGraphic(null);
                }else{
                    VBox v =new VBox(5);
                    v.setStyle("-fx-border-width:2;-fx-border-color:black;-fx-padding:10");
                    
                    Text t = new Text(q.getContent());
                    v.getChildren().add(t);
                    
                    ToggleGroup toggle = new ToggleGroup();
                    for(var c: q.getChoice()){
                        RadioButton rdo = new RadioButton(c.getContent());
                        rdo.setToggleGroup(toggle);
                        
                        if(answers.get(q.getId()) == c)
                            rdo.setSelected(true);
                        
                        rdo.setOnAction(evt->{
                            if(rdo.isSelected()==true)
                                answers.put(q.getId(), c);
                        });
                         
                        v.getChildren().add(rdo);
                    }
                    setGraphic(v);
                }
               }
        });
        
    }

    public void start(ActionEvent e) {
        this.answers  =new HashMap<>();
        switch (this.cbExamTypes.getSelectionModel().getSelectedItem()) {
            case SPECIFIC:
                ExamStratery ex = new SpecificExam(this.txtNum.getText());
                this.questions = ex.getQuestions();
                break;
            default:
                ExamStratery ex1 = new FixedStratery();
                this.questions = ex1.getQuestions();
                break;
        }
        this.lvQuestions.setItems(FXCollections.observableArrayList(this.questions));
    }

    public void gradding(ActionEvent e){
     int count =0;
     for(var c: answers.values())
         if(c.isCorrect()==true)
             count++;
     
        MyAlertSingleton.getInstance().showAlert(String.format("Bạn đúng %d/%d câu", count,this.questions.size()),Alert.AlertType.INFORMATION);
    }
}
