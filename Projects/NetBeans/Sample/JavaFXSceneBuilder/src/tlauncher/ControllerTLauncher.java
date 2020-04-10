/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tlauncher;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ControllerTLauncher implements Initializable {

    @FXML
//    public TextField username;
//    public PasswordField password;
//    public HBox hBox;
    public Button button1;
    public Button btn1, btn2;
    public Label label1;
    public TextArea ta1, ta2;
    public BorderPane bp1;
    public MenuItem mihelp;
    public ComboBox cbbox;
    public TextArea cbboxtarea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {


            // =================================================================
//            Image imageOk = new Image(getClass().getResourceAsStream("images/1.png"));
//            Image helpIcon = new Image(getClass().getResourceAsStream("images/2.png"));
//            ImageView helpView = new ImageView(helpIcon);
//            helpView.setFitWidth(15);
//            helpView.setFitHeight(15);
//            button1.setGraphic(new ImageView(imageOk));
//            label1.setGraphic(new ImageView(imageOk));
//            mihelp.setGraphic(helpView);


            ta1.setOnKeyReleased(event -> {
//            ta1.setOnKeyPressed(event -> {
                ta2.setText("You pressed: " + event.getCode());
                switch (event.getCode()) {
                    case ENTER:
                        break;
                    default:
                        break;
                }
            });

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    @FXML
    public void onMouseClicked() {
        try {
            System.out.println("MOUSE Click");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void onMouseEntered() {
        try {
            System.out.println("MOUSE ENTERED");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void onMouseExit() {
        try {
            System.out.println("MOUSE EXIT");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void btn1Clicked() {
        try {
            ta2.setText("You clicked: btn1");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void btn2Clicked() {
        try {
            ta2.setText("You clicked: btn2");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void help() {
        try {
            ta2.setText("You clicked: Help Menu");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void handleLabel(MouseEvent actionEvent) {
        try {
            Label labels = (Label) actionEvent.getSource();
            String s = labels.getText();

            switch (s) {
                case "How To Play":
                    ta2.setText("You clicked:\n" + s);
                    break;
                case "Install Skin":
                    ta2.setText("You clicked:\n" + s);
                    break;
                case "Animate Capes":
                    ta2.setText("You clicked:\n" + s);
                    break;
                default:
                    ta2.setText("You clicked:\n" + "None on the CASE LIST");
                    break;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
