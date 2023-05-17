package agg.persistence.service;


import agg.dao.Camarero;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.CamareroManager;

import java.sql.Connection;
import java.sql.SQLException;

public class CamareroService {

    private CamareroManager manager;

    public CamareroService(CamareroManager manager){
        this.manager = manager;
    }

    public Camarero verificateUserByUserAndPassword(String user, String password){


        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return manager.getCamareroByUserAndPassword(con, user, password);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }

    public Camarero getById(int id){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return manager.getById(con, id);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }
}