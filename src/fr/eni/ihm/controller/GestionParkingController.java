package fr.eni.ihm.controller;

import fr.eni.bll.PersonneBll;
import fr.eni.bo.Personne;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionParkingController {

    public TableColumn colNom;
    public TableColumn colPrenom;
    public TableView tablePersonne;
    public TextField tfNom;
    public TextField tfPrenom;

    public void initialize(){

        colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));

        ObservableList<Personne> personneObservableList = FXCollections.observableArrayList();
        personneObservableList.addAll(PersonneBll.getAll());

        tablePersonne.setItems(personneObservableList);
    }

    public void addPerson(ActionEvent actionEvent){
        try {
            PersonneBll.insert(new Personne(
                tfNom.getText(), tfPrenom.getText()
            ));
            initialize();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
