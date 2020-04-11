package mcbx.jb.samples.table;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import mcbx.jb.classes.databaseconnection.MySQL;

public class JF_Office extends javax.swing.JFrame {

     //
     DefaultTableModel jTableOffice_TableModel;
     //

     public JF_Office() {
          initComponents();
          //
          jTableOffice_TableModel = (DefaultTableModel) jTableOffice.getModel();
          jTable_setShowHorizontalLines(jTableOffice);
          jTable_setTableHeader(jTableOffice);
          //
     }

// ----------------------------------------------------------------------------- [SET TABLE]
     private void jTable_setShowHorizontalLines(JTable jTable) {
          jTable.setShowHorizontalLines(true);
          jTable.setShowVerticalLines(true);
     }

     private void jTable_setTableHeader(JTable jTable) {
          JTableHeader header = jTable.getTableHeader();
          header.setEnabled(true);
          header.setUpdateTableInRealTime(true);
          //header.setBackground(Color.WHITE);
          header.setForeground(Color.BLACK);
          header.setFont(new java.awt.Font("Tahoma", 1, 11));
          header.setAlignmentX(0);
          header.setAlignmentY(0);
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          jButton1 = new javax.swing.JButton();
          jScrollPane1 = new javax.swing.JScrollPane();
          jTableOffice = new javax.swing.JTable();
          jSlider1 = new javax.swing.JSlider();
          jSlider2 = new javax.swing.JSlider();
          jSpinner2 = new javax.swing.JSpinner();
          jSpinner1 = new javax.swing.JSpinner();
          jMenuBar1 = new javax.swing.JMenuBar();
          jMenu1 = new javax.swing.JMenu();
          jMenu2 = new javax.swing.JMenu();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setMinimumSize(new java.awt.Dimension(450, 430));
          setPreferredSize(new java.awt.Dimension(450, 400));

          jButton1.setText("Fill Table");
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });

          jTableOffice.setAutoCreateRowSorter(true);
          jTableOffice.setBackground(new java.awt.Color(255, 255, 204));
          jTableOffice.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {

               },
               new String [] {
                    "Office", "Description"
               }
          ) {
               Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class
               };
               boolean[] canEdit = new boolean [] {
                    false, true
               };

               public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
               }

               public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
               }
          });
          jTableOffice.setRowHeight(23);
          jTableOffice.getTableHeader().setReorderingAllowed(false);
          jTableOffice.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyReleased(java.awt.event.KeyEvent evt) {
                    jTableOfficeKeyReleased(evt);
               }
          });
          jScrollPane1.setViewportView(jTableOffice);
          jTableOffice.getColumnModel().getColumn(0).setMinWidth(0);
          jTableOffice.getColumnModel().getColumn(0).setPreferredWidth(100);
          jTableOffice.getColumnModel().getColumn(0).setMaxWidth(100);

          jSlider1.setMaximum(50);
          jSlider1.setMinimum(1);
          jSlider1.setValue(23);
          jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
               public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    jSlider1StateChanged(evt);
               }
          });

          jSlider2.setMaximum(50);
          jSlider2.setMinimum(1);
          jSlider2.setValue(11);
          jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
               public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    jSlider2StateChanged(evt);
               }
          });

          jSpinner2.setModel(new javax.swing.SpinnerNumberModel(11, 1, 50, 1));
          jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
               public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    jSpinner2StateChanged(evt);
               }
          });

          jSpinner1.setModel(new javax.swing.SpinnerNumberModel(23, 1, 50, 1));
          jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
               public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    jSpinner1StateChanged(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jButton1))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                   .addComponent(jSlider2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap())
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(jButton1)
                              .addGap(0, 0, Short.MAX_VALUE))
                         .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jSpinner1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jSpinner2))
                    .addContainerGap())
          );

          getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

          jMenu1.setText("File");
          jMenuBar1.add(jMenu1);

          jMenu2.setText("Edit");
          jMenuBar1.add(jMenu2);

          setJMenuBar(jMenuBar1);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jTableOfficeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableOfficeKeyReleased
     }//GEN-LAST:event_jTableOfficeKeyReleased

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          fill_jTableOffice();
     }//GEN-LAST:event_jButton1ActionPerformed

     private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
          try {
               JSlider source = (JSlider) evt.getSource();
               if (!source.getValueIsAdjusting()) {
                    int value = (int) source.getValue();

                    if (value == 0) {
                         System.out.println("Value is zero");
                    } else {
                         jTableOffice.setRowHeight(value);
                         jSpinner1.setValue(value);
                    }
               }

          } catch (Exception e) {
               System.out.println(e);
          }

     }//GEN-LAST:event_jSlider1StateChanged

     private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
          try {
               JSlider source = (JSlider) evt.getSource();
               if (!source.getValueIsAdjusting()) {
                    int value = (int) source.getValue();

                    if (value == 0) {
                    } else {
                         jTableOffice.setFont(new java.awt.Font("Tahoma", 0, value));
                         jSpinner2.setValue(value);
                    }
               }

          } catch (Exception e) {
               System.out.println(e);
          }
     }//GEN-LAST:event_jSlider2StateChanged

     private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged

          try {
               jSlider1.setValue(jSpinner1.getValue().hashCode());
          } catch (Exception e) {
          }



     }//GEN-LAST:event_jSpinner1StateChanged

     private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
          try {
               jSlider2.setValue(jSpinner2.getValue().hashCode());
          } catch (Exception e) {
          }

     }//GEN-LAST:event_jSpinner2StateChanged

     public static void main(String args[]) {
// ----------------------------------------------------------------------------- Nimbus LOOK&FEEL       
          try {
               for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                         javax.swing.UIManager.setLookAndFeel(info.getClassName());
                         break;
                    }
               }
          } catch (ClassNotFoundException ex) {
               java.util.logging.Logger.getLogger(JF_Office.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(JF_Office.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(JF_Office.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(JF_Office.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               @Override
               public void run() {
                    JF_Office instanceThis = new JF_Office();
                    instanceThis.setLocationRelativeTo(null);
                    instanceThis.setVisible(true);
               }
          });
     }
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton jButton1;
     private javax.swing.JMenu jMenu1;
     private javax.swing.JMenu jMenu2;
     private javax.swing.JMenuBar jMenuBar1;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JSlider jSlider1;
     private javax.swing.JSlider jSlider2;
     private javax.swing.JSpinner jSpinner1;
     private javax.swing.JSpinner jSpinner2;
     private javax.swing.JTable jTableOffice;
     // End of variables declaration//GEN-END:variables

// ----------------------------------------------------------------------------- [QUERY INFORMATION]     
     private void fill_jTableOffice() {
          try {
               jTableOffice_TableModel.setRowCount(0);
               new Office().select_information_jTable();
               for (int i = 0; i < Office.getjTableOffice_data().size(); i++) {
                    jTableOffice_TableModel.addRow((Vector) Office.getjTableOffice_data().get(i));
               }
          } catch (Exception e) {
               System.out.println(e);
          }
     }
}
