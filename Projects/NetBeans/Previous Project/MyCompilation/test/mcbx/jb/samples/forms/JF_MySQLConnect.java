package mcbx.jb.samples.forms;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mcbx.jb.classes.databaseconnection.MySQLConnection;

public class JF_MySQLConnect extends javax.swing.JFrame {

     private static MySQLConnection ref_MySQLConnection = new MySQLConnection();

     public JF_MySQLConnect() {
          initComponents();

     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          jPanel2 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jTextField1 = new javax.swing.JTextField();
          jTextField2 = new javax.swing.JTextField();
          jTextField3 = new javax.swing.JTextField();
          jTextField4 = new javax.swing.JTextField();
          jButton3 = new javax.swing.JButton();
          jLabel5 = new javax.swing.JLabel();
          jTextField5 = new javax.swing.JTextField();
          jButton4 = new javax.swing.JButton();
          jButton5 = new javax.swing.JButton();

          jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Connect to MySQL"));

          jLabel1.setText("Server Host:");

          jLabel2.setText("Port:");

          jLabel3.setText("Username:");

          jLabel4.setText("Password:");

          jTextField1.setText("localhost");

          jTextField2.setText("3306");

          jTextField3.setText("root");
          jTextField3.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField3ActionPerformed(evt);
               }
          });

          jButton3.setText("Clear");
          jButton3.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
               }
          });

          jLabel5.setText("Schema:");

          jTextField5.setText("internetreservationsystem");

          jButton4.setText("Connect");
          jButton4.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton4ActionPerformed(evt);
               }
          });

          jButton5.setText("Close Connection");
          jButton5.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton5ActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel2Layout.createSequentialGroup()
                              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addComponent(jLabel1)
                                             .addComponent(jLabel3)
                                             .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addComponent(jTextField4)
                                             .addComponent(jTextField1)
                                             .addComponent(jTextField3)
                                             .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                                   .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jLabel2)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                              .addComponent(jButton4)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jButton5)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(jButton3)))
                    .addContainerGap())
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel1)
                         .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel2)
                         .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel5))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jButton3)
                         .addComponent(jButton4)
                         .addComponent(jButton5))
                    .addContainerGap())
          );

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );

          getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

          pack();
     }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

         String serverHost = jTextField1.getText().toLowerCase().toString().trim();
         String port = jTextField2.getText().toLowerCase().toString().trim();
         String username = jTextField3.getText().toLowerCase().toString().trim();
         String password = jTextField4.getText().toLowerCase().trim().toString();
         String schema = jTextField5.getText().toLowerCase().toString().trim();

         String jdbcUrl = "jdbc:mysql://" + serverHost + ":" + port + "/" + schema;
         try {
              if (ref_MySQLConnection.getConn() == null || ref_MySQLConnection.getConn().isClosed()) {
                   try {
                        Class.forName(MySQLConnection.getDbDriver());
                        // setConn(jdbc:mysql://localhost:3306/'databasename',root,'empty')
                        ref_MySQLConnection.setConn(DriverManager.getConnection(jdbcUrl, username, password));
                        JOptionPane.showMessageDialog(this, "Connection successful!", "Connection", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Connection: 'Connected'");
                        setEnableJTextField(false);
                        setEditableJTextField(false);
                   } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex + "\nCommunications link failure.", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Exception: " + ex);
                   }
              } else {
                   System.out.println("Connection: 'Still connected'");
              } // end condition
         } catch (SQLException ex) {
              System.out.println("SQLException: " + ex);;
         }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         ref_MySQLConnection.setConn(null);
         setEnableJTextField(true);
         setEditableJTextField(true);
         System.out.println("Connection: 'Closed'");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         setTextJTextField("");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

     public static void main(String args[]) {

// ----------------------------------------------------------------------------- Nimbus LOOK&FEEL       
        /* Set the Nimbus look and feel */
          //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
           * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
           */
          try {
               for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                System.out.println(info.getName());
                    if ("Windows".equals(info.getName())) {
                         javax.swing.UIManager.setLookAndFeel(info.getClassName());
                         break;
                    }
               }
          } catch (ClassNotFoundException ex) {
               java.util.logging.Logger.getLogger(JF_MySQLConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(JF_MySQLConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(JF_MySQLConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(JF_MySQLConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               @Override
               public void run() {
                    JF_MySQLConnect instanceThis = new JF_MySQLConnect();
                    instanceThis.setLocationRelativeTo(null);
                    instanceThis.setVisible(true);

               }
          });
     }
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton jButton3;
     private javax.swing.JButton jButton4;
     private javax.swing.JButton jButton5;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JTextField jTextField1;
     private javax.swing.JTextField jTextField2;
     private javax.swing.JTextField jTextField3;
     private javax.swing.JTextField jTextField4;
     private javax.swing.JTextField jTextField5;
     // End of variables declaration//GEN-END:variables

     private void setEnableJTextField(boolean b) {

          jTextField1.setEnabled(b);
          jTextField2.setEnabled(b);
          jTextField3.setEnabled(b);
          jTextField4.setEnabled(b);
          jTextField5.setEnabled(b);
     }

     private void setEditableJTextField(boolean b) {
          jTextField1.setEditable(b);
          jTextField2.setEditable(b);
          jTextField3.setEditable(b);
          jTextField4.setEditable(b);
          jTextField5.setEditable(b);

     }

     private void setTextJTextField(String string) {
          jTextField1.setText(string);
          jTextField2.setText(string);
          jTextField3.setText(string);
          jTextField4.setText(string);
          jTextField5.setText(string);
     }
}
