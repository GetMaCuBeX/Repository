/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.database;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
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
import net.sf.jasperreports.swing.JRViewer;

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
            JasperPrint dataReports = JasperFillManager.fillReport(jasperReportObj, jrxmlParameters, serverConnection);
//------------------------------------------------------------------------------ EXPORT AUTOMATIC TO PDF USE v5.0.0 - DEPRECATED VERSION
//            JasperPrint print = JasperFillManager.fillReport(jasperReportObj, jrxmlParameters, serverConnection);
//
//            // Create a PDF exporter
//            JRExporter exporter = new JRPdfExporter();
//
//            // Configure the exporter (set output file name and print object)
//            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "idmembers.pdf");
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//            // Export the PDF file
//            exporter.exportReport(); 
//------------------------------------------------------------------------------ DISPLAY REPORT IN THIS FRAME
            JFrame newFrame = new JFrame(); 

            JRViewer displayReports = new JRViewer(dataReports);
            displayReports.setOpaque(true);
            displayReports.setVisible(true);
            newFrame.add(displayReports);
            newFrame.setSize(700, 500);
            newFrame.setVisible(true);
            System.out.print("Done!");
        } catch (HeadlessException | JRException e) {
            System.err.println(e.getMessage()+"...");
        }
    }
//------------------------------------------------------------------------------ OTHER SOURCE

}
