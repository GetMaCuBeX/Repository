package com.mgrecol.jasper.jasperviewerfx;

import database.Database;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setResizable(true);
            // LOCATE REPORT        
            String location = System.getProperty("user.dir") + "/reports/reportthis.jrxml";

            // THREAD
            new Thread() {
                @Override
                public void run() {
                    try {
                        // I USE THIS TO CACHE THE PROCESS TO MINIMIZE THE NEXT COMPILATION - UP TO YOU
                        // COMPILE OTHER REPORT
                        long COMPILE_OTHER_REPORT = System.currentTimeMillis();
                        JasperReport report = JasperCompileManager.compileReport(System.getProperty("user.dir") + "/reports/membersInformation.jrxml");
                        System.out.println("Compiling Other Report: " + (System.currentTimeMillis() - COMPILE_OTHER_REPORT) + "ms");
                    } catch (JRException ex) {
                        System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
                        System.err.println(ex.fillInStackTrace());
                    }
                }
            }.start();

            // DATABASE
            long DATABASE = System.currentTimeMillis();
            Connection conn = Database.getConnectionMySQL(Database.BOOKS_RESERVATION);
            System.out.println("Connecting Server: " + (System.currentTimeMillis() - DATABASE) + "ms");

            // INPUT DIALOG
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Title");
            dialog.setHeaderText("Report");
            dialog.setContentText("Enter ID: ");
            String resultv = null;
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                resultv = result.get();
            }

            // PARAMETERS
            int param1 = Integer.parseInt(resultv);
            HashMap parameters = new HashMap();
            parameters.put("idmembers", param1);

            // COMPILE
            long COMPILE = System.currentTimeMillis();
            JasperReport report = JasperCompileManager.compileReport(location);
            System.out.println("Compiling: " + (System.currentTimeMillis() - COMPILE) + "ms");

            //PRINT
            long PRINT = System.currentTimeMillis();
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            System.out.println("Printing: " + (System.currentTimeMillis() - PRINT) + "ms");

            // FXML            
            long DISPLAY = System.currentTimeMillis();
            JRViewerFx viewer = new JRViewerFx(print, JRViewerFxMode.REPORT_VIEW, primaryStage);
//            viewer.start(primaryStage);
            System.out.println("Display: " + (System.currentTimeMillis() - DISPLAY) + "ms");

        } catch (Exception ex) {
            System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
            System.err.println(ex.fillInStackTrace());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
