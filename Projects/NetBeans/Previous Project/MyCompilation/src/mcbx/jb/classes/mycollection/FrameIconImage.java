package mcbx.jb.classes.mycollection;

import java.awt.Image;
import java.awt.Toolkit;

public final class FrameIconImage {

     public Image img;

     public Image getImg() {
          return img;
     }

     public void setImg(Image img) {
          this.img = img;
     }

     public FrameIconImage(String systemResournce) {
          try {
               java.net.URL url = ClassLoader.getSystemResource(systemResournce);
               Toolkit kit = Toolkit.getDefaultToolkit();
               this.setImg(kit.createImage(url));
          } catch (Exception e) {
               System.out.println(e);
          }
     }
}
