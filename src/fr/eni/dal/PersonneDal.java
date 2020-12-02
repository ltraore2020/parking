package fr.eni.dal;

import fr.eni.bo.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonneDal {

    private static final String GET_BY_ID = "SELECT * FROM Personnes WHERE idPersonne = ?";
    private static final String GET_ALL = "SELECT * FROM Personnes";

    public static Personne get(int id){

        Personne result = null;

        try (Connection connection = Utils.getConnection()){

            PreparedStatement request = connection.prepareStatement(GET_BY_ID);
            request.setInt(1, id);
            ResultSet response = request.executeQuery();

            if(response.next()){
                result = new Personne();
                result.setId(response.getInt("idPersonne"));
                result.setNom(response.getString("nom"));
                result.setPrenom(response.getString("prenom"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static List<Personne> getAll(){
        List<Personne> personnes = new ArrayList<>();

        try(Connection connection = Utils.getConnection()){

            PreparedStatement request = connection.prepareStatement(GET_ALL);
            ResultSet response = request.executeQuery();

            while (response.next()){
                personnes.add( new Personne(
                        response.getInt("idPersonne"),
                        response.getString("nom"),
                        response.getString("prenom")
                ));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return personnes;
     }
}
