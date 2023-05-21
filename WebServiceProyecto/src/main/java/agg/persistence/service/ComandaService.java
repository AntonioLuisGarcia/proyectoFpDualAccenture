package agg.persistence.service;

import agg.dao.Comanda;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComandaManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ComandaService {
    private final ComandaManager comandaManager;

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

    public Comanda createComanda(int idMesa, int idCamarero, String emailContacto){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            Comanda comanda = comandaManager.createComanda(con, idMesa, idCamarero, emailContacto);
            return comanda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comanda> listAll(){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return comandaManager.listAll(con);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comanda> getNoPagadas(){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return comandaManager.getNoPagadas(con);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Comanda pagarComanda(int id){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return comandaManager.pagarComanda(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
