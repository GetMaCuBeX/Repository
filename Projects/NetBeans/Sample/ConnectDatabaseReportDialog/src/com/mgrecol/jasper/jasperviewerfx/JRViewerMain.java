/**
 *
 */
package com.mgrecol.jasper.jasperviewerfx;

import java.util.HashMap;

import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class JRViewerMain extends Application {

    public static String[] prgArgs;

    public static void main(String[] args) {
        prgArgs = args;
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("reports/reportthis.jasper", new HashMap(), new JREmptyDataSource());
        } catch (JRException ex) {
            System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
            System.err.println(ex.fillInStackTrace());
        }
        JRViewerFx viewer = new JRViewerFx(jasperPrint, JRViewerFxMode.REPORT_VIEW, primaryStage);
        primaryStage.setResizable(false);
        viewer.start(primaryStage);
    }
}
