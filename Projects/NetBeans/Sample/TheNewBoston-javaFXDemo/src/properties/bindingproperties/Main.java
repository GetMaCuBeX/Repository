/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties.bindingproperties;

import properties.binding.*;
import properties.*;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class Main extends Application {

    Stage window;

    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TITLE PROPERTIES");
// =============================================================================

        // Input and labels
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("Welcome to the site");
        Label secondLabel = new Label();

        button = new Button("Submit");
        button.setOnAction(e -> {
        });

// =============================================================================
        HBox bottomeText = new HBox(firstLabel, secondLabel);
        bottomeText.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10, userInput, bottomeText);
        vBox.setAlignment(Pos.CENTER);

        // BIND THE LABEL
        secondLabel.textProperty().bind(userInput.textProperty());

        Scene scene = new Scene(vBox, 300, 250);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
