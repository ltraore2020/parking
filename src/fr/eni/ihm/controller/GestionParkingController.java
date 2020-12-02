package fr.eni.ihm.controller;

import fr.eni.bll.PersonneBll;
import fr.eni.bo.Personne;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionParkingController {

    public Label test;
    public TableColumn colNom;
    public TableColumn colPrenom;
    public TableView tablePersonne;

    public void initialize(){
        Personne personne = PersonneBll.get(1);
        test.setText(personne.getNom());

        colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));

        ObservableList<Personne> personneObservableList = FXCollections.observableArrayList();
        personneObservableList.addAll(PersonneBll.getAll());

        tablePersonne.setItems(personneObservableList);
    }
}
