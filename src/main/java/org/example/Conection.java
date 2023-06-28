package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conection {

    public static void main(String[] args) {
        conectionBD();
    }

    public static void conectionBD(){

        //variables
        String jdbcDriver = "org.postgresql.Driver";
        String BD = "jdbc:postgresql://localhost:5433/ejemplo2";
        String user = "postgres";
        String pass = "9908";

        try (Connection connection = DriverManager.getConnection(BD,user,pass)) {

            Class.forName(jdbcDriver);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO persona (nombre) values ('Hoyos')");
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {

            System.out.println("Se produjo un error al intentar conectar con la BD" + e.getMessage());

        }

    }

}