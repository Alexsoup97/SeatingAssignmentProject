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

public class SystemManager extends JFrame {
    
    private EnrollmentSystem enrollSystem = new EnrollmentSystem();

    JFrame thisFrame;
  
  //Constructor - this runs first
   SystemManager() { 
    super("Start Screen");
    this.thisFrame = this; 
    JPanel mainPanel = new BackgroundPanel();

    
    //configure the window
    this.setSize(1325, 750);    
    this.setLocationRelativeTo(null); //start the frame in the center of the screen
    this.setResizable (false);
    
    //Create a JButton for the centerPanel
    JButton startButton = new JButton("PLAY");
    startButton.setPreferredSize(new Dimension(240, 50));
    startButton.setBackground(new Color(0, 0, 0, 0)); // button color
    startButton.addActionListener(new StartButtonListener(this,1));
    
    //Create a JButton for the centerPanel
    JButton instButton = new JButton("INSTRUCTIONS");
    instButton.setPreferredSize(new Dimension(240, 50));
    instButton.setBackground(new Color(0, 0, 0, 0));
    instButton.addActionListener(new StartButtonListener(this,2));
 
    //Create a JButton for the centerPanel
    JButton exitButton = new JButton("EXIT");
    exitButton.setPreferredSize(new Dimension(240, 50));
    exitButton.addActionListener(new StartButtonListener(this,3));

    
    //Add all panels to the mainPanel according to border layout
    //mainPanel.add(startButton);
    //mainPanel.add(instButton); 
    mainPanel.add(exitButton); 
    
    //add the main panel to the frame
    this.add(mainPanel);
   
    this.setVisible(true);
    
    this.requestFocusInWindow();
  }

    public static void main(String[] args) {

        new SystemManager();


        
    }

    class BackgroundPanel extends JPanel { 
        //variables
        private BufferedImage background;
        /**
         * BackgroundPanel constructor
         */
        BackgroundPanel(){

        }
          

      /**
       * paintComponent 
       * draws the background image
       * @param g, Graphics
       */
        public void paintComponent(Graphics g) {   
          super.paintComponent(g); //required
          setDoubleBuffered(true); 
          g.drawRect(0,10, 100, 200);
        }
      } 
    
}
