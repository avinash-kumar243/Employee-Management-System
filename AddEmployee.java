package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class AddEmployee extends JFrame implements ActionListener {
    
    JLabel heading, name, fathername, dob, salary, address, phone, email, education, designation, adhar, id, myid;
    JTextField myname, myfathername, mysalary, myaddress, myphone, myemail, myeducation, mydesignation, myadhar;
    JButton addDetails, back;
    JDateChooser mydob;
    JComboBox educationalBox;

    
    public AddEmployee() {
        
        setLayout(null);
        
        heading = new JLabel("Add Employee Details");
        heading.setBounds(265, 40, 300, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        add(heading);
        
        name = new JLabel("Name");
        name.setBounds(70, 140, 80, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 17));
        add(name);
        
        myname = new JTextField();
        myname.setBounds(210, 140, 170, 30);
        myname.setFont(new Font("Raleway", Font.BOLD, 14));
        add(myname);
        
        fathername = new JLabel("Father's name");
        fathername.setBounds(450, 140, 120, 30);
        fathername.setFont(new Font("Raleway", Font.BOLD, 17));
        add(fathername);
        
        myfathername = new JTextField();
        myfathername.setBounds(600, 140, 170, 30);
        myfathername.setFont(new Font("Raleway", Font.BOLD, 14));
        add(myfathername);
        
        dob = new JLabel("Date of Birth");
        dob.setBounds(70, 185, 105, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 17));
        add(dob);
        
        mydob = new JDateChooser();
        mydob.setBounds(210, 185, 170, 30);
        mydob.setFont(new Font("Raleway", Font.BOLD, 14));
        mydob.setForeground(new Color(105, 105, 105));
        add(mydob);

        salary = new JLabel("Salary");
        salary.setBounds(450, 185, 120, 30);
        salary.setFont(new Font("Raleway", Font.BOLD, 17));
        add(salary);
        
        mysalary = new JTextField();
        mysalary.setBounds(600, 185, 170, 30);
        mysalary.setFont(new Font("Raleway", Font.BOLD, 14));
        add(mysalary);
        
        address = new JLabel("Address");
        address.setBounds(70, 230, 80, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 17));
        add(address);
        
        myaddress = new JTextField();
        myaddress.setBounds(210, 230, 170, 30);
        myaddress.setFont(new Font("Raleway", Font.BOLD, 14));
        add(myaddress);
        
        phone = new JLabel("Phone no.");
        phone.setBounds(450, 230, 120, 30);
        phone.setFont(new Font("Raleway", Font.BOLD, 17));
        add(phone);
        
        myphone = new JTextField();
        myphone.setBounds(600, 230, 170, 30);
        myphone.setFont(new Font("Raleway", Font.BOLD, 14));
        add(myphone);
        
        email = new JLabel("Email");
        email.setBounds(70, 275, 80, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 17));
        add(email);
        
        myemail = new JTextField();
        myemail.setBounds(210, 275, 170, 30);
        myemail.setFont(new Font("Raleway", Font.BOLD, 14));
        add(myemail);
        
        education = new JLabel("Education");
        education.setBounds(450, 275, 120, 30);
        education.setFont(new Font("Raleway", Font.BOLD, 17));
        add(education);

        String[] edu = {"NULL", "School", "Non graduation", "Graduation", "Post Graduation", "Doctorate", "Others"};
        educationalBox = new JComboBox(edu);
        educationalBox.setFont(new Font("Raleway", Font.BOLD, 14));
        educationalBox.setBounds(600, 275, 170, 30);
        educationalBox.setBackground(Color.WHITE);
        add(educationalBox);
        
        designation = new JLabel("Designation");
        designation.setBounds(70, 320, 105, 30);
        designation.setFont(new Font("Raleway", Font.BOLD, 17));
        add(designation);
        
        mydesignation = new JTextField();
        mydesignation.setBounds(210, 320, 170, 30);
        mydesignation.setFont(new Font("Raleway", Font.BOLD, 14));
        add(mydesignation);
        
        adhar = new JLabel("Adhar no.");
        adhar.setBounds(450, 320, 120, 30);
        adhar.setFont(new Font("Raleway", Font.BOLD, 17));
        add(adhar);
        
        myadhar = new JTextField();
        myadhar.setBounds(600, 320, 170, 30);
        myadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        add(myadhar);
        
        id = new JLabel("Id");
        id.setBounds(70, 365, 80, 25);
        id.setFont(new Font("Raleway", Font.BOLD, 17));
        add(id);
        
        Random rm = new Random();
        int num = rm.nextInt(999999);
        
        myid = new JLabel("" + num);
        myid.setBounds(210, 365, 60, 25);
        myid.setFont(new Font("Raleway", Font.BOLD, 17));
        add(myid);
        
        addDetails = new JButton("Add Details");
        addDetails.setBackground(Color.BLACK);
        addDetails.setForeground(Color.WHITE);
        addDetails.setFont(new Font("Raleway", Font.BOLD, 16));
        addDetails.setBounds(270, 470, 130, 30);
        addDetails.addActionListener(this);
        add(addDetails);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.addActionListener(this);
        back.setBounds(490, 470, 130, 30);
        add(back);
        
        setBounds(250, 60, 860, 610);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addDetails) {
            String name = myname.getText();
            String fname = myfathername.getText();
            String dob = ((JTextField) mydob.getDateEditor().getUiComponent()).getText();
            String salary = mysalary.getText();
            String address = myaddress.getText();
            String phone = myphone.getText();
            String email = myemail.getText();
            String education = (String) educationalBox.getSelectedItem();
            String designation = mydesignation.getText();
            String adharno = myadhar.getText();
            String employeeId = myid.getText();
            
            try {
                if(name.equals("") || fname.equals("") || dob.equals("") || salary.equals("") || address.equals("") || phone.equals("") || email.equals("") || education.equals("") || designation.equals("") || adharno.equals("") || employeeId.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all required details");
                }
                else {
                    Conn con = new Conn();
                    String query = "INSERT INTO employee VALUES('" + name + "', '" + fname + "', '" + dob + "', '" + salary + "', '" + address + "', '" + phone + "', '" + education + "', '" + email + "', '" + designation + "', '" + adharno + "', '" + employeeId + "')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Details saved successfully");
                    setVisible(false);
                    new Home();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[]) {
        new AddEmployee();
    }
}