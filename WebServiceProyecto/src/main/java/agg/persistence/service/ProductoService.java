package agg.persistence.service;

import agg.dao.Productos.Producto;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ProductoManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductoService {

    private ProductoManager productoManager;

    public ProductoService(ProductoManager productoManager){
        this.productoManager = productoManager;
    }

    public List<Producto> getAllProducts(){

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return productoManager.getAllProductos(con);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Producto getById(int id){
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return productoManager.getProductoById(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
