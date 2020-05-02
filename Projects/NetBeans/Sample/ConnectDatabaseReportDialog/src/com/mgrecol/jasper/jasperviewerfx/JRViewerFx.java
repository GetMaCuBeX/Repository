package com.mgrecol.jasper.jasperviewerfx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperPrint;

public class JRViewerFx extends Application {

    private JasperPrint jasperPrint;
    private JRViewerFxMode printMode;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(JRViewerFx.class.getResource("FRViewerFx.fxml"));
            Parent page = loader.load();
            Object o = loader.getController();
            if (o instanceof JRViewerFxController) {
                JRViewerFxController jrViewerFxController = (JRViewerFxController) o;
                jrViewerFxController.setJasperPrint(jasperPrint);
                jrViewerFxController.show();
            }
            primaryStage.setScene(new Scene(page));
            primaryStage.setTitle("Jasper Viewer for JavaFx");
            primaryStage.show();
        } catch (IOException ex) {
            System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
            System.err.println(ex.fillInStackTrace());
        }
    }

    public JRViewerFx(JasperPrint jasperPrint, JRViewerFxMode printMode, Stage primaryStage) {
        this.jasperPrint = jasperPrint;
        this.printMode = printMode;
        try {
            start(primaryStage);
        } catch (Exception ex) {
            System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
            System.err.println(ex.fillInStackTrace());
        }
    }

    public JRViewerFx(Stage primaryStage) {
        try {
            start(primaryStage);
        } catch (Exception ex) {
            System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
            System.err.println(ex.fillInStackTrace());
        }
    }

}
