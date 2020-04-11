package mcbx.jb.classes.mycollection;

import java.awt.Image;
import javax.swing.JDesktopPane;

public class JDialogIconImage extends JDesktopPane {

     public Image img;

     public Image getImg() {
          return img;
     }

     private void setImg(Image img) {
          this.img = img;
     }

     public JDialogIconImage(String systemResource) {
          try {
               java.net.URL url = ClassLoader.getSystemResource(systemResource);
               this.setImg(javax.imageio.ImageIO.read(url));
          } catch (Exception e) {
               System.out.println("SetImage: cannot find file '" + systemResource + "'");
          }
     }
}