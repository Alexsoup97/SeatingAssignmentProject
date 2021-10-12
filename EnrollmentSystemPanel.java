import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

/**
 * [EnrollmentSystemPanel.java]
 * 
 * @author 
 * @version 1.0 
**/

public class EnrollmentSystemPanel {

    private static EnrollmentSystem sys;

    public EnrollmentSystemPanel(EnrollmentSystem system) {
        sys = system;
        generateJTable();
    }

    public static void generateJTable() {
        // create JFrame and JTable
        JFrame frame = new JFrame();

        // create JTextFields to hold the value
        JTextField textName = new JTextField();
        JTextField textID = new JTextField();
        JTextField textCohort = new JTextField();
       // JTextField textFriends = new JTextField();

        // create JButtons to add the action
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");
        JButton btnBack = new JButton("Back");

        JLabel errorMessage = new JLabel();
        errorMessage.setForeground(Color.red);
        errorMessage.setFont(new Font("Calibri", Font.BOLD, 25));

        JComboBox<String> friendPrefOne = new JComboBox<String>(sys.getStudentNames());
        JComboBox<String> friendPrefTwo = new JComboBox<String>(sys.getStudentNames());
        JComboBox<String> friendPrefThree = new JComboBox<String>(sys.getStudentNames());
    

        errorMessage.setBounds(350, 250, 300, 25);

        textName.setBounds(20, 205, 150, 25);
        textID.setBounds(20, 237, 150, 25);
        textCohort.setBounds(20, 270, 150, 25);
        friendPrefOne.setBounds(370, 205, 150,25);
        friendPrefTwo.setBounds(540, 205, 150,25);
        friendPrefThree.setBounds(710, 205, 150,25);
       // textFriends.setBounds(20, 300, 150, 25);

        btnBack.setBounds(20, 330, 100, 25);
        btnAdd.setBounds(200, 205, 100, 25);
        btnUpdate.setBounds(200, 237, 100, 25);
        btnDelete.setBounds(200, 270, 100, 25);

        frame.setLayout(null);
        frame.add(sys.getPane());
        frame.add(friendPrefOne);
        frame.add(friendPrefTwo);
        frame.add(friendPrefThree);
    

        // add JTextFields to the jframe
        frame.add(textName);
        frame.add(textID);
        frame.add(textCohort);
        //frame.add(textFriends);
        frame.add(errorMessage);

        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnBack);

        // create an array of objects to set the row data
        Object[] data = new Object[4];
        // button add row - Clicked on Add Button
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    data[0] = textName.getText();
                    data[1] = Integer.valueOf(textID.getText());
                    data[2] = textCohort.getText();

                    data[3] = "";
                
                    if(friendPrefOne.getSelectedItem() != null){
                        data[3] +=  friendPrefOne.getSelectedItem() + ", ";
                    }

                    if(friendPrefTwo.getSelectedItem() != null){
                        data[3] +=  friendPrefTwo.getSelectedItem() + ", ";
                    }
                    if(friendPrefThree.getSelectedItem() != null){
                        data[3] +=  friendPrefThree.getSelectedItem() + ", ";
                    }


                    
                   // data[3] = textFriends.getText();
                    textName.setText("");
                    textID.setText("");
                    textCohort.setText("");
                   // textFriends.setText("");
                    sys.addStudent(data);
                } catch (NumberFormatException a) {
                    // data[0]=null;
                    // data[1]=null;
                    // data[2]=null;
                    // data[3]=null;
                    for (int i = 0; i < 4; i++) {
                        data[i] = null;
                    }
                    // for(Object objects: data){
                    //     objects == null;
                    // }   
                    errorMessage.setText("Incorrect Inputs");
                    clearErrorMessage(errorMessage);
                }
            }
        });

        // button remove row - Clicked on Delete Button
        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // i = the index of the selected row
                int i = sys.getRow();

                if (i >= 0) {
                    // remove a row from jtable
                    //removeStudent((int)model.getValueAt(i,1));
                    sys.removeStudent(i);
                    textName.setText("");
                    textID.setText("");
                    textCohort.setText("");
                    //textFriends.setText("");
                } else {
                    errorMessage.setText("Please select a valid row");
                    clearErrorMessage(errorMessage);
                }
            }
        });

        // get selected row data From table to textfields
        sys.table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // i = the index of the selected row
                int i = sys.getRow();
                textName.setText(sys.getValue(i, 0));
                textID.setText(sys.getValue(i, 1));
                textCohort.setText(sys.getValue(i, 2));
              //  textFriends.setText(sys.getValue(i, 3));
            }
        });

        // button update row - Clicked on Update Button
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudents();
                // i = the index of the selected row
                int i = sys.getRow();
                if (i >= 0) {
                    try {
                        data[0] = textName.getText();
                        data[1] = Integer.valueOf(textID.getText());
                        data[2] = textCohort.getText();
                       // data[3] = textFriends.getText();
                        sys.updateStudent(i, data);
                    } catch (NumberFormatException a) {
                        errorMessage.setText("Inccorect Inputs");
                        clearErrorMessage(errorMessage);
                    }
                } else {
                    errorMessage.setText("Please select a valid row");
                    clearErrorMessage(errorMessage);
                }
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new SystemManager();
            }
        });
        frame.setSize(900, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void clearErrorMessage(JLabel errorMessage) {
        //if you spam update error, the timer doesnt work
        Timer timer = new Timer(2500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorMessage.setText("");
            }
        });

        timer.start();
        timer.setRepeats(false);
    }

    public static void displayStudents() {
        for (Student s: sys.getStudentList()) {
            System.out.println(s.getId());
        }
    }
}