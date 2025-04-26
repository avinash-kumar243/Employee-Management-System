package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener {
    
    ImageIcon i1, i3;
    JLabel image, heading;
    JButton addEmp, updateEmp, removeEmp, viewEmp;
    
    Home() {
        
        setLayout(null); 
        
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
        add(image);
        
        heading = new JLabel("Employee Management System");
        heading.setBounds(480, 20, 350, 32);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        image.add(heading);
        
        // 4 Buttons 
        addEmp = new JButton("Add Employee");
        addEmp.setBounds(493, 70, 150, 26);
        addEmp.addActionListener(this);
        addEmp.setFont(new Font("Raleway", Font.BOLD, 13));
        image.add(addEmp);
        
        viewEmp = new JButton("View Employees");
        viewEmp.setBounds(665, 70, 153, 26);
        viewEmp.addActionListener(this);
        viewEmp.setFont(new Font("Raleway", Font.BOLD, 13));
        image.add(viewEmp);
        
        updateEmp = new JButton("Update Employee");
        updateEmp.setBounds(493, 110, 150, 26);
        updateEmp.addActionListener(this);
        updateEmp.setFont(new Font("Raleway", Font.BOLD, 13));
        image.add(updateEmp);
        
        removeEmp = new JButton("Remove Employee");
        removeEmp.setBounds(665, 110, 153, 26);
        removeEmp.addActionListener(this);
        removeEmp.setFont(new Font("Raleway", Font.BOLD, 13));
        image.add(removeEmp);
        
        removeEmp.setFocusPainted(false);
        viewEmp.setFocusPainted(false);
        updateEmp.setFocusPainted(false);
        addEmp.setFocusPainted(false);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(200, 80, 900, 600);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addEmp) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == viewEmp) {
            setVisible(false);
            new ViewEmployees();
        } else if (ae.getSource() == updateEmp) {
            String empId = JOptionPane.showInputDialog(this, "Enter Employee ID to Update:");
            if (empId != null && !empId.trim().isEmpty()) {
                setVisible(false);
                new UpdateEmployee(empId.trim());
            }
        } else if (ae.getSource() == removeEmp) {
            setVisible(false);
            new RemoveEmployee();
        }
    }
    
    public static void main(String args[]) {
        new Home();
    }
}
