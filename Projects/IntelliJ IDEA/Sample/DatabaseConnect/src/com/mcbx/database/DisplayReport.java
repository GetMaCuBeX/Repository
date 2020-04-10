package com.mcbx.database;

import java.sql.Connection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisplayReport extends Application {

    Stage window;
    Scene scene;
    Button btn1;
    Button btnShowReport;
    Connection conn;

    @Override
    public void start(Stage primaryStage) {
        try {
            window = primaryStage;
            window.setTitle("Jasper Report Tutorial");
            btn1 = new Button("Show Report");

            btn1.setOnAction(e -> {
                try {
                    conn = Database.getConnectionMySQL(Database.BOOKS_RESERVATION, window);
                    if (conn != null) {
                        new PrintReport().showReport(conn);
                    }
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            });

            VBox vboxObj = new VBox(10);
            vboxObj.setPadding(new Insets(20, 20, 20, 20));
            vboxObj.getChildren().addAll(btn1);
            scene = new Scene(vboxObj, 300, 250);
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            AlertHelper.showAlertException(Alert.AlertType.ERROR, window, "Class " + getClass().getSimpleName(), "Exception", e.getMessage(), e);
//            System.err.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
