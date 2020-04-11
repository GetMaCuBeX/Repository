package mcbx.jb.samples.forms;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.SwingUtilities;
import mcbx.jb.classes.mycollection.DesktopPane;
import mcbx.jb.classes.mycollection.MousePosition;

public class JP_OpenForms1 extends javax.swing.JPanel {

     private MousePosition mp1 = new MousePosition();
     
     Image img;

     public JP_OpenForms1(String path) {
          initComponents();
          try {
               java.net.URL url = ClassLoader.getSystemResource(path);
               img = javax.imageio.ImageIO.read(url);
          } catch (Exception e) {
          }
     }

     @Override
     public void paintComponent(Graphics g) {
          super.paintComponent(g);
          if (img != null) {
               //System.out.println("Image Found");
               g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
          } else {
               g.drawString("Image not found", 10, 50);
          }
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          setBorder(javax.swing.BorderFactory.createEtchedBorder());
          setOpaque(false);
          addMouseListener(new java.awt.event.MouseAdapter() {
               public void mousePressed(java.awt.event.MouseEvent evt) {
                    formMousePressed(evt);
               }
          });
          addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
               public void mouseDragged(java.awt.event.MouseEvent evt) {
                    formMouseDragged(evt);
               }
          });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
          this.setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 296, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 296, Short.MAX_VALUE)
          );
     }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged


         try {
              Container container = SwingUtilities.getAncestorOfClass(DesktopPane.class, (Component) evt.getSource());
              if (container != null) {
                   DesktopPane desktop = (DesktopPane) container;
                   this.setLocation(desktop.getMousePosition().x - mp1.getMouseX(), desktop.getMousePosition().y - mp1.getMouseY());
              } else {
              }
         } catch (Exception e) {
         }


    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
         mp1.setMouseX((int) this.getMousePosition().getX());
         mp1.setMouseY((int) this.getMousePosition().getY());
    }//GEN-LAST:event_formMousePressed
     // Variables declaration - do not modify//GEN-BEGIN:variables
     // End of variables declaration//GEN-END:variables
}
