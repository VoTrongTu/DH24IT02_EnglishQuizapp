package com.vtt.quizapp.englishquizapp;

import MyAlert.MyAlert;
import com.vtt.utils.themes.ThemesTypes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class PrimaryController implements Initializable{
    @FXML private ComboBox<ThemesTypes> cbThemes;
    
       @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbThemes.setItems(FXCollections.observableArrayList(ThemesTypes.values()));
    }
    
    public void manageQuestion(ActionEvent e){
        MyAlert.getInstance().showAlert("coming soon...");
    }
    public void praticeQuestion(ActionEvent e){
        MyAlert.getInstance().showAlert("coming soon...");
    }
     public void examQuestion(ActionEvent e){
        MyAlert.getInstance().showAlert("coming soon...");
    }

     public void changeTheme(ActionEvent e){
         switch(this.cbThemes.getSelectionModel().getSelectedItem()){
             case DARK:
                  this.cbThemes.getScene().getRoot().getStylesheets().clear();
                   this.cbThemes.getScene().getRoot().getStylesheets().add(App.class.getResource("dark.css").toExternalForm());
                 break;
             case LIGHT:
                 this.cbThemes.getScene().getRoot().getStylesheets().clear();
                   this.cbThemes.getScene().getRoot().getStylesheets().add(App.class.getResource("light.css").toExternalForm());
                 break;
              default:
                   this.cbThemes.getScene().getRoot().getStylesheets().clear();
                   this.cbThemes.getScene().getRoot().getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                    
                 
         }
             
     }
}
