package com.mcbx.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Screen1Controller implements Initializable, ControlledScreen {

    ScreensController myController;

    @Override
    public void initialize(URL location, ResourceBundle rb) {
    }
  
    @Override
    public void setScreenParent(ScreensController screenParent) {
            myController = screenParent;
    }
    
    @FXML
    public void goToScreen2(ActionEvent event){
        myController.setScreen(ScreensFramework.screen2ID);
    }
    
    @FXML
    public void goToScreen3(ActionEvent event){
        myController.setScreen(ScreensFramework.screen3ID);
    }   
 
 
    
}
