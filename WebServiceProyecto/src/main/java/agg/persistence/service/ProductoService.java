package agg.persistence.service;

import agg.dao.Productos.Producto;
import agg.interfaces.ProductoInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ProductoManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductoService implements ProductoInterface {

    private ProductoManager productoManager;
    private MySQLConnector mySQLConnector;

    public ProductoService(ProductoManager productoManager, MySQLConnector mySQLConnector){
        this.productoManager = productoManager;
        this.mySQLConnector = mySQLConnector;
    }

    @Override
    public List<Producto> getAll(){

        try (Connection con = mySQLConnector.getMySQLConnection()) {

            return productoManager.getAll(con);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Producto getById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return productoManager.getById(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
