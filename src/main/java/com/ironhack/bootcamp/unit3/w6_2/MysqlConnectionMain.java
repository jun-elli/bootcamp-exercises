package com.ironhack.bootcamp.unit3.w6_2;

import java.sql.*;

public class MysqlConnectionMain {

    public static void main(String[] args) {
        try {
            // Crea la conexión a la base de datos
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irondb", "iron-user", "Ironhack_22");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select course_code, course_name from course");

            while (resultSet.next())
                System.out.println(
                        resultSet.getString(1) + "  " + resultSet.getString(2)
                );
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
