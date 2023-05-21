package agg.persistence.service;

import agg.dao.ComandaProducto;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComandaProductoManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ComandaProductoService {

    private ComandaProductoManager comandaProductoManager;

    public ComandaProductoService(ComandaProductoManager comandaProductoManager){
        this.comandaProductoManager = comandaProductoManager;
    }

    public List<ComandaProducto> getProductosById(int id){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return comandaProductoManager.getProductosByIdComanda(con, id);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }

    public ComandaProducto createComandaProducto(int idProducto, int idComanda, int cantidad){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return comandaProductoManager.createComandaProducto(con, idProducto, idComanda, cantidad);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ComandaProducto getById(int id){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return comandaProductoManager.getById(con, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
