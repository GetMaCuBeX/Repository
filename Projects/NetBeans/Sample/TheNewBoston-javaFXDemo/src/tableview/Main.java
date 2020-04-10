/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview;

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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    TableView<Product> table;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TableView");
// =============================================================================
        // TableView
        
        // Name Column
        // <Product = Type of data, String = DataType of the data> (Name = header)
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        // (name = The attribute of the variable in the product class / User name property of object)
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        // Price Column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        // Quantity Column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        
        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);
        
        
        
        
        

        // Button
        button = new Button("Button Click");
        button.setOnAction(e -> {
//            System.out.println(nameInput.getText());
        });

// =============================================================================
        // LAYOUT 
        VBox vBox = new VBox();
//        vBox.setPadding(new Insets(20, 20, 20, 20));
        vBox.getChildren().addAll(table);
// =============================================================================
        // SCENE
//        Scene scene = new Scene(vBox, 300, 200);
        scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
    
    // Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop",859.00,20));
        products.add(new Product("Mouse",200.00,10));
        products.add(new Product("Toilet",500.00,15));
        products.add(new Product("DVD",100.00,5));
        products.add(new Product("Corn",2.00,846));
        
        return products;
    }

}
