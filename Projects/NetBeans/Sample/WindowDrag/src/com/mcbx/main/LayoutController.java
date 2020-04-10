/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LayoutController implements Initializable {

    @FXML
    BorderPane borderPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    Stage stageWindow;
    double x, y;

// ============================================================================= TITLE BAR DRAGGING
    @FXML
    public void dragged(MouseEvent event) {
        stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageWindow.setX(event.getScreenX() - x);
        stageWindow.setY(event.getScreenY() - y);
    }

    @FXML
    public void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

// ============================================================================= TITLE BAR 
    @FXML
    public void draggedDoubleClick(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        if (event.getClickCount() == 2) {
            if (stage.isFullScreen()) {
                stage.setFullScreen(false);
            } else {
                stage.setFullScreen(true);
            }
        }
    }

    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void maximize(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreenExitHint("");
//        Stage.setFullScreenExitKeyCombination(KeyCombination);
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
        } else {
            stage.setFullScreen(true);
        }
        
    }

    @FXML
    public void minimize(MouseEvent event) {
        Stage stage = null;
        if (event.getClickCount() == 1) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if (stage.isIconified()) {
                stage.setIconified(false);
            } else {
                stage.setIconified(true);
            }
        }
    }

}
