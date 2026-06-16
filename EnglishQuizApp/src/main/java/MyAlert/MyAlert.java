/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyAlert;

import javafx.scene.control.Alert;

/**
 *
 * @author admin
 */
public class MyAlert {
    private static MyAlert instance;
    private Alert alert;
    
    private MyAlert(){
        this.alert = new Alert(Alert.AlertType.INFORMATION);
        this.alert.setTitle("quizapp");
    }
    
    public static MyAlert getInstance(){
        if(instance == null)
            instance = new MyAlert();
        return instance;
    }
    
   public void showAlert(String content){
       this.alert.setContentText(content);
       this.alert.show();
   }
}
