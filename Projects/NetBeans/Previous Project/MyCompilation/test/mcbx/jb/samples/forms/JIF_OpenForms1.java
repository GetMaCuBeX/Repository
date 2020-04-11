package mcbx.jb.samples.forms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.TrayIcon;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import mcbx.jb.classes.mycollection.DesktopPane;
import mcbx.jb.classes.mycollection.MousePosition;

public class JIF_OpenForms1 extends javax.swing.JInternalFrame {

     BasicInternalFrameUI _BasicInternalFrameUI = (BasicInternalFrameUI) getUI();
     private static JToolBar unifiedToolBar;
     private static JToolBar unifiedStatusBar;
     boolean setjButton5 = true;
     int count = 0;

     public JIF_OpenForms1() {

          initComponents();

// ----------------------------------------------------------------------------- JDIALOG PALLETTE
          jDialog1.setSize(jPanel5.getPreferredSize());
          jDialog1.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
          jDialog1.getRootPane().setFont(UIManager.getFont("SmallSystemFont"));
          jDialog1.getRootPane().putClientProperty("Quaqua.RootPane.isVertical", Boolean.FALSE);
//        jDialog1.getRootPane().putClientProperty("Quaqua.RootPane.isPalette", Boolean.TRUE);
//        jDialog1.getRootPane().putClientProperty("Window.style", "small");
//        FloatingPaletteHandler.getInstance().addPalette(jDialog1);

// ----------------------------------------------------------------------------- FRAME PALLETTE
          jFrame1.setSize(jPanel4.getPreferredSize());
          jFrame1.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
          jFrame1.getRootPane().setFont(UIManager.getFont("SmallSystemFont"));
          jFrame1.getRootPane().putClientProperty("Quaqua.RootPane.isVertical", Boolean.FALSE);
//        jFrame1.getRootPane().putClientProperty("Quaqua.RootPane.isPalette", Boolean.TRUE);
//        jFrame1.getRootPane().putClientProperty("Window.style", "small");
//        FloatingPaletteHandler.getInstance().addPalette(jFrame1);


// ----------------------------------------------------------------------------- BUTTON ICONABLE
//        jButton4.setVisible(false);

// ----------------------------------------------------------------------------- TOOLBAR
//        jToolBar1.putClientProperty("Quaqua.ToolBar.style", "plain");
//        jToolBar1.putClientProperty("Quaqua.ToolBar.style", "title");
//        jToolBar1.putClientProperty("Quaqua.ToolBar.style", "gradient");
          jToolBar1.putClientProperty("Quaqua.ToolBar.style", "bottom");
          jToolBar1.revalidate();
          jToolBar1.repaint();


// ----------------------------------------------------------------------------- JInternalFrame
//        _BasicInternalFrameUI.setNorthPane(null);
//        _BasicInternalFrameUI.setEastPane(null);
//        _BasicInternalFrameUI.setWestPane(null);
//        _BasicInternalFrameUI.setSouthPane(null);
          this.getRootPane().setBackground(new Color(255, 255, 255, 50));
          jToolBar1.setBackground(new Color(255, 255, 255, 0));
          jPanel2.setBackground(new Color(255, 255, 255, 0));
          jButton4.setBackground(new Color(255, 255, 255, 0));
          jToolBar1.setVisible(false);
     }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jDialog1 = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();

        jFrame1.setTitle("JFrame");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialog1.setTitle("JDialog");
        jDialog1.setAlwaysOnTop(true);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("JDialog of JIF_OpenForms_1");

