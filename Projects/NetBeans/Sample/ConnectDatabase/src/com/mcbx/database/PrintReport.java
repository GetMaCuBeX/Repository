/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//------------------------------------------------------------------------------
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.fill.JRFillInterruptedException;   

public class PrintReport {

    private final String REPORTS_DIRECTORY = System.getProperty("user.dir") + "/reports/booksreservation/";

    public void showReport(Connection serverConnection) throws JRException, ClassNotFoundException, SQLException {

        try {
            String jrxmlFile = REPORTS_DIRECTORY + "membersInformation.jrxml";

             // First, compile jrxml file.
            JasperReport jasperReportObj = JasperCompileManager.compileReport(jrxmlFile);
            // Fields for report
            HashMap<String, Object> jrxmlParameters = new HashMap<>();
            jrxmlParameters.put("idmembers", 2);

            ArrayList<HashMap<String, Object>> list = new ArrayList<>();
            list.add(jrxmlParameters);
//------------------------------------------------------------------------------
//            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(list);
//            JasperPrint print = JasperFillManager.fillReport(jasperReport, null, con);
//            JasperPrint dataReports = JasperFillManager.fillReport(jasperReportObj, jrxmlParameters, serverConnection);
//------------------------------------------------------------------------------ EXPORT AUTOMATIC TO PDF USE v5.0.0 - DEPRECATED VERSION
            JasperPrint print = JasperFillManager.fillReport(jasperReportObj, jrxmlParameters, serverConnection);

            // Create a PDF exporter
            JRExporter exporter = new JRPdfExporter();

            // Configure the exporter (set output file name and print object)
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "idmembers.pdf");
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            // Export the PDF file
            exporter.exportReport();
//------------------------------------------------------------------------------ NEW VERSION v6.12.2 - NEW VERSION INCLUE v[ ]
            try {

//                long start = System.currentTimeMillis();

//		JRPdfExporter exporter = new JRPdfExporter();  

//		exporter.setExporterInput(new SimpleExporterInput("build/reports/BookReport.jrprint"));
//		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("build/reports/BookReport.pdf"));
//		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//		configuration.setCreatingBatchModeBookmarks(true);
//		exporter.setConfiguration(configuration);
//		
//		exporter.exportReport();
//		//JasperExportManager.exportReportToPdfFile("build/reports/BookReport.jrprint");
//		System.err.println("PDF creation time : " + (System.currentTimeMillis() - start));
// ----------------------------------------
//                long start = System.currentTimeMillis();
//		JRPdfExporter exporter = new JRPdfExporter();		
//		exporter.setExporterInput(new SimpleExporterInput(jrxmlFile));
//		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(REPORTS_DIRECTORY+"File.pdf"));
//		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//		configuration.setCreatingBatchModeBookmarks(true);
//		exporter.setConfiguration(configuration);
//		
//		exporter.exportReport();
//		//JasperExportManager.exportReportToPdfFile("build/reports/BookReport.jrprint");
//		System.err.println("PDF creation time : " + (System.currentTimeMillis() - start));
////
//                System.err.println("PDF creation time : " + (System.currentTimeMillis() - start));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

//------------------------------------------------------------------------------ DISPLAY REPORT IN THIS FRAME
// extends JFrame
//            JasperPrint dataReports = JasperFillManager.fillReport(jasperReportObj, jrxmlParameters, serverConnection);
//
//            JRViewer displayReports = new JRViewer(dataReports);
//            displayReports.setOpaque(true);
//            displayReports.setVisible(true);
//            this.add(displayReports);
//            this.setSize(700, 500);
//            this.setVisible(true);
//            System.out.print("Done!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
//------------------------------------------------------------------------------ OTHER SOURCE
 

}
