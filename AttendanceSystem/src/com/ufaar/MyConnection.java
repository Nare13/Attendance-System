package com.ufaar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    public static Connection connect() {
        Connection con = null;
        try {
            //This is for web
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "root", "nare.123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
