/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package gridpane;



import javafx.application.Application;
import javafx.geometry.Insets; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 *
 * @author Administrator
 */
public class Main extends Application {

    Stage window;
    
    public static void main(String[] args){
        launch(args);
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title");
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        // Name label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);
        
        // Name input
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 1, 0);
        
        // Password label
        Label passLabel = new Label("Passowrd:");
        GridPane.setConstraints(passLabel, 0, 1);
        
        // Password Input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);
        
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);
        
        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton);
        
        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);        
        window.show();
    }
    
    
    
}
