package fr.eni.dal;

import fr.eni.bo.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonneDal {

    public static String test(){
        try(Connection connection = Utils.getConnection()){
            return "connection établie";
        } catch (Exception e) {
            e.printStackTrace();
            return "default";
        }
    }

    private static final String GET_BY_ID = "SELECT * FROM Personnes WHERE idPersonne = ?";

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
}
