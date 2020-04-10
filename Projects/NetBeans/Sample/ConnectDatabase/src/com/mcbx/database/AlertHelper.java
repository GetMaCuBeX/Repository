package com.mcbx.database;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Window;

public class AlertHelper {

    // Customize AlerBox
    public static ButtonType showAlert(Alert.AlertType alertType, Window owner, String title, String headerText, String message) {
        Alert alert = new Alert(alertType);
        //
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(message);
        alert.initOwner(owner);
        //alert.show();        
        Optional<ButtonType> result = alert.showAndWait();
        return result.get();
    }

    public static ButtonType showAlertException(Alert.AlertType alertType, Window owner, String title, String headerText, String message, Exception ex) {
        Alert alert = new Alert(alertType);
        //
        alert.initOwner(owner);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(message);
//         Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();
        //
        Label label = new Label("The exception stacktrace was:");
        TextArea textArea = new TextArea(exceptionText);
        textArea.setStyle("-fx-text-fill: red;");
        //-fx-font-weight
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        //
        //// Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        Optional<ButtonType> result = alert.showAndWait();
        return result.get();
    }
    public static String showInputDialog(Window window, String title, String headerText, String contentText, String defaultValue) {
        try {
            TextInputDialog dialog = new TextInputDialog(defaultValue);
             dialog.setTitle(title);
            dialog.setHeaderText(headerText);
            dialog.setContentText(contentText);

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                return result.get();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public static String showChoiceDialog(Window window, String title, String headerText, String contentText, List choicesList, String defaultSelection) {
        try {
//            List<String> choicesList = new ArrayList<>();
//            choices.add("a");
//            choices.add("b");
//            choices.add("c");

            ChoiceDialog<String> dialog = new ChoiceDialog<>(defaultSelection, choicesList);
            dialog.setTitle(title);
            dialog.setHeaderText(headerText);
            dialog.setContentText(contentText);

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                return result.get();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
}
