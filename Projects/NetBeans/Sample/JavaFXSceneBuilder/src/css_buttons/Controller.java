/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package css_buttons;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Administrator
 */
public class Controller implements Initializable {

    @FXML
    public TextField username;
    public PasswordField password;
    public HBox hBox;
    public Button buttonLogin;

    @FXML
    public void logInputButtonClick() {
        try {
            System.out.println("USER LOGIN");
            System.out.println("Username: " + username.getText());
            System.out.println("Password: " + password.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        hBox.setVisible(false);
        try {

//A button with the specified text caption and icon.
Image imageOk = new Image(getClass().getResourceAsStream("resources/images/Settings2.png"));
 //A button with the specified text caption and icon.
//Image imageOk = new Image(getClass().getResourceAsStream("Settings2.png"));
            
            
            buttonLogin.setGraphic(new ImageView(imageOk));
            

        } catch ( Exception e) {

        }
    }

}
