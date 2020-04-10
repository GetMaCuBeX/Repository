/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
 
public class Scene2Controller implements Initializable {
 

    @FXML
    Button button; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

 
 
    public void myFunction(String text){
        button.setText(text);
    }

}
