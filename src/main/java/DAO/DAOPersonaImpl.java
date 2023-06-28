package DAO;

import Interfaces.DAOPersona;
import Models.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonaImpl extends Conection implements DAOPersona {

    @Override
    public void RegisterPerson(Persona persona) throws Exception {
        try {
            createConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO persona (nombre) VALUES (?) ");
            statement.setString(1,persona.getNombre());
            statement.executeUpdate();

        } catch (Exception e){
            throw e;
        } finally {
            closeConnection();
        }
    }
    @Override
    public void modifiedPerson(Persona persona) throws Exception {
        try {
            createConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE persona set nombre = ? where id = ?");
            statement.setString(1, persona.getNombre());
            statement.setInt(2,persona.getId());
            statement.executeUpdate();

        } catch (Exception e){
            throw e;
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Persona> listPerson() throws Exception {
        List<Persona> listPerson = new ArrayList<>();
        try {
            createConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM persona");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Persona persona = new Persona();
                persona.setId(resultSet.getInt("id"));
                persona.setNombre(resultSet.getString("nombre"));
                listPerson.add(persona);
            }

        } catch (Exception e){
            throw e;
        }
        return listPerson;
    }

    @Override
    public void deletedPerson(Persona persona) throws Exception {
        try {
            createConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE from persona where id = ?");
            statement.setInt(1,persona.getId());
            statement.executeUpdate();

        } catch (Exception e){
            throw e;
        } finally {
            closeConnection();
        }
    }


}
