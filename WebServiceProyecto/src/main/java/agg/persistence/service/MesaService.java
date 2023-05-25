package agg.persistence.service;

import agg.dao.Mesa;
import agg.interfaces.MesaInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.MesaManager;

import java.sql.Connection;
import java.sql.SQLException;

public class MesaService implements MesaInterface {

    private MesaManager manager;
    private MySQLConnector mySQLConnector;

    public MesaService(MesaManager manager, MySQLConnector mySQLConnector){
        this.manager = manager;
        this.mySQLConnector = mySQLConnector;
    }

    @Override
    public Mesa getById(int id){

        try (Connection con = mySQLConnector.getMySQLConnection()) {

            return manager.getById(con, id);

        } catch (SQLException | ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }

}
