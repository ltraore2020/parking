package fr.eni.ihm.controller;

import fr.eni.bll.PersonneBll;
import fr.eni.bo.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdatePersonController {
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private Button closeButton;

    private Personne personne;

    public void myFunction(Personne personne){
        this.personne = personne;
        tfNom.setText(personne.getNom());
        tfPrenom.setText(personne.getPrenom());
    }

    @FXML
    private void sendUpdate(ActionEvent actionEvent){
        try {
            boolean change = PersonneBll.update(new Personne(
                    this.personne.getId(), tfNom.getText(), tfPrenom.getText()
            ));
            if (change) cancel(actionEvent);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void cancel(ActionEvent actionEvent){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
