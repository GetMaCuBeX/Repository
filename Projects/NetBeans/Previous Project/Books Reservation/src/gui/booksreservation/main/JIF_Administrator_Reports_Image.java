package gui.booksreservation.main;

import java.awt.Color;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class JIF_Administrator_Reports_Image extends javax.swing.JInternalFrame {

    public JIF_Administrator_Reports_Image() {
        initComponents();
        BasicInternalFrameUI _BasicInternalFrameUI = (BasicInternalFrameUI) getUI();
        _BasicInternalFrameUI.setNorthPane(null);
        this.getRootPane().setBackground(new Color(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setBorder(null);
        setClosable(true);
        setResizable(true);
        setOpaque(false);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/booksreservation/main/icons/1_256x256_NoImageBackground_Books.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setIconTextGap(0);
        jPanel2.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel6, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
