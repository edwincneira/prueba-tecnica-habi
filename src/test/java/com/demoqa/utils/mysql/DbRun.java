package com.demoqa.utils.mysql;

import java.sql.*;

import static com.demoqa.utils.mysql.User.*;

public class DbRun {

    Connection connect;

    public DbRun() {
        try {
            connect = DriverManager.getConnection(HOST,USER,PASSWORD);
            if (connect != null){
                System.out.println("Connect");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void run(String query) {
        DbRun db = new DbRun();
        Statement statement;
        ResultSet responseDb;
        try {
            statement = db.connect.createStatement();
            responseDb = statement.executeQuery(query);
            System.out.println(responseDb);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DbRun db = new DbRun();
        String query = "select * from users"; // Here change for your personal query
        db.run(query);
    }

}