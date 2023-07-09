package com.todo;

import java.io.IOException;
import java.sql.*;


public class putData {

    public static void main(String[] args) {
       
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoList","root","root")) {
            String sql = "SELECT * FROM tasks";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date date = resultSet.getDate("date");
                String taskDescription = resultSet.getString("task");
                boolean status = resultSet.getBoolean("status");

                System.out.println("ID: " + id);
                System.out.println("Date: " + date);
                System.out.println("Task: " + taskDescription);
                System.out.println("Status: " + status);
                System.out.println("--------------------------");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
