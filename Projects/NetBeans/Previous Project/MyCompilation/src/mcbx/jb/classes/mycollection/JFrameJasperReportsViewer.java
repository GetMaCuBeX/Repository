package mcbx.jb.classes.mycollection;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class JFrameJasperReportsViewer extends javax.swing.JFrame {

     public JFrameJasperReportsViewer() {
     }

     /* JasperReports with no parameter */
     public JFrameJasperReportsViewer(String jasperFile, Connection conn) {
          try {
               JasperPrint print = JasperFillManager.fillReport(jasperFile, null, conn);
               JRViewer viewer = new JRViewer(print);
               Container c = getContentPane();
               c.setLayout(new BorderLayout());
               c.add(viewer);
          } catch (Exception e) {
               System.out.println(e);
          }
     }

     /* JasperReports with parameter */
     public JFrameJasperReportsViewer(String jasperFile, HashMap parameter, Connection conn) {
          try {
               JasperPrint print = JasperFillManager.fillReport(jasperFile, parameter, conn);
               JRViewer viewer = new JRViewer(print);

               Container c = getContentPane();
               c.setLayout(new BorderLayout());
               c.add(viewer);

          } catch (Exception e) {
               System.out.println(e);
          }
     }
}
