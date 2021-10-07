import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class TestPanel extends JPanel {
    public void paintComponent(Graphics g) {   
        super.paintComponent(g); //required
        setDoubleBuffered(true);

        g.drawRect(0,0, 100, 200);
        System.out.print("Test");
      }
  }