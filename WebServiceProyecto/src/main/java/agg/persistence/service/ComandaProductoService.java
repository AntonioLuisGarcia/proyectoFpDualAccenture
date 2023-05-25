package agg.persistence.service;

import agg.dao.ComandaProducto;
import agg.interfaces.ComandaProductoServiceInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComandaProductoManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ComandaProductoService implements ComandaProductoServiceInterface {

    private ComandaProductoManager comandaProductoManager;
    private MySQLConnector mySQLConnector;

    public ComandaProductoService(ComandaProductoManager comandaProductoManager, MySQLConnector mySQLConnector){
        this.comandaProductoManager = comandaProductoManager;
        this.mySQLConnector = mySQLConnector;
    }

    @Override
    public List<ComandaProducto> getProductosById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaProductoManager.getProductosById(con, id);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public ComandaProducto create(int idProducto, int idComanda, int cantidad){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaProductoManager.create(con, idProducto, idComanda, cantidad);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ComandaProducto getById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaProductoManager.getById(con, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ComandaProducto updateCantidadByIdAndIdComanda(int idComanda, int idProducto, int cantidad){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaProductoManager.updateCantidadByIdAndIdComanda(con, idComanda, idProducto, cantidad);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean borrarPorId(int idComanda, int idProducto){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaProductoManager.borrarPorId(con, idComanda, idProducto);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
