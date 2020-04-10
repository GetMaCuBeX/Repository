/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeview;

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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TreeView");
// =============================================================================
        // TreeView
        TreeItem<String> root, bucky, megan;

        // Root branch
        root = new TreeItem<>();
        root.setExpanded(true);

        // Bucky branch
        bucky = makeBranch("Bucky", root);
        makeBranch("thenewboston", bucky);
        makeBranch("Youtube", bucky);
        makeBranch("chickes", bucky);

        // Megan
        megan = makeBranch("Megan", root);
        makeBranch("Glitter", megan);
        makeBranch("Makeup", megan);

        // Create Tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue != null) {
                        System.out.println(newValue.getValue());
                    }
                });

        // Button
        button = new Button("Button Click");
        button.setOnAction(e -> {
//            System.out.println(nameInput.getText());
        });

// =============================================================================
        // LAYOUT 
        StackPane layout = new StackPane();
        layout.getChildren().addAll(tree);
// =============================================================================
        // SCENE
        Scene scene1 = new Scene(layout, 300, 200);
        window.setScene(scene1);
        window.show();
    }

    // Create branches
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);

        parent.getChildren().add(item);
        return item;
    }

}
