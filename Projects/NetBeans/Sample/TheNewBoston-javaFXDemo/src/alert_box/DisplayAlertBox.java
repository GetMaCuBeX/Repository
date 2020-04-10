package alert_box;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class DisplayAlertBox extends Application{

    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {

        button = new Button();
        button.setText("CLICK ME");
        button.setOnAction(e -> AlertBox.display("TITLE OF THE WINDOW","ALERT BOX IS AWESOME"));

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

}
