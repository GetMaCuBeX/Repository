package com.mcbx.database;

import database.Database;
import database.MySQL;
import java.sql.Connection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Scene sceneObj;
    Stage window;
    Button btn;
    Button btnShowReport;
    Connection conn;
    MySQL mysqlObj = new MySQL("localhost", "3306", "booksreservation", "root", "");

//    private JasperPrint jasperPrint;
//    private JRViewer jasperViewer;
//    private Container instanceContainer;
    @Override
    public void start(Stage primaryStage) {
        StackPane stackPaneObj = new StackPane();
        VBox vboxObj = new VBox();

        Button btn1 = new Button("Establish Database Connection...");
        Button btn2 = new Button("Test Database Connection...");

        // Establish Connection
        btn1.setOnAction((event) -> {
            System.out.println("Connecting...");
            conn = Database.getConnectionMySQL(mysqlObj,primaryStage);
            if (conn != null) {
                // Execute query...
            } else {
                // Connecting failed...
            }
        });

        // Test Connection
        btn2.setOnAction((event) -> {
            try {
                if (mysqlObj.getConnection() != null) {
                    AlertHelper.showAlert(AlertType.INFORMATION, primaryStage, "Information", null, "The server connection was successfully established");
                } else {
                    AlertHelper.showAlert(AlertType.WARNING, primaryStage, "Information", null, "The server connection was not successfully established");
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        });

        vboxObj.getChildren().addAll(btn1, btn2);

        stackPaneObj.getChildren().addAll(vboxObj);
        sceneObj = new Scene(stackPaneObj, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(sceneObj);

        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }

}
