package gui.booksreservation.main;

import javax.swing.JInternalFrame;
import mcbx.jb.classes.mycollection.DesktopPane;
import mcbx.jb.classes.mycollection.JIFrameJasperReportsViewer;

public class JF_Administrator_Reports extends javax.swing.JFrame {

    private String DP_IMAGE_LOCATION = "mcbx/jb/images/jdesktoppane/";
    public DesktopPane DP1 = new DesktopPane(DP_IMAGE_LOCATION + "black.jpg");
//    public JIF_Administrator_Reports_Image ref_JIF_Administrator_Reports_Image;

    public JF_Administrator_Reports() {
        initComponents();

        initComponents_MainDesktopPane();
//        open_JIF_Administrator_Reports_Image();
    }


    /* open JInternalFrame */
    public void open_JInternalFrame(JInternalFrame ref_JInternalFrame, DesktopPane iDesktopPane) {
        try {
            iDesktopPane.add(ref_JInternalFrame);
            ref_JInternalFrame.setSelected(true);
            int a = ref_JInternalFrame.getWidth() / 2;
            int b = ref_JInternalFrame.getHeight() / 2;
            ref_JInternalFrame.setLocation(iDesktopPane.getWidth() / 2 - a, iDesktopPane.getHeight() / 2 - b);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Administrator_Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JF_Administrator_Reports instance = new JF_Administrator_Reports();
                instance.setLocationRelativeTo(null);
                instance.setSize(600,500);
                instance.setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void initComponents_MainDesktopPane() {
        try {
            jPanel2.add(DP1, java.awt.BorderLayout.CENTER);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void open_JIF_Administrator_Reports_Image() {
        try {
//            if (ref_JIF_Administrator_Reports_Image == null || ref_JIF_Administrator_Reports_Image.isClosed()) {
//                open_JInternalFrame(ref_JIF_Administrator_Reports_Image = new JIF_Administrator_Reports_Image(), DP1);
//                ref_JIF_Administrator_Reports_Image.setLayer(0);
//                ref_JIF_Administrator_Reports_Image.setMaximum(true);
//                ref_JIF_Administrator_Reports_Image.setVisible(true);
//            } else {
//                ref_JIF_Administrator_Reports_Image.setVisible(true);
//                if (ref_JIF_Administrator_Reports_Image.isIcon()) {
//                    ref_JIF_Administrator_Reports_Image.setIcon(false);
//                }
//            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
