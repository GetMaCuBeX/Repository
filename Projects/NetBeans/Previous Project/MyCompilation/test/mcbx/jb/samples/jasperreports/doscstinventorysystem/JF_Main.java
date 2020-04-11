package mcbx.jb.samples.jasperreports.doscstinventorysystem;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import mcbx.jb.classes.databaseconnection.MySQL;
import mcbx.jb.classes.mycollection.JFrameJasperReportsViewer;
import mcbx.jb.classes.mycollection.JIFrameJasperReportsViewer;

public class JF_Main extends javax.swing.JFrame {

     //
     private static MySQL db_doscstinventorysystem = new MySQL("localhost", "3306", "doscstinventorysystem", "root", "");
     private static String reportsDirectory = System.getProperty("user.dir") + "/reports/doscstinventorysystem/";
     //
     private JDateChooser dc_JFrame = new JDateChooser(null, null, null, new JSpinnerDateEditor());
     private JDateChooser dc_JIFrame = new JDateChooser(null, null, null, new JSpinnerDateEditor());

     public JF_Main() {
          initComponents();
          //
          java.util.Date date = new Date();
          date.getTime();
          setJDateChooser(dc_JFrame, "MMMM d, yyyy", date, jPanel3);
          setJDateChooser(dc_JIFrame, "MMMM d, yyyy", date, jPanel6);
          //
          jDialog1_PurchaseRequest_JFrame.setModal(false);
          jDialog1_PurchaseRequest_JFrame.setLocationRelativeTo(null);
          jDialog1_PurchaseRequest_JIFrame.setModal(false);
          jDialog1_PurchaseRequest_JIFrame.setLocationRelativeTo(null);
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jDialog1_PurchaseRequest_JFrame = new javax.swing.JDialog();
          jPanel1 = new javax.swing.JPanel();
          jPanel2 = new javax.swing.JPanel();
          jButton2 = new javax.swing.JButton();
          jButton1 = new javax.swing.JButton();
          jTextField1 = new javax.swing.JTextField();
          jLabel2 = new javax.swing.JLabel();
          jLabel1 = new javax.swing.JLabel();
          jPanel3 = new javax.swing.JPanel();
          jDialog1_PurchaseRequest_JIFrame = new javax.swing.JDialog();
          jPanel4 = new javax.swing.JPanel();
          jPanel5 = new javax.swing.JPanel();
          jButton3 = new javax.swing.JButton();
          jButton4 = new javax.swing.JButton();
          jTextField2 = new javax.swing.JTextField();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jPanel6 = new javax.swing.JPanel();
          jDesktopPane1 = new javax.swing.JDesktopPane();
          jMenuBar1 = new javax.swing.JMenuBar();
          jMenu1 = new javax.swing.JMenu();
          jMenu2 = new javax.swing.JMenu();
          jMenu3 = new javax.swing.JMenu();
          jMenu4 = new javax.swing.JMenu();
          jMenu6 = new javax.swing.JMenu();
          jMenuItem3 = new javax.swing.JMenuItem();
          jMenu5 = new javax.swing.JMenu();
          jMenu7 = new javax.swing.JMenu();
          jMenuItem2 = new javax.swing.JMenuItem();
          jMenu9 = new javax.swing.JMenu();
          jMenuItem5 = new javax.swing.JMenuItem();

          jDialog1_PurchaseRequest_JFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          jDialog1_PurchaseRequest_JFrame.setTitle("Purchase Request");
          jDialog1_PurchaseRequest_JFrame.setMinimumSize(new java.awt.Dimension(300, 170));

          jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          jButton2.setText("Ok");
          jButton2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
               }
          });

          jButton1.setText("Cancel");
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });

          jLabel2.setText("PR Date:");

          jLabel1.setText("Employee ID:");

          jPanel3.setLayout(new java.awt.BorderLayout());

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel2Layout.createSequentialGroup()
                              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jTextField1)))
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                              .addGap(0, 116, Short.MAX_VALUE)
                              .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jButton1)))
                    .addContainerGap())
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel1)
                         .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jButton1)
                         .addComponent(jButton2))
                    .addContainerGap())
          );

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );

          jDialog1_PurchaseRequest_JFrame.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

          jDialog1_PurchaseRequest_JIFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          jDialog1_PurchaseRequest_JIFrame.setTitle("Purchase Request");
          jDialog1_PurchaseRequest_JIFrame.setMinimumSize(new java.awt.Dimension(300, 170));

          jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          jButton3.setText("Ok");
          jButton3.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
               }
          });

          jButton4.setText("Cancel");
          jButton4.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton4ActionPerformed(evt);
               }
          });

          jLabel3.setText("PR Date:");

          jLabel4.setText("Employee ID:");

          jPanel6.setLayout(new java.awt.BorderLayout());

          javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
          jPanel5.setLayout(jPanel5Layout);
          jPanel5Layout.setHorizontalGroup(
               jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel5Layout.createSequentialGroup()
                              .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jTextField2)))
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                              .addGap(0, 116, Short.MAX_VALUE)
                              .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jButton4)))
                    .addContainerGap())
          );
          jPanel5Layout.setVerticalGroup(
               jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel4)
                         .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jButton4)
                         .addComponent(jButton3))
                    .addContainerGap())
          );

          javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
          jPanel4.setLayout(jPanel4Layout);
          jPanel4Layout.setHorizontalGroup(
               jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );
          jPanel4Layout.setVerticalGroup(
               jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );

          jDialog1_PurchaseRequest_JIFrame.getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setMinimumSize(new java.awt.Dimension(750, 650));
          getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

          jMenu1.setText("File");
          jMenuBar1.add(jMenu1);

          jMenu2.setText("Edit");
          jMenuBar1.add(jMenu2);

          jMenu3.setText("View");

          jMenu4.setText("JF iReport");

          jMenu6.setText("doscstinventorysystem");

          jMenuItem3.setText("PurchaseRequest.jasper");
          jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem3ActionPerformed(evt);
               }
          });
          jMenu6.add(jMenuItem3);

          jMenu4.add(jMenu6);

          jMenu3.add(jMenu4);

          jMenu5.setText("JIF iReport");

          jMenu7.setText("doscstinventorysystem");

          jMenuItem2.setText("PurchaseRequest.jasper");
          jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem2ActionPerformed(evt);
               }
          });
          jMenu7.add(jMenuItem2);

          jMenu5.add(jMenu7);

          jMenu3.add(jMenu5);

          jMenuBar1.add(jMenu3);

          jMenu9.setText("Open");

          jMenuItem5.setText("File");
          jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem5ActionPerformed(evt);
               }
          });
          jMenu9.add(jMenuItem5);

          jMenuBar1.add(jMenu9);

          setJMenuBar(jMenuBar1);

          pack();
     }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         // show jDialog - Other Components 
         if (jDialog1_PurchaseRequest_JIFrame.isVisible() || jDialog1_PurchaseRequest_JIFrame.isShowing()) {
              jDialog1_PurchaseRequest_JIFrame.setVisible(true);
         } else {
              jDialog1_PurchaseRequest_JIFrame.setVisible(true);
         }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         // show jDialog - Other Components 
         if (jDialog1_PurchaseRequest_JFrame.isVisible() || jDialog1_PurchaseRequest_JFrame.isShowing()) {

              jDialog1_PurchaseRequest_JFrame.setVisible(true);
         } else {
              jDialog1_PurchaseRequest_JFrame.setVisible(true);
         }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    }//GEN-LAST:event_jMenuItem5ActionPerformed

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          java.util.Date prDate = dc_JFrame.getDate();
          report_PurchaseRequest_JFrame(jTextField1.getText().trim().toString(), prDate);
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          jDialog1_PurchaseRequest_JFrame.dispose();
     }//GEN-LAST:event_jButton1ActionPerformed

     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          java.util.Date prDate = dc_JIFrame.getDate();
          report_PurchaseRequest_JIFrame(jTextField2.getText().trim().toString(), prDate);
     }//GEN-LAST:event_jButton3ActionPerformed

     private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          jDialog1_PurchaseRequest_JIFrame.dispose();
     }//GEN-LAST:event_jButton4ActionPerformed

     public static void main(String args[]) {

          try {
               for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                         javax.swing.UIManager.setLookAndFeel(info.getClassName());
                         break;


                    }
               }
          } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(JF_Main.class
                       .getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }

          java.awt.EventQueue.invokeLater(new Runnable() {
               @Override
               public void run() {
                    JF_Main ref_JF_Main = new JF_Main();
                    ref_JF_Main.setLocationRelativeTo(null);
                    ref_JF_Main.setSize(750, 650);
                    ref_JF_Main.setVisible(true);

               }
          });

     }
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JButton jButton4;
     private javax.swing.JDesktopPane jDesktopPane1;
     private javax.swing.JDialog jDialog1_PurchaseRequest_JFrame;
     private javax.swing.JDialog jDialog1_PurchaseRequest_JIFrame;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JMenu jMenu1;
     private javax.swing.JMenu jMenu2;
     private javax.swing.JMenu jMenu3;
     private javax.swing.JMenu jMenu4;
     private javax.swing.JMenu jMenu5;
     private javax.swing.JMenu jMenu6;
     private javax.swing.JMenu jMenu7;
     private javax.swing.JMenu jMenu9;
     private javax.swing.JMenuBar jMenuBar1;
     private javax.swing.JMenuItem jMenuItem2;
     private javax.swing.JMenuItem jMenuItem3;
     private javax.swing.JMenuItem jMenuItem5;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JPanel jPanel3;
     private javax.swing.JPanel jPanel4;
     private javax.swing.JPanel jPanel5;
     private javax.swing.JPanel jPanel6;
     private javax.swing.JTextField jTextField1;
     private javax.swing.JTextField jTextField2;
     // End of variables declaration//GEN-END:variables

     
     
     //
     private void setJDateChooser(JDateChooser jDateChooser, String DateFormat, java.util.Date date, JPanel jPanel) {
          jDateChooser.setDateFormatString(DateFormat);
          jDateChooser.setDate(date);
          //((JDateChooser) dc).getJCalendar().getDayChooser().addDateEvaluator(new BirthdayEvaluator());
          //((JDateChooser) dc).getJCalendar().getDayChooser().addDateEvaluator(new TestDateEvaluator());
          ((JDateChooser) jDateChooser).getJCalendar().setTodayButtonVisible(true);
          ((JDateChooser) jDateChooser).getJCalendar().setNullDateButtonVisible(true);

          ((JDateChooser) jDateChooser).getJCalendar().setDecorationBordersVisible(false);
          ((JDateChooser) jDateChooser).getJCalendar().setDecorationBackgroundColor(Color.black);
          ((JDateChooser) jDateChooser).getJCalendar().setWeekdayForeground(Color.white);
          ((JDateChooser) jDateChooser).getJCalendar().setSundayForeground(Color.red);
          ((JDateChooser) jDateChooser).getJCalendar().setDecorationBackgroundVisible(true);

          ((JDateChooser) jDateChooser).getJCalendar().setWeekOfYearVisible(false);
          ((JDateChooser) jDateChooser).getJCalendar().setMaxDayCharacters(1);
          ((JDateChooser) jDateChooser).getJCalendar().setBackground(Color.black);
          jPanel.add(jDateChooser);
     }

     //
     private void report_PurchaseRequest_JFrame(String employeeId, Date prDate) {
          try {
               db_doscstinventorysystem.connectToServer();
               if (db_doscstinventorysystem.getConnection() != null) {
                    String iReport = reportsDirectory + "PurchaseRequest.jasper";
                    HashMap parameters = new HashMap();
                    parameters.put("employeeId", employeeId);
                    parameters.put("prDate", prDate);

                    // Class.forName(MySQL_Driver);
                    // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doscstinventorysystem", "root", "");
                    // or
                    // Class.forName(MySQLConnection.getDbDriver());
                    // Connection conn = DriverManager.getConnection(MySQLConnection.getJdbcUrl() + ref_MySQLConnection.getConfig(), ref_MySQLConnection.getMySqlUsername(), ref_MySQLConnection.getMySqlPassword());
                    JFrame ref_JF_iReports = new JFrameJasperReportsViewer(iReport, parameters, db_doscstinventorysystem.getConnection());

                    if (ref_JF_iReports == null || !ref_JF_iReports.isVisible()) {
                         ref_JF_iReports.setSize(950, 650);
                         ref_JF_iReports.setLocationRelativeTo(null);
                         ref_JF_iReports.setAlwaysOnTop(false);
                         ref_JF_iReports.setVisible(true);
                    }
               }
          } catch (Exception e) {
               System.out.println(e);
          }
     }

     //
     private void report_PurchaseRequest_JIFrame(String employeeId, java.util.Date prDate) {
          try {
               db_doscstinventorysystem.connectToServer();
               if (db_doscstinventorysystem.getConnection() != null) {
                    String iReport = reportsDirectory + "PurchaseRequest.jasper";
                    HashMap parameters = new HashMap();
                    parameters.put("employeeId", employeeId);
                    parameters.put("prDate", prDate);

                    // Class.forName(MySQL_Driver);
                    // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doscstinventorysystem", "root", "");
                    // or
                    // Class.forName(MySQLConnection.getDbDriver());
                    // Connection conn = DriverManager.getConnection(MySQLConnection.getJdbcUrl() + ref_MySQLConnection.getConfig(), ref_MySQLConnection.getMySqlUsername(), ref_MySQLConnection.getMySqlPassword());
                    JInternalFrame ref_JIF_Reports = new JIFrameJasperReportsViewer(iReport, parameters, db_doscstinventorysystem.getConnection());
                    if (ref_JIF_Reports == null || !ref_JIF_Reports.isVisible()) {
                         ref_JIF_Reports.setClosable(true);
                         ref_JIF_Reports.setIconifiable(true);
                         ref_JIF_Reports.setMaximizable(true);
                         ref_JIF_Reports.setResizable(true);
                         jDesktopPane1.add(ref_JIF_Reports);
                         int w = 700;
                         int h = 500;
                         int x = w / 2;
                         int y = h / 2;
                         /* set JInternalFrame to center position */
                         int newX = jDesktopPane1.getWidth() / 2 - x;
                         int newY = jDesktopPane1.getHeight() / 2 - y;
                         ref_JIF_Reports.setBounds(newX, newY, w, h);
                         ref_JIF_Reports.setVisible(true);
                    }
               }
          } catch (Exception e) {
               System.out.println(e);
          }

     }
}
