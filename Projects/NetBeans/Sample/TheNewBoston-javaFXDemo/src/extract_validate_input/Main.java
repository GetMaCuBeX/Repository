/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extract_validate_input;

import gridpane.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class Main extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title");
// =============================================================================
        // TextField
        TextField nameInput = new TextField("Bucky");

        button = new Button("Click Me");
        button.setOnAction(e -> {
            boolean result = isInt(nameInput, nameInput.getText());
            if (result) {
            }
//            System.out.println(nameInput.getText());
        });

// =============================================================================
        // LAYOUT 
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(nameInput, button);
// =============================================================================
        // SCENE
        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private boolean isInt(TextField nameInput, String text) {
        try {
            int age = Integer.parseInt(text);
            System.out.println("User is: " + age);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: "+ text + " is not a number");
            return false;
        }
    }

}
