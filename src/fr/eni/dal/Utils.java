package fr.eni.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlserver://DESKTOP-ADCSM32:1433;databaseName=Parking;user=student;password=student");
    }
}
