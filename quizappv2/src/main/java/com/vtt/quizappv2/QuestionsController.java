/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vtt.quizappv2;

import com.vtt.pojo.Category;
import com.vtt.pojo.Choice;
import com.vtt.pojo.Level;
import com.vtt.pojo.Question;
import com.vtt.services.CategoryServices;
import com.vtt.services.LevelServices;
import com.vtt.services.questions.QuestionsServices;
import com.vtt.utils_.Configs;
import com.vtt.utils_.MyAlertSingleton;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {
    @FXML private TextArea txtContent;
    @FXML private ComboBox<Category> cbCates;
    @FXML private ComboBox<Level> cbLevels;
    @FXML private TableView<Question> tvQuestions;
    @FXML private VBox vChoices;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadColumns();
        
        try {

            this.cbCates.setItems(FXCollections.observableList(Configs.cateService.getCates()));
            this.cbLevels.setItems(FXCollections.observableList(Configs.lvlService.getLevels()));
            this.tvQuestions.setItems(FXCollections.observableList(Configs.questionService.getQuestions(null)));
        } catch (SQLException ex) {
//            Logger.getLogger(QuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadColumns() {
        TableColumn colId = new TableColumn("Id");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colId.setPrefWidth(80);

        TableColumn colContent = new TableColumn("Nội dung câu hỏi");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(80);

        this.tvQuestions.getColumns().addAll(colId, colContent);
    }

    public void addChoice() {
        HBox h = new HBox();
        h.getStyleClass().add("Container");

        RadioButton rod = new RadioButton();
        TextField txt = new TextField();
        txt.getStyleClass().add("input");
        
        //thêm rod txt và Hbox
        h.getChildren().addAll(rod, txt);
        
        this.vChoices.getChildren().add(h);
    }

    public void addQuestion(ActionEvent e){
        Question q = new Question.QuestionBuilder().setContent(txtContent.getText())
                .setCategory(cbCates.getSelectionModel().getSelectedItem())
                .setLevel(cbLevels.getSelectionModel().getSelectedItem()).build();
        
        List<Choice> choices = new ArrayList<>();
        for( var hBox: this.vChoices.getChildren()){
            HBox h =(HBox)hBox;
            
            RadioButton rdo = (RadioButton)h.getChildren().get(0);
            TextField txt = (TextField)h.getChildren().get(1);
            
            choices.add(new Choice(txt.getText(),rdo.isSelected()));
        }
        try {
            Configs.uQuestionService.addQuestion(q, choices);
            MyAlertSingleton.getInstance().showAlert("Thêm câu hỏi thành công!");
        } catch (SQLException ex) {
            MyAlertSingleton.getInstance().showAlert("Thêm câu hỏi thất bại "+ ex.getMessage());
        }
    }
    
    
}
