package fr.eni.bll;

import fr.eni.bo.Personne;
import fr.eni.dal.PersonneDal;

public class PersonneBll {
    public static Personne get(int id){ return PersonneDal.get(id); }
}
