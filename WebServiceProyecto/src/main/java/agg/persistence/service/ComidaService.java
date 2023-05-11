package agg.persistence.service;

import agg.dao.Productos.Comida;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComidaManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComidaService {

    private MySQLConnector connector;
    private ComidaManager manager;

    public ComidaService(MySQLConnector connector, ComidaManager manager){
        this.connector = connector;
        this.manager = manager;
    }

    public ArrayList<Comida> getAllFood(){
        Connection con = null;

        try{
            con = connector.getMySQLConnection();

            return manager.getAllFood(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
