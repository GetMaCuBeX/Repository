/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combobox;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Restaurant");
// =============================================================================
        // ComboBox
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Good Will Hunting",
                "St. Vincent",
                "Blackhat",
                "St. Vincents",
                "Blackhast",
                "St. Vincents",
                "Blackhats"
        );
        comboBox.setPromptText("What is your favorite movie?");
        comboBox.setOnAction(e -> {
            System.out.println("User selected: " + comboBox.getValue());
        });
        comboBox.setVisibleRowCount(4);
        comboBox.setEditable(true);

        // Button
        button = new Button("Order Now");
        button.setOnAction(e -> {
            printMovie();
//            System.out.println(nameInput.getText());
        });

// =============================================================================
        // LAYOUT 
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, button);
// =============================================================================
        // SCENE
        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private void printMovie() {
        System.out.println(comboBox.getValue());
    }

}
