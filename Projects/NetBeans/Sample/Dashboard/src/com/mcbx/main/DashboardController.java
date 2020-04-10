package com.mcbx.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DashboardController implements Initializable {


	public String x="";

    @FXML
    private BorderPane borderpane;
    @FXML
    private HBox topDragable;

    @FXML
    void CLEAR(MouseEvent event) {
        borderpane.setCenter(null);
    }

    @FXML
    void UI1(MouseEvent event) {
        loadUI("ui1");
    }

    @FXML
    void UI2(MouseEvent event) {
        loadUI("ui2");

    }

    @FXML
    void UI3(MouseEvent event) {
        loadUI("ui3");

    }

    @FXML
    void UI4(MouseEvent event) {
        loadUI("ui4");

    }

    @FXML
    void UI5(MouseEvent event) {
        loadUI("ui5");

    }

    private void loadUI(String fxml) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxml + ".fxml"));

        } catch (IOException ex) {
            System.err.println("-------------------------------------------- " + ex.getMessage());
        }
        borderpane.setCenter(root);
    }


    @Override
    public void initialize(URL location, ResourceBundle rb) {

    }

}
