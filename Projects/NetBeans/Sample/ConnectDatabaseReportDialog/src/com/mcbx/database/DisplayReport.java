package com.mcbx.database;

import database.Database;
import java.sql.Connection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class DisplayReport extends Application {

    Stage window;
    Scene scene;
    Button btn1;
    Button btn2;
    Button btnShowReport;
    Connection conn;

    @Override
    public void start(Stage primaryStage) {
        try {
            window = primaryStage;
            window.setTitle("Jasper Report Tutorial");
            btn1 = new Button("Show Report");
            btn2 = new Button("PRINT OTHER Report");

            btn1.setOnAction(e -> {
                try {
                    conn = Database.getConnectionMySQL(Database.BOOKS_RESERVATION, window);
                    if (conn != null) {
                        new PrintReport().showReport(conn);
                    }
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            });

            btn2.setOnAction((e) -> {
//                printReportTo();
            });

            VBox vboxObj = new VBox(10);
            vboxObj.setPadding(new Insets(20, 20, 20, 20));
            vboxObj.getChildren().addAll(btn1,btn2);
            scene = new Scene(vboxObj, 300, 250);
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            AlertHelper.showAlertException(Alert.AlertType.ERROR, window, "Class " + getClass().getSimpleName(), "Exception", e.getMessage(), e);
//            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

//    private void printReportTo() {
//        String fileName = "test.jasper";
//        String outFileName = "test.pdf";
//        HashMap hm = new HashMap();
//        try {
//            // Fill the report using an empty data source
//            JasperPrint print = JasperFillManager.fillReport(fileName, hm, new JREmptyDataSource());
//
//            // Create a PDF exporter
//            JRExporter exporter = new JRPdfExporter();
//
//            // Configure the exporter (set output file name and print object)
//            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//
//            // Export the PDF file
//            exporter.exportReport();
//
//        } catch (JRException e) {
//            e.printStackTrace();
//            System.exit(1);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.exit(1);
//        }
//    }
}
