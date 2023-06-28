package org.example;

import Models.Persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Conection {

    public static void main(String[] args) {

        String name = requestName();
        conectionBD(name);

    }

    public static String requestName(){
        System.out.println("Introduce tu Nombre ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        return name;
    }

    public static void conectionBD(String name){

        //variables
        String jdbcDriver = "org.postgresql.Driver";
        String BD = "jdbc:postgresql://localhost:5433/ejemplo2";
        String user = "postgres";
        String pass = "9908";

        try (Connection connection = DriverManager.getConnection(BD,user,pass)) {

            Class.forName(jdbcDriver);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO persona (nombre) values (?)");
            statement.setString(1,name);
            statement.executeUpdate();
            statement.close();
            System.out.println("Se agrego exitosamente a: " + name);



        } catch (Exception e) {

            System.out.println("Se produjo un error al intentar conectar con la BD" + e.getMessage());

        }

    }

}