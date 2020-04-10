package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application implements EventHandler<ActionEvent> {

    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {

        button = new Button();
        button.setText("CLICK ME");
        button.setOnAction(this);

        primaryStage.setTitle("Title of the WINDOW");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button) {
            System.out.println("oooo i love it when u touch me");
        }
    }

}
