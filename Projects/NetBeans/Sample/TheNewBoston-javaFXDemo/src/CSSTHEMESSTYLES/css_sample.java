package CSSTHEMESSTYLES;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import gridpane.*;
import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class css_sample extends Application {

    Stage window;
    Scene scene;
    private static final String cssDirectory = System.getProperty("user.dir") + "/css/";
    private static final String styleCSS = cssDirectory + "stylesheet.css";

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title");

        
//A button with the specified text caption and icon.
Image imageOk = new Image(getClass().getResourceAsStream("Settings2.png"));
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Name label
        Label nameLabel = new Label("Username:");
        nameLabel.setStyle("-fx-text-fill:#FFFFFF;");
        nameLabel.setId("bold-label");
        GridPane.setConstraints(nameLabel, 0, 0);

        // Name input
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 1, 0);

        // Password label
        Label passLabel = new Label("Passowrd:");
        passLabel.setStyle("-fx-text-fill:#FFFFFF;");
        GridPane.setConstraints(passLabel, 0, 1);

        // Password Input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        // Login Button
        Button loginButton = new Button("Log In");
        loginButton.setStyle("-fx-background-radius: 50;");
        GridPane.setConstraints(loginButton, 1, 2);

        // SignUp Button
        Button signUpButton = new Button("Sign Up", new ImageView(imageOk));
        signUpButton.getStyleClass().add("button-blue");
        GridPane.setConstraints(signUpButton, 1, 3);

        
// =============================================================================        
        // LAYOUT    
//        String cssDirectoryReplace = styleCSS.replace("\\", "/");
//        String cssDirectoryReplace = styleCSS.replace("/", "\\");

        try {

            StackPane root = new StackPane();
            root.setStyle("-fx-background-color:#2A2A2A;-fx-font-size: 15; -fx-background-image: url(images/ROG_4.png);");
            root.getStylesheets().add("stylesheet.css");

            
            grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signUpButton);

            root.getChildren().addAll(grid);
            scene = new Scene(root, 300, 200);
            window.setScene(scene);
            window.show();

        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }

}
