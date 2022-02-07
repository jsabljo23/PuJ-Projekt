package com.example.carbuypuj;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConn {

    public Connection conn;

    public Connection getConnection(){

        String dbName = "PUJCarBuy";
        String dbUser = "root";
        String dbPassword = "";
        String dbUrl = "jdbc:mysql://localhost/" + dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }
}
