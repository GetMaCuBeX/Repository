package gui.booksreservation.main;

public class JF_Administrator extends javax.swing.JFrame {

    //
    public JF_Administrator_Books JF_Books = new JF_Administrator_Books();
    public REF_JF_Administrator_Members REF_JF_Administrator_Members = new REF_JF_Administrator_Members();
    public JF_Administrator_Reports ref_JF_Administrator_Reports = new JF_Administrator_Reports();
    public JD_UpdateBorrowedBooks ref_JD_UpdateBorrowedBooks = new JD_UpdateBorrowedBooks(this, false);

    public JF_Administrator() {
        initComponents();
        ref_JD_UpdateBorrowedBooks.setSize(ref_JD_UpdateBorrowedBooks.getPreferredSize());
        ref_JD_UpdateBorrowedBooks.setLocationRelativeTo(null);
        ref_JD_UpdateBorrowedBooks.setAlwaysOnTop(true);
        jToggleButton3.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel3 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        buttonGroup1.add(jToggleButton1);
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_64x64_Books.png"))); // NOI18N
        jToggleButton1.setSelected(true);
        jToggleButton1.setToolTipText("Books");
        jToggleButton1.setFocusPainted(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setPreferredSize(new java.awt.Dimension(80, 80));
        jToggleButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jToggleButton1ItemStateChanged(evt);
            }
        });
        jPanel3.add(jToggleButton1);

        buttonGroup1.add(jToggleButton2);
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_64x64_Students.png"))); // NOI18N
        jToggleButton2.setToolTipText("Members");
        jToggleButton2.setFocusPainted(false);
        jToggleButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton2.setPreferredSize(new java.awt.Dimension(80, 80));
        jToggleButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jToggleButton2ItemStateChanged(evt);
            }
        });
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jToggleButton2);

        buttonGroup1.add(jToggleButton3);
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_64x64_Records_2.png"))); // NOI18N
        jToggleButton3.setToolTipText("Records");
        jToggleButton3.setFocusPainted(false);
        jToggleButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton3.setPreferredSize(new java.awt.Dimension(80, 80));
        jToggleButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jToggleButton3ItemStateChanged(evt);
            }
        });
        jPanel3.add(jToggleButton3);

        buttonGroup1.add(jToggleButton4);
        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_64x64_Reports.png"))); // NOI18N
        jToggleButton4.setToolTipText("Reprots");
        jToggleButton4.setFocusPainted(false);
        jToggleButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton4.setPreferredSize(new java.awt.Dimension(80, 80));
        jToggleButton4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jToggleButton4ItemStateChanged(evt);
            }
        });
        jPanel3.add(jToggleButton4);

        jToolBar1.add(jPanel3);

        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel5.add(jLabel1, java.awt.BorderLayout.CENTER);

        jToolBar1.add(jPanel5);

        jPanel1.add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jToggleButton1ItemStateChanged

        itemStateChange();
    }//GEN-LAST:event_jToggleButton1ItemStateChanged

    private void jToggleButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jToggleButton2ItemStateChanged
        itemStateChange();
    }//GEN-LAST:event_jToggleButton2ItemStateChanged

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jToggleButton3ItemStateChanged
        itemStateChange();
    }//GEN-LAST:event_jToggleButton3ItemStateChanged

    private void jToggleButton4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jToggleButton4ItemStateChanged
        itemStateChange();
    }//GEN-LAST:event_jToggleButton4ItemStateChanged

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(JF_Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Administrator().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JToggleButton jToggleButton2;
    public javax.swing.JToggleButton jToggleButton3;
    public javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    public void itemStateChange() {
        /* Books */
        if (jToggleButton1.isSelected()) {
            jPanel4.add(JF_Books.jPanel3);
        } else {
            jPanel4.remove(JF_Books.jPanel3);
        }
        /* Students */
        if (jToggleButton2.isSelected()) {
            jPanel4.add(REF_JF_Administrator_Members.jPanel2);
        } else {
            jPanel4.remove(REF_JF_Administrator_Members.jPanel2);
        }
        /* Records */
        if (jToggleButton3.isSelected()) {
        } else {
        }
        /* Reports */
        if (jToggleButton4.isSelected()) {
            jPanel4.add(ref_JF_Administrator_Reports.jPanel1);
        } else {
            jPanel4.remove(ref_JF_Administrator_Reports.jPanel1);
        }
        jPanel4.updateUI();
    }
}
