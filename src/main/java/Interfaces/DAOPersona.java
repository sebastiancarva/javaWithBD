package Interfaces;

import Models.Persona;

import java.util.List;

public interface DAOPersona {

    void RegisterPerson(Persona persona) throws Exception;
    List<Persona> listPerson() throws Exception;
    void deletedPerson(Persona persona) throws Exception;
    void modifiedPerson(Persona persona) throws Exception;
}
