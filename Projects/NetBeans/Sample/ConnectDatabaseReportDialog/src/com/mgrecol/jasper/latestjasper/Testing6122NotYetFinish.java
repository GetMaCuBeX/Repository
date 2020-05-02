package com.mgrecol.jasper.latestjasper;

import database.Database;
import database.MySQL;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter; 
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOdsReportConfiguration;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

public class Testing6122NotYetFinish extends Application {

    Connection conn;
    MySQL mysqlObj = new MySQL("localhost", "3306", "booksreservation", "root", "");

    @Override
    public void start(Stage stage) {

        try {

            long start = System.currentTimeMillis();
            // DESKTOP PATH /*CHECK IF OUTPUT DIRECTORY EXIST IN THE LOCATION*//*THROWS ERROR WHEN FOLDER IS NOT EXIST OR LOCATED*/
            String desktopPath = System.getProperty("user.home") + "/Desktop/";

            // LOCATE REPORT
            String reportPath = System.getProperty("user.dir") + "/reports/";
            String reportName = "reportthis.jrxml";
            //String reportFormat = "pdf";
            String reportFormat = "odt";
            String location = reportPath + reportName;

            // DATABASE
            Connection databaseConnection = Database.getConnectionMySQL(Database.BOOKS_RESERVATION);

            // PARAMETERS
            int param1 = 2;
            HashMap parameters = new HashMap();
            parameters.put("idmembers", param1);

            // DESTINATION
            String pathDestination = desktopPath;
            String outputFile = generateReportName(pathDestination, reportName, reportFormat, param1);

            // COMPILE
            JasperReport compiledReportDesignedObject = JasperCompileManager.compileReport(location);

            // PRINT
            JasperPrint print = JasperFillManager.fillReport(compiledReportDesignedObject, parameters, databaseConnection);

            // EXPORT
            saveReport(print, reportFormat, outputFile);
            System.out.println("Filling time : " + (System.currentTimeMillis() - start) + "ms");

            // OPEN FILE @CMD
            String savePath = outputFile.replace("\\", "/");
            /*THIS WONT EXECUTE IF THE OUTPUT FILENAME HAVE SPACE CHARACTER*/
            //Runtime.getRuntime().exec("cmd /c start  " + savePath + "");

            // OPEN EXPLORER
            try {
                Desktop desktop = Desktop.getDesktop();
                File dirToOpen = null;
                dirToOpen = new File(desktopPath + "5");
                desktop.open(dirToOpen);
            } catch (IllegalArgumentException ex) {
                System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
                System.err.println(ex.fillInStackTrace());
            }
            System.exit(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage() + "...");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private enum Format {
        pdf,
        html,
        xml,
        xls,
        csv,
        rtf,
        ods,
        pptx,
        docx,
        odt
    };

    // STRING GENERATOR
    private static String generateReportName(String reportDirectory, String reportName, String reportFormat, int parameter) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd.HH-mm-ss");
        //return reportDirectory + reportName + sdf.format(new Date()) + "." + reportFormat; 
        String output = String.format("%s%s-[%s].%s", reportDirectory, sdf.format(new Date()), parameter, reportFormat);
        return output;

    }

    // REPROT TYPE
    private static String saveReport(JasperPrint jasperPrint, String format, String destFileName) throws JRException, Exception {
        String reportName = null;
        switch (Format.valueOf(format)) {
            case pdf:
                JasperExportManager.exportReportToPdfFile(jasperPrint, destFileName);
                reportName = destFileName;
                break;
            case html:
                JasperExportManager.exportReportToHtmlFile(jasperPrint, destFileName);
                reportName = destFileName;
                break;
            case xml:
                JasperExportManager.exportReportToXmlFile(jasperPrint, destFileName, true);
                reportName = destFileName;
                break;
            case csv:
                JRCsvExporter csvExporter = new JRCsvExporter();
                csvExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                csvExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFileName);
                csvExporter.exportReport();
                reportName = destFileName;
                break;
            case xls:
                JRXlsxExporter xlsxExporter = new JRXlsxExporter();
                xlsxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFileName));
                SimpleXlsxReportConfiguration configuration2 = new SimpleXlsxReportConfiguration();
                configuration2.setOnePagePerSheet(false);
                xlsxExporter.setConfiguration(configuration2);
                xlsxExporter.exportReport();
                reportName = destFileName;
                break;
            case ods:
                JROdsExporter odsExporter = new JROdsExporter();
                odsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                odsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFileName));
                SimpleOdsReportConfiguration odsReportConfiguration = new SimpleOdsReportConfiguration();
                odsReportConfiguration.setOnePagePerSheet(true);
                odsExporter.setConfiguration(odsReportConfiguration);
                odsExporter.exportReport();
                reportName = destFileName;
                break;
            case odt:
                JROdtExporter odtExporter = new JROdtExporter();
                odtExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                odtExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFileName));
                odtExporter.exportReport();
                reportName = destFileName;
                break;
            case pptx:
                JRPptxExporter pptxExporter = new JRPptxExporter();
                pptxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                pptxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFileName));
                pptxExporter.exportReport();
                reportName = destFileName;
                break;
            case docx:
                JRDocxExporter docxExporter = new JRDocxExporter();
                docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFileName));
                docxExporter.exportReport();
                reportName = destFileName;
                break;
            case rtf:
                JRRtfExporter rtfExporter = new JRRtfExporter();
                rtfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                rtfExporter.setExporterOutput(new SimpleWriterExporterOutput(destFileName));
                rtfExporter.exportReport();
                break;
            default:
                System.err.println("Error Running Report: Unknown Format: %s\", format");
        }
        return reportName;
    }
}
