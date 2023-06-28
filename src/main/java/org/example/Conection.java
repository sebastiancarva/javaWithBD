package org.example;

import DAO.DAOPersonaImpl;
import Interfaces.DAOPersona;
import Models.Persona;



public class Conection {

    public static void main(String[] args)  {

     // Persona persona = new Persona();
      //persona.setId(11);
        try {
            DAOPersona daoPersona = new DAOPersonaImpl();
            for (Persona persona:daoPersona.listPerson() ) {
                System.out.println("Nombre: " + persona.getNombre() + " Id " + persona.getId());
            }

        } catch (Exception e) {
            System.out.println("Se produjo el error: " + e.getMessage());
        }


    }


}