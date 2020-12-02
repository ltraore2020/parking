package fr.eni.dal;

import java.sql.Connection;

public class ParkingDal {

    public static String test(){
        try(Connection connection = Utils.getConnection()){
            return "connection établie";
        } catch (Exception e) {
            e.printStackTrace();
            return "default";
        }
    }
}
