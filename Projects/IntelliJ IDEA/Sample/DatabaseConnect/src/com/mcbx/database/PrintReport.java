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
import javax.swing.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class PrintReport extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final String REPORTS_DIRECTORY = System.getProperty("user.dir") + "/reports/booksreservation/";

    public void showReport(Connection serverConnection) throws JRException, ClassNotFoundException, SQLException {


        try {
            String jrxmlFile = REPORTS_DIRECTORY + "membersInformation.jrxml";

            // First, compile jrxml file.
            JasperReport jasperReportObj = JasperCompileManager.compileReport(jrxmlFile);
            // Fields for report
            HashMap<String, Object> jrxmlParameters = new HashMap<>();
            jrxmlParameters.put("idmembers", 1);

            ArrayList<HashMap<String, Object>> list = new ArrayList<>();
            list.add(jrxmlParameters);

            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(list);
            /*JasperPrint print = JasperFillManager.fillReport(jasperReportObj, null, serverConnection);*/
            JasperPrint dataReports = JasperFillManager.fillReport(jasperReportObj, jrxmlParameters, serverConnection);

            JRViewer displayReports = new JRViewer(dataReports);
            displayReports.setOpaque(true);
            displayReports.setVisible(true);
            this.add(displayReports);
            this.setSize(700, 500);
            this.setVisible(true);
            System.out.print("Done!");

        } catch (JRException e) {
            System.err.println(e.getMessage());
        }
    }

}
