package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    
    JLabel empId, name, myname, phone, myphone, email, myemail, image;
    ImageIcon i1, i3;
    Image i2;
    Choice selectId;
    JButton delete, back;
    
    RemoveEmployee() {
        setLayout(null);
        
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 350, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        
        image = new JLabel(i3);
        image.setBounds(360, 10, 450, 350);
        add(image);
        
        empId = new JLabel("Employee Id");
        empId.setBounds(55, 50, 120, 30);
        empId.setFont(new Font("Raleway", Font.BOLD, 15));
        add(empId);
        
        selectId = new Choice();
        selectId.setBounds(190, 56, 130, 30);
        selectId.setBackground(Color.WHITE);
        add(selectId);
        
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                selectId.add(rs.getString("id"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
                
        name = new JLabel("Name");
        name.setBounds(55, 110, 120, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 15));
        add(name);
        
        myname = new JLabel();
        myname.setBounds(190, 110, 120, 30);
        myname.setFont(new Font("Raleway", Font.BOLD, 15));
        add(myname);
    
        phone = new JLabel("Phone");
        phone.setBounds(55, 170, 120, 30);
        phone.setFont(new Font("Raleway", Font.BOLD, 15));
        add(phone);
        
        myphone = new JLabel();
        myphone.setBounds(190, 170, 120, 30);
        myphone.setFont(new Font("Raleway", Font.BOLD, 15));
        add(myphone);
        
        email = new JLabel("Email");
        email.setBounds(55, 230, 120, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 15));
        add(email);
        
        myemail = new JLabel();
        myemail.setBounds(190, 230, 200, 30);
        myemail.setFont(new Font("Raleway", Font.BOLD, 15));
        add(myemail);
        
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM employee WHERE id = '"+selectId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                myname.setText(rs.getString("name"));
                myphone.setText(rs.getString("phone"));
                myemail.setText(rs.getString("email"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        selectId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "SELECT * FROM employee WHERE id = '"+selectId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        myname.setText(rs.getString("name"));
                        myphone.setText(rs.getString("phone"));
                        myemail.setText(rs.getString("email"));
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(100, 300, 80, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
                
        back = new JButton("Back");
        back.setBounds(220, 300, 80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setBounds(250, 150, 840, 380);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "DELETE FROM employee WHERE id = '"+selectId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information deleted successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
        new RemoveEmployee();
    }
}
