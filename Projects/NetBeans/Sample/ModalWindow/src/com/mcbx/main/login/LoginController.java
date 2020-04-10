/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.main.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable {

//    Stage window;
    @FXML
    public Button login;
    public Button cancelLogin;
    public TextField tf;
    public PasswordField pf;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            tf.setOnKeyPressed((KeyEvent t) -> {
                KeyCode key = t.getCode();
                if (key == KeyCode.ESCAPE) {
                    tf.setText("");
                }
            });
            pf.setOnKeyPressed((KeyEvent t) -> {
                KeyCode key = t.getCode();
                if (key == KeyCode.ESCAPE) {
                    pf.setText("");
                }
            });
            
            setFireKey(login);
            setFireKey(cancelLogin);

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    @FXML
    public void login() {
        try {
//            KeyCode key = keyEvent.getCode();
//            if (key == KeyCode.ENTER) {
//                System.out.println("LOGIN...");
//            }

            System.out.println("LOGIN...");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    public void cancelLogin(ActionEvent actionEvent) {
        try {
            System.out.println("CANCEL LOGIN...");

            // Get the source who call this method
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    private void setFireKey(Button btn) {
        btn.setOnKeyPressed((KeyEvent t) -> {
            KeyCode key = t.getCode();
            if (key == KeyCode.ENTER) {
                btn.fire();
            }
        });
    }

}
