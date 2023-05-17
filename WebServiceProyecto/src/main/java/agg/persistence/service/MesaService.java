package agg.persistence.service;

import agg.dao.Mesa;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.MesaManager;

import java.sql.Connection;
import java.sql.SQLException;

public class MesaService {

    private MesaManager manager;

    public MesaService(MesaManager manager){
        this.manager = manager;
    }

    public Mesa getById(int id){

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return manager.getMesaByNumber(con, id);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }

}
