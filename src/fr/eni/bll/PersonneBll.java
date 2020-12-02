package fr.eni.bll;

import fr.eni.bo.Personne;
import fr.eni.dal.PersonneDal;

import java.util.List;

public class PersonneBll {

    public static Personne get(int id){ return PersonneDal.get(id); }

    public static List<Personne> getAll(){ return PersonneDal.getAll(); }

}
