package agg.persistence.service;

import agg.dao.Productos.Comida;
import agg.interfaces.ProductoInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComidaManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComidaService implements ProductoInterface {

    private ComidaManager manager;
    private MySQLConnector mySQLConnector;

    public ComidaService(ComidaManager manager, MySQLConnector mySQLConnector){
        this.manager = manager;
        this.mySQLConnector = mySQLConnector;
    }

    @Override
    public ArrayList<Comida> getAll(){

        try (Connection con = mySQLConnector.getMySQLConnection()) {

            return manager.getAll(con);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Comida getById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return manager.getById(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
