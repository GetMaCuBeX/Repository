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
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
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
public class Radio_Menu_Item extends Application {
    
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
        // File Menu ===========================================================
        Menu fileMenu = new Menu("_File");
        
        // Menu Items
        MenuItem newFile = new MenuItem("New..");
        newFile.setOnAction(e -> System.out.println("Create a new file"));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        // Edit Menu ===========================================================
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        
        // Menu Items
        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> {
            System.out.println("Paste Menu");
        });
        editMenu.getItems().add(paste);
        paste.setDisable(true);

        // Help Menu ===========================================================
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
             if(showLines.isSelected())
                 System.out.println("Program will now display line numbers.");
              else
                 System.out.println("Hiding line numbers");             
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);
        
        
        // Difficulty RadioMenuItem ============================================
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();
        
        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");
        
        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);
        
        difficultyMenu.getItems().addAll(easy,medium,hard);
        
        
        
        
        
        
        
        // Main Menubar --------------------------------------------------------
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);

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
