/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties.binding;

import properties.*;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty(3);

        y.bind(x.multiply(10));
        System.out.println("x: "+x.getValue());
        System.out.println("y: "+y.getValue()+"\n");
        
        x.setValue(9);
        System.out.println("x: "+x.getValue());
        System.out.println("y: "+y.getValue()+"\n");

        button = new Button("Submit");
        button.setOnAction(e -> {
        });

// =============================================================================
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
