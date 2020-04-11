package mcbx.jb.classes.databaseconnection;

import javax.swing.JOptionPane;
import mcbx.jb.classes.databaseconnection.MySQL;

public class JD_MySQLConnect extends javax.swing.JDialog {

     private MySQL ref_MySQL = new MySQL(null, null, null, null, null);

     public JD_MySQLConnect(java.awt.Frame parent, boolean modal) {
          super(parent, modal);
          initComponents();
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel2 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jTextField_serverHostName = new javax.swing.JTextField();
          jTextField_portNumber = new javax.swing.JTextField();
          jTextField_userName = new javax.swing.JTextField();
          jLabel5 = new javax.swing.JLabel();
          jTextField_schema = new javax.swing.JTextField();
          jPasswordField_password = new javax.swing.JPasswordField();
          jPanel3 = new javax.swing.JPanel();
          jButton_testConnection = new javax.swing.JButton();
          jButton_clear = new javax.swing.JButton();
          jButton1 = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setTitle("Establish Connection");
          setResizable(false);

          jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Connect to MySQL"));

          jLabel1.setText("Server Host:");

          jLabel2.setText("Port:");

          jLabel3.setText("Username:");

          jLabel4.setText("Password:");

          jTextField_serverHostName.setMargin(new java.awt.Insets(1, 4, 1, 4));

          jTextField_portNumber.setMargin(new java.awt.Insets(1, 4, 1, 4));

          jTextField_userName.setMargin(new java.awt.Insets(1, 4, 1, 4));
          jTextField_userName.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField_userNameActionPerformed(evt);
               }
          });

          jLabel5.setText("Schema:");

          jTextField_schema.setEditable(false);
          jTextField_schema.setFocusable(false);
          jTextField_schema.setMargin(new java.awt.Insets(1, 4, 1, 4));

          jPasswordField_password.setMargin(new java.awt.Insets(1, 4, 1, 4));
          jPasswordField_password.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jPasswordField_passwordActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel1)
                         .addComponent(jLabel3)
                         .addComponent(jLabel5)
                         .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jTextField_serverHostName)
                         .addComponent(jTextField_userName)
                         .addComponent(jTextField_schema)
                         .addComponent(jPasswordField_password))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField_portNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel1)
                         .addComponent(jTextField_serverHostName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel2)
                         .addComponent(jTextField_portNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jTextField_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jLabel4)
                         .addComponent(jPasswordField_password))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jTextField_schema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel5))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          jPanel3.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

          jButton_testConnection.setText("Set  Connection");
          jButton_testConnection.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_testConnectionActionPerformed(evt);
               }
          });
          jPanel3.add(jButton_testConnection);

          jButton_clear.setText("Clear");
          jButton_clear.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_clearActionPerformed(evt);
               }
          });
          jPanel3.add(jButton_clear);

          jButton1.setText("Cancel");
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          jPanel3.add(jButton1);

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 39, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jTextField_userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_userNameActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_jTextField_userNameActionPerformed

     private void jPasswordField_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_passwordActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_jPasswordField_passwordActionPerformed

     private void jButton_testConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_testConnectionActionPerformed

          establishConneciton();
     }//GEN-LAST:event_jButton_testConnectionActionPerformed

     private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed

          clearFields();
     }//GEN-LAST:event_jButton_clearActionPerformed

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          this.dispose();
     }//GEN-LAST:event_jButton1ActionPerformed

     public static void main(String args[]) {
          /* Set the Nimbus look and feel */
          //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
           * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
           */
          try {
               for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                         javax.swing.UIManager.setLookAndFeel(info.getClassName());
                         break;
                    }
               }
          } catch (ClassNotFoundException ex) {
               java.util.logging.Logger.getLogger(JD_MySQLConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(JD_MySQLConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(JD_MySQLConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(JD_MySQLConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the dialog */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    JD_MySQLConnect dialog = new JD_MySQLConnect(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                         @Override
                         public void windowClosing(java.awt.event.WindowEvent e) {
                              System.exit(0);
                         }
                    });
                    dialog.setVisible(true);
               }
          });
     }
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton_clear;
     private javax.swing.JButton jButton_testConnection;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JPanel jPanel3;
     private static javax.swing.JPasswordField jPasswordField_password;
     private static javax.swing.JTextField jTextField_portNumber;
     private static javax.swing.JTextField jTextField_schema;
     private static javax.swing.JTextField jTextField_serverHostName;
     private static javax.swing.JTextField jTextField_userName;
     // End of variables declaration//GEN-END:variables

     /* initiliaze connection */
     public void initiliazeConnection(MySQL ins_MySQL) {
          try {
               ref_MySQL = ins_MySQL;
               /* set fields */
               setFields();
          } catch (Exception e) {
               System.err.println(e);
          }
     }

     /* set fields */
     private void setFields() {
          try {
               jTextField_serverHostName.setText(ref_MySQL.getServerHostName());
               jTextField_portNumber.setText(ref_MySQL.getPortNumber());
               jTextField_userName.setText(ref_MySQL.getUserName());
               jPasswordField_password.setText(ref_MySQL.getPassword());
               jTextField_schema.setText(ref_MySQL.getSchema());
          } catch (Exception e) {
               System.err.println(e);
          }
     }

     /* get fields */
     private void getFields() {
          try {
               ref_MySQL.setServerHostName(jTextField_serverHostName.getText().trim());
               ref_MySQL.setPortNumber(jTextField_portNumber.getText().trim());
               ref_MySQL.setUserName(jTextField_userName.getText().trim());
               ref_MySQL.setPassword(jPasswordField_password.getText().trim());
               ref_MySQL.setSchema(jTextField_schema.getText().trim());
          } catch (Exception e) {
               System.err.println(e);
          }

     }


     /* establish MySQL connection */
     private void establishConneciton() {
          try {
               getFields();
               setFields();
               ref_MySQL.connectToServer();
               checkConnection();
          } catch (Exception e) {
               System.err.println(e);
          }
     }

     /* check connection */
     private void checkConnection() {
          try {
               /* if connection is connected*/
               if (ref_MySQL.getConnection() != null) {
                    JOptionPane.showMessageDialog(this, "The server connection was successfully established", "Message", JOptionPane.PLAIN_MESSAGE);
               } else { /* failed to connect*/

               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }


     /* clear fields */
     private void clearFields() {
          jTextField_serverHostName.setText("");
          jTextField_portNumber.setText("");
          jTextField_userName.setText("");
          jPasswordField_password.setText("");
//          jTextField_schema.setText("");
     }
}
