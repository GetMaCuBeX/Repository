package embedding_layouts;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {

    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("SCENE 1");
//        window.setOnCloseRequest(e -> {
//            e.consume(); // consume the event
//            closeProgram();
//        });
// =====================================================
        HBox topMenu = new HBox();
        
        Button buttonaA = new Button("File");
        Button buttonaB = new Button("Edit");
        Button buttonaC = new Button("View");
        topMenu.getChildren().addAll(buttonaA,buttonaB,buttonaC);
        
        
        VBox leftMenu = new VBox();
        
        Button buttonaD = new Button("D");
        Button buttonaE = new Button("E");
        Button buttonaF = new Button("F");
        leftMenu.getChildren().addAll(buttonaD,buttonaE,buttonaF);
        
// ------------------------------------------------------        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);


// =====================================================
        Scene scene = new Scene(borderPane, 300, 250);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
