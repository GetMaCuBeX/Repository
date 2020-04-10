/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Dashboard extends Application {
 
//    private String reportsDirectory = System.getProperty("user.dir") + "/com/mcbx/login/";
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
        Parent parentRoot = FXMLLoader.load(getClass().getResource("dashboard.fxml"));  
            primaryStage.setScene(new Scene(parentRoot));
            primaryStage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
