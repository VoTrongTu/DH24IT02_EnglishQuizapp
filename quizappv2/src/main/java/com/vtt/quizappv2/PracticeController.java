/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vtt.quizappv2;

import com.vtt.pojo.Category;
import com.vtt.pojo.Level;
import com.vtt.pojo.Question;
import com.vtt.pojo.QuestionQueryBuilder;
import com.vtt.utils_.Configs;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class PracticeController implements Initializable {
    @FXML private ComboBox<Category> cbSearchCates;
    @FXML private ComboBox<Level> cbSearchLevels;
    @FXML private TextField txtNum;
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
        QuestionQueryBuilder b = new QuestionQueryBuilder().setLimit(this.txtNum.getText())
                .widthCategory(this.cbSearchCates.getSelectionModel().getSelectedItem())
                ; // chưa xg nha
    }
}
