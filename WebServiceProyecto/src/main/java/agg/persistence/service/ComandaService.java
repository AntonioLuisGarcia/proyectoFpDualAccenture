package agg.persistence.service;

import agg.dao.Comanda;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComandaManager;

import java.sql.Connection;
import java.sql.SQLException;

public class ComandaService {
    private ComandaManager comandaManager;

    public ComandaService(ComandaManager comandaManager){
        this.comandaManager = comandaManager;
    }

    public Comanda getById(int id){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return comandaManager.getComandaById(con, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int createComanda(int idMesa, int idCamarero){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return comandaManager.createComanda(con, idMesa, idCamarero);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
