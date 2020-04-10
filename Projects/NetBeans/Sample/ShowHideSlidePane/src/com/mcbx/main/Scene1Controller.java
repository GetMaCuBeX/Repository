package com.mcbx.main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Scene1Controller implements Initializable {

    @FXML
    AnchorPane anchorPane;

    @FXML
    public JFXDrawer drawer;
    @FXML
    public JFXButton drawerButton;
    @FXML
    public TextField tf;
    @FXML
    public JFXHamburger myHamburger;
    @FXML
    private VBox vBox;
    public Button botton;

    FXMLLoader fxmlloaderObj;

    public void showsidebar(MouseEvent event) {
//        System.out.println(event.getButton());
        switch (event.getButton()) {
            case PRIMARY:
                if (drawer.isOpened()) {
                    drawer.close();
                } else {
                    drawer.open();
                }
                break;
            default:
                break;
        }
    }

    @FXML
    void setText(ActionEvent event) {

        // Get access to the FXMLFILE Controller via FXMLLoader above.
        Scene2Controller secondController = fxmlloaderObj.getController();
        // Call the function from the other Controller.
        secondController.myFunction(tf.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            fxmlloaderObj = new FXMLLoader();
            fxmlloaderObj.setLocation(getClass().getResource("scene2.fxml"));

            vBox = fxmlloaderObj.load();
            drawer.setSidePane(vBox);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        anchorPane.setOnKeyPressed((event) -> {
//            System.out.println(event.getText());
            switch (event.getCode()) {
                case ESCAPE:
                    if (drawer.isOpened()) {
                        drawer.close();
                    }
                    break;
                default:
                    break;
            }
            System.out.println(event.getCode());
        });

//        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(myHamburger);
//
//        myHamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)
//                -> {
//            transition.setRate(transition.getRate() * -1);
//            transition.play();
//
//            if (drawer.isOpened()) {
//                drawer.close();
//            } else {
//                drawer.open();
//            }
//        }
//        );
    }

    public void setText(String text) {
        tf.setText(text);
    }

}
