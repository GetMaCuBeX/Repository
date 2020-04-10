/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tlauncher;
 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

 
public class MainTlauncher extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLTLauncher.fxml"));
        primaryStage.setScene(new Scene(root, 1000,1000));
        primaryStage.show();
    }

 
    public static void main(String[] args) {
        launch(args);
    }
    
}
