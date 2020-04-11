package mcbx.jb.samples.forms;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.SwingUtilities;
import mcbx.jb.classes.mycollection.DesktopPane;
import mcbx.jb.classes.mycollection.MousePosition;

public class JP_Image extends javax.swing.JPanel {

     private MousePosition mp2 = new MousePosition();
     private Image img;

     public JP_Image(String url_image) {
          try {
               java.net.URL url = ClassLoader.getSystemResource(url_image);
               img = javax.imageio.ImageIO.read(url);
          } catch (Exception e) {
               System.out.println(e);
          }

     }

     @Override
     public void paintComponent(Graphics g) {
          super.paintComponent(g);
          if (img != null) {
               g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
          } else {
               g.drawString("Image not found", 10, 50);
          }
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

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
               .addGap(0, 400, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 300, Short.MAX_VALUE)
          );
     }// </editor-fold>//GEN-END:initComponents

     private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
          mp2.setMouseX((int) this.getMousePosition().getX());
          mp2.setMouseY((int) this.getMousePosition().getY());
     }//GEN-LAST:event_formMousePressed

     private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
          try {
               Container container = SwingUtilities.getAncestorOfClass(DesktopPane.class, (Component) evt.getSource());
               if (container != null) {
                    DesktopPane desktop = (DesktopPane) container;
                    this.setLocation(desktop.getMousePosition().x - mp2.getMouseX(), desktop.getMousePosition().y - mp2.getMouseY());
               } else {
               }
          } catch (Exception e) {
          }
     }//GEN-LAST:event_formMouseDragged
     // Variables declaration - do not modify//GEN-BEGIN:variables
     // End of variables declaration//GEN-END:variables
}
