import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SystemManager extends JFrame {

  
    
    private static EnrollmentSystem enrollSys = new EnrollmentSystem();

   

  

   

    JFrame thisFrame;

   SystemManager() { 
    super("Seating Assignment Manager");
  


    this.thisFrame = this; 
    JPanel mainPanel = new MainPanel();

    
    //configure the window
    this.setSize(900, 400);    
    this.setLocationRelativeTo(null); //start the frame in the center of the screen
    this.setResizable (false);
    
    //Create a JButton for the centerPanel
    JButton enrollButton = new JButton("Enrollment System");
    enrollButton.setPreferredSize(new Dimension(240, 50));
    enrollButton.setBackground(new Color(0, 0, 0, 0)); // button color

    enrollButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) { 
        thisFrame.dispose();
        new EnrollmentSystemPanel(enrollSys);

      }

    });
    
    //Create a JButton for the centerPanel
    JButton instButton = new JButton("Floor Plan System");
    instButton.setPreferredSize(new Dimension(240, 50));
    instButton.setBackground(new Color(0, 0, 0, 0));
    instButton.addActionListener(new StartButtonListener(this,2));
 
    //Create a JButton for the centerPanel
    JButton exitButton = new JButton("Seating Arrangment System");
    exitButton.setPreferredSize(new Dimension(240, 50));
    exitButton.addActionListener(new StartButtonListener(this,3));

    
    mainPanel.add(enrollButton);
    mainPanel.add(instButton); 
    mainPanel.add(exitButton); 
    
    //add the main panel to the frame
   
    this.add(mainPanel);
    
   
    this.setVisible(true);
    
    this.requestFocusInWindow();
  }

    public static void main(String[] args) {

     

        new SystemManager();


        
    }


    class MainPanel extends JPanel { 

        public void paintComponent(Graphics g) {   
          super.paintComponent(g); //required
          setDoubleBuffered(true);
        }
      } 
    
}