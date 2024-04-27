package com.hdfc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection con =null;
    public static Connection getConnection() {
   ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testkc", "testkc", "testkc");
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
return con;
    }

    public static void closeConnection() throws SQLException {
        if(con!=null){
            con.close();
        }
    }
}
