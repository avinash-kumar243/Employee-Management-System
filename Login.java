package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JLabel username, password, image;
    JTextField userText;
    JPasswordField passText;
    JButton login;
    ImageIcon i1, i3;
    
    Login() {
        
        setLayout(null);
        
        username = new JLabel("Username");
        username.setBounds(45, 75, 100, 22);
        username.setFont(new Font("Raleway", Font.BOLD, 18));
        add(username);
        
        userText = new JTextField();
        userText.setBounds(180, 74, 160, 25);
        userText.setFont(new Font("Raleway", Font.BOLD, 16));
        add(userText);
        
        password = new JLabel("Password");
        password.setBounds(45, 130, 100, 22);
        password.setFont(new Font("Raleway", Font.BOLD, 18));
        add(password);
        
        passText = new JPasswordField();
        passText.setBounds(180, 129, 160, 25);
        passText.setFont(new Font("Raleway", Font.BOLD, 16));
        add(passText);
        
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(240, 240, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        
        image = new JLabel(i3);
        image.setBounds(380, 30, 200, 200);
        add(image);
        
        login = new JButton("Login");
        login.setBounds(180, 205, 160, 30);
        login.setFont(new Font("Raleway", Font.BOLD, 18));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        setBounds(370, 180, 630, 360);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String user = userText.getText();
            String pass = new String(passText.getPassword());  
            
            Conn c = new Conn();
            
            String query = "SELECT * FROM login WHERE BINARY username = '"+user+"' AND BINARY password = '"+pass+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                // next work in next class
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid user name or password");
                setVisible(false);
                new Login();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
