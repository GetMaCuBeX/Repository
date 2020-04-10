package com.mcbx.main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreensFramework extends Application {

    public static String screen1ID = "Screen1";
    public static String screen1File = "Screen1.fxml";

    public static String screen2ID = "Screen2";
    public static String screen2File = "Screen2.fxml";

    public static String screen3ID = "Screen3";
    public static String screen3File = "Screen3.fxml";

    @Override
    public void start(Stage primaryStage) {
        // CREATE Group obj
        Group groupObj = new Group();
        
        // CREATE ScreensConctroller obj
        ScreensController screensControlerObj = new ScreensController();

        // LOAD THE FXML FILE TO THE HASHMAP VIA ID AND FXML FILE
        screensControlerObj.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
        screensControlerObj.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
        screensControlerObj.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);

        // SET THE SCREEN VIA ID IN THE HASHMAP
        screensControlerObj.setScreen(ScreensFramework.screen1ID);

        // ADD ScreensController obj TO THE GROUP obj
        groupObj.getChildren().addAll(screensControlerObj);

        // CREATE Scene obj
        // ADD THE GROUP obj TO THE Scene obj
        Scene sceneObj = new Scene(groupObj);
        
        // SET PROPERTY OF THE STAGE/WINDOW
        primaryStage.setTitle("Login");
//        primaryStage.setResizable(false);
//        primaryStage.setIconified(false);
        primaryStage.setScene(sceneObj);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
