package com.hdfc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        Connection con =null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testkc", "testkc", "testkc");
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
return con;
    }
}
