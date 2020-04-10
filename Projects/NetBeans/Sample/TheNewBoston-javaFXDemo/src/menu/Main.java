/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Menu");
// =============================================================================
        // File Menu
        Menu fileMenu = new Menu("file");

        // Menu Items
        fileMenu.getItems().add(new MenuItem("New Project..."));
        fileMenu.getItems().add(new MenuItem("New Module..."));
        fileMenu.getItems().add(new MenuItem("Import Project..."));
        fileMenu.getItems().add(new MenuItem("Export Project..."));

        // Main Menubar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);

        // Button
        button = new Button("Button Click");
        button.setOnAction(e -> {
//            System.out.println(nameInput.getText());
        });

// =============================================================================
        // LAYOUT
        layout = new BorderPane();
        layout.setTop(menuBar);

// =============================================================================
        // SCENE
        scene = new Scene(layout, 300, 200); 
        window.setScene(scene);
        window.show();
    }

}
