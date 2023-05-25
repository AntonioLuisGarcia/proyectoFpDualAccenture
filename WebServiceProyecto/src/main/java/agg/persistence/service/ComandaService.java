package agg.persistence.service;

import agg.dao.Comanda;
import agg.interfaces.ComandaServiceInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComandaManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ComandaService implements ComandaServiceInterface {
    private final ComandaManager comandaManager;
    private MySQLConnector mySQLConnector;

    public ComandaService(ComandaManager comandaManager, MySQLConnector mySQLConnector){
        this.comandaManager = comandaManager;
        this.mySQLConnector = mySQLConnector;
    }

    public Comanda getById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaManager.getById(con, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Comanda create(int idMesa, int idCamarero, String emailContacto){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            Comanda comanda = comandaManager.create(con, idMesa, idCamarero, emailContacto);
            return comanda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comanda> getAll(){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaManager.getAll(con);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comanda> getNoPagadas(){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaManager.getNoPagadas(con);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comanda> getNoPagadasYPorIdCamarero(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaManager.getNoPagadasYPorIdCamarero(con,  id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Comanda pagar(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaManager.pagar(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
