/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.utils;

import com.dht.quizappv2.App;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class MyStageSingleton {
    private static MyStageSingleton instance;
    private final  Stage stage;
    
    private MyStageSingleton(){
        this.stage = new Stage();
        this.stage.setTitle("Quiz App");
    }
    
    public static MyStageSingleton getInstance(){
        if(instance == null)
            instance = new MyStageSingleton();
        return instance;
    }
    
    public void showStage(String fxml){
        if(!this.stage.isShowing()){
            Scene scene = null;
            try {
                scene = new Scene(new FXMLLoader(App.class.getResource(fxml+".fxml")).load());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.stage.setScene(scene);
            this.stage.show();
        }
                    
    }
}
