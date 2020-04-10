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

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parentRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
//        primaryStage.setScene(new Scene(root, 500,500));
        primaryStage.setTitle("Login");
        primaryStage.setResizable(false);
        primaryStage.setIconified(false); 
        primaryStage.setScene(new Scene(parentRoot));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);        
        
        
    }

 
}
