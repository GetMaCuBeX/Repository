package communicating_windows;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application {

    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {

        button = new Button();
        button.setText("CLICK ME");
        button.setOnAction(e -> {
            boolean result = ConfirmBox.display("TITLE OF THE WINDOW", "Click choice");
            System.out.println(result);
        });

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
