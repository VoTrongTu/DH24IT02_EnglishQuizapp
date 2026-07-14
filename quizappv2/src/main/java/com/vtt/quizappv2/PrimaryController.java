package com.vtt.quizappv2;

import com.vtt.utils_.MyStageSingleton;
import com.vtt.utils.themes.ThemeTypes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;


public class PrimaryController implements Initializable {
    @FXML private ComboBox<ThemeTypes> cbThemes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbThemes.setItems(FXCollections.observableArrayList(ThemeTypes.values()));
    }
    
    public void manageQuestion(ActionEvent e) throws IOException {
          MyStageSingleton.getInstance().showStage("questions");
    }
    
    public void practice(ActionEvent e) {
         MyStageSingleton.getInstance().showStage("practice");
    }
    
    public void exam(ActionEvent e) {
        MyStageSingleton.getInstance().showStage("exam");
    }

    public void changeTheme(ActionEvent e) {
        this.cbThemes.getSelectionModel().getSelectedItem().updateTheme(this.cbThemes.getScene());
    }
}
