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

    /**
     * Obtiene una lista de productos de comanda por su ID.
     * @param id el ID de la comanda de la cual se desean obtener los productos.
     * @return una lista de productos de comanda correspondientes al ID proporcionado.
     * @throws RuntimeException si ocurre un error al obtener los productos de comanda.
     */

    @Override
    public List<ComandaProducto> getProductosById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaProductoManager.getProductosById(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Crea un nuevo producto de comanda.
     * @param idProducto el ID del producto.
     * @param idComanda el ID de la comanda a la que se asocia el producto.
     * @param cantidad la cantidad del producto en la comanda.
     * @return el producto de comanda creado.
     * @throws RuntimeException si ocurre un error al crear el producto de comanda.
     */

    @Override
    public ComandaProducto create(int idProducto, int idComanda, int cantidad){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaProductoManager.create(con, idProducto, idComanda, cantidad);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene un producto de comanda por su ID.
     * @param id el ID del producto de comanda que se desea obtener.
     * @return el producto de comanda correspondiente al ID proporcionado.
     * @throws RuntimeException si ocurre un error al obtener el producto de comanda.
     */
    @Override
    public ComandaProducto getById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaProductoManager.getById(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Actualiza la cantidad de un producto de comanda por su ID de comanda y su ID de producto.
     * @param idComanda el ID de la comanda a la que pertenece el producto.
     * @param idProducto el ID del producto que se desea actualizar.
     * @param cantidad la nueva cantidad del producto en la comanda.
     * @return el producto de comanda actualizado.
     * @throws RuntimeException si ocurre un error al actualizar el producto de comanda.
     */

    @Override
    public ComandaProducto updateCantidadByIdAndIdComanda(int idComanda, int idProducto, int cantidad){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaProductoManager.updateCantidadByIdAndIdComanda(con, idComanda, idProducto, cantidad);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Elimina un producto de comanda por su ID de comanda y su ID de producto.
     * @param idComanda el ID de la comanda a la que pertenece el producto.
     * @param idProducto el ID del producto que se desea eliminar.
     * @return true si el producto de comanda se eliminó correctamente, false de lo contrario.
     * @throws RuntimeException si ocurre un error al eliminar el producto de comanda.
     */

    @Override
    public boolean borrarPorId(int idComanda, int idProducto){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaProductoManager.borrarPorId(con, idComanda, idProducto);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
