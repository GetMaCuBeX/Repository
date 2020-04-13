package com.mcbx.database.jasperreport;

import com.mcbx.database.Database;
import com.mysql.jdbc.log.LogUtils;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.ReportContext;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.w3c.tidy.Report;

public class ExportReports {

    public static void main(String[] args) throws JRException, IOException, Exception {
        System.out.println("Hello Main");
        testReport();
    }

    private static void testReport() throws IOException, Exception {
        try {
            long start = System.currentTimeMillis();
            // DESKTOP PATH
            String desktopPath = System.getProperty("user.home") + "/Desktop/";
            // LOCATE REPORT       
            String reportPath = System.getProperty("user.dir") + "/reports/";
            String reportName = "reportthis.jrxml";
            String reportFormat = "pdf";
            String location = reportPath + reportName;

            // DESTINATION
            String pathDestination = desktopPath;
            String outputFile = generateReportName(pathDestination, reportName, reportFormat);

            // DATABASE
            Connection conn = Database.getConnectionMySQL(Database.BOOKS_RESERVATION);

            // PARAMETERS
            int param1 = 2;
            HashMap parameters = new HashMap();
            parameters.put("idmembers", param1);

            // COMPILE
            JasperReport report = JasperCompileManager.compileReport(location);

            // PRINT
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);

            // EXPORT 
            saveReport(print, reportFormat, outputFile);
            //JasperExportManager.exportReportToPdfFile(print, outputFile);
            //System.err.println("Filling time : " + (System.currentTimeMillis() - start) + "ms");

            // OPEN FILE @CMD
            String savePath = outputFile.replace("\\", "/");
            Runtime.getRuntime().exec("cmd /c start  " + savePath + "");
            //Runtime.getRuntime().exec("cmd /c start C:/2020-04-13-071949.pdf");

            // OPEN EXPLORER
            try {
                Desktop desktop = Desktop.getDesktop();
                File dirToOpen = null;
                dirToOpen = new File(desktopPath);
                desktop.open(dirToOpen);
            } catch (IllegalArgumentException e) {
                System.err.println("File Not Found " + e.getMessage());
            }
        } catch (JRException e) {
            System.err.println(e.getMessage());
        }

    }

    private enum Format {
        pdf,
        html,
        xml,
        xls,
        csv,
        rtf
    };

    // STRING GENERATOR
    private static String generateReportName(String reportDirectory, String reportName, String reportFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH-mm-ss");
        //return reportDirectory + reportName + sdf.format(new Date()) + "." + reportFormat;
        return reportDirectory + sdf.format(new Date()) + "." + reportFormat;
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
                JRCsvExporter exporter = new JRCsvExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFileName);
                exporter.exportReport();
                reportName = destFileName;
                break;
            default:
                System.err.println("Error Running Report: Unknown Format: %s\", format");
        }
        return reportName;
    }

}
