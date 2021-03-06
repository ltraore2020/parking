package fr.eni.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        String myConnection = ParkingDal.test();
        Parent root = FXMLLoader.load( getClass().getResource("GestionParking.fxml") );
        stage.setTitle("Gestion Parking");
        stage.setScene( new Scene(root, 600, 400));
        stage.show();
    }
}
