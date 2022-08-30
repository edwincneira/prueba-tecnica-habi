package com.demoqa.utils.mysql;

import java.sql.*;

public class DbRun {

    private static Connection connection;
    private static final String USER = System.getenv("USER_DB_DEMOQA");
    private static final String PASSWORD = System.getenv("PASSWORD_DB_DEMOQA");
    private static final String HOST = System.getenv("HOST_DB_DEMOQA");

    public static Connection newConnection() {
        try {
            connection = null;
            connection = DriverManager.getConnection(HOST,USER,PASSWORD);
            if (connection != null){
                System.out.println("Connect");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void run(String query) throws SQLException, InterruptedException {
        Statement db = newConnection().createStatement();
        db.addBatch(query);
        Thread.sleep(2000);
        connection.close();
    }

}