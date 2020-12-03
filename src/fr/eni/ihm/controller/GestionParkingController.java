package fr.eni.ihm.controller;

import fr.eni.bll.PersonneBll;
import fr.eni.bo.Personne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionParkingController {

    @FXML
    private TableColumn colNom;
    @FXML
    private TableColumn colPrenom;
    @FXML
    private TableView tablePersonne;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;

    @FXML
    private void initialize(){

        colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));

        ObservableList<Personne> personneObservableList = FXCollections.observableArrayList();
        personneObservableList.addAll(PersonneBll.getAll());

        tablePersonne.setItems(personneObservableList);
    }

    @FXML
    private void addPerson(ActionEvent actionEvent){
        try {
            boolean change = PersonneBll.insert(new Personne(
                    tfNom.getText(), tfPrenom.getText()
            ));
            if (change) initialize();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void removePerson(ActionEvent actionEvent){
        try {
            // TODO Check if row selected
            Personne personne = (Personne) tablePersonne.getSelectionModel().getSelectedItem();
            boolean change = PersonneBll.delete(personne);
            if (change) initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updatePerson(ActionEvent actionEvent){

        try {
            // TODO Check if row selected
            Personne personne = (Personne) tablePersonne.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../UpdatePerson.fxml"));
            Parent root = (Parent) loader.load();
            UpdatePersonController c2 = loader.getController();
            c2.myFunction(personne);
            Stage alertBox = new Stage();
            alertBox.initModality(Modality.APPLICATION_MODAL);
            alertBox.setScene(new Scene(root));
            alertBox.showAndWait();
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
