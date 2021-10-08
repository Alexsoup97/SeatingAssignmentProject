import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EnrollmentSystem {
    private static ArrayList<Student> studentList = new ArrayList <Student>();
      
    public EnrollmentSystem() {
        generateJTable();
    }

    public static void generateJTable() {

        // create JFrame and JTable
        JFrame frame = new JFrame();
      
        // create a table model and set a Column Identifiers to this model
        Object[] columns = { "Name", "ID", "Cohort",
        "Friends" };
        DefaultTableModel model = new DefaultTableModel();
        //set columns header
        JTable table = new JTable(model);
        model.setColumnIdentifiers(columns);
    
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setForeground(Color.black);
        Font font = new Font("Calibri", Font.ITALIC, 15);
        table.setFont(font);
        table.setRowHeight(20);
        
        // create JTextFields to hold the value
         JTextField textName = new JTextField();
         JTextField textID = new JTextField();
         JTextField textCohort = new JTextField();
         JTextField textFriends = new JTextField();
        
        // create JButtons to add the action
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");
        
        textName.setBounds(20, 220, 150, 25);
        textID.setBounds(20, 250, 150, 25);
        textCohort.setBounds(20, 280, 150, 25);
        textFriends.setBounds(20, 310, 150, 25);
        
        btnAdd.setBounds(200, 220, 100, 25);
        btnUpdate.setBounds(200, 265, 100, 25);
        btnDelete.setBounds(200, 310, 100, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        // add JTextFields to the jframe
        frame.add(textName);
        frame.add(textID);
        frame.add(textCohort);
        frame.add(textFriends);
        
        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        
        // create an array of objects to set the row data
        Object[] data = new Object[4];
        
        // button add row - Clicked on Add Button
        btnAdd.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        data[0] = textName.getText();
        data[1] = Integer.valueOf(textID.getText());
        data[2] = textCohort.getText();
        data[3] = textFriends.getText();
        
        addStudent((String)data[0],(int)data[1], (String)data[2]);
        model.addRow(data);
        }
        });
        
        // button remove row - Clicked on Delete Button
        btnDelete.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        // i = the index of the selected row
        int i = table.getSelectedRow();
        removeStudent((int)model.getValueAt(i,1));


        if (i >= 0) {
        // remove a row from jtable
        model.removeRow(i);
        } else {
        System.out.println("Cannot delete");
        }
        }
        });
        
        // get selected row data From table to textfields
        table.addMouseListener(new MouseAdapter() {
        
        @Override
        public void mouseClicked(MouseEvent e) {
        
        // i = the index of the selected row
        int i = table.getSelectedRow();
        
        textName.setText(model.getValueAt(i, 0).toString());
        textID.setText(model.getValueAt(i, 1).toString());
        textCohort.setText(model.getValueAt(i, 2).toString());
        textFriends.setText(model.getValueAt(i, 3).toString());
        }
        });
        
        // button update row - Clicked on Update Button
        btnUpdate.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {

        displayStudents();
        
        // i = the index of the selected row
        int i = table.getSelectedRow();
        
        if (i >= 0) {
        model.setValueAt(textName.getText(), i, 0);
        model.setValueAt(textID.getText(), i, 1);
        model.setValueAt(textCohort.getText(), i, 2);
        model.setValueAt(textFriends.getText(), i, 3);
        } else {
        System.out.println("Update Error");
        }
        }
        });
        
        frame.setSize(900, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        }

    public static void addStudent(String name, int id, String cohort ) {  

        studentList.add(new Student(name, id, cohort));

    }

    public static void removeStudent(int id) {

        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getId() == id){
                studentList.remove(i);
            } 
        }



    }

    public  static void displayStudents() {

        for(Student s: studentList){

            System.out.println(s.getId());
        }
        
    }

      
}
