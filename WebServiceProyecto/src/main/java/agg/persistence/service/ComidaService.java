package agg.persistence.service;

import agg.dao.Productos.Comida;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComidaManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComidaService {

    private ComidaManager manager;

    public ComidaService(ComidaManager manager){

        this.manager = manager;
    }

    public ArrayList<Comida> getAllFood(){

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return manager.getAllFood(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Comida getOneById(int id){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return manager.getOneById(con, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