        jButton11.setText("Title");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jButton11))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBackground(new java.awt.Color(102, 102, 102));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("JInternalFrame 1");
        setMinimumSize(new java.awt.Dimension(100, 100));
        setVisible(true);

        jToolBar1.setBackground(new java.awt.Color(220, 220, 220));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setAlignmentX(0.0F);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setEnabled(false);
        jToolBar1.setFocusable(false);
        jToolBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToolBar1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToolBar1MousePressed(evt);
            }
        });
        jToolBar1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jToolBar1MouseDragged(evt);
            }
        });

        jPanel2.setOpaque(false);

        jPanel6.setOpaque(false);

        jButton2.setToolTipText("Close");
        jButton2.setFocusable(false);
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.setMaximumSize(new java.awt.Dimension(12, 12));
        jButton2.setMinimumSize(new java.awt.Dimension(12, 12));
        jButton2.setOpaque(false);
        jButton2.setPreferredSize(new java.awt.Dimension(12, 12));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setToolTipText("Close");
        jButton5.setFocusable(false);
        jButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton5.setMaximumSize(new java.awt.Dimension(12, 12));
        jButton5.setMinimumSize(new java.awt.Dimension(12, 12));
        jButton5.setOpaque(false);
        jButton5.setPreferredSize(new java.awt.Dimension(12, 12));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setToolTipText("Close");
        jButton4.setFocusable(false);
        jButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton4.setMaximumSize(new java.awt.Dimension(12, 12));
        jButton4.setMinimumSize(new java.awt.Dimension(12, 12));
        jButton4.setOpaque(false);
        jButton4.setPreferredSize(new java.awt.Dimension(12, 12));
        jButton4.setRequestFocusEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INTERNAL FRAME: WINDOW FORMS");
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jToolBar1.add(jPanel2);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton6.setText("TrayIcon Message");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addContainerGap(312, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private MousePosition mp1 = new MousePosition();

    private void jToolBar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToolBar1MousePressed

         if (this.isMaximum == true) {
         } else {
              mp1.setMouseX((int) this.getMousePosition().getX());
              mp1.setMouseY((int) this.getMousePosition().getY());
         }


    }//GEN-LAST:event_jToolBar1MousePressed

    private void jToolBar1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToolBar1MouseDragged
         if (this.isMaximum == true) {
         } else {
              try {
                   Container container = SwingUtilities.getAncestorOfClass(DesktopPane.class, (Component) evt.getSource());
                   if (container != null) {
                        DesktopPane desktop = (DesktopPane) container;
                        this.setLocation(desktop.getMousePosition().x - mp1.getMouseX(), desktop.getMousePosition().y - mp1.getMouseY());
                   } else {
                   }
              } catch (Exception e) {
              }
         }


    }//GEN-LAST:event_jToolBar1MouseDragged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         this.jDialog1.dispose();
         this.jFrame1.dispose();
         if (smallPalette != null) {
              smallPalette.dispose();
         }
         this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         try {
              if (this.isIcon == true) {
              } else {
                   this.setIcon(true);
              }
         } catch (PropertyVetoException ex) {
         }



    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         try {
              if (this.isMaximum == true) {
                   this.setMaximum(false);
              } else {
                   this.setMaximum(true);
              }
         } catch (PropertyVetoException ex) {
         }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jToolBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToolBar1MouseClicked
         if (evt.getButton() == MouseEvent.BUTTON1) {
              if (evt.getClickCount() == 2) {
                   try {
                        if (this.isMaximum == true) {
                             this.setMaximum(false);
                        } else {
                             this.setMaximum(true);
                        }
                   } catch (PropertyVetoException ex) {
                   }
              } else {
              }
         }
    }//GEN-LAST:event_jToolBar1MouseClicked
     private JDialog smallPalette;
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
         this.setTitle("New Title " + count++);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JF_Main.TrayIcon_MyTrayIcon.displayMessage("Sun TrayIcon Demo",
            "This is an error message", TrayIcon.MessageType.ERROR);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    public static javax.swing.JDialog jDialog1;
    public static javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
//jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Frame/14x14_Disable_Icon_2.png")));

     public void changeTitle(String new_Title) {
          this.setTitle(new_Title);
     }

     public void showDialog() {
          JOptionPane.showMessageDialog(this, "MESSAGE", "TITLE", 2, null);
     }
}
