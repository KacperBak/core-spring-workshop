package org.example.examples;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

/**
 * User: chb
 */
public class JDBCExample {


    public static void main(String a[]){

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@<hostname>:<port num>:<DB name>"
                    , "user", "password");
            Statement stmt = con.createStatement();
            System.out.println("Created DB Connection....");
            ResultSet rs = stmt.executeQuery("select name, age from Person");
            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
            }
            rs.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
