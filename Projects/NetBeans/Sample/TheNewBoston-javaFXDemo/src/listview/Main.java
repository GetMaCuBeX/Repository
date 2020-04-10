/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listview;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Restaurant");
// =============================================================================
        // ListView
        listView = new ListView<>();
        listView.getItems().addAll("Iron Man","Titanic","Contact","Surrogates");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        
        
        // Button
        button = new Button("Button Click");
        button.setOnAction(e -> { 
            buttonClicked();
//            System.out.println(nameInput.getText());
        });

// =============================================================================
        // LAYOUT 
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView, button);
// =============================================================================
        // SCENE
        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private void buttonClicked() {
        String message="";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();
        
        for(String m: movies){
            message += m +"\n";
        }
        
        System.out.println(message);
    }

  
}
