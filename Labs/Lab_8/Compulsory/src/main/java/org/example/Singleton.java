package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Singleton {
    public class Database {
        private static final String URL =
                "jdbc:phpmyadmin://localhost:3306/javabd";
        private static final String USER = "root@localhost";
        private static final String PASSWORD = "password";
        private static Connection connection = null;
        private Database() {}
        public static Connection getConnection() {
            return connection;
        }
        private static void createConnection() {
            try {
                //Connection = TODO
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        public static void closeConnection() { TODO }
}
