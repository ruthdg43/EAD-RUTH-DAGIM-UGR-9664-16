
package com.jdbc;

import java.sql.*;

public class StudentDatabaseOperations {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/StudentsDB";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("firstname") + " " +
                    rs.getString("lastname") + " " +
                    rs.getInt("grade")
                );
            }

            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
