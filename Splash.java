package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;    

public class Splash extends JFrame implements ActionListener {
    
    JLabel text;
    JButton click;
    ImageIcon i1, i3;
    
    Splash() {
        
        setLayout(null);
        
        text = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        text.setBounds(85, 20, 890, 55);
        text.setFont(new Font("Serif", Font.PLAIN, 45));
        text.setForeground(Color.RED);
        add(text);
        
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 680, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60, 82, 815, 450);
        add(image);
        
        click = new JButton("Click here to continue");
        click.setBounds(300, 365, 240, 50);
        click.setFocusPainted(false);
        click.setFont(new Font("Syetem", Font.BOLD, 19));
        click.addActionListener(this);
        image.add(click);
        
        setSize(930, 600);
        getContentPane().setBackground(Color.WHITE);
        setLocation(170, 70);
        //setUndecorated(true);
        setVisible(true);
        
        while(true) {
            text.setVisible(false);
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            
            text.setVisible(true);
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == click) {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[]) {
        new Splash();
    }
}
