package mcbx.jb.classes.mycollection;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JDesktopPane;

public class DesktopPane extends JDesktopPane {

    public Image img;

    public Image getImg() {
        return img;
    }

    private void setImg(Image img) {
        this.img = img;
    }
    
    public DesktopPane(String systemResource) {
        try {
            java.net.URL url = ClassLoader.getSystemResource(systemResource);
            this.setImg(javax.imageio.ImageIO.read(url));
        } catch (Exception e) {
            System.err.println("SetImage: cannot find file '" + systemResource + "'");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.img != null) {
            g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
        } else {
            g.drawString("Image not found", 10, 50);
        }
    }
}