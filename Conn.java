package employee.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn () {
        // 5 steps for JDBC
        
        // step 1 : register the driver class
        // step 2 : creating the connection string
        // step 2 : create statement
        // step 2 : execute mysql queries
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "Abhishek@@11");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}