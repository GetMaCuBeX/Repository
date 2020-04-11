package mcbx.jb.samples.forms;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import mcbx.jb.classes.mycollection.DesktopPane;
import mcbx.jb.classes.mycollection.FrameIconImage;

public class JF_SetImageIcon extends javax.swing.JFrame {

     private String images_jpanel = "mcbx/jb/images/jpanel/";
     private String icons_jframe = "mcbx/jb/icons/jframe/";
     private String icons_joptionpane = "mcbx/jb/icons/joptionpane/";
     //
     private DesktopPane image1 = new DesktopPane(images_jpanel + "02_300x300_DOSCST.png");
     private FrameIconImage icon1 = new FrameIconImage(icons_jframe + "01_14x14_Disable_Icon.png");
     private JP_Image JP_Image1 = new JP_Image(icons_joptionpane + "02_64x64_DOSCST.png");

     public JF_SetImageIcon() {
          initComponents();
          jPanel1.add(image1, java.awt.BorderLayout.CENTER);
          this.setIconImage(icon1.getImg());
          //
          jPanel2.add(JP_Image1);
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          jPanel2 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();

          jPanel1.setBackground(new java.awt.Color(255, 255, 255));
          jPanel1.setLayout(new java.awt.BorderLayout());

          jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
          jPanel2.setLayout(new java.awt.BorderLayout());

          jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          jLabel1.setText("JP_Image");

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGroup(layout.createSequentialGroup()
                              .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jLabel1)))
                    .addContainerGap(148, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

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
               java.util.logging.Logger.getLogger(JF_SetImageIcon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(JF_SetImageIcon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(JF_SetImageIcon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(JF_SetImageIcon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               @Override
               public void run() {
                    JF_SetImageIcon instanceThis = new JF_SetImageIcon();
                    instanceThis.setLocationRelativeTo(null);
                    instanceThis.setVisible(true);

               }
          });
     }
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JLabel jLabel1;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     // End of variables declaration//GEN-END:variables

     protected static ImageIcon createImageIcon(String path) {
          java.net.URL imgURL = ClassLoader.getSystemResource(path);
          //java.net.URL imgURL = JF_SetImageIcon.class.getResource(path);
          if (imgURL != null) {
               return new ImageIcon(imgURL);
          } else {
               System.err.println("Couldn't find file: " + path);
               return null;
          }
     }
}
