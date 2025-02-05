import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlconnectorEmpdata {
    public static void main(String[] args) {
        // Database URL, username, and password
        final String DB_URL = "jdbc:mysql://localhost:3306/EmployeeInformation";
        final String USER = "root";
        final String PASSWORD = "mHASAs@&@2006";

        // SQL INSERT query
        String insertQuery = "INSERT INTO employees (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        // Employee data
        int[][] employeeData = {
                {101, 25, 10000},
                {102, 30, 20000},
                {103, 20, 40000},
                {104, 40, 80000},
                {105, 25, 90000}
        };

        String[] employeeNames = {"Jenny", "Jacky", "Joe", "John", "Shameer"};

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            for (int i = 0; i < employeeData.length; i++) {
                pstmt.setInt(1, employeeData[i][0]);
                pstmt.setString(2, employeeNames[i]);
                pstmt.setInt(3, employeeData[i][1]);
                pstmt.setInt(4, employeeData[i][2]);
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
