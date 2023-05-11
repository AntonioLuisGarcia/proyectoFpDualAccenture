package agg.persistence.service;


import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.CamareroManager;

import java.sql.Connection;
import java.sql.SQLException;

public class CamareroService {

    private MySQLConnector connector;
    private CamareroManager manager;

    public CamareroService(MySQLConnector connector, CamareroManager manager){
        this.connector = connector;
        this.manager = manager;
    }

    public boolean verificateUserByUserAndPassword(String user, String password){
        Connection con = null;

        try{
            con = connector.getMySQLConnection();

            return manager.verificateUserByUserAndPassword(con, user, password);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }
}