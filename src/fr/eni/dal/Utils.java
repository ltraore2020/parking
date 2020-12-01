package fr.eni.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
    public static Connection getConnection() throws SQLException{
        String connection = "jdbc:sqlserver://DESKTOP-ADCSM32\\SQLSERVER:1433;";
                //"databaseName=parking;user=student;password=student";
        return DriverManager.getConnection(connection, "student", "student");
    }
}
