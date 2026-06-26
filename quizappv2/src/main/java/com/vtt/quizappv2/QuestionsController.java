/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vtt.quizappv2;

import com.vtt.pojo.Category;
import com.vtt.pojo.Question;
import com.vtt.services.CategoryServices;
import com.vtt.services.QuestionsServices;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {

    @FXML
    private ComboBox<Category> cbCates;
    @FXML
    private TableView<Question> tvQuestions;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadColumns();
        CategoryServices s = new CategoryServices();
        QuestionsServices questionService = new QuestionsServices();
        try {

            this.cbCates.setItems(FXCollections.observableList(s.getCates()));
            this.tvQuestions.setItems(FXCollections.observableList(questionService.getQuestions(null)));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadColumns(){
        TableColumn colId= new TableColumn("Id");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colId.setPrefWidth(80);
        
        TableColumn colContent =  new TableColumn("Nội dung câu hỏi");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(80);
        
        this.tvQuestions.getColumns().addAll(colId, colContent);
    }
    
   
}
