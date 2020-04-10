/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbox;

import gridpane.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
        window.setTitle("Restaurant");
// =============================================================================
        // CheckBoxes
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        box2.setSelected(true);
        
        // Button
        button = new Button("Order Now");
        button.setOnAction(e -> {
            handleOptions(box1,box2);
//            System.out.println(nameInput.getText());
        });

// =============================================================================
        // LAYOUT 
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(box1,box2, button);
// =============================================================================
        // SCENE
        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2) {
        String message="Users order:\n";
        if(box1.isSelected()){
            message += "Bacon\n";
        }
        
        if(box2.isSelected()){
            message += "Tuna\n";
        }
        
        System.out.println(message);
    }

}
