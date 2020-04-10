 
package com.mcbx.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent scene = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        primaryStage.setScene(new Scene(scene));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
