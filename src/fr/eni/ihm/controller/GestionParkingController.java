package fr.eni.ihm.controller;

import fr.eni.bll.PersonneBll;
import fr.eni.bo.Personne;
import javafx.scene.control.Label;

public class GestionParkingController {

    public Label test;

    public void initialize(){
        try {
            Personne personne = PersonneBll.get(1);

            test.setText(personne.getNom());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
