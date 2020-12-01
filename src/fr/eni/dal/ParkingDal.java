package fr.eni.dal;

import java.sql.Connection;

public class ParkingDal {

    public static void test(){
        try(Connection connection = Utils.getConnection()){
            System.out.println("Connection établie");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
