package agg.persistence.service;

import agg.dao.Camarero;
import agg.dao.Mesa;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.CamareroManager;
import agg.persistence.manager.MesaManager;

import java.sql.Connection;
import java.sql.SQLException;

public class MesaService {

    private MySQLConnector connector;
    private MesaManager manager;

    public MesaService(MySQLConnector connector, MesaManager manager){
        this.connector = connector;
        this.manager = manager;
    }

    public Mesa verificateUserByUserAndPassword(int number){
        Connection con = null;

        try{
            con = connector.getMySQLConnection();

            return manager.getMesaWithNumber(con, number);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }

}
