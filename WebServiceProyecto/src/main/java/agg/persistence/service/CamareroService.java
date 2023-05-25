package agg.persistence.service;

import agg.dao.Camarero;
import agg.interfaces.CamareroInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.CamareroManager;

import java.sql.Connection;
import java.sql.SQLException;

public class CamareroService implements CamareroInterface {

    private CamareroManager manager;
    private MySQLConnector mySQLConnector;

    public CamareroService(CamareroManager manager, MySQLConnector mySQLConnector){
        this.manager = manager;
        this.mySQLConnector = mySQLConnector;
    }

    @Override
    public Camarero getCamareroByUserAndPassword(String user, String password){

        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return manager.getCamareroByUserAndPassword(con, user, password);
        } catch (SQLException | ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public Camarero getById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {

            return manager.getById(con, id);
        } catch (SQLException | ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }
}