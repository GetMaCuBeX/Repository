package mcbx.jb.samples.forms;

import javax.swing.UIManager;

public class JD_OpenForms1 extends javax.swing.JDialog {

    public JD_OpenForms1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.getRootPane().setFont(UIManager.getFont("SmallSystemFont"));
        this.getRootPane().putClientProperty("Quaqua.RootPane.isVertical", Boolean.FALSE);
        this.getRootPane().putClientProperty("Quaqua.RootPane.isPalette", Boolean.FALSE);

    }

    @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jDialog1 = new javax.swing.JDialog();
          jPanel2 = new javax.swing.JPanel();
          jFrame1 = new javax.swing.JFrame();
          jPanel3 = new javax.swing.JPanel();
          jPanel1 = new javax.swing.JPanel();
          jButton1 = new javax.swing.JButton();
          jButton2 = new javax.swing.JButton();

          jDialog1.setTitle("JDialog");
          jDialog1.setMinimumSize(new java.awt.Dimension(412, 371));

          jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 376, Short.MAX_VALUE)
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 274, Short.MAX_VALUE)
          );

          javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
          jDialog1.getContentPane().setLayout(jDialog1Layout);
          jDialog1Layout.setHorizontalGroup(
               jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jDialog1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );
          jDialog1Layout.setVerticalGroup(
               jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jDialog1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );

          jFrame1.setTitle("JFrame");
          jFrame1.setMinimumSize(new java.awt.Dimension(412, 371));

          jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
          jPanel3.setLayout(jPanel3Layout);
          jPanel3Layout.setHorizontalGroup(
               jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 376, Short.MAX_VALUE)
          );
          jPanel3Layout.setVerticalGroup(
               jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 274, Short.MAX_VALUE)
          );

          javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
          jFrame1.getContentPane().setLayout(jFrame1Layout);
          jFrame1Layout.setHorizontalGroup(
               jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jFrame1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );
          jFrame1Layout.setVerticalGroup(
               jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jFrame1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setTitle("JDialog");

          jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          jButton1.setText("JD_JD_1");
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });

          jButton2.setText("JD_JF_1");
          jButton2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jButton1)
                         .addComponent(jButton2))
                    .addContainerGap(301, Short.MAX_VALUE))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton2)
                    .addContainerGap(282, Short.MAX_VALUE))
          );

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jDialog1.isVisible() || jDialog1.isShowing()) {
            jDialog1.setModal(true);
            jDialog1.setLocationRelativeTo(this);
            jDialog1.setVisible(true);
        } else {
            jDialog1.setModal(true);
            jDialog1.setLocationRelativeTo(this);
            jDialog1.setVisible(true);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (jFrame1.isVisible() || jFrame1.isShowing()) {
            jFrame1.setLocationRelativeTo(this);
            jFrame1.setVisible(true);
        } else {
            jFrame1.setLocationRelativeTo(this);
            jFrame1.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JD_OpenForms1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_OpenForms1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_OpenForms1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_OpenForms1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_OpenForms1 dialog = new JD_OpenForms1(new javax.swing.JFrame(), true);
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
     private javax.swing.JButton jButton2;
     private javax.swing.JDialog jDialog1;
     private javax.swing.JFrame jFrame1;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JPanel jPanel3;
     // End of variables declaration//GEN-END:variables
}
