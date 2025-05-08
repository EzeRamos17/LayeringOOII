package ar.unrn.tp4.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    //        String url = "jdbc:derby://localhost:1527/participantes";
    private String url = "jdbc:mysql://localhost:3306/participantes_db";
    private String user = "root";
    private String password = "hernan123";

    Connection Open(){
        try {
            return DriverManager.getConnection(url, user, password);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
