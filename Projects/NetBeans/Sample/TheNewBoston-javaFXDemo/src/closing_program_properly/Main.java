package closing_program_properly;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application {

    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("SCENE 1");

        window.setOnCloseRequest(e -> {
            e.consume(); // consume the event
            closeProgram();
        });

        button = new Button();
        button.setText("Close Program");
        button.setOnAction(e -> {
            closeProgram();
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void closeProgram() {
//        System.out.println("File is saved!");
//        window.close();
// =============================================
        boolean answer = ConfirmBox.display("TITLE OF THE WINDOW", "Click choice");
//        System.out.println(answer);
        if (answer == true) {
            window.close();
        } else {

        }
    }

}
