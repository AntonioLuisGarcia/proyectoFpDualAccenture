package agg.persistence.service;

import agg.dao.Productos.Bebida;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.BebidaManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class BebidaService {

    private MySQLConnector connector;
    private BebidaManager manager;

    public BebidaService(MySQLConnector connector, BebidaManager manager){
        this.connector = connector;
        this.manager = manager;
    }

    public ArrayList<Bebida> getAllFood(){
        Connection con = null;

        try{
            con = connector.getMySQLConnection();

            return manager.getAllBebidas(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
