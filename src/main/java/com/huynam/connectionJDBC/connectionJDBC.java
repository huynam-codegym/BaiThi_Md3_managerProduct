package com.huynam.connectionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionJDBC {
    private static Connection connection;

    public static final String URL = "jdbc:mysql://localhost:3306/managerproduct";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static Connection getConnection(){
        if(connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
                System.out.println("Connect success!");
            } catch (ClassNotFoundException | SQLException e){
                System.out.println("Connect MYSQL failed!");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
