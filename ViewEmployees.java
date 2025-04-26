package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class ViewEmployees extends JFrame implements ActionListener {
    
    JTable table;
    Choice cemployeeId;
    JButton search, update, print, back;
    
    ViewEmployees() {
        
        setLayout(null);
        
        JLabel searchLbl = new JLabel("Search by Employee Id");
        searchLbl.setBounds(40, 30, 200, 30);
        searchLbl.setFont(new Font("Raleway", Font.BOLD, 16));
        add(searchLbl);
        
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(250, 37, 200, 30);
        cemployeeId.setBackground(Color.WHITE);
        add(cemployeeId);
        
        search = new JButton("Search");
        search.setBounds(40, 75, 85, 25);
        search.addActionListener(this);
        add(search);
        
        update = new JButton("Update");
        update.setBounds(140, 75, 85, 25);
        update.addActionListener(this);
        add(update);
        
        print = new JButton("Print");
        print.setBounds(240, 75, 85, 25);
        print.addActionListener(this);
        add(print);
        
        back = new JButton("Back");
        back.setBounds(340, 75, 85, 25);
        back.addActionListener(this);        
        add(back);
                
        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT * FROM employee");
            
            while(rs.next()) {
                cemployeeId.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
                
        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 115, 1000, 615);
        add(jsp);
               
        setBounds(150, 20, 1000, 710);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == search) {
            String query = "SELECT * FROM employee WHERE id = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn con = new Conn();
                ResultSet rs = con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
        new ViewEmployees();
    }
}
