package lambda_expression;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class LambdaExpression extends Application {

    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {

        button = new Button();
        button.setText("CLICK ME");
        // Using lambda expression.
        button.setOnAction(e -> {
            System.out.println("IM ANONYMOUS INNER CLASS");
            System.out.println("IM ANONYMOUS INNER CLASS 2");
        });

//        button.setOnAction((ActionEvent event) -> {
//            System.out.println("IM ANONYMOUS INNER CLASS");
//        });
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
