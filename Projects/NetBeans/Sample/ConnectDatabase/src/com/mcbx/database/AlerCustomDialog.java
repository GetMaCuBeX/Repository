/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.database;

import java.sql.Connection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlerCustomDialog extends Application {

    Stage window;
    Button btn;
    Button btnShowReport;
    Connection conn;
    private final String STYLES_DIRECTORY = System.getProperty("user.dir") + "/styles/alertdisplay/";
    private final String STYLES = STYLES_DIRECTORY + "alert.css";

    @Override
    public void start(Stage primaryStage) {
        try {
            String newStyle = STYLES.replace("\\", "/");

            Scene scene;
            StackPane stackPaneObj = new StackPane();
            VBox vboxObj = new VBox();
            HBox hboxObj = new HBox();

            Button btn1 = new Button("Button 1");
            Button btn2 = new Button("Button 2");
            Button btn3 = new Button("Button 3");

            setOnActionEvent(btn1, primaryStage);

            hboxObj.getChildren().addAll(btn1, btn2, btn3);
            //hboxObj.setStyle("-fx-padding: 5px 5px 5px 5px;");
            hboxObj.setPadding(new Insets(10, 10, 10, 10));
            hboxObj.setSpacing(10);

            stackPaneObj.getChildren().addAll(hboxObj);
            scene = new Scene(stackPaneObj, 300, 250);
            scene.getStylesheets().clear();
            //scene.getStylesheets().add(newStyle);
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setOnCloseRequest((event)-> {
                System.exit(0);
            });

        } catch (Exception e) {
            AlertHelper.showAlertException(AlertType.ERROR, window, "Class " + getClass().getSimpleName(), "Exception", e.getMessage(), e);
//            System.err.println(e.getMessage());
//            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void setOnActionEvent(Button btn, Stage window) {
        try {
            btn.setOnAction((event) -> {
//------------------------------------------------------------------------------                 
//------------------------------------------------------------------------------                 
//------------------------------------------------------------------------------              
//------------------------------------------------------------------------------              
//------------------------------------------------------------------------------              
//------------------------------------------------------------------------------              
//------------------------------------------------------------------------------              
//------------------------------------------------------------------------------              
//------------------------------------------------------------------------------ 
//------------------------------------------------------------------------------ DISPLAY CHOICE DIALOG
//                List<String> choicesList = new ArrayList<>();
//                choicesList.add("a");
//                choicesList.add("b");
//                choicesList.add("c");
//                String result = AlertHelper.showChoiceDialog(window, "Choice Dialog Box", "Select For Reporting ", "Select Character: ", choicesList,"a");
//                System.out.println(result); 
//                if (result != null) {
//                    switch (result) {
//                        case "":
//                            break;
//                        default:
//                            break;
//                    }
//                }
//------------------------------------------------------------------------------ DISPALY EXCEPTION DIALOG
//  AlertHelper.showAlertException(AlertType.ERROR, window, "Class " + getClass().getSimpleName(), "Exception", e.getMessage(), e);

//------------------------------------------------------------------------------ DISPLAY INPUT DIALOG
//                String result = AlertHelper.showInputDialog(window, "Title", "Report ", "Enter ID: ", "");
//                System.out.println(result);
//                if (result != null) {
//                    switch (result) {
//                        case "":
//                            break;
//                        default:
//                            break;
//                    }
//                }

//------------------------------------------------------------------------------ DISPLAY NOTIFICATION DIALOG
//            ButtonType result = AlertHelper.showAlert(AlertType.CONFIRMATION, window, "CONFIRMATION", null, "Message");
//            System.out.println("BUTTON: " + result.getText());
//            switch (result.getText()) {
//                case "OK":
//                    break;
//                case "Cancel":
//                    break;
//                default:
//                    break;
//            }
//            AlertHelper.showAlert(AlertType.INFORMATION, window, "INFORMATION", null, "You pressed: " + result.getText());
//            AlertHelper.showAlert(AlertType.ERROR, window, "Error", null, "Message");
//            AlertHelper.showAlert(AlertType.WARNING, window, "WARNING", null, "Message");
//            AlertHelper.showAlert(AlertType.INFORMATION, window, "INFORMATION", null, "Message");
//------------------------------------------------------------------------------
            });
        } catch (Exception e) {
            AlertHelper.showAlertException(AlertType.ERROR, window, "Class " + getClass().getSimpleName(), "Exception", e.getMessage(), e);
        }

    }

}
