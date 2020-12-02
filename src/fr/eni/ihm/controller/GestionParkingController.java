package fr.eni.ihm.controller;

import fr.eni.dal.ParkingDal;
import javafx.scene.control.Label;

public class GestionParkingController {

    public Label test;

    public void initialize(){
        try {

            test.setText(ParkingDal.test());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
