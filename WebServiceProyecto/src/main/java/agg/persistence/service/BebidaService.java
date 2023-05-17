package agg.persistence.service;

import agg.dao.Productos.Bebida;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.BebidaManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BebidaService {

    private BebidaManager manager;

    public BebidaService( BebidaManager manager){
        this.manager = manager;
    }

    public List<Bebida> getAllDrinks(){

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return manager.getAllBebidas(con);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
