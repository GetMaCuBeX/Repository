package mcbx.jb.classes.mycollection;

import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class JIFrameJasperReportsViewer extends javax.swing.JInternalFrame {

    private BasicInternalFrameUI _BasicInternalFrameUI = (BasicInternalFrameUI) getUI();
    private JasperPrint jasperPrint;
    private JRViewer jasperViewer;
    private Container instanceContainer;

    public BasicInternalFrameUI getBasicInternalFrameUI() {
        return _BasicInternalFrameUI;
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }

    public void setJasperPrint(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    public JRViewer getJasperViewer() {
        return jasperViewer;
    }

    public void setJasperViewer(JRViewer jasperViewer) {
        this.jasperViewer = jasperViewer;
    }


    public Container getInstanceContainer() {
        return instanceContainer;
    }

    public void setInstanceContainer(Container instanceContainer) {
        this.instanceContainer = instanceContainer;
    }

    

    public JIFrameJasperReportsViewer() {
    }

    /* JasperReports with no parameter */
    public JIFrameJasperReportsViewer(String jasperFileDirectory, Connection conn) {
        try {
            jasperPrint = JasperFillManager.fillReport(jasperFileDirectory, null, conn);
            jasperViewer = new JRViewer(jasperPrint);

            instanceContainer = getContentPane();
            instanceContainer.setLayout(new BorderLayout());
            instanceContainer.add(jasperViewer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* JasperReports with parameter */
    public JIFrameJasperReportsViewer(String jasperFileDirectory, HashMap parameters, Connection conn) {
        try {
            jasperPrint = JasperFillManager.fillReport(jasperFileDirectory, parameters, conn);
            jasperViewer = new JRViewer(jasperPrint);

            instanceContainer = getContentPane();
            instanceContainer.setLayout(new BorderLayout());
            instanceContainer.add(jasperViewer);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public JIFrameJasperReportsViewer(String jasperFileDirectory, HashMap parameters, Connection conn, boolean isSetNorthPaneEqualToNull) {
        try {
            if (isSetNorthPaneEqualToNull == true) {
                _BasicInternalFrameUI.setNorthPane(null);
            }

            jasperPrint = JasperFillManager.fillReport(jasperFileDirectory, parameters, conn);
            jasperViewer = new JRViewer(jasperPrint);

            instanceContainer = getContentPane();
            instanceContainer.setLayout(new BorderLayout());
            instanceContainer.add(jasperViewer);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
