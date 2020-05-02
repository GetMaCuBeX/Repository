 
package com.mgrecol.jasper.window.displayreport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parentRoot = FXMLLoader.load(getClass().getResource("layout.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(new Scene(parentRoot));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
