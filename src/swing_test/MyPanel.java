
package swing_test;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
private String filename;
    public MyPanel(LayoutManager ob,String filename) {
        super(ob);
        this.filename=filename;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        try {
            g.drawImage(ImageIO.read(new FileInputStream(this.filename)), 0, 0, this.getWidth(), this.getHeight(), null);
                    } catch (IOException ex) {
            Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
