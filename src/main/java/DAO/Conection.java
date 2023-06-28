package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conection {

    protected Connection connection;

    private final String JDBC_DRIVER = "org.postgresql.Driver";
    private final String BD = "jdbc:postgresql://localhost:5433/ejemplo2";
    private final String USER = "postgres";
    private final String PASS = "9908";

    public void createConnection () throws Exception {

        try {
            connection = DriverManager.getConnection(BD,USER,PASS);
            Class.forName(JDBC_DRIVER);
        } catch (Exception e){
            throw e;
        }

    }

    public void closeConnection () throws Exception {

        if ( connection != null ){
            if( !connection.isClosed() ){
                connection.close();
            }
        }

    }

}
